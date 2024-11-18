import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Montserrat-Regular.ttf")));
        } catch (IOException|FontFormatException e) {
            //Handle exception
        }

        Font font = new Font("Montserrat",Font.PLAIN,20);

        JFrame frame = new JFrame("Chat Application");
        JPanel panel = new JPanel(new BorderLayout());
        JButton send = new JButton("Send");
        frame.add(panel);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        panel.setLayout(null);


        JTextField text = new JTextField("Message", 32);
        text.setPreferredSize(new Dimension(120,50));
         text.setFont(font);


        send.setPreferredSize(new Dimension(20,50));

        panel.add(text);
        panel.add(send);
        text.setBounds(50,700,420,50);
        send.setBounds(480, 700, 70, 50);
        text.setBackground(Color.decode("#33313b"));
        text.setForeground(Color.WHITE);
        send.setOpaque(true);
        send.setContentAreaFilled(true);
        send.setBorderPainted(false);
        send.setBackground(Color.decode("#33313b"));
        send.setForeground(Color.WHITE);

        panel.setBackground(Color.decode("#121212"));
        frame.setVisible(true);
    }
}