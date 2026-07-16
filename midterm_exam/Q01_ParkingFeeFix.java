public class Q01_ParkingFeeFix {
    public static void main(String[] args) {
        int[] testMinutes = {-20, 30, 31, 60, 61, 120, 121, 420};
        
        for (int minutes : testMinutes) {
            int fee = calculateFee(minutes);
            System.out.println("停車 " + minutes + " 分鐘, 費用 : " + fee + " 元");
        }
    }

    public static int calculateFee(int minutes) {
        if (minutes < 0) {
            return -1;
        }
        if (minutes <= 30) {
            return 0;
        }
        
        int fee = 0;
        if (minutes <= 120) {
            // 超過30分鐘的部分，每開始30分鐘收20元
            int overMinutes = minutes - 30;
            int time = (overMinutes + 29) / 30;
            fee = time * 20;
        } else {
            // 超過120分鐘，前120分鐘收60元，之後每開始60分鐘加收30元
            int overMinutes = minutes - 120;
            int time = (overMinutes + 59) / 60;
            fee = 60 + (time * 30);
        }
        
        // 單次最高收費 180 元
        if (fee > 180) {
            fee = 180;
        }
        
        return fee;
    }
}