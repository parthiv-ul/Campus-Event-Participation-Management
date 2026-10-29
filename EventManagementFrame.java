import javax.swing.*;
import java.awt.*;

public class EventManagementFrame extends JFrame {

    public EventManagementFrame() {

        setTitle("Event Management");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("EVENT MANAGEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        // Event ID
        JLabel idLabel = new JLabel("Event ID:");
        JTextField idField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(idLabel, gbc);

        gbc.gridx = 1;
        panel.add(idField, gbc);

        // Event Name
        JLabel nameLabel = new JLabel("Event Name:");
        JTextField nameField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        panel.add(nameField, gbc);

        // Event Type
        JLabel typeLabel = new JLabel("Event Type:");

        String[] eventTypes = {
            "Technical",
            "Cultural",
            "Sports"
        };

        JComboBox<String> typeComboBox =
                new JComboBox<>(eventTypes);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(typeLabel, gbc);

        gbc.gridx = 1;
        panel.add(typeComboBox, gbc);

        // Date
        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(dateLabel, gbc);

        gbc.gridx = 1;
        panel.add(dateField, gbc);

        // Time
        JLabel timeLabel = new JLabel("Time:");
        JTextField timeField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(timeLabel, gbc);

        gbc.gridx = 1;
        panel.add(timeField, gbc);

        // Venue
        JLabel venueLabel = new JLabel("Venue:");
        JTextField venueField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(venueLabel, gbc);

        gbc.gridx = 1;
        panel.add(venueField, gbc);

        // Maximum Participants
        JLabel capacityLabel = new JLabel("Maximum Participants:");
        JTextField capacityField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(capacityLabel, gbc);

        gbc.gridx = 1;
        panel.add(capacityField, gbc);

        // Description
        JLabel descriptionLabel = new JLabel("Description:");

        JTextArea descriptionArea = new JTextArea(4, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        JScrollPane descriptionScrollPane =
                new JScrollPane(descriptionArea);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(descriptionLabel, gbc);

        gbc.gridx = 1;
        panel.add(descriptionScrollPane, gbc);

        JButton saveButton = new JButton("Save");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        actionPanel.add(saveButton);
        actionPanel.add(updateButton);
        actionPanel.add(deleteButton);
        actionPanel.add(clearButton);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(actionPanel, gbc);

        JButton dashboardButton = new JButton("Dashboard");
        gbc.gridy = 10;
        panel.add(dashboardButton, gbc);

        saveButton.addActionListener(e -> saveEvent(idField, nameField,
                typeComboBox, dateField, timeField, venueField, capacityField,
                descriptionArea, false));
        updateButton.addActionListener(e -> saveEvent(idField, nameField,
                typeComboBox, dateField, timeField, venueField, capacityField,
                descriptionArea, true));
        deleteButton.addActionListener(e -> {
            try {
                CampusEventStore.deleteEvent(idField.getText());
                JOptionPane.showMessageDialog(this, "Event deleted.");
                clearFields(idField, nameField, dateField, timeField, venueField,
                        capacityField, descriptionArea);
            } catch (IllegalArgumentException ex) {
                showError(ex.getMessage());
            }
        });
        clearButton.addActionListener(e -> clearFields(idField, nameField, dateField,
                timeField, venueField, capacityField, descriptionArea));
        dashboardButton.addActionListener(e -> AppNavigation.returnToDashboard(this));

        add(panel);
    }

    private void saveEvent(JTextField idField, JTextField nameField,
            JComboBox<String> typeComboBox, JTextField dateField,
            JTextField timeField, JTextField venueField, JTextField capacityField,
            JTextArea descriptionArea, boolean update) {
        try {
            int capacity = Integer.parseInt(capacityField.getText().trim());
            if (capacity <= 0) {
                throw new IllegalArgumentException("Maximum Participants must be greater than zero.");
            }
            CampusEventStore.Event event = new CampusEventStore.Event(
                    idField.getText().trim(), nameField.getText().trim(),
                    (String) typeComboBox.getSelectedItem(), dateField.getText().trim(),
                    timeField.getText().trim(), venueField.getText().trim(), capacity,
                    descriptionArea.getText().trim());
            if (update) {
                CampusEventStore.updateEvent(event);
            } else {
                CampusEventStore.saveEvent(event);
            }
            JOptionPane.showMessageDialog(this, update ? "Event updated." : "Event saved.");
        } catch (NumberFormatException ex) {
            showError("Maximum Participants must be a whole number.");
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        }
    }

    private void clearFields(JTextField idField, JTextField nameField,
            JTextField dateField, JTextField timeField, JTextField venueField,
            JTextField capacityField, JTextArea descriptionArea) {
        idField.setText("");
        nameField.setText("");
        dateField.setText("");
        timeField.setText("");
        venueField.setText("");
        capacityField.setText("");
        descriptionArea.setText("");
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Event Management",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new EventManagementFrame().setVisible(true);
    }
}