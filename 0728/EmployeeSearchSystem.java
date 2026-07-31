public class EmployeeSearchSystem {
    
    public static int binarySearchEmployee(Employee[] employees, int targetId) {
        if (employees == null || employees.length == 0) {
            return -1;
        }
        
        int low = 0;
        int high = employees.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (employees[mid].getId() == targetId) {
                return mid;
            } else if (employees[mid].getId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void searchAndPrint(Employee[] employees, int id) {
        System.out.println("正在查詢員工編號: " + id);
        int index = binarySearchEmployee(employees, id);
        if (index != -1) {
            System.out.println("【系統查獲資料】-> " + employees[index]);
        } else {
            System.out.println("【系統訊息】查無此員工編號！");
        }
        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) {
        Employee[] list = {
            new Employee(1001, "張三", "資訊部", "8801"),
            new Employee(1005, "李四", "行銷部", "8805"),
            new Employee(1010, "王五", "財務部", "8810"),
            new Employee(1012, "趙六", "人事部", "8812")
        };

        System.out.println("--- 課後作業三：員工編號查詢系統 ---");
        searchAndPrint(list, 1005);
        searchAndPrint(list, 1001);
        searchAndPrint(list, 1012);
        searchAndPrint(list, 9999);
        searchAndPrint(new Employee[]{}, 1001);
    }
}