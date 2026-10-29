import javax.swing.*;
import java.awt.*;

public class AttendanceFrame extends JFrame {

    public AttendanceFrame() {

        setTitle("Attendance Management");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("ATTENDANCE MANAGEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // Attendance ID
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Attendance ID:"), gbc);

        JTextField attendanceIdField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(attendanceIdField, gbc);

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

        // Attendance Status
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Attendance Status:"), gbc);

        String[] attendanceStatus = {"Present", "Absent"};
        JComboBox<String> attendanceComboBox =
                new JComboBox<>(attendanceStatus);

        gbc.gridx = 1;
        panel.add(attendanceComboBox, gbc);

        // Date
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Date:"), gbc);

        JTextField dateField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(dateField, gbc);

        // Buttons
        JButton markButton = new JButton("Mark Attendance");
        JButton clearButton = new JButton("Clear");

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(markButton, gbc);

        gbc.gridx = 1;
        panel.add(clearButton, gbc);

        JButton dashboardButton = new JButton("Dashboard");
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(dashboardButton, gbc);

        markButton.addActionListener(e -> {
            try {
                CampusEventStore.Event event =
                        CampusEventStore.findEvent(eventIdField.getText());
                if (event == null) {
                    throw new IllegalArgumentException("Create the event before using its ID.");
                }
                eventNameField.setText(event.name);
                CampusEventStore.markAttendance(studentIdField.getText(),
                        studentNameField.getText(), event.id, event.name,
                        (String) attendanceComboBox.getSelectedItem(), dateField.getText());
                JOptionPane.showMessageDialog(this, "Attendance marked.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Attendance Management", JOptionPane.ERROR_MESSAGE);
            }
        });

        clearButton.addActionListener(e -> {
            attendanceIdField.setText("");
            studentIdField.setText("");
            studentNameField.setText("");
            eventIdField.setText("");
            eventNameField.setText("");
            dateField.setText("");
            attendanceComboBox.setSelectedIndex(0);
        });
        dashboardButton.addActionListener(e -> AppNavigation.returnToDashboard(this));

        add(panel);
    }

    public static void main(String[] args) {
        new AttendanceFrame().setVisible(true);
    }
}
