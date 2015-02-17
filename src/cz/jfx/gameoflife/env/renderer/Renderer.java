package cz.jfx.gameoflife.env.renderer;

import cz.jfx.gameoflife.env.entity.World;

/**
 * @author Felix
 */
public interface Renderer {

    void render(World world);

    void renderNeighs(World world);
}
