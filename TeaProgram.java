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
    JLabel welcome = new JLabel("Welcome to Japanese Tea Ceremony Simulator 🫖");

    public MyWindow() {
        layOutComponents();
    }

    private void layOutComponents() {
        Font font = new Font("Arial", Font.BOLD, 20);
        welcome.setFont(font);
        welcome.setForeground(Color.gray);
        welcome.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        heading.setLayout(new FlowLayout());
        heading.setForeground(Color.RED); // just for illustration

        start.setBackground(new Color(50, 100, 50));

        heading.add(welcome);
        start.add(heading);
        this.add(start, BorderLayout.CENTER);
    }
}
