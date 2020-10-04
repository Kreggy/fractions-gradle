import org.junit.Assert;
import org.junit.Test;


public class TestDivide {

    @Test
    public void testSimple() {
        var fraction = TestUtils.createFraction(6, 5);
        var result = fraction.dividedBy(new NotImplementedFraction(3, 8));

        Assert.assertEquals((Integer) 16, result.getNumerator());
        Assert.assertEquals((Integer) 5, result.getDenominator());
    }

    @Test
    public void testNormalisation() {
        var fraction = TestUtils.createFraction(4, 2);
        var result = fraction.dividedBy(new NotImplementedFraction(8, 4));

        Assert.assertEquals((Integer) 1, result.getNumerator());
        Assert.assertEquals((Integer) 1, result.getDenominator());
    }
}
