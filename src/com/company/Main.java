package com.company;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        File toyFile = null;
        try{
            toyFile = new File("toyFile.txt");

            if(!toyFile.exists())  toyFile.createNewFile();

        } catch (IIOException e){
            System.out.println("error: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }



        ArrayList<Toys> array = new ArrayList();
        Toys toy1 = new Toys(1, "машина", 10);
        Toys toy2 = new Toys(2, "робот", 15);
        Toys toy3 = new Toys(3, "самолет", 20);
        Toys toy4 = new Toys(4, "кукла", 15);
        Toys toy5 = new Toys(5, "мяч", 15);
        Toys toy6 = new Toys(6, "юла",  25);

        System.out.println("Игра началась!");
        boolean game = true;
        Scanner in = new Scanner(System.in);
        while (game){
            moveToys(in, game);
            getToys(toyFile, in);
       }
        in.close();
        showAllToys();
    }

    public static boolean moveToys(Scanner in, boolean game){
        System.out.println("Хотите разыграть игрушку?");
        String answer = in.nextLine();
        if (answer.equals("да")){
            System.out.println("выпала игрушка машина");
        }
        if (answer.equals("нет")){
            System.out.println("игра закончилась");
             game = false;
        }
        return game;
    }

    public static void getToys(File toyFile, Scanner in) throws FileNotFoundException {

        System.out.println("Хотите забрать игрушку?");
        String answer1 = in.nextLine();
        if (answer1.equals("да")){
            System.out.println("игрушка машина добавлена в ваше хранилище");
        }
        if (answer1.equals("нет")){
            System.out.println("продолжаем игру");
        }

        PrintWriter pw = new PrintWriter(toyFile);
        pw.println("Toy added in you bag");
        pw.close();
    }

    public static void showAllToys() throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("toyFile.txt"));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }

}

