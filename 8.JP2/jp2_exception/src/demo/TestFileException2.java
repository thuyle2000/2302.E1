/*  demo try-with-resources  */
package demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestFileException2 {

    public static void main(String[] args) {
        TestFileException2 t2 = new TestFileException2();
        Scanner sc = new Scanner(System.in);
        System.out.print(" - nhap ten tap tin muon doc : ");
        String fname = sc.nextLine().trim();
        t2.readFile2(fname);
    }

    private void readFile(String fname) {
        BufferedReader br = null;
        try {
            //1. mo file co ten trong bien [fname] de doc
            br = new BufferedReader(new FileReader(fname));
            //2. doc file va hien thi cac dong len man hinh
            br.lines().forEach(System.out::println);
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestFileException2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(TestFileException2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void readFile2(String fname) {
        //2. doc file va hien thi cac dong len man hinh
        try ( //1. mo file co ten trong bien [fname] de doc
             BufferedReader br = new BufferedReader(new FileReader(fname))) {
            //2. doc file va hien thi cac dong len man hinh
            br.lines().forEach(System.out::println);
            //3. dong file
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestFileException2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestFileException2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
