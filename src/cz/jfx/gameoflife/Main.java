package cz.jfx.gameoflife;

import cz.jfx.gameoflife.env.entity.World;
import cz.jfx.gameoflife.env.Game;
import cz.jfx.gameoflife.env.criteria.S23B3Limit;
import cz.jfx.gameoflife.env.generator.oscillators.Wing;
import cz.jfx.gameoflife.env.renderer.ConsoleRendererListener;

/**
 * @author Felix
 */
public class Main {

    public static void main(String[] args) {

        Game g = new Game();
        g.create(6);
        g.setGenerator(new Wing());
        g.setLimiter(S23B3Limit.create());
        g.registerListener(new ConsoleRendererListener());

        World w = g.getWorld();
        g.live(8);
    }

}
