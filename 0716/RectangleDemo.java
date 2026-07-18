public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle[] rectangles = {
            new Rectangle(5.0, 5.0),
            new Rectangle(4.0, 7.5),
            new Rectangle(-2.0, 3.0) 
        };

        for (int i = 0; i < rectangles.length; i++) {
            Rectangle r = rectangles[i];
            System.out.println("--- 矩形 " + (i + 1) + " ---");
            System.out.println(r);
            System.out.println("面積: " + r.calculateArea());
            System.out.println("周長: " + r.calculatePerimeter());
            System.out.println("是否為正方形: " + (r.isSquare() ? "是" : "否"));
        }
    }
}