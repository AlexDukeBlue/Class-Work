import java.util.HashMap;

public class BSTcount {
	public long howMany(int[] values) {
		return helpcount(values.length);
	}
	
	HashMap<Integer, Long> mySavedValues = new HashMap<Integer, Long>();
	
	public long helpcount(int size) {
	   
		long value = 0;
		if (mySavedValues.containsKey(size)) {
            return mySavedValues.get(size);
        }
		
		if (size<=1){
			value = 1;
			return value;
		}
		
		for (int i=0; i<size; i++){
			value += helpcount(i)*helpcount(size-i-1);
		}
		mySavedValues.put(size, value);
		return value;
    }
}