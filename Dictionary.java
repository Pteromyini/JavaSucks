import java.util.Arrays;
import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private static class Pair {

        private final String key;
        private Integer value;

        private Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{key=" + key + ",value=" + value + "}";
        }
    }

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public Dictionary() {
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {

        // Add an exception check here.
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }

        if (count == elems.length) {
            increaseCapacity();
        }

        elems[count] = new Pair(key, value);
        count++;
    }

    private void increaseCapacity() {

        Pair[] copy;
        copy = new Pair[elems.length + INCREMENT];
        System.arraycopy(elems, 0, copy, 0, count);

        elems = copy;
    }

    @Override
    public boolean contains(String key) {

        // Add an exception check here.
        if (key == null) {
            throw new NullPointerException("value is null");
        }

        boolean found = false;
        int pos = count - 1;

        while (pos >= 0 && !found) {
            if (elems[pos].key.equals(key)) {
                found = true;
            } else {
                pos--;
            }
        }

        return found;
    }

    @Override
    public Integer get(String key) throws NoSuchElementException {

        // Add an exception check here.
        if (key == null) {
            throw new NullPointerException("value is null");
        }

        boolean found = false;
        int pos = count - 1;

        while (pos >= 0 && !found) {
            if (elems[pos].key.equals(key)) {
                found = true;
            } else {
                pos--;
            }
        }

        // Add an exception check here.
        if (pos < 0) {
            throw new NoSuchElementException();
        }

        return elems[pos].value;
    }

    @Override
    public void replace(String key, Integer value) throws NoSuchElementException {

        // Add an exception check here.
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }

        boolean found = false;
        int pos = count - 1;

        while (pos >= 0 && !found) {
            if (elems[pos].key.equals(key)) {
                found = true;
            } else {
                pos--;
            }
        }

        // Add an exception check here.
        if (pos < 0) {
            throw new NoSuchElementException();
        }

        elems[pos].value = value;
    }

    @Override
    public Integer remove(String key) throws NoSuchElementException {

        // Add an exception check here.
        if (key == null) {
            throw new NullPointerException("key or value is null");
        }

        boolean found = false;
        int pos = count - 1;

        while (pos >= 0 && !found) {
            if (elems[pos].key.equals(key)) {
                found = true;
            } else {
                pos--;
            }
        }

        // Add an exception check here.
        if (pos < 0) {
            throw new NoSuchElementException();
        }

        Integer saved = elems[pos].value;

        while (pos < count - 1) {
            elems[pos] = elems[pos + 1];
            pos++;
        }

        count--;

        elems[count] = null; // scrubbing

        return saved;
    }

    @Override
    public String toString() {
        Pair[] reverse;
        reverse = new Pair[count];
        for (int i = 0; i < count; i++) {
            reverse[i] = elems[count - i - 1];
        }
        return "Dictionary: {elems = " + Arrays.toString(reverse) + "}";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*public static void dictionaryPutExceptions() {
        Dictionary d = new Dictionary();

        try {
            d.put(null, 0);
            System.out.println("d.put(null, 0) was expected to throw NullPointerException");
        } catch (NullPointerException e) {
            System.out.println("part 1 works");
        }

        try {
            d.put ("hi", null);
            System.out.println("d.put (\"hi\", null) was expected to throw NullPointerException");
        } catch (NullPointerException e) {
            System.out.println("part 2 works");
        }
    }

    
    public static void dictionaryContainsExceptions() {
        Dictionary d = new Dictionary();

        try {
            d.contains(null);
            System.out.println("d.contains(null) was expected to throw NullPointerException");
        } catch (NullPointerException e) {
            System.out.println("part 1 works");
        }
    }

    
    public static void dictionaryGetExcpetions() {
        Dictionary d = new Dictionary();

        try {
            d.get(null);
            System.out.println("d.get(null) was expected to throw NullPointerException");
        } catch (NullPointerException e) {
            System.out.println("part 1 works");
        }

        try {
            d.get(" ");
            System.out.println("d.get(\" \") was expected to throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            System.out.println("part 2 works");
        }
    }

    
    public static void dictionaryReplaceExceptions() {
        Dictionary d = new Dictionary();

        try {
            d.replace(null, 0);
            System.out.println("d.replace(null, 0) was expected to throw NullPointerException");
        } catch (NullPointerException e) {
            System.out.println("part 1 works");
        }

        try {
            d.put(" ", 0);
            d.replace(" ", null);
            System.out.println("d.replace(\" \", null) was expected to throw NullPointerException");
        } catch (NullPointerException e) {
            System.out.println("part 2 works");
        }

        try {
            d.replace("item", 0);
            System.out.println("d.replace(\"item\", 0) was expected to throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            System.out.println("part 3 works");
        }
    }

    
    public static void dictionaryRemoveExceptions() {
        Dictionary d = new Dictionary();

        try {
            d.remove(null);
            System.out.println("d.remove(null) was expected to throw NullPointerException");
        } catch (NullPointerException e) {
            System.out.println("part 1 works");
        }

        try {
            d.remove(" ");
            System.out.println("d.remove(\" \") was expected to throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            System.out.println("part 2 works");
        }
    }

    public static void main(String[] args) {
        System.out.println("dictionaryPutExceptions");
        dictionaryPutExceptions();
        System.out.println();

        System.out.println("dictionaryContainsExceptions");
        dictionaryContainsExceptions();
        System.out.println();

        System.out.println("dictionaryGetExcpetions");
        dictionaryGetExcpetions();
        System.out.println();

        System.out.println("dictionaryReplaceExceptions");
        dictionaryReplaceExceptions();
        System.out.println();

        System.out.println("dictionaryRemoveExceptions");
        dictionaryRemoveExceptions();
        System.out.println();

    }*/

}
