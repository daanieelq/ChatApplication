import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

class TextField extends JTextField {
    Frame frame;
    ChatBubble chatBubble;

    private Shape shape;


    public TextField(int size, Frame frame) {
        super(size);
        this.frame = frame;
        setOpaque(false);


        chatBubble = new ChatBubble();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = KeyEvent.VK_ENTER;
                if (e.getKeyCode() == key) {
                    frame.userInput = TextField.this.getText();
                    if (!frame.userInput.equals("Message") && !frame.userInput.isEmpty()) {
                        System.out.println(frame.userInput);
                        TextField.this.setText("");
                    }
                }
            }
        });

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                TextField.this.setForeground(new Color(255, 255, 255, 40));
                TextField.this.setBackground(new Color(40, 111, 122, 40));
                if (TextField.this.getText().trim().isEmpty()) {
                    TextField.this.setText("Message..");
                }
                super.focusLost(e);
            }
        });

        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                TextField.this.setForeground(new Color(255, 255, 255));
                TextField.this.setBackground(new Color(40, 111, 122, 80));
                if (TextField.this.getText().equals("Message")) {
                    TextField.this.setText("");
                }
                super.focusGained(e);
            }
        });


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                TextField.this.setForeground(new Color(255, 255, 255));
                TextField.this.setBackground(new Color(40, 111, 122, 80));
                super.mouseEntered(e);
            }
        });


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TextField.this.setForeground(new Color(255, 255, 255));
                TextField.this.setBackground(new Color(40, 111, 122, 80));
                super.mouseClicked(e);
            }
        });

    }

        protected void paintComponent (Graphics g){
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setComposite((AlphaComposite.Clear));
            g2.fillRect(0, 0, getWidth(), getHeight());

            g2.setComposite(AlphaComposite.SrcOver);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

            g2.dispose();
            super.paintComponent(g);
        }

        protected void paintBorder (Graphics g){
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setColor(getForeground());
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }

        public boolean contains (int x, int y){
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(2, 2, getWidth() - 1, getHeight() - 1, 20, 20);
            }
            return shape.contains(x, y);
        }
}