import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Albert-Kenneth Okine
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    mergeSort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>)

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Merge and sort the upper and lower bounds, according to the
   * comparator given.
   */
  private static <T> void mergeSort(T[] values, int lb, int ub,
    Comparator<? super T> order)
  {
    // Find the midpoint between the upper and lower bounds.
    int mid = lb + (ub - lb) / 2;
    
    // Check if the array can be split into halves and sorted
    if (mid > lb) {
      // Recursively merge sort the two halves of the list
      mergeSort(values, lb, mid, order);
      mergeSort(values, mid, ub, order);
    } // if (there are two or more elements)

    // Merge the two halves together
    merge(values, lb, mid, ub, order);
  } // mergeSort(T[], int, int, Comaparator<? super T>)
  
  /**
   * Merge the values from positions [lo...mid) and [mid...hi) back
   * into the same part of the array.
   * 
   * Preconditions: Each subarray is sorted according to comparator.
   */
  private static <T> void merge(T[] values, int lo, int mid, int hi, 
    Comparator<? super T> comparator)
  {
    // Create a temporary array to merge into.
    T[] newArr = Arrays.copyOfRange(values, lo, hi);
    // Keep track of the current array index.
    int index = 0, i = lo, j = mid;

    // Iteratively merge the minimum element in both subarrays.
    while ((i < mid) && (j < hi)) {
      newArr[index++] = (comparator.compare(values[i], values[j]) < 0)
        ? values[i++]
        : values[j++];
    } // while (there are elements left in both subarrays)

    // Copy the remaining elements into the temporary array.
    //  note: only one loop will execute.
    for (int k = i; k < mid; k ++) newArr[index++] = values[k];
    for (int k = j; k < hi; k ++) newArr[index++] = values[k];

    // Copy the elements of the temp array back into the original.
    for (int k = lo; k < hi; k ++) values[k] = newArr[k - lo];
  } // merge(T[], int, int, int, Comparator<? super T>)

} // class MergeSort