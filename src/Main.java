public class Main {
    public static void main(String[] args) {

        Battery battery1 = new Battery(110);
        Battery battery2 = new Battery(150);
        Battery battery3 = new Battery(450);
        SolarPanel solarPanel1 = new SolarPanel(50);

        // Création du gestionnaire d'énergie
        EnergyManager energyManager = new EnergyManager();
        SolarPanel solarPanel = new SolarPanel();

        // Ajout des composants au gestionnaire
        energyManager.addComponent(battery1);
        energyManager.addComponent(battery2);
        energyManager.removeComponent(battery1);
        energyManager.addComponent(battery3);
        energyManager.addComponent(solarPanel1);

        for (Component component : energyManager.getComponents()) {
            System.out.println(component.getDetails());
        }
        // Calcul de la capacité totale des batteries
        int totalCapacity = energyManager.calculateTotalCapacity();
        System.out.println("Total Battery Capacity: " + totalCapacity + " kWh");


    }
}