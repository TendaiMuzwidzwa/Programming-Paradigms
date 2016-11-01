/**
 *
 * Student name:Tendai
 * Student number:Muzwidzwa
 */
import java.util.*;
import java.util.function.*;
public class Assignment4 {
  public static void main(String[] args) {
  	
  	// Question 1 ==========================================================================
    Words wds = new Words();
    List<String> wlst = new ArrayList<>(Arrays.asList("red","happy","sad","house","open",
                                                       "closed","now","aa","b","g","night","hope"));
    for(String s : wlst) wds.add(s);
    
  //Boolean Search Test
    System.out.println("Is the word night in the list?: " +wds.search(x -> x.equals("night")));
    
	//Int Count Test
    System.out.println("Number of words in the list that start with h: " +wds.count( x -> x.charAt(0) == 'h'));
    
    //Filter
    System.out.println("What words contain h: " +wds.filter( x -> x.charAt(0) == 'h'));
    System.out.println("What words contain h: " +wds.filter( x -> x.charAt(1) == 'o'));
    

	//Display Test
//	for (String s: wlst) wds.display(cn -> cn.charAt(0) =="h" && cn.charAt(4)=="e");
	wds.accept(printAll);
	
	
	
	//Sort Test
	
	
	
    //=====================================================================================
    //Question 2 ==========================================================================


    //=====================================================================================
  }
  
}
	class Words{
	private List<String> list = new ArrayList<>();
	void add(String w){list.add(w);}
	boolean search(Predicate<String> pr){
		for(String s : list) if(pr.test(s)) return true;
	    return false;
	}
	int count(Predicate<String> pr){
		int count = 0;
		for(String s: list) if(pr.test(s)) count++;
		return count;
	}
	List<String> filter(Predicate<String> pr){
		List<String> lst1 = new ArrayList<>(Arrays.asList("happy","house","hope"));
		for(String s: list) if(pr.test(s)) return lst1;
		return null;
	}
	void display(Consumer<String> cn){
		Consumer<String> printAll =s ->{
			System.out.print( s + " ");
		};
	}

//	void sort(Comparator<String> cmp){
//		String
//		for(String s: list) 
//	}
}
