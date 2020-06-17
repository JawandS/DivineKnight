import java.awt.event.*;
import javax.swing.*;  //to access JFrame and JPanel
import java.awt.*;     //to access Graphics and Color
import java.awt.event.*;//to access Listeners
import java.awt.geom.*; //to access GeneralPath
import javax.swing.Timer;

public class FlappyGalaxyv1{
   public static void main(String[] arg){
      JFrame frame = new JFrame("T0Lab07LastFirstMouseListener");
      frame.setSize(1500,666);
      frame.setLocation(0,0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new DrawPanelLab07());
   
      frame.setVisible(true);
      
   }
}

class DrawPanelLab07 extends JPanel implements MouseListener, MouseMotionListener{
   public boolean vis=true;
   private Timer timer;
   private double tr = 1500;
   private double x2=10;
   private double y2=10;
   private double x3 = 850;
   private double y3=125;
   private double x4 = 915; 
   private double y4 = 200;
   private int count = 0;
   private int score=100;
   public int loss=0;
   private int secret = 0;
   private int secret2= 0;
   private int secret3 = 0;
   
   private Coke s1 = new Coke(450, 0, 525, 150);
   private Coke s2 = new Coke(650, 400, 715, 500);
   private Coke s3 = new Coke(x3, y3, x4, y4);
   private Coke s4 = new Coke(1200,400,1450,500);
   int a=0;
   int f=0;
   int s=0;
   
   int speed = 60;
   int level = 0;
   

   
   private int clicks=0;
   
   Coke sprite2 = new Coke(x2,y2,100,100);
  // Coke test = new Coke(10,10,100,100);
  
   public DrawPanelLab07(){
   
      timer = new Timer(55, new TimerListener());
   
      timer.start();
      setFocusable(true);             
      requestFocusInWindow();  
      addMouseListener(this);        
      addMouseMotionListener(this);          
      
      addKeyListener(
         new KeyAdapter(){                             
            @Override                  
            public void keyPressed(KeyEvent event) {
               if(event.getKeyCode()==KeyEvent.VK_RIGHT){
                  x2+=2;
                  sprite2.offset(x2,y2);
                  repaint();
               
               }
               
               if(event.getKeyCode()==KeyEvent.VK_UP){
                  y2-=6;
                  sprite2.offset(x2,y2);
                  repaint();
               }
               
               if(event.getKeyCode()==KeyEvent.VK_S){ //slows doen the game
                  //s++;
               }
               
               if(event.getKeyCode()==KeyEvent.VK_F){ //speeds up the game
                 // f++;
               }
               
               if(event.getKeyCode()==KeyEvent.VK_A){ //speeds up the game
                 // a++;
               }
            
            
            }
         }
         );
   }
   
   public void mousePressed(MouseEvent e) {}
   @Override public void mouseReleased(MouseEvent e) {}
   @Override public void mouseClicked(MouseEvent e) {
      clicks++;
      if(clicks>=2){ //initiates admin acess and delays for 5 millisecodns
      
      
      
         secret+=1;
      
      }    
   }
   @Override public void mouseEntered(MouseEvent e) {
      if(secret2>=1){ // gives "infinite" time and also skips into screens, don't use at lvl 2
         level++;
         tr=1000000;
       /*  if(secret3>=1){ //if you drag then initiate admin acess remvoes obstacles
            s1.setEmpty();
            s2.setEmpty();
            s3.setEmpty(); } */
        
      }
   }
   @Override public void mouseExited(MouseEvent e) {
      if(secret>=1)
         secret2+=1;
         
      System.out.println("You go a score of: " +score+"/100, You also finished level "+level);
   }
   
   public void mouseDragged(MouseEvent e){
      secret3++;
   }   
   public void mouseMoved(MouseEvent e){
   
   }
              
   public void paintComponent(Graphics g){
   
    //sprite2.mImage = new ImageIcon("download.jfif");
      sprite2.setImage("download.jfif");
   
      int mode = 0;
      
   
      if(0<=count && count<=50){
         g.setColor(new Color(180,50,50));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.black);
         g.drawString("Welcome to the FlappyRealm, try to go right",(int)(.2*getWidth()),(int)(.5*getHeight()));
      
      }
        
      if(51<=count && count<=100){
         g.setColor(new Color(231,180,22));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.black);
         g.drawString("Dont touch walls or green boxes",(int)(.2*getWidth()),(int)(.5*getHeight()));
         
      }
      
      if(101<=count && count<=150){         
         g.setColor(new Color(45,201,55));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.black);
         g.drawString("Use the up arrow to go up",(int)(.2*getWidth()),(int)(.5*getHeight()));
       
      
       
      }
     
      if(level==1){
         g.setColor(new Color(0,0,0));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);             
         Graphics2D g2D = (Graphics2D)g;      
         g.setColor(new Color(5,10,60));
      
         check_collisions(g);
      
         s1.setEmpty();
         s2.setEmpty();
         s3.setEmpty();
         sprite2.draw(g);
         System.out.println("Speed: "+ speed);
      
      }
        
      if(level==2){ //level two of the game
         g.setColor(new Color(0,0,0));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);             
         Graphics2D g2D = (Graphics2D)g;      
         g.setColor(new Color(5,10,60));
      
         check_collisions(g);
      
         s1.set(450, 0, 525, 150);
         s2.set(650, 400, 715, 500);
         s3.set((float)x3, (float)y3, (float)x4, (float)y4);
         
         s1.draw(g);
         s2.draw(g);
         s3.draw(g);
         sprite2.draw(g);
         System.out.println("Speed: "+ speed);
      }
      
      if(level==3){ //levle three of the game
         g.setColor(new Color(0,0,0));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);             
         Graphics2D g2D = (Graphics2D)g;      
         
         s1.setEmpty();
         s2.setEmpty();
         s3.setEmpty();
         
         check_collisions(g);
         g.setColor(new Color(100,150,150)); //this is the safe color
         g.drawRect(300,0,500,getHeight());
         g.drawString("This color won't hurt you",325,100);
         g.setColor(new Color(5,10,60));
         s4.draw(g);
         sprite2.draw(g);
         
      }
      
      if(level==4){ //level two of the game
         g.setColor(new Color(0,0,0));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);             
         Graphics2D g2D = (Graphics2D)g;      
         g.setColor(new Color(5,10,60));
      
         check_collisions(g);
      
         s1.set(300,330,325,360);
         s2.set(350,330,375,360);
         s3.set(400,330,425,360);
         s4.set(450,330,475,360);
         
         s1.draw(g);
         s2.draw(g);
         s3.draw(g);
         s4.draw(g);
         
         sprite2.draw(g);
        
      }
      
      if(level==5){ //level five of the game
         g.setColor(new Color(0,0,0));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);             
         Graphics2D g2D = (Graphics2D)g;      
         g.setColor(new Color(5,10,60));
      
         check_collisions(g);
      
         s1.set(300,330,325,360);
         s2.set(350,330,375,360);
         s3.set(400,330,425,360);
         s4.set(450,330,475,360);
         
                  
         s1.draw(g);
         s2.draw(g);
         s3.draw(g);
         s4.draw(g);
         
         
         
         sprite2.draw(g);
        
      }
      
      if(level==6){ //end screen
         g.setColor(new Color(0,0,0));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);             
         Graphics2D g2D = (Graphics2D)g;      
       
         g.setColor(new Color(200,0,200));
         g.drawString("YOU WIN",325,100);
      
         
      }
   
   
   
   
         
      if(sprite2.right>=getWidth())
      {
         g.setColor(new Color(25,75,25));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.GREEN);
         g.drawString("YOU WIN",300,100);
         
         level++;
         
         sprite2.setLT(10,10,100,100);
         x2=10;
         y2=10;
         sprite2.draw(g);
         repaint();
      }
           
      if(tr<0){
         g.setColor(new Color(0,0,0));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.RED);
         g.drawString("YOURE out of TIME",300,100);
         
       
         
         g.setColor(Color.RED);
           
         sprite2.setLT(10,10,100,100);
         x2=10;
         y2=10;
         sprite2.draw(g);
         repaint();
      }
      
   }
   
   public void check_collisions(Graphics g){
   
      if(sprite2.intersects(s1))
      {
         g.setColor(new Color(25,75,25));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.GREEN);
         g.drawString("OUCH!",300,100);
         
       
         score-=10;
         
         sprite2.setLT(10,10,100,100);
         x2=10;
         y2=10;
         sprite2.draw(g);
         repaint();
      
      } 
      if(sprite2.intersects(s2))
      {
         g.setColor(new Color(25,75,25));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.GREEN);
         g.drawString("OUCH!",300,100);
         
      
         score-=10;
         
         sprite2.setLT(10,10,100,100);
         x2=10;
         y2=10;
         sprite2.draw(g);
         repaint();
      
      } 
      if(sprite2.intersects(s3))
      {
         
         
         g.setColor(new Color(25,75,25));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.GREEN);
         g.drawString("OUCH!",300,100);
         
      
         score-=10;
         
         sprite2.setLT(10,10,100,100);
         x2=10;
         y2=10;
         sprite2.draw(g);
         repaint();
      }
         
      if(sprite2.intersects(s4))
      {
         g.setColor(new Color(25,75,25));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.GREEN);
         g.drawString("OUCH!",300,100);
         
       
         score-=10;
         
         sprite2.setLT(10,10,100,100);
         x2=10;
         y2=10;
         sprite2.draw(g);
         repaint();
      
      } 
   
      
      
      
      if(sprite2.bottom>getHeight()){
      
         g.setColor(new Color(20,10,100));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.GREEN);
         g.drawString("Too low",300,100);
         
      
         score-=10;
         
         //sprite2.setLT(10,10,100,100);
         sprite2.offsetTo(10,10);
         x2=10;
         y2=10;
         sprite2.draw(g);
         repaint();
      }      
      
      if(sprite2.top<0){
      
         g.setColor(new Color(20,10,100));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.GREEN);
         g.drawString("Too high",300,100);
         
      
         score-=10;
         
         sprite2.setLT(10,10,100,100);
         x2=10;
         y2=10;
         sprite2.draw(g);
         repaint();
      }  
      
      if(score==0){ //if you run our of lives 
      
         g.setColor(new Color(0,0,0));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);
         g.setColor(Color.GREEN);
         g.drawString("GAME OVER",300,100);
         
         score-=10;
         
         sprite2.setLT(10,10,100,100);
         sprite2.draw(g);
         repaint();
      }  
   
   } 
   
   class TimerListener implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
       
         repaint();
         if(level>=1){
            tr--;
            sprite2.offset(x2,y2);
            y2+=1;
         }
         if(level==5){
            s1.offset(25,25);
            s2.offset(11,9);
            s3.offset(12,8);
            s4.offset(13,7);
         }
      
        
         if(count==120)
            level++;
         
         count++;
            
        
         
      }
   
   }
}

/* code for a level

if(level==4){ //level two of the game
         g.setColor(new Color(0,0,0));
         g.fillRect(0,0, getWidth()-1, getHeight()-1);             
         Graphics2D g2D = (Graphics2D)g;      
         g.setColor(new Color(5,10,60));
      
         check_collisions(g);
      
         s1.set();
         s2.set();
         s3.set();
         s4.set();
         
         s1.draw(g);
         s2.draw(g);
         s3.draw(g);
         s4.draw(g);
         
         sprite2.draw(g);
         System.out.println("Speed: "+ speed);
      }
*/

/* try{
            Thread.sleep(35);
         }catch(InterruptedException e){
            
         } */
