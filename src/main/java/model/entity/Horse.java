package model.entity;

/**
 * Created by daniel on 26/12/16.
 */
public class Horse {
    private Integer number;
    private String name;
    private String color;


    public Horse(Integer number, String name, String color) {
        this.number = number;
        this.name = name;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    @Override
    public String toString() {
        return  "#" + number +
                " name:" + name  +
                " color:" + color;
    }
}
