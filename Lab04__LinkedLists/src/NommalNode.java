public class NommalNode implements IListOfInts {


  private int data;
  private IListOfInts rest;

  public NommalNode(int data, IListOfInts rest) {
    this.data = data;
    this.rest = rest;
  }

  @Override
  public IListOfInts addAtIndex(int data, int index) {
    if (index == 0) {
      IListOfInts remember;
      remember = new NommalNode(this.data, this.rest);
      this.data = data;
      this.rest = remember;}
      //this.rest = new NommalNode(data, this.rest);}
      //return new NommalNode(data, this);}
    else {
      this.rest.addAtIndex(data,index-1);}

    return this;
      //return new NommalNode(this.data, this.rest.addAtIndex(data, index-1));}
  }

  @Override
  public IListOfInts addFront(int data) {
    return new NommalNode(data, this);
  }

  @Override
  public IListOfInts addBack(int data) {
    return new NommalNode(this.data, this.rest.addBack(data));
  }

  @Override
  public int getDataAtIndex(int index) {
    if (index == 0) {return this.data;}
    else {return this.rest.getDataAtIndex(index-1);}
  }

  public int count() {
    return 1 + this.rest.count();
  }

  @Override
  public int sum() {
    return this.data + this.rest.sum();
  }

  public String toString() {
    return "(" + this.data + ")" + this.rest.toString();
  }

  /*
  public IListOfInts insert(int data) {
    return new NommalNode(data, this);
  }

   */

}
