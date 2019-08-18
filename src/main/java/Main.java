import service.PolynomialService;

public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("4"));
        PolynomialService polynomialService = new PolynomialService();
        polynomialService.inputToPolinom("4x^4 + 5x^3 - 3x^2 + 2x - 1");
    }
}
