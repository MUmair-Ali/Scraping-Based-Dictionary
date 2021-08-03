package application;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class DictionaryPane extends Pane
{
	private static Rectangle backs1, backs2;
	private static Text word, partOfSpeech;
	private static Text defs;
	private static String [] str;
	private static String def = "";
	private static ComboBox<String> menu = new ComboBox<>();

	
	public DictionaryPane() 
	{
		super();

		backs1 = new Rectangle(0, 0, 1000, 1);
		backs2 = new Rectangle(0, 999, 1000, 1);
		backs1.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		backs1.setStrokeType(StrokeType.INSIDE);
		backs1.setFill(Color.rgb(60,179,113));
		backs2.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		backs2.setStrokeType(StrokeType.INSIDE);
		backs2.setFill(Color.WHITE);
		
		word = new Text();
		word.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
		word.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		word.setFill(Color.WHITE);
		word.setStroke(Color.ANTIQUEWHITE);
		word.setStrokeWidth(2);
		word.setLayoutX(45);
		word.setLayoutY(150);
		
		partOfSpeech = new Text();
		partOfSpeech.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.ITALIC, 25));
		partOfSpeech.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		partOfSpeech.setFill(Color.SILVER);
		partOfSpeech.setStroke(Color.ANTIQUEWHITE);
		partOfSpeech.setLayoutX(45);
		partOfSpeech.setLayoutY(190);
		
		defs = new Text();	
		defs.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        defs.setFill(Color.WHITE);
		defs.setLayoutX(30);
		defs.setLayoutY(340);	
		
		menu.setPromptText("Settings");
		menu.getItems().addAll("History");
		menu.setBlendMode(BlendMode.COLOR_BURN);
		menu.setStyle(" -fx-background-color: transparent;  -fx-border-color: transparent; -fx-background-radius:50; -fx-border-radius:50; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"); 
		menu.setPadding(new Insets(10));
		menu.setLayoutX(710);
		menu.setLayoutY(4);
		
        setPadding(new Insets(10));
		
		ScaleTransition sct1 = new ScaleTransition(Duration.seconds(3), backs1);
		sct1.setByY(-900);
		sct1.setCycleCount(1);
		sct1.play();
		
		ScaleTransition sct2 = new ScaleTransition(Duration.seconds(3), backs2);
		sct2.setByY(1400);
		sct2.setCycleCount(1);
		sct2.play();
		
		FillTransition ft1 = new FillTransition(Duration.seconds(3), backs1, Color.rgb(143,188,143),Color.rgb(57,133,100));
		ft1.setCycleCount(1);
		ft1.setDelay(Duration.seconds(1));
		ft1.setAutoReverse(false);
		ft1.play();
		
		FillTransition ft2 = new FillTransition(Duration.seconds(3), backs2, Color.WHITE, Color.rgb(82,191,144));
		ft2.setCycleCount(1);
		ft2.setDelay(Duration.seconds(1));
		ft2.setAutoReverse(false);
		ft2.play();
		
		FadeTransition fd1 = new FadeTransition(Duration.seconds(3), word);
		fd1.setFromValue(0);
		fd1.setCycleCount(1);
		fd1.setDelay(Duration.seconds(2));
		fd1.setToValue(99);
		fd1.play();
		
		FadeTransition fd2 = new FadeTransition(Duration.seconds(3), partOfSpeech);
		fd2.setFromValue(0);
		fd2.setCycleCount(1);
		fd2.setDelay(Duration.seconds(2));
		fd2.setToValue(99);
		fd2.play();
		
		FadeTransition fd3 = new FadeTransition(Duration.seconds(3), menu);
		fd3.setFromValue(0);
		fd3.setCycleCount(1);
		fd3.setDelay(Duration.seconds(2));
		fd3.setToValue(99);
		fd3.play();
		
		FadeTransition fd4 = new FadeTransition(Duration.seconds(3), defs);
		fd4.setFromValue(0);
		fd4.setCycleCount(1);
		fd4.setDelay(Duration.seconds(2));
		fd4.setToValue(99);
		fd4.play();
		
		getChildren().addAll(backs1, backs2, menu, word, partOfSpeech, defs);
		
	}
	

	public void doScrapping()
	{
		int i = 0;
		Document site = null;
		String words = SearchPane.getSearchBar().getText().toLowerCase();
		final String URL = "https://www.dictionary.com/browse/" + words;
	
		try
		{
			site = Jsoup.connect(URL).get();
		}
		catch(IOException ioe)
		{
			ExceptionPane.displayExceptionNotification("Internet Connection Problem !");
		}
		
		try
		{
			Elements pos = site.getElementsByClass("luna-pos");
			
			Elements senten = site.getElementsByAttribute("value");
			
			Element po = pos.first();
			
			word.setText(words.toUpperCase());
			
			partOfSpeech.setText("Part of Speech : " + po.text());
			
			str = new String[senten.size()];
			
			for(Element means : senten)
			{		
				str[i] = i + ". " + means.text();
				i++;
			}
			
			for(int k = 0 ; k < str.length - 1 ; k++)
			{
				def = def.concat(str[k]).concat("\n").concat("\n");
			}
			
			defs.setText(def);
			
			
			HistoryPane.rememberHistory(words, senten.get(1).text());
		
		}
		catch(Exception e)
		{
			ExceptionPane.displayExceptionNotification("Word not Found !");
		}
		
	}

	
	public static  final Rectangle getBacks1() {
		return backs1;
	}

	public static  final void setBacks1(Rectangle backs1) {
		DictionaryPane.backs1 = backs1;
	}

	public static  final Rectangle getBacks2() {
		return backs2;
	}

	public static  final void setBacks2(Rectangle backs2) {
		DictionaryPane.backs2 = backs2;
	}


	public static  final ComboBox<String> getMenu() {
		return menu;
	}

	public static  final void setMenu(ComboBox<String> menu) {
		DictionaryPane.menu = menu;
	}


	public static final String[] getStr() {
		return str;
	}


	public static final void setStr(String[] str) {
		DictionaryPane.str = str;
	}


	public static final String getDef() {
		return def;
	}


	public static final void setDef(String def) {
		DictionaryPane.def = def;
	}
	
	

	
}
