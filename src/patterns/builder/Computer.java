package patterns.builder;

/**
 * Created by umamaheshwar on 27/11/2017.
 */
public class Computer {
    private String ram;
    private String graphics;
    private String ssd;
    private boolean wirelessEnabled;

    public Computer(ComputerBuilder builder) {
        this.ram = builder.ram;
        this.graphics = builder.graphics;
        this.ssd = builder.ssd;
        this.wirelessEnabled=builder.wirelessEnabled;
    }
    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public boolean isWirelessEnabled() {
        return wirelessEnabled;
    }

    public void setWirelessEnabled(boolean wirelessEnabled) {
        this.wirelessEnabled = wirelessEnabled;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RAM : "+this.ram).append("\n");
        sb.append("GRAPHICS : "+this.graphics).append("\n");
        sb.append("SSD : "+this.ssd).append("\n");
        sb.append("WIRELESS : "+this.wirelessEnabled);
        return sb.toString();
    }

    public static class ComputerBuilder {

        private String ram;
        private String graphics;
        private String ssd;
        private boolean wirelessEnabled;

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }



        public ComputerBuilder setGraphics(String graphics) {
            this.graphics = graphics;
            return this;
        }



        public ComputerBuilder setSsd(String ssd) {
            this.ssd = ssd;
            return this;
        }

        public ComputerBuilder setWirelessEnabled(boolean wirelessEnabled) {
            this.wirelessEnabled = wirelessEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }

    }
}
