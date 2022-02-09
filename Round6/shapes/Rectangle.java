import java.io.*;
import java.util.*;
import java.lang.String;

public class Rectangle implements IShapeMetrics {
    private double height = 0;
    private double width = 0;

    Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }

    public String toString(){
        return String.format("Rectangle with height %.2f and width %.2f", this.height, this.width);

    }

    public String name(){
        return "rectangle";
    }

    @Override
    public double area(){
        return (this.height*this.width);
    }

    @Override
    public double circumference(){
        return 2*(this.height+this.width);
    }



}
