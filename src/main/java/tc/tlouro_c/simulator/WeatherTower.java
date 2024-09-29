package tc.tlouro_c.simulator;

import tc.tlouro_c.simulator.aircrafts.*;
import tc.tlouro_c.simulator.WeatherProvider;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates p_coordinates) {
		return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
	}

	public void changeWeather() {
		this.conditionChanged();
	}
}
