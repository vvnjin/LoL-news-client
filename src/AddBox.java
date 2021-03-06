

import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.layout.VBox;
        import javafx.stage.Modality;
        import javafx.stage.Stage;

/**
 * Created by Justin on 5/31/2015.
 */
public class AddBox {

    public static void display(String title, String message) {
        Stage window = new Stage();

        //Block other windows' input events until this window is closed
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);
        Button addPlayer = new Button("Add Player");

        addPlayer.setOnAction(e -> {
            String addedPlayer = AddPlayer.display("Add Player", "Enter Info");
            System.out.println(addedPlayer);
        });

        Button addTeam = new Button("Add Team");

       /* addTeam.setOnAction(e -> {
            String addedTeam = AddTeam.display("Add Team", "Enter team name: ");
            System.out.println(addedTeam);
        });*/

        Button addRegion = new Button ("Add Region");
        Button addChampion = new Button("Add Champion");
        Button addNewsItem = new Button("Add News");
        Button addMatch = new Button("Add Match");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,addRegion,addChampion,addMatch,addNewsItem,addPlayer, addTeam);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(5));

        Scene scene = new Scene(layout);
        window.setScene(scene);

        //Shows this stage and waits for it to be hidden (closed) before returning to the caller.
        window.showAndWait();
    }

}

