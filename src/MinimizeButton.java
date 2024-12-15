import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class MinimizeButton extends JButton {

    ImageIcon closeJPG = new ImageIcon("src\\assets\\MinimizeButton.png");
    Image img = closeJPG.getImage();
    Image imgScale = img.getScaledInstance(20,20, 100);
    ImageIcon scaledClose = new ImageIcon(imgScale);

    public MinimizeButton() {
        this.setOpaque(true);
        this.setContentAreaFilled(true);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setBackground(null);
        this.setForeground(null);
        this.setBorderPainted(false);
        this.setRequestFocusEnabled(false);
        this.setIcon(scaledClose);
        this.setEnabled(false);
    }
}
