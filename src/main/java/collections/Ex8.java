package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex8 {
	public static void main(String[] args) {
		ArrayList<Gerbil> gerbils = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			gerbils.add(new Gerbil(i));
		}

		Iterator<Gerbil> it = gerbils.iterator();
		while (it.hasNext()) {
			it.next().hop();
		}
	}
}
