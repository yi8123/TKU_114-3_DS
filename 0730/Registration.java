public class Registration {
    private int id;
    private String name;

    public Registration(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "報名編號: " + id + " | 姓名: " + name;
    }
}