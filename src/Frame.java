import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

public class Frame {
    ChatBubble chatBubble;
    JFrame frame;
    JScrollPane scrollPanel;
    CloseButton closeButton;
    MinimizeButton minimizeButton;
    TextField textField;
    SendButton sendButton;
    JLabel chatWindow;

    Font Montserrat;

    int spaces = 20;
    int windowHeight = 800;
    int windowWidth = 600;
    public String userInput;


    ImageIcon chatIcon = new ImageIcon("src\\assets\\icon.png");


    public Frame() throws IOException {
        frame = new JFrame("Chat Application");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(chatIcon.getImage());
        frame.setUndecorated(true);
        frame.getRootPane().setBorder(null);
        frame.setShape(new RoundRectangle2D.Double(5,5 , frame.getWidth(), frame.getHeight(), 20, 20));
        frame.setBackground(new Color(18, 17, 19, 90));


        customFont();
        textField = new TextField(20, this);
        textField.setBounds(50, 700, 420, 40);
        textField.setFont(Montserrat);


        scrollPanel = new JScrollPane (chatWindow);
        scrollPanel.setLayout(null);
        scrollPanel.setBounds(0, 0, windowWidth, windowHeight);
        scrollPanel.setBackground(new Color(18, 17, 19, 90));

        closeButton = new CloseButton();
        closeButton.setBounds(565, 15, 20, 20);
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                super.mouseClicked(e);
            }
        });

        minimizeButton = new MinimizeButton();
        minimizeButton.setBounds(535, 15, 20, 20);
        minimizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setExtendedState(frame.ICONIFIED);
                super.mouseClicked(e);
            }
        });

        sendButton = new SendButton();
        sendButton.setBounds(480, 700, 40, 40);
        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userInput = textField.getText().trim();
                if (!userInput.equals("Message") && !userInput.isEmpty()) {
                    System.out.println(userInput);
                    textField.setText("");
                    super.mouseClicked(e);
                }
            }
        });


        frame.add(scrollPanel);
        scrollPanel.add(textField);
        scrollPanel.add(sendButton);
        scrollPanel.add(closeButton);
        scrollPanel.add(minimizeButton);
        frame.setVisible(true);
    }

    public void customFont() {
        try {
            Montserrat = Font.createFont(Font.TRUETYPE_FONT, new File("src/assets/Montserrat-Regular.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/assets/Montserrat-Regular.ttf")));
        } catch (IOException | FontFormatException e) {

        }


    }
}

