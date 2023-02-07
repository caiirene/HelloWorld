/**
 * THIS IS A STRUCTURE OF LINKED LIST
 */
public interface IListOfInts {

  /**
   * !!!AFTER ADD A NEW DATA, OBJECT KEPT THE SAME.
   * @param data
   * @param index
   * @return this object itself
   */
  IListOfInts addAtIndex(int data, int index);

  /**
   * add a data at front
   * @param data
   * @return itself
   */
  IListOfInts addFront(int data);

  /**
   * add a data at back
   * @param data
   * @return itself
   */
  IListOfInts addBack(int data);

  /**
   * get a data at index
   * @param index
   * @return int data
   */
  int getDataAtIndex(int index);

  /**
   * count how many normal node, empty node count as 0
   * @return int
   */
  int count();

  /**
   * add all data together
   * @return int
   */
  int sum();

}
