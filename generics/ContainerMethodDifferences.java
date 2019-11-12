package generics;

public class ContainerMethodDifferences {
	static Set<String> methodSet(Class<?> type) {
		Set<String> result = new TreeSet<String>();

		for (Method m : type.getMethods()) {
			result.add(m.getName());
		}

		return result;
	}

	static void interfaces(Class<?> type) {
		System.out.print("Interfaces in " + type.getSimpleName() + ": ");

		List<String> result = new ArrayList<String>();
		for (Class<?> c : type.getInterfaces()) {
			result.add(c.getSimpleName());
		}

		System.out.println(result);
	}

	static Set<String> object = methodSet(Object.class);

	static {
		object.add("clone");
	}

	static void difference(Class<?> superset, Class<?> subset) {
		System.out.print(subset.getSimpleName() + " extends " + superset.getSimpleName() + ", adds: ");
		
		Set<String> comp = Sets.difference(methodSet(subset), methodSet(superset));

		comp.removeAll(object);

		System.out.println(comp);

		interfaces(subset);
	}
}
