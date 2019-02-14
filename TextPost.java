public class TextPost extends Post {

  private String message;

  public TextPost(String userName, String message) {
      // Your code here.
    super(userName);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public String toString() {
   String str = new String();
   str = super.toString() + ", " + message;
   return  str;
 }

 public boolean isPopular() {
  		// Your code here.
  return super.getLikes() > 50;
}

/*public static void testConstructor() {

  System.out.println();
  System.out.println("testConstructor");

  TextPost myPost = new TextPost("username", "hello world");

  System.out.println("username " + myPost.getUserName());
  System.out.println("hello world " + myPost.getMessage());
}


public static void testNotPopularTextPost() {
  System.out.println();
  System.out.println("testNotPopularTextPost");

  TextPost myPost = new TextPost("username", "hello world");

  System.out.println(myPost.isPopular());

  for (int i = 0; i < 49; i++) {
    myPost.like();
  }

  System.out.println(myPost.isPopular());
}


public static void testPopularTextPost() {

  System.out.println();
  System.out.println("testPopularTextPost");

  TextPost myPost = new TextPost("username", "hello world");

  for (int i = 0; i < 51; i++) {
    myPost.like();
  }

  System.out.println(myPost.isPopular());
  myPost.like();
  System.out.println(myPost.isPopular());

}

public static void main(String[] args) {

  testConstructor();
  testNotPopularTextPost();
  testPopularTextPost();
}*/

}
