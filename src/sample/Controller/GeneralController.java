package sample.Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import sample.Model.GeneralModel;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneralController implements Initializable{

    @FXML
    private TextArea text;

    @FXML
    private MenuItem save, open, create, saveAs, undo, paste, cut, copy,
                    delete, find, change, selectAll, time, font, exit, about;

    @FXML
    private CheckMenuItem nextLine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GeneralModel.getInstance().saveFile(text.getText());
                System.exit(0);
            }
        });

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GeneralModel.getInstance().saveFile(text.getText());
            }
        });

        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GeneralModel.getInstance().createNewFile();
            }
        });
    }

    public  String getText() {
        return text.getText();
    }


}
