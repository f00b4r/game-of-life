package cz.jfx.gameoflife.gui;

import cz.jfx.gameoflife.env.Game;
import cz.jfx.gameoflife.env.entity.Cell;
import cz.jfx.gameoflife.env.entity.World;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * @author Felix
 */
public class CellFrame extends JFrame {

    private Game game;
    private Thread thread;

    /**
     * Creates new form CellFrame
     */
    public CellFrame() {
        initComponents();
        initMyComponents();
    }

    /**
     * Creates new form CellFrame
     *
     * @param game Game
     */
    public CellFrame(Game game) {
        this.game = game;
        initComponents();
        initMyComponents();
    }

    /**
     ***************************************************************************
     * GUI METHODS
     * **************************************************************************
     */
    private void initMyComponents() {
        // Set frame icon
        setIconImage(new ImageIcon(getClass().getResource("/cz/jfx/gameoflife/resources/favicon.png")).getImage());
        
        // Set GridLayout
        GridLayout layout = new java.awt.GridLayout(game.getWorld().getCols(), game.getWorld().getRows());
        layout.setVgap(2);
        layout.setHgap(2);

        world.setLayout(layout);

        // Label mouse clicked + enter
        MouseAdapter labelAction = new MouseAdapter() {

            @Override
            public void mouseEntered(final MouseEvent me) {
                if (me.getModifiers() == MouseEvent.BUTTON1_MASK) {
                    CellLabel label = (CellLabel) me.getSource();
                    Cell cell = label.getCell();
                    game.getWorld().getCell(cell.getX(), cell.getY()).setAlive();
                    label.revalidate();
                }
            }
        };

        // Fill grid
        for (int y = 0; y < game.getWorld().getRows(); y++) {
            for (int x = 0; x < game.getWorld().getCols(); x++) {
                CellLabel label = new CellLabel(game.getWorld().getCell(x, y));
                label.addMouseListener(labelAction);
                world.add(label);
            }
        }

        // Key-shortcut
        buttonsNextGeneration.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "refresh");
        buttonsNextGeneration.getActionMap().put("refresh", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttonsNextGenerationActionPerformed(e);
            }
        });

        // Pack components together
        pack();

        // Center window
        setLocationRelativeTo(null);
    }

    private void refresh() {
        for (Component c : world.getComponents()) {
            ((CellLabel) c).revalidate();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controls = new javax.swing.JPanel();
        buttonsNextGeneration = new javax.swing.JButton();
        buttonsClean = new javax.swing.JButton();
        buttonsRandom = new javax.swing.JButton();
        buttonsAutoGeneration = new javax.swing.JToggleButton();
        world = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life 2.0 (c) Milan Felix Sulc <sulcmil@gmail.com>");
        setLocationByPlatform(true);
        setName("cellframe"); // NOI18N

        controls.setBackground(java.awt.SystemColor.activeCaption);

        buttonsNextGeneration.setText("Generation");
        buttonsNextGeneration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsNextGenerationActionPerformed(evt);
            }
        });

        buttonsClean.setText("Clean");
        buttonsClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsCleanActionPerformed(evt);
            }
        });

        buttonsRandom.setText("Random");
        buttonsRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsRandomActionPerformed(evt);
            }
        });

        buttonsAutoGeneration.setText("Generation (auto)");
        buttonsAutoGeneration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsAutoGenerationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlsLayout = new javax.swing.GroupLayout(controls);
        controls.setLayout(controlsLayout);
        controlsLayout.setHorizontalGroup(
            controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonsRandom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsClean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addComponent(buttonsAutoGeneration)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsNextGeneration)
                .addContainerGap())
        );
        controlsLayout.setVerticalGroup(
            controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(buttonsClean)
                    .addComponent(buttonsRandom)
                    .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonsAutoGeneration)
                        .addComponent(buttonsNextGeneration)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(world, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(controls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(world, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonsCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsCleanActionPerformed
        game.getWorld().clean();
        refresh();
    }//GEN-LAST:event_buttonsCleanActionPerformed

    private void buttonsNextGenerationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsNextGenerationActionPerformed
        this.game.live(1);
        refresh();
    }//GEN-LAST:event_buttonsNextGenerationActionPerformed

    private void buttonsRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsRandomActionPerformed
        World w = this.game.getWorld();
        w.clean();
        Random r = new Random();

        for (int y = 0; y < w.getRows(); y++) {
            for (int x = 0; x < w.getCols(); x++) {
                if (r.nextBoolean()) {
                    w.getCell(x, y).setAlive();
                }
            }
        }
        refresh();
    }//GEN-LAST:event_buttonsRandomActionPerformed

    private void buttonsAutoGenerationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsAutoGenerationActionPerformed
        if (this.thread != null) {
            this.thread.stop();
            this.thread = null;
            this.buttonsAutoGeneration.setSelected(false);
            this.buttonsAutoGeneration.setText("Generation (auto)");
            return;
        }

        this.buttonsAutoGeneration.setSelected(true);
        this.buttonsAutoGeneration.setText("Generation (running)");
        this.thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) {
                        game.live(1);
                        refresh();
                        Thread.sleep(100);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(CellFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.thread.start();
    }//GEN-LAST:event_buttonsAutoGenerationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton buttonsAutoGeneration;
    private javax.swing.JButton buttonsClean;
    private javax.swing.JButton buttonsNextGeneration;
    private javax.swing.JButton buttonsRandom;
    private javax.swing.JPanel controls;
    private javax.swing.JPanel world;
    // End of variables declaration//GEN-END:variables
}
