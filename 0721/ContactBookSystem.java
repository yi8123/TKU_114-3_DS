import java.util.ArrayList;
import java.util.Scanner;

public class ContactBookSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        int choice;

        do {

            showMenu();

            while (!sc.hasNextInt()) {
                System.out.println("請輸入數字選項！");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addContact(sc, contacts);
                    break;

                case 2:
                    searchContact(sc, contacts);
                    break;

                case 3:
                    updatePhone(sc, contacts);
                    break;

                case 4:
                    deleteContact(sc, contacts);
                    break;

                case 5:
                    showAllContacts(contacts);
                    break;

                case 0:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("無此選項！");
            }


        } while (choice != 0);


        sc.close();
    }


    // 顯示選單
    public static void showMenu() {

        System.out.println("\n===== 聯絡人管理系統 =====");
        System.out.println("1. 新增聯絡人");
        System.out.println("2. 搜尋聯絡人");
        System.out.println("3. 修改電話");
        System.out.println("4. 刪除聯絡人");
        System.out.println("5. 顯示全部");
        System.out.println("0. 離開");
        System.out.print("請選擇：");
    }



    // 新增聯絡人
    public static void addContact(Scanner sc, ArrayList<Contact> list) {

        System.out.print("請輸入代碼：");
        String code = sc.nextLine().trim();


        if (code.isEmpty()) {
            System.out.println("代碼不可空白！");
            return;
        }


        if (findByCode(code, list) != null) {
            System.out.println("代碼已存在！");
            return;
        }


        System.out.print("請輸入姓名：");
        String name = sc.nextLine().trim();


        if (name.isEmpty()) {
            System.out.println("姓名不可空白！");
            return;
        }


        System.out.print("請輸入電話：");
        String phone = sc.nextLine();


        System.out.print("請輸入Email：");
        String email = sc.nextLine();


        Contact contact =
                new Contact(code, name, phone, email);


        list.add(contact);

        System.out.println("新增成功！");
    }



    // 搜尋聯絡人
    public static void searchContact(Scanner sc, ArrayList<Contact> list) {

        System.out.print("請輸入聯絡人代碼：");
        String code = sc.nextLine();


        Contact contact = findByCode(code, list);


        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("找不到聯絡人！");
        }

    }



    // 修改電話
    public static void updatePhone(Scanner sc, ArrayList<Contact> list) {

        System.out.print("請輸入聯絡人代碼：");
        String code = sc.nextLine();


        Contact contact = findByCode(code, list);


        if (contact == null) {
            System.out.println("找不到聯絡人！");
            return;
        }


        System.out.print("請輸入新電話：");
        String phone = sc.nextLine();


        contact.setPhone(phone);

        System.out.println("電話修改成功！");
    }



    // 刪除聯絡人
    public static void deleteContact(Scanner sc, ArrayList<Contact> list) {

        System.out.print("請輸入聯絡人代碼：");
        String code = sc.nextLine();


        Contact contact = findByCode(code, list);


        if (contact != null) {

            list.remove(contact);

            System.out.println("刪除成功！");

        } else {

            System.out.println("找不到聯絡人！");
        }

    }



    // 顯示全部聯絡人
    public static void showAllContacts(ArrayList<Contact> list) {


        if (list.isEmpty()) {

            System.out.println("目前沒有聯絡人資料！");
            return;
        }


        System.out.println("\n===== 聯絡人清單 =====");


        for (Contact contact : list) {

            System.out.println(contact);

        }

    }



    // 依代碼搜尋
    public static Contact findByCode(String code, ArrayList<Contact> list) {


        for (Contact contact : list) {

            if (contact.getCode().equalsIgnoreCase(code)) {

                return contact;

            }
        }


        return null;
    }

}