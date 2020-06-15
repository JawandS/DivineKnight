public class Gear{

//vars
int in;
int iv;
double id;

//constructor 1, for various subclass
public Gear(int in, int iv, double id){
this.in = in;
this.iv = iv;
this.id = id;
}

//constructor 2, for the knight class
public Gear(Gear g){}

public String toString(){

return ("Item number is " + in +", the value is " + iv + ", and the defense is " + id);

}

}