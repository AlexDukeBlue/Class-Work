import java.util.Arrays;
import java.util.Comparator;

public class StringSort {
     
	public class StrComp implements Comparator<String> {
	       public int compare(String a, String b){
	           if(a.length()>b.length()) return 1;  //return 1 if first is shorter. 
	           if(b.length()>a.length()) return -1; //return -1 if second is shorter. 
	           if(a.length() == b.length()) return a.compareTo(b);
	           return 0; //if no other conclusion can be made.
	       }
	   }
	
	public String[] sort(String[] words) {
		StrComp here = new StrComp();
		Arrays.sort(words, here);
		return words;
     }
 }
