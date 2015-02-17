package cz.jfx.gameoflife.env.renderer;

import cz.jfx.gameoflife.env.entity.Cell;
import cz.jfx.gameoflife.env.entity.World;

/**
 * @author Felix
 */
public class ConsoleRenderer implements Renderer {

    public void render(World world) {
        System.out.println("Generation: " + world.getGeneration());
        for (int y = 0; y < world.getRows(); y++) {
            for (int x = 0; x < world.getCols(); x++) {
                Cell c = world.getCell(x, y);
                System.out.print(c.isAlive() ? " X " : " . ");
            }
            System.out.println();
        }
        System.out.println("");
    }

    public void renderNeighs(World world) {
        System.out.println("Generation: " + world.getGeneration());
        for (int y = 0; y < world.getRows(); y++) {
            for (int x = 0; x < world.getCols(); x++) {
                Cell c = world.getCell(x, y);
                int n = world.neighs(x, y);
                System.out.print(c.isAlive() ? "[" + n + "]" : " " + n + " ");
            }
            System.out.println();
        }
        System.out.println("");
    }

}
