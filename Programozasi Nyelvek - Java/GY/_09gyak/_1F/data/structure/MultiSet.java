package _09gyak._1F.data.structure;

import java.util.HashMap;

public class MultiSet<E> {

    private HashMap<E, Integer> elemToCount = new HashMap<>();;

    public MultiSet(E[] initialElements) {
        for (E elem : initialElements) {
            add(elem);
        }
    }

    public MultiSet<E> add(E x) {
        elemToCount.put(x, elemToCount);

        return elemToCount;
    }

    public int getCount(E x) {
        return 0;
    }

    public MultiSet<E> intersect(MultiSet<E>) {

    }

    public int size() {
        return 0;
    }

}
