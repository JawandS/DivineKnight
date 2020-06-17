import java.awt.event.*;
import javax.swing.*;  //to access JFrame and JPanel
import java.awt.*;     //to access Graphics and Color
import java.awt.event.*;//to access Listeners
import java.awt.geom.*; //to access GeneralPath
import javax.swing.Timer;


//file for the driver
//DK = Divine Knight

public class DKdriver{

   public static void main(String[] args){
   
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int sWidth = (int) screenSize.getWidth();
      int sHeight = (int) screenSize.getHeight();
      
      JFrame frame = new JFrame("DivineKnight");
      frame.setSize((int)(sWidth-10),(int)(sHeight-10));
      frame.setLocation(0,0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new DKPanel());
   
      frame.setVisible(true);
    
   }
}

class DKPanel extends JPanel implements MouseListener, MouseMotionListener{
   
   //necessary vars
   int time = 0;
   //Gear
   LHelmet h = new LHelmet(); 
   LChestplate c = new LChestplate();
   LBoots b = new LBoots();
   LGauntlets g = new LGauntlets();
   WWeapon w = new WWeapon();
   //Screen size
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   int sW = (int) screenSize.getWidth(); //width
   int sH = (int) screenSize.getHeight(); //height
   //Monsters
   RatPack rp = new RatPack(sW, sH);
   GiantSpider gs = new GiantSpider(sW, sH);
   SkeletonWarrior sw = new SkeletonWarrior(sW, sH);
   ElderLich el = new ElderLich(sW, sH);
   MallumDraco md = new MallumDraco (sW, sH);
   //MC
   Knight k = new Knight (h, c, g, b, w, (int)(.2*sW), (int)(.55*sH), (int)(.05 * sW), (int)(.45*sH));
   //Timer                                   width             height               x                 y        
   private Timer timer;
   //level
   int level = 1;   
   
   public DKPanel(){
   //setup
      timer = new Timer(7, new TimerListener());
   
      timer.start();
      setFocusable(true);             
      requestFocusInWindow();  
      addMouseListener(this);        
      addMouseMotionListener(this);  
      
   //actions
      addKeyListener(
         new KeyAdapter(){
            public void keyPressed(KeyEvent event) {
               if(event.getKeyCode()==KeyEvent.VK_LEFT){//left arrow
                  if(k.getLeft() > 10)
                  k.setLeft(k.getLeft() - 7);
               } 
               if(event.getKeyCode()==KeyEvent.VK_RIGHT){//right arrow
                  if(k.getLeft() < (sW-400) && (rp.getLeft()-k.getRight()) >= 50)
                  k.setLeft(k.getLeft() + 9);
               } 
               if(event.getKeyCode()==KeyEvent.VK_1){
               if(level==1 && (k.getRight()-rp.getLeft()) <= 50){
               k.kAttack(false, 0, k, rp);
               }
               }
               if(event.getKeyCode()==KeyEvent.VK_2){}
               if(event.getKeyCode()==KeyEvent.VK_3){}   
            }
         }
         ); 
         
      
   }     
    
//Necessary methods (mouse class)
   public void mousePressed(MouseEvent e) {}
   public void mouseReleased(MouseEvent e) {}
   public void mouseClicked(MouseEvent e) {}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   public void mouseDragged(MouseEvent e){}
   public void mouseMoved(MouseEvent e){}


//Paint component
   public void paintComponent(Graphics g){
      Graphics2D g2D = (Graphics2D)g;

      if(level == 1){//level 1
      //background (top)
      Image pic; 
      ImageIcon obj = new ImageIcon("-100.jpg");
      pic = obj.getImage();
      g.drawImage(pic,0, 0,sW,(int)(.6*sH), null);
      //background (bottom)
      Color c = new Color(0, 0, 0);
      g.setColor(c);
      g.fillRect(0, (int)(.45*sH), (int)(sW), (int)(.55*sH));  
      //knight
      k.draw(g);
      //monster
      rp.draw(g);
      }
      
      if(level == 2){//level 2
      //background (top)
      Image pic; 
      ImageIcon obj = new ImageIcon("-101.jpg");//change background
      pic = obj.getImage();
      g.drawImage(pic,0, 0,sW,(int)(.6*sH), null);
      //background (bottom)
      Color c = new Color(0, 0, 0);
      g.setColor(c);
      g.fillRect(0, (int)(.45*sH), (int)(sW), (int)(.55*sH));  
      //knight
      k.draw(g);
      //monster
      rp.draw(g);//change monster
      }

   }
   
//animation (timer)

   class TimerListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         repaint();
         time++;
         
         if(level == 1){//level 1 animations
         
         if(rp.getHealth() <= 0){//death sequence for monster
         level++;
         System.out.println("Monster died");
         }
         if(k.getHealth() <= 0){//death sequence for knight
         level = 0;
         System.out.println("You Died");
         }
         
         if(time%30 == 0 && (rp.getLeft()-k.getRight()) >= 50)
         rp.setLeft(rp.getLeft()-10);
         
         if(time%75 == 0 && (rp.getLeft()-k.getRight()) <= 50)
         rp.mAttack(k, rp);
         }
      }
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
