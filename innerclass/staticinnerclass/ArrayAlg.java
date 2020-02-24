package innerclass.staticinnerclass;

public class ArrayAlg {
    public static class Pair {
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    public static Pair minmax(double[] vals) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for (double v : vals) {
            if (v < min) {
                min = v;
            }
            if (v > max) {
                max = v;
            }
        }

        return new Pair(min, max);
    }
}
