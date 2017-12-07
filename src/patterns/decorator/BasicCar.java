package patterns.decorator;

/**
 * Created by umamaheshwar on 27/11/2017.
 */
public class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling basic car");
    }
}
