public class Dictionary implements Map<String, Integer> {

	private final static int INITIAL_CAPACITY = 10;
	private final static int INCREMENT = 5;
	private int count;

	private Pair[] elems;

	public int getCount() {
		return count;
	}

	public int getCapacity() {
		return elems.length;
	}

	public Dictionary() {
		/* Your code here */
		elems = new Pair [INITIAL_CAPACITY];
		count = 0;
	}

	@Override
	public void put(String key, Integer value) {
		/* Your code here */

		if (count >= elems.length){
			increaseCapacity();
		}
		//System.out.println("\ncount before = " + count);
		elems[count++] = new Pair (key, value);
		
		//System.out.println("\ncount after = " + count);

		/*System.out.println("Printing...");
		for (int i = 0; i < elems.length; i++) {
			System.out.println(elems[i]);
		}*/
	}

	private void increaseCapacity() {
		/* Your code here.  Use this in put() where necessary. */
		Pair [] newElems = new Pair [elems.length + INCREMENT];
		for (int i = 0; i < elems.length; i++) {
			newElems [i] = elems[i];
		}
		elems = newElems;
	}

	@Override
	public boolean contains(String key) {
		/* Your code here. */
		if (count == 0) {
			return false;
		}

		for (int i = 0; i < elems.length; i++) {
			if (elems[i] != null){
				if (elems[i].getKey().equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Integer get(String key) {
		/* Your code here. */
		if (count >= 0) {
			//System.out.println("Count = " + count);
			for (int i = count - 1; i >= 0; i--) {
				//System.out.println("i = " + i);
				if (elems[i] != null) {
					if (elems[i].getKey().equals(key)) {
						return elems[i].getValue();
					}
				}
			}
			return -1;
		}
		return -1;
	}

	@Override
	public void replace(String key, Integer value) {
		/* Your code here. */
		if (count >= 0) {
			for (int i = count - 1; i >= 0; i--) {
				if (elems[i].getKey().equals(key)) {
					elems[i].setValue(value);
				}
			}
		}

	}

	@Override
	public Integer remove(String key) {
		/* Your code here. */
		if (count >= 0) {
			int tempPos = 0;
			int tempValue = 0;
			Pair [] tempElems;

			// loop from the top to the bottom to find the matching key
			for (int i = count; i >= 0; i--) {
				if (elems[i] != null) {
					if (elems[i].getKey().equals(key)) {
						tempPos = i;
						tempValue = elems[i].getValue();
						break;
					}
				}
			}
			
			tempElems = new Pair [elems.length - 1];

			/* loop to re-size the array by storing all the values 
			except the removing value from the original array 
			to a temp array
			*/
			for (int i = 0; i < tempPos; i++) {
				tempElems[i] = elems[i];
			}

			for (int i = tempPos + 1; i < tempElems.length; i++) {
				tempElems[i - 1] = elems[i];
			}

			elems = tempElems;

			return tempValue;
		}

		return -1;
	}

	@Override
	public String toString() {
		String res;
		res = "Dictionary: {elems = [";
		for (int i = count-1; i >= 0 ; i--) {
			res += elems[i];
			if(i > 0) {
				res += ", ";
			}
		}
		return res +"]}";
	}


	//////////////////////////////////////////////////////////
	/*public static void testConstructor() {
		Dictionary ages = new Dictionary();

      //assertEquals(0, ages.getCount());
      //assertEquals(10, ages.getCapacity());
      //assertEquals(true, ages instanceof Map);

		System.out.println("0 = " + ages.getCount());
		System.out.println("10 = " + ages.getCapacity());
		System.out.println(ages instanceof Map);

	}


	public static void testGetLeftmost() {
		Dictionary ages = new Dictionary();
		ages.put("Marc", 25);
		ages.put("John", 20);
		ages.put("Marc", 15);

      //assertEquals(15, (int) ages.get("Marc"));
		System.out.println("15 = " + (int) ages.get("Marc"));

	}


	public static void testGetSingular() {
		Dictionary ages = new Dictionary();
		ages.put("Marc", 25);
		ages.put("John", 20);
		ages.put("Betty", 15);

      //assertEquals(25, (int) ages.get("Marc"));
		System.out.println("25 = " + (int) ages.get("Marc"));

	}


	public static void testContainsTrue() {
		Dictionary ages = new Dictionary();
		ages.put("Marc", 25);
		ages.put("John", 20);
		ages.put("Marc", 15);

      //assertEquals(true, ages.contains("Marc"));
		System.out.println(ages.contains("Marc"));

	}


	public static void testContainsFalse() {
		Dictionary ages = new Dictionary();
		ages.put("Marc", 25);
		ages.put("John", 20);
		ages.put("Marc", 15);

      //assertEquals(false, ages.contains("Takashi"));
		System.out.println(ages.contains("Takashi"));

	}


	public static void testPutOverCapacity() {
		Dictionary ages = new Dictionary();
		ages.put("Marc", 25);
		ages.put("John", 20);
		ages.put("Marc", 15);
		ages.put("Jack", 11);
		ages.put("Betty", 18);
		ages.put("Takashi", 30);
		ages.put("Reileen", 25);
		ages.put("Mike", 22);
		ages.put("Edward", 40);
		ages.put("Samantha", 28);
		ages.put("Gackt", 500);
		ages.put("Zeus", 9999);

      //assertEquals(15, ages.getCapacity());
		System.out.println("15 = " + ages.getCapacity());

	}


	public static void testReplaceExistsTwice() {
		Dictionary ages = new Dictionary();
		ages.put("Marc", 25);
		ages.put("John", 20);
		ages.put("Marc", 15);

		ages.replace("Marc", 16);

      //assertEquals(3, ages.getCount());
      //assertEquals(16, (int) ages.get("Marc"));
		System.out.println("3 = " + ages.getCount());
		System.out.println("16 = " + (int) ages.get("Marc"));

	}


	public static void testReplaceExistOnce() {
		Dictionary ages = new Dictionary();
		ages.put("Mary", 25);
		ages.put("John", 20);
		ages.put("Marc", 15);

		ages.replace("Mary", 28);

      //assertEquals(3, ages.getCount());
      //assertEquals(28, (int) ages.get("Mary"));
		System.out.println("3 = " + ages.getCount());
		System.out.println("28 = " + (int) ages.get("Mary"));
	}


	public static void testRemove() {
		Dictionary ages = new Dictionary();
		ages.put("Mary", 25);
		ages.put("John", 20);
		ages.put("Marc", 15);

		int ret = ages.remove("Mary");

      //assertEquals(25, ret);
      //assertEquals(2, ages.getCount());

		System.out.println("25 = " + ret);
		System.out.println("2 = " + ages.getCount());
	}

	public static void main(String[] args) {
		System.out.println("testConstructor");
		testConstructor();
		System.out.println();


		System.out.println("testGetLeftmost");
		testGetLeftmost();
		System.out.println();

		System.out.println("testGetSingular");
		testGetSingular();
		System.out.println();

		System.out.println("testContainsTrue");
		testContainsTrue();
		System.out.println();

		System.out.println("testContainsFalse");
		testContainsFalse();
		System.out.println();

		System.out.println("testPutOverCapacity");
		testPutOverCapacity();
		System.out.println();

		System.out.println("testReplaceExistsTwice");
		testReplaceExistsTwice();
		System.out.println();

		System.out.println("testReplaceExistOnce");
		testReplaceExistOnce();
		System.out.println();

		System.out.println("testRemove");
		testRemove();
		System.out.println();
	}*/



}
