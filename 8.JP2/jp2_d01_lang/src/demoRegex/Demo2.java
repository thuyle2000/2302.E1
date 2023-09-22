/*  demo bieu thuc qui tac  */
package demoRegex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Demo2 {

    public static void main(String[] args) {
        testCity();
        
        String name = "      anh      hoang  ";
        System.out.printf("[%s] -> [%s]\n" , name, allTrim(name));
    }
    
    private static void testCity(){
        Scanner sc = new Scanner(System.in);
        System.out.print(" - nhap thanh pho (HN/SG/CT/HU): ");
        String city = sc.nextLine().trim();
        
        if(Pattern.matches("(?i)(hn|sg|hu|ct)", city)){
            System.out.printf("[%s] : chuoi hop le !\n", city);
        }
        else{
            System.out.printf("LOI:[%s]->Du Lieu Ko Hop Le!\n", city);
        }
    }
    
    private static String allTrim(String s){
        return s.trim().replaceAll("\\s+", " ");
    }
    
    
}
