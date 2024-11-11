import java.awt.Color;
import javax.swing.*;

public class QuestionOnExitPanel extends JPanel {

    QuestionOnExitPanel() {
        JLabel question = new JLabel("Are you sure?");
        question.setBounds(50, 30, 90, 30);
        JButton yesButton = new JButton("YES");
        yesButton.setBounds(30, 80, 60, 30);
        yesButton.setBackground(Color.GREEN);

        JButton noButton = new JButton("NO");
        noButton.setBounds(100, 80, 60, 30);
        noButton.setBackground(Color.RED);

        setBackground(Color.CYAN);
        setSize(200, 150);
        setLayout(null);
        add(question);
        add(yesButton);
        add(noButton);

        // }
        // public static void main(String[] args) {
        // JFrame f = new JFrame();
        // JLabel question = new JLabel("Are you sure?");
        // question.setBounds(50,30,90,30);
        // JButton yesButton = new JButton("YES");
        // yesButton.setBounds(30,80,60,30);
        // yesButton.setBackground(Color.GREEN);

        // JButton noButton = new JButton("NO");
        // noButton.setBounds(100,80,60,30);
        // noButton.setBackground(Color.RED);
        // JPanel panel = new JPanel();
        // panel.setBackground(Color.CYAN);

        // panel.setSize(200,150);
        // panel.setLayout(null);
        // panel.add(question);
        // panel.add(yesButton);
        // panel.add(noButton);
        // f.add(panel);
        // f.setSize(350,350);
        // f.setLayout(null);

        // f.setVisible(true);

        // }

    }
}
