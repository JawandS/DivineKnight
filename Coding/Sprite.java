//access ImageIcon
import javax.swing.*;
//to access Graphics and Color
import java.awt.*; 

public class Sprite extends RectF{     //inherits everything from RectF

   private double dX, dY;
   private ImageIcon mImage;
   private Color mColor=Color.black;

   public Sprite(){}
   
   public Sprite(double l, double t, double r, double b){
      super(l, t, r, b);
      ImageIcon mImage = new ImageIcon("download.jfif");
      dX=8; dY=10;
   }

  
   public Sprite(RectF f){
      super(f);
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
   
   public Color getColor(){
      return mColor;
   }
   
   public void setColor(Color mColor){
      this.mColor=mColor;
   }
   
   public ImageIcon getImage(){
      return mImage;
   }
   
   public void setImage(ImageIcon mImage){
      this.mImage=mImage;
   }
   
   public String toString() {
      return "Sprite(" + left + ", " + top + ", " + right + ", " + bottom + ")";
   }
   
   public void draw(Graphics g){ //draw itself
      if(getImage()!=null){                            //if the sprite has an image
         g.drawImage(getImage().getImage(),(int) left,(int) top,(int) getWidth(),(int) getHeight(), null); 
      } else {
         g.setColor(getColor());
         if(getWidth()>0)
            g.fillRect((int)left, (int)top, (int)getWidth(), (int)getHeight());
         else
            g.fillRect((int)left, (int)top, 2, 2);
      }
   }
   
   public void update(){        
   left += dX;
   right += dX;
   top += dY;
   bottom += dY;
   
   this.offset(dX,dY);

}

}