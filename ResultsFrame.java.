import javax.swing.*;
import java.awt.*;

public class ResultsFrame extends JFrame {

    public ResultsFrame() {

        setTitle("Results & Winners");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("RESULTS & WINNERS");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // Result ID
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Result ID:"), gbc);

        JTextField resultIdField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(resultIdField, gbc);

        // Event ID
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Event ID:"), gbc);

        JTextField eventIdField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(eventIdField, gbc);

        // Event Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Event Name:"), gbc);

        JTextField eventNameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(eventNameField, gbc);

        // Student ID
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Student ID:"), gbc);

        JTextField studentIdField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(studentIdField, gbc);

        // Student Name
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Student Name:"), gbc);

        JTextField studentNameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(studentNameField, gbc);

        // Position
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Position:"), gbc);

        String[] positions = {"1st", "2nd", "3rd", "Participant"};
        JComboBox<String> positionComboBox = new JComboBox<>(positions);

        gbc.gridx = 1;
        panel.add(positionComboBox, gbc);

        // Result Status
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Result Status:"), gbc);

        String[] resultStatuses = {"Winner", "Runner-up", "Participant"};
        JComboBox<String> statusComboBox =
                new JComboBox<>(resultStatuses);

        gbc.gridx = 1;
        panel.add(statusComboBox, gbc);

        // Buttons
        JButton saveButton = new JButton("Save Result");
        JButton clearButton = new JButton("Clear");

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(saveButton, gbc);

        gbc.gridx = 1;
        panel.add(clearButton, gbc);

        // Clear button
        clearButton.addActionListener(e -> {
            resultIdField.setText("");
            eventIdField.setText("");
            eventNameField.setText("");
            studentIdField.setText("");
            studentNameField.setText("");
            positionComboBox.setSelectedIndex(0);
            statusComboBox.setSelectedIndex(0);
        });

        add(panel);
    }

    public static void main(String[] args) {
        new ResultsFrame().setVisible(true);
    }
}
