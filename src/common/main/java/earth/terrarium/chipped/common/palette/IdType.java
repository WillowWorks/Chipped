package earth.terrarium.chipped.common.palette;

import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.ints.IntObjectPair;

import java.util.List;
import java.util.Locale;

public enum IdType {
    NONE(""),
    DIRECTIONAL(""),
    PILLAR(""),
    LIMITED_PILLAR(""),
    PANE_PILLAR(""),
    GIANT(""),
    CTM("ctm"),
    PANE_CTM("ctm"),
    CARPET_CTM("ctm");

    private final String suffix;

    IdType(String suffix) {
        this.suffix = suffix;
    }

    public String suffix() {
        return suffix;
    }

    public String id() {
        return name().toLowerCase(Locale.ROOT);
    }

    public List<IntObjectPair<String>> getTextureIds() {
        return switch (this) {
            case PILLAR, LIMITED_PILLAR, PANE_PILLAR -> List.of(
                IntObjectPair.of(0, "self"),
                IntObjectPair.of(1, "top"),
                IntObjectPair.of(2, "center"),
                IntObjectPair.of(3, "bottom")
            );
            case CTM, CARPET_CTM, PANE_CTM -> List.of(
                IntObjectPair.of(0, "empty"),
                IntObjectPair.of(1, "vertical"),
                IntObjectPair.of(2, "horizontal"),
                IntObjectPair.of(3, "center")
            );
            case GIANT -> List.of(
                IntObjectPair.of(0, "1"),
                IntObjectPair.of(1, "2"),
                IntObjectPair.of(2, "3"),
                IntObjectPair.of(3, "4")
            );
            default -> List.of();
        };
    }

    public void addTextureInfo(JsonObject json) {
        if (this == GIANT) {
            json.addProperty("width", 2);
            json.addProperty("height", 2);
        }
    }

    public boolean isSpecial() {
        return this != NONE && this != DIRECTIONAL;
    }
}
