package patterns.decorator;

/**
 * Created by umamaheshwar on 27/11/2017.
 */
public class CarDecorator implements Car {

    private Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}
