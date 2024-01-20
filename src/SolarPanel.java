public class SolarPanel extends Component{
    //power generation capacity in kW
    private  int power;

    public SolarPanel(int power) {
        this.power=power;
    }
    public SolarPanel() {

    }


    @Override
    public String getDetails() {
        return "Solar Panel: Power Generation = " + power + " kW";
    }
    

    public int generatePower() {
        // Simulate power generation
        return power;
    }
}
