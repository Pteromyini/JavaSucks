public class Customer {

    // Constant

    private static final int MAX_NUM_ITEMS = 25;

    // Instance variables

    private int arrivalTime;
    private int numberOfItems;
    private int initialNumberOfItems;

    // Constructor

    public Customer( int arrivalTime ) {
        // Your code here.
        this.arrivalTime = arrivalTime;
        numberOfItems =  (int) ( ( MAX_NUM_ITEMS - 1 ) * Math.random() ) + 1;
        initialNumberOfItems = numberOfItems;
    }

    // Access methods

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getNumberOfServedItems() {
        // Your code here.
        return initialNumberOfItems - numberOfItems;
    }

    public void serve() {
        // Your code here.
        numberOfItems--;
    }

    /////////////////////////////////////////////////////
    
    /*public static void customerConstructor() {
      Customer someGuy = new Customer(5);
      //assertEquals(5, someGuy.getArrivalTime());
      System.out.println( "5 = " + someGuy.getArrivalTime() );

      Customer fastGuy = new Customer(0);
      //assertEquals(0, fastGuy.getArrivalTime());
      System.out.println( "0 = " +fastGuy.getArrivalTime() );

      
  }


  public static void customerServeItems() {
      Customer someGuy = new Customer(5);
      int beforeItems = someGuy.getNumberOfItems();
      someGuy.serve();
      int afterItems = someGuy.getNumberOfItems();
      int diffItems = beforeItems - afterItems;
      //assertEquals(1, diffItems);
      System.out.println( "1 = " + diffItems );
      
  }


  public static void customerNumberServed() {
      Customer someGuy = new Customer(5);
      //assertEquals(0, someGuy.getNumberOfServedItems());
      System.out.println( "0 = " + someGuy.getNumberOfServedItems() );

      someGuy.serve();
      
      //assertEquals(1, someGuy.getNumberOfServedItems());
      System.out.println( "1 = " + someGuy.getNumberOfServedItems() );

  }

  public static void main(String[] args) {

    System.out.println( "customerConstructor" );
    customerConstructor();
    System.out.println(  );

    System.out.println( "customerServeItems" );
    customerServeItems();
    System.out.println(  );

    System.out.println( "customerNumberServed" );
    customerNumberServed();
    System.out.println(  );

}*/


}