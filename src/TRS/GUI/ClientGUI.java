package TRS.GUI;
	
import java.io.IOException;

import com.sun.javafx.iio.ios.IosDescriptor;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

import javax.swing.event.HyperlinkEvent;


public class ClientGUI extends Application {
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		primaryStage.setTitle("TRS System");
		mainWindow();
	}
	
	public void mainWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(ClientGUI.class.getResource("Login.fxml"));
			AnchorPane pane = loader.load();
			primaryStage.setMinHeight(400.00);
			primaryStage.setMinWidth(400.00);
			ClientGUIController clientGUIController = loader.getController();
		//	mainWindowController.setMain(this);
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.show();
        } catch(IOException e) {
			e.printStackTrace();
		}



	}

	public static void main(String[] args) {
		launch(args);
	}
}
