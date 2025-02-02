package earth.terrarium.chipped.common.palette;

import com.mojang.datafixers.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

public interface Palette extends Iterable<String> {

    List<Pair<IdType, String>> ids();

    default String get(int index) {
        return ids().get(index).getSecond();
    }

    @NotNull
    @Override
    default Iterator<String> iterator() {
        return ids().stream().map(Pair::getSecond).iterator();
    }

    default List<Pair<IdType, String>> getSpecial() {
        return ids().stream().filter(pair -> pair.getFirst().isSpecial()).toList();
    }

}
