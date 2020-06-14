public class Gear{

//vars
int in;
int iv;
double id;

//constructor
public Gear(int in, int iv, double id){
this.in = in;
this.iv = iv;
this.id = id;
}

public String toString(){

return ("Item number is " + in +", the value is " + iv + ", and the defense is " + id);

}

}