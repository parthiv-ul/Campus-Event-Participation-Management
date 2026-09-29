
import javax.swing.*;
import java.awt.*;

public class EventDetailsFrame extends JFrame {

    public EventDetailsFrame() {

        setTitle("Event Details");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("EVENT DETAILS");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        // Event ID
        // Event ID
gbc.gridwidth = 1;
gbc.gridy = 1;

panel.add(new JLabel("Event ID:"), gbc);
        JTextField idField = new JTextField(20);
        idField.setEditable(false);
        gbc.gridx = 1;
        panel.add(idField, gbc);

        // Event Name
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Event Name:"), gbc);
        JTextField nameField = new JTextField(20);
        nameField.setEditable(false);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        // Event Type
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Event Type:"), gbc);
        JTextField typeField = new JTextField(20);
        typeField.setEditable(false);
        gbc.gridx = 1;
        panel.add(typeField, gbc);

        // Date
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Date:"), gbc);
        JTextField dateField = new JTextField(20);
        dateField.setEditable(false);
        gbc.gridx = 1;
        panel.add(dateField, gbc);

        // Time
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Time:"), gbc);
        JTextField timeField = new JTextField(20);
        timeField.setEditable(false);
        gbc.gridx = 1;
        panel.add(timeField, gbc);

        // Venue
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Venue:"), gbc);
        JTextField venueField = new JTextField(20);
        venueField.setEditable(false);
        gbc.gridx = 1;
        panel.add(venueField, gbc);

        // Coordinator
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Coordinator:"), gbc);
        JTextField coordinatorField = new JTextField(20);
        coordinatorField.setEditable(false);
        gbc.gridx = 1;
        panel.add(coordinatorField, gbc);

        // Maximum Participants
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Maximum Participants:"), gbc);
        JTextField capacityField = new JTextField(20);
        capacityField.setEditable(false);
        gbc.gridx = 1;
        panel.add(capacityField, gbc);

        // Registered Participants
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("Registered Participants:"), gbc);
        JTextField registeredField = new JTextField(20);
        registeredField.setEditable(false);
        gbc.gridx = 1;
        panel.add(registeredField, gbc);

        // Event Status
        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(new JLabel("Event Status:"), gbc);
        JTextField statusField = new JTextField(20);
        statusField.setEditable(false);
        gbc.gridx = 1;
        panel.add(statusField, gbc);

        // Description
        gbc.gridx = 0;
        gbc.gridy = 11;
        panel.add(new JLabel("Description:"), gbc);

        JTextArea descriptionArea = new JTextArea(4, 20);
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(descriptionArea);

        gbc.gridx = 1;
        panel.add(scrollPane, gbc);

        add(panel);
    }

    public static void main(String[] args) {
        new EventDetailsFrame().setVisible(true);
    }
}