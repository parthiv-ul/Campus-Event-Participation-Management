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

        add(panel);
    }

    public static void main(String[] args) {
        new EventManagementFrame().setVisible(true);
    }
}