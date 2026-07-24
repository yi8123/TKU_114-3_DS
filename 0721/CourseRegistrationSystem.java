import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();

        int choice;



        do {


            showMenu();


            while(!sc.hasNextInt()) {

                System.out.println("請輸入數字選項！");
                sc.next();

            }


            choice = sc.nextInt();

            sc.nextLine();




            switch(choice) {


                case 1:

                    addCourse(sc, courses);

                    break;



                case 2:

                    registerCourse(sc, courses);

                    break;



                case 3:

                    cancelCourse(sc, courses);

                    break;



                case 4:

                    deleteCourse(sc, courses);

                    break;



                case 5:

                    searchCourse(sc, courses);

                    break;



                case 6:

                    showStatistics(courses);

                    break;



                case 7:

                    showAllCourses(courses);

                    break;



                case 0:

                    System.out.println("程式結束！");

                    break;



                default:

                    System.out.println("無此選項！");

            }



        } while(choice != 0);



        sc.close();

    }







    // 選單
    public static void showMenu() {


        System.out.println("\n===== 選課管理系統 =====");

        System.out.println("1. 新增課程");

        System.out.println("2. 選課");

        System.out.println("3. 退選");

        System.out.println("4. 刪除課程");

        System.out.println("5. 搜尋課程");

        System.out.println("6. 統計資料");

        System.out.println("7. 顯示全部課程");

        System.out.println("0. 離開");

        System.out.print("請選擇：");


    }








    // 新增課程
    public static void addCourse(Scanner sc, ArrayList<Course> courses) {


        System.out.print("請輸入課程代碼：");

        String code = sc.nextLine();



        if(findCourse(code, courses) != null) {

            System.out.println("課程代碼不可重複！");
            return;

        }




        System.out.print("請輸入課程名稱：");

        String name = sc.nextLine();



        if(name.trim().isEmpty()) {

            System.out.println("課程名稱不可空白！");
            return;

        }





        System.out.print("請輸入容量：");

        int capacity = sc.nextInt();

        sc.nextLine();




        if(capacity <= 0) {

            System.out.println("容量必須大於0！");
            return;

        }




        courses.add(new Course(code, name, capacity));


        System.out.println("新增成功！");


    }









    // 選課
    public static void registerCourse(Scanner sc, ArrayList<Course> courses) {


        System.out.print("請輸入課程代碼：");

        String code = sc.nextLine();



        Course course = findCourse(code, courses);



        if(course == null) {

            System.out.println("找不到課程！");
            return;

        }




        if(course.addStudent()) {

            System.out.println("選課成功！");

        } else {

            System.out.println("課程已額滿！");

        }

    }









    // 退選
    public static void cancelCourse(Scanner sc, ArrayList<Course> courses) {


        System.out.print("請輸入課程代碼：");

        String code = sc.nextLine();



        Course course = findCourse(code, courses);



        if(course == null) {

            System.out.println("找不到課程！");
            return;

        }




        if(course.removeStudent()) {

            System.out.println("退選成功！");

        } else {

            System.out.println("目前沒有人選此課程！");

        }


    }









    // 刪除課程
    public static void deleteCourse(Scanner sc, ArrayList<Course> courses) {


        System.out.print("請輸入課程代碼：");

        String code = sc.nextLine();



        Course course = findCourse(code, courses);



        if(course != null) {

            courses.remove(course);

            System.out.println("刪除成功！");


        } else {


            System.out.println("找不到課程！");

        }

    }









    // 搜尋課程
    public static void searchCourse(Scanner sc, ArrayList<Course> courses) {


        System.out.print("請輸入課程代碼：");

        String code = sc.nextLine();



        Course course = findCourse(code, courses);



        if(course != null) {

            System.out.println(course);

        } else {

            System.out.println("找不到課程！");

        }


    }









    // 顯示全部課程
    public static void showAllCourses(ArrayList<Course> courses) {


        if(courses.isEmpty()) {

            System.out.println("目前沒有課程資料！");
            return;

        }



        System.out.println("\n===== 課程列表 =====");



        for(Course course : courses) {

            System.out.println(course);

        }

    }









    // 統計資料
    public static void showStatistics(ArrayList<Course> courses) {


        int totalPeople = 0;


        System.out.println("\n===== 統計資料 =====");

        System.out.println("總課程數：" + courses.size());



        for(Course course : courses) {


            totalPeople += course.getCurrentPeople();


        }



        System.out.println("總選課人次：" + totalPeople);



        System.out.println("===== 額滿課程 =====");



        boolean found = false;



        for(Course course : courses) {


            if(course.isFull()) {


                System.out.println(course);


                found = true;

            }


        }




        if(!found) {

            System.out.println("目前沒有額滿課程！");

        }


    }









    // 搜尋課程
    public static Course findCourse(String code, ArrayList<Course> courses) {


        for(Course course : courses) {


            if(course.getCode().equalsIgnoreCase(code)) {

                return course;

            }

        }


        return null;

    }


}