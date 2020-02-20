package weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

// Review Question 5

public class Weather {

    public static void main(String[] args) throws IOException {


        String[] weatherData = getData(); 
        
        // Your code goes here
        // peaking the data
//        for(int i = 0; i < weatherData.length; i++)
//        {
//            System.out.println(weatherData[i]);
//        }

        double highestTemperatureDailyMean = -9999;
        int count = 0;
        int sum = 0;
        int count2 = 0;
        for(int i = 1; i < weatherData.length; i++)
        {
            System.out.println(weatherData[i]);
            String[] data = weatherData[i].split(";");
            // for q1
            String temperatureDailyMeanString = data[5];
            double temperatureDailyMean = Double.parseDouble(temperatureDailyMeanString);
            if(temperatureDailyMean > highestTemperatureDailyMean)
                highestTemperatureDailyMean = temperatureDailyMean;


            // for q2
            String relativeHumidityDailyMeanString = data[6];
            double relativeHumidityDailyMean = Double.parseDouble(relativeHumidityDailyMeanString);
            if(relativeHumidityDailyMean > 60)
            {
                count ++;
            }

            // for q3
            String month = data[1];
            if(month.equals("04")) // April's data
            {
                sum += temperatureDailyMean;
                count2++;
            }
        }
        System.out.println(highestTemperatureDailyMean);
        System.out.println(count);
        System.out.println(sum / count2);
        for(int k = 5; k < 11; k++)
        {
            System.out.println(getHighest(weatherData,k));
        }

    }


    public static double getHighest(String[] weatherData, int index)
    {

        double highest = - 9999;
        for(int i = 1; i < weatherData.length; i++) {
            //System.out.println(weatherData[i]);
            String[] data = weatherData[i].split(";");
            // for q1
            String dataString = data[index];
            double dataNumber = Double.parseDouble(dataString);
            if (dataNumber > highest)
                highest = dataNumber;
        }

        return highest;
    }


    public static String[] getData() throws IOException {

        URL url = new URL("https://cs.wcupa.edu/schen/csc240/weather.csv");
        URLConnection connection = url.openConnection();

        InputStreamReader input = new InputStreamReader(connection.getInputStream());
        BufferedReader buffer = null;
        StringBuilder data = new StringBuilder();

        String line = "";
        try {
            buffer = new BufferedReader(input);

            while ((line = buffer.readLine()) != null) {
                data.append(line + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data.toString().split("\n");
    }

}