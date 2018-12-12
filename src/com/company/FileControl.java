package com.company;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;

public class FileControl {

    private String nameMainFile;
    private String nameCopyFile;

    public FileControl() {
        this.nameMainFile = "./products.ser";
        this.nameCopyFile = "./copy" + (new Date().getTime()) + ".ser";
    }

    public String getNameMainFile() {
        return nameMainFile;
    }

    public String getNameCopyFile() {
        return nameCopyFile;
    }
    //метод создания файлов. если не существует главный файл, то он создается, причем если он пуст то резерваня копия не создается,
    // в противном случае копия будет создана.
    public  void createFiles(){
        File mainFile = new File(getNameMainFile());
        File copyFile = new File(getNameCopyFile());

        if(!mainFile.exists()){
            System.out.println("файл не существует, создание файла...");
            try{
                mainFile.createNewFile();
            }
            catch (IOException ex){
                System.out.println("проблемы с созданием файла!");
            }
        }
        else{
            try{
                if(Files.size(mainFile.toPath()) == 0)
                    System.out.println("Файл пуст, резервная копия не создана.");
                else {
                    try {
                        Files.copy(mainFile.toPath(), copyFile.toPath());
                    } catch (IOException ex) {
                        System.out.println("Не удалось создать резервуную копию!");
                    }
                }
            }
            catch (IOException ex){

            }
        }
    }

    /*public void Load (String file){
        ProductsArrayList p = new ProductsArrayList();
        try{
            FileInputStream inputFile = new FileInputStream(file);
            ObjectInputStream inputObject = new ObjectInputStream(inputFile);
            p.addNewProductItems((ArrayList<Product>) inputObject.readObject());
            p.showProductArrayList();
            inputFile.close();
            inputObject.close();
            System.out.println("Данные успешно загружены из файла " + file);
        }
        catch (IOException exception){
            System.out.println("Ошибка загрузки из файла.");
            return;
        }
        catch (ClassNotFoundException exception){
            System.out.println("Класс не найден");
            exception.printStackTrace();
        }
    }*/


}
