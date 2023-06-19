import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Group[] groups = new Group[8];
        groups[0] = new Group(new City("Al Khor", "Al Bayt Stadium"), "Qatar", "Ecuador", "Senegal", "Netherlands", "A");

        groups[1] = new Group(new City("Doha", "Al Thumama Stadium"), "England", "Iran", "USA", "Wales", "B");

        groups[2] = new Group(new City("Lusail", "Lusail Stadium"), "Argentina", "Saudi Arabia", "Mexico", "Poland", "C");

        groups[3] = new Group(new City("Ar Rayyan", "Education City Stadium"), "France", "Australia", "Denmark", "Tunisia", "D");

        groups[4] = new Group(new City("Al Wakrah", "Al Janoub Stadium"), "Spain", "Costa Rica", "Germany", "Japan", "E");

        groups[5] = new Group(new City("Ar Rayyan", "Ahmad Bin Ali Stadium"), "Belgium", "Canada", "Morocco", "Croatia", "F");

        groups[6] = new Group(new City("Ar Rayyan", "Khalifa International Stadium"), "Brazil", "Serbia", "Switzerland", "Cameroon", "G");

        groups[7] = new Group(new City("Doha", "Stadium 974"), "Portugal", "Ghana", "Uruguay", "South Korea", "H");

        String name, id, address;
        int age, matchNumber, index, seatNumber;
        String category, area, group;
        JOptionPane.showMessageDialog(null, "Welcome! Enter Your Personal Info. ");
        JTextField nameField = new JTextField();
        JTextField idField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField addressField = new JTextField();
        Object[] fields = {"Name:", nameField, "National ID:", idField, "Age:", ageField, "Address:", addressField};
        int input = JOptionPane.showConfirmDialog(null, fields, "Personal Info", JOptionPane.OK_CANCEL_OPTION);
        if (input == JOptionPane.OK_OPTION) {
            name = nameField.getText();
            id = idField.getText();
            address = addressField.getText();
            age = Integer.parseInt(ageField.getText());
            if (age < 18) {
                JOptionPane.showMessageDialog(null, "You must be 18 years or older to book a ticket.");
                return;
            }
            Person owner = new Person(name, id, age);
            StringBuilder groupInfo = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                groupInfo.append(groups[i].getGroupName()).append("\n").append(groups[i].stringTeams()).append("\n");
            }
            JOptionPane.showMessageDialog(null, groupInfo.toString());
            group = (JOptionPane.showInputDialog("enter the letter for pref group"));
            index = getGroupIndex(group);
            while (index == 101) {
                while (index == 101) {
                    JOptionPane.showMessageDialog(null, "Invalid group name");
                    group = JOptionPane.showInputDialog("Enter the letter for pref group again");
                    index = getGroupIndex(group);
                }
            }
            JTextArea matchesArea = new JTextArea();
            matchesArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(matchesArea);
            scrollPane.setPreferredSize(new Dimension(300, 200));
            for (int i = 0; i < 6; i++) {
                matchesArea.append((i + 1) + "-" + groups[index].getMatch(i) + "\n------------------------\n");
            }
            JOptionPane.showMessageDialog(null, scrollPane, "Matches", JOptionPane.PLAIN_MESSAGE);
            String matchNumberInput = JOptionPane.showInputDialog("Enter Match number:");
            matchNumber = Integer.parseInt(matchNumberInput)-1;
            String[] categories = {"A", "B", "C"};
            category = (String) JOptionPane.showInputDialog(null, "Enter the letter for preferred category", "Ticket Booking", JOptionPane.PLAIN_MESSAGE, null, categories, categories[0]);
            area = "";
            switch (category) {
                case "A" -> area = "A";
                case "B" -> {
                    String[] areas = {"B1", "B2", "B3"};
                    area = (String) JOptionPane.showInputDialog(null, "Choose an area from", "Ticket Booking", JOptionPane.PLAIN_MESSAGE, null, areas, areas[0]);
                }
                case "C" -> {
                    String[] areas = {"C1", "C2"};
                    area = (String) JOptionPane.showInputDialog(null, "Choose an area from", "Ticket Booking", JOptionPane.PLAIN_MESSAGE, null, areas, areas[0]);
                }
            }
            Random random = new Random();
            seatNumber = random.nextInt(50000) + 1;
            Ticket ticket = new Ticket(groups[index], category, seatNumber, area, owner, matchNumber);
            JOptionPane.showMessageDialog(null, ticket, "Ticket Details", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, "Your ticket will be delivered to " + address, "Ticket Delivery", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static int getGroupIndex(String groupName) {
        return switch (groupName) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            case "E" -> 4;
            case "F" -> 5;
            case "G" -> 6;
            case "H" -> 7;
            default -> 101;
        };
    }
}