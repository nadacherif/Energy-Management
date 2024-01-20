public class Battery extends Component{
    //capacity of the battery in kWh
    private int capacity;

    public int getCapacity() {
        return capacity;
    }
    public  Battery (int capacity){
        this.capacity=capacity;
    }

    @Override
    public String getDetails() {
        return "Battery: Capacity = " + capacity + " kWh";
    }


}
