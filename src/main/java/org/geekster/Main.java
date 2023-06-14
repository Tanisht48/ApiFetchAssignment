package org.geekster;



import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("please Enter 1 or 2 for which Api you want");
        int flag = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the URL from which You want to Fetch");
        if(flag==1) {
            Jokes joke = new Jokes();
            joke.connectionBuilder(sc.nextLine());
            joke.Display();
        }
        else {
            ZipCodes zip = new ZipCodes();
            zip.connectionBuilder(sc.nextLine());
            zip.Display();
        }

    }
}