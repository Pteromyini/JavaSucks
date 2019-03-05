public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        // Your code here.
        elems = (E[]) new Object[DEFAULT_INC];
        top = 0;
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        // Your code here.
        if (isEmpty() == false){
            E temp = elems [--top];
            elems[top] = null;
            return temp;
        }
        return null;
    }

    private void increaseSize(E element){
        E [] temp = (E []) new Object [elems.length + DEFAULT_INC];

        for (int i = 0; i < elems.length; i++) {
            temp[i] = elems[i];
        }

        temp [top++] = element;

        elems = temp;
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        // Your code here.
        if (top < elems.length){
            elems[top++] = element;
        }
        else {
            increaseSize(element);
        }
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        // Your code here.
        for (int i = 0; i < elems.length; i++) {
            pop();
        }
    }

    ///////////////////////////////////////////////////
    public static void testPushDynamic24th() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 24; i++) {
        myStack.push(i);
    }
      //assertEquals(23, (int) myStack.peek());
      //assertEquals(25, (int) myStack.getCapacity());
    System.out.println("23 = " + (int) myStack.peek());
    System.out.println("25 = " + (int) myStack.getCapacity());


}


public static void testPushDynamic26th() {
  DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
  for (int i = 0; i < 26; i++) {
    myStack.push(i);
}
      //assertEquals(25, (int) myStack.peek());
      //assertEquals(50, (int) myStack.getCapacity());
System.out.println("25 = " + (int) myStack.peek());
System.out.println("50 = " + (int) myStack.getCapacity());

}


public static void testPopDynamic1st() {
  DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(0);
      //assertEquals(25, (int) myStack.getCapacity());
  System.out.println("25 = " + (int) myStack.getCapacity());
  myStack.push(999);
      //assertEquals(999, (int) myStack.pop());
  System.out.println("999 = " + (int) myStack.pop());

}


public static void testPopDynamic26th25th() {
  DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
  for (int i = 0; i < 26; i++) {
    myStack.push(i);
}

/*System.out.println("no pop");
for (int i : myStack) {
    System.out.println(myStack[i]);
}

System.out.println("pop 1");*/
//System.out.println("capacity = " + myStack.getCapacity());
System.out.println( "top = " + myStack.peek());
myStack.pop();
//System.out.println("capacity = " + myStack.getCapacity());

/*for (int i : myStack) {
    System.out.println(myStack[i]);
}

System.out.println("pop 2");*/
System.out.println( "top = " + myStack.peek());
myStack.pop();
//System.out.println("capacity = " + myStack.getCapacity());

/*for (int i : myStack) {
    System.out.println(myStack[i]);
}*/
      //assertEquals(25, (int) myStack.getCapacity());
System.out.println("25 = " + (int) myStack.getCapacity());


}


public static void testClearDynamic5() {
  DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
  for (int i = 0; i < 5; i++) {
    myStack.push(i);
}
myStack.clear();
      //assertEquals(true, myStack.isEmpty());
      //assertEquals(25, (int) myStack.getCapacity());
System.out.println(myStack.isEmpty());
System.out.println("25 = " + (int) myStack.getCapacity());


}


public static void testClearDynamic100() {
  DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
  for (int i = 0; i < 100; i++) {
    myStack.push(i);
}
myStack.clear();
      //assertEquals(true, myStack.isEmpty());
System.out.println(myStack.isEmpty());
//assertEquals(true, myStack.isEmpty());
System.out.println(myStack.isEmpty());


}

public static void main(String[] args) {

    /*System.out.println("testPushDynamic24th");
    testPushDynamic24th();
    System.out.println();

    System.out.println("testPushDynamic26th");
    testPushDynamic26th();
    System.out.println();

    System.out.println("testPopDynamic1st");
    testPopDynamic1st();
    System.out.println();*/

    System.out.println("testPopDynamic26th25th");
    testPopDynamic26th25th();
    System.out.println();

    /*System.out.println("testClearDynamic5");
    testClearDynamic5();
    System.out.println();

    System.out.println("testClearDynamic100");
    testClearDynamic100();
    System.out.println();*/



}

}
