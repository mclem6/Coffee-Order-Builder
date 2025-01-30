import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.image.*;

public class MyController implements Initializable{

    @FXML
    private BorderPane root1;

    @FXML
    private Button orderBtn;

    @FXML
    private Button restartBtn;

    @FXML
    private Button addToCartBtn;

    @FXML
    private TextArea orderTextArea;

    @FXML
    private TextArea cartTextArea;

    @FXML
    private Text orderTotalText;


    BuildOrder newOrder;


    

    @Override
    public void initialize(URL location, ResourceBundle resources){

        newOrder = new BuildOrder();
        


    }

    public void pressOrderBtn(ActionEvent e) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/orderScene.fxml"));
        Parent root2 = loader.load();
		MyController myctr = loader.getController();
		root2.getStylesheets().add("/styles/styleOrder.css");
		root1.getScene().setRoot(root2);

    }

    public void pressXtraShotBtn(ActionEvent e) throws IOException{
        
        //add extra shot
        //update screen with item and total updated
        newOrder.addShot();
        orderTextArea.appendText("\n+ extra shot: $1.20");
        orderTotalText.setText("Total: " + newOrder.order_total);

        

    }

    public void pressSugarBtn(ActionEvent e) throws IOException{
        
        //add extra shot
        //update screen with item and total updated
        newOrder.addSugar();
        orderTextArea.appendText("\n+ sugar: $.50");
        orderTotalText.setText("Total: " + newOrder.order_total);
    
    }

    public void pressCreamBtn(ActionEvent e) throws IOException{
        
        //add extra shot
        //update screen with item and total updated
        newOrder.addCream();
        orderTextArea.appendText("\n+ cream: $.50");
        orderTotalText.setText("Total: " + newOrder.order_total);
        
        //update screen with order detail
        

    }

    public void pressCinnamonBtn(ActionEvent e) throws IOException{
        
        //add extra shot
        //update screen with item and total updated
        newOrder.addCinnamon();
        orderTextArea.appendText("\n+ cinnamon: $.33");
        orderTotalText.setText("Total: " + newOrder.order_total);
        
        //update screen with order detail

    }
        


    public void pressVanillaBtn(ActionEvent e) throws IOException{
    
        //add extra shot
        //update screen with item and total updated
        newOrder.addVanilla();
        orderTextArea.appendText("\n+ vanilla: $.33");
        orderTotalText.setText("Total: " + newOrder.order_total);
        
        //update screen with order detail
        

    }


    public void restartBtn(ActionEvent e) throws IOException{
        newOrder.restartOrder();
        orderTextArea.setText("Black coffee: $4.50");
        orderTotalText.setText("Total: " + newOrder.order_total);
    }

    public void addToCartBtn(ActionEvent e) throws IOException{

        //display order below
        cartTextArea.setVisible(true);
        cartTextArea.setText(newOrder.orderDetails + "\nTotal: $" + newOrder.order_total);

        //reset order details
        newOrder.restartOrder();
        orderTextArea.setText("Black coffee: $4.50");
        orderTotalText.setText("Total: " + newOrder.order_total);
    }
   
    


    
}
