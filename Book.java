public class Book {

    // Your variables declaration here
    private String author;
    private String title;
    private int year;

    public Book (String author, String title, int year) {
        // Your code here
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        // Your code here
        return author;
    }

    public String getTitle() {
        // Your code here
        return title;
    }

    public int getYear() {
        // Your code here
        return year;
    }

    public boolean equals(Object other) {
        // Your code here
        if ((other == null) && (this != null)){
            return false;
        }
        else if ((other != null) && (this == null)){
            return false;
        }
        else if ((other == null) && (this == null)){
            return true;
        }
        else if (! (other instanceof Book)){
            return false;
        }
        else{
            Book a = (Book) other;
            if ((this.author == a.author) && (this.title == a.title) && (this.year == a.year)){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        // Your code here
        return author + ": " + title + "(" + Integer.toString(year) + ")";   
    }




    public static void testConstructor() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);

      System.out.println("Shakespeare " + myBook.getAuthor());
      System.out.println("Hamlet " + myBook.getTitle());
      System.out.println("1600 " + myBook.getYear());
    }
    
    public static void testEqualBooks() {
      String a1 = new String("Shakespeare");
      String a2 = new String("Shakespeare");
      String t1 = new String("Hamlet");
      String t2 = new String("Hamlet");

      Book myBook = new Book(a1, t1, 1600);
      System.out.println("Basic equality, should work even with wrong reference comparison " + myBook.equals(myBook));
      Book myBook2 = new Book(a2, t2, 1600);
      System.out.println("Compared references with .equal " + myBook.equals(myBook2));
    }

    
    public static void testNotEqualBooks() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", "Macbeth", 1600);
      Book myBook3 = new Book("Shakespeare", "Hamlet", 1601);
      Book myBook4 = new Book("Shakespeared", "Hamlet", 1600);
      System.out.println("Book.equals: Different titles "  + myBook.equals(myBook2));
      System.out.println("Book.equals: Different dates " + myBook.equals(myBook3));
      System.out.println("Book.equals: Different authors " + myBook.equals(myBook4));
    }

    
    public static void testNotEqualNullBooks() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      System.out.println("Book.equals: null parameter "+ myBook.equals(null));
    }

    
    public static void testNotEqualNullAuthor() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book(null, "Macbeth", 1600);
      System.out.println("Book.equals: null author parameter "+ myBook.equals(myBook2));
      System.out.println("Book.equals: null author instance "+ myBook2.equals(myBook));
    }

    
    public static void testEqualNullAuthor() {
      Book myBook = new Book(null, "Macbeth", 1600);
      Book myBook2 = new Book(null, "Macbeth", 1600);
      System.out.println("Book.equals: both null authors "+ myBook.equals(myBook2));
    }

    
    public static void testNotEqualNullTitle() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", null, 1600);
      System.out.println("Book.equals: null title parameter "+ myBook.equals(myBook2));
      System.out.println("Book.equals: null title instance "+ myBook2.equals(myBook));
    }

    
    public static void testEqualNullTitle() {
      Book myBook = new Book("Shakespeare", null, 1600);
      Book myBook2 = new Book("Shakespeare", null, 1600);
      System.out.println("Book.equals: both null title "+ myBook.equals(myBook2));
    }

    
    public static void testEqualWrongType() {
      Book myBook = new Book("Shakespeare", null, 1600);
      Integer myInt = Integer.valueOf(5);
      System.out.println("Book.equals: called with Integer "+ myBook.equals(myInt));
    }

    
    public static void testEqualNotOveritten() {
      Book myBook = new Book("Shakespeare", null, 1600);
      Book myBook2 = new Book("Shakespeare", null, 1600);
      System.out.println("Book.equals: method was overloaded and not overwritten "+ myBook.equals((Object)myBook2));
    }

    public static void main(String[] args) {
        
        System.out.println();
        System.out.println("testConstructor");
        testConstructor();
        
        System.out.println();
        System.out.println("testEqualBooks");
        testEqualBooks();
        
        System.out.println();
        System.out.println("testNotEqualBooks");
        testNotEqualBooks();
        
        System.out.println();
        System.out.println("testNotEqualNullBooks");
        testNotEqualNullBooks();
        
        System.out.println();
        System.out.println("testNotEqualNullAuthor");
        testNotEqualNullAuthor();
        
        System.out.println();
        System.out.println("testEqualNullAuthor");
        testEqualNullAuthor();
        
        System.out.println();
        System.out.println("testNotEqualNullTitle");
        testNotEqualNullTitle();
        
        System.out.println();
        System.out.println("testEqualNullTitle");
        testEqualNullTitle();
        
        System.out.println();
        System.out.println("testEqualWrongType");
        testEqualWrongType();

        System.out.println();
        System.out.println("testEqualNotOveritten");
        testEqualNotOveritten();
        
    }

    /*public static void main(String[] args) {

        Book b1 = new Book("D. Knuth", "TAOCP", 1970);
        Book b2 = new Book("D. Knuth", "TAOCP", 1971);
        Book b3 = new Book("D. IAmNotKnuth", "TAOCP", 1970);
        Book b4 = new Book("D. Knuth", "TAOCP v2", 1970);
        Book b5 = new Book("D. Knuth", "TAOCP", 1970);

        System.out.println(b1 + " equals " + b2 + ": " + b1.equals(b2));
        System.out.println(b1 + " equals " + b3 + ": " + b1.equals(b3));
        System.out.println(b1 + " equals " + b4 + ": " + b1.equals(b4));
        System.out.println(b1 + " equals " + b5 + ": " + b1.equals(b5));

        Book b6 = new Book(null, "TAOCP", 1971);
        Book b7 = new Book("D. IAmNotKnuth", null, 1970);

        System.out.println(b1 + " equals " + b6 + ": " + b1.equals(b6));
        System.out.println(b1 + " equals " + b7 + ": " + b1.equals(b7));
        System.out.println(b1 + " equals " + null + ": " + b1.equals(null));
        System.out.println(b6 + " equals " + b1 + ": " + b6.equals(b1));
        System.out.println(b7 + " equals " + b1 + ": " + b7.equals(b1));
        System.out.println(b6 + " equals " + b6 + ": " + b6.equals(b6));
        System.out.println(b7 + " equals " + b7 + ": " + b7.equals(b7));
    }*/
}
