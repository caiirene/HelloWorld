interface StringProcessor {
  String process(String s);

}

  public static String processString(String str, StringProcessor processor) {
    return processor.process(str);
  }


  StringProcessor processor = s -> s.toUpperCase(); // Convert string to uppercase

  String originalString = "Hello, world!";
  String processedString = processString(originalString, processor);
  System.out.println(processedString); // Output: HELLO, WORLD!
