public static void testConstructor() {
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

}
