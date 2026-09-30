import javax.swing.*;
import java.awt.*;

public class ParticipantFrame extends JFrame {

    public ParticipantFrame() {

        setTitle("Participant Management");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("PARTICIPANT MANAGEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // Participant ID
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Participant ID:"), gbc);

        JTextField participantIdField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(participantIdField, gbc);

        // Student ID
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Student ID:"), gbc);

        JTextField studentIdField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(studentIdField, gbc);

        // Student Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Student Name:"), gbc);

        JTextField studentNameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(studentNameField, gbc);

        // Event ID
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Event ID:"), gbc);

        JTextField eventIdField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(eventIdField, gbc);

        // Event Name
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Event Name:"), gbc);

        JTextField eventNameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(eventNameField, gbc);

        // Event Type
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Event Type:"), gbc);

        String[] eventTypes = {"Technical", "Cultural", "Sports"};
        JComboBox<String> typeComboBox = new JComboBox<>(eventTypes);

        gbc.gridx = 1;
        panel.add(typeComboBox, gbc);

        // Registration Status
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Registration Status:"), gbc);

        String[] statuses = {"Registered", "Pending", "Cancelled"};
        JComboBox<String> statusComboBox = new JComboBox<>(statuses);

        gbc.gridx = 1;
        panel.add(statusComboBox, gbc);

        // Buttons
        JButton saveButton = new JButton("Save");
        JButton clearButton = new JButton("Clear");

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(saveButton, gbc);

        gbc.gridx = 1;
        panel.add(clearButton, gbc);

        // Clear button
        clearButton.addActionListener(e -> {
            participantIdField.setText("");
            studentIdField.setText("");
            studentNameField.setText("");
            eventIdField.setText("");
            eventNameField.setText("");
            typeComboBox.setSelectedIndex(0);
            statusComboBox.setSelectedIndex(0);
        });

        add(panel);
    }

    public static void main(String[] args) {
        new ParticipantFrame().setVisible(true);
    }
}
