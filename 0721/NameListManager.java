import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();

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
                    addName(sc, nameList);
                    break;
                case 2:
                    searchName(sc, nameList);
                    break;
                case 3:
                    modifyName(sc, nameList);
                    break;
                case 4:
                    deleteName(sc, nameList);
                    break;
                case 5:
                    showAll(nameList);
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
        System.out.println("\n===== 名單管理 =====");
        System.out.println("1. 新增姓名");
        System.out.println("2. 搜尋姓名");
        System.out.println("3. 修改姓名");
        System.out.println("4. 刪除姓名");
        System.out.println("5. 列出全部");
        System.out.println("0. 離開");
        System.out.print("請選擇：");
    }

    // 新增姓名
    public static void addName(Scanner sc, ArrayList<String> list) {

        System.out.print("請輸入姓名：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("姓名不可空白！");
            return;
        }

        list.add(name);
        System.out.println("新增成功！");
    }

    // 搜尋姓名
    public static void searchName(Scanner sc, ArrayList<String> list) {

        System.out.print("請輸入要搜尋的姓名：");
        String name = sc.nextLine();

        for (String item : list) {
            if (item.equalsIgnoreCase(name)) {
                System.out.println("找到：" + item);
                return;
            }
        }

        System.out.println("查無此姓名！");
    }

    // 修改姓名
    public static void modifyName(Scanner sc, ArrayList<String> list) {

        System.out.print("請輸入要修改的姓名：");
        String oldName = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equalsIgnoreCase(oldName)) {

                System.out.print("請輸入新的姓名：");
                String newName = sc.nextLine().trim();

                if (newName.isEmpty()) {
                    System.out.println("姓名不可空白！");
                    return;
                }

                list.set(i, newName);
                System.out.println("修改成功！");
                return;
            }
        }

        System.out.println("查無此姓名！");
    }

    // 刪除姓名
    public static void deleteName(Scanner sc, ArrayList<String> list) {

        System.out.print("請輸入要刪除的姓名：");
        String name = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equalsIgnoreCase(name)) {
                list.remove(i);
                System.out.println("刪除成功！");
                return;
            }
        }

        System.out.println("找不到該姓名！");
    }

    // 列出全部
    public static void showAll(ArrayList<String> list) {

        if (list.isEmpty()) {
            System.out.println("目前沒有任何資料！");
            return;
        }

        System.out.println("\n===== 全部名單 =====");

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
