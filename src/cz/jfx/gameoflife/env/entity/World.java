package cz.jfx.gameoflife.env.entity;

import cz.jfx.gameoflife.env.criteria.Limiter;

/**
 * @author Felix
 */
public class World implements Liveable {

    // Vars
    private Cell[][] cells;
    private Limiter limiter;
    private int rows;
    private int cols;
    private float generation;

    public World() {
        this.generation = 0;
    }

    public World(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
        generate();
    }

    public World(int size) {
        this(size, size);
    }
    // =========================================================================
    // GETTERS/SETTERS =========================================================
    // =========================================================================

    public Cell[][] getCells() {
        return cells;
    }

    public Cell[] getCellsRow(int y) {
        if (y > (cells.length - 1) || y < 0) {
            return null;
        }
        return cells[y];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell getCell(int x, int y) {
        if ((y > (cells.length - 1) || y < 0) || (x > (cells[0].length - 1) || x < 0)) {
            return null;
        }
        return cells[y][x];
    }

    public void setCell(int x, int y, Cell c) {
        cells[x][y] = c;
    }

    public Coordinate getCenter() {
        return new Coordinate(rows / 2, rows / 2);
    }

    public float getGeneration() {
        return generation;
    }

    public void setLimiter(Limiter limiter) {
        this.limiter = limiter;
    }

    public Limiter getLimiter() {
        return limiter;
    }

    // =========================================================================
    // HELPERS =================================================================
    // =========================================================================
    protected final void generate() {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                cells[y][x] = new Cell(x, y);
            }
        }
    }

    public void resize(int rows, int cols) {
        Cell[][] cells = new Cell[rows][cols];

        for (int y = 0; y < Math.max(this.rows, rows); y++) {
            if (y > (this.rows - 1)) {
                continue;
            }
            for (int x = 0; x < Math.max(this.cols, cols); x++) {
                if (x > (this.cols - 1)) {
                    continue;
                }

                cells[y][x] = this.cells[y][x];
            }
        }

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (cells[y][x] == null) {
                    cells[y][x] = new Cell(x, y);
                }
            }
        }

        this.cells = cells;
        this.rows = rows;
        this.cols = cols;
    }

    public void resize(int size) {
        resize(size, size);
    }

    // =========================================================================
    // PUBLIC API ==============================================================
    // =========================================================================
    public void live() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                int n = neighs(cell.getX(), cell.getY());

                if (cell.isAlive()) {
                    if (limiter.survive(n)) {
                        cell.setNextState(CellState.ALIVE);
                    } else {
                        cell.setNextState(CellState.DEAD);
                    }
                } else if (cell.isDead()) {
                    if (limiter.revive(n)) {
                        cell.setNextState(CellState.ALIVE);
                    }
                }
            }
        }

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.doLive();
            }
        }

        generation++;
    }

    public int neighs(int x, int y) {
        int n = 0;
        Cell c;
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (dy == 0 && dx == 0) {
                    continue;
                }
                if ((c = getCell(x + dx, y + dy)) != null && c.isAlive()) {
                    n++;
                }
            }
        }

        return n;
    }
}
