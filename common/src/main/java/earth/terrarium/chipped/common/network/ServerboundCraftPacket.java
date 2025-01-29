package earth.terrarium.chipped.common.network;

import com.teamresourceful.bytecodecs.base.ByteCodec;
import com.teamresourceful.bytecodecs.base.object.ObjectByteCodec;
import com.teamresourceful.resourcefullib.common.bytecodecs.ExtraByteCodecs;
import com.teamresourceful.resourcefullib.common.network.Packet;
import com.teamresourceful.resourcefullib.common.network.base.PacketType;
import com.teamresourceful.resourcefullib.common.network.base.ServerboundPacketType;
import com.teamresourceful.resourcefullib.common.network.defaults.CodecPacketType;
import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

public record ServerboundCraftPacket(
    ItemStack stack, boolean replaceAll
) implements Packet<ServerboundCraftPacket> {

    public static final ServerboundPacketType<ServerboundCraftPacket> TYPE = new Type();

    @Override
    public PacketType<ServerboundCraftPacket> type() {
        return TYPE;
    }

    private static class Type extends CodecPacketType<ServerboundCraftPacket> implements ServerboundPacketType<ServerboundCraftPacket> {

        public Type() {
            super(
                ResourceLocation.fromNamespaceAndPath(Chipped.MOD_ID, "craft"),
                ObjectByteCodec.create(
                    ExtraByteCodecs.ITEM_STACK.fieldOf(ServerboundCraftPacket::stack),
                    ByteCodec.BOOLEAN.fieldOf(ServerboundCraftPacket::replaceAll),
                    ServerboundCraftPacket::new
                )
            );
        }

        @Override
        public Consumer<Player> handle(ServerboundCraftPacket message) {
            return player -> {
                if (player.containerMenu instanceof WorkbenchMenu menu) {
                    menu.craft(message.stack, message.replaceAll);
                    player.containerMenu.broadcastChanges();
                }
            };
        }
    }
}
