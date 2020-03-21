package unnecessarycreation;

import java.util.regex.Pattern;

public class AvoidUnnecessaryCreation {
    private static final Pattern ROMAN = Pattern.compile(
        "^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static boolean isRomanNumeral(String s) {
        /* unnecessary Pattern instance creation each time it is executed
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
         */

        return ROMAN.matcher(s).matches();
    }

    public static long sum() {
        /* unnecessary Long instance creation each time addition
        Long sum = 0L;
         */
        long sum = 0;
        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }

        return sum;
    }
}
