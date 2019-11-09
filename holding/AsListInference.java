package holding;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsListInference {
	public static void main(String[] args) {
		List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
		output(snow1);

		List<Snow> snow2 = Arrays.asList(new Heavy(), new Light());
		output(snow2);

		List<Snow> snow3 = new ArrayList<>();
		Collections.addAll(snow3, new Heavy(), new Light());
		output(snow3);

		List<Snow> snow4 = Arrays.<Snow>asList(new Heavy(), new Light());
		output(snow4);
	}

	private static void output(List<Snow> snow) {
		for (Snow s : snow) {
			System.out.println(s);
		}
	}
}

class Snow {
}

class Powder extends Snow {
}

class Heavy extends Powder {
}

class Light extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}
