class Robot {
    private int x, y;
    private Facing facing;
    private boolean placed = false;
    private final int TABLE_SIZE = 5;

    public void place(int x, int y, Facing facing) {
        if (isValidPosition(x, y)) {
            this.x = x;
            this.y = y;
            this.facing = facing;
            this.placed = true;
        }
    }

    public void move() {
        if (!placed) return;
        int newX = x, newY = y;
        switch (facing) {
            case NORTH -> newY++;
            case SOUTH -> newY--;
            case EAST  -> newX++;
            case WEST  -> newX--;
        }
        if (isValidPosition(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public void left() {
        if (placed) facing = facing.left();
    }

    public void right() {
        if (placed) facing = facing.right();
    }

    public void report() {
        if (placed) {
            System.out.println("Output: " + x + "," + y + "," + facing);
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < TABLE_SIZE && y >= 0 && y < TABLE_SIZE;
    }
}