package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int END_COUNTER = 2000;
	private static final int INITIAL_COUNTER = 1000;
	private static final int ONE_HUNDRED_THOUSAND = 100000;
	private static final int ONE_THOUSAND = 1000;
	

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = INITIAL_COUNTER; i < END_COUNTER; i++) {
        	arrList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> linkedList = new LinkedList<Integer>(arrList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final Integer firstElement = arrList.get(0);
        final Integer lastElement = arrList.get(arrList.size() - 1);
        arrList.set(0, lastElement);
        arrList.set(arrList.size() - 1, firstElement);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer element : arrList) {
        	System.out.println(element);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long arrListTime = System.nanoTime();
        for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
        	arrList.add(0, i);
        }
        arrListTime = System.nanoTime() - arrListTime;
        System.out.println("Inserting " + ONE_HUNDRED_THOUSAND + " elements in an ArrayList took " + arrListTime);
        
        long linkedListTime = System.nanoTime();
        for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
        	linkedList.addFirst(i);
        }
        linkedListTime = System.nanoTime() - linkedListTime;
        System.out.println("Inserting " + ONE_HUNDRED_THOUSAND + " elements in a LinkedList took " + linkedListTime);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        arrListTime = System.nanoTime();
        
        for (int i = 0; i < ONE_THOUSAND; i++) {
        	arrList.get(arrList.size() / 2);
        }
        arrListTime = System.nanoTime() - arrListTime;
        System.out.println("Get the element in the middle of an ArrayList took " + arrListTime);
        
        linkedListTime = System.nanoTime();
        for (int i = 0; i < ONE_THOUSAND; i++) {
        	linkedList.get(linkedList.size() / 2);
        }
        linkedListTime = System.nanoTime() - linkedListTime;
        
        System.out.println("Get the element in the middle of an LinkedList took " + arrListTime);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        
        Map<String,Long> populationByContinent = new HashMap<String,Long>();
        
        populationByContinent.put("Africa", 110_635_000L);
        populationByContinent.put("Americas", 972_005_000L);
        populationByContinent.put("Antarctica", 0L);
        populationByContinent.put("Asia", 4_298_723_000L);
        populationByContinent.put("Europe", 742_452_000L);
        populationByContinent.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long populationOfTheWorld = 0;
        for (Entry<String,Long> elem : populationByContinent.entrySet()) {
        	populationOfTheWorld += elem.getValue();
        }
        
        
    }
}
