import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streamsinjava {

	public static void main(String[] args) {
		 String[] names = {"sudheer","satish","mohanarao","malleswari"};
		 System.out.println(names.length);
		 
		 //change array to arryList
		 ArrayList<String> name = new ArrayList<String>(Arrays.asList(names));
		 //System.out.println(name.size());
		 name.add("mahesh");
		 System.out.println(name.size());
		 //print all name in arraylist
		 //name.stream().forEach(i->System.out.println(i));
		 
		 //print ends with "sh"
		 name.stream().filter(i->i.endsWith("sh")).forEach(i->System.out.println(i));
		 List<String> num = name.stream().filter(i->i.endsWith("sh")).collect(Collectors.toList());
		 num.stream().filter(j->j.startsWith("m")).map(j->j.toUpperCase()).forEach(j->System.out.println(j));
		 name.stream().sorted().forEach(k->System.out.println(k));
		 
		 
		 
	}

}
