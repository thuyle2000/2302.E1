/*  demo bieu thuc qui tac  */
package demoRegex;

import java.util.Scanner;
import java.util.regex.*;

public class Demo1 {

    public static void main(String[] args) {
        testName();
    }

    private static void testID() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" >> nhap ma so sinh vien (STxx[xx]): ");
        String id = sc.nextLine().trim();

        //kiem tra id co dang thuc STxx[xx], voi x: ky tu so
        //1. tao qui tac mau
        Pattern p = Pattern.compile("ST\\d{2,4}");

        //2. tao doi tuong kiem tra, de xem qt mau co xh trong id ?
        Matcher m = p.matcher(id);

        //3. kiem tra
        if (m.matches()) {
            System.out.printf("[%s] la ma so hop le !\n", id);
        } else {
            System.out.printf("LOI: Ma so ko hop le !\n", id);
        }
    }

    private static void testName() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" nhap ho ten sinh vien: ");
        String name = sc.nextLine().trim();

        // kiem tra chuoi ho ten co hop le ko ?
        //(chi chua kt chu va khoang trang, tu 3->40 ky tu)
        
        //kiem tra xem chuoi [name] co khop voi qui tac duoc yc ko ?
        if (Pattern.matches("(?i)[a-z ]{3,40}", name)) {
            System.out.printf("[%s] la chuoi ho ten hop le. \n", name);
        } else {
            System.out.printf("LOI: [%s] KO HOP LE ! \n", name);
        }
    }
}
