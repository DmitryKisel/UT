package test.java;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class TNGGroupFourTest {
    Triangle triangle;

    @DataProvider(name = "getSquareExceptionsExpectedProvider")
    public Object[][] getSquareExceptionsExpectedProviderData() {
        return new Object[][]
                {
                        {-5.0d, 4.0d, 5.0d},
                        {5.0d, -4.0d, 5.0d},
                        {5.0d, 4.0d, -5.0d},
                        {5.0d, 0.0d, 4.1d},
                        {0.0d, 5.0d, 4.1d},
                        {5.0d, 4.1d, 0.0d},
                        {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                };
    }

    @DataProvider(name = "getSquarePositiveProvider")
    public Object[][] getSquarePositiveProviderData() {
        return new Object[][]
                {
                        {1.0d, 1.0d, 1.0d},

                };
    }

        @Test(expectedExceptions = Exception.class, dataProvider = "getSquareExceptionsExpectedProvider")
        public void tstGetSquareExceptionsExpected(Double side_a, Double side_b, Double side_c) throws Exception {
            triangle = new Triangle(side_a, side_b, side_c);
            triangle.getSquare();
        }



        @Test(dataProvider = "getSquarePositiveProvider")
        public void tstGetSquare(Double side_a, Double side_b, Double side_c){
        double p = (side_a + side_b + side_c)/2;
        double square = Math.sqrt(p*(p-side_a)*(p-side_b)*(p - side_c));
        triangle = new Triangle(side_a, side_b, side_c);
            Assert.assertEquals(triangle.getSquare(), square);
        }


    }

