// Päätason luokka LinkedStack.
public class LinkedStack {

  // Sisäinen luokka Node, jota pino hyödyntää yksittäisten alkioiden tallennukseen.
  public static class Node {
    // Node-luokan yksityiseksi määritetyt jäsenmuuttujat, joihin
    // tallennetaan seuraava solmu ja tämän solmun alkio.
    private Node next;
    private Object item;  // Object-viite voi viitata kaikentyyppisiin olioihin!

    // Node-luokan rakennin, jolle annetaan parametreina viitteet seuraavaan
    // solmuun sekä alkioon ja joka asettaa ne nyt luotavan Node-olion jäseniin.
    // Tässä näkyvyysmääre on jätetty pois (sellaisen saisi antaa).
    Node(Node next, Object item) {
      this.next = next;
      this.item = item;
    }

    // Node-luokan jäsenfunktio, joka palauttaa yksityisen next-jäsenen arvon.
    // Tässä näkyvyysmääre on jätetty pois (sellaisen saisi antaa).
    Node getNext() {
      return this.next;
    }

    // Node-luokan jäsenfunktio, joka palauttaa yksityisen item-jäsenen arvon.
    // Tässä näkyvyysmääre on jätetty pois (sellaisen saisi antaa).
    Object getItem() {
      return this.item;
    }
  } // Sisäisen Node-luokan määritys päättyy tähän.

  // LinkedStack-luokan yksityiset jäsenmuuttujat, joihin tallennetaan
  // pinon päällimmäinen solmu sekä pinon koko. Java sallii alustuksen
  // suoraan määrittelyn yhteydessä, mutta ne voisi alustaa myös rakentimessa.
  private Node top = null;
  private int n = 0;

  // Tämä LinkedStack-luokka ei tarvitse rakenninta, koska tarvittavat alustukset
  // onnistuivat suoraan jäsenmuuttujien määritysten yhteydessä. Luokka toimii aivan
  // kuin sillä olisi muotoa public LinkedList() {} oleva mitään tekemätön rakennin.

  // LinkedStack-luokan julkinen jäsenfunktio, joka palauttaa pinon
  // päällimmäisen arvon.
  public Node peek() {
    return this.top;
  }

  // LinkedStack-luokan julkinen jäsenfunktio, joka poistaa ja palauttaa
  // pinon päällimmäisen solmun. Palautetaan null, jos pino oli jo tyhjä.
  public Node pop() {
    Node result = this.top;
    if(this.top != null) { // Poisto tehdään, ellei pino jo ole tyhjä.
      this.n -= 1;
      this.top = this.top.getNext();
    }
    return result;
  }

  // LinkedStack-luokan julkinen jäsenfunktio, joka lisää parametrina
  // saadun alkion pinon päälle.
  public void push(Object item) {
    this.top = new Node(this.top, item);
    this.n += 1;
  }

  // LinkedStack-luokan julkinen jäsenfunktio, joka palauttaa pinon koon.
  public int size() {
    return this.n;
  }
} // C++-ohjelmoijat huomio: Java-luokan loppusulun perään ei kuulu puolipistettä!
  // Java tosin sallii puolipisteen, koska tämä virhe on yleinen C++-taustaisilla.