package StepDefinitions;

public class Car implements Vehicle{
    @Override
    public void speed() {
        System.out.println("200");
    }

    @Override
    public void mirror() {
System.out.println("2");
    }

    @Override
    public void tyres() {
System.out.println("4");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.speed();
        car.mirror();
        car.tyres();
    }
}
