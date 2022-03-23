package fi.tuni.prog3.json;
import java.lang.*;

import java.util.*;


/**
 * A class for representing a JSON array.
 */
public final class ArrayNode extends Node implements Iterable<Node>{

    private final ArrayList<Node> arr;


    /**
     * Constructs an initially empty JSON array node.
     */
    public ArrayNode(){
        this.arr = new ArrayList<>();
    }


    /**
     * Returns the number of JSON nodes stored in this JSON array.
     * @return the number of JSON nodes in this JSON array.
     */
    public int size(){
        return this.arr.size();
    }

    /**
     * Adds a new JSON node to the end of this JSON array.
     * @param node the new JSON node to be added.
     *  */
    public void add(Node node){
        this.arr.add(node);
    }

    /**
     * Returns a Node iterator that iterates the JSON nodes stored in this JSON array.
     * Specified by:
     * iterator in interface Iterable<Node>
     * @return a Node iterator that iterates the JSON nodes stored in this JSON array.
     */
    @Override
    public Iterator<Node> iterator(){
        return this.arr.iterator();
    }





}
