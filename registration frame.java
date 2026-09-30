import javax.swing.*;
import java.awt.*;

public class RegistrationFrame extends JFrame {

    public RegistrationFrame() {

        setTitle("Event Registration");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("EVENT REGISTRATION");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        // Student ID
        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(studentIdLabel, gbc);

        gbc.gridx = 1;
        panel.add(studentIdField, gbc);

        // Student Name
        JLabel studentNameLabel = new JLabel("Student Name:");
        JTextField studentNameField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(studentNameLabel, gbc);

        gbc.gridx = 1;
        panel.add(studentNameField, gbc);

        // Event ID
        JLabel eventIdLabel = new JLabel("Event ID:");
        JTextField eventIdField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(eventIdLabel, gbc);

        gbc.gridx = 1;
        panel.add(eventIdField, gbc);

        // Event Name
        JLabel eventNameLabel = new JLabel("Event Name:");
        JTextField eventNameField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(eventNameLabel, gbc);

        gbc.gridx = 1;
        panel.add(eventNameField, gbc);

        // Event Type
        JLabel eventTypeLabel = new JLabel("Event Type:");
        JTextField eventTypeField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(eventTypeLabel, gbc);

        gbc.gridx = 1;
        panel.add(eventTypeField, gbc);

        // Registration Status
        JLabel statusLabel = new JLabel("Registration Status:");
        JTextField statusField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(statusLabel, gbc);

        gbc.gridx = 1;
        panel.add(statusField, gbc);

        // Buttons
        JButton registerButton = new JButton("Register");
        JButton clearButton = new JButton("Clear");

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(registerButton, gbc);

        gbc.gridx = 1;
        panel.add(clearButton, gbc);

        // Clear button - visual frame functionality only
        clearButton.addActionListener(e -> {
            studentIdField.setText("");
            studentNameField.setText("");
            eventIdField.setText("");
            eventNameField.setText("");
            eventTypeField.setText("");
            statusField.setText("");
        });

        add(panel);
    }

    public static void main(String[] args) {
        new RegistrationFrame().setVisible(true);
    }
}
