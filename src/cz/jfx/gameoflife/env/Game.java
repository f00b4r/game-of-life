package cz.jfx.gameoflife.env;

import cz.jfx.gameoflife.env.criteria.Limit;
import cz.jfx.gameoflife.env.entity.World;
import cz.jfx.gameoflife.env.generator.Generator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Felix
 */
public class Game{
    
    // Constants
    public static final String VERSION = "2.0";
    
    // Vars
    private World world;

    // Listeners
    private final List<GameListener> listeners;

    public Game() {
        this.listeners = new ArrayList<>();
    }

    // =========================================================================
    // GETTERS =================================================================
    // =========================================================================
    public World getWorld() {
        return world;
    }

    // =========================================================================
    // PUBLIC API ==============================================================
    // =========================================================================
    public void create(int rows, int cols) {
        world = new World(rows, cols);
    }

    public void create(int size) {
        create(size, size);
    }

    public void setLimiter(Limit limit) {
        world.setLimiter(limit);
    }

    public void setGenerator(Generator generator) {
        generator.generate(world);
    }

    public void live(int g) {
        for (GameListener l : listeners) {
            l.onBeforeGeneration(world, g);
        }

        for (int i = 0; i < g; i++) {
            for (GameListener l : listeners) {
                l.onGeneration(world, g, i + 1);
            }

            world.live();
        }

        for (GameListener l : listeners) {
            l.onAfterGeneration(world);
        }
    }

    // =========================================================================
    // LISTENERS ===============================================================
    // =========================================================================
    public void registerListener(GameListener listener) {
        listeners.add(listener);
    }

}
