package cz.jfx.gameoflife.env.generator.stilllife;

import cz.jfx.gameoflife.env.entity.CellState;
import cz.jfx.gameoflife.env.entity.World;
import cz.jfx.gameoflife.env.generator.Generator;

/**
 * @author Felix
 */
public class Block implements Generator {

    @Override
    public void generate(World world) {
        world.getCell(1, 3).setState(CellState.ALIVE);
        world.getCell(1, 4).setState(CellState.ALIVE);
        world.getCell(2, 3).setState(CellState.ALIVE);
        world.getCell(2, 4).setState(CellState.ALIVE);
    }

}
