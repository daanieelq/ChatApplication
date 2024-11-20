import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Frame {
    int spaces = 20;
    int windowHeight = 800;
    int windowWidth = 600;
    int chatWindowHeight = windowHeight - spaces ;
    int chatWindowWidth = windowWidth - spaces;
    int sendButtonHeight = ;
    int sendButtonWidth;
    int textBoxHeight;
    int textBoxWidth;
    String userInput;
    int key;


    JFrame frame;
    JPanel panel;
    JButton sendButton;
    JTextField text;
    JLabel chatWindow;
    Font Montserrat;



    ImageIcon img = new ImageIcon("src\\icon.png");

    public Frame() {
        frame = new JFrame("Chat Application");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(windowWidth,windowHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(img.getImage());


        panel = new JPanel(new BorderLayout());
        panel.setLayout(null);
        panel.setBackground(Color.decode("#121212"));


        text = new RoundTextField(0);
        text.setPreferredSize(new Dimension(120,50));
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = KeyEvent.VK_ENTER;
                if(e.getKeyCode() == key) {
                    userInput = text.getText().trim();
                    if(!userInput.equals("Message") && !userInput.isEmpty()) {
                        System.out.println(userInput);
                        text.setText(null);
                    }
                }
            }
        });
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
        sendButton.addActionListener(e -> {
            userInput = text.getText().trim();
            if(!userInput.equals("Message") && !userInput.isEmpty()) {
                System.out.println(userInput);
                text.setText(null);
            }
        });


        chatWindow = new JLabel();
        chatWindow.setBackground(Color.decode("#2e2925"));
        chatWindow.setOpaque(true);
        chatWindow.setVisible(true);


        customFont();

        text.setBounds(50,700,420,40);
        sendButton.setBounds(480, 700, 70, 40);
        chatWindow.setBounds(20, 20, 540, 630);
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

        if (key == KeyEvent.VK_ENTER) {
            System.out.println("Hallo");
        }
        text.setText(null);
    }

    public void textfieldFocusLost(java.awt.event.FocusEvent evt) {
        if(text.getText().trim().isEmpty()) {
            text.setText("Message");
        }
    }
}

