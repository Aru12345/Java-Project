import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.List;

class TeaGame {
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
    JPanel thirdBody = new JPanel();
    JScrollPane scrollPane = new JScrollPane(thirdBody);

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
    ButtonGroup optionGroup;
    ButtonGroup levelButtons = new ButtonGroup();
    JRadioButton levelButton1 = new JRadioButton("Easy");
    JRadioButton levelButton2 = new JRadioButton("Medium");
    JRadioButton levelButton3 = new JRadioButton("Hard");

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
        thirdBody.setBackground(new Color(0, 158, 96));
        thirdBody.setForeground(Color.white);

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

        optionGroup = new ButtonGroup();
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

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane, BorderLayout.CENTER);
        // thirdBody.setLayout(new BoxLayout(thirdBody, BoxLayout.Y_AXIS));

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

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve the selected tea type
                String selectedTeaType = null;
                for (Enumeration<AbstractButton> buttons = optionGroup.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        selectedTeaType = button.getText();
                        break;
                    }
                }

                // Retrieve the selected preparation level
                String selectedLevel = null;
                if (levelButton1.isSelected()) {
                    selectedLevel = "Easy";
                } else if (levelButton2.isSelected()) {
                    selectedLevel = "Medium";
                } else if (levelButton3.isSelected()) {
                    selectedLevel = "Hard";
                }

                // Check if both tea type and preparation level have been selected
                if (selectedLevel != null) {
                    if (selectedTeaType.equals("Matcha (抹茶)")) {
                        Matcha matcha = new Matcha("History of Matcha", "Overview of Matcha");
                        displayMatchaInfo(matcha);
                    } else if (selectedTeaType.equals("Gyokuro (玉露)")) {
                        // Handle Gyokuro tea
                    } else if (selectedTeaType.equals("Hatsugama (初釜)")) {
                        // Handle Hatsugama tea
                    }
                } else {
                    // If either tea type or preparation level is not selected, display an error
                    // message
                    JLabel errorMsg = new JLabel("Sorry something went wrong.Please Select a tea type and a level.");
                    secondBody.add(errorMsg);
                    secondBody.revalidate();
                    secondBody.repaint();
                    errorMsg.setForeground(Color.white);
                    errorMsg.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 20));
                }
            }
        });

    }

    private void displayMatchaInfo(Matcha matcha) {
        // Display Matcha information
        JLabel historyLabel = new JLabel(
                "<html><p style='height: 400px;'>History: " + matcha.getHistory() + "</p></html>");
        historyLabel.setVerticalAlignment(SwingConstants.TOP);
        historyLabel.setVerticalTextPosition(SwingConstants.TOP);
        historyLabel.setForeground(Color.white);

        JLabel overviewLabel = new JLabel("<html>Overview: " + matcha.getOverview() + "</html>");
        overviewLabel.setVerticalAlignment(SwingConstants.TOP);
        overviewLabel.setVerticalTextPosition(SwingConstants.TOP);
        overviewLabel.setForeground(Color.white);

        // Adjust the width of the labels dynamically
        Dimension preferredSize = historyLabel.getPreferredSize();
        int width = preferredSize.width > 500 ? 500 : preferredSize.width;
        historyLabel.setPreferredSize(new Dimension(width, preferredSize.height));

        preferredSize = overviewLabel.getPreferredSize();
        width = preferredSize.width > 500 ? 500 : preferredSize.width;
        overviewLabel.setPreferredSize(new Dimension(width, preferredSize.height));

        // Add history and overview labels to the thirdBody panel
        thirdBody.add(historyLabel);
        thirdBody.add(overviewLabel);

        // Retrieve and display questions based on the selected difficulty level
        int difficultyLevel = 0;
        if (levelButton1.isSelected()) {
            difficultyLevel = 1;
        } else if (levelButton2.isSelected()) {
            difficultyLevel = 2;
        } else if (levelButton3.isSelected()) {
            difficultyLevel = 3;
        }

        List<String> questions = matcha.getQuestions(difficultyLevel);
        List<List<String>> options = matcha.getOptions(difficultyLevel);
        if (questions != null && options != null && questions.size() == options.size()) {
            for (int i = 0; i < questions.size(); i++) {
                JLabel questionLabel = new JLabel(questions.get(i));
                thirdBody.add(questionLabel);

                ButtonGroup optionGroup = new ButtonGroup();
                for (String option : options.get(i)) {
                    JRadioButton radioButton = new JRadioButton(option);
                    optionGroup.add(radioButton);
                    thirdBody.add(radioButton);
                }
            }
        }

        // Update the layout of the thirdBody panel
        thirdBody.setLayout(new BoxLayout(thirdBody, BoxLayout.Y_AXIS));

        // Add the thirdBody panel to the scrollPane
        scrollPane.setViewportView(thirdBody);

        getContentPane().remove(secondBody); // Remove the secondBody panel
        getContentPane().add(scrollPane, BorderLayout.CENTER); // Add the scrollPane to the center
        revalidate(); // Re-layout components
        repaint();
        personalMsg.setText("Hi 👋 " + userName + "!");
    }

}