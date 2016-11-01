/*
 *
 *
 *Student name: Tendai Muzwidzwa
 *Student number: 2833471
 *
 *
 */
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
public class Assignment6{
 public static void main(String[] args) {
   //Q1=======================================
   List<Integer> lst = new ArrayList<>(Arrays.asList(2,3,4,5,6,7,8,10,14,15,20,21,25,26));

	//Sum of multiples of 5
	System.out.println(lst.stream().reduce(0,(sum,x) -> x % 5 == 0?sum + x: sum));
	
	
	//Sum of the square of all multiples of 3
	System.out.println(lst.stream().reduce(1,(sum,x) -> x % 3==0? sum = x*x: sum));
	
	
	//The maximum value in the list
	System.out.println(lst.stream().reduce(Integer.MIN_VALUE,(x,y)->{if (x > y) return x;else return y;
	}));
		
			

   //End Q1 ==================================
   //Q2=================================================================================
   List<String> lst1 = new ArrayList<>(Arrays.asList("happy","sad","joy","laughter","smile","cry","shout"));
   
   //Find the longest string
   System.out.println("Longest string: "+lst1.stream().reduce("",(str,s)-> str.length() >= s.length()? str:s));
   
   //Concatenation
   System.out.println("Single String: " +lst1.stream().reduce("",(s1,s2)-> s1 +" "+ s2 ));
   
   //Concatenation in reverse order
   System.out.println("Reverse order: " +lst1.stream().filter(x -> x.charAt(0)=='s' ).reduce("",(s3,s4)-> s4+" "+s3));

   //End Q2=============================================================================
   //Q3 ================================================================================


   //Create stream and output summary statistics
   //Sum of first 20 natural numbers
   System.out.println("Sum: "+IntStream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).sum());
   
   //Sum of the square of the first 20 natural numbers.
   System.out.println("Sum of squared: "+IntStream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).map(x->x*x).sum());
   
   //Sum of 20 random natural numbers
   System.out.println("Sum of random: " +IntStream.generate(()->(int)(Math.random()*30)).limit(20).sum());

IntStream.generate(()->(int)(Math.random()*100)).limit(20).sum();
   
   //Create a stream of 30 random numbers and output its Summary statistics
   System.out.println(IntStream.generate(()->(int)(Math.random()*100)).limit(30).summaryStatistics());


   //End Q3 ============================================================================
   // Q4 ===============================================================================
   //list problems
   
   List<Integer> lst2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30));
   
   //Extraxt aall the odd values from lst 2 into a list called oddLst
   List<Integer> oddLst = lst2.stream()
   	.filter(x -> x%2==1)
   		.collect(Collectors.toCollection(ArrayList::new));
   System.out.println("Odd List: " + oddLst);
   
   //Create a set containing cube of each value less than 10
   Set<Integer> cubed;
   cubed = lst2.stream()
   	.map(x -> x*x*x)
   		.limit(9)
   			.collect(Collectors.toSet());
   System.out.println("Cubed: " +cubed);

	//Create a character array that contains all the characteras of each string in lst1

   //End Q4=============================================================================
 }
}