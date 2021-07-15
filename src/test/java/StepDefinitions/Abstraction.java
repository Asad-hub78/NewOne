package StepDefinitions;
abstract class Truck {
    String weight;

    public void speed() {
        System.out.println("200");
    }
    public abstract void model();
}
class TruckIn extends Truck{
    public void model(){
        System.out.println("2020");
    }
}

public class Abstraction {
    public static void main(String[] args) {
 TruckIn t = new TruckIn();
 t.speed();
 t.model();

    }
}
