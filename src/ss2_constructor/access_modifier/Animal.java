package ss2_constructor.access_modifier;

public class Animal {
    private int id;
    String name;
    protected String color;
    public int age;

    public void accessProperty() {
        this.id = 1;
        this.name = "Mèo";
        this.color = "Trắng";
        this.age = 10;
    }
}
