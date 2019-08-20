package model;

public class Monomial {

    private int coefficient;
    private int power;

    public Monomial(int coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public Monomial() {
    }

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
        String returnedString = "";
        String coefToString = coefficient + "";
        String powerToString = "x^" + power;
        if (coefficient == 1) {
            coefToString = "";
        }

        if (coefficient != 0) {

            if (power > 1) {
                //   returnedString = coefficient > 0 ? returnedString.concat("+ " + coefToString + "x^" + power) : returnedString.concat("- " + (coefficient * -1) + "x^" + power);
            } else if (power == 1) {
                powerToString = "x";
                //   returnedString = coefficient > 0 ? returnedString.concat("+ " + coefficient + "x") : returnedString.concat("- " + (coefficient * -1) + "x");
            } else {
                powerToString = "";
                //   returnedString = coefficient > 0 ? returnedString.concat("+ " + coefficient) : returnedString.concat("- " + (coefficient * -1));
            }
            return coefficient > 0 ? returnedString.concat("+ " + coefToString + powerToString) : returnedString.concat("- " + (coefficient * -1) + powerToString);
        }

        return "";
    }
}
