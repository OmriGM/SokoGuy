package view;

import SokoDB.Score;
import SokoDB.SokoDBManager;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class LevelTableViewer extends Application {
	@FXML
    private TableView<Score> table = new TableView();

    String levelName;
    String userInput;
    String lvlInput;
//    public static void main(String[] args) {
//        launch(args);
//    }
    public LevelTableViewer(String levelName) {
		this.levelName=levelName;
	}
    @Override
    public void start(Stage stage) {
    	Scene scene = new Scene(new Group());
        stage.setTitle("Score Table");
        stage.setWidth(420);
        stage.setHeight(600);
        
        
        scene.getStylesheets().add("TableStyle.css");
        
        
        Label label = new Label(levelName + " Score Table");
        label.setFont(new Font("Ariel", 20));
        
        TextField txtF=new TextField("");
        TextField txtF2=new TextField("");
        txtF.setMaxWidth(150);
        txtF2.setMaxWidth(150);
        txtF.setPromptText("Enter Username here");
        txtF2.setPromptText("Enter Level name here");
        
        table.setEditable(true);
        TableColumn<Score,String> idCol=new TableColumn<>("ID");
        TableColumn<Score,String> lvlCol=new TableColumn<>("Level Name");
        TableColumn<Score,String> userNameCol=new TableColumn<>("Username");
        TableColumn<Score,String> stepsCol=new TableColumn<>("Steps");
        TableColumn<Score,String> timeCol=new TableColumn<>("Time");
        
        idCol.setCellValueFactory(new PropertyValueFactory<Score,String>("id"));
        lvlCol.setCellValueFactory(new PropertyValueFactory<Score,String>("levelName"));
        userNameCol.setCellValueFactory(new PropertyValueFactory<Score,String>("userName"));
        stepsCol.setCellValueFactory(new PropertyValueFactory<Score,String>("steps"));
        timeCol.setCellValueFactory(new PropertyValueFactory<Score,String>("time"));
        
        idCol.setVisible(false);
        lvlCol.setVisible(false);
        
        Button searchButton=new Button("Search");
        searchButton.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {				
				userInput=txtF.getText();
				lvlInput=txtF2.getText();
				ObservableList<Score> data=null;
				if(!(txtF2.getText().isEmpty())&&txtF.getText().isEmpty())					
					data= SokoDBManager.getScoreList(lvlInput,"");			
				else if(!(txtF.getText().isEmpty())&&txtF2.getText().isEmpty()){
					data= SokoDBManager.getScoreList("",userInput);	
					userNameCol.setVisible(false);
				}
				else if(!(txtF.getText().isEmpty()&&!(txtF2.getText().isEmpty()))){
					data= SokoDBManager.getScoreList(lvlInput,userInput);
					lvlCol.setVisible(false);
				}
				
				lvlCol.setVisible(true);
		        table.setItems(data);
			}
		});
       // table.setStyle("-fx-alignment: CENTER;");
        table.setRowFactory( tv -> {
            TableRow<Score> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Score rowData = row.getItem();
                    ObservableList<Score> data= SokoDBManager.getScoreList("",rowData.getUserName());                    
    		        table.setItems(data);  
    		        label.setText(rowData.getUserName()+" Score Table");
    		        userNameCol.setVisible(false);
    		        lvlCol.setVisible(true);
                }
            });
            return row ;
        });
		ObservableList<Score> data= SokoDBManager.getScoreList(levelName,"");
        table.setItems(data);        
        table.getColumns().remove(0, table.getColumns().size());             
        table.getColumns().addAll(lvlCol,userNameCol, stepsCol, timeCol);
        table.setMaxHeight(table.getMaxHeight());
        
        final HBox hb = new HBox();
        hb.getChildren().addAll(txtF,txtF2,searchButton);
        hb.setSpacing(5);
        
        Button nextP=new Button(">");
        Button prevP=new Button("<");
        Button goToPage=new Button("Go");
        TextField pageNum=new TextField();
        pageNum.setPromptText("Enter page");
        final HBox hb2 = new HBox();
        hb2.getChildren().addAll(pageNum,goToPage,prevP,nextP);
        hb2.setSpacing(5);

        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 2, 0, 10));
        vbox.getChildren().addAll(label,hb, table,hb2);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
}