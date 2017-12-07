package patterns.decorator;

/**
 * Created by umamaheshwar on 27/11/2017.
 */
public class LuxaryCar extends CarDecorator {

    public LuxaryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Assemble luxary car");
    }
}
