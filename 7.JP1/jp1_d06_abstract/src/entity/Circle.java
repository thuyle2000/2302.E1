/*
 Circle la con cua class [Shape] 
 */
package entity;

import java.util.Scanner;

public class Circle extends Shape{
   public float r;
   
   @Override
   public double area(){
       return Math.PI*r*r;
   }
    
   @Override
   public double peripheral(){
       return Math.PI*r*2;
   }
   
   @Override
   public void input(){
       Scanner sc = new Scanner(System.in);
       while(true){
           System.out.print(" >> nhap ban kinh r (>0): ");
           r = Float.parseFloat(sc.nextLine().trim());
           if(r>0){
               break;
           }
       }
   }
   
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.input();
        System.out.println("Circle c1 = " + c1);
        
        Shape c2 = new Circle();
        c2.input();
        System.out.println("Shape c2 = " + c2);
    }
}
