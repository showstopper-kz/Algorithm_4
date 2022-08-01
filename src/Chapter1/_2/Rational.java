package Chapter1._2;

public final class Rational {
    long numerator;
    long denominator;

    public Rational(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        assert denominator != 0: "denominator is zero";

        long n = gcd(numerator,denominator);
        if (n != 1) {
            this.numerator /= n;
            this.denominator /= n;
        }
    }

    private long robuPlus(long a, long b) {
        long res = a + b;
        if (a == 0) return b;
        if (b == 0) return a;

        if (a > 0 && b > 0) {
            // upside out of
            assert res > 0 && res > a && res > b;
        } else if (a < 0 && b < 0)
            // downside out of
            assert res < 0 && res < a && res < b;
        return res;
    }

    private long robuTimes(long a, long b) {
        long res = a * b;
        if (a ==0 || b == 0) return 0;
        if (a == 1) return b;
        if (b == 1) return a;

        if (a > 0 && b > 0)
            // upside out of
            assert res > 0 && res > a && res > b;
        else if (a < 0 && b < 0)
            // upside out of
            assert res > 0 && res > -a && res > -b;
        else
            assert res < 0 && res < b && res < a;

        return res;
    }

    private long robuMinus(long a, long b) {
        long res = a - b;
        if (a == 0) return -b;
        if (b == 0) return a;
        return robuPlus(a, -b);
    }

    public Rational plus(Rational b) {
        long a1 = robuTimes(numerator , b.denominator);
        long a2 = robuTimes(denominator,  b.numerator);
        long a3 = robuTimes(this.denominator, b.denominator);
        return new Rational(robuPlus(a1, a2), a3);
    }

    public Rational minus(Rational b) {
        long a1 = robuTimes(numerator , b.denominator);
        long a2 = robuTimes(denominator,  b.numerator);
        long a3 = robuTimes(this.denominator, b.denominator);
        return new Rational(robuMinus(a1, a2), a3);
    }

    public Rational times(Rational b) {
        long a1 = robuTimes(this.numerator , b.numerator);
        long a2 = robuTimes(this.denominator, b.denominator);
        return new Rational(a1, a2);
    }

    public Rational divides(Rational b) throws Exception{
        if (numerator == 0) return new Rational(0, 0);
        if (b.numerator == 0) throw new Exception("can't divide a zero value");
        long a1 = robuTimes(numerator , b.denominator);
        long a2 = robuTimes(denominator,  b.numerator);
        return new Rational(a1, a2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Rational that = (Rational) obj;
        if (this.numerator == that.numerator && this.denominator == that.denominator)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        long r = a % b;
        return gcd(b, r);
    }

    public static void main(String[] args) throws Exception{
        Rational a = new Rational(1, 2);
        Rational b = new Rational(3, 4);

        assert a.plus(b).equals(new Rational(5, 4));
        assert a.minus(b).equals(new Rational(-1, 4));
        assert a.times(b).equals(new Rational(3, 8));
        assert a.divides(b).equals(new Rational(2, 3));

        Rational max = new Rational(Long.MAX_VALUE, 1);
        Rational min = new Rational(Long.MIN_VALUE, 1);
        Rational d = new Rational(2, 1);
        min.times(d);
    }
}
