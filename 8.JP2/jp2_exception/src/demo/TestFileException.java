package demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class TestFileException {

    public static void main(String[] args) {
        TestFileException t = new TestFileException();
        Scanner sc = new Scanner(System.in);
        System.out.print(" - nhap ten tap tin muon doc : ");
        String name = sc.nextLine().trim();
        
        try {
            t.readFile(name);
        } catch (IOException ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
        
        System.out.println("FINISHED !");
        
    }
    private void readFile(String fname) throws FileNotFoundException, IOException{
        //1. mo file co ten trong bien [fname] de doc
        BufferedReader br = new BufferedReader(new FileReader(fname));
        
        //2. doc file va hien thi cac dong len man hinh
        br.lines().forEach(System.out::println);
        
        //3. dong file
        br.close();
    }
}
