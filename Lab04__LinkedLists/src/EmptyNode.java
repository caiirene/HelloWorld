public class EmptyNode implements IListOfInts {

  private int nothing;

  @Override
  public IListOfInts addAtIndex(int data, int index) {
    return new NommalNode(data, this);
  }

  @Override
  public IListOfInts addFront(int data) {
    return new NommalNode(data, this);
  }

  @Override
  public IListOfInts addBack(int data) {
    return new NommalNode(data, this);
  }

  @Override
  public int getDataAtIndex(int index) {
    System.out.println("no such index, just return 0.\n");
    return 0;
  }


  @Override
  public int count() {
    return 0;
  }

  @Override
  public int sum() {
    return 0;
  }

  @Override
  public String toString() {
    return "";
  }

  public IListOfInts insert(int data) {
    return new NommalNode(data, this);
  }


}




