public interface IListOfInts {

  /**
   * make a new linked list
   * @param data
   * @param index
   * @return
   */
  IListOfInts addAtIndex(int data, int index);

  IListOfInts addFront(int data);

  IListOfInts addBack(int data);

  int getDataAtIndex(int index);

  int count();

  int sum();

}
