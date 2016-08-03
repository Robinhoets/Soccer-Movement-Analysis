

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

class ColorPanel extends JPanel {

    private BufferedImage bimg;
    private Dimension dims;

    public ColorPanel(BufferedImage image) {
        bimg = image;
        dims = new Dimension(bimg.getWidth(), bimg.getHeight());
    }


}