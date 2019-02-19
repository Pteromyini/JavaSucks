import java.util.ArrayList;
import java.util.Collections; 

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();

    public Book getBook(int i) {
      return library.get(i);
  }

  public int getSize() {
      return library.size();
  }

  public void addBook (Book b) {
        // Your code here
    library.add(b);
}

    // This method sorts the library starting from author, title, then year
public void sort() {

        // Your code here

    //System.out.println();
    //System.out.println("running sorting algorithm");
    Collections.sort(library, new BookComparator());
    //System.out.println();
    //System.out.println("done sorting");

}


public void printLibrary() {
        // Your code here
    System.out.println(library);
}

public static void testAddBook() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook);

      System.out.println(myBook + "=" + myLibrary.getBook(0));     
    }


    
    public static void testSortByAuthor() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Ienaga", "The Pacific War", 1968);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook);
      myLibrary.addBook(myBook2);
      myLibrary.sort();

      System.out.println(myBook2 + "=" + myLibrary.getBook(0));
      System.out.println(myBook + "=" + myLibrary.getBook(1));
    }

    
    public static void testSortByAuthor2() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Ienaga", "The Pacific War", 1968);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook2);
      myLibrary.addBook(myBook);
      myLibrary.sort();

      System.out.println(myBook2 + "=" + myLibrary.getBook(0));
      System.out.println(myBook + "=" + myLibrary.getBook(1));
    }

    
    public static void testSortByTitle() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", "A Midsummer Night's Dream", 1600);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook);
      myLibrary.addBook(myBook2);
      myLibrary.sort();

      System.out.println(myBook2 + "=" + myLibrary.getBook(0));
      System.out.println(myBook + "=" + myLibrary.getBook(1));
    }

    
    public static void testSortByTitle2() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", "A Midsummer Night's Dream", 1600);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook2);
      myLibrary.addBook(myBook);
      myLibrary.sort();

      System.out.println(myBook2 + "=" + myLibrary.getBook(0));
      System.out.println(myBook + "=" + myLibrary.getBook(1));    
    }
    
    public static void testSortByYear() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", "Hamlet", 1599);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook);
      myLibrary.addBook(myBook2);
      myLibrary.sort();

      System.out.println(myBook2 + "=" + myLibrary.getBook(0));
      System.out.println(myBook + "=" + myLibrary.getBook(1));      
    }

    
    public static void testSortFiveBooks() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", "A Midsummer Night's Dream", 1600);
      Book myBook3 = new Book("Shakespeare", "Hamlet", 1599);
      Book myBook4 = new Book("Ienaga", "The Pacific War", 1968);
      Book myBook5 = new Book("Coutu", "Le québécois en 10 leçons", 2014);

      Library myLibrary = new Library();
      myLibrary.addBook(myBook);
      myLibrary.addBook(myBook2);
      myLibrary.addBook(myBook3);
      myLibrary.addBook(myBook4);
      myLibrary.addBook(myBook5);
      myLibrary.sort();

      System.out.println(myBook5 + "=" + myLibrary.getBook(0));
      System.out.println(myBook4 + "=" + myLibrary.getBook(1));
      System.out.println(myBook2 + "=" + myLibrary.getBook(2));
      System.out.println(myBook3 + "=" + myLibrary.getBook(3));
      System.out.println(myBook + "=" + myLibrary.getBook(4));
    }


    public static void main(String[] args) {

        System.out.println();
        System.out.println("testAddBook");
        testAddBook();

        System.out.println();
        System.out.println("testSortByAuthor");
        testSortByAuthor();
        
        System.out.println();
        System.out.println("testSortByAuthor2");
        testSortByAuthor2();
        
        System.out.println();
        System.out.println("testSortByTitle");
        testSortByTitle();
        
        System.out.println();
        System.out.println("testSortByTitle2");
        testSortByTitle2();
        
        System.out.println();
        System.out.println("testSortByYear");
        testSortByYear();
        
        System.out.println();
        System.out.println("testSortFiveBooks");
        testSortFiveBooks();
    }

}

    