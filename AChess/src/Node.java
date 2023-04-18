public class Node {

  public int data;
  public Node parent;
  public int rank;

  public Node() {
    this.parent = this;
    this.rank = 1;
  }

  public Node getParent() {
    return parent;
  }


  public void setParent(Node parent) {
    this.parent = parent;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }
  public Node findParent() {
    if (this.parent == this) {return this;}
    return this.parent.findParent();
  }

  public boolean isUnion(Node node_1, Node node_2) {
    if (node_1.parent == node_2.parent) {
      return true;
    }
    return false;
  }

  public int makeThemUnion(Node node_1, Node node_2) {
    if (isUnion(node_1, node_2)) {
      return 0;
    }

    if (node_1.parent.rank > node_2.parent.rank) {
      node_2.setParent(node_1.findParent());
      //这里需要让node_1.parent.rank++吗？
    } else if (node_1.parent.rank<node_2.parent.rank) {
      node_1.setParent(node_2.findParent());
      //这里需要让node_2.parent.rank++吗？
    } else {
      node_1.setParent(node_2.parent);
      node_1.parent.rank ++ ;
    }

    return 1;
  }
}
