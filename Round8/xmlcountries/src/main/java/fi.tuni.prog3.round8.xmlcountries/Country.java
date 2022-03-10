package fi.tuni.prog3.round8.xmlcountries;


public class Country implements Comparable<Country>{
    private final String name;
    private final double area;
    private final long population;
    private final double gdp;


    public Country(String name, double area, long population, double gdp){
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
    }
    @Override
    public int compareTo(Country o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString(){
        return String.format("%s%n  Area: %.1f km2%n  Population: %d%n  GDP: %.1f (2015 USD)%n",
                this.name, this.area, this.population, this.gdp);
    }

    public String getName(){
        return this.name;
    }

    public double getArea(){
        return this.area;
    }

    public long getPopulation(){
        return this.population;
    }

    public double getGdp(){
        return this.gdp;
    }




}
