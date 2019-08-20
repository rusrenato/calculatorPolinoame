package service;

import model.Monomial;
import model.Polynomial;

import java.util.*;

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
        TreeMap<Integer, Monomial> map = new TreeMap<>();
        Polynomial rez = new Polynomial();
        for (Monomial m1 : p1.getMonomialList()) {
            for (Monomial m2 : p2.getMonomialList()) {
                int key = m1.getPower() + m2.getPower();
                if (!map.containsKey(key)) {
                    map.put(key, new Monomial(m1.getCoefficient() * m2.getCoefficient(), key));
                } else {
                    map.put(key, new Monomial(map.get(key).getCoefficient() + (m1.getCoefficient() * m2.getCoefficient()), key));
                }
            }
        }
        NavigableMap navigableMap = map.descendingMap();
        navigableMap.forEach((k, v) -> {
            rez.addMonomialToPolynomial((Monomial) v);
        });
        return rez;
    }

    public Polynomial derivation(Polynomial p) {
        Polynomial rez = new Polynomial();
        for (Monomial m : p.getMonomialList()) {
            if (m.getPower() > 0) {
                rez.addMonomialToPolynomial(new Monomial(m.getCoefficient() * m.getPower(), m.getPower() - 1));
            }
        }
        return rez;
    }

    public Polynomial integration(Polynomial p) {
        Polynomial rez = new Polynomial();
        for (Monomial m : p.getMonomialList()) {
            rez.addMonomialToPolynomial(new Monomial(m.getCoefficient(), m.getPower() + 1));
        }
        return rez;
    }

    public Polynomial division(Polynomial p1, Polynomial p2) {
        Polynomial rez = new Polynomial();
        Monomial t = new Monomial();
        Monomial q = new Monomial();
        Polynomial r = new Polynomial(p1.getMonomialList());
        System.out.println(r);

        while(!r.getMonomialList().isEmpty() && (p1.getPolynomialDegree() > p2.getPolynomialDegree())){
            t.setCoefficient(r.getMonomialList().get(0).getCoefficient() / p2.getMonomialList().get(0).getCoefficient());
            t.setPower(r.getMonomialList().get(0).getPower() - p2.getMonomialList().get(0).getPower());
            q.setCoefficient(q.getCoefficient() + t.getCoefficient());
            q.setPower(t.getPower());
            List<Monomial> monomialList = new ArrayList<>();
            monomialList.add(t);
            Polynomial polynomialT = new Polynomial(monomialList);
            r = sub(r,polynomialT);
        }
        System.out.println(q);
        System.out.println(r);
        return null;
    }


}
