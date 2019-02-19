//import java.util.Arrays;

public class Arithmetic extends AbstractSeries {

    // instance variables
    double [] aSum = super.take (5);
    int pos = 0;

    public double [] take (int k){

      double sum = 0;

      for (int i = 1; i <= k; i++){
        sum = sum + i;
        aSum[i - 1] = sum;
      }

      return aSum;
    }

    public double next() {

        // implement the method
        int temp = pos;
        pos++;
        if (pos > aSum.length){
        	return aSum[aSum.length - 1];
        }

        return aSum[temp]; 
    }

    /*public static void testExtendsAbstractSeries() {
      AbstractSeries s;
      s = new Arithmetic();
      System.out.println(s instanceof Arithmetic);
      System.out.println(s instanceof AbstractSeries);
    }

    public static void testArithmeticSeriesValues() {
      Arithmetic s = new Arithmetic();
      double[] actual = s.take(5);
      double[] expected = new double[]{1,3,6,10,15};
      System.out.println(Arrays.equals(expected, actual));

      double sixth = s.next();
      System.out.println("21 " + sixth +  " 0");
    }

    public static void main (String [] args){
    	testExtendsAbstractSeries ();
    	testArithmeticSeriesValues();

    }*/
}