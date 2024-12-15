import javax.swing.*;
import java.awt.*;


public class CloseButton extends JButton {

    ImageIcon closeJPG = new ImageIcon("src\\assets\\CloseButton.png");
    Image img = closeJPG.getImage();
    Image imgScale = img.getScaledInstance(20,20, 100);
    ImageIcon scaledClose = new ImageIcon(imgScale);

    public CloseButton() {
        this.setOpaque(false);
        this.setContentAreaFilled(false);
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
