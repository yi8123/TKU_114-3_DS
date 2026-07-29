import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CounterServiceSystem {
    private static class Customer {
        int number;
        String name;

        Customer(int number, String name) {
            this.number = number;
            this.name = name;
        }
    }

    private Queue<Customer> queue = new LinkedList<>();
    private List<String> historyLogs = new ArrayList<>();
    private int numberCounter = 1;

    public void takeNumber(String name) {
        Customer c = new Customer(numberCounter++, name);
        queue.offer(c);
        System.out.println("取號成功: 號碼 " + c.number + " 號，姓名: " + c.name);
    }

    public void callNext() {
        if (queue.isEmpty()) {
            System.out.println("【提示】目前沒有人在等待叫號。");
            return;
        }
        Customer c = queue.poll();
        String log = "服務紀錄: 號碼 " + c.number + " 號 [" + c.name + "] 已完成服務。";
        historyLogs.add(log);
        System.out.println("【叫號】請 " + c.number + " 號 " + c.name + " 到櫃檯服務。");
    }

    public void peekNext() {
        if (queue.isEmpty()) {
            System.out.println("目前等待隊列為空。");
        } else {
            Customer c = queue.peek();
            System.out.println("下一位等待者: " + c.number + " 號 " + c.name);
        }
    }

    public void showWaitingCount() {
        System.out.println("目前等待人數: " + queue.size() + " 人");
    }

    public static void main(String[] args) {
        CounterServiceSystem system = new CounterServiceSystem();

        system.callNext();
        system.takeNumber("Alice");
        system.takeNumber("Bob");
        system.showWaitingCount();
        system.peekNext();
        system.callNext();
        system.callNext();
        system.callNext();
    }
}