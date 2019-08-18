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


    @Override
    public String toString() {
       String polynomialForm = "";
       for(Monomial monomial : monomialList) {
           polynomialForm = polynomialForm + " " + monomial;
       }
       return polynomialForm.substring(3);
    }
}
