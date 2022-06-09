package api;

import scripts.Managment;

import java.util.ArrayList;

public class Start {

    public Start() throws InterruptedException {
        System.out.println("Starting the App");
        Thread.sleep(3000);
    }

    public void startApp(){
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> vaules = new ArrayList<>();

        System.out.println("Welcome!");
        Managment managment;
        managment = new Managment();
        managment.setPath("archive/produtos.json");
        managment.setObjName("Pão");
        keys.add("Lote");
        keys.add("Quantidade");
        keys.add("Validade");

        vaules.add("01923");
        vaules.add("300");
        vaules.add("10/8/2022");

        managment.writeFile(keys, vaules);

    }
}
