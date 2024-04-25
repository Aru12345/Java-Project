import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TeaProgram {
    public static void main(String[] args) {
        MyWindow window = new MyWindow();
        window.setTitle("CSCIE-10B Final Project");
        window.setSize(800, 600);
        window.setVisible(true);
    }
}

class MyWindow extends JFrame {
    JPanel start = new JPanel();
    boolean begin = true;

    JPanel heading = new JPanel();
    JPanel body = new JPanel();
    JPanel secondBody = new JPanel();

    JPanel inputName = new JPanel();

    JLabel welcome = new JLabel("Welcome to Japanese Tea Ceremony Simulator 🫖");

    JLabel ask = new JLabel("Hi! What is your name?");
    JTextField box = new JTextField();
    JButton enter = new JButton("Enter");

    String userName = "";
    JLabel personalMsg = new JLabel("");
    JLabel teaPrep = new JLabel("Please select a tea preparation 🍵");
    JLabel levelMsg = new JLabel("Please select a preparation level 🍵");

    String[] teaTypes = { "Matcha (抹茶)", "Gyokuro (玉露)", "Hatsugama (初釜)" }; // Data Struture used to store tea-types

    JButton startButton = new JButton("Start");

    public MyWindow() {
        layOutComponents();
        addActionsListeners();
    }

    private void layOutComponents() {
        start.setLayout(new BoxLayout(start, BoxLayout.Y_AXIS));
        Font font = new Font("Arial", Font.BOLD, 20);
        welcome.setFont(font);
        welcome.setForeground(Color.white);
        welcome.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        heading.setLayout(new FlowLayout());
        heading.setSize(5, 10);
        heading.setBackground(new Color(46, 139, 87));

        // start.setBackground(new Color(50, 100, 50));
        body.setBackground(new Color(0, 158, 96));
        secondBody.setBackground(new Color(0, 158, 96));

        inputName.add(ask);
        inputName.add(box);
        inputName.add(enter);
        inputName.setLayout(new BoxLayout(inputName, BoxLayout.Y_AXIS));
        inputName.setBackground(new Color(46, 139, 87));
        ask.setFont(font);
        ask.setForeground(Color.white);
        inputName.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        personalMsg.setFont(font);
        personalMsg.setForeground(Color.white);
        personalMsg.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        teaPrep.setFont(font);
        teaPrep.setForeground(new Color(220, 220, 220));
        teaPrep.setBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20));

        // Tea Options

        secondBody.add(personalMsg);
        secondBody.add(teaPrep);
        secondBody.setLayout(new BoxLayout(secondBody, BoxLayout.Y_AXIS));

        ButtonGroup optionGroup = new ButtonGroup();
        for (int i = 0; i < teaTypes.length; i++) {
            JRadioButton radioButton = new JRadioButton(teaTypes[i]);

            radioButton.setFont(font);
            radioButton.setForeground(Color.white);
            radioButton.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));

            optionGroup.add(radioButton);
            secondBody.add(radioButton);
        }
      
        levelMsg.setFont(font);
        levelMsg.setForeground(new Color(220, 220, 220));
        levelMsg.setBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20));
        secondBody.add(levelMsg);

        ButtonGroup levelButtons = new ButtonGroup();
        JRadioButton levelButton1 = new JRadioButton("Easy");
        JRadioButton levelButton2 = new JRadioButton("Medium");
        JRadioButton levelButton3 = new JRadioButton("Hard");

        levelButton1.setFont(font);
        levelButton1.setForeground(Color.white);
        levelButton1.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));

        levelButton2.setFont(font);
        levelButton2.setForeground(Color.white);
        levelButton2.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));

        levelButton3.setFont(font);
        levelButton3.setForeground(Color.white);
        levelButton3.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
        
        levelButtons.add(levelButton1);
        levelButtons.add(levelButton2);
        levelButtons.add(levelButton3);

        secondBody.add(levelButton1);
        secondBody.add(levelButton2);
        secondBody.add(levelButton3);
        secondBody.add(startButton);

        

        body.add(inputName);
        heading.add(welcome);

        start.add(heading);
        // start.add(body);

        this.add(start, BorderLayout.NORTH);
        this.add(body, BorderLayout.CENTER);
    }

    public void addActionsListeners() {
        // final boolean active = this.begin;
        box.addFocusListener(new FocusListener() {
            // No action takes place during focus Gain
            public void focusGained(FocusEvent e) {
            }

            // Title is updated to what user enters in subject textfield after focus is lost
            public void focusLost(FocusEvent e) {
                String name = box.getText();
                MyWindow.this.userName = name;
            }
        });

        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                getContentPane().remove(body); // Remove the body panel
                getContentPane().add(secondBody, BorderLayout.CENTER); // Add the secondBody panel
                revalidate(); // Re-layout components
                repaint();

                personalMsg.setText("Hi 👋 " + userName + "!");

            }
        });
    }
}
