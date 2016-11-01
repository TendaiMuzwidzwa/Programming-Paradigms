/*
 *
 *Student name:Tendai Muzwidzwa
 *Student number:2844371
 *
 */


import java.util.*;
import java.util.function.*;
import java.util.stream.*;
public class Assignment7
{
 public static void main(String[] args) {
   //Q1 ==============================================================

	List<String> lst1 = new ArrayList<>(
							Arrays.asList("house","1991","mouse","2882",	
										"home","3773","mice","4664","rat23","01cat","59bird"));
    
    Predicate<String>allDgtsorLCase = s ->
										{return s.chars().allMatch(x->('0'<=x && x <='9'))||
											    s.chars().allMatch(x->('a'<=x && x<='z'));};
										
	Map<Boolean,List<String>> mp = lst1.stream()
 									.filter(allDgtsorLCase)
										.collect(Collectors.partitioningBy( s->s.chars().allMatch(x-> 'a'<=x && x<='z')));
	System.out.println(mp);
					
					
	List<Integer> lst2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	Map<Boolean,List<Integer>> map1 = lst2.stream()
										.collect(Collectors.partitioningBy(x -> x % 2 == 0));
											System.out.println(map1);

   //End Q1 ==========================================================
   //Q2===============================================================
   List<String>wLst = new ArrayList<>(
   	                      Arrays.asList("cat","fat","happy","sad","down",
   	                                 "about","car","zoo","a","g","food"));

/*
	Map<Character, List<String>> mp2 = wLst.stream()
										.collect(Collectors.groupingBy(String::length));
											System.out.println(mp2);
*/
//s->s.chars().allMatch(x-> 'a' >=x  && x <= 'z'
	
   // End Q2 ==============================================================
   //Q3 ===================================================================
   List<NatAuthor> na = new LinkedList<>(Arrays.asList(	new NatAuthor("Irish","Doyle"),
   														new NatAuthor("French","Flaubert"),
   														new NatAuthor("French","deBeauvoir"),
   														new NatAuthor("German","Hegel"),
   														new NatAuthor("Irish","Brown"),
   														new NatAuthor("German","Goethe"),
   														new NatAuthor("English","McEwan")
   																			));

	Map<String, Long> mp3 = na.stream()
										.collect(Collectors.groupingBy(String::length));
											System.out.println(mp3);

    // End Q3 ================================================================
    //Q4 =====================================================================

    List<String> c1 = new ArrayList<String>(Arrays.asList("London","Paris","New York"));
	  List<String> c2 = new ArrayList<String>(Arrays.asList("Paris","Tokyo","London"));
	  List<String> c3 = new ArrayList<String>(Arrays.asList("London","New York","Berlin"));
	  UrbanExplorer k = new UrbanExplorer("Donal","Dublin",c1);
	  System.out.println(k);

	  UrbanExplorers expLst = new UrbanExplorers();
	  expLst.add(k);
	  expLst.add(new UrbanExplorer("Carmel","Dublin",c1));
	  expLst.add(new UrbanExplorer("Rory","Manchester",c2));
	  expLst.add(new UrbanExplorer("Clare","Manchester",c3));
	  //System.out.println(expLst);
	  //System.out.println("Names: "+expLst.names());
	  //System.out.println("All cities visited: " + expLst.citiesVisited());

	  //System.out.println(expLst.citiesVisitedBy());

    // End Q4 ================================================================
 }
}
final class NatAuthor{
	private final String nationality;
	private final String author;
	NatAuthor(String a, String b){nationality = a; author = b;}
	String nationality(){return nationality;}
	String author(){return author;}
	public String toString(){return author+" "+ nationality;}
}

final class UrbanExplorer{
	private String name;
	private String homeCity;
	private List<String> cities;
	UrbanExplorer(String n, String c, List<String> v){
		name = n; homeCity = c;
		cities = v.stream().collect(Collectors.toCollection(ArrayList::new));
	}
	String name(){return name;}
	String homeCity(){return homeCity;}
	List<String> cities(){return Collections.unmodifiableList(cities);}
	public boolean equals(Object ob){
		if(!(ob instanceof UrbanExplorer)) return false;
		UrbanExplorer ue = (UrbanExplorer)ob;
		return name.equals(ue.name);
	}

	public String toString(){
		return name+" "+homeCity+" "+ cities;
	}
}

class UrbanExplorers{
	private List<UrbanExplorer> data = new ArrayList<UrbanExplorer>();
	void add(UrbanExplorer k){
		data.add(k);
	}
	//List<String> names(){//list names of explorers}
	//List<String> citiesVisited(){
		//list all cities visited
	//}
	//Map<String,List<String>> citiesVisitedBy(){
		//return map that connects each city with a list of visitors
	//}

	//public String toString(){
}