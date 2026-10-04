import javax.swing.*;
import java.awt.*;

public class ReportsFrame extends JFrame {

    public ReportsFrame() {

        setTitle("Event Reports");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("EVENT REPORTS");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // Report Type
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Report Type:"), gbc);

        String[] reportTypes = {
            "Event Report",
            "Participant Report",
            "Attendance Report",
            "Results Report"
        };

        JComboBox<String> reportComboBox =
                new JComboBox<>(reportTypes);

        gbc.gridx = 1;
        panel.add(reportComboBox, gbc);

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

        // Total Participants
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Total Participants:"), gbc);

        JTextField participantsField = new JTextField(20);
        participantsField.setEditable(false);
        gbc.gridx = 1;
        panel.add(participantsField, gbc);

        // Attendance
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Attendance:"), gbc);

        JTextField attendanceField = new JTextField(20);
        attendanceField.setEditable(false);
        gbc.gridx = 1;
        panel.add(attendanceField, gbc);

        // Winners
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Winners:"), gbc);

        JTextField winnersField = new JTextField(20);
        winnersField.setEditable(false);
        gbc.gridx = 1;
        panel.add(winnersField, gbc);

        // Buttons
        JButton generateButton = new JButton("Generate Report");
        JButton clearButton = new JButton("Clear");

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(generateButton, gbc);

        gbc.gridx = 1;
        panel.add(clearButton, gbc);

        // Clear button
        clearButton.addActionListener(e -> {
            eventIdField.setText("");
            eventNameField.setText("");
            participantsField.setText("");
            attendanceField.setText("");
            winnersField.setText("");
            reportComboBox.setSelectedIndex(0);
        });

        add(panel);
    }

    public static void main(String[] args) {
        new ReportsFrame().setVisible(true);
    }
}
