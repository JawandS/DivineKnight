import java.awt.event.*;
import javax.swing.*;  //to access JFrame and JPanel
import java.awt.*;     //to access Graphics and Color
import java.awt.event.*;//to access Listeners
import java.awt.geom.*; //to access GeneralPath
import javax.swing.Timer;

public class Knight{

//variables
   int itemNumber = 0;
   private double dX, dY;
   private ImageIcon mImage;
   private int w, h, l, t; //width and height, left and top of the knight

//items
   private Gear helmet;
   private Gear chestplate;
   private Gear gauntlets;
   private Gear boots;
   private Gear weapon;

//attributes
   private int health;
   private int mana;
   private int stamina;

//ig variables
   private int gold;
   private int exp; 

//constructor 
   public Knight(Gear g1, Gear g2, Gear g3, Gear g4, Gear g5, int w, int h, int l, int t){
   
      helmet = new Gear(g1);
      chestplate = new Gear(g2);
      gauntlets = new Gear(g3);
      boots = new Gear(g4);
      weapon = new Gear(g5);
   
      this.health = 100;
      this.mana = 100;
      this.stamina = 100;
   
      gold = 0;
      exp = 0;
      
      this.w = w;
      this.h = h;
      this.l = l;
      this.t = t;
      mImage = new ImageIcon("0.jpg");
   }

//methods

   public void kAttack(boolean special, int name, Knight k, Monster m){//the method for attacks, name for specific special attack
   
      if (special==false){ 
         int damage = k.getWeapon(2) - m.getDefense();
      
         if (damage > 0)
            m.setHealth(m.getHealth() - damage);
            
         if(m.getHealth() == 0){ //DEATH SEQUENCE 
            System.out.println("Monster died");//ANIMATE HERE
            return;
         }
        
      }
   
      if(special == true){//Special Attacks
      
         if(name == 1){//Bull Rush (x2 Damage)
            int damage = 2*(k.getWeapon(2)) - m.getDefense();
            if (damage > 0){
               int stamina = k.getStamina() - 80; //stamina cost = 80
               if(stamina > 0){
                  k.setStamina(stamina);
                  m.setHealth(m.getHealth() - damage);
                  if(m.getHealth() == 0){ //DEATH SEQUENCE 
                     System.out.println("Monster died");//ANIMATION HERE
                     return;
                  }
                  //ANIMATE HERE
               }
            }
         }
      
         if(name == 2){//Slam (+50 Damage)
            int damage = 50+(k.getWeapon(2)) - m.getDefense();
            if (damage > 0){
               int stamina = k.getStamina() - 50; //stamina cost = 50
               if(stamina > 0){
                  k.setStamina(stamina);
                  m.setHealth(m.getHealth() - damage);
                  if(m.getHealth() == 0){ //DEATH SEQUENCE 
                     System.out.println("Monster died");//Death ANIMATION
                     return;
                  }
                  //ANIMATE HERE
               }
            }
         }
         
      }
   }
   
   public void kSpell(int name, Knight k, Monster m){
   
      if(name == 1){//Divine Thunder (100 points damage, ignore defense)
         if((k.getMana() - 200) > 0){//costs 200 mana
            k.setMana((k.getMana() - 200));
            m.setHealth(m.getHealth()-100);
         }
      }
      
      if(name == 2){//Poison (reduce defense and health by 15)
         if((k.getMana() - 50) > 0){//costs 50 mana
            k.setMana((k.getMana() - 50));
            m.setHealth(m.getHealth()-15);
            m.setDefense(m.getDefense() - 15);
         }
      }
   }
 
   public int getDefense(Knight k){//return knight totaled defense
      int def = k.getHelmet(2)+k.getChestplate(2)+k.getBoots(2)+k.getGauntlets(2);
      return def;
   }


//setters
   public void setHelmet(Gear g){
      helmet = g;
   }

   public void setChestplate(Gear g){
      chestplate = g;
   }

   public void setGauntlets(Gear g){
      gauntlets = g;
   }

   public void setBoots(Gear g){
      boots = g;
   }

   public void setWeapon(Gear g){
      weapon = g;
   }

   public void setHealth(int i){
      health = i;
   }

   public void setMana(int i){
      mana = i;
   }

   public void setStamina(int i){
      stamina = i;
   }

   public void setGold(int i){
      gold = i;
   }

   public void setExp(int i){
      exp = i;
   }
   
   public void setLeft(int i){
      l = i;
   }


//getter, int i represent which value you want to retireve. 1 = item number. 2 item defense. 3 item value
   public int getHelmet(int i){
      if(i==1)
         return helmet.in;
      else if(i==2)
         return helmet.id;
      else
         return helmet.iv;
   }

   public int getChestplate(int i){
      if(i==1)
         return chestplate.in;
      else if(i==2)
         return chestplate.id;
      else
         return chestplate.iv;
   } 

   public int getGauntlets(int i){
      if(i==1)
         return gauntlets.in;
      else if(i==2)
         return gauntlets.id;
      else
         return gauntlets.iv;
   }

   public int getBoots(int i){
      if(i==1)
         return boots.in;
      else if(i==2)
         return boots.id;
      else
         return boots.iv;
   }

   public int getWeapon(int i){
      if(i==1)
         return weapon.in;
      else if(i==2)
         return weapon.id;
      else
         return weapon.iv;
   }

   public int getHealth(){
      return health;
   }

   public int getMana(){
      return mana;
   }

   public int getStamina(){
      return stamina;
   }

   public int getGold(){
      return gold;
   }

   public int GetExp(){
      return exp;
   }
   
   public int getLeft(){
      return l;
   }
   
   //ANIMATION METHODS
    
   public void draw(Graphics g){
   
      if(getImage()!=null){                            //if the sprite has an image
         g.drawImage(getImage().getImage(),(int) l,(int) t, w, h, null); 
      } else {
         System.out.println("Oops, image not found (Knight class)");
      }
   
   //timer in the gui panel
   //al of the other pieces of items will be based of the pso of the knight
   //create ticks in the listnere class
   //action performed in the lsitener
   //key listener (if left go left)
   //get image from fro item nubmer
   //make the backgroudn move not the knight
   
   //make the monster move, but when the knight is moving everyhtign else moves 
   }
   
   public ImageIcon getImage(){
      return mImage;
   }
   
   public void setImage(ImageIcon mImage){
      this.mImage=mImage;
   }
   public double getdX(){
      return dX;
   }
   
   public void setdX(double dX){
      this.dX=dX;
   }
   
   public double getdY(){
      return dY;
   }
   
   public void setdY(double dY){
      this.dY=dY;
   }
   
}


/* NOTES

Has: Armor, weapon, attributes, gold, and exp (along with there getters and setter)



public void update(){        
   left += dX;
   right += dX;
   top += dY;
   bottom += dY;
   
   this.offset(dX,dY);



*/