import java.util.ArrayList;
import java.util.List;

public class UniqueNewYork {
	public int seen(String[] records) {
	 List<String> lisc = new ArrayList<>();
		String[] recc = new String[0];
	 for (String t : records){
		 recc = t.split(",");
	for (String s : recc){
		String[] reccNew = s.split(",");

	 if (!lisc.contains(reccNew[0])){
		 lisc.add(reccNew[0]);
	 }
	}
	 }
return lisc.size();
	}
}
