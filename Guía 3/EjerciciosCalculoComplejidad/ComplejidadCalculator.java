public class ComplejidadCalculator {
    public long calculateFormula(int n, char formula) {
        switch (formula) {
            case 'a':
                return 2 * (long) Math.pow(n, 3) - Math.abs(3 * (long) Math.pow(n, 2) + 1);
            case 'b':
                return (long) Math.pow(n, 5) + (long) Math.pow(4, 2) - (long) Math.sqrt(n) + 1;
            case 'c':
                return (long) (n * n * Math.pow(Math.log(n), 1)) + 2 * (long) Math.pow(n, 4) + (long) Math.sqrt(2 * n);
            default:
                throw new IllegalArgumentException("Fórmula inválida");
        }
    }

    public boolean checkComplexity(long value, int n, int complexity) {
        double max = Math.pow(n, complexity);
        return value <= max;
    }
}