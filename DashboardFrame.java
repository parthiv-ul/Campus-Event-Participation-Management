import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Campus Event Management System - Dashboard");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel(new BorderLayout(20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Dashboard title
        JLabel title = new JLabel("CAMPUS EVENT MANAGEMENT DASHBOARD");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(title, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(5, 2, 20, 20));

        JButton eventButton = new JButton("Event Management");
        JButton eventDetailsButton = new JButton("Event Details");
        JButton registrationButton = new JButton("Registration");
        JButton participantButton = new JButton("Participants");
        JButton attendanceButton = new JButton("Attendance");
        JButton resultButton = new JButton("Results & Winners");
        JButton searchButton = new JButton("Search & Status");
        JButton reportButton = new JButton("Reports");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(eventButton);
        buttonPanel.add(eventDetailsButton);
        buttonPanel.add(registrationButton);
        buttonPanel.add(participantButton);
        buttonPanel.add(attendanceButton);
        buttonPanel.add(resultButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(reportButton);
        buttonPanel.add(exitButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        eventButton.addActionListener(e ->
                AppNavigation.open(new EventManagementFrame(), this));
        eventDetailsButton.addActionListener(e -> openEventDetails());
        registrationButton.addActionListener(e ->
                AppNavigation.open(new RegistrationFrame(), this));
        participantButton.addActionListener(e ->
                AppNavigation.open(new ParticipantFrame(), this));
        attendanceButton.addActionListener(e ->
                AppNavigation.open(new AttendanceFrame(), this));
        resultButton.addActionListener(e ->
                AppNavigation.open(new ResultsFrame(), this));
        searchButton.addActionListener(e ->
                AppNavigation.open(new SearchStatusFrame(), this));
        reportButton.addActionListener(e ->
                AppNavigation.open(new ReportsFrame(), this));
        exitButton.addActionListener(e -> dispose());

        add(panel);
    }

    private void openEventDetails() {
        java.util.List<String> eventIds = CampusEventStore.getEventIds();
        if (eventIds.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Save an event before viewing its details.",
                    "No Events", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Object selectedId = JOptionPane.showInputDialog(this, "Select an event:",
                "Event Details", JOptionPane.PLAIN_MESSAGE, null,
                eventIds.toArray(), eventIds.get(0));
        if (selectedId != null) {
            AppNavigation.open(new EventDetailsFrame(selectedId.toString()), this);
        }
    }

    public static void main(String[] args) {
        new DashboardFrame().setVisible(true);
    }
}