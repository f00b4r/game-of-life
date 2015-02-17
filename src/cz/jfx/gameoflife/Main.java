package cz.jfx.gameoflife;

import cz.jfx.gameoflife.env.entity.World;
import cz.jfx.gameoflife.env.Game;
import cz.jfx.gameoflife.env.GameListener;
import cz.jfx.gameoflife.env.criteria.S23B3Limit;
import cz.jfx.gameoflife.env.generator.oscillators.Wing;
import cz.jfx.gameoflife.env.renderer.ConsoleRenderer;
import cz.jfx.gameoflife.env.renderer.Renderer;

/**
 * @author Felix
 */
public class Main {

    public static void main(String[] args) {
        Game g = new Game();
        g.create(15);
        g.setGenerator(new Wing());
        g.setLimiter(S23B3Limit.create());
        g.registerListener(new GameListener() {

            @Override
            public void onBeforeGeneration(World world, int g) {
            }

            @Override
            public void onGeneration(World world, int q, int i) {
                Renderer r = new ConsoleRenderer();
                r.render(world);
            }

            @Override
            public void onAfterGeneration(World world) {
            }
        });

        World w = g.getWorld();
        g.live(10);
    }

}
