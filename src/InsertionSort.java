import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Albert-Kenneth Okine
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // Iteratively sort the elements in the array
    for (int i = 0; i < values.length; i ++) { // Insert the least element
      int least = i;
      for (int j = i; j < values.length; j ++) { // Find the least element
        least = (order.compare(values[j], values[least]) < 0) ? j : least;
      } // for (the remaining elements in the array)
      // Swap the values of the least element and the current index.
      swap(values, i, least);
    } // for (each index in the array)
  } // sort(T[], Comparator<? super T>

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /** 
   * Swap the given elements in the array.
   */
  private static <T> void swap(T[] values, int a, int b) {
    T temp = values[a];     // Temporily store the value at a
    values[a] = values[b];  // Store the value of b in a
    values[b] = temp;       // Store the value of a in b
  } // swap(T[], int, int)

} // class InsertionSort