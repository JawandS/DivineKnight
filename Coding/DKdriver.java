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
   //Panels
   JPanel left = new JPanel();
   JPanel right = new JPanel();
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
   int level = -1;   
   //standard monster
   Monster m;
   //animations
   Sword sword = new Sword((int)(.02*sW), (int)(.2*sH), -100, (int)(.59*sH));
   Bull bull = new Bull((int)(.1*sW), (int)(.1*sH), -1000, (int)(.59*sH));
   Poison poison = new Poison((int)(.1*sW), (int)(.1*sH), -1000, (int)(.59*sH));

   
   public DKPanel(){
   //setup
      timer = new Timer(10, new TimerListener());
   
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
                  if(k.getLeft() < (sW-400) && (m.getLeft()-k.getRight()) >= 25)
                     k.setLeft(k.getLeft() + 9);
               } 
               if(event.getKeyCode()==KeyEvent.VK_S){//intro skip
                  if(level < 0)
                     level = 1;
               } 
               if(event.getKeyCode()==KeyEvent.VK_1){//Regular attack
                  if((m.getLeft()-k.getRight()) <= 25){
                     k.kAttack(false, 0, k, m, sword, bull);
                     
                  }
               }
               if(event.getKeyCode()==KeyEvent.VK_2){//special attack
                  if( (m.getLeft()-k.getRight()) <= 250){ 
                     k.kAttack(true, 1, k, m, sword, bull);
                     
                  }
               }
               if(event.getKeyCode()==KeyEvent.VK_3){//magic spell
                  if(m.getLeft()-k.getRight() <= 1000){
                     k.kSpell(2, k, m, poison);
                     
                  }
               }   
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
      
      //NOTE: ADD A BACKGROUND TO SLIDES -1 TO -4
      
      if(level == -1){//TEMPLATE / FIRST SCREEN
      //background
         Image pic; 
         ImageIcon obj = new ImageIcon("-200.jpg");//Change number
         pic = obj.getImage();
         g.drawImage(pic,0, 0,sW,(int)(sH), null);
      
      //text
         g.setColor(Color.white);
         g.setFont(new Font("TimesRoman", Font.PLAIN, (int)(.1*getWidth()))); 
         g.drawString("Press S to skip",(int)(.01*getWidth()),(int)(.3*getHeight())); //NOTE: IMPLEMENT THIS FEATURE USING KEY LISTENRS
      }
      
      if(level == -2){
         //EXPLANATION OF CONTROLS
      }
      
      if(level == -3){
         //EXPLANATION OF 3 INITIAL ATTACKS
      }
      
      if(level == -4){
         //CREDITS
      }
      
      if(level == 0){
         g.setColor(Color.red);
         g.setFont(new Font("TimesRoman", Font.BOLD, (int)(.1*getWidth()))); 
         g.drawString("You Died",(int)(.2*getWidth()),(int)(.39*getHeight()));
      }
      
   
      
      if (level == 1)
         level(k, rp, -100, g2D);  
      
      if (level == 2)
         level(k, gs,-101, g2D);  
         
      if (level == 3)
         level(k, sw,-102, g2D); 
         
      if (level == 4)
         level(k, el,-103, g2D); 
         
      if (level == 5)
         level(k, md,-104, g2D); 
      
   }
//level method
   public void level(Knight k, Monster rp, int background, Graphics g){
      //background (top)
      Image pic; 
      ImageIcon obj = new ImageIcon(""+background+".jpg");//Change number
      pic = obj.getImage();
      g.drawImage(pic,0, 0,sW,(int)(.6*sH), null);
      //Stats (knight)
      g.setColor(Color.white);
      g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
      g.drawString("Knight Stats",(int)(.05*getWidth()),(int)(.1*getHeight()));
      g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
      g.drawString("Health: " + k.getHealth(),(int)(.05*getWidth()),(int)(.15*getHeight()));
      g.drawString("Defense: " + k.getDefense(k),(int)(.05*getWidth()),(int)(.2*getHeight()));
      g.drawString("Mana: " + k.getMana(),(int)(.05*getWidth()),(int)(.25*getHeight()));
      g.drawString("Stamina: " + k.getStamina(),(int)(.05*getWidth()),(int)(.3*getHeight()));
      g.drawString("Attack: " + k.getWeapon(2),(int)(.05*getWidth()),(int)(.35*getHeight()));
      //Stats (monster) //change monster
      g.setFont(new Font("TimesRoman", Font.BOLD, 30)); 
      g.drawString("Monster Stats",(int)(.85*getWidth()),(int)(.1*getHeight()));
      g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
      g.drawString("Health: " + rp.getHealth(),(int)(.85*getWidth()),(int)(.15*getHeight()));
      g.drawString("Defense: " + rp.getDefense(),(int)(.85*getWidth()),(int)(.2*getHeight()));
      g.drawString("Attack: " + rp.getAttack(),(int)(.85*getWidth()),(int)(.25*getHeight()));
      //background (bottom)
      Color c = new Color(0, 0, 0);
      g.setColor(c);
      g.fillRect(0, (int)(.45*sH), (int)(sW), (int)(.55*sH));  
      //knight
      k.draw(g);
      //monster (change)
      rp.draw(g);
      //anis
      sword.draw(g);
      bull.draw(g);
      poison.draw(g);
   }
 //level animation
 
   public void lvlAni(Knight k, Monster rp){//timer animation
         
      if(rp.getHealth() <= 0){//death sequence for monster
         level++;
               //Knight reset (CHANGE TO RESET TO UPDATED VALUES)
         k.setLeft((int)(.05 * sW));
         k.setHealth(100);
         k.setMana(100);
         k.setStamina(100);
               
         rp.setLeft(getWidth()*2);
         System.out.println("Monster died");
      }
      if(k.getHealth() <= 0){//death sequence for knight
         this.level = 0;
         System.out.println("You Died");
      }
         
      if(time%50 == 0 && (rp.getLeft()-k.getRight()) >= 25)
         rp.setLeft(rp.getLeft()-20);
         
      if(time%100 == 0 && (rp.getLeft()-k.getRight()) <= 25)
         rp.mAttack(k, rp);
      
      if(time%150 == 0 && k.getStamina() <= 90) //increased stamina per half second
         k.setStamina(k.getStamina() + 5);
      
      if(time%150 == 0 && k.getMana() <= 90) //increases mana per half second
         k.setMana(k.getMana() + 5);
         
      if(time%150 == 0 && k.getHealth() <= 90) //increases health per half second
         k.setHealth(k.getHealth() + 1);
         
   }
           
//animation (timer)

   class TimerListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         
         repaint();
         time++;
         
         //code for intro screens
         if(time < 200)
            level = -1;
         
         if(time < 500 && time >  200)
            level = -2;
         
         if (time < 800 && time >  500)
            level = -3;
         
         if (time < 1000 && time >  800)
            level = -4;
         
         if (time == 1000)
            level = 1;
         
         
         //code for game mechs
         if(level==1){
            lvlAni(k, rp);
            m = rp;
         }
         
         if(level==2){
            lvlAni(k, gs);
            m = gs;
         }
            
         if(level==3){
            lvlAni(k, sw);
            m = sw;
         }
      
         if(level==4){
            lvlAni(k, el);
            m = el;
         }
            
         if(level==5){
            lvlAni(k, md);
            m = md;
         }
         
         if(sword.getLeft()>0){
            sword.setLeft(sword.getLeft()+5);
            if(m.getLeft()-sword.getRight() < -150)
               sword.setLeft(-1000);
         }
         
         if(bull.getLeft()>0){
            bull.setLeft(bull.getLeft()+10);
            if(m.getLeft()-bull.getRight() < -500)
               bull.setLeft(-1000);
         }
         
         if(poison.getLeft()>0){
            poison.setLeft(poison.getLeft()+20);
            if(m.getLeft()-poison.getRight() < -250)
               poison.setLeft(-1000);
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
