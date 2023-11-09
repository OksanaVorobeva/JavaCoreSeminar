package seminar3;

public class Cat {
    private  static final int CURRENT_YEAR=2022;
    private static int id=0;

    private String name;
    private String color;
    private  int birthYear;
    public  int uid;

    public Cat(String name, String color, int birthYear, int uid) {
        this.name = name;
        this.color = color;
        this.birthYear = birthYear;
        this.uid = ++id;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Cat.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
