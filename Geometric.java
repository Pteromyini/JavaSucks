import java.util.Arrays;

public class Geometric extends AbstractSeries {

    // instance variables
    double [] gSum = super.take (5);
    int pos = 0;

    public double [] take (int k){

      double sum = 0;

      for (int i = 0; i <= k; i++){
        sum = sum + 1/(Math.pow(2,i));
        gSum[i - 1] = sum;
      }

      return gSum;
    }

    public double next() {

        // implement the method
        int temp = pos;
        pos++;
        if (pos > gSum.length){
        	return gSum[gSum.length - 1];
        }

        return gSum[temp];
    }

    public static void testImplementsSeries() {
      Series s;
      s = new Geometric();
      System.out.println(s instanceof Geometric);
      System.out.println(s instanceof Series);
    }

    public static void testGeometricSeriesValues() {
      Geometric s = new Geometric();
      double[] actual = s.take(5);
      double[] expected = new double[]{1, 1.5, 1.75, 1.875, 1.9375};
      System.out.println(Arrays.equals(expected, actual));

      double sixth = s.next();
      System.out.println("1.96875 " + sixth + " 0");
    }


    public static void main(String[] args) {

        testImplementsSeries();
        testGeometricSeriesValues();

    }
}
