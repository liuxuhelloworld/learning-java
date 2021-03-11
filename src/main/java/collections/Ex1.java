package collections;

import java.util.ArrayList;

public class Ex1 {
	public static void main(String[] args) {
		ArrayList<Gerbil> gerbils = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			gerbils.add(new Gerbil(i));
		}

		for (Gerbil gerbil : gerbils) {
			gerbil.hop();
		}
	}
}

class Gerbil {
	private int gerbilNumber;

	public Gerbil(int i) {
		gerbilNumber = i;
	}

	public void hop() {
		System.out.println("Gerbil " + gerbilNumber + " hopps");
	}
}
