import java.awt.event.*;
import javax.swing.*;  //to access JFrame and JPanel
import java.awt.*;     //to access Graphics and Color
import java.awt.event.*;//to access Listeners
import java.awt.geom.*; //to access GeneralPath
import javax.swing.Timer;

public class RatPack extends Monster{

   public RatPack(int sW, int sH){
      super(100, 20, 5, 101, (int)(.3*sW), (int)(.55*sH), (int)(.85 * sW), (int)(.45*sH)); //MONSTERS START WITH 100
      mImage = new ImageIcon("101.png");
   }
}

class GiantSpider extends Monster{

   public GiantSpider(int sW, int sH){
      super(500, 37, 10, 102, (int)(.3*sW), (int)(.55*sH), (int)(.85 * sW), (int)(.45*sH)); //MONSTERS ID START WITH 100 (health, attack, def)
   }
}

class SkeletonWarrior extends Monster{

   public SkeletonWarrior(int sW, int sH){
      super(250, 200, 60, 103, (int)(.3*sW), (int)(.55*sH), (int)(.85 * sW), (int)(.45*sH)); //MONSTERS ID START WITH 100
   }
}

class ElderLich extends Monster{

   public ElderLich(int sW, int sH){
      super(50, 500, 245, 104, (int)(.3*sW), (int)(.55*sH), (int)(.85 * sW), (int)(.45*sH)); //MONSTERS ID START WITH 100
   }
}

class MallumDraco extends Monster{

   public MallumDraco(int sW, int sH){
      super(1000, 1750, 4999, 105, (int)(.3*sW), (int)(.55*sH), (int)(.85 * sW), (int)(.45*sH)); //MONSTERS ID START WITH 100
   }
}