
public class ArrayStack<E> implements Stack<E> {


    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell

    @SuppressWarnings( "unchecked" )

    // Constructor

    public ArrayStack( int capacity ) {
        elems = (E[]) new Object[ capacity ];
        top = 0;
    }

    // Returns true if this ArrayStack is empty

    public boolean isEmpty() {

        // Same as:
        // if ( top == 0 ) {
        //     return true;
        // } else {
        //     return false;
        // }

        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it

    public E peek() {

        // pre-conditions: ! isEmpty()

        return elems[ top-1 ];
    }

    // Removes and returns the top element of this stack

    public E pop() {

        // pre-conditions: ! isEmpty()

        // *first* decrements top, then access the value!
        E saved = elems[ --top ];

        elems[ top ] = null; // scrub the memory!

        return saved;
    }

    // Puts the element onto the top of this stack.

    public void push( E element ) {

        // Pre-condition: the stack is not full
        // *first* stores the element at position top, then increments top

        elems[ top++ ] = element;
    }


    // Gets current capacity of the array (for testing purpose)
    public int getCapacity() {
        return elems.length;
    }




    @SuppressWarnings( "unchecked" )

    // Add clear method.
    public void clear (){
        for (int i = 0; i < elems.length; i++) {
            if ( ! isEmpty() ){
                pop();
            }

        }
    }

    /*public static void testClearEmptyStack() {
      ArrayStack<Integer> myStack = new ArrayStack<Integer>(5);
      //assertEquals(true, myStack.isEmpty());
      System.out.println(myStack.isEmpty());
      myStack.clear();
      //assertEquals(true, myStack.isEmpty());
      System.out.println(myStack.isEmpty());

  }


  public static void testClearPopulatedStack() {
      ArrayStack<Integer> myStack = new ArrayStack<Integer>(5);
      myStack.push(1);
      myStack.push(2);
      myStack.push(3);
      //assertEquals(false, myStack.isEmpty());
      System.out.println(myStack.isEmpty());
      myStack.clear();
      //assertEquals(true, myStack.isEmpty());
      System.out.println(myStack.isEmpty());


  }

  public static void main(String[] args) {

    System.out.println("testClearEmptyStack "); 
    testClearEmptyStack();
    System.out.println();

    System.out.println("testClearPopulatedStack "); 
    testClearPopulatedStack();
    System.out.println();
}*/

}
