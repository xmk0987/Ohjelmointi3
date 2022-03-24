import java.util.NoSuchElementException;

public class Order {
    Order(){

    }

    public boolean addItems(String name, int count)throws IllegalArgumentException, NoSuchElementException{
        return true;
    }
    public static class Item {
        Item(String name, double price){

        }
    }

    public static class Entry{
        Entry(Order.Item item, int count){

        }
    }
}
