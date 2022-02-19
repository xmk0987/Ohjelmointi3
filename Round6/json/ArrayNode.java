import java.io.*;
import java.lang.*;

import java.util.*;
import java.lang.String;

public class ArrayNode extends Node implements Iterable<Node>{

    private final ArrayList<Node> arr;


    public ArrayNode(){
        this.arr = new ArrayList<>();
    }

    public void add(Node node){
        this.arr.add(node);
    }

    public int size(){
        return this.arr.size();
    }

    @Override
    public Iterator<Node> iterator(){
        return this.arr.iterator();
    }





}
