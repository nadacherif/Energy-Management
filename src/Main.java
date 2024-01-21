import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create instances of Battery and SolarPanel
        Battery battery1 = new Battery(110);
        Battery battery2 = new Battery(150);
        Battery battery3 = new Battery(450);
        SolarPanel solarPanel1 = new SolarPanel(50);
        SolarPanel solarPanel2 = new SolarPanel(50);

        // Create an instance of EnergyManager
        EnergyManager energyManager = new EnergyManager();

        // Add components to the manager
        energyManager.addComponent(battery1);
        energyManager.addComponent(battery2);
        energyManager.removeComponent(battery1);
        energyManager.addComponent(battery3);
        energyManager.addComponent(solarPanel1);
        energyManager.addComponent(solarPanel2);

        // Create a Swing UI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Energy Management System");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JTextArea componentDetails = new JTextArea(10, 30);
                componentDetails.setEditable(false);

                JButton calculateButton = new JButton("Calculate Totals");
                calculateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Update JTextArea with component details and totals
                        componentDetails.setText("");
                        for (Component component : energyManager.getComponents()) {
                            componentDetails.append(component.getDetails() + "\n");
                        }

                        int totalCapacity = energyManager.calculateTotalCapacity();
                        int totalGeneratedPower = energyManager.calculateTotalGeneratedPower();

                        componentDetails.append("\nTotal Battery Capacity: " + totalCapacity + " kWh\n");
                        componentDetails.append("Total Generated Power: " + totalGeneratedPower + " kW");
                    }
                });

                JPanel panel = new JPanel();
                panel.add(new JScrollPane(componentDetails));
                panel.add(calculateButton);

                frame.getContentPane().add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
