public class Monster
{
//other value
   int loc;
   int id;

//main attributes
   int health;
   int attack;
   int defense;
 
 //constructor
   public Monster(int h, int a, int d, int id){
      health = h;
      attack = a;
      defense = d;
      this.id = id;
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
}
    
  
 
 
 /*
   //General pseudocode
   /* int armor;
      int item;
      */
   //Attacks pseudocode
   /* int itemNumber;
      int damage;
      int range;
      */
   //attack(itemNumber, damage, range);
   //Health pseudocode
   /* 
      int health;
      */
   //Boss pseudocode
   /* 
      boolean boss;
      }
      */


/*class Value
{
   //pseudocode
    
      int numitems;
      double probability;
      int value;
      int gold;
      }
      */
