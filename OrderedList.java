import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
        // Your code here.
        head = new Node ( null, null, null );
        //head.next = head;
        //head.previous = head;
    }

    // Calculates the size of the list

    public int size() {
      	// Remove line below and add your implementation.

        if ( head.next == null ) {
          return 0;
        }

        int size = 0;
        Node temp = head.next;

        while ( temp != null ) {
          size++;
          temp = temp.next;
        }

        return size;
    }


    public Object get( int pos ) {
        // Remove line below and add your implementation.

        if ( pos < 0 ) {
          throw new IndexOutOfBoundsException("Bruh, why you gotta be so negative?");
        }
        
        if ( pos > size() - 1 ) {
          throw new IndexOutOfBoundsException("Are you sure the item is at this place?");
        }

        Node temp = head.next;

        for (int i = 0; i < pos; i++) {
          temp = temp.next;
        }

        return temp.value;
    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {
        // Remove line below and add your implementation.
        if ( o == null ) {
          throw new IllegalArgumentException( "Bruh, you can't add null!" );
        }

        Node currentNode;

        if ( head.next == null ) {
          currentNode = new Node (o, head, null);
          head.next = currentNode;
          return true;
        }

        currentNode = head.next;

        //System.out.println("The beginning of the add method");
        //System.out.println("The size is = " + size());

        while ( currentNode != null ) {

          //System.out.println( "I got into the loop" );

          int comparedCurrent = o.compareTo(currentNode.value);

          //System.out.println( "o = " + o );
          //System.out.println( "currentNode.value = " + currentNode.value );
          //System.out.println( "comparedCurrent = " + comparedCurrent );
          
          // checking to see if "o" is the smallest thing 
          if ( comparedCurrent <= 0 && currentNode.previous == head ) {

            //System.out.println( "First if" );

            Node temp = new Node(o, head, currentNode);
            head.next = temp;
            currentNode.previous = temp;
            break;
          }
          
          // checking to see if "o" is the biggest thing
          else if ( comparedCurrent >= 0 && currentNode.next == null ) {

            //System.out.println( "Second if" );

            Node temp = new Node(o, currentNode, null);
            currentNode.next = temp;
            break;
          }
          
          // well, that means "o" is a value that's somewhere in the middle
          else {
            //System.out.println( "Third if" );

            int comparedNext = o.compareTo(currentNode.next.value);

            if ( comparedCurrent >= 0 && comparedNext <= 0 ) {
              Node temp = new Node(o, currentNode, currentNode.next);
              Node currentNext = currentNode.next;
              currentNode.next = temp;
              currentNext.previous = temp;
              break;
            }
          }

          //System.out.println(  );

          currentNode = currentNode.next;
          
        }

        //System.out.println("The end of the add method");
        //System.out.println("The size is = " + size());

        return true;

    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
      // Remove line below and add your implementation.

        if ( pos < 0 ) {
          throw new IndexOutOfBoundsException( "Bruh, why you gotta be so negative?" );
        }

        if ( pos > size() - 1 ) {
          throw new IndexOutOfBoundsException( "Are you sure the item is at this place?" );
        }

        Node temp = head.next;

        for (int i = 0; i < pos; i++) {
          temp = temp.next;
        }

        // removing first element
        if ( temp.previous == head ) {
          Node nextNode = temp.next;
          head.next = nextNode;
          nextNode.previous = head;

          temp.previous = null;
          temp.next = null;
        }
        // removing last element
        else if ( temp.next == null ) {
          Node prevNode = temp.previous;
          prevNode.next = null;

          temp.previous = null;
        }
        // removing an element that's somewhere in the middle
        else {
          Node nextNode = temp.next;
          Node prevNode = temp.previous;

          prevNode.next = nextNode;
          nextNode.previous = prevNode;

          temp.previous = null;
          temp.next = null;
        }


    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList other ) {
      // Remove line below and add your implementation.
      if ( this.size() >= 1 && other.size() >= 1 ) {
        
        Node thisNode = this.head.next;
        Node otherNode = other.head.next;
        boolean inserted = false;

        while ( otherNode != null ) {

          while ( thisNode != null && ! inserted ) {

            int comparedCurrent = otherNode.value.compareTo(thisNode.value);
          
            // checking to see if the value of otherNode is the smallest thing 
            if ( comparedCurrent <= 0 && thisNode.previous == head ) {

              //System.out.println( "First if" );

              Node temp = new Node(otherNode.value, head, thisNode);
              head.next = temp;
              thisNode.previous = temp;
              
              inserted = true;

            }

            // checking to see if the value of otherNode is the biggest thing
            else if ( comparedCurrent >= 0 && thisNode.next == null ) {

              //System.out.println( "Second if" );

              Node temp = new Node(otherNode.value, thisNode, null);
              thisNode.next = temp;

              inserted = true;

            }

            // well, that means the value of otherNode is a value that's somewhere in the middle
            else {

              int comparedNext = otherNode.value.compareTo(thisNode.next.value);
              
              if ( comparedCurrent >= 0 && comparedNext <= 0 ) {

                //System.out.println( "Third if" );
                
                Node temp = new Node(otherNode.value, thisNode, thisNode.next);
                Node thisNext = thisNode.next;

                //System.out.println( "thisNext = " + thisNext.value );

                thisNode.next = temp;
                thisNext.previous = temp;

                inserted = true;

              }
              
            }

            thisNode = thisNode.next;

            //System.out.println();
            //printList();
          }

          otherNode = otherNode.next;
          inserted = false;

        }

      }

    }

    public void printList (){
      System.out.println();
      System.out.println( "My list" );

      Node currentNode = head.next;

      while ( currentNode != null ) {
        System.out.println( currentNode.value );
        currentNode = currentNode.next;
      }

      System.out.println();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*public static void testConstructor() {

        OrderedList list = new OrderedList();

        //assertEquals(0, list.size());
        System.out.println( "0 = " + list.size() );

    }

    public static void testGetNegative() {

        OrderedList list = new OrderedList();

        try {
            list.get(-1);
            System.out.println( "list.get(-1) was expected to throw IndexOutOfBoundsException" );
        } catch (IndexOutOfBoundsException e) {
            System.out.println( "get method works" );            
        }

    }

    public static void testGetIndexOutOfBoundsException() {

        OrderedList list = new OrderedList();

        try {
            list.get(1);
            System.out.println("list.get(1) on empty list was expected to throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println( "get method works" );
        }

    }

    public static void testAddExceptions() {

        OrderedList list = new OrderedList();

        try {
            list.add(null);
            System.out.println("list.add(null) was expected to throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            System.out.println( "add method works" );
            
        } catch (NullPointerException e) { // Acceptable
            System.out.println( "add method works" );
        }

    }

    public static void testRemoveNegative() {

        OrderedList list = new OrderedList();

        try {
            list.remove(-1);
            System.out.println("list.remove(-1) was expected to throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println( "remove method works" );
        }

    }

    public static void testRemoveIndexOutOfBoundsException() {

        OrderedList list = new OrderedList();

        try {
            list.remove(1);
            System.out.println("list.get(1) on empty list was expected to throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println( "remove method works" );
        }

    }

    public static void testAddAlreadySorted() {

        OrderedList list = new OrderedList();

        list.add("A");
        list.add("B");

        //assertEquals(2, list.size());
        System.out.println( "2 = " + list.size() );

        //assertEquals("A", list.get(0));
        System.out.println( "A = " + list.get(0) );

        //assertEquals("B", list.get(1));
        System.out.println( "B = " + list.get(1) );
        

    }

    public static void testAddNeedsSorting() {

        OrderedList list = new OrderedList();

        list.add("C");
        list.add("A");
        list.add("B");

        //assertEquals("A", list.get(0));
        System.out.println( "A = " + list.get(0) );

        //assertEquals("B", list.get(1));
        System.out.println( "B = " + list.get(1) );
        

        //assertEquals("C", list.get(2));
        System.out.println( "C = " + list.get(2) );
        

    }

    
    public static void testRemoveLast() {

        OrderedList list = new OrderedList();

        list.add("A");
        list.add("B");

        list.remove(1);

        //assertEquals(1, list.size());
        System.out.println( "1 = " + list.size() );

        //assertEquals("A", list.get(0));
        System.out.println( "A = " + list.get(0) );
        

    }

    
    public static void testRemoveFirst() {

        OrderedList list = new OrderedList();

        list.add("A");
        list.add("B");

        list.remove(0);

        //assertEquals("B", list.get(0));
        System.out.println( "B = " + list.get(0) );
        

    }

    
    public static void testMerge() {

      OrderedList list1 = new OrderedList();
      OrderedList list2 = new OrderedList();

      list1.add("C");
      list1.add("A");
      
      list2.add("D");
      list2.add("B");

      list1.merge(list2);

      //System.out.println();
      //System.out.println( "Printing list from testMerge" );
      //list1.printList();

      //assertEquals(4, list1.size());
      System.out.println( "4 = " + list1.size() );

      //assertEquals(2, list2.size());
      System.out.println( "2 = " + list2.size() );

      //assertEquals("A", list1.get(0));
      System.out.println( "A = " + list1.get(0) );

      //assertEquals("B", list1.get(1));
      System.out.println( "B = " + list1.get(1) );

      //assertEquals("C", list1.get(2));
      System.out.println( "C = " + list1.get(2) );

      //assertEquals("D", list1.get(3));
      System.out.println( "D = " + list1.get(3) );
    }

    public static void main(String[] args) {

      System.out.println( "testConstructor" );
      testConstructor();
      System.out.println(  );

      System.out.println( "testGetNegative" );
      testGetNegative();
      System.out.println(  );

      System.out.println( "testGetIndexOutOfBoundsException" );
      testGetIndexOutOfBoundsException();
      System.out.println(  );

      System.out.println( "testAddExceptions" );
      testAddExceptions();
      System.out.println(  );

      System.out.println( "testRemoveNegative" );
      testRemoveNegative();
      System.out.println(  );

      System.out.println( "testRemoveIndexOutOfBoundsException" );
      testRemoveIndexOutOfBoundsException();
      System.out.println(  );

      System.out.println( "testAddAlreadySorted" );
      testAddAlreadySorted();
      System.out.println(  );

      System.out.println( "testAddNeedsSorting" );
      testAddNeedsSorting();
      System.out.println(  );

      System.out.println( "testRemoveLast" );
      testRemoveLast();
      System.out.println(  );

      System.out.println( "testRemoveFirst" );
      testRemoveFirst();
      System.out.println(  );

      System.out.println( "testMerge" );
      testMerge();
      System.out.println(  );

    }*/



}