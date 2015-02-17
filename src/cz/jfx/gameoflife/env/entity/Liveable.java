package cz.jfx.gameoflife.env.entity;

/**
 * @author Felix
 */
public interface Liveable {

    void live();

    int neighs(int x, int y);
}
