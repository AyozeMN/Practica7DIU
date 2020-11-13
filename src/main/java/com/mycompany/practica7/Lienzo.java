package com.mycompany.practica7;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;

/**
 *
 * @author Ayoze, Nicolás
 */
public class Lienzo extends JPanel {
    protected Mat img;
    protected BufferedImage imgBI = null;
    
    @Override
    public void paintComponent(Graphics g) {
        if (imgBI != null) {
            this.setPreferredSize(new Dimension(imgBI.getWidth(), imgBI.getHeight()));
        }
        super.paintComponent(g);
        g.drawImage(imgBI, 0, 0, null);
        repaint();
    }
    
    public void setMat(Mat imagenRead) {
        if (imagenRead != null) {
            img = imagenRead;
            imgBI = (BufferedImage) HighGui.toBufferedImage(imagenRead);
        } else {
            img = null;
            imgBI = null;
        }
        
        this.repaint();
    }
}
