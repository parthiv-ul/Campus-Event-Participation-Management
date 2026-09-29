import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {

        setTitle("Campus Event Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title
        JLabel titleLabel = new JLabel("CAMPUS EVENT MANAGEMENT SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Username
        JLabel usernameLabel = new JLabel("Username:");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField(20);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(usernameField, gbc);

        // Password
        JLabel passwordLabel = new JLabel("Password:");

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passwordField, gbc);

        // Login button
        JButton loginButton = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(loginButton, gbc);

        // Clear button
        JButton clearButton = new JButton("Clear");

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(clearButton, gbc);

    // Clear button action
clearButton.addActionListener(e -> {
    usernameField.setText("");
    passwordField.setText("");
});


        add(panel);
    }

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}