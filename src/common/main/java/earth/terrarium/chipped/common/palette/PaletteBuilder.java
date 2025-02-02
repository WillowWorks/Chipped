package earth.terrarium.chipped.common.palette;

import com.mojang.datafixers.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.UnaryOperator;

public class PaletteBuilder {

    private final List<Pair<IdType, String>> ids = new ArrayList<>();

    public PaletteBuilder() {
    }

    public static PaletteBuilder create() {
        return new PaletteBuilder();
    }

    public PaletteBuilder(Palette palette, String... removals) {
        this.ids.addAll(palette.ids());
        final var set = new HashSet<>(List.of(removals));
        this.ids.removeIf(pair -> set.contains(pair.getSecond()));
    }

    public PaletteBuilder(Palette palette, UnaryOperator<IdType> swap, String... removals) {
        final var set = new HashSet<>(List.of(removals));
        for (var entry : palette.ids()) {
            if (set.contains(entry.getSecond())) continue;
            this.ids.add(Pair.of(swap.apply(entry.getFirst()), entry.getSecond()));
        }
    }

    public static PaletteBuilder create(Palette palette, String... removals) {
        return new PaletteBuilder(palette, removals);
    }

    public static PaletteBuilder create(Palette palette, UnaryOperator<IdType> swap, String... removals) {
        return new PaletteBuilder(palette, swap, removals);
    }

    public PaletteBuilder add(IdType type, String... ids) {
        for (String id : ids) {
            this.ids.add(Pair.of(type, id));
        }
        return this;
    }

    public PaletteBuilder add(String... ids) {
        add(IdType.NONE, ids);
        return this;
    }

    public PaletteBuilder directional(String... ids) {
        add(IdType.DIRECTIONAL, ids);
        return this;
    }

    public PaletteBuilder limitedPillar(String... ids) {
        add(IdType.LIMITED_PILLAR, ids);
        return this;
    }

    public PaletteBuilder pillar(String... ids) {
        add(IdType.PILLAR, ids);
        return this;
    }

    public PaletteBuilder ctm(String... ids) {
        add(IdType.CTM, ids);
        return this;
    }

    public PaletteBuilder giant(String... ids) {
        add(IdType.GIANT, ids);
        return this;
    }

    public Palette build() {
        final List<Pair<IdType, String>> ids = List.copyOf(this.ids);
        return () -> ids;
    }
}
