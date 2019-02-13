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

}
