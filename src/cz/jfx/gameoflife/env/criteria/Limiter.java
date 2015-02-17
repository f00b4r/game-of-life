package cz.jfx.gameoflife.env.criteria;

/**
 * @author Felix
 */
public interface Limiter {

    boolean survive(int neighs);

    boolean revive(int neighs);
}
