package hotel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Karol Pokomeda on 2017-04-23.
 * Adresses generated with random address generator https://www.doogal.co.uk/RandomAddresses.php
 * Names generated with http://www.fantasynamegenerators.com/company-names.php#.WPxYz7gwhdg
 *
 */
public class RandomHotelGenerator {
    public static List<Hotel> withProcessSource(String filePath){
        ArrayList<Hotel> result = new ArrayList<>();
        File inputFile = new File(filePath);
        try(FileReader fileIn = new FileReader(inputFile);
            Scanner dataIn = new Scanner(fileIn)){
            while(dataIn.hasNextLine()){
                String[] processText = dataIn.nextLine().split(";");
                HashMap<Integer, Double> bedPrices = new HashMap<Integer, Double>();
                bedPrices.put(1, Double.valueOf(processText[8].replace(",", ".")));
                bedPrices.put(2 + (int)(Math.random()*2), Double.valueOf(processText[9].replace(",", ".")));
                HotelImpl nextHotel = new HotelImpl(
                        processText[0],
                        processText[1],
                        Integer.valueOf(processText[2]),
                        Boolean.valueOf(processText[3]),
                        Boolean.valueOf(processText[4]),
                        Boolean.valueOf(processText[5]),
                        Double.valueOf(processText[6].replace(",", ".")),
                        Double.valueOf(processText[7].replace(",", ".")),
                        bedPrices
                );
                for (int i = (int)(Math.random()*20); i > 0; i--){
                    nextHotel.rate((int)(Math.random()*5)+1);
                }
                System.out.println(nextHotel);
                result.add(nextHotel);
            }
        } catch (IOException e){
            throw new IllegalArgumentException("File not found or data corrupted");
        }
        return result;
    }
}
