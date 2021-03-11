package generics.corejava;

import java.time.LocalDate;

import objects.Employee;
import objects.Executive;
import objects.Manager;
import objects.Person;

public class PairTest {
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        String min = a[0];
        String max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }

        return new Pair<>(min, max);
    }

    /**
     * bound for type variable example
     */
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        T min = a[0];
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }

        return new Pair<>(min, max);
    }

    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies");
    }

    public static void minmaxSalary(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) {
            return ;
        }

        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getSalary() > a[i].getSalary()) {
                min = a[i];
            }
            if (max.getSalary() < a[i].getSalary()) {
                max = a[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminSalary(Manager[] a, Pair<? super Manager> result) {
        minmaxSalary(a, result);
        swapHelper(result);
    }

    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }

    public static void swap(Pair<?> p) {
        swapHelper(p);
    }

    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());

        LocalDate[] birthdays = {
            LocalDate.of(1906, 12, 9),
            LocalDate.of(1815, 12, 10),
            LocalDate.of(1903, 12, 3),
            LocalDate.of(1910, 6, 22),
        };
        Pair<LocalDate> mm2 = minmax(birthdays);
        System.out.println("min = " + mm2.getFirst());
        System.out.println("max = " + mm2.getSecond());

        Pair<String> p = Pair.makePair(String::new);
        System.out.println(p);

        Pair<String> p2 = Pair.makePair(String.class);
        System.out.println(p2);

        Employee first = new Employee("Tom", 100);
        Employee second = new Employee("Jerry", 200);
        Pair<Employee> ep = new Pair<>(first, second);
        printBuddies(ep);

        Manager firstm = new Manager("Tomm", 100);
        Manager secondm = new Manager("Jerrym", 200);
        Pair<Manager> mp = new Pair<>(firstm, secondm);
        printBuddies(mp);

        Pair<? extends Employee> wildcardmp = mp;
        // wildcardmp.setFirst(first); // error
        // wildcardmp.setFirst(firstm); // error
        Person px = wildcardmp.getFirst();
        Employee x = wildcardmp.getFirst();
        // Manager y = wildcardmp.getFirst();

        Pair<? super Manager> wildcardep = ep;
        // wildcardep.setFirst(first);
        wildcardep.setFirst(firstm);
        Executive firste = new Executive("Tome", 100);
        wildcardep.setFirst(firste);
        // Employee xx = wildcardep.getFirst();
        // Manager yy = wildcardep.getFirst();
    }
}
