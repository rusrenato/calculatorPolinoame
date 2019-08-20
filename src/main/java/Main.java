import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import service.PolynomialService;

public class Main extends Application {
 /*   public static void main(String[] args) {
        System.out.println(Integer.parseInt("4"));
        PolynomialService polynomialService = new PolynomialService();
        System.out.println(polynomialService.inputToPolynomialForm("4x^4 + 5x^3 - 3x^2 + 2x - 1"));

        System.out.println("Add : " + polynomialService.add(polynomialService.inputToPolynomialForm("4x^4 + 5x^3 - 3x^2 + 2x - 1"), polynomialService.inputToPolynomialForm("4x^4 + 5x^3 - 3x^2 + 2x - 1")));
        System.out.println("Sub : " + polynomialService.sub(polynomialService.inputToPolynomialForm("5x^4 + 6x^3 - 3x^2 + 2x - 1"), polynomialService.inputToPolynomialForm("4x^4 + 5x^3 - 3x^2 + 2x - 1")));
        System.out.println("Multiple : " + polynomialService.multiple(polynomialService.inputToPolynomialForm("3x^3 - 6x^2 + 2x + 8"), polynomialService.inputToPolynomialForm("2x + 3")));
        System.out.println("Derivation : " + polynomialService.derivation(polynomialService.inputToPolynomialForm("3x^3 - 2x^2 + 3x + 4")));
        System.out.println("Integration : " + polynomialService.integration(polynomialService.inputToPolynomialForm("3x^3 - 2x^2 + 3x + 4")).integrationSpecialRepresentation());
        System.out.println("Degree : " + polynomialService.inputToPolynomialForm("3x^3 + 2x^2 + 3x + 1").getPolynomialDegree());
     //   System.out.println("Division : " + polynomialService.division(polynomialService.inputToPolynomialForm("3x^3 - 6x^2 + 2x + 8"), polynomialService.inputToPolynomialForm("2x + 3")));
    }*/

    @Override
    public void start(Stage primaryStage) throws Exception {
       // BorderPane root = new BorderPane();
      //  Scene scene = new Scene(root,400,400);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/test.fxml"));
        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
