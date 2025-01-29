package earth.terrarium.chipped.datagen.provider;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonWriter;
import com.teamresourceful.resourcefullib.common.lib.Constants;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public record MinifiedProvider(DataProvider provider) implements DataProvider {

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput output) {
        MinifiedOutput minifiedOutput = new MinifiedOutput(output);
        return provider.run(minifiedOutput);
    }

    @Override
    public @NotNull String getName() {
        return provider.getName();
    }

    public static class MinifiedOutput implements CachedOutput {

        protected final CachedOutput parent;

        public MinifiedOutput(CachedOutput parent) {
            this.parent = parent;
        }

        @Override
        public void writeIfNeeded(@NotNull Path path, byte @NotNull [] data, @NotNull HashCode hashCode) throws IOException {
            if (path.toString().endsWith(".json")) {
                JsonElement element = Constants.GSON.fromJson(new String(data, StandardCharsets.UTF_8), JsonElement.class);
                writeMinifiedJson(this.parent, path, element);
            } else {
                this.parent.writeIfNeeded(path, data, hashCode);
            }
        }

        protected static void writeMinifiedJson(CachedOutput output, Path path, JsonElement element) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                HashingOutputStream hashingOutputStream = new HashingOutputStream(Hashing.sha1(), byteArrayOutputStream);

                try (JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(hashingOutputStream, StandardCharsets.UTF_8))) {
                    jsonWriter.setSerializeNulls(false);
                    GsonHelper.writeValue(jsonWriter, element, DataProvider.KEY_COMPARATOR);
                }
                output.writeIfNeeded(path, byteArrayOutputStream.toByteArray(), hashingOutputStream.hash());
            } catch (IOException var10) {
                DataProvider.LOGGER.error("Failed to save file to {}", path, var10);
            }
        }
    }
}
