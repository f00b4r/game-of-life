package cz.jfx.gameoflife.env;

import cz.jfx.gameoflife.env.entity.World;

/**
 * @author Felix
 */
public interface GameListener {

    public void onBeforeGeneration(World world, int generation);

    public void onGeneration(World world, int generation, int step);

    public void onAfterGeneration(World world);
}
