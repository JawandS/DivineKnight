

public class Knight{

//variables
int itemNumber = 0;
int xPos; //Change based on size of the frame
int yPos; //read above note

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
public Knight(Gear g1, Gear g2, Gear g3, Gear g4, Gear g5){

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
}

//methods

public void kAttack(boolean special, int name, Knight k, Monster m){//the method for attacks, id for specific special attack

if (special==false){ 
int damage = k.getWeapon(2) - m.getDefense();

if (damage > 0)
m.setHealth(m.getHealth() - damage);
}

if(special == false){

//COMPLETE SPECIAL ATTACKS AS NEEDED 
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


//public void draw(Graphics g){

//timer in the gui panel
//al of the other pieces of items will be based of the pso of the knight
//create ticks in the listnere class
//action performed in the lsitener
//key listener (if left go left)
//get image from fro item nubmer
//make the backgroudn move not the knight

//make the monster move, but when the knight is moving everyhtign else moves 
//}


}

/* NOTES

Has: Armor, weapon, attributes, gold, and exp (along with there getters and setter)





*/