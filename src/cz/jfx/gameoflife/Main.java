package cz.jfx.gameoflife;

import java.util.Arrays;

/**
 * @author Felix
 */
public class Main {

    public static void main(String[] args) {
        if (Arrays.asList(args).contains("--cli")) {
            MainCli.main(args);
        } else {
            MainGui.main(args);
        }
    }
}
