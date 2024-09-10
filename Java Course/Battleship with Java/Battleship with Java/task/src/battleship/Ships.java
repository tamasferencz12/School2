package battleship;

public enum Ships {
    AIRCRAFTCARRIER("Enter the coordinates of the Aircraft Carrier (5 cells):"),
    BATTLESHIP("Enter the coordinates of the Battleship (4 cells):"),
    SUBMARINE("Enter the coordinates of the Submarine (3 cells):"),
    CRUISER("Enter the coordinates of the Cruiser (3 cells):"),
    DESTROYER("Enter the coordinates of the Destroyer (2 cells):");

    private final String name;

    Ships(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
