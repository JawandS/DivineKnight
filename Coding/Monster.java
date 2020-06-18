import java.awt.event.*;
import javax.swing.*;  //to access JFrame and JPanel
import java.awt.*;     //to access Graphics and Color
import java.awt.event.*;//to access Listeners
import java.awt.geom.*; //to access GeneralPath
import javax.swing.Timer;

public class Monster
{
//other value
   private int w, h, l, t; //width and height, left and top of the knight
   int id;
   ImageIcon mImage;

//main attributes
   int health;
   int attack;
   int defense;
 
 //constructor
   public Monster(int he, int a, int d, int id, int w, int h, int l, int t){
      health = he;
      attack = a;
      defense = d;
      this.id = id;
      
      this.w = w;
      this.h = h;
      this.l = l;
      this.t = t;
      
   }
   
 //methods
   public void mAttack(Knight k, Monster m){//Attack method for monster
      int damage = m.getAttack() - k.getDefense(k);
      
      if (damage > 0)
         k.setHealth(k.getHealth() - damage);
   }
 
 //getters
   public int getHealth(){
      return health;
   }
 
   public int getAttack(){
      return attack;
   }
 
   public int getDefense(){
      return defense;
   }
   
   //setters
   public void setHealth(int i){
      health = i;
   }
   
   public void setAttack(int i){
      defense = i;
   }
   
   public void setDefense(int i){
      defense = i;
   }
   
   //Animation
   public void draw(Graphics g){
   
      if(getImage()!=null){                            //if the sprite has an image
         g.drawImage(getImage().getImage(),(int) l,(int) t, w, h, null); 
      } else {
         System.out.println("Oops, image not found (Monster class)");
      }
   }
   
   public int getLeft(){
      return l;
   }
   
   public void setLeft(int i){
      l = i;
   }

   public ImageIcon getImage(){
      return mImage;
   }
   
   public void setImage(ImageIcon mImage){
      this.mImage=mImage;
   }
  
}