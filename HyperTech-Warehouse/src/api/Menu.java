package api;

import scripts.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public Menu() throws InterruptedException {
        System.out.println("Iniciando Software");
        Thread.sleep(3000);
    }
    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int cc = 3;
        ArrayList<String> lista = new ArrayList<>();
        List<String> split;
        System.out.println("Bem-vindo!");
        Managment log = new Managment();
        Managment estoque = new Managment();
        estoque.setPath("src\\archive\\produtos.txt");
        log.setPath("src\\log\\log.txt");
//        if (log.createFile())
//            System.out.println(log.createFile());
//        log.createFile();
        estoque.setMsg("Oi, Mundo, !");
        estoque.writeFileAppend();

        estoque.setMsg("Hello, World, !");
        estoque.writeFileAppend();

        System.out.println(estoque.listRegister());

        System.out.println("O que deseja remover?");
        String tex = scanner.nextLine();
        estoque.deleteContent(tex);

        System.out.println(estoque.listRegister());
    }
}
