//version 2.1
public class Gear{

//vars
int in;
int iv;
int id;

//constructor 1, for various subclass
public Gear(int in, int iv, int id){
this.in = in;
this.iv = iv;
this.id = id;
}

//constructor 2, for the knight class
public Gear(Gear g){
this.in = g.in;
this.iv = g.iv;
this.id = g.id;
}

public String toString(){

return ("Item number is " + in +", the value is " + iv + ", and the defense is " + id);

}

}