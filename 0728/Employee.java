public class Employee {
    private int id;
    private String name;
    private String department;
    private String ext;

    public Employee(int id, String name, String department, String ext) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.ext = ext;
    }

    public int getId() { return id; }
    
    @Override
    public String toString() {
        return String.format("員工編號: %d | 姓名: %s | 部門: %s | 分機: %s", id, name, department, ext);
    }
}