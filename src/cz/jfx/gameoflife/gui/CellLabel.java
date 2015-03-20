package cz.jfx.gameoflife.gui;

import cz.jfx.gameoflife.env.entity.Cell;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 * @author Felix
 */
public class CellLabel extends JLabel {

    private Cell cell;

    public CellLabel(Cell cell) {
        this.cell = cell;
        this.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        this.setBackground(cell.isAlive() ? Color.BLACK : null);
        this.setOpaque(true);

        Dimension d = new Dimension(8, 12);
        this.setPreferredSize(d);
        this.setMinimumSize(d);
    }

    public Cell getCell() {
        return cell;
    }

    @Override
    public void revalidate() {
        super.revalidate();
        if (cell != null) {
            this.setBackground(cell.isAlive() ? Color.BLACK : null);
        }
    }

}
