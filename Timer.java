public class Timer {
	private int hours;
	private int minutes;
	private int seconds;

	public Timer(){
		hours = 0;
		minutes = 0;
		seconds = 0;
	}

	public void incrementHours(){
		// Your code here.
		if (hours == 23) {
			hours = 0;
		}
		else {
			hours++;
		}
	}

	public void decrementHours(){
		// Your code here.
		if (hours > 0) {
			hours--;
		}
	}

	public int getHours(){
		return hours;
	}

	public void incrementMinutes(){
		// Your code here.
		if (minutes == 59) {
			minutes = 0;
			incrementHours();
		}
		else {
			minutes++;
		}
	}
	public void decrementMinutes(){
		// Your code here.
		if (minutes > 0) {
			minutes--;
		}
	}

	public int getMinutes() {
		return minutes;
	}

	public void incrementSeconds(){
		// Your code here.
		if (seconds == 59) {
			incrementMinutes();
		}
		else {
			seconds++;
		}
	}

	public void decrementSeconds(){
		// Your code here.
		if (seconds > 0) {
			seconds--;
		}
	}
	
	public int getSeconds(){
		return seconds;
	}

	public String toString () {
		return "Timer "+hours+":"+minutes+":"+seconds;
	}

	////////////////////////////////////////////////////
	public static void modelIncrementHours() {
		Timer timer = new Timer();

		for (int i = 0; i < 5; i++) {
			timer.incrementHours();
		}

      //assertEquals(5, timer.getHours());
		System.out.println("5 = " + timer.getHours());

		for (int i = 0; i < 19; i++) {
			timer.incrementHours();
		}

      //assertEquals(0, timer.getHours());
		System.out.println("0 = " + timer.getHours());

	}


	public static void modelDecrementHours() {
		Timer timer = new Timer();

		for (int i = 0; i < 5; i++) {
			timer.decrementHours();
		}

      //assertEquals(19, timer.getHours());
		System.out.println("19 = " + timer.getHours());


		for (int i = 0; i < 19; i++) {
			timer.decrementHours();
		}

      //assertEquals(0, timer.getHours());
		System.out.println("0 = " + timer.getHours());

	}


	public static void modelIncrementMinutes() {
		Timer timer = new Timer();

		for (int i = 0; i < 5; i++) {
			timer.incrementMinutes();
		}

      //assertEquals(5, timer.getMinutes());
		System.out.println("5 = " + timer.getMinutes());


		for (int i = 0; i < 55; i++) {
			timer.incrementMinutes();
		}

      //assertEquals(0, timer.getMinutes());

		System.out.println("0 = " + timer.getMinutes());

      //assertEquals(1, timer.getHours());
		
		System.out.println("1 = " + timer.getHours());

	}


	public static void modelDecrementMinutes() {
		Timer timer = new Timer();

		for (int i = 0; i < 5; i++) {
			timer.decrementMinutes();
		}

      //assertEquals(55, timer.getMinutes());

		System.out.println("55 = " + timer.getMinutes());

      //assertEquals(23, timer.getHours());	

		System.out.println("23 = " + timer.getHours());


		for (int i = 0; i < 55; i++) {
			timer.decrementMinutes();
		}

      //assertEquals(0, timer.getMinutes());
		System.out.println("0 = " + timer.getMinutes());

	}


	public static void modelIncrementSeconds() {
		Timer timer = new Timer();

		for (int i = 0; i < 5; i++) {
			timer.incrementSeconds();
		}

      //assertEquals(5, timer.getSeconds());
		System.out.println("5 = " + timer.getSeconds());


		for (int i = 0; i < 55; i++) {
			timer.incrementSeconds();
		}

      //assertEquals(0, timer.getSeconds());
		System.out.println("0 = " + timer.getSeconds());

      //assertEquals(1, timer.getMinutes());

		System.out.println("1 = " + timer.getMinutes());

	}


	public static void modelDecrementSeconds() {
		Timer timer = new Timer();

		for (int i = 0; i < 5; i++) {
			timer.decrementSeconds();
		}

      //assertEquals(55, timer.getSeconds());
		System.out.println("55 = " + timer.getSeconds());

      //assertEquals(59, timer.getMinutes());
		System.out.println("59 = " + timer.getMinutes());


		for (int i = 0; i < 55; i++) {
			timer.decrementSeconds();
		}

      //assertEquals(0, timer.getSeconds());
		System.out.println("0 = " + timer.getSeconds());

	}


	public static void main(String[] args) {

		System.out.println("modelIncrementHours");
		modelIncrementHours();
		System.out.println();

		System.out.println("modelDecrementHours");
		modelDecrementHours();
		System.out.println();

		System.out.println("modelIncrementMinutes");
		modelIncrementMinutes();
		System.out.println();

		System.out.println("modelDecrementMinutes");
		modelDecrementMinutes();
		System.out.println();

		System.out.println("modelIncrementSeconds");
		modelIncrementSeconds();
		System.out.println();

		System.out.println("modelDecrementSeconds");
		modelDecrementSeconds();
		System.out.println();

	}
}
