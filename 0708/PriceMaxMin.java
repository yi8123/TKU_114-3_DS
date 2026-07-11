public class PriceMaxMin {
    public static void main(String[] args){
        int cookie = 30;
        int candy = 10;
        int cake = 80;

        int max = cookie;
        int min = cookie;

        if (candy > max) {
            max = candy;
        }

        if (cake > max) {
            max = cake;
        }

        if (candy < min) {
            min = candy;
        }
        
        if (cake < min)  {
            min = cake;
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
