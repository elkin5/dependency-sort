package open.gcs.util.dependency_sort.view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConsoleLogFX {
  private Stage stage = new Stage();
  private Scene scene = new Scene(new Group());
  private AnchorPane layout = new AnchorPane();
  private Button btnCancel = new Button();
  private TextArea txtConsole = new TextArea();
  private Label lblAction = new Label();

  public ConsoleLogFX(String title, Stage parent) {
    stage.setTitle(title);
    stage.initStyle(StageStyle.UTILITY);
    stage.initOwner(parent);
    stage.setResizable(false);
    stage.initModality(Modality.WINDOW_MODAL);
    layout.setPrefWidth(415.0);
    layout.prefHeight(277.0);
    btnCancel.setLayoutX(292.0);
    btnCancel.setLayoutY(209.0);
    btnCancel.setMnemonicParsing(false);
    btnCancel.setPrefHeight(25.0);
    btnCancel.setPrefWidth(82.0);
    btnCancel.setText("Cancelar");
    txtConsole.setEditable(false);
    txtConsole.setLayoutX(29.0);
    txtConsole.setLayoutY(59.0);
    txtConsole.setPrefHeight(133.0);
    txtConsole.setPrefWidth(353.0);
    txtConsole.setWrapText(true);
    txtConsole.setFont(new Font("System", 10.0));
    txtConsole.setStyle("-fx-control-inner-background: black;");
    lblAction.setLayoutX(29.0);
    lblAction.setLayoutY(24.0);
    lblAction.setPrefHeight(17.0);
    lblAction.setPrefWidth(250.0);
    lblAction.setText("Ejecutando proceso, espere ...");
    lblAction.setTextFill(Paint.valueOf("#1d8a43"));
    lblAction.setFont(new Font("System Bold Italic", 14.0));

    layout.getChildren().add(lblAction);
    layout.getChildren().add(txtConsole);
    layout.getChildren().add(btnCancel);

    ((Group) scene.getRoot()).getChildren().add(layout);
    stage.setScene(scene);
  }

  public void print(String text, boolean mark) {
    try {
      
      txtConsole.appendText(text + "\n");
      stage.show();

    } catch (Exception e) {
      // TODO: handle exception
    }
  }
  
  public void close(){
    stage.close();
  }

}
