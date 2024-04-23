import javax.swing.*;
import java.awt.*;

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

    JPanel heading = new JPanel();
    JPanel body = new JPanel();

    JPanel inputName = new JPanel();

    JLabel welcome = new JLabel("Welcome to Japanese Tea Ceremony Simulator 🫖");

    JLabel ask = new JLabel("Hi! What is your name?");
    JTextField box = new JTextField();
    JButton enter = new JButton("Enter");

    public MyWindow() {
        layOutComponents();
    }

    private void layOutComponents() {
        start.setLayout(new BoxLayout(start, BoxLayout.Y_AXIS));
        Font font = new Font("Arial", Font.BOLD, 20);
        welcome.setFont(font);
        welcome.setForeground(Color.gray);
        welcome.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        heading.setLayout(new FlowLayout());
        heading.setSize(5,10);
        heading.setBackground(new Color(255, 170, 29));

       // start.setBackground(new Color(50, 100, 50));
        body.setBackground(new Color(0, 90, 4));

        inputName.add(ask);
        inputName.add(box);
        inputName.add(enter);

        body.add(inputName);
        heading.add(welcome);

        start.add(heading);
       // start.add(body);
      
        this.add(start, BorderLayout.NORTH);
        this.add(body, BorderLayout.CENTER);
    }
}

/*
 start.setLayout(new BoxLayout(start, BoxLayout.Y_AXIS));
        Font font = new Font("Arial", Font.BOLD, 20);
        welcome.setFont(font);
        welcome.setForeground(Color.gray);
        welcome.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        heading.setLayout(new FlowLayout());
        heading.setSize(5,10);

        start.setBackground(new Color(50, 100, 50));
       // body.setBackground(Color.blue);

        inputName.add(ask);
        inputName.add(box);
        inputName.add(enter);

        body.add(inputName);
        heading.add(welcome);

        start.add(heading);
        start.add(body);

        start.setBackground(Color.green);
        this.add(start, BorderLayout.CENTER); */