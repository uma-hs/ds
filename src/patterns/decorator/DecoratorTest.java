package patterns.decorator;

/**
 * Created by umamaheshwar on 27/11/2017.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Car car = new BasicCar();
        car = new SportsCar(car);
        car.assemble();


        Car lux = new BasicCar();
        lux = new LuxaryCar(lux);
        lux.assemble();
    }
}
