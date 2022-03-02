import java.io.*;
import java.lang.*;
import java.util.*;
import java.lang.String;
import java.util.function.Function;
import java.util.stream.Collectors;


public class NdArray<E> extends AbstractCollection<E> {
    public NdArray(Integer firstDimLen, Integer ... furherDimLens) throws NegativeArraySizeException{

    }

    public int size(){

    }

    public E get(int... indices) throws IllegalArgumentException, IndexOutOfBoundsException{
        try{

        }
        catch(IllegalArgumentException e){

        }
    }

    void set(E item, int... indices){

    }

    int[] getDimensions(){

    }

    public interface Iterable<E>{
        Iterator<E> iterator();
    }



}
