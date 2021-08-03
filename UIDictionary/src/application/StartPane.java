package application;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.DepthTest;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class StartPane extends Pane
{
	private static ImageView logo;
	private static Text title;
	private static Button start;
	private static Rectangle back1,back2;
	private FillTransition f3;
	
	public StartPane()
	{
		super();
		
		back1 = new Rectangle(0, 0, 600, 1);
		back2 = new Rectangle(0, 599, 600, 1);
		back1.setFill(Color.SEAGREEN);
		back1.setStrokeType(StrokeType.INSIDE);
		back1.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		back2.setFill(Color.FORESTGREEN);
		back2.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		back2.setStrokeType(StrokeType.INSIDE);
		
		start = new Button(" S T A R T ");
		start.setPadding(new Insets(15));
		start.setAlignment(Pos.CENTER);
		start.setBlendMode(BlendMode.SRC_OVER);
		start.setStyle("-fx-background-color: #00FF7F; -fx-background-radius: 40; -fx-border-color:#98FB98; -fx-border-radius: 40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"); 
		start.setLayoutX(-250);
		start.setLayoutY(400);
		start.setDepthTest(DepthTest.INHERIT);
		start.setFont(Font.font("Georgia", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 17));
		
		setPadding(new Insets(10));
		
		logo = new ImageView("file:logo.png");
		logo.setFitHeight(200);
		logo.setFitWidth(190);
		logo.setLayoutX(200);
		logo.setLayoutY(19);
		logo.setStyle("-fx-border-color:#98FB98; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		
		title = new Text(" U I - D I C T I O N A R Y ");
		title.setFont(Font.font("Impact", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 45));
		title.setFill(Color.rgb(128,128,0));
		title.setStroke(Color.rgb(107,142,35));
		title.setTextAlignment(TextAlignment.JUSTIFY);
		title.setLayoutX(100);
		title.setLayoutY(300);
		
		this.getChildren().addAll(back1, back2, logo, title, start);
		
		ScaleTransition tt1 = new ScaleTransition(Duration.seconds(3),back1);
		tt1.setByY(700);
		tt1.setCycleCount(1);
	
		ScaleTransition tt2 = new ScaleTransition(Duration.seconds(3),back2);
		tt2.setByY(-500);
		tt2.setCycleCount(1);
		
		FillTransition f1 = new FillTransition(Duration.seconds(3), back1, Color.rgb(107,142,35), Color.rgb(46,139,87));
		f1.setCycleCount(1);
		f1.setDelay(Duration.seconds(1));
		f1.setAutoReverse(false);
		
		FillTransition f2 = new FillTransition(Duration.seconds(3), back2, Color.rgb(143,188,143), Color.rgb(60,179,113));
		f2.setCycleCount(1);
		f2.setDelay(Duration.seconds(1));
		f2.setAutoReverse(false);
		
		FadeTransition ft1 = new FadeTransition(Duration.seconds(3), logo);
		ft1.setFromValue(0);
		ft1.setToValue(99);
		ft1.setCycleCount(1);
		
		FadeTransition ft2 = new FadeTransition(Duration.seconds(3), title);
		ft2.setFromValue(0);
		ft2.setToValue(99);
		ft2.setCycleCount(1);
		
		f3 = new FillTransition(Duration.seconds(3), title, new Color(Math.random(), Math.random(), Math.random(), Math.random()), new Color(Math.random(), Math.random(), Math.random(), Math.random()));
		f3.setCycleCount(Animation.INDEFINITE);
		f3.setDelay(Duration.seconds(1));
		f3.setAutoReverse(true);
		f3.setRate(14);
		f3.play();
		
		RotateTransition rt2 = new RotateTransition(Duration.seconds(3),start);
		rt2.setByAngle(360);
		rt2.setRate(10);
		rt2.setDelay(Duration.seconds(3.5));
		rt2.setCycleCount(3);
		rt2.play();
		
		TranslateTransition t2 = new TranslateTransition(Duration.seconds(3),start);
		t2.setToX(485);
		t2.setDelay(Duration.seconds(2));
		t2.setCycleCount(1);
		t2.play();
		
		ParallelTransition pt = new ParallelTransition(tt1, tt2, f1, f2);
		pt.play();
		SequentialTransition sqt = new SequentialTransition(ft1, ft2);
		sqt.play();
	}
	
	public static final ImageView getLogo()
	{
		return logo;
	}
	public static final void setLogo(ImageView logo)
	{
		StartPane.logo = logo;
	}
	public static final Text getTitle() 
	{
		return title;
	}
	public static final void setTitle(Text title)
	{
		StartPane.title = title;
	}
	public static final Button getStart() 
	{
		return start;
	}
	public static final void setStart(Button start)
	{
		StartPane.start = start;
	}
	public static final Rectangle getBack1() 
	{
		return back1;
	}
	public static final void setBack1(Rectangle back1)
	{
		StartPane.back1 = back1;
	}
	public static final Rectangle getBack2()
	{
		return back2;
	}
	public static final void setBack2(Rectangle back2) 
	{
		StartPane.back2 = back2;
	}

	public synchronized final FillTransition getF3() 
	{
		return f3;
	}

}
