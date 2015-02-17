package cz.jfx.gameoflife.env.renderer;

import cz.jfx.gameoflife.env.GameListener;
import cz.jfx.gameoflife.env.entity.World;

/**
 * @author Felix
 */
public class ConsoleRendererListener implements GameListener {

    // Vars
    private int step;
    private boolean progress;
    private int type;
    private Renderer renderer;

    public ConsoleRendererListener() {
        this.step = -1;
        this.progress = true;
        this.renderer = new ConsoleRenderer();
        this.type = Renderer.MODE_NORMAL;
    }

    public ConsoleRendererListener(int step) {
        this();
        this.step = step;
    }

    public ConsoleRendererListener(int step, Renderer renderer) {
        this();
        this.step = step;
        this.renderer = renderer;
    }

    public ConsoleRendererListener(int step, boolean progress) {
        this();
        this.step = step;
        this.progress = progress;
    }

    public ConsoleRendererListener(int step, boolean progress, int type) {
        this();
        this.step = step;
        this.progress = progress;
        this.type = type;
    }

    public ConsoleRendererListener(int step, boolean progress, int type, Renderer renderer) {
        this();
        this.step = step;
        this.progress = progress;
        this.type = type;
        this.renderer = renderer;
    }

    @Override
    public void onBeforeGeneration(World world, int generation) {
        if (!progress) {
            System.out.println("Before GENERATION");
            render(world);
        }
    }

    @Override
    public void onGeneration(World world, int generation, int step) {
        if (progress) {
            if (this.step == -1) {
                render(world);
            } else if (step > 0 && ((step % this.step) == 0)) {
                System.out.println("Each " + this.step + " step");
                render(world);
            } else {
                // Nothing..
            }
        }
    }

    @Override
    public void onAfterGeneration(World world) {
        if (!progress) {
            System.out.println("After GENERATION");
            render(world);
        }
    }

    // =========================================================================
    // HELPERS =================================================================
    // =========================================================================
    private void render(World world) {
        if (type == Renderer.MODE_NEIGHS) {
            renderer.renderNeighs(world);
        } else {
            renderer.render(world);
        }
    }

}
