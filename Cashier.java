public class Cashier {

    // Constant

    private static final String nl = System.getProperty( "line.separator" );

    // Instance variables

    private Queue<Customer> queue;
    private Customer currentCustomer;

    private int totalCustomerWaitTime;
    private int customersServed;
    private int totalItemsServed;

    // constructor

    public Cashier(){
        // Your code here.
        queue = new ArrayQueue<Customer>();
        totalCustomerWaitTime = 0;
        customersServed = 0;
        totalItemsServed = 0;
    }

    public void addCustomer( Customer c ) {
        // Your code here.
        queue.enqueue(c);
    }

    public int getQueueSize() {
        // Your code here.
        return queue.size();
    }

    public void serveCustomers( int currentTime ){
      // Your code here.
        if ( queue.isEmpty() ) {
            if ( currentCustomer != null ) {
                if ( currentCustomer.getNumberOfItems() >= 1  ) {

                    currentCustomer.serve();
                    totalItemsServed++;

                    if ( currentCustomer.getNumberOfItems() == 0 ) {
                        customersServed++;
                        currentCustomer = null;
                    }

                }
            }
        }

        if ( ! queue.isEmpty() ) {
            if ( currentCustomer == null ) {
                currentCustomer = queue.dequeue();
                totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();
            }

            if ( currentCustomer.getNumberOfItems() >= 1  ) {

                currentCustomer.serve();
                totalItemsServed++;

                if ( currentCustomer.getNumberOfItems() == 0 ) {
                    customersServed++;
                    currentCustomer = null;
                }

            }

        }

    }

    public int getTotalCustomerWaitTime() {
        return totalCustomerWaitTime;
    }

    public int getTotalItemsServed() {
        return totalItemsServed;
    }

    public int getTotalCustomersServed() {
        return customersServed;
    }

    public String toString() {

        StringBuffer results = new StringBuffer();

        results.append( "The total number of customers served is " );
        results.append( customersServed );
        results.append( nl );

        results.append( "The average number of items per customer was " );
        results.append( totalItemsServed / customersServed );
        results.append( nl );

        results.append( "The average waiting time (in seconds) was " );
        results.append( totalCustomerWaitTime / customersServed );
        results.append( nl );

        return results.toString();
    }


    ////////////////////////////////////////////////////////////////////////////////
    /*public static void cashierConstructor() {
      Cashier cashier = new Cashier();
      //assertEquals(0, cashier.getTotalCustomerWaitTime());
      System.out.println("0 = " + cashier.getTotalCustomerWaitTime());

      //assertEquals(0, cashier.getTotalItemsServed());
      System.out.println("0 = " + cashier.getTotalItemsServed());

      //assertEquals(0, cashier.getTotalCustomersServed());
      System.out.println("0 = " + cashier.getTotalCustomersServed());
  }

  public static void cashierServeEmpty() {
      Cashier cashier = new Cashier();
      cashier.serveCustomers(5);
      //assertEquals(0, cashier.getTotalCustomerWaitTime());
      System.out.println( "0 = " + cashier.getTotalCustomerWaitTime() );

      //assertEquals(0, cashier.getTotalItemsServed());
      System.out.println( "0 = " + cashier.getTotalItemsServed() );

      //assertEquals(0, cashier.getTotalCustomersServed());
      System.out.println( "0 = " + cashier.getTotalCustomersServed() );


  }


  public static void cashierServeOne() {
      Cashier cashier = new Cashier();
      Customer customer = new Customer(5);
      cashier.addCustomer(customer);

      //assertEquals(1, cashier.getQueueSize());
      System.out.println( "1 = " + cashier.getQueueSize() );


      int items = customer.getNumberOfItems();
      System.out.println( "number of items of the Customer = " + items );

      for (int i = 0; i < items; i++) {
        cashier.serveCustomers(10);
    }

    //assertEquals(0, cashier.getQueueSize());
    System.out.println( "0 = " + cashier.getQueueSize() );


    //assertEquals(items, cashier.getTotalItemsServed());
    System.out.println( "number of items that I have served = " + cashier.getTotalItemsServed() );
    //assertEquals(1, cashier.getTotalCustomersServed());
    System.out.println( "1 = " + cashier.getTotalCustomersServed() );


    //assertEquals(5, cashier.getTotalCustomerWaitTime());
    System.out.println( "5 = " + cashier.getTotalCustomerWaitTime() );

}


public static void cashierServeTwo() {
  Cashier cashier = new Cashier();
  Customer customer1 = new Customer(5);
  Customer customer2 = new Customer(10);
  cashier.addCustomer(customer1);
  cashier.addCustomer(customer2);

  //assertEquals(2, cashier.getQueueSize());
  System.out.println( "2 = " + cashier.getQueueSize() );


  int items1 = customer1.getNumberOfItems();

  System.out.println( "number of items of customer1 (items1) = " + items1 );

  int items2 = customer2.getNumberOfItems();

  System.out.println( "number of items of customer2 (items2) = " + items2 );

  for (int i = 0; i < items1; i++) {
    cashier.serveCustomers(10);
}

//assertEquals(1, cashier.getTotalCustomersServed());
System.out.println( "1 = " + cashier.getTotalCustomersServed() );


for (int i = 0; i < items2; i++) {
    cashier.serveCustomers(15);
}

//assertEquals(2, cashier.getTotalCustomersServed());
System.out.println( "2 = " + cashier.getTotalCustomersServed() );


//assertEquals(items1 + items2, cashier.getTotalItemsServed());
System.out.println( "items1 + items2 = " + cashier.getTotalItemsServed() );


//assertEquals(10, cashier.getTotalCustomerWaitTime());
System.out.println( "10 = " + cashier.getTotalCustomerWaitTime() );


//assertEquals(0, cashier.getQueueSize());
System.out.println( "0 = " + cashier.getQueueSize() );

}

public static void main(String[] args) {

    System.out.println( "cashierConstructor" );
    cashierConstructor();
    System.out.println(  );

    System.out.println( "cashierServeEmpty" );
    cashierServeEmpty();
    System.out.println(  );

    System.out.println( "cashierServeOne" );
    cashierServeOne();
    System.out.println(  );

    System.out.println( "cashierServeTwo" );
    cashierServeTwo();
    System.out.println(  );

}*/




}