package application;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

public class SearchPane extends Pane
{
	private static TextField searchBar;
	private static Rectangle backs1, backs2;
	private static Button search;
	private static ImageView slogo;
	
	public SearchPane() 
	{
		super();
		
		backs1 = new Rectangle(0, 0, 600, 1);
		backs2 = new Rectangle(0, 699, 600, 1);
		backs1.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		backs1.setStrokeType(StrokeType.INSIDE);
		backs1.setFill(Color.rgb(46,139,87));
		backs2.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		backs2.setStrokeType(StrokeType.INSIDE);
		backs2.setFill(Color.rgb(60,179,113));
		
		searchBar = new TextField();
		searchBar.setPadding(new Insets(15));
		searchBar.setStyle("-fx-background-radius:25; -fx-border-color:palegreen; -fx-border-radius:25; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		searchBar.setLayoutX(220);
		searchBar.setLayoutY(240);
		searchBar.setScaleX(2);
		searchBar.setScaleY(2);
		searchBar.setText("Search a Word !");
		
		slogo = new ImageView("file:seacrhlogo.png");
		slogo.setFitHeight(50);
		slogo.setFitWidth(50);
		
		search = new Button("", slogo);
		search.setPadding(new Insets(20));
		search.setStyle("-fx-background-radius:40; -fx-background-color: #00FF7F; -fx-border-color:#00FA9A; -fx-border-radius:40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		search.setAlignment(Pos.CENTER);
		search.setBlendMode(BlendMode.SRC_OVER);
		search.setLayoutX(250);
		search.setLayoutY(480);
		
		setPadding(new Insets(10));
		
		ScaleTransition sct1 = new ScaleTransition(Duration.seconds(3), backs1);
		sct1.setByY(800);
		sct1.setCycleCount(1);
		sct1.play();
		
		ScaleTransition sct2 = new ScaleTransition(Duration.seconds(3), backs2);
		sct2.setByY(-600);
		sct2.setCycleCount(1);
		sct2.play();
		
		FillTransition ft1 = new FillTransition(Duration.seconds(3), backs1, Color.rgb(107,142,35),Color.rgb(57,133,100));
		ft1.setCycleCount(1);
		ft1.setDelay(Duration.seconds(1));
		ft1.setAutoReverse(false);
		ft1.play();
		
		FillTransition ft2 = new FillTransition(Duration.seconds(3), backs2, Color.rgb(143,188,143), Color.rgb(82,191,144));
		ft2.setCycleCount(1);
		ft2.setDelay(Duration.seconds(1));
		ft2.setAutoReverse(false);
		ft2.play();
		
		FadeTransition dt1 = new FadeTransition(Duration.seconds(3), search);
		dt1.setFromValue(0);
		dt1.setToValue(99);
		dt1.setCycleCount(1);
		dt1.play();
		
		FadeTransition dt2 = new FadeTransition(Duration.seconds(3), searchBar);
		dt2.setFromValue(0);
		dt2.setToValue(99);
		dt2.setCycleCount(1);
		dt2.play();
	
		
		getChildren().addAll(backs1, backs2, searchBar, search);
		
	}
	
	public static final TextField getSearchBar() {
		return searchBar;
	}

	public static  final void setSearchBar(TextField searchBar) {
		SearchPane.searchBar = searchBar;
	}

	public static  final Rectangle getBacks1() {
		return backs1;
	}

	public static  final void setBacks1(Rectangle backs1) {
		SearchPane.backs1 = backs1;
	}

	public static  final Rectangle getBacks2() {
		return backs2;
	}

	public static  final void setBacks2(Rectangle backs2) {
		SearchPane.backs2 = backs2;
	}

	public static  final Button getSearch() {
		return search;
	}

	public static  final void setSearch(Button search) {
		SearchPane.search = search;
	}
	

}
