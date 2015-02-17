package cz.jfx.gameoflife.env;

import cz.jfx.gameoflife.env.entity.World;

/**
 * @author Felix
 */
public interface GameListener {

    public void onBeforeGeneration(World world, int g);

    public void onGeneration(World world, int q, int i);

    public void onAfterGeneration(World world);
}
