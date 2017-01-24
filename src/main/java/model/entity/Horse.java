package model.entity;

/**
 * Created by daniel on 26/12/16.
 */
public class Horse  implements Entity{
    private Integer number;
    private String name;
    private String color;
    private Double coefficent;

    public Horse(Integer number, String name, String color, Double coefficent) {
        this.number = number;
        this.name = name;
        this.color = color;
        this.coefficent = coefficent;
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
                " color:" + color +
                " coeff:" + coefficent;
    }
}
