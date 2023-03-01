public class Liiist {
  List<Integer> myL1 = new ArrayList<>(Arrays.asList(1, 2, 3));
  List<Integer> myL2 = new ArrayList<>(myL1); // create a new list object and copy the elements

System.out.println(myL1); // [1, 2, 3]
System.out.println(myL2); // [1, 2, 3]

myL1.add(4);
myL1.remove(0);

System.out.println(myL1); // [2, 3, 4]
System.out.println(myL2); // [1, 2, 3]


}
