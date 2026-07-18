public class Rectangle {
    private double width;
    private double height;

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

    public double getHeight() {
        return height;
    }

    public boolean setHeight(double height) {
        if (height > 0) {
            this.height = height;
            return true;
        }
        return false;
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