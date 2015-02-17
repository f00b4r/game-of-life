package cz.jfx.gameoflife.env.entity;

/**
 * @author Felix
 */
public class Cell {

    // Vars
    private final Coordinate cords;
    private CellState state;
    private CellState nextState;

    public Cell(int x, int y) {
        this.cords = new Coordinate(x, y);
        this.state = CellState.DEAD;
        this.nextState = CellState.DEAD;
    }

    // =========================================================================
    // GETTERS/SETTERS =========================================================
    // =========================================================================
    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public void setAlive() {
        this.state = CellState.ALIVE;
    }

    public boolean isAlive() {
        return state == CellState.ALIVE;
    }

    public void setDead() {
        this.state = CellState.DEAD;
    }

    public boolean isDead() {
        return state == CellState.DEAD;
    }

    public void setNextState(CellState nextState) {
        this.nextState = nextState;
    }

    public CellState getNextState() {
        return nextState;
    }

    public int getX() {
        return cords.getX();
    }

    public int getY() {
        return cords.getY();
    }

    // =========================================================================
    // HOOKS ===================================================================
    // =========================================================================
    public void doLive() {
        this.state = this.nextState;
        this.nextState = CellState.DEAD;
    }

    @Override
    public String toString() {
        return "Cell{" + "cords=" + cords + ", state=" + state + ", nextState=" + nextState + '}';
    }

}
