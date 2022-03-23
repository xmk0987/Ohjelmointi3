package fi.tuni.prog3.json;
import java.io.*;
import java.util.*;
import java.lang.String;

/**
 * A class for representing a JSON object.
 */
public final class ObjectNode extends Node implements Iterable<String>{
    private final TreeMap<String, Node> map;

    /**
     * Constructs an initially empty JSON object node.
     */
    public ObjectNode(){
        this.map = new TreeMap<>();
    }

    /**
     * Returns the JSON node stored under the given name.
     * @param name the name of the name-node pair whose node should be returned.
     * @return the JSON node corresponding to name, or null if such node does not exist.
     */
    public Node get(String name){
        return this.map.get(name);
    }

    /**
     * Stores a name - JSON node pair into this JSON object. If a name-node pair with the same name already exists,
     * the previously existing node will be replaced.
     * @param name the name of the name-node pair.
     * @param node the JSON node of the name-node pair.
     */
    public void set(String name, Node node){
        this.map.put(name, node);
    }

    /**
     * Returns the number of JSON nodes stored under this JSON object.
     * @return the number of JSON nodes under this JSON object.
     */
    public int size(){
        return this.map.size();
    }

    /**
     * Returns a String iterator that iterates the names of the name-node pairs stored in this JSON object in natural
     * String order.
     * Specified by:
     * iterator in interface Iterable<String>
     * @return a String iterator that iterates the names of the stored name-node pairs in natural String order.
     */
    @Override
    public Iterator<String> iterator(){
        return map.keySet().iterator();
    }




}

