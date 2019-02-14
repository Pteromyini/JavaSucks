/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

  private Post[] messages;
  private int size;
  public static final int MAX_SIZE = 25;

  public NewsFeed() {
    	// Your code here.
    messages = new Post[MAX_SIZE];
    size = 0;
  }

  public void add(Post message) {
      // Your code here.
    messages[size] = message;
    size ++;
  }

  public Post get(int index) {
    return messages[index];
  }

  public int size() {
    return size;
  }

  public void sort(){
   int i, j, argMin;
   Post tmp;
   for (i = 0; i < size - 1; i++) {
    argMin = i;
    for (j = i + 1; j < size(); j++) {
     if (messages[j].compareTo(messages[argMin]) < 0) {
      argMin = j;
    }
  }

  tmp = messages[argMin];
  messages[argMin] = messages[i];
  messages[i] = tmp;
}

}

public NewsFeed getPhotoPost(){
  		// Your code here
  NewsFeed myNews = new NewsFeed();

  for (int i = 0; i < 25; i++){
        //PhotoPost newPP = new PhotoPost();
    myNews.add(messages[i]);
  }

  return myNews; 
}

public NewsFeed plus(NewsFeed other){

  	  // Your code here
  NewsFeed myNews = new NewsFeed();

  for (int pos = 0; pos < other.size(); pos++){
    myNews.add (other.messages[pos]);
  }

  for (int pos = myNews.size(); pos < 25; pos++){
    myNews.add(this.messages[pos]);
  }

  myNews.sort();

  return myNews;
}

    ///////////////////////////////////////////////////////////
public static void TestAddFirstPost() {

  System.out.println();
  System.out.println("TestAddFirstPost");

  NewsFeed feed = new NewsFeed();
  Post myPost = new Post("Hi");
  feed.add(myPost);
  System.out.println("1 " + feed.size());
  System.out.println("Hi " + feed.get(0));
}


public static void TestAdd25Posts() {

  System.out.println();
  System.out.println("TestAdd25Posts");

  NewsFeed feed = new NewsFeed();
  Post myPost = new Post("Hi");
  for (int i = 0; i < 25; i++) {
    feed.add(myPost);
  }

  System.out.println("25 " + feed.size());

}

public static void TestGetPhotoPostEmpty() {

  System.out.println();
  System.out.println("TestGetPhotoPostEmpty");

  NewsFeed feed = new NewsFeed();
  NewsFeed feed2 = feed.getPhotoPost();
  System.out.println("0 " + feed2.size());

}


public static void TestGetPhotoPostBlank() {

  System.out.println();
  System.out.println("TestGetPhotoPostBlank");

  NewsFeed feed = new NewsFeed();
  Post myPost = new Post("Hi");
  for (int i = 0; i < 25; i++) {
    feed.add(myPost);
  }
  NewsFeed feed2 = feed.getPhotoPost();
  System.out.println("0 " + feed2.size());

}


public static void TestGetPhotoPostSome() {

  System.out.println();
  System.out.println("TestGetPhotoPostSome");

  NewsFeed feed = new NewsFeed();
  Post myPost = new Post("Hi");
  Post myPhotoPost = new PhotoPost("Hi", "hi.png", "Hi");
  feed.add(myPhotoPost);
  for (int i = 0; i < 10; i++) {
    feed.add(myPost);
  }

  feed.add(myPhotoPost);
  feed.add(myPost);
  feed.add(myPhotoPost);
  NewsFeed feed2 = feed.getPhotoPost();
  System.out.println("3 " + feed2.size());

}


public static void TestAddEmptyFeedToEmptyFeed () {

  System.out.println();
  System.out.println("TestAddEmptyFeedToEmptyFeed");

  NewsFeed feed = new NewsFeed();
  NewsFeed feed2 = new NewsFeed();
  NewsFeed feed3 = feed.plus(feed2);
  System.out.println("0 "  + feed3.size());

}


public static void TestAddSingletonFeedToSelf () {

  System.out.println();
  System.out.println("TestAddSingletonFeedToSelf");

  NewsFeed feed = new NewsFeed();
  Post myPost = new Post("Hi");
  feed.add(myPost);
  NewsFeed feed2 = feed.plus(feed);
  System.out.println("2 " + feed2.size());

}


public static void TestAddFeedSorted() {

  System.out.println();
  System.out.println("TestAddFeedSorted");

  NewsFeed feed = new NewsFeed();
  Post myPostSorted = new Post("Sorted");
  NewsFeed feed2 = new NewsFeed();
  Post myPostUnsorted = new Post ("Unsorted");
  feed.add(myPostSorted);
  feed2.add(myPostUnsorted);
  NewsFeed feed3 = feed2.plus(feed);
  System.out.println("Sorted " + feed.get(0));

}


public static void TestAddFeedAtCapacity() {

  System.out.println();
  System.out.println("TestAddFeedAtCapacity");

  NewsFeed feed = new NewsFeed();
  Post myPost = new Post("Hi");
  for (int i = 0; i < 10; i++) {
    feed.add(myPost);
  }
  NewsFeed feed2 = new NewsFeed();
  Post myPost2 = new Post("HO");
  for (int i = 0; i < 15; i++) {
    feed2.add(myPost2);
  }
  NewsFeed feed3 = feed.plus(feed2);
  System.out.println("25 " + feed3.size());

}

public static void main(String[] args) {

  TestAddFirstPost();
  TestAdd25Posts();
  TestGetPhotoPostEmpty();
  TestGetPhotoPostBlank();
  TestGetPhotoPostSome();
  TestAddEmptyFeedToEmptyFeed();
  TestAddSingletonFeedToSelf();
  TestAddFeedSorted();
  TestAddFeedAtCapacity();

}

}
