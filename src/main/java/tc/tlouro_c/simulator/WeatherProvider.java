package tc.tlouro_c.simulator;

import tc.tlouro_c.simulator.aircrafts.Coordinates;

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
		//TODO
		return weather[0];
	}
}
