import java.util.Calendar;
import java.util.Date;

public class Post implements Likeable, Comparable<Post> {

  protected int likes;
  private Date timeStamp;
  private String userName;

  public Post(String userName) {
      // Your code here
    likes = 0;
    timeStamp = Calendar.getInstance().getTime();
    this.userName = userName;
  }

  public int getLikes(){
    return likes;
  }

  public String getUserName() {
    return userName;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

    // Implement the methods required by the interface Likeable.
    // This file will not compile unless they are present with the correct name and signature.

  public String toString() {
   String str = new String();
   str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
   return  str;
 }


 public int compareTo(Post other){
  		// Your code here.
  /*System.out.println();
  System.out.println("inside method");
  System.out.println("this " + this.timeStamp);
  System.out.println("other " + other.timeStamp);

  System.out.println("compareTo " + this.timeStamp.compareTo(other.timeStamp));*/

  return this.timeStamp.compareTo(other.timeStamp);
}

public boolean isPopular(){
  		// Your code here.
  return likes > 100;
}

public void like(){
  likes++;
}

/*public static void testConstructor() {
  Post myPost = new Post("username");

  System.out.println();
  System.out.println("testConstructor");
  System.out.println("username " + myPost.getUserName());
  System.out.println("0 " + myPost.getLikes());
}

public static void testLikes() {
  Post myPost = new Post("username");
  for (int i = 0; i < 10; i++) {
    myPost.like();
  }

  System.out.println();
  System.out.println("testLikes");
  System.out.println("10 " + myPost.getLikes());
}

public static void testCompareSamePost() {
  Post myPost = new Post("username");

  System.out.println();
  System.out.println("testCompareSamePost");
  
  System.out.println("0 " + myPost.compareTo(myPost));
}

public static void testCompareDifferentPost() {
  System.out.println();
  System.out.println("testCompareDifferentPost");

  Post myPost = new Post("username");
  System.out.println("mine " + myPost.getTimeStamp());
  
  Post yourPost = new Post("username2");
  System.out.println("yours " + yourPost.getTimeStamp());

  System.out.println(myPost.compareTo(yourPost) < 0);
  System.out.println(yourPost.compareTo(myPost) > 0);
}

public static void main(String[] args) {
  testConstructor();
  testLikes();
  testCompareSamePost();
  testCompareDifferentPost();
}*/

}
