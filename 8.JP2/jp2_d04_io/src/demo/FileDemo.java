/*  demo File class  */
package demo;

import java.io.*;
import java.util.*;
public class FileDemo {

    public static void main(String[] args) {
        listDir(); //liet ke danh sach tap tin trong thu muc
    }

    private static void listDir() {
        Scanner sc = new Scanner(System.in);
        System.out.print(">> nhap ten thu muc: ");
        String folderName = sc.nextLine().trim();
        
        File f = new File(folderName);
        if(f.exists()){
            if(f.isDirectory()){
                //liet ke ds cac tap tin trong thu muc nay
                System.out.printf("Danh sach cac tap tin(thu muc) [%s]: \n", System.getProperty("user.dir")) ;
                String[] fnames = f.list();
                for (int i = 0; i < fnames.length; i++) {
                    System.out.printf("%2d. %s\n", i+1, fnames[i]);
                }
            }
            else{
                System.out.printf("[%s] la tap tin \n", f.getPath());
            }
        }else{
            System.err.printf(">> Loi: tap tin [%s] ko ton tai\n ", f.getName());
        }
    }
    
}
