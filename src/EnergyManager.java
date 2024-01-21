import java.util.ArrayList;
import java.util.List;

public class EnergyManager {
    private List<Component> components;

    // Constructeur du gestionnaire d'énergie
    public EnergyManager() {
        this.components = new ArrayList<>();
    }

    public List<Component> getComponents() {
        return components;
    }

    // Méthode pour ajouter un composant au gestionnaire
    public void addComponent(Component component) {
        components.add(component);
    }

    // Méthode pour supprimer un composant du gestionnaire
    public void removeComponent(Component component) {
        components.remove(component);
    }

    // Méthode pour calculer la capacité totale des batteries gérées
    public int calculateTotalCapacity() {
        int totalCapacity = 0;
        for (Component component : components) {
            if (component instanceof Battery) {
                totalCapacity += ((Battery) component).getCapacity();
            }

        }
        return totalCapacity;
    }
    // Additional method to calculate total generated and consumed power
    public int calculateTotalGeneratedPower() {
        int totalGeneratedPower = 0;
        for (Component component : components) {
            if (component instanceof SolarPanel) {
                totalGeneratedPower += ((SolarPanel) component).generatePower();
            }
        }
        return totalGeneratedPower;
    }
}
