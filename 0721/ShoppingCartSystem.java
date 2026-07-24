import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        ArrayList<CartItem> cart = new ArrayList<>();

        int choice;


        do {

            showMenu();


            while (!sc.hasNextInt()) {

                System.out.println("請輸入數字選項！");
                sc.next();

            }


            choice = sc.nextInt();
            sc.nextLine();



            switch(choice) {


                case 1:
                    addItem(sc, cart);
                    break;


                case 2:
                    updateQuantity(sc, cart);
                    break;


                case 3:
                    removeItem(sc, cart);
                    break;


                case 4:
                    showCart(cart);
                    break;


                case 5:
                    calculateTotal(cart);
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





    // 顯示選單
    public static void showMenu() {


        System.out.println("\n===== 購物車系統 =====");

        System.out.println("1. 加入商品");

        System.out.println("2. 修改數量");

        System.out.println("3. 移除商品");

        System.out.println("4. 查看購物車");

        System.out.println("5. 計算總額");

        System.out.println("0. 離開");

        System.out.print("請選擇：");


    }






    // 加入商品
    public static void addItem(Scanner sc, ArrayList<CartItem> cart) {


        System.out.print("請輸入商品代碼：");
        String code = sc.nextLine();



        CartItem item = findItem(code, cart);



        if(item != null) {


            System.out.print("商品已存在，請輸入增加數量：");

            int quantity = sc.nextInt();
            sc.nextLine();



            if(quantity <= 0) {

                System.out.println("數量必須大於0！");
                return;

            }


            item.addQuantity(quantity);

            System.out.println("商品數量增加成功！");


        } else {


            System.out.print("請輸入商品名稱：");
            String name = sc.nextLine();



            System.out.print("請輸入單價：");
            int price = sc.nextInt();



            System.out.print("請輸入數量：");
            int quantity = sc.nextInt();

            sc.nextLine();



            if(price <= 0 || quantity <= 0) {

                System.out.println("價格與數量必須大於0！");
                return;

            }



            cart.add(new CartItem(code, name, price, quantity));


            System.out.println("加入成功！");


        }

    }







    // 修改數量
    public static void updateQuantity(Scanner sc, ArrayList<CartItem> cart) {


        System.out.print("請輸入商品代碼：");

        String code = sc.nextLine();



        CartItem item = findItem(code, cart);



        if(item == null) {

            System.out.println("找不到商品！");
            return;

        }



        System.out.print("請輸入新數量：");

        int quantity = sc.nextInt();

        sc.nextLine();



        if(quantity <= 0) {

            System.out.println("數量必須大於0！");
            return;

        }



        item.setQuantity(quantity);


        System.out.println("修改成功！");

    }








    // 移除商品
    public static void removeItem(Scanner sc, ArrayList<CartItem> cart) {


        System.out.print("請輸入商品代碼：");

        String code = sc.nextLine();



        CartItem item = findItem(code, cart);



        if(item != null) {


            cart.remove(item);

            System.out.println("移除成功！");


        } else {


            System.out.println("找不到商品！");

        }


    }








    // 顯示購物車
    public static void showCart(ArrayList<CartItem> cart) {


        if(cart.isEmpty()) {

            System.out.println("購物車沒有商品！");
            return;

        }



        System.out.println("\n===== 購物車內容 =====");



        for(CartItem item : cart) {

            System.out.println(item);

        }

    }







    // 計算總額
    public static void calculateTotal(ArrayList<CartItem> cart) {


        int total = 0;



        for(CartItem item : cart) {

            total += item.getSubtotal();

        }



        System.out.println("購物車總額：" + total);

    }







    // 搜尋商品
    public static CartItem findItem(String code, ArrayList<CartItem> cart) {


        for(CartItem item : cart) {


            if(item.getCode().equalsIgnoreCase(code)) {

                return item;

            }

        }


        return null;

    }


}