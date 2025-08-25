enum Facing {
    NORTH, EAST, SOUTH, WEST;

    public Facing left() {
        return values()[(this.ordinal() + 3) % 4]; // Turn left 90
    }

    public Facing right() {
        return values()[(this.ordinal() + 1) % 4]; // Turn right 90
    }
}
