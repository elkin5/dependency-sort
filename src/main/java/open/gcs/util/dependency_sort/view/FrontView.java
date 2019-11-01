package open.gcs.util.dependency_sort.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FrontView implements Initializable{
  
  Stage stage = new Stage();
  Scene scene = new Scene(new Group());
  HBox hbox = new HBox();
  TextArea label1 = new TextArea();
  
  public FrontView(String title) {
    stage.setTitle(title);
    stage.initStyle(StageStyle.UNDECORATED);
//    label1.setFont(new Font("Arial", 30));
//    label1.setTextFill(Color.web("#0076a3"));
//    label1.setTextAlignment(TextAlignment.JUSTIFY);
    
  }

  public void print(String text) {
    try {
      
//      Stage stage = new Stage();
//      stage.setTitle(text); 
//      Scene scene = new Scene(new Group());
//
//
//      HBox hbox = new HBox();
//
//      Label label1 = new Label("Search");
//      // label1.setGraphic(new ImageView(image));
//      label1.setFont(new Font("Arial", 30));
//      label1.setTextFill(Color.web("#0076a3"));
//      label1.setTextAlignment(TextAlignment.JUSTIFY);
//      stage.close();
      label1.appendText(text);

      hbox.getChildren().add(label1);

      ((Group) scene.getRoot()).getChildren().add(hbox);

      stage.setScene(scene);
      stage.show();
      
      // Stage stage1 = new Stage();
      // stage1.setTitle(path);
      // stage1.setResizable(false);
      // URL url = this.getClass().getResource("/fxml/modal.fxml");
      // final Parent root=(Parent)FXMLLoader.load(url);
      // final Scene scene=new Scene(root);
      // stage1.setScene(scene);
      // stage1.show();

    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // TODO Auto-generated method stub
    
  }

}
