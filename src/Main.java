import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window;
    Scene scene1;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setOnCloseRequest(e -> {
            e.consume(); //consumed event, it won't close the program automatically
            closeProgram();
        });


        Button button1 = new Button("Check your feed");
        button1.setOnAction(e -> AlertBox.display("News feed", "Click button to close"));
        Button button2 = new Button("Add player");
        button2.setOnAction(e -> {
            String addedPlayer = AddPlayer.display("Add Player", "Enter player name: ");
            System.out.println(addedPlayer);
        });
        Button button3 = new Button("Return to desktop");
        button3.setOnAction(e-> closeProgram());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(button1, button2, button3);
        layout.setAlignment(Pos.CENTER);
        scene1 = new Scene(layout, 200, 200);

        window.setTitle("LOLNews");
        window.setScene(scene1);
        window.show();
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Closing", "Are you sure you wish to exit?");
        if (answer) window.close();
    }
}