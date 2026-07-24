import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Equipment> equipmentList = new ArrayList<>();

        int choice;

        do {
            showMenu();

            while (!sc.hasNextInt()) {
                System.out.println("請輸入正確的選項！");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine(); // 清除換行

            switch (choice) {
                case 1:
                    addEquipment(sc, equipmentList);
                    break;
                case 2:
                    searchEquipment(sc, equipmentList);
                    break;
                case 3:
                    borrowEquipment(sc, equipmentList);
                    break;
                case 4:
                    returnEquipment(sc, equipmentList);
                    break;
                case 5:
                    showAvailableEquipment(equipmentList);
                    break;
                case 0:
                    System.out.println("程式結束！");
                    break;
                default:
                    System.out.println("查無此選項！");
            }

        } while (choice != 0);

        sc.close();
    }

    // 顯示選單
    public static void showMenu() {
        System.out.println("\n===== 設備管理系統 =====");
        System.out.println("1. 新增設備");
        System.out.println("2. 搜尋設備");
        System.out.println("3. 借出設備");
        System.out.println("4. 歸還設備");
        System.out.println("5. 列出可借設備");
        System.out.println("0. 離開");
        System.out.print("請選擇：");
    }

    // 新增設備
    public static void addEquipment(Scanner sc, ArrayList<Equipment> list) {

        System.out.print("請輸入設備代碼：");
        String code = sc.nextLine().trim();

        if (code.isEmpty()) {
            System.out.println("設備代碼不可空白！");
            return;
        }

        if (findEquipment(code, list) != null) {
            System.out.println("設備代碼不可重複！");
            return;
        }

        System.out.print("請輸入設備名稱：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("設備名稱不可空白！");
            return;
        }

        list.add(new Equipment(code, name));
        System.out.println("新增成功！");
    }

    // 搜尋設備
    public static void searchEquipment(Scanner sc, ArrayList<Equipment> list) {

        System.out.print("請輸入設備代碼：");
        String code = sc.nextLine();

        Equipment equipment = findEquipment(code, list);

        if (equipment != null) {
            System.out.println(equipment);
        } else {
            System.out.println("找不到設備！");
        }
    }

    // 借出設備
    public static void borrowEquipment(Scanner sc, ArrayList<Equipment> list) {

        System.out.print("請輸入設備代碼：");
        String code = sc.nextLine();

        Equipment equipment = findEquipment(code, list);

        if (equipment == null) {
            System.out.println("找不到設備！");
            return;
        }

        if (!equipment.isAvailable()) {
            System.out.println("此設備已借出！");
            return;
        }

        equipment.setAvailable(false);
        System.out.println("借出成功！");
    }

    // 歸還設備
    public static void returnEquipment(Scanner sc, ArrayList<Equipment> list) {

        System.out.print("請輸入設備代碼：");
        String code = sc.nextLine();

        Equipment equipment = findEquipment(code, list);

        if (equipment == null) {
            System.out.println("找不到設備！");
            return;
        }

        if (equipment.isAvailable()) {
            System.out.println("此設備尚未借出！");
            return;
        }

        equipment.setAvailable(true);
        System.out.println("歸還成功！");
    }

    // 列出可借設備
    public static void showAvailableEquipment(ArrayList<Equipment> list) {

        if (list.isEmpty()) {
            System.out.println("目前沒有設備資料！");
            return;
        }

        boolean found = false;

        System.out.println("\n===== 可借設備 =====");

        for (Equipment equipment : list) {
            if (equipment.isAvailable()) {
                System.out.println(equipment);
                found = true;
            }
        }

        if (!found) {
            System.out.println("目前沒有可借設備！");
        }
    }

    // 依代碼搜尋設備
    public static Equipment findEquipment(String code, ArrayList<Equipment> list) {

        for (Equipment equipment : list) {
            if (equipment.getCode().equalsIgnoreCase(code)) {
                return equipment;
            }
        }

        return null;
    }
}