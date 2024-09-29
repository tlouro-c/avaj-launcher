package tc.tlouro_c.simulator;

import java.util.Random;

public class WeatherProvider {
	String[] weather;
	private static WeatherProvider instance;

	private WeatherProvider() {
		weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};
	};

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}

	public String getCurrentWeather(Coordinates p_coordinates) {
		long seed = p_coordinates.getLongitude() 
				* p_coordinates.getLatitude()
				+ p_coordinates.getHeight();
		int index = Math.abs(new Random(seed).nextInt()) % 4;
		
		return weather[index];
	}
}
