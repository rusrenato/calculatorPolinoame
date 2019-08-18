package model;

public class Monom {
    private int coefficient;
    private int power;

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "model.Monom{" +
                "coefficient=" + coefficient +
                ", power=" + power +
                '}';
    }
}
