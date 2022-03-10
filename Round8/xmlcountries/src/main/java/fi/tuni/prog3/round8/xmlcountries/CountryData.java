package fi.tuni.prog3.round8.xmlcountries;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import javax.swing.text.DefaultStyledDocument;
import javax.xml.XMLConstants;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.lang.String;
import java.util.stream.Collectors;

public class CountryData {
    public static List<Country> readFromXmls(String areaFile, String populationFile, String gdpFile) throws IOException, JDOMException{
        HashMap<String, Map<String, String>> countries = new HashMap<>();

        var sax = new SAXBuilder();

        var Document_area = sax.build(new File(areaFile));
        var Document_population = sax.build(new File(populationFile));
        var Document_gdp = sax.build(new File(gdpFile));


        for(var child : Document_area.getRootElement().getChild("data").getChildren()){
            var key = child.getChildren().get(0).getAttribute("key").getValue();
            var name = child.getChildren().get(0).getContent(0).getValue();
            var area = child.getChildren().get(2).getContent(0).getValue();
            HashMap<String, String> areamap = new HashMap<>();
            areamap.put("area", area);
            areamap.put("name", name);
            countries.put(key, areamap);
        }

        for(var child : Document_population.getRootElement().getChild("data").getChildren()){
            var key = child.getChildren().get(0).getAttribute("key").getValue();
            var population = child.getChildren().get(2).getContent(0).getValue();
            countries.get(key).put("population", population);
        }

        for(var child : Document_gdp.getRootElement().getChild("data").getChildren()){
            var key = child.getChildren().get(0).getAttribute("key").getValue();
            var gdp = child.getChildren().get(2).getContent(0).getValue();
            countries.get(key).put("gdp", gdp);
        }

        return countries.values().stream().map(x -> new Country(x.get("name"), Double.parseDouble(x.get("area")
        ), Long.parseLong(x.get("population")), Double.parseDouble(x.get("gdp")))).collect(Collectors.toList());
    }

    public static void writeToXml(List<Country> countries, String countryFile){
        Document document = new Document();
        Element root = new Element("countries");

        // Creating a child for the root element. Here we can see how to
        // set the text of an xml element.
        for(Country country : countries){
            Element child = new Element("country");
            child.addContent(new Element("name").setText(country.getName()));
            child.addContent(new Element("area").setText(String.valueOf(country.getArea())));
            child.addContent(new Element("population").setText(String.valueOf(country.getPopulation())));
            child.addContent(new Element("GDP").setText(String.valueOf(country.getGdp())));
            // Add the child to the root element and add the root element as
            // the document content.
            root.addContent(child);
            document.setContent(root);
        }


        try {
            FileWriter writer = new FileWriter("userinfo.xml");
            XMLOutputter outputter = new XMLOutputter();

            // Set the XLMOutputter to pretty formatter. This formatter
            // use the TextMode.TRIM, which mean it will remove the
            // trailing white-spaces of both side (left and right)
            outputter.setFormat(Format.getPrettyFormat());

            // Write the document to a file and also display it on the
            // screen through System.out.
            outputter.output(document, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
