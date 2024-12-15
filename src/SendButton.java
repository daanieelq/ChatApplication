import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SendButton extends JButton {

    ImageIcon sendIcon = new ImageIcon("src\\assets\\ButtonImage.png");
    Image img2 = sendIcon.getImage();
    Image imgScale2 = img2.getScaledInstance(40, 40, 100);
    ImageIcon scaledSend = new ImageIcon(imgScale2);


    SendButton() {
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setBackground(null);
        this.setForeground(null);
        this.setIcon(this.scaledSend);
        this.setEnabled(false);
    }
}