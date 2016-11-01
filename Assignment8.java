/**
 * 
 *
 *Student Name:Tendai Muzwidzwa
 *Student Number:2833471
 */

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Assignment8 {

    public static void main(String[] args)  {
    	List<Complex> cpx1 = new ArrayList<>(
							Arrays.asList((1,3),(2,4),(3,6),(4,4),(1,1),(2,5));
    	 
    } 
}
public final class Complex implements Comaparable<Complex>{
	final int real,imag;
	public Complex(int rr, int ii)
	{
		real = rr; imag = ii;
	}
	public Complex(int c)
	{
		this (c,0);
	}
	public Complex(int z1, int z2, int i,int )
	{
		i = Math.sqrt(-1);
		z1 = real + i.real;
		z2 = imag + i.imag;
		
	}
	
	public int getR()
	{
		return real;
	}
	
	public int getI()
	{
		return imag;
	}
	//Return tht complex cconjugate
	public Complex conj()
	{
		return new Complex(real,imag)
	}
	//Return absolute squared value
	public int absSq()
	{
		return real*real + imag*imag;
	}
	//Return absolute value
	public int abs()
	{
		return Math.sqrt(absSq());
	}

	public int add(Complex c)		
	{
		return new Complex(real + c.real, imag+c.imag);
	}
/*	public int add(int c){
		return add(new Complex(c));
	}*/
	public int sub(Complex c)
	{
		return new Complex(real - c.real, imag-c.imag);
	}
/*	public int sub(int c){
		return sub(new Complex(c));
	}*/
	public int mult(Complex c)
	{
		return new Complex(real*c.real - imag*c.imag, real*c.imag + c.real*imag);	
	}
/*	public int mult(int c){
		return mult(new Complex(c));
	}*/
	public Complex div(int d)
	{
		return new Complex(real/d,imag/d)
	}
	public boolean equals(Object ob)
	{
		if (ob == null) {
            return false;
        }
        // Return false if the object is not a Complex number
        if (!(ob instanceof Complex)) {
            return false;
        }
        
        // Now the object must be a Complex number, so we can convert it to a 
        // Complex number.
        Complex other = (Complex) ob;
        
        // If the x-coordinates are not equal, then return false.
        if (real != other.real) {
            return false;
        }
        // If the y-coordinates are not equal, then return false.
        if (imag != othaer.imag) {
            return false;
        }
        // Both parts are equal, so return true.
        return true;
	}
	public in compareTo()
	{
		if(that == null){
			return -1;
		if (t<0) return -1;
		else if(t > 0) return 1;
		else return 0;
		}
	}
	public String toString()
	{
		if(imag == 0){
			return ""+real;
		}
		if(i >0){
			return ""+real+"+"+imag+"*I";
		}
		else
		return ""+real+" - "+(-imag)+"*I";
	}
	public int hashCode()
	{
		return 41*(real.hashCode()+41)+ imag.hashCode();
	}	
}

class ComplexList{
	List<Complex> cpx = new Arraylist<>();
	//Search
	boolean search(Predicate<Complex> pr){
		for(Complex s : cpx) if(pr.test(s)) return true;
	    return false;
	}
	//Count
	int count(Predicate<Complex> pr){
		int count = 0;
		for(Complex s: ) if(pr.test(s)) count++;
		return count;
	}
	//Filter
	List<Complex> filter(Predicate<Complex> pr){
		List<Complex> c1 = new ArrayList<>());
		for(Complex s: cpx) if(pr.test(s)) return lst1;
		return null;
	}
	//FilterMap
	FilterMap <Predicate<Complex>,Function<Complex,Complex>,List<Complex>> filterMap =
		(f,m)->
	{
		List<Complex>dt = new ArrayList<Complex>();
		for(Complex x: cpx) if(f.test(x))dt.add(m.apply(x));
		return dt
	}
	Function<List<Complex>,Complex> max = maxlist -> { 
    	int mx = 0;
    	for(Integer x: maxlist){
    		if (mx == 0)
    	}
    		mx == x
    	}
    		if(mx.compareTo(x) > 0){
    			mx = x;
    	}
    	else
    		return mx;
    	
    };
	
	
}