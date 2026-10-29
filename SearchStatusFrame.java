import javax.swing.*;
import java.awt.*;

public class SearchStatusFrame extends JFrame {

    public SearchStatusFrame() {

        setTitle("Search & Event Status");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("SEARCH & EVENT STATUS");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // Search By
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Search By:"), gbc);

        String[] searchOptions = {
            "Event ID",
            "Event Name",
            "Event Type"
        };

        JComboBox<String> searchComboBox =
                new JComboBox<>(searchOptions);

        gbc.gridx = 1;
        panel.add(searchComboBox, gbc);

        // Search Value
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Search Value:"), gbc);

        JTextField searchField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(searchField, gbc);

        // Event ID
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Event ID:"), gbc);

        JTextField eventIdField = new JTextField(20);
        eventIdField.setEditable(false);

        gbc.gridx = 1;
        panel.add(eventIdField, gbc);

        // Event Name
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Event Name:"), gbc);

        JTextField eventNameField = new JTextField(20);
        eventNameField.setEditable(false);

        gbc.gridx = 1;
        panel.add(eventNameField, gbc);

        // Event Type
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Event Type:"), gbc);

        JTextField eventTypeField = new JTextField(20);
        eventTypeField.setEditable(false);

        gbc.gridx = 1;
        panel.add(eventTypeField, gbc);

        // Event Status
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Event Status:"), gbc);

        JTextField statusField = new JTextField(20);
        statusField.setEditable(false);

        gbc.gridx = 1;
        panel.add(statusField, gbc);

        // Buttons
        JButton searchButton = new JButton("Search");
        JButton clearButton = new JButton("Clear");

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(searchButton, gbc);

        gbc.gridx = 1;
        panel.add(clearButton, gbc);

        JButton dashboardButton = new JButton("Dashboard");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        panel.add(dashboardButton, gbc);

        searchButton.addActionListener(e -> {
            String value = searchField.getText().trim();
            if (value.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter a search value.",
                        "Search", JOptionPane.WARNING_MESSAGE);
                return;
            }
            CampusEventStore.Event event = CampusEventStore.findEvent(
                    (String) searchComboBox.getSelectedItem(), value);
            if (event == null) {
                eventIdField.setText("");
                eventNameField.setText("");
                eventTypeField.setText("");
                statusField.setText("");
                JOptionPane.showMessageDialog(this, "No matching event was found.",
                        "Search", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            eventIdField.setText(event.id);
            eventNameField.setText(event.name);
            eventTypeField.setText(event.type);
            statusField.setText(
                    CampusEventStore.getRegistrationCount(event.id) >= event.capacity
                            ? "Full" : "Open");
        });

        clearButton.addActionListener(e -> {
            searchField.setText("");
            eventIdField.setText("");
            eventNameField.setText("");
            eventTypeField.setText("");
            statusField.setText("");
            searchComboBox.setSelectedIndex(0);
        });
        dashboardButton.addActionListener(e -> AppNavigation.returnToDashboard(this));

        add(panel);
    }

    public static void main(String[] args) {
        new SearchStatusFrame().setVisible(true);
    }
}
