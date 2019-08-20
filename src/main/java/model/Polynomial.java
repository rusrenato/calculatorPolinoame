package model;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private List<Monomial> monomialList;

    public Polynomial(){
        monomialList = new ArrayList<>();
    }

    public List<Monomial> getMonomialList() {
        return monomialList;
    }

    public void addMonomialToPolynomial(Monomial monomial) {
        monomialList.add(monomial);
    }

    public int getPolynomialDegree() {
        return monomialList.get(0).getPower();
    }

    public Polynomial(List<Monomial> monomialList) {
        this.monomialList = monomialList;
    }

    @Override
    public String toString() {
       String polynomialForm = "";
       for(Monomial monomial : monomialList) {
           polynomialForm = polynomialForm + " " + monomial;
       }
       return polynomialForm.substring(3);
    }

    public String integrationSpecialRepresentation() {
        String polynomialForm = "";
        for(Monomial monomial : monomialList) {
            if(monomial.getPower() > 1) {
                polynomialForm = polynomialForm + " " + monomial + "/" + monomial.getPower();
            } else {
                polynomialForm = polynomialForm + " " + monomial;
            }
        }
        return polynomialForm.substring(3) + " + C";
    }

}
