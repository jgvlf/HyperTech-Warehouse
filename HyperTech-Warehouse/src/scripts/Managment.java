package scripts;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Managment implements SetFile{
    private String path;
    String msg;
    List<List<String>> registro;
    public Managment(){

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean createFile() {
        boolean situation = true;
        File file = new File(this.path);
        try {
            boolean value = file.createNewFile();
            if (!value) {
                situation = false;
            }
        }
        catch(Exception e) {
            e.getStackTrace();
        }
        return situation;
    }

    @Override
    public List<List<String>> listRegister() {
        registro = new ArrayList<>();
        String[] dados;
        String[] charc = null;
        try {
            File myObj = new File(this.path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.equals("")) {
                    charc = data.split("-&%&-");
                    registro.add(List.of(charc));
                }
            }
                myReader.close();
            } catch(FileNotFoundException e){
                System.out.println("Um erro ocorreu.");
                e.printStackTrace();
            }
            return registro;
        }

    @Override
    public void readFile() {
        try {
            File myObj = new File(this.path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.equals("")) {
                    System.out.println(data+"\n");
                }
                else
                    System.out.print(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Um erro ocorreu.");
            e.printStackTrace();
        }
    }

    @Override
    public void writeFileAppend() {
        try {
            FileWriter myWriter = new FileWriter(this.path, true);
            myWriter.write(this.msg+"\n\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Um erro ocorreu.");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContent(String texto) {
        String[] carac;
        boolean find = false;
        for (int itens = 0; itens<registro.size(); itens++) {
            for (String elementos: registro.get(itens)) {
                carac = elementos.split(",");
                for (String top: carac) {
                    if (top.equals(texto)){
                        registro.remove(registro.get(itens));
                        find = true;
                    }
                }
            }
        }
        if (!find){
            System.out.println("Palavra não encontrada.");
        }
    }
}
