package test.java;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;


public class TNGGroupThreeTest {

    Triangle triangle;

    @DataProvider(name = "detectTriangleProvider")
    public Object[][] detectTriangleProviderData() {
        return new Object[][]
                {
                        {5.0d, 4.0d, 3.0d, 8},
                        {4.0d, 5.0d, 3.0d, 8},
                        {3.0d, 4.0d, 5.0d, 8},
                        {4.0d, 5.0d, 5.0d, 2},
                        {5.0d, 4.0d, 5.0d, 2},
                        {5.0d, 5.0d, 4.1d, 2},
                        {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE / 2, 2},
                        {2.1d, 2.1d, 2.1d, 3},
                        {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 3},
                        {4.0d, 5.0d, 6.0d, 4},
                        {1d, 1d, Math.sqrt(2.0d), 10},
                        {1d, Math.sqrt(2.0d), 1d, 10},
                        {Math.sqrt(2.0d), 1d, 1d, 10},
                };
    }

    @DataProvider(name = "detectTriangleExceptionsExpectedProvider")
    public Object[][] detectTriangleExceptionsExpectedProviderData() {
        return new Object[][]
                {
                        {0.0d, 0.0d, 0.0d},
                        {-4.0d, 5.0d, 3.0d},
                        {3.0d, -4.0d, 5.0d},
                        {4.0d, 5.0d, -5.0d},
                        {0.0d, 4.0d, 5.0d},
                        {5.0d, 0.0d, 4.1d},
                        {5.0d, 4.1d, 0.0d},
                };
    }

    @Test(dataProvider = "detectTriangleProvider")
    public void tstDetectTriangle(Double side_a, Double side_b, Double side_c, int expected_result) {
        triangle = new Triangle(side_a, side_b, side_c);
        Assert.assertEquals(triangle.detectTriangle(), expected_result);
    }


    @Test(expectedExceptions = Exception.class, dataProvider =
            "detectTriangleExceptionsExpectedProvider")
    public void tstDetectTriangleExceptionsExpected(Double side_a, Double side_b, Double side_c) throws Exception {
            triangle = new Triangle(side_a, side_b, side_c);
            triangle.detectTriangle();
    }
}
