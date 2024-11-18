import javax.swing.border.Border;
import java.awt.*;

public class RoundedButton implements Border {

    private int radius;

    RoundedButton(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRect(x, y, width - 1, height - 1);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
