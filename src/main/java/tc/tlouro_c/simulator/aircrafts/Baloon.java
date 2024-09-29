package tc.tlouro_c.simulator.aircrafts;

public class Baloon extends Aircraft {
	
	Baloon(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);

		switch (weather) {
			case "SUN":
				message = "And the weather so breezy. Man, why can't life always be this easy?";
				coordinates.increaseHeight(4);
				coordinates.increaseLongitude(2);
				break;
			case "RAIN":
				message = "Rain, rain, rain go away, let the sun come out and all the children say...";
				coordinates.decreaseHeight(5);
				break;
			case "FOG":
				message = "Can't see nothing around my baloon...";
				coordinates.decreaseHeight(3);
				break;
			case "SNOW":
				message = "I'm afraid we might fall with all this snow...";
				coordinates.decreaseHeight(15);
				break;
		}

		if (coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
		}
	}

	@Override
	public String toString() {
		return String.format("Baloon#%s(%d)", name, id);
	}
}
