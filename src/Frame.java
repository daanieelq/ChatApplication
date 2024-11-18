import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Frame {
    JFrame frame;
    JPanel panel;
    JButton sendButton;
    JTextField text;
    Font Montserrat;

    ImageIcon img = new ImageIcon("C:\\Users\\antis\\Documents\\programmieren\\ChatApplication\\src\\icon.png");

    public Frame() {
        frame = new JFrame("Chat Application");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(img.getImage());



        panel = new JPanel(new BorderLayout());
        panel.setLayout(null);
        panel.setBackground(Color.decode("#121212"));



        text = new RoundTextField(0);
        text.setPreferredSize(new Dimension(120,50));

        sendButton = new JButton("Send");
        sendButton.setPreferredSize(new Dimension(20,50));


        customFont();

        text.setBounds(50,700,420,40);
        sendButton.setBounds(480, 700, 70, 40);
        text.setBackground(Color.decode("#33313b"));
        text.setForeground(Color.WHITE);
        text.setFont(Montserrat);
        sendButton.setOpaque(true);
        sendButton.setContentAreaFilled(true);
        sendButton.setBorderPainted(false);
        sendButton.setBackground(Color.decode("#33313b"));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(Montserrat.deriveFont(13f));



        frame.add(panel);
        panel.add(text);
        panel.add(sendButton);
        frame.setVisible(true);
    }

    public void customFont() {
        try {
            Montserrat = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\antis\\Documents\\programmieren\\ChatApplication\\src\\Montserrat-Regular.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\antis\\Documents\\programmieren\\ChatApplication\\src\\Montserrat-Regular.ttf")));
        }
        catch(IOException | FontFormatException e) {

        }
    }

    public void textfieldMouseClicked(java.awt.event.MouseEvent evt) {
        text.setText(null);
    }

    public void textfieldFocusLost(java.awt.event.FocusEvent evt) {
        text.setText("Message:");
    }

}

