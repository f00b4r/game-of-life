package cz.jfx.gameoflife;

import cz.jfx.gameoflife.env.Game;
import cz.jfx.gameoflife.env.criteria.S23B3Limit;
import cz.jfx.gameoflife.env.generator.oscillators.Wing;
import cz.jfx.gameoflife.env.generator.stilllife.Beenhive;
import cz.jfx.gameoflife.env.generator.stilllife.Block;
import cz.jfx.gameoflife.env.renderer.ConsoleRendererListener;
import cz.jfx.gameoflife.env.renderer.Renderer;
import java.util.Scanner;

/**
 * @author Felix
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Game of Life [v=" + Game.VERSION + "]");
        System.out.println("Developed by: Milan Felix Sulc <sulcmil@gmail.com>");
        System.out.println();

        System.out.println("Settings:");
        System.out.print("World [WxH]: ");
        String[] d = sc.next().split("[x|,|-]");

        Game g = new Game();
        g.create(Integer.parseInt(d[0]), Integer.parseInt(d[1]));
        g.setLimiter(S23B3Limit.create());

        System.out.print("Renderer [cells/neighs]: ");
        String renderer = sc.next();
        if (renderer.equals("neighs")) {
            g.registerListener(new ConsoleRendererListener(-1, true, Renderer.MODE_NEIGHS));
        } else {
            g.registerListener(new ConsoleRendererListener(-1, true));
        }

        System.out.print("Generator [wing/beenhive/block/none]: ");
        String generator = sc.next();

        if (generator.equals("wing")) {
            g.setGenerator(new Wing());
        } else if (generator.equals("beenhive")) {
            g.setGenerator(new Beenhive());
        } else if (generator.equals("block")) {
            g.setGenerator(new Block());
        } else {
            while (true) {
                System.out.print("Place cell [x,y] [q = end]: ");
                String s = sc.next();
                if (s.contains("q")) {
                    break;
                } else {
                    String[] cd = s.split("[x|,|-]");
                    g.getWorld().getCell(Integer.parseInt(cd[0]), Integer.parseInt(cd[1])).setAlive();
                }
                System.out.println();
            }
        }

        while (true) {
            System.out.print("Generation [n] [-1 = end]: ");
            int gen = sc.nextInt();

            if (gen < 0) {
                break;
            }
            g.live(gen);
        }

    }

}
