package open.gcs.util.dependency_sort.application;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application{

  private static final String TITLE_APP="Ordenar listado de assembly";
  private static final String ICON_APP="icons/logo.png";
  private static final String INIT_APP="/fxml/Init.fxml";
  public void start(final Stage primaryStage) throws IOException{
      Image appLogo = new Image(ICON_APP);
      primaryStage.setTitle(TITLE_APP);
      primaryStage.setResizable(false);
      primaryStage.getIcons().add(appLogo);
      URL url = this.getClass().getResource(INIT_APP);
      
      final Parent root=(Parent)FXMLLoader.load(url);
      final Scene scene=new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    launch(args);
  }

}
