/*
Assignment2 (2014) Programming Paradigms

Student Name:Tendai Muzwidzwa

Student Number:2833471

*/
import java.util.*;
import java.util.function.*;

public class Assignment2 {

    public static void main(String[]args) {
   //Define Functions and Tests for Question 1
   //Cube Function 
    Function <Integer,Integer> cube = x ->	x*x*x;
    
    //Cube Funtion Test
    System.out.println("Cubed value is: " + cube.apply(4));	
    
    
    //Max Funtion
    BiFunction<Integer,Integer,Integer> max = (x,y) -> { 
    	if(x >y){
    	 return x;
    	}
    	else
    		return y;
    	
    };
    
    //Max Function Test
    System.out.println("The max is: " + max.apply(3,7));
    System.out.println("The max is: " + max.apply(9,7));
    
    
    
    //Min Function Test
    BiFunction<String,String,String> min = (x,y) -> {
    	if(x.compareTo(y)==0){
    		return x;
    	}
    	else{
    		return y;
    		} 
    };
    
    //Min Function Test   
   System.out.println("The lexicographically least one is: " + min.apply("Mi","Me"));
   
   
   
    //MinLst Function
    Function<List<String>,String> minLst = minlst ->{
    	String minComp = "";
    	for(String x: minlst){	
    		if(minComp == "")
    		{
    			minComp = x;
    		}
    			if(minComp.compareTo(x) > 0){
    				minComp = x;
    			}	
    	}return minComp;    		
    };
    
	//MinLst Function Test
	List<String> lo = new ArrayList<String>(Arrays.asList("Teacup","Teabag","Teasaucer","Teapot"));
	System.out.println("The lexicographically least one is: " + minLst.apply(lo));
    	
    	
    	
    	
    	
    //Define Functions and Tests for Question 2
    //Consumer Function
 	Consumer<List<Integer>> list = lst ->{	
	   	for(Integer i: lst)
	   		if(i > 0 && i < 101)
	   	System.out.print(i+ ",");	
	   	
	}; 
		
    //Consumer Function test
    List<Integer> dt = new ArrayList<Integer>(Arrays.asList(1,5,23797,15,45,76,9786,57,90,12,11,95,60));
    list.accept(dt);
      
       
    //UnaryOperator Function
    UnaryOperator <Integer> fact = x ->{    
        int factn = 1; // this  will be the result
        for (int i = 1; i <= x; i++) {
            factn *= i;
        }
        return factn;
    };
    //UnaryOperator Function test
    System.out.println("\nFactorial of x is: " + fact.apply(5));
    
    
    //Prediate Function
    Predicate <List<String>> isCap = lst ->{
    	for(int x=0; x<lst.size(); x++){
			char c = lst.get(x).charAt(0);
			if(c >= 97 && c <= 122) {
				return false;
			}
    	}
    	return true;
    };
    
    //Predicate Function Test
    List<String> ds = new ArrayList<String>(Arrays.asList("Milk","Cake","Diary","Pizza","Sushi"));
    System.out.println("Do all strings begin with a capital? " +isCap.test(ds));
    
    List<String> dr = new ArrayList<String>(Arrays.asList("milk","Cake","Diary","Pizza","Sushi"));
    System.out.println("Do all strings begin with a capital? " +isCap.test(dr));
    
   
    
    }
}




