package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import service.PolynomialService;

public class uiController {

    @FXML
    private TextField firstPolynomial;
    @FXML
    private TextField secondPolynomial;
    @FXML
    private TextField result;

    private PolynomialService polynomialService = new PolynomialService();

    public void onPlus() {
        result.setText(polynomialService.add(polynomialService.inputToPolynomialForm(firstPolynomial.getText()),polynomialService.inputToPolynomialForm(secondPolynomial.getText())) + "");
    }

    public void onMinus() {
        result.setText(polynomialService.sub(polynomialService.inputToPolynomialForm(firstPolynomial.getText()),polynomialService.inputToPolynomialForm(secondPolynomial.getText())) + "");
    }

    public void onMul() {
        result.setText(polynomialService.multiple(polynomialService.inputToPolynomialForm(firstPolynomial.getText()),polynomialService.inputToPolynomialForm(secondPolynomial.getText())) + "");
    }

    public void onDiv() {
        result.setText(polynomialService.division(polynomialService.inputToPolynomialForm(firstPolynomial.getText()),polynomialService.inputToPolynomialForm(secondPolynomial.getText())) + "");
    }

    public void onDerivation() {
        result.setText(polynomialService.derivation(polynomialService.inputToPolynomialForm(firstPolynomial.getText())) + "");
    }

    public void onIntegration() {
        result.setText(polynomialService.integration(polynomialService.inputToPolynomialForm(firstPolynomial.getText())) + "");

    }



}
