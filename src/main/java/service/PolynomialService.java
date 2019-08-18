package service;

import model.Monomial;
import model.Polynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PolynomialService {

    public Polynomial inputToPolinom (String input) {
        Polynomial polynomial = new Polynomial();
        List<String> stringList = new LinkedList<>(Arrays.asList(input.split(" ")));
        List<String> signList = new ArrayList<>();
        int power;

        System.out.println(stringList);
        for (String s : stringList) {
            if (s.matches("[+-]")) {
                signList.add(s);
            }
        }
        stringList.removeAll(signList);

        for (int i = 0; i < signList.size(); i++) {
            stringList.set(i + 1, signList.get(i).concat(stringList.get(i + 1)));
        }
        System.out.println(stringList);
        if(!stringList.get(0).startsWith("-")){
            stringList.set(0, "+".concat(stringList.get(0)));
        }

        for (String string : stringList) {
            Monomial monomial = new Monomial();
            if (string.startsWith("-")) {
                monomial.setCoefficient(Integer.parseInt(string.substring(1, 2)) * -1);
            } else {
                monomial.setCoefficient(Integer.parseInt(string.substring(1, 2)));
            }

            if (string.contains("^")) {
                power = Integer.parseInt(string.substring(string.indexOf("^") + 1));
            } else if (string.contains("x")) {
                power = 1;
            } else {
                power = 0;
            }
            monomial.setPower(power);

            polynomial.addMonomialToPolynomial(monomial);
        }
        return polynomial;
    }
}
