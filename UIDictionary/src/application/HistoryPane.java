package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.DepthTest;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HistoryPane extends FlowPane
{
	private static Text title;
	private static Text  hist;
	private static String temp;
	private static Stack<String> words = new Stack<>();
	private static Stack<String> meanings = new Stack<>();
	private static ArrayList<String> all = new ArrayList<>();
	private static HashMap<String, String> history = new HashMap<>();
	private static Set<Map.Entry<String, String>> hlist = history.entrySet();
	private static Button clear;
	private static File file = new File ("D:\\Umair Doc\\Java Program\\UIDictionary\\History.txt");

	public HistoryPane() 
	{
		super();
		setPadding(new Insets(20));
		setStyle("-fx-background-color:	#49ab81; -fx-border-color:grey;  -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		setPrefSize(600, 800);
		
		title = new Text(" HISTORY ");
		title.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.REGULAR, 50));
		title.setFill(Color.rgb(0,255,0));
		title.setStroke(Color.rgb(107,142,35));
		title.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		title.setDepthTest(DepthTest.ENABLE);
		title.setBlendMode(BlendMode.SRC_ATOP);
		title.setLayoutY(5);
		title.setLayoutX(250);
		
		temp = "";
		
		hist = new Text();
		hist.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 13));
		hist.setFill(Color.BLACK);
		hist.setStroke(Color.GREY);
		hist.setStyle("-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );");
		hist.setDepthTest(DepthTest.ENABLE);
		hist.setBlendMode(BlendMode.SRC_ATOP);
		hist.setLayoutY(240);
		hist.setLayoutX(19);
		
		clear = new Button(" Clear ");
		clear.setPadding(new Insets(10));
		clear.setAlignment(Pos.CENTER);
		clear.setBlendMode(BlendMode.SRC_OVER);
		clear.setStyle("-fx-background-color: #00FF7F; -fx-background-radius: 40; -fx-border-color:#98FB98; -fx-border-radius: 40; -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.7) , 10,0,0,1 ); -fx-effect: innershadow( gaussian , rgba(0,0,0,0.7) , 20,0,0,0 );"); 
		clear.setLayoutX(5);
		clear.setLayoutY(710);
		clear.setDepthTest(DepthTest.INHERIT);
		clear.setFont(Font.font("Georgia", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 12));
		
		
		getChildren().addAll(title, hist, clear);
	}
	
	
	public static void writeInFile(String info)
	{
		int i = 0;	
		 
		try
		{
			file.createNewFile();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter (file, true));
			
			do
			{
				writer.write(info.charAt(i));
				
				if (info.charAt(i) == '\n')
				{
					writer.newLine();
				}
				i++;
			}
			while(i < info.length());
			
			writer.close();
			
		}
		catch (IOException io) {};
		
		
	}
	public static void readFormFile()
	{ 
		BufferedReader reader = null;
		
		try
		{
			file.createNewFile();
			
			 reader = new BufferedReader(new FileReader (file));
			 String line;
			 
			while((line = reader.readLine()) != null)
			{
				all.add(line);
			}
			 	
			reader.close();
			
			
		}
		catch (IOException io) {}
		finally
		{
			try
			{
				reader.close();
			}
			catch(IOException io) {}
		}
		
	}
	
	
	public static void rememberHistory(String word, String meanings)
	{	
        writeInFile(word + "\n" + meanings + "\n");

	}
	
	public static String showHistory()
	{
		readFormFile();
		boolean checker = true;
		
		for(int k = 0 ; k < all.size(); k+=2)
		{
			if(checker)
			{
				words.push(all.get(k));
				checker = false;
			}
			else
			{
				meanings.push(all.get(k));
				checker = true;
			}
			
		}
		
		int size = words.size();
		int j = 1;
		
		while(j < size)
		{
			//history.put(j + ". " + words.pop() + "\n", meanings.pop() + "\n");
			temp = temp.concat(j + ". " + words.pop() + "\n" + meanings.pop() + "\n");
			j++;
		}
		
		for(Map.Entry<String, String> hl : hlist)
		{
			//temp = temp.concat(hl.getKey() + "\n" + hl.getValue() + "\n");
			
		}
	
		return temp;
			
	}

	public static final Text getTitle() {
		return title;
	}

	public static final void setTitle(Text title) {
		HistoryPane.title = title;
	}

	public static final Button getClear() {
		return clear;
	}

	public static final void setClear(Button clear) {
		HistoryPane.clear = clear;
	}


	public static final HashMap<String, String> getHistory() {
		return history;
	}


	public static final void setHistory(HashMap<String, String> history) {
		HistoryPane.history = history;
	}


	public static final Text getHist() {
		return hist;
	}


	public static final void setHist(String txt) 
	{
		hist.setText(txt);
		
	}


	public static final File getFile() {
		return file;
	}


	public static final void setFile(File file) {
		HistoryPane.file = file;
	}
	
	
	

}
