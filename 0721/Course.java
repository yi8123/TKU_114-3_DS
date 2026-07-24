public class Course {

    private String code;
    private String name;
    private int capacity;
    private int currentPeople;


    // 建構子
    public Course(String code, String name, int capacity) {

        this.code = code;
        this.name = name;
        this.capacity = capacity;
        this.currentPeople = 0;

    }



    // Getter

    public String getCode() {

        return code;

    }


    public String getName() {

        return name;

    }


    public int getCapacity() {

        return capacity;

    }


    public int getCurrentPeople() {

        return currentPeople;

    }




    // 選課
    public boolean addStudent() {


        if(currentPeople < capacity) {

            currentPeople++;

            return true;

        }


        return false;

    }





    // 退選
    public boolean removeStudent() {


        if(currentPeople > 0) {

            currentPeople--;

            return true;

        }


        return false;

    }





    // 判斷是否額滿
    public boolean isFull() {

        return currentPeople >= capacity;

    }






    @Override
    public String toString() {


        return "代碼：" + code +
                "　課程：" + name +
                "　容量：" + capacity +
                "　目前人數：" + currentPeople;


    }

}