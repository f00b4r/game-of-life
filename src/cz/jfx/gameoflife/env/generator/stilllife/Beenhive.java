package cz.jfx.gameoflife.env.generator.stilllife;

import cz.jfx.gameoflife.env.entity.World;
import cz.jfx.gameoflife.env.generator.Generator;

/**
 *
 * @author Felix
 */
public class Beenhive implements Generator {

    @Override
    public void generate(World world) {
        world.getCell(2, 3).setAlive();
        world.getCell(3, 2).setAlive();
        world.getCell(4, 2).setAlive();
        world.getCell(5, 3).setAlive();
        world.getCell(3, 4).setAlive();
        world.getCell(4, 4).setAlive();
    }

}
