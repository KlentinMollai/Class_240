package HomeWork_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GasPrices {

	static double yearlyAverage = 0;
	static double monthlyAverage = 0;
	static double highest = -9999;
	static double lowest = 9999;

	public static void main(String[] args) throws IOException {

		String[] gasData = getData(); // download gas price into an array
		for (int year = 18; year >= 8; year--) {
			for (int month = 12; month >= 1; month--) {
				for (int i = 1; i < gasData.length; i++) {
					yearlyAverage = getYearlyAverageGasPrice(gasData, year, 4);
					monthlyAverage = getMonthlyAverageGasPrice(gasData, month, year, 6);
					highest = getHighest(gasData);
					lowest = getLowest(gasData);
				}

				System.out.printf("Average Price Per Month for New York City: %d/20%02d $%.2f\n ", month, year,
						monthlyAverage);
			}
			System.out.printf(" Average Price for Buffalo in: 20%02d  $%.2f\n ", year, yearlyAverage);
		}
		
		System.out.printf("Highest gas price: $%.2f\n ", highest);
		System.out.printf("Lowest gas price: $%.2f\n ", lowest);
	}
	
	public static double getYearlyAverageGasPrice(String[] gasPrice, int year, int city_state) {

		double sum = 0;
		int count = 0;
		for (int i = 1; i < gasPrice.length; i++) {
			String[] data = gasPrice[i].split(",");
			String weeklyAverageDataString = data[city_state];
			double weeklyAverageData = Double.parseDouble(weeklyAverageDataString);
			String dateString = data[0];
			String yearString = "" + (year);
			if (dateString.endsWith(yearString)) {
				count++;
				sum += weeklyAverageData;

			}
			
		}yearlyAverage = sum / count;

		return yearlyAverage;
	}

	public static double getMonthlyAverageGasPrice(String[] gasPrice, int month, int year, int city_state) {

		double sum = 0;
		int count = 0;
		for (int i = 1; i < gasPrice.length; i++) {
			String[] data = gasPrice[i].split(",");
			String weeklyAverageDataString = data[city_state];
			double weeklyAverageData = Double.parseDouble(weeklyAverageDataString);
			String dateString = data[0];
			String yearString = "" + (year);
			String monthString = "" + (month);
			if (dateString.startsWith(monthString) && dateString.endsWith(yearString)) {
				sum += weeklyAverageData;
				count++;

			}

		}
		monthlyAverage = sum / count;
		return monthlyAverage;
	}

	public static double getHighest(String[] gasPrices) {

		for (int i = 1; i < gasPrices.length; i++) {
			String[] data = gasPrices[i].split(",");

			for (int j = 1; j < 10; j++) {
				String dataString = data[j];
				double priceData = Double.parseDouble(dataString);
				if (priceData > highest)
					highest = priceData;
			}
		}

		return highest;
	}

	public static double getLowest(String[] gasPrices) {

		for (int i = 1; i < gasPrices.length; i++) {
			String[] data = gasPrices[i].split(",");
			for (int j = 1; j < 10; j++) {
				String dataString = data[j];
				double priceData = Double.parseDouble(dataString);
				if (priceData < lowest)
					lowest = priceData;
			}
		}

		return lowest;
	}

	public static String[] getData() throws IOException {

		URL url = new URL(
				"https://cs.wcupa.edu/schen/csc240/Gasoline_Retail_Prices_Weekly_Average_by_Region__Beginning_2008.csv");
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
