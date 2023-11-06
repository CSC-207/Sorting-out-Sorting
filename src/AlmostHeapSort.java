import java.io.UncheckedIOException;
import java.util.Comparator;

import java.util.Collections;

/**
 * Sort using AlmostHeapSort.
 *
 * @author Albert-Kenneth Okine
 */
public class AlmostHeapSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new AlmostHeapSort();

  /** 
   * The root of the heap.
   */
  private static Node root;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  AlmostHeapSort() {
  } // AlmostHeapSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // Make the heap and keep track of the root node.
    this.root = heapify(values, 0, values.length, 0);
    maxHeapify(root, order);

  } // sort(T[], Comparator<? super T>)

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /** Node of a doubly-linked list. */
  public static class Node {
    /** The data stored in this node. */
    Object data;
    /** Pointer to the node on the left. */
    Node left;
    /** Pointer to the node on the right. */
    Node right;
    
    /** Construct a new node  */
    public <T> Node(T data) {
      this.data = data;
      // Initialize the left and right nodes to null.
      this.left = this.right = null;
    } // Node()

    
    public String toString(int level) {
      String spa = "    ".repeat(level);
      return String.format("%d: %s\n%d: %s%s\n%d: %s%s",
        level, this.data, level + 1, spa,
        (this.left != null) ? this.left.toString(level + 1) : "", 
        level + 1, spa,
        (this.right != null) ? this.right.toString(level + 1) : "");
    } // toString()

  } // class Node

  /**
   * Convert the array into a heap data structure.
   */
  private static <T> Node heapify(T[] values, int lb, int ub, 
    int rootIndex)
  { // Make a new root from the given root index.
    Node newRoot = new Node(values[rootIndex]);

    // Find the left and right values of the new root.
    if ((2 * rootIndex + 1) < values.length)
      newRoot.left = heapify(values, lb, ub, (2 * rootIndex + 1));
    if ((2 * rootIndex + 2) < values.length)
      newRoot.right = heapify(values, lb, ub, (2 * rootIndex + 2));

    return newRoot; // Return the root, now initialized.
  } // heapify(T[], int, int, int)

  @SuppressWarnings({ "unchecked" })
  private static <T> void maxHeapify(Node root,
    Comparator<? super T> compare)
  {
    if (root.left != null) {
      // Check if the current node is less than the node to the left.
      if (compare.compare((T) root.data, (T) root.left.data) < 0)
        swap(root, root.left);
      // maxHeapify the nodes to the left of the root.
      maxHeapify(root.left, compare);
    } if (root.right != null) {
      // Check if the current node is less than the node to the right.
      if (compare.compare((T) root.data, (T) root.right.data) < 0)
        swap(root, root.right);
      // maxHeapify the nodes to the right of the root.
      maxHeapify(root.right, compare);
    } // if...else
  } // maxHeapify(Node, Comparator<? super T>)
    
    
    
    
    
  //   for (int i = 0; i < Math.log(values.length) / Math.log(2); i ++) {
  //     int offset = 2 * i;
  //     if ((offset + 1 < values.length) && 
  //        (comparator.compare(values[i], values[offset + 1]) < 0)) {
  //       swap(values, i, offset);
  //     } if ((offset + 2 < values.length) && 
  //          (comparator.compare(values[i], values[offset + 2]) < 0)) {
  //       swap(values, i, offset + 1);
  //     }
  //   }
  // } // heapify(T[], int, int, Comparator<? super T>)

  public static <T> T heapSort(T[] values, int lb, int ub,
    Comparator<? super T> order) {


    values[ub] = heapSort(values, lb, ub, order);
    return values[ub];
  } // heapSort

  /** 
   * Swap the given elements in the array.
   */
  private static <T> void swap(T[] values, int a, int b) {
    T temp = values[a];     // Temporily store the value at a
    values[a] = values[b];  // Store the value of b in a
    values[b] = temp;       // Store the value of a in b
  } // swap(T[], int, int)

  /** 
   * Swap the two nodes given.
   * 
   * Note: node a is guaranteed to be the parent of node b.
   */
  private static void swap(Node a, Node b) {
    Node temp = a;    // Temporily store the value at a
    a = b;            // Store the value of b in a
    b = temp;         // Store the value of a in b
  } // swap(Node, Node)

  public static <T> void main(String[] args) {
    Integer[] arr = new Integer[] {3, 1, 5, 2};
    
    // AlmostHeapSort.heapify(arr, 0, 5, (x, y) -> x.compareTo(y));

    // for (Integer i : arr) System.out.printf("%d ", i);



    root = heapify(arr, 0, arr.length, 0);
    System.out.println(root.toString(0));

    maxHeapify(root, (x, y) -> ((Integer) x).compareTo((Integer) y));

    System.out.println("1: " + ((Integer) root.data).compareTo((Integer) root.left.data));

    System.out.println(root.toString(0));

    swap(root, root.left);
    System.out.println(root.toString(0));


    // swap(arr, 0, 1);

    // Integer[] values = new Integer[] {1, 2, 3, 4};

    // for (Integer i : values) System.out.printf("%d ", i);

    // Integer a = values[0];
    // Integer b = values[1];

    // Integer temp = a;     // Temporily store the value at a
    // a = b;  // Store the value of b in a
    // b = temp; 

    // for (Integer i : values) System.out.printf("%d ", i);
  } // main



} // class AlmostHeapSort
