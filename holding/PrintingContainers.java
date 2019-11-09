package holding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.Map;

public class PrintingContainers {
	static Collection fill(Collection<String> collection) {
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");

		return collection;
	}

	static Map fill(Map<String, String> map) {
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "Spot");

		return map;
	}

	public static void main(String[] args) {
		System.out.println(fill(new ArrayList<>()));
		System.out.println(fill(new LinkedList<>()));
		System.out.println(fill(new HashSet<>()));
		System.out.println(fill(new TreeSet<>()));
		System.out.println(fill(new LinkedHashSet<>()));

		System.out.println(fill(new HashMap<>()));
		System.out.println(fill(new TreeMap<>()));
		System.out.println(fill(new LinkedHashMap<>()));
	}
}
