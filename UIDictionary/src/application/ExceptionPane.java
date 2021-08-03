package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ExceptionPane extends HBox
{
	private static Text message;
	private static ImageView errorLogo;
	private static String eMsg;
	
	public ExceptionPane(String eMsg) 
	{
		super();
		
		ExceptionPane.eMsg = eMsg;
		
		setPadding(new Insets(20));
		setAlignment(Pos.CENTER);
		setPrefSize(400, 300);
		setStyle("-fx-background-color: white; -fx-border-color:grey;  -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		
		message = new Text(eMsg);
		message.setFont(Font.font("Calbri", FontWeight.BOLD, FontPosture.ITALIC, 17));
		message.setFill(Color.CRIMSON);
		message.setStroke(Color.RED);
		message.setTextAlignment(TextAlignment.JUSTIFY);
		
		errorLogo = new ImageView("file:error.png");
		errorLogo.setFitHeight(40);
		errorLogo.setFitWidth(40);
		
		setSpacing(10);
		
		getChildren().addAll(errorLogo, message);
		
	}
	
	public static void displayExceptionNotification(String eMsg)
	{
		Scene sc = new Scene(new ExceptionPane(eMsg), 400, 150);
		Stage st = new Stage();
		st.setScene(sc);
		st.setResizable(false);
		st.setTitle(" E R R O R ");
		st.show();
	}

	public static  final Text getMessage() {
		return message;
	}

	public static  final void setMessage(Text message) {
		ExceptionPane.message = message;
	}

	public static  final ImageView getErrorLogo() {
		return errorLogo;
	}

	public static  final void setErrorLogo(ImageView errorLogo) {
		ExceptionPane.errorLogo = errorLogo;
	}

	public static  final String geteMsg() {
		return eMsg;
	}

	public static  final void seteMsg(String eMsg) {
		ExceptionPane.eMsg = eMsg;
	}
	
	
	
}
