import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ChatBubble extends JTextField {
    TextField roundTextField;
    SendButton sendButton;

    int messages = 0;
    private Shape shape;


    public ChatBubble() {

    }

    public String createBubble(String message) {

        this.setText(message);
        return "Nachricht erzeugt: " + message;
    }


    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 5, 5);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 5, 5);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 5, 5);
        }
        return shape.contains(x, y);
    }

}
