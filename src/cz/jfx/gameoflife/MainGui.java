package cz.jfx.gameoflife;

import cz.jfx.gameoflife.env.Game;
import cz.jfx.gameoflife.env.criteria.S23B3Limit;
import cz.jfx.gameoflife.gui.CellFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Felix
 */
public class MainGui {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(CellFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                Game g = new Game();
                g.create(50, 50);
                g.setLimiter(S23B3Limit.create());

                CellFrame frame = new CellFrame(g);
                frame.setVisible(true);
            }
        });
    }

}
