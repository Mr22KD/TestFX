package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Person;
import ch.makery.address.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application 
{
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	
	public MainApp()
	{
		// Add some sample data
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
	}
	
	/**
     * Returns the data as an observable list of Persons. 
     * @return
     */
    public ObservableList<Person> getPersonData() 
    {
        return personData;
    }
	
	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("AddressApp");
		
		initRootLayout();
		showPersonOverview();
	}

	//Initializes the root layout
	public void initRootLayout() 
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();	
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void showPersonOverview() 
	{
		 try 
		 {
			 // Load person overview.
	         FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
	         AnchorPane personOverview = (AnchorPane) loader.load();

	         // Set person overview into the center of root layout.
	         rootLayout.setCenter(personOverview);
	         
	         PersonOverviewController controler = loader.getController();
	         controler.setMainApp(this);
	         
	     }catch(IOException e) 
		 {
	    	 e.printStackTrace();
	     }
	}
	
	public Stage getPrimaryStage() 
	{
        return primaryStage;
    }

	public static void main(String[] args) 
	{
		launch(args);
	}
}