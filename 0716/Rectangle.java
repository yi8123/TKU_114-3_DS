public class Rectangle {
    private double width;
    private double height;

    // 建構子，同時利用 setter 進行正數驗證，若不合法則給予預設值 1.0
    public Rectangle(double width, double height) {
        if (!setWidth(width)) {
            this.width = 1.0;
        }
        if (!setHeight(height)) {
            this.height = 1.0;
        }
    }

    public double getWidth() {
        return width;
    }

    public boolean setWidth(double width) {
        if (width > 0) {
            this.width = width;
            return true;
        }
        return false;
    }

    這是一套完整的 Java 物件導向程式碼實作，包含你所列出的四個主題。程式碼均加上了清晰的邏輯防禦與註解。

---

## 1. 矩形計算 (Rectangle)

### Rectangle.java
```java
public class Rectangle {
    private double width;
    private double height;

    // 建構子：驗證若小於等於 0 則給予預設值 1.0
    public Rectangle(double width, double height) {
        this.width = width > 0 ? width : 1.0;
        this.height = height > 0 ? height : 1.0;
    }

    public double getWidth() {
        return width;
    }

    public boolean setWidth(double width) {
        if (width <= 0) {
            return false;
        }
        this.width = width;
        return true;
    }

    public double getHeight() {
        return height;
    }

    public boolean setHeight(double height) {
        if (height <= 0) {
            return false;
        }
        this.height = height;
        return true;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return Double.compare(width, height) == 0;
    }

    @Override
    public String toString() {
        return String.format("矩形 [寬: %.2f, 高: %.2f]", width, height);
    }
}