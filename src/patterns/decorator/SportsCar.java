package patterns.decorator;

/**
 * Created by umamaheshwar on 27/11/2017.
 */
public class SportsCar extends CarDecorator{


    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Assemble sport car");
    }
}
