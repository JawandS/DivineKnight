import java.awt.event.*;
import javax.swing.*;  //to access JFrame and JPanel
import java.awt.*;     //to access Graphics and Color
import java.awt.event.*;//to access Listeners
import java.awt.geom.*; //to access GeneralPath
import javax.swing.Timer;

public class Sword{//change class name
   private ImageIcon mImage;
   private int w, h, l, t;

   public Sword(int w, int h, int l, int t){//change class name
      this.w = w;
      this.h = h;
      this.l = l;
      this.t = t;
      mImage = new ImageIcon("sword.png");//change for image
   }
   
   public ImageIcon getImage(){
      return mImage;
   }
   
   public int getLeft(){
      return l;
   }
   
   public int getRight(){
      return l + w;
   }
   
   public void setLeft(int i){
      l = i;
   }
   public void draw(Graphics g){
   
      if(getImage()!=null){                            //if the sprite has an image
         g.drawImage(getImage().getImage(),(int) l,(int) t, w, h, null); 
      } else {
         System.out.println("ERROR: IMAGE NOT FOND (SWORD.JAVA)");
      }
   
   }
}

class Bull{//change class name
   private ImageIcon mImage;
   private int w, h, l, t;

   public Bull(int w, int h, int l, int t){//change class name
      this.w = w;
      this.h = h;
      this.l = l;
      this.t = t;
      mImage = new ImageIcon("bull.jpg");//change for image
   }
   
   public ImageIcon getImage(){
      return mImage;
   }
   
   public int getLeft(){
      return l;
   }
   
   public int getRight(){
      return l + w;
   }
   
   public void setLeft(int i){
      l = i;
   }
   public void draw(Graphics g){
   
      if(getImage()!=null){                            //if the sprite has an image
         g.drawImage(getImage().getImage(),(int) l,(int) t, w, h, null); 
      } else {
         System.out.println("ERROR: IMAGE NOT FOND (SWORD.JAVA)");
      }
   
   }
}

class Poison{//change class name
   private ImageIcon mImage;
   private int w, h, l, t;

   public Poison(int w, int h, int l, int t){//change class name
      this.w = w;
      this.h = h;
      this.l = l;
      this.t = t;
      mImage = new ImageIcon("poison.jpg");//change for image
   }
   
   public ImageIcon getImage(){
      return mImage;
   }
   
   public int getLeft(){
      return l;
   }
   
   public int getRight(){
      return l + w;
   }
   
   public void setLeft(int i){
      l = i;
   }
   public void draw(Graphics g){
   
      if(getImage()!=null){                            //if the sprite has an image
         g.drawImage(getImage().getImage(),(int) l,(int) t, w, h, null); 
      } else {
         System.out.println("ERROR: IMAGE NOT FOND (SWORD.JAVA)");
      }
   
   }
}