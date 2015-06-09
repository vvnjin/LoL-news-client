import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    Stage window, login;
    Scene scene1;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        login = primaryStage;
        //START: login screen
        login.setTitle("Log In");
        login.setMaxHeight(100);
        login.setResizable(false);
        TextField username = new TextField();
        username.setPromptText("User");
        TextField password = new TextField();
        password.setPromptText("Password");
        //Label logIn = new Label("Log in:");
        Button logInButton = new Button("Login");
        logInButton.setMinHeight(60);

        //Login screen layout
        HBox loginHBox = new HBox(5);
        loginHBox.setPadding(new Insets(5));
        VBox fields = new VBox (5);
        fields.setPadding(new Insets(5));
        fields.getChildren().addAll(username,password);
        loginHBox.getChildren().addAll(fields, logInButton);
        logInButton.setOnAction(e -> {login.close();mainMenu();});
        Scene loginScene = new Scene(loginHBox);

        //Start window
        login.setOnCloseRequest(e -> {
            e.consume(); //consumed event, it won't close the program automatically
            closeProgram(login);
        });
        login.setScene(loginScene);
        login.show();
    }

    private void mainMenu() {
        window = new Stage();
        window.setOnCloseRequest(e -> {
            e.consume(); //consumed event, it won't close the program automatically
            closeProgram(window);
        });
        //Post-login: Main menu
        Button button1 = new Button("Check your feed");
        button1.setOnAction(e -> AlertBox.display("News feed", "Click button to close"));
        Button button2 = new Button("Add player");
        button2.setOnAction(e -> {
            String addedPlayer = AddPlayer.display("Add Player", "Enter player name: ");
            System.out.println(addedPlayer);
        });
        Button button3 = new Button("Return to desktop");
        button3.setOnAction(e-> closeProgram(window));
        Button button4 = new Button("Search");
        button4.setOnAction(e->SearchFor.display());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(button1, button2, button4, button3);
        layout.setAlignment(Pos.CENTER);
        scene1 = new Scene(layout, 200, 200);

        window.setTitle("LOLNews");
        window.setScene(scene1);
        window.show();
    }

    private void closeProgram(Stage stage) {
        Boolean answer = ConfirmBox.display("Closing", "Are you sure you wish to exit?");
        if (answer) stage.close();
    }
}