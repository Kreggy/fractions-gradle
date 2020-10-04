import org.junit.Assert;
import org.junit.Test;


public class TestTimes {

    @Test
    public void testSimple() {
        var fraction = TestUtils.createFraction(3, 5);
        var result = fraction.times(new NotImplementedFraction(3, 5));

        Assert.assertEquals((Integer) 9, result.getNumerator());
        Assert.assertEquals((Integer) 25, result.getDenominator());
    }

    @Test
    public void testNormalisation() {
        var fraction = TestUtils.createFraction(1, 3);
        var result = fraction.times(new NotImplementedFraction(3, 1));

        Assert.assertEquals((Integer) 1, result.getNumerator());
        Assert.assertEquals((Integer) 1, result.getDenominator());
    }
}
