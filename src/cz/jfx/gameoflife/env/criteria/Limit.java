package cz.jfx.gameoflife.env.criteria;

/**
 * @author Felix
 */
public class Limit implements Limiter{

    private final int[] revive;
    private final int[] survive;

    public Limit(int[] survive, int[] revive) {
        this.survive = survive;
        this.revive = revive;
    }

    // =========================================================================
    // GETTERS =================================================================
    // =========================================================================
    public int[] getRevive() {
        return revive;
    }

    public int[] getSurvive() {
        return survive;
    }

    // =========================================================================
    // API =====================================================================
    // =========================================================================
    public boolean survive(int neighs) {
        for (int n : survive) {
            if (n == neighs) {
                return true;
            }
        }

        return false;
    }

    public boolean revive(int neighs) {
        for (int n : revive) {
            if (n == neighs) {
                return true;
            }
        }

        return false;
    }

}
