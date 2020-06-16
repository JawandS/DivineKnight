import java.util.*;

//file for the driver
//DK = Divine Knight

public class DKdriver{

   public static void main(String[] args){
   
      

   
   }
}

/*TEST 3
LHelmet h = new LHelmet(); 
      LChestplate c = new LChestplate();
      LBoots b = new LBoots();
      LGauntlets g = new LGauntlets();
      WWeapon w = new WWeapon();
      
      RatPack r = new RatPack();
      
      Knight k = new Knight (h, c, g, b, w);
      
      k.kAttack(false, 0, k, r);
      System.out.println("Knight Attacked, Monster health:" + r.getHealth()); //Monster health
      
      r.mAttack(k, r);
      System.out.println("Monster Attacked, Knight health:" + k.getHealth()); //Knight health
      
      RESULT: works, adjust value to realist settigns
*/


/*LIST OF BASIC GEAR
LHelmet h = new LHelmet(); 
LChestplate c = new LChestplate();
LBoots b = new LBoots();
LGauntlets g = new LGauntlets();

TOTAL DEF: 13

IHelmet h = new IHelmet(); 
IChestplate c = new IChestplate();
IBoots b = new IBoots();
IGauntlets g = new IGauntlets();

TOTAL DEF: 37

CHelmet h = new CHelmet(); 
      CChestplate c = new CChestplate();
      CBoots b = new CBoots();
      CGauntlets g = new CGauntlets();

TOTAL DEF: 113

THelmet h = new THelmet(); 
      TChestplate c = new TChestplate();
      TBoots b = new TBoots();
      TGauntlets g = new TGauntlets();

TOTAL DEF: 341

EHelmet h = new EHelmet(); 
      EChestplate c = new EChestplate();
      EBoots b = new EBoots();
      EGauntlets g = new EGauntlets();
      
TOTAL DEF: 1701


*/

/* TEST 2
 EHelmet h = new EHelmet(); 
      EChestplate c = new EChestplate();
      EBoots b = new EBoots();
      EGauntlets g = new EGauntlets();
   
      Knight k = new Knight (h, c, g, b, h);
      
      System.out.println(""+ k.getDefense(k));
      */

/* TEST 1
   
   LHelmet h = new LHelmet();
   Knight k = new Knight (h, h, h, h, h);
   
   THelmet th = new THelmet();
   
   k.setHelmet(th);
   
   System.out.println(""+k.helmet.in);
   //System.out.println((k.getg1).toString()); */
