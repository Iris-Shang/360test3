package calctest;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import app.CalculatorApp;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CalcModel;
import model.Operation;
import view.MainController;


@SuppressWarnings("unused")
@ExtendWith(ApplicationExtension.class)
public class Calcapptest extends ApplicationTest {

	CalcModel tm;
    @Start
    public void start(Stage stage)
    {
         
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(MainController.class.getResource("main.fxml"));

      try {
  	    BorderPane view = loader.load();
  	    MainController cont = loader.getController();
  	    CalcModel model =new CalcModel(); 
  	    cont.setModel(model);
        Scene s = new Scene(view);
        stage.setScene(s);
        stage.show();
     
      
      

      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();}
      }
    
    @SuppressWarnings("unchecked")
    ListView<Operation> getops(FxRobot robot)

    {
     return (ListView<Operation>) robot.lookup("#HistoryView")
         .queryAll().iterator().next();
    }
    
    @Test
    public void addtest(FxRobot robot)
    {
    	ListView <Operation> ops = getops(robot);
    	Assertions.assertThat(ops).isEmpty();
    	
    	robot.clickOn("#num1");
    	robot.write("40");
    	robot.clickOn("#num2");
    	robot.write("4");
    	robot.clickOn("#addb");
        Assertions.assertThat(robot.lookup("#ResultLabel")
        		.queryAs(Label.class)).hasText("44");
        
    	robot.clickOn("#subb");
        Assertions.assertThat(robot.lookup("#ResultLabel")
        		.queryAs(Label.class)).hasText("36");
        
    	robot.clickOn("#multib");
        Assertions.assertThat(robot.lookup("#ResultLabel")
        		.queryAs(Label.class)).hasText("160");
    	robot.clickOn("#num1");
    	robot.write("30");
    	robot.clickOn("#num2");
    	robot.write("3");
    	robot.clickOn("#divideb");
        Assertions.assertThat(robot.lookup("#ResultLabel")
        		.queryAs(Label.class)).hasText("10");
    	
    	ops = getops(robot);
    	
    	Operation [] check1 = {
    			new Operation(40,"+",4,44),
    			new Operation(40,"-",4,36),
    			new Operation(40,"*",4,160),
    			new Operation(30,"/",3,10),
    			};
        Assertions.assertThat(ops).hasExactlyNumItems(check1.length);
    //  ObservableList<Operation> operations  = tm.getOperations();
        //assertEquals(ops,operations);
        for(Operation i: check1)
        {
        	Assertions.assertThat(ops).hasListCell(i); 
          
        }
    	
    }
}