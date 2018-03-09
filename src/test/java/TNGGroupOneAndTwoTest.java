package test.java;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import triangle.Triangle;


public class TNGGroupOneAndTwoTest {
    Triangle triangle;

    @DataProvider(name = "checkTriangleProvider")
    public Object[][] checkTriangleProviderData() {
        return new Object[][]
                {
                        {0.0d, 0.0d, 0.0d, "a<=0"},
                        {0.0d, 2.0d, 2.0d, "a<=0"},
                        {2.0d, 0.0d, 2.0d, "b<=0"},
                        {2.0d, 2.0d, 0.0d, "c<=0"},
                        {-1.0d, -2.3d, -2.1d, "a<=0"},
                        {-1.0d, 2.3d, 2.1d, "a<=0"},
                        {2.1d, -1.0d, 2.3d, "b<=0"},
                        {2.1d, 2.3d, -1.0d, "c<=0"},
                        {12.1d, 2.3d, 2.5d, "b+c<=a"},
                        {2.5d, 12.1d, 2.3d, "a+c<=b"},
                        {2.5d, 2.3d, 12.1d, "a+b<=c"},
                };
    }


    @Test(dataProvider = "checkTriangleProvider")
    public void tstNegativeCheckTriangleAndGetMessage(Double side_a, Double side_b, Double side_c, String expected_result) {
        triangle = new Triangle(side_a, side_b, side_c);
        Assert.assertFalse(triangle.checkTriangle());
        Assert.assertEquals(triangle.getMessage(), expected_result);
    }


    @Test
    public void tstPositiveCheckTriangleAndGetMessage() {
        triangle = new Triangle(1.0, 2.0, 2.1);
        Assert.assertTrue(triangle.checkTriangle());
        Assert.assertEquals(triangle.getMessage(), "");
    }

}
