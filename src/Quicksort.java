import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Albert-Kenneth Okine
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quickSort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+
  
  /**
   * Select a pivot and partition the subarray from [lb .. ub) into 
   * the following form.
   * 
   * <pre> 
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  private static <T> int partition(T[] arr,
    Comparator<? super T> compare, int lb, int ub)
  { // Select the pivot, then swap it to the front of the array.
    int median = ((ub - lb) / 2) + lb;
    swap(arr, lb, median);

    // Define our iterative variables.
    int small = lb + 1, large = ub - 1;
    // Iterate through all values between upper and lower bounds.
    while (small <= large) {
      // Check if the element is smaller than the pivot
      if (compare.compare(arr[small], arr[lb]) < 0) {
        small++;                          // Increment small.
      } else swap(arr, small, large--);   // Decrement large.
    } // while (there are unproccessed elements remaining)

    // Move the pivot into the correct location.
    swap(arr, lb, large);

    // return the final index of the pivot.
    return large;
  } // partition(T[], Comparator<? super T>, int, int)

  /**
   * Recursively partition and sort the left and right halves
   * of the given array from [lb...ub).
   */
  private static <T> void quickSort(T[] values, int lb, int ub,
    Comparator<? super T> order)
  { // Check that the subarray can be partioned and sorted.
    if (ub - lb > 1) {
      // Partition the array, then find the location of the pivot.
      int pivotLoc = partition(values, order, lb, ub);
      
      // Quick sort the remaining halves.
      quickSort(values, lb, pivotLoc, order);
      quickSort(values, pivotLoc + 1, ub, order);
    } // if (there are more than 2 elements in the subarray)
  } // quickSort(T[], int, int)

  /** 
   * Swap the given elements in the array.
   */
  private static <T> void swap(T[] values, int a, int b) {
    T temp = values[a];     // Temporarily store the value at a.
    values[a] = values[b];  // Store the value of b in a.
    values[b] = temp;       // Store the value of a in b.
  } // swap(T[], int, int)

} // class Quicksort