public class PhotoPost extends Post {

    private String fileName;
    private String caption;

    public PhotoPost(String userName, String fileName, String caption) {
      // Your code here.
        super(userName);
        this.fileName = fileName;
        this.caption = caption;
    }

    public String getCaption() {
      return caption;
  }

  public String getFileName() {
      return fileName;
  }

  public String toString() {
   String str = new String();
   str = super.toString() + ", " + fileName + ", " + caption;
   return str;
}

/*public static void testConstructor() {

    System.out.println();
    System.out.println("testConstructor");

    PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");

    System.out.println("username " + myPost.getUserName());
    System.out.println("hello world " + myPost.getCaption());
    System.out.println("hello.jpg " + myPost.getFileName());

}

public static void testNotPopularPhotoPost() {

    System.out.println();
    System.out.println("testNotPopularPhotoPost");

    PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
    System.out.println(myPost.isPopular());

    for (int i = 0; i < 99; i++) {
        myPost.like();
    }
    System.out.println(myPost.isPopular());

}

public static void testPopularTextPost() {

    System.out.println();
    System.out.println("testPopularTextPost");

    PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");

    for (int i = 0; i < 101; i++) {
        myPost.like();
    }
    System.out.println(myPost.isPopular());
    myPost.like();
    System.out.println(myPost.isPopular());

}

public static void main(String[] args) {

    testConstructor();
    testNotPopularPhotoPost();
    testPopularTextPost();

}*/

}
