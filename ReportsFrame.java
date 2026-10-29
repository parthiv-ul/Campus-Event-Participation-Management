import javax.swing.*;
import java.awt.*;

public class ReportsFrame extends JFrame {

    public ReportsFrame() {
        this(null);
    }

    public ReportsFrame(String initialReportType) {

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
        if (initialReportType != null) {
            reportComboBox.setSelectedItem(initialReportType);
        }

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

        JButton dashboardButton = new JButton("Dashboard");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        panel.add(dashboardButton, gbc);

        generateButton.addActionListener(e -> generateReport(
                (String) reportComboBox.getSelectedItem(), eventIdField,
                eventNameField, participantsField, attendanceField, winnersField));

        clearButton.addActionListener(e -> {
            eventIdField.setText("");
            eventNameField.setText("");
            participantsField.setText("");
            attendanceField.setText("");
            winnersField.setText("");
            reportComboBox.setSelectedIndex(0);
        });
        dashboardButton.addActionListener(e -> AppNavigation.returnToDashboard(this));

        add(panel);
    }

    private void generateReport(String reportType, JTextField eventIdField,
            JTextField eventNameField, JTextField participantsField,
            JTextField attendanceField, JTextField winnersField) {
        String eventId = eventIdField.getText().trim();
        CampusEventStore.Event event = null;
        if (!eventId.isEmpty()) {
            event = CampusEventStore.findEvent(eventId);
            if (event == null) {
                JOptionPane.showMessageDialog(this, "No event exists with this ID.",
                        "Event Reports", JOptionPane.ERROR_MESSAGE);
                return;
            }
            eventNameField.setText(event.name);
        }

        int registrations = CampusEventStore.getRegistrationCount(eventId.isEmpty() ? null : eventId);
        int participantRecords = CampusEventStore.getParticipantCount(
                eventId.isEmpty() ? null : eventId);
        int present = CampusEventStore.getAttendanceCount(
                eventId.isEmpty() ? null : eventId, "Present");
        int absent = CampusEventStore.getAttendanceCount(
                eventId.isEmpty() ? null : eventId, "Absent");

        if ("Participant Report".equals(reportType)) {
            participantsField.setText(String.valueOf(participantRecords));
        } else {
            participantsField.setText(String.valueOf(registrations));
        }
        attendanceField.setText("Present: " + present + ", Absent: " + absent);
        if ("Results Report".equals(reportType)) {
            winnersField.setText("No winners have been recorded");
        } else {
            winnersField.setText("Not applicable");
        }
        JOptionPane.showMessageDialog(this, reportType + " generated.",
                "Event Reports", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new ReportsFrame().setVisible(true);
    }
}
