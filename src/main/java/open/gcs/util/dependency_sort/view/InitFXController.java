package open.gcs.util.dependency_sort.view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class InitFXController implements Initializable {

  private static final String SELECT_DRECTORY = "Seleccionar directorio";
  private static final String SELECT_DRECTORY_RES = "¿Desea iniciar el proceso?";
  private static final String INIT_RES =
      "Se generara un archivo .txt en la carpeta seleccionada indicando orden de aplicación.";
  private static final String RESULT_OK =
      "Proceso Terminado. verifique en la carpeta el archivo ordenAplica.txt.";
  @FXML
  private Button btnSelectFile;
  @FXML
  private Button btnAcept;
  @FXML
  private Button btnCancel;
  @FXML
  private Label lblFilePath;
  @FXML
  private Label lblResult;
  @FXML
  private AnchorPane layout;

  public void initialize(final URL location, final ResourceBundle resources) {
    this.btnSelectFile.setOnAction(this::onSelectedFile);
    this.btnCancel.setOnAction(this::onCancel);
    this.btnAcept.setOnAction(this::onAcept);
  }

  public void print(String text) {
    this.lblResult.setText("Hola");
  }

  private void onSelectedFile(final ActionEvent event) {
    String filePathName = "";

    final DirectoryChooser chooser = new DirectoryChooser();
    chooser.setTitle(SELECT_DRECTORY);
    final File selDirectory = chooser.showDialog((Window) null);
    filePathName = selDirectory.getAbsolutePath();
    this.lblResult.setText(SELECT_DRECTORY_RES);


    this.btnAcept.setVisible(true);
    this.btnCancel.setVisible(true);
    this.btnSelectFile.setVisible(false);
    this.lblFilePath.setText(filePathName);
  }

  private void onCancel(final ActionEvent event) {
    this.reset();
  }

  private void reset() {
    this.btnAcept.setVisible(false);
    this.btnCancel.setVisible(false);
    this.btnSelectFile.setVisible(true);
    this.lblFilePath.setText("");
    this.lblResult.setText(INIT_RES);
  }

  private void onAcept(final ActionEvent event) {
    final String path = this.lblFilePath.getText();
    Stage stage = new Stage();
    stage.initStyle(StageStyle.UTILITY);
    stage.initOwner(((Node) event.getSource()).getScene().getWindow());
    stage.setResizable(false);
    stage.initModality(Modality.WINDOW_MODAL);
    stage.setTitle("Procesando ...");

    try {
      FXMLLoader loader1 = new FXMLLoader();
      loader1.setLocation(this.getClass().getResource("/fxml/ConsoleLog.fxml"));
      final Scene scene = new Scene((Pane) loader1.load());
      stage.setScene(scene);
      ConsoleLogFXController controller = loader1.<ConsoleLogFXController>getController();
      controller.initData(path);

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    stage.show();

    this.reset();
    this.lblResult.setText(RESULT_OK);

  }
}
