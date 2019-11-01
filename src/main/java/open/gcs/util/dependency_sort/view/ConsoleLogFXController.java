package open.gcs.util.dependency_sort.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import open.gcs.util.dependency_sort.service.OrderAssembly;

public class ConsoleLogFXController implements Initializable {

  @FXML
  private Button btnContinue;
  @FXML
  private TextArea txtConsole;
  @FXML
  private Label lblAction;
  private int counter;
  private String path;
  private OrderAssembly orderAssembly;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.orderAssembly = new OrderAssembly();
    // TODO Auto-generated method stub
    this.btnContinue.setOnAction(this::onClickContinue);
    this.txtConsole.setOnInputMethodTextChanged(this::onChangeTextConsole);
    this.txtConsole.setStyle("-fx-control-inner-background: black;");
    this.txtConsole.appendText("Siguiente acción: obtener Assemblies \n");
    this.txtConsole.appendText("Presione el boton Continuar \n");
    this.counter = 1;
  }

  public void initData(String path) {
    this.path = path;
  }

  private void onClickContinue(final ActionEvent event) {

    switch (this.counter) {
      case 1:
        this.lblAction.setText("Ejecutando proceso, espere ...");
        this.txtConsole.appendText("Obteniendo Assemblies ... \n");
        this.txtConsole.appendText(orderAssembly.setAsembly(this.path) + "\n");
        this.txtConsole
            .appendText("Siguiente acción: Crear grafo con assemblys y sus dependencias \n");
        this.txtConsole.appendText("Presione el boton Continuar \n");
        this.counter += 1;
        break;
      case 2:
        this.txtConsole.appendText("Creando Grafo ... \n");
        this.txtConsole.appendText(orderAssembly.serGraph() + "\n");
        this.txtConsole
            .appendText("Siguiente acción: Obtener el nivel de cada uno de los assembly \n");
        this.txtConsole.appendText("Presione el boton Continuar \n");
        this.counter += 1;
        break;

      case 3:
        this.txtConsole.appendText("Obteniendo nivel de los assembly ... \n");
        this.txtConsole.appendText(orderAssembly.setLevel(this.path) + "\n");
        this.txtConsole
            .appendText("Siguiente acción: Finalizar \n");
        this.txtConsole.appendText("Presione el boton Continuar \n");
        this.counter += 1;
        break;

      default:
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // do what you have to do
        stage.close();
        break;
    }



  }

  private void onChangeTextConsole(final InputMethodEvent event) {

  }

}
