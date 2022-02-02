public class StackTest {
  // Testaa luokkaa LinkedStack asettamalla komentoriviparametrit pinoon ja
  // sen jälkeen tulostamalla ja poistamalla päällimmäisen alkion, kunnes
  // pino on tyhjä.
  public static void main(String[] args) {
    LinkedStack stack = new LinkedStack();
    for(String arg: args) {
      stack.push(arg);  // String-tyyppinen arg käy Object-tyyppiseksi parametriksi.
    }
    while(stack.size() > 0) {
      System.out.println("Current stack size: " + stack.size());
      System.out.println("  Top item: " + stack.peek().getItem());
      System.out.println("Now popping the top item.");
      stack.pop();
    }
    System.out.println("Current stack size: " + stack.size());
  }
}