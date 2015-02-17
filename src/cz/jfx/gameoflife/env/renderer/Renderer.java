package cz.jfx.gameoflife.env.renderer;

import cz.jfx.gameoflife.env.entity.World;

/**
 * @author Felix
 */
public interface Renderer {

    public static final int MODE_NORMAL = 1;
    public static final int MODE_NEIGHS = 2;

    void render(World world);

    void renderNeighs(World world);
}
