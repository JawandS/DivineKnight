import java.util.*;

//file for the driver
//DK = Divine Knight

public class DKdriver{

   public static void main(String[] args){
   
   LHelmet h = new LHelmet();
   Knight k = new Knight (h, h, h, h, h);
   
   THelmet th = new THelmet();
   
   k.setHelmet(th);
   
   System.out.println(""+k.getHelmet());
   //System.out.println((k.getg1).toString());
   
   
   }
}
