/*
 * Programming Paradigms Assignment 3
 *
 * Student Name:Tendai Muzwidzwa
 *
 * Student Number:2833471
 *
*/

import java.util.*;
import java.util.function.*;
public class Assignment3 {
	public static void main(String[] args) {
   //================================================
   // Functions for Question 1
   	Function<Integer,Integer> inc = x -> x + 1;
	Function<Integer,Integer> dec = x -> x -1;
	Function<Integer,Integer> sq = x -> x * x;
 	BiFunction<Integer,Integer,Integer> add = (x,y) -> x + y;
 	BiFunction<List<Integer>, List<Integer>, List<Integer>> join = (ls1,ls2)->{
    	List<Integer> temp = new ArrayList<>(ls1);
    	temp.addAll(ls2);
    	return temp;
    };
    Function<List<Integer>,List<Integer>> removeOdd = ls ->{
    	List<Integer> temp = new ArrayList<>();
    	for(Integer x : ls)
    		if(x % 2 == 0) temp.add(x);
    	return temp;
    };
    Function<List<Integer>, Integer> sum = ls ->{
      int temp = 0;
    	for(Integer x : ls) temp += x;
    	return temp;
    };
    //=================================================================
    List<Integer> list1 = new ArrayList<>(Arrays.asList(2,5,5,9,2,2,9));
    List<Integer> list2= new ArrayList<>(Arrays.asList(2,5,6,7,9));

    //Question 1 Solution here
    //A
    assert inc.andThen(dec).apply(3) == 3;
    assert dec.andThen(inc).apply(3) == 3;


	//B
	assert add.andThen(sq).andThen(dec).apply(10,12) == 483;
	System.out.println("Backwards composition: "+add.andThen(sq).andThen(dec).apply(10,12));
	
	//C
	assert removeOdd.andThen(sum).apply(list1) == 6;
	System.out.println("Sum of even values in list1: "+removeOdd.andThen(sum).apply(list1));
	
	//C part 2
	assert join.andThen(removeOdd).andThen(sum).apply(list1,list2) == 14;
	System.out.println("Sum of even numbers in list1 and list2: " +join.andThen(removeOdd).andThen(sum).apply(list1,list2));

	
	


   //==================================================
   // Functions for Question 2

   BiFunction<Function<Integer,Integer>,Integer,Integer> hFunc = (f,x)-> f.apply(x);

   BiFunction<List<String>, Predicate<String>, Integer> freq = (lst,p) ->{
   	int count = 0;
   	for(String s : lst) if(p.test(s)) count++;
   	return count;
   };
   
   

   //======================================================================
   // Question 2 solutions here
   List<String> sList = new ArrayList<>(Arrays.asList("hat","coat","shirt","House","top","Flat","mat"));

	//part1
   assert hFunc.apply(x -> 2*x + 1,5) == 11;
   System.out.println("Higher Function: " +hFunc.apply(x -> 2*x + 1,5));
   
   
   //part2
   assert hFunc.apply(x -> x*x + 2*x - 4,2) == 4;
   System.out.println("Higher Function: " +hFunc.apply(x -> x*x + 2*x - 4,2));
   
   
   //part3
   assert hFunc.apply(x -> x*x*x + 2*x*x +3*x,3) == 54;
   System.out.println("Higher Function: " +hFunc.apply(x -> x*x*x + 2*x*x +3*x,3));
   
   //B
	assert freq.apply(sList, x ->  x.charAt(0) >= 'A' && x.charAt(0) <= 'Z')==2;
	System.out.println("How many of the words in the list start with capitals? " +freq.apply(sList, x ->  x.charAt(0) >= 'A' && x.charAt(0) <= 'Z') );
	
	assert freq.apply(sList, x -> x.charAt(1) == 'a') ==2;
    System.out.println("How many words have a as a second letter?" +freq.apply(sList, x -> x.charAt(1) == 'a')); 
    	
   	assert freq.apply(sList, x ->  x.charAt(0) == 'c' && x.charAt(3) == 't')==1;
	System.out.println("How many of the words start with c and end with t? " +freq.apply(sList, x ->  x.charAt(0) == 'c' && x.charAt(3) == 't')) ;

	//C
	BiFunction<List<Integer>, Predicate<Integer>, Boolean >exists = (lst1,p) ->{
		for(Integer y: lst1)if(!p.test(y))return false;
		return true;
	};
	//C test
	List<Integer>drlst = new ArrayList<Integer>(Arrays.asList(2,4,6,8,10,12));
	assert exists.apply(drlst,y -> y %2 ==0 )== true;
	System.out.println("Does the list contain values divisible by 2? " +exists.apply(drlst,y -> y %2 ==0));
	
	
   
   //===================================================
  }
}