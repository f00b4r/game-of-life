package cz.jfx.gameoflife.env.entity;

/**
 * @author Felix
 */
public class Coordinate {

    // Vars
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // =========================================================================
    // GETTERS =================================================================
    // =========================================================================
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinate{" + "x=" + x + ", y=" + y + '}';
    }

}
