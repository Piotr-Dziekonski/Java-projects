import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rgbLabelColorChanger extends JFrame {

    private JLabel label;
    private JButton buttonAccept, buttonReset;
    private JTextField red, green, blue;
    private JPanel textPanel, elementsPanel;

    public rgbLabelColorChanger() {
        setLayout(new BorderLayout());
        textPanel = new JPanel(new GridBagLayout());
        elementsPanel = new JPanel(new FlowLayout());
        buttonReset = new JButton("Reset");
        add(buttonReset, BorderLayout.NORTH);
        add(textPanel);
        add(elementsPanel, BorderLayout.SOUTH);

        label = new JLabel("<html><font color = 'red'>Hello world! I am changing colors!</font></html>");
        textPanel.add(label);

        red = new JTextField(5);
        green = new JTextField(5);
        blue = new JTextField(5);
        buttonAccept = new JButton("Confirm");

        elementsPanel.add(red);
        elementsPanel.add(green);
        elementsPanel.add(blue);
        elementsPanel.add(buttonAccept);


        acceptEvent accept = new acceptEvent();
        resetEvent reset = new resetEvent();
        buttonAccept.addActionListener(accept);
        buttonReset.addActionListener(reset);

    }

    public static void main(String args[]) {
        rgbLabelColorChanger app = new rgbLabelColorChanger();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setMinimumSize(new Dimension(400, 200));
        app.setLocationRelativeTo(null);
        app.setVisible(true);
        app.setTitle("RGB Label Color Changer");

    }

    public class resetEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            red.setText("");
            green.setText("");
            blue.setText("");
            label.setText("<html><font color = 'red'>Hello world! I am changing colors!</font></html>");
        }
    }

    public class acceptEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String inputRed = red.getText();
            String inputGreen = green.getText();
            String inputBlue = blue.getText();
            try {
                int inputRedInt = Integer.parseInt(inputRed);
                if (inputRedInt < 0) {
                    inputRed = "200";
                    red.setText("200");
                } else if (inputRedInt > 255) {
                    inputRed = "255";
                    red.setText("255");
                }

            } catch (NumberFormatException x) {
                red.setText("");
                label.setText("<html><font color = 'red'>Enter correct values</font></html>");
            }
            try {
                int inputGreenInt = Integer.parseInt(inputGreen);
                if (inputGreenInt < 0) {
                    inputGreen = "200";
                    green.setText("200");
                } else if (inputGreenInt > 255) {
                    inputGreen = "255";
                    green.setText("255");
                }

            } catch (NumberFormatException x) {
                green.setText("");
                label.setText("<html><font color = 'red'>Enter correct values</font></html>");
            }
            try {
                int inputBlueInt = Integer.parseInt(inputBlue);
                if (inputBlueInt < 0) {
                    inputBlue = "200";
                    blue.setText("200");
                } else if (inputBlueInt > 255) {
                    inputBlue = "255";
                    blue.setText("255");
                }

            } catch (NumberFormatException x) {
                blue.setText("");
                label.setText("<html><font color = 'red'>Enter correct values</font></html>");
            }

            try {
                Color color = new Color(Integer.parseInt(inputRed), Integer.parseInt(inputGreen), Integer.parseInt(inputBlue));
                label.setText("<html><font color = 'rgb(" + color.getValue() + ")'>Hello world! I am changing colors!</font></html>");
            } catch (Exception x) {
            }

        }
    }

    public class Color {
        private int red;
        private int green;
        private int blue;

        public Color(int r, int g, int b) {
            red = r;
            green = g;
            blue = b;
        }

        public String getValue() {
            return String.format("%s,%s,%s", red, green, blue);
        }
    }

}
