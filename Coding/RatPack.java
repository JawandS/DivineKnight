public class RatPack extends Monster{

   public RatPack(){
      super(100, 20, 5, 101); //MONSTERS START WITH 100
   }
}

class GiantSpider extends Monster{

   public GiantSpider(){
      super(500, 37, 10, 102); //MONSTERS ID START WITH 100 (health, attack, def)
   }
}

class SkeletonWarrior extends Monster{

   public SkeletonWarrior(){
      super(250, 200, 60, 103); //MONSTERS ID START WITH 100
   }
}

class ElderLich extends Monster{

   public ElderLich(){
      super(50, 500, 245, 104); //MONSTERS ID START WITH 100
   }
}

class MallumDraco extends Monster{

   public MallumDraco(){
      super(1000, 1750, 4999, 105); //MONSTERS ID START WITH 100
   }
}