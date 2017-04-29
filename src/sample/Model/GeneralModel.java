package sample.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Great Alexander on 24.04.2017.
 */
public class GeneralModel {

    private File openedFile = null;
    private static volatile GeneralModel instance;

     public static GeneralModel getInstance() {
        GeneralModel localInstance = instance;
        if (localInstance == null) {
            synchronized (GeneralModel.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new GeneralModel();
                }
            }
        }
        return localInstance;
    }

    public void saveFile(String text) {
        if(openedFile!=null){
            try {
                if(FileAlreadyExists.getInstance()==null){
                    new FileAlreadyExists();
                }else{
                    FileAlreadyExists.getInstance().show();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            newFile();
            save(text);
        }
    }

    public void createNewFile() {
        openedFile = null;
    }

    private void save(String text) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            fileWriter = new FileWriter(openedFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void newFile(){
        int name = 0;
        while (true){
            name +=1;
            if(!(new File(Integer.toString(name)+".txt").exists())) {
                openedFile = new File(Integer.toString(name)+".txt");
                break;
            }
        }
        System.out.println(openedFile);
    }

}
