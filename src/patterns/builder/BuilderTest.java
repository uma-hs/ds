package patterns.builder;

/**
 * Created by umamaheshwar on 27/11/2017.
 */
public class BuilderTest {
    public static void main(String args[]) {
        Computer computer = new Computer.ComputerBuilder().setGraphics("NVIDIA").setRam("SAMSUNG 16 GB").setSsd("500 GB SANDISK").setWirelessEnabled(false).build();
        System.out.println(computer);
    }
}
