/*  demo cach hoat dong cua class Runtime  */
package demo;

import java.io.IOException;
import java.util.Scanner;

public class DemoRuntime {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String op = "";
        Runtime run = Runtime.getRuntime();

        while (true) {
            System.out.println("\n +++ MENU +++");
            System.out.println("1. open Casio");
            System.out.println("2. open NotePad");
            System.out.println("3. exit");
            System.out.print(" plz choice [1-3]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1" ->  run.exec("calc");
                case "2" ->  run.exec("notepad");
                case "3" -> { run.exit(0); }
                default -> System.err.println(" Wrong option !");
            }
        }
    }
}
