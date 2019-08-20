import service.PolynomialService;

public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("4"));
        PolynomialService polynomialService = new PolynomialService();
        System.out.println(polynomialService.inputToPolynomialForm("4x^4 + 5x^3 - 3x^2 + 2x - 1"));

        System.out.println("Add : " + polynomialService.add(polynomialService.inputToPolynomialForm("4x^4 + 5x^3 - 3x^2 + 2x - 1"), polynomialService.inputToPolynomialForm("4x^4 + 5x^3 - 3x^2 + 2x - 1")));
        System.out.println("Sub : " + polynomialService.sub(polynomialService.inputToPolynomialForm("5x^4 + 6x^3 - 3x^2 + 2x - 1"), polynomialService.inputToPolynomialForm("4x^4 + 5x^3 - 3x^2 + 2x - 1")));
        System.out.println("Multiple : " + polynomialService.multiple(polynomialService.inputToPolynomialForm("3x^2 + 2x"), polynomialService.inputToPolynomialForm("2x + 3")));
    }
}
