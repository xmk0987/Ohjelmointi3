import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.lang.String;
//authors Onni Vitikainen, Paavo Jyrkiäinen, Otto Ukkonen

public class sevenznimi {
    public static void main(String[] args)throws IOException{

        String strFilename = args[0];
        String strHakusana = args[1];

        try(SevenZFile archiveFile = new SevenZFile(new File(strFilename))){
            SevenZArchiveEntry entry;
            while ((entry = archiveFile.getNextEntry() ) != null) {

                if(entry.getName().contains("txt")){

                    ByteArrayOutputStream contentBytes = new ByteArrayOutputStream();


                    byte[] buffer = new byte[2048];
                    int bytesRead;
                    while((bytesRead = archiveFile.read(buffer)) != -1) {
                        contentBytes.write(buffer, 0, bytesRead);
                    }

                    String content = contentBytes.toString("UTF-8");
                    System.out.println(entry.getName());
                    try(var reader = new BufferedReader((new StringReader(content)))){
                        String line;
                        int i = 1;
                        while((line = reader.readLine()) != null){
                            String line2 = line.toLowerCase();
                            if(line2.contains(strHakusana.toLowerCase())){
                                System.out.println(i + ": " +line.replaceAll("(?i)" + strHakusana, strHakusana.toUpperCase()));

                            }
                            i+= 1;

                        }
                    }
                    System.out.println();
                }


            }

        }
        }






}

