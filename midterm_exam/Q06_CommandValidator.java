public class Q06_CommandValidator {
    public static void main(String[] args) {
        String[] commands = {
            "START",
            new String("stop"),
            "  Pause  ",
            "RUN",
            "   ",
            null
        };
        for (String command : commands) {
            System.out.println(command + " -> " + isValidCommand(command));
        }
    }

    public static boolean isValidCommand(String command) {
        if (command == null) {
            return false;
        }
        // 去除前後空白並轉為大寫比對
        String trimmed = command.trim().toUpperCase();
        return trimmed.equals("START") || trimmed.equals("STOP") || trimmed.equals("PAUSE");
    }
}