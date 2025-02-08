package earth.terrarium.chipped.datagen.provider.server;

import com.google.common.hash.HashCode;
import com.google.gson.JsonElement;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.resourcefullib.common.lib.Constants;
import earth.terrarium.chipped.datagen.provider.MinifiedProvider;
import net.minecraft.data.CachedOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagFile;
import net.minecraft.util.ExtraCodecs;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class MinifiedTagOutput extends MinifiedProvider.MinifiedOutput {

    private static final Codec<ExtraCodecs.TagOrElementLocation> TAG_OR_ELEMENT_ID = Codec.STRING.comapFlatMap(
        (string) -> string.startsWith("#") ?
            ResourceLocation.read(string.substring(1)).map((arg) -> new ExtraCodecs.TagOrElementLocation(arg, true)) :
            ResourceLocation.read(string).map((arg) -> new ExtraCodecs.TagOrElementLocation(arg, false)),
        element -> element.tag() ? "#" + toMinifiedString(element.id()) : toMinifiedString(element.id())
    );

    private static final Codec<TagEntry> FULL_CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            TAG_OR_ELEMENT_ID.fieldOf("id").forGetter(arg -> new ExtraCodecs.TagOrElementLocation(arg.getId(), arg.isTag())),
            Codec.BOOL.optionalFieldOf("required", true).forGetter(TagEntry::isRequired))
        .apply(instance, (element, required) -> {
            if (required) {
                return element.tag() ? TagEntry.tag(element.id()) : TagEntry.element(element.id());
            }
            return element.tag() ? TagEntry.optionalTag(element.id()) : TagEntry.optionalElement(element.id());
        }));

    private static final Codec<TagEntry> ENTRY_CODEC = Codec.either(TAG_OR_ELEMENT_ID, FULL_CODEC).xmap((either) ->
            either.map(
                (arg) -> arg.tag() ? TagEntry.tag(arg.id()) : TagEntry.element(arg.id()),
                (arg) -> arg
            )
        , (arg) -> arg.isRequired() ? Either.left(new ExtraCodecs.TagOrElementLocation(arg.getId(), arg.isTag())) : Either.right(arg));

    private static final Codec<TagFile> BETTER_CODEC = RecordCodecBuilder.create((instance) -> instance.group(
        ENTRY_CODEC.listOf().fieldOf("values").forGetter(TagFile::entries),
        Codec.BOOL.optionalFieldOf("replace", false).forGetter(TagFile::replace)
    ).apply(instance, TagFile::new));

    public MinifiedTagOutput(CachedOutput parent) {
        super(parent);
    }

    @Override
    public void writeIfNeeded(@NotNull Path path, byte @NotNull [] data, @NotNull HashCode hashCode) throws IOException {
        if (path.toString().endsWith(".json")) {
            JsonElement element = Constants.GSON.fromJson(new String(data, StandardCharsets.UTF_8), JsonElement.class);
            TagFile file = TagFile.CODEC.parse(JsonOps.INSTANCE, element).getOrThrow();
            element = BETTER_CODEC.encodeStart(JsonOps.INSTANCE, file).getOrThrow();
            writeMinifiedJson(this.parent, path, element);
        } else {
            this.parent.writeIfNeeded(path, data, hashCode);
        }
    }

    private static String toMinifiedString(ResourceLocation id) {
        String namespace = id.getNamespace();
        String path = id.getPath();
        if (namespace.equals("minecraft")) {
            return path;
        }
        return namespace + ":" + path;
    }
}
