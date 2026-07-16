public class Q01_ParkingFeeFix {
    public static int calculateFee(int minutes) {

        if (minutes < 0) {
        return -1;
        }

        if (minutes <= 30) {
        return 0;
        }

        int fee;

        if (minutes <= 120) {
        fee = ((minutes - 31) / 30 + 1) * 20;
        } else {
        fee = 60 + ((minutes - 121) / 60 + 1) * 30;
        }

        if (fee > 180) {
        fee = 180;
        }

        return fee;
    }
}
