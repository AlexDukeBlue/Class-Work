import java.util.Arrays;
import java.util.Comparator;

public class ClientsList {
	public class Person {
		String first;
		String last;

		public Person(String s) {
			first = s.split(" ")[0];
			last = s.split(" ")[1];
		}

		public String getLast() {
			return last;
		}

		public String getFirst() {
			return first;
		}
	}

	public String[] dataCleanup(String[] names) {

		Person[] list = new Person[names.length];
		for (int i = 0; i < names.length; i++) {
			if (names[i].contains(",")) {
				String[] splitter = names[i].split(",");
				String a = splitter[0];
				String b = splitter[1].substring(1);
				String c = b + " " + a;
				Person aa = new Person(c);
				list[i] = aa;
			} else {
				Person aa = new Person(names[i]);
				list[i] = aa;
			}
			
		}
		Comparator<Person> comp = Comparator.comparing(Person::getLast);
		comp = comp.thenComparing(Person::getFirst);
		Arrays.sort(list, comp);

		String[] sortList = new String[list.length];
		for (int i = 0; i < list.length; i++) {
			String first = list[i].getFirst();
			String last = list[i].getLast();
			String a = first + " " + last;
			sortList[i] = a;
		}

		return sortList;
	}
}