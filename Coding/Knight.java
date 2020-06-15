

public class Knight{
//variables

int itemNumber = 0;
int xPos; //Change based on size of the frame
int yPos; //read above note

//items
Gear helmet;
Gear chestplate;
Gear gauntlets;
Gear boots;
Gear weapon;
int health;
int mana;
int stamina;

//constructor 
public Knight(Gear g1, Gear g2, Gear g3, Gear g4, Gear g5, int health, int mana, int stamina){

helmet = new Gear(g1);
chestplate = new Gear(g2);
gauntlets = new Gear(g3);
boots = new Gear(g4);
weapon = new Gear(g5);

this.health = health;
this.mana = mana;
this.stamina = stamina;

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

//getters 
public int getHelmet(){
return helmet.in;
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

