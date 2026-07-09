public class TemperatureLevel {
    public static void main(String[] args) {

        int temperature = 25;

        if (temperature < 15) {
            System.out.println("Temperature: Cold");
        } else if (temperature < 28) {
            System.out.println("Temperature: Comfortable");
        } else {
            System.out.println("Temperature: Hot");
        }

    }
}