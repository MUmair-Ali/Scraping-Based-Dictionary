package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class Main extends Application 
{
	DictionaryPane dict;
	@Override
	public void start(Stage primaryStage) throws Exception
	{
			StartPane start = new StartPane();
			Scene scene = new Scene(start,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle(" W E L C O M E ");
			primaryStage.setResizable(false);
			primaryStage.show();
			
			StartPane.getStart().setOnMouseMoved(e -> 
			{
				StartPane.getStart().setStyle("-fx-background-color: #7FFF00; -fx-background-radius: 40; -fx-border-color: #00FF00; -fx-border-radius: 40;");
				StartPane.getStart().setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.REGULAR, 17));
			});
			
			StartPane.getStart().setOnMouseClicked(e -> 
			{
				StartPane.getStart().setStyle("-fx-background-color: #32CD32; -fx-background-radius: 40; -fx-border-color:#228B22; -fx-border-radius: 40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
			});
			
			StartPane.getStart().setOnMouseReleased(e -> 
			{
				StartPane.getStart().setStyle("-fx-background-color: #00FF7F; -fx-background-radius: 40; -fx-border-color:#98FB98; -fx-border-radius: 40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"); 
			});
			
			StartPane.getStart().setOnMouseExited(e -> 
			{
				StartPane.getStart().setStyle("-fx-background-color: #00FF7F; -fx-background-radius: 40; -fx-border-color:#98FB98; -fx-border-radius: 40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"); 
				StartPane.getStart().setFont(Font.font("Georgia", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 17));
			});
			
			StartPane.getTitle().setOnMouseMoved(e -> 
			{
				start.getF3().pause();
				StartPane.getTitle().setFill(Color.rgb(0,255,0));
				StartPane.getTitle().setStroke(Color.rgb(107,142,35));
			});
			
			StartPane.getTitle().setOnMouseExited(e -> 
			{
				start.getF3().play();
			});
			
			StartPane.getStart().setOnAction(e ->
			{
				primaryStage.close();
				
				Stage mainStage = new Stage();
				SearchPane search = new SearchPane();
				Scene scene2 = new Scene(search, 600, 700);
				mainStage.setTitle(" U I - D I C T I O N A R Y ");
				mainStage.setScene(scene2);
				mainStage.setResizable(false);
				mainStage.show();
				
				SearchPane.getSearch().setOnMouseMoved(ev -> 
				{
					SearchPane.getSearch().setStyle("-fx-background-color: #7FFF00; -fx-background-radius: 40; -fx-border-color: #00FF00; -fx-border-radius: 40;");
				});
				
				SearchPane.getSearch().setOnMouseClicked(ev -> 
				{
					SearchPane.getSearch().setStyle("-fx-background-color: #32CD32; -fx-background-radius: 40; -fx-border-color:#228B22; -fx-border-radius: 40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
				});
				
				SearchPane.getSearch().setOnMouseReleased(ev -> 
				{
					SearchPane.getSearch().setStyle("-fx-background-color: #00FF7F; -fx-background-radius: 40; -fx-border-color:#98FB98; -fx-border-radius: 40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"); 
				});
				
				SearchPane.getSearch().setOnMouseExited(ev -> 
				{
					SearchPane.getSearch().setStyle("-fx-background-color: #00FF7F; -fx-background-radius: 40; -fx-border-color:#98FB98; -fx-border-radius: 40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"); 
				});
				
				SearchPane.getSearch().setOnAction(ev ->
				{	
						 dict = new DictionaryPane();
						Scene sc = new Scene(dict, 900, 800);
						mainStage.setScene(sc);
						dict.doScrapping();
						
						
				});
				
				SearchPane.getSearchBar().setOnKeyPressed(ev ->
				{
					switch(ev.getCode())
					{
					case ENTER:
						
						 dict = new DictionaryPane();
						Scene sc = new Scene(dict, 900, 800);
						mainStage.setScene(sc);
						dict.doScrapping();
						
						break;
					default:
							break;
					}
				});
				
				
				DictionaryPane.getMenu().setOnMouseMoved(ev -> 
				{
					DictionaryPane.getMenu().setStyle("-fx-background-color: #7FFF00; -fx-background-radius: 50; -fx-border-color: #00FF00; -fx-border-radius: 50;");
				});
				
				DictionaryPane.getMenu().setOnMouseClicked(ev -> 
				{
					DictionaryPane.getMenu().setStyle("-fx-background-color: #32CD32; -fx-background-radius: 50; -fx-border-color:#228B22; -fx-border-radius: 50; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
				});
				
				DictionaryPane.getMenu().setOnMouseReleased(ev -> 
				{
					DictionaryPane.getMenu().setStyle("-fx-background-color: transparent; -fx-background-radius: 50; -fx-border-color:transparent; -fx-border-radius: 50; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"); 
				});
				
				DictionaryPane.getMenu().setOnMouseExited(ev -> 
				{
					DictionaryPane.getMenu().setStyle("-fx-background-color: transparent; -fx-background-radius: 50; -fx-border-color: transparent; -fx-border-radius: 50; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"); 
				});
				
				DictionaryPane.getMenu().setOnAction(eh ->
				{
					mainStage.close();
					
					HistoryPane hist = new HistoryPane();
					HistoryPane.setHist(HistoryPane.showHistory());
					
					BorderPane bh = new BorderPane();
					bh.setCenter(hist);
					
					Scene sc2 = new Scene(bh, 800, 800);
					
					Stage tempStage = new Stage();
					tempStage.setScene(sc2);
					tempStage.setTitle(" H I S T O R Y ");
					tempStage.setResizable(true);
					tempStage.show();
					
					HistoryPane.getClear().setOnMouseMoved(eve -> 
					{
						HistoryPane.getClear().setStyle("-fx-background-color: #7FFF00; -fx-background-radius: 40; -fx-border-color: #00FF00; -fx-border-radius: 40;");
					});
					
					HistoryPane.getClear().setOnMouseClicked(eve -> 
					{
						HistoryPane.getClear().setStyle("-fx-background-color: #32CD32; -fx-background-radius: 40; -fx-border-color:#228B22; -fx-border-radius: 40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
					});
					
					HistoryPane.getClear().setOnMouseReleased(eve -> 
					{
						HistoryPane.getClear().setStyle("-fx-background-color: #00FF7F; -fx-background-radius: 40; -fx-border-color:#98FB98; -fx-border-radius: 40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"); 
					});
					
					HistoryPane.getClear().setOnMouseExited(eve -> 
					{
						HistoryPane.getClear().setStyle("-fx-background-color: #00FF7F; -fx-background-radius: 40; -fx-border-color:#98FB98; -fx-border-radius: 40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"); 
					});
					
					HistoryPane.getClear().setOnAction(eve -> 
					{
						HistoryPane.getHistory().clear();
						HistoryPane.getFile().delete();
						HistoryPane.setHist("No History Found !");
						
					});
					
				});
				
			});
			
	}
	
	public static void main(String[] args) 
	{
		launch(args);
		
	}
}
