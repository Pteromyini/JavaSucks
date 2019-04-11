public class Iterative {

    public static BitList complement( BitList in ) {

        // Your code here
        if ( in == null ) {
            throw new NullPointerException();
        }

        /*if ( in.size() == 0 ) {
            throw new IllegalArgumentException( "Bro, this BitList has nothing in it." );
        }*/

        BitList inDeepCopy = new BitList();
        Iterator inIterator = in.iterator();

        while ( inIterator.hasNext() ) {
            inDeepCopy.addFirst( inIterator.next() );
        }

        BitList logicalNot = new BitList();
        Iterator temp = in.iterator();

        while ( temp.hasNext() ) {

            int tempValue = temp.next();
            System.out.println( "value is = " + tempValue );
            
            if ( tempValue == 0 ) {
                logicalNot.addFirst ( 1 );
            }
            else {
                logicalNot.addFirst ( 0 );    
            }

            System.out.println( "logicalNot = \n" + logicalNot + "\n" );
        }

        return logicalNot;
    }

    public static BitList or( BitList a, BitList b ) {

        // Your code here
        if ( a == null || b == null ) {
            throw new NullPointerException();
        }

        if ( a.size() != b.size() ) {
            throw new IllegalArgumentException( "Bro, these two BitList are not the same size." );
        }

        if ( a.size() == 0 && b.size() == 0 ) {
            throw new IllegalArgumentException( "Bro, these two BitList are not the same size." );
        }

        Iterator temp1 = a.iterator();
        Iterator temp2 = b.iterator();

        BitList logicalOR = new BitList();

        while ( temp1.hasNext() && temp2.hasNext() ) {
            int temp1Value = temp1.next();
            int temp2Value = temp2.next();

            if ( temp1Value == 0 && temp2Value == 0 ) {
                logicalOR.addFirst ( 0 );
            }
            else {
                logicalOR.addFirst ( 1 );
            }
        }

        return logicalOR;

    }

    public static BitList and( BitList a, BitList b ) {

        // Your code here
        if ( a == null || b == null ) {
            throw new NullPointerException();
        }

        if ( a.size() != b.size() ) {
            throw new IllegalArgumentException( "Bro, these two BitList are not the same size." );
        }

        if ( a.size() == 0 && b.size() == 0 ) {
            throw new IllegalArgumentException( "Bro, these two BitList are not the same size." );
        }

        Iterator temp1 = a.iterator();
        Iterator temp2 = b.iterator();

        BitList logicalAnd = new BitList();

        while ( temp1.hasNext() && temp2.hasNext() ) {
            int temp1Value = temp1.next();
            int temp2Value = temp2.next();

            if ( temp1Value == 1 && temp2Value == 1 ) {
                logicalAnd.addFirst ( 1 );
            }
            else {
                logicalAnd.addFirst ( 0 );
            }
        }

        return logicalAnd;
    }

	public static BitList xor( BitList a, BitList b ) {

        // Your code here
        if ( a == null || b == null ) {
            throw new NullPointerException();
        }

        if ( a.size() != b.size() ) {
            throw new IllegalArgumentException( "Bro, these two BitList are not the same size." );
        }

        if ( a.size() == 0 && b.size() == 0 ) {
            throw new IllegalArgumentException( "Bro, these two BitList are not the same size." );
        }

        Iterator temp1 = a.iterator();
        Iterator temp2 = b.iterator();

        BitList logicalXOR = new BitList();

        while ( temp1.hasNext() && temp2.hasNext() ) {
            int temp1Value = temp1.next();
            int temp2Value = temp2.next();

            if ( ( temp1Value == 0 && temp2Value == 0 ) || ( temp1Value == 1 && temp2Value == 1 ) ){
                logicalXOR.addFirst ( 0 );
            }
            else {
                logicalXOR.addFirst ( 1 );
            }
        }

        return logicalXOR;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void testComplementSingle0() {

        BitList list = new BitList("0");
        Iterative it = new Iterative();
        BitList listComp = it.complement(list);
        int bit = listComp.removeFirst();
        //assertEquals(1, bit);
        System.out.println("1="+bit);
    }

    public static void testComplementSingle1() {

        BitList list = new BitList("1");
        Iterative it = new Iterative();
        BitList listComp = it.complement(list);
        int bit = listComp.removeFirst();
        //assertEquals(0, bit);
        System.out.println("0="+bit);
    }

    
    public static void testComplementMultiple() {

        BitList list = new BitList("1011");
        Iterative it = new Iterative();
        BitList listComp = it.complement(list);
        int bit1 = listComp.removeFirst();
        int bit2 = listComp.removeFirst();
        int bit3 = listComp.removeFirst();
        int bit4 = listComp.removeFirst();

        //assertEquals(0, bit1);
        System.out.println("0="+bit1);
        //assertEquals(0, bit2);
        System.out.println("0="+bit2);
        //assertEquals(1, bit3);
        System.out.println("1="+bit3);
        //assertEquals(0, bit4);
        System.out.println("0="+bit4);
    }

    
    public static void testOrExceptionsNotTheSameLength() {

        BitList list2 = new BitList("1");
        BitList list3 = new BitList("10");
        Iterative it = new Iterative();
        BitList list4;

        try {
            list4 = it.or(list2, list3);
            System.out.println("list.or on lists of different length was expected to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("or method has passed");
        }
    }

    
    public static void testOrExceptionsEmptyEmpty() {

        BitList list0 = new BitList("");
        BitList list1 = new BitList("");
        Iterative it = new Iterative();
        BitList list4;

        try {
            list4 = it.or(list0, list1);
            System.out.println("list.or on empty lists was expected to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("or method has passed");
        }

    }

    
    public static void testAndExceptionsNotTheSameLength() {

        BitList list2 = new BitList("1");
        BitList list3 = new BitList("10");
        Iterative it = new Iterative();
        BitList list4;

        try {
            list4 = it.and(list2, list3);
            System.out.println("list.and on lists of different length was expected to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("and method has passed");
        }
    }

    
    public static void testAndExceptionsEmptyEmpty() {

        BitList list0 = new BitList("");
        BitList list1 = new BitList("");
        Iterative it = new Iterative();
        BitList list4;

        try {
            list4 = it.and(list0, list1);
            System.out.println("list.and on empty lists was expected to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("and method has passed");
        }

    }

    
    public static void testXorExceptionsNotTheSameLength() {

        BitList list2 = new BitList("1");
        BitList list3 = new BitList("10");
        Iterative it = new Iterative();
        BitList list4;

        try {
            list4 = it.xor(list2, list3);
            System.out.println("list.xor on lists of different length was expected to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("xor method has passed");
        }
    }

    
    public static void testXorExceptionsEmptyEmpty() {

        BitList list0 = new BitList("");
        BitList list1 = new BitList("");
        Iterative it = new Iterative();
        BitList list4;

        try {
            list4 = it.xor(list0, list1);
            System.out.println("list.xor on empty lists was expected to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("xor method has passed");
        }

    }


    
    public static void testOr() {

        BitList list1 = new BitList("10001");
        BitList list2 = new BitList("00011");
        Iterative it = new Iterative();

        BitList list3 = it.or(list1, list2);

        int bit1 = list3.removeFirst();
        int bit2 = list3.removeFirst();
        int bit3 = list3.removeFirst();
        int bit4 = list3.removeFirst();
        int bit5 = list3.removeFirst();

        //assertEquals(1, bit1);
        System.out.println( "1=" + bit1 );
        //assertEquals(1, bit2);
        System.out.println( "1=" + bit2 );
        //assertEquals(0, bit3);
        System.out.println( "0=" + bit3 );
        //assertEquals(0, bit4);
        System.out.println( "0=" + bit4 );
        //assertEquals(1, bit5);
        System.out.println( "1=" + bit5 );        
    }

    
    public static void testAnd() {

        BitList list1 = new BitList("10001");
        BitList list2 = new BitList("00011");
        Iterative it = new Iterative();

        BitList list3 = it.and(list1, list2);

        int bit1 = list3.removeFirst();
        int bit2 = list3.removeFirst();
        int bit3 = list3.removeFirst();
        int bit4 = list3.removeFirst();
        int bit5 = list3.removeFirst();

        //assertEquals(1, bit1);
        System.out.println( "1=" + bit1 ); 
        //assertEquals(0, bit2);
        System.out.println( "0=" + bit2 ); 
        //assertEquals(0, bit3);
        System.out.println( "0=" + bit3 ); 
        //assertEquals(0, bit4);
        System.out.println( "0=" + bit4 ); 
        //assertEquals(0, bit5);
        System.out.println( "0=" + bit5 ); 
    }

    
    public static void testXor() {

        BitList list1 = new BitList("10001");
        BitList list2 = new BitList("00011");
        Iterative it = new Iterative();

        BitList list3 = it.xor(list1, list2);

        int bit1 = list3.removeFirst();
        int bit2 = list3.removeFirst();
        int bit3 = list3.removeFirst();
        int bit4 = list3.removeFirst();
        int bit5 = list3.removeFirst();

        //assertEquals(0, bit1);
        System.out.println( "0=" + bit1 ); 
        //assertEquals(1, bit2);
        System.out.println( "1=" + bit2 ); 
        //assertEquals(0, bit3);
        System.out.println( "0=" + bit3 ); 
        //assertEquals(0, bit4);
        System.out.println( "0=" + bit4 ); 
        //assertEquals(1, bit5);
        System.out.println( "1=" + bit5 ); 
    }

    public static void main(String[] args) {

        System.out.println( "testComplementSingle0" );
        testComplementSingle0();
        System.out.println(  );

        System.out.println( "testComplementSingle1" );
        testComplementSingle1();
        System.out.println(  );

        System.out.println( "testComplementMultiple" );
        testComplementMultiple();
        System.out.println(  );

        System.out.println( "testOrExceptionsNotTheSameLength" );
        testOrExceptionsNotTheSameLength();
        System.out.println(  );

        System.out.println( "testOrExceptionsEmptyEmpty" );
        testOrExceptionsEmptyEmpty();
        System.out.println(  );

        System.out.println( "testAndExceptionsNotTheSameLength" );
        testAndExceptionsNotTheSameLength();
        System.out.println(  );

        System.out.println( "testAndExceptionsEmptyEmpty" );
        testAndExceptionsEmptyEmpty();
        System.out.println(  );

        System.out.println( "testXorExceptionsNotTheSameLength" );
        testXorExceptionsNotTheSameLength();
        System.out.println(  );

        System.out.println( "testXorExceptionsEmptyEmpty" );
        testXorExceptionsEmptyEmpty();
        System.out.println(  );

        System.out.println( "testOr" );
        testOr();
        System.out.println(  );

        System.out.println( "testAnd" );
        testAnd();
        System.out.println(  );

        System.out.println( "testXor" );
        testXor();
        System.out.println(  );

    }
}