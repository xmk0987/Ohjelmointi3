import java.io.*;
import java.util.*;
import java.lang.String;

public class ValueNode extends Node{
    private final Object value;

    public ValueNode(double value){
        this.value = value;
    }

    public ValueNode(boolean value){
        this.value = value;
    }

    public ValueNode(String value){
        this.value = value;

    }

    public boolean isNumber(){
        return value instanceof Double;
    }

    public boolean isBoolean(){
        return value instanceof Boolean;
    }

    public boolean isString(){
        return value instanceof String;
    }

    public boolean isNull(){
        return value == null;
    }

    public double getNumber(){
        String str = value.toString();
        return Double.parseDouble(str);
    }

    public boolean getBoolean(){
        return (boolean) (Boolean) value;
    }

    public String getString(){
        return value.toString();
    }



}


