package tc.tlouro_c.simulator.aircrafts;

import tc.tlouro_c.simulator.WeatherTower;

public abstract class Flyable {

	protected WeatherTower weatherTower;

	public abstract void updateConditions();

	public void registerTower(WeatherTower p_tower) {
		weatherTower = p_tower;
		weatherTower.register(this);
	}
}
