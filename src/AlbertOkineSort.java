import java.io.UncheckedIOException;
import java.util.Comparator;
import java.util.Arrays;

import java.util.Random;

/**
 * Sort using AlbertOkineSort.
 *
 * @author Albert-Kenneth Okine
 */

public class AlbertOkineSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new AlbertOkineSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  AlbertOkineSort() {
  } // AlbertOkineSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    randomSort(values, order);
  } // sort(T[], Comparator<? super T>)
  
  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+
  
  /**
   * An extremely fast sorter.
   */
  private static <T> void randomSort(T[] values,
    Comparator<? super T> order)
  {
    if (sorted(values, order)) {
      // Oh my goodness it actually worked bahahahahahahahahahahaha
    } else {  
      // Randomly shuffle the array.
      shuffle(values);
      randomSort(values, order);
    }
  } // randomSort(T[], Comparator<? super T>)

  /**
   * Determine if the array is sorted.
   */
  private static <T> boolean sorted(T[] values,
    Comparator<? super T> compare)
  { // Iterate throughout the array.
    for (int i = 0; i < values.length - 1; i ++) {
      if (compare.compare(values[i], values[i + 1]) > 0)
        return false;
    } // for (each element in the array)
    return true; // all elements satisfy the comparator.
  } // sorted(T[], Comparator<? super T>)

  /** 
   * Randomly shuffle the array.
   */
  private static <T> void shuffle(T[] values) {
    // Construct a new Random object.
    Random rand = new Random();

    // Iterativelly swap random indices in the array.
    for (int i = 0; i < values.length/2; i ++) {
      // Swap the random index and the current index.
      swap(values, i, rand.nextInt(values.length));
    } // for (each element in the array)
  } // shuffle(T[])

  /** 
   * Swap the given elements in the array.
   */
  private static <T> void swap(T[] values, int a, int b) {
    T temp = values[a];     // Temporily store the value at a
    values[a] = values[b];  // Store the value of b in a
    values[b] = temp;       // Store the value of a in b
  } // swap(T[], int, int)

} // class AlbertOkineSort
