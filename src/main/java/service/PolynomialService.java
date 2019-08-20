package service;

import model.Monomial;
import model.Polynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PolynomialService {

    public Polynomial inputToPolynomialForm(String input) {
        Polynomial polynomial = new Polynomial();
        List<String> stringList = new LinkedList<>(Arrays.asList(input.split(" ")));
        List<String> signList = new ArrayList<>();
        int power;

        for (String s : stringList) {
            if (s.matches("[+-]")) {
                signList.add(s);
            }
        }
        stringList.removeAll(signList);

        for (int i = 0; i < signList.size(); i++) {
            stringList.set(i + 1, signList.get(i).concat(stringList.get(i + 1)));
        }
        if (!stringList.get(0).startsWith("-")) {
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

    public Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        for (Monomial m1 : p1.getMonomialList()) {
            for (Monomial m2 : p2.getMonomialList()) {
                if (m1.getPower() == m2.getPower()) {
                    rez.addMonomialToPolynomial(new Monomial(m1.getCoefficient() + m2.getCoefficient(), m1.getPower()));
                }
            }
        }
        return rez;
    }

    public Polynomial sub(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        for (Monomial m1 : p1.getMonomialList()) {
            for (Monomial m2 : p2.getMonomialList()) {
                if (m1.getPower() == m2.getPower()) {
                    rez.addMonomialToPolynomial(new Monomial(m1.getCoefficient() - m2.getCoefficient(), m1.getPower()));
                }
            }
        }
        return rez;
    }

    public Polynomial multiple(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        for (Monomial m1 : p1.getMonomialList()) {
            for (Monomial m2 : p2.getMonomialList()) {
                rez.addMonomialToPolynomial(new Monomial(m1.getCoefficient() * m2.getCoefficient(), m1.getPower() * m2.getPower()));
            }
        }
        for(Monomial monomial : rez.getMonomialList()) {

        }
        return rez;
    }


}
