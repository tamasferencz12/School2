package _11gyak.action.user;

import _11gyak.action.*;
import java.util.Objects;

public class MultiDimensionPoint implements Scalable, Comparable<MultiDimensionalPoint> {

    @Override // object osztajbol + EQUALITY_CHECK
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other instanceof MultiDimensionalPoint mdp) {
            // TODO: mdp.coordinates <-> this.coordinates
        }

        return false;

    }

    @Override // object osztajbol + EQUALITY_CHECK
    public int hasCode() {
        return Object.hash(coordinates);
    }

    @Override
    public int CompareTo(MultiDomensionPoint mdp) {
        // return 1, 0 , -1;
    }

    private int[] cordinates;

    private int[] lastCoordinates;

    public MultiDimensionPoint(int... coordinates) {
        this.coordinates = new int[coordinates.length];

        System.arraycopy(coordinates, 0, this.coordinates, 0, coordinates.length);
    }

}
