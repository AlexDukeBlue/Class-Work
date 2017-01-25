import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AuntUncle {

	Map<String, Set<String>> myMap;

	public Set<String> getSiblings(String p) {
		Set<String> rents = myMap.get(p);
		Set<String> ret = new HashSet<>();
		if (rents == null)
			return ret;
		for (String ss : myMap.keySet()) {
			for (String gg : myMap.get(ss)) {
				if (rents.contains(gg)) {
					ret.add(ss);
				}
			}
		}
		return ret;
	}
	
	public String[] list(String[] parents, String target){
		myMap = new HashMap<>();
		for(String s : parents){
		String[] data = s.split(" ");
		myMap.put(data[2],new HashSet<>());
		myMap.get(data[2]).add(data[0]);
		myMap.get(data[2]).add(data[1]);
		} 
		Set<String> rents = myMap.get(target);
		if (rents == null) return new String[0];
		Set<String> sibs = new TreeSet<>();
		for(String p : rents){

		 sibs.addAll(getSiblings(p));
		}
		sibs.removeAll(rents);
		sibs.remove(target);
		String[] ret = sibs.toArray(new String[0]);
		return ret;
	}
}


