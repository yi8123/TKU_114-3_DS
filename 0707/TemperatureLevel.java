public class TemperatureLevel {
    public static void main(String[] args){
        int temperature = 34;
        if (temperature < 15) {
            System.out.println("Temperature Level: Cold");
        } else if (temperature < 28) {
            System.out.println("Temperature Level: Comfortable");
        } else if (temperature > 28) {
            System.out.println("Temperature Level: Hot");
        } 

    }
}
