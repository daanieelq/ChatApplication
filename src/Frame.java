import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Frame {
    JFrame frame;
    JPanel panel;
    JButton sendButton;
    JTextField text;
    JLabel chatWindow;
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
        text.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                text.setForeground(new Color(255,255,255));
                text.setText(null);
                textfieldMouseClicked(e);
            }
        });
        text.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost (java.awt.event.FocusEvent evt) {
                text.setForeground(new Color(255,255,255,128));
                textfieldFocusLost(evt);
            }
        });


        sendButton = new JButton();
        sendButton.setBounds(5,5,30,25);
        sendButton.setBorder(new RoundedButton(20));
        sendButton.setPreferredSize(new Dimension(20,50));
        sendButton.setOpaque(false);


        chatWindow = new JLabel();
        chatWindow.setBackground(Color.decode("#2e2925"));
        chatWindow.setOpaque(true);
        chatWindow.setVisible(true);


        customFont();

        text.setBounds(50,700,420,40);
        sendButton.setBounds(480, 700, 70, 40);
        chatWindow.setBounds(20, 20, 560, 630);
        text.setBackground(Color.decode("#33313b"));
        text.setForeground(new Color(255,255,255,128));
        text.setFont(Montserrat);
        sendButton.setOpaque(true);
        sendButton.setContentAreaFilled(true);
        sendButton.setBorderPainted(false);
        sendButton.setBackground(Color.decode("#33313b"));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(Montserrat.deriveFont(10f));


        frame.add(panel);
        panel.add(text);
        panel.add(sendButton);
        panel.add(chatWindow);
        frame.setVisible(true);
    }

    public void customFont() {
        try {
            Montserrat = Font.createFont(Font.TRUETYPE_FONT, new File("src/Montserrat-Regular.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Montserrat-Regular.ttf")));
        }
        catch(IOException | FontFormatException e) {

        }
    }

    public void textfieldMouseClicked(java.awt.event.MouseEvent evt) {
        text.setText(null);
    }

    public void textfieldFocusLost(java.awt.event.FocusEvent evt) {
        text.setText("Message");
    }

    public void actionPerformed(ActionEvent e) {
        sendButton.addActionListener();
    }

}

