public class Fraction implements IFraction {

    private final Integer numerator;
    private final Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (denominator == 0) throw new ArithmeticException("Cannot Divide by 0");
    }

    @Override
    public Integer getNumerator() {
        return numerator;
    }

    @Override
    public Integer getDenominator() {
        return denominator;
    }

    @Override
    public IFraction plus(IFraction other) {
        int denominatorR = getDenominator() * other.getDenominator();
        int numeratorR = (other.getDenominator() * getNumerator()) + (getDenominator() * other.getNumerator());
        return createNormalised(numeratorR, denominatorR);
    }

    @Override
    public IFraction minus(IFraction other) {
        int denominatorR = getDenominator() * other.getDenominator();
        int numeratorR = (other.getDenominator() * getNumerator()) - (getDenominator() * other.getNumerator());
        return createNormalised(numeratorR, denominatorR);
    }

    @Override
    public IFraction times(IFraction other) {
        int denominatorR = getDenominator() * other.getDenominator();
        int numeratorR = getNumerator() * other.getNumerator();
        return createNormalised(numeratorR, denominatorR);
    }

    @Override
    public IFraction dividedBy(IFraction other) {
        int denominatorR = getDenominator() * other.getNumerator();
        int numeratorR = getNumerator() * other.getDenominator();
        return createNormalised(numeratorR, denominatorR);
    }

    public static Fraction createNormalised(Integer numerator, Integer denominator) {
        int max = 1;
        for(int i = 1; (i <= numerator) && (i <= denominator); i++) {
            if(((numerator % i) == 0) && ((denominator % i) == 0)) max = i;
        }
        numerator /= max;
        denominator /= max;

        return new Fraction(numerator, denominator);
    }

    @Override
    public String toString() {
        return "Fraction " + numerator + "|" + denominator;
    }
}
