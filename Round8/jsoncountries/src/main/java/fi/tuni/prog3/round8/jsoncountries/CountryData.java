package fi.tuni.prog3.round8.jsoncountries;



import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.String;
import java.util.stream.Collectors;

public class CountryData {
    public static List<Country> readFromJsons(String areaFile, String populationFile, String gdpFile) throws IOException {
        HashMap<String, Map<String, String>> countries = new HashMap<>();

        Gson gson = new Gson();

        var areajson = gson.fromJson(new FileReader(areaFile), JsonObject.class);
        var populationjson = gson.fromJson(new FileReader(populationFile), JsonObject.class);
        var gdpjson = gson.fromJson(new FileReader(gdpFile), JsonObject.class);

        for(var country: areajson.get("Root").getAsJsonObject().get("data").getAsJsonObject().get("record").getAsJsonArray()) {
            var key = country.getAsJsonObject().get("field").getAsJsonArray().get(0).getAsJsonObject().get("attributes").getAsJsonObject()
                    .getAsJsonObject().get("key").getAsString();
            var name = country.getAsJsonObject().get("field").getAsJsonArray().get(0).getAsJsonObject().get("value").getAsString();
            var area = country.getAsJsonObject().get("field").getAsJsonArray().get(2).getAsJsonObject().get("value").getAsString();

            HashMap<String, String> areamap = new HashMap<>();
            areamap.put("area", area);
            areamap.put("name", name);
            countries.put(key, areamap);

        }

        for(var country: populationjson.get("Root").getAsJsonObject().get("data").getAsJsonObject().get("record").getAsJsonArray()) {
            var key = country.getAsJsonObject().get("field").getAsJsonArray().get(0).getAsJsonObject().get("attributes").getAsJsonObject()
                    .getAsJsonObject().get("key").getAsString();
            var population = country.getAsJsonObject().get("field").getAsJsonArray().get(2).getAsJsonObject().get("value").getAsString();

            countries.get(key).put("population", population);

        }

        for(var country: gdpjson.get("Root").getAsJsonObject().get("data").getAsJsonObject().get("record").getAsJsonArray()) {
            var key = country.getAsJsonObject().get("field").getAsJsonArray().get(0).getAsJsonObject().get("attributes")
                    .getAsJsonObject()
                    .getAsJsonObject().get("key").getAsString();
            var gdp = country.getAsJsonObject().get("field").getAsJsonArray().get(2).getAsJsonObject().get("value").getAsString();

            countries.get(key).put("gdp", gdp);

        }

        return countries.values().stream().map(x -> new Country(x.get("name"), Double.parseDouble(x.get("area")
        ), Long.parseLong(x.get("population")), Double.parseDouble(x.get("gdp")))).collect(Collectors.toList());
    }

    public static void writeToJson(List<Country> countries, String countryFile){
        Gson gson = new Gson();
        String json = gson.toJson(countries);

        try {

            FileWriter writer = new FileWriter(countryFile);
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

