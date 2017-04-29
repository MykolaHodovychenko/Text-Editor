package sample.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.Model.FileAlreadyExists;
import sample.Model.GeneralModel;


import java.net.URL;
import java.util.ResourceBundle;

public class FileAlreadyExistController implements Initializable{

    @FXML
    Button replace, createNew, cancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        replace.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GeneralModel.getInstance().saveFile(new GeneralController().getText());
            }
        });

        createNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GeneralModel.getInstance().createNewFile();
                GeneralModel.getInstance().saveFile(new GeneralController().getText());
            }
        });

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FileAlreadyExists.getInstance().close();
                    System.out.println(FileAlreadyExists.getInstance());
                }catch (Throwable e){
                    e.printStackTrace();
                }

            }
        });
    }
}
