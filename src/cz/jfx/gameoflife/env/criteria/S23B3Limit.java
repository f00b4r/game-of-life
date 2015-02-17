package cz.jfx.gameoflife.env.criteria;

/**
 * @author Felix
 */
public class S23B3Limit {

    public static Limit create() {
        return new Limit(
                new int[]{2, 3},
                new int[]{3}
        );
    }

}
