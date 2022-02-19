
import java.io.*;
import java.util.*;
import java.lang.String;

public class ObjectNode extends Node implements Iterable<String>{
    private final TreeMap<String, Node> map;

    public ObjectNode(){
        this.map = new TreeMap<>();
    }

    public Node get(String key){
        return this.map.get(key);
    }

    public void set(String key, Node node){
        this.map.put(key, node);
    }

    public int size(){
        return this.map.size();
    }

    @Override
    public Iterator<String> iterator(){
        return map.keySet().iterator();
    }




}
