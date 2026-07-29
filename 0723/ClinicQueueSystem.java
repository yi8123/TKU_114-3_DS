import java.util.*;

public class ClinicQueueSystem {
    private Queue<Patient> waitingQueue = new LinkedList<>();
    private Set<Integer> existingNumbers = new HashSet<>();
    private Map<String, Integer> deptWaitingCount = new HashMap<>();
    private int totalServedCount = 0;

    public void register(int number, String name, String department) {
        if (existingNumbers.contains(number)) {
            System.out.println("【錯誤】號碼 " + number + " 已被使用，掛號失敗！");
            return;
        }
        Patient p = new Patient(number, name, department);
        waitingQueue.offer(p);
        existingNumbers.add(number);
        
        deptWaitingCount.put(department, deptWaitingCount.getOrDefault(department, 0) + 1);
        System.out.println("掛號成功: [" + department + "] " + number + "號 " + name);
    }

    public void callPatient() {
        if (waitingQueue.isEmpty()) {
            System.out.println("【提示】目前沒有人在等待就診。");
            return;
        }
        Patient p = waitingQueue.poll();
        existingNumbers.remove(p.getNumber());
        totalServedCount++;
        
        deptWaitingCount.put(p.getDepartment(), deptWaitingCount.get(p.getDepartment()) - 1);
        
        System.out.println("【叫號】請 " + p.getNumber() + " 號 " + p.getName() + " 前往 [" + p.getDepartment() + "] 看診。");
    }

    public void peekNext() {
        if (waitingQueue.isEmpty()) {
            System.out.println("等待隊列目前為空。");
        } else {
            Patient p = waitingQueue.peek();
            System.out.println("下一位就診者: " + p.getNumber() + " 號 " + p.getName() + " (" + p.getDepartment() + ")");
        }
    }

    public void printReport() {
        System.out.println("\n========== 診所狀態報表 ==========");
        System.out.println("總服務完成人數: " + totalServedCount + " 人");
        System.out.println("各科別目前等待人數:");
        for (Map.Entry<String, Integer> entry : deptWaitingCount.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue() + " 人");
        }
        System.out.println("==================================");
    }

    public static void main(String[] args) {
        ClinicQueueSystem clinic = new ClinicQueueSystem();

        clinic.register(101, "張三", "內科");
        clinic.register(102, "李四", "小兒科");
        clinic.register(101, "王五", "外科");
        clinic.register(103, "趙六", "內科");

        clinic.peekNext();
        clinic.printReport();

        clinic.callPatient();
        clinic.callPatient();
        
        clinic.printReport();
    }
}