package sample.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by student on 13.04.2017.
 */
public class FileAlreadyExists {

    private static volatile Stage instance;

    public FileAlreadyExists()  {
        try {
            create();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("fileAlreadyExists EXCEPTION");
        }
    }

    public static Stage getInstance() {
        Stage localInstance = instance;
        if (localInstance == null) {
            synchronized (FileAlreadyExists.class) {
                localInstance = instance;
                if (localInstance == null) {
                    new FileAlreadyExists();
                    localInstance = instance;
                }
            }
        }
        return localInstance;
    }

    private void create() throws Exception{
        Parent fileAlreadyExists = FXMLLoader.load(getClass().getResource("View/AlreadyExists.fxml"));
        instance = new Stage();
        instance.setTitle("Файл уже существует!");
        instance.setScene(new Scene(fileAlreadyExists,400,100));
        instance.show();
    }
}




