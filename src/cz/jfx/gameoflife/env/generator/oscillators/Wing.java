package cz.jfx.gameoflife.env.generator.oscillators;

import cz.jfx.gameoflife.env.entity.CellState;
import cz.jfx.gameoflife.env.entity.World;
import cz.jfx.gameoflife.env.generator.Generator;

/**
 *
 * @author Felix
 */
public class Wing implements Generator {

    @Override
    public void generate(World world) {
        world.getCell(3, 1).setState(CellState.ALIVE);
        world.getCell(3, 2).setState(CellState.ALIVE);
        world.getCell(3, 3).setState(CellState.ALIVE);
        world.getCell(1, 2).setState(CellState.ALIVE);
        world.getCell(2, 3).setState(CellState.ALIVE);
    }

}
