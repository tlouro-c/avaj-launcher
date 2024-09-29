package tc.tlouro_c.simulator.aircrafts;

import tc.tlouro_c.simulator.utils.OutputFile;
import tc.tlouro_c.simulator.Coordinates;
import java.io.IOException;

public class Helicopter extends Aircraft {
	
	Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String message = "";

		switch (weather) {
			case "SUN":
				message = "Sun... All Of The Lights!";
				coordinates.increaseHeight(2);
				coordinates.increaseLongitude(10);
				break;
			case "RAIN":
				message = "Rain... Again... But on the heli...";
				coordinates.increaseLongitude(5);
				break;
			case "FOG":
				message = "Can't see nothing around my heli...";
				coordinates.increaseLongitude(1);
				break;
			case "SNOW":
				message = "I'm freezing, turn on AC please...";
				coordinates.decreaseHeight(12);
				break;
		}

		try {
			OutputFile.getInstance().write(this + ": " + message + "\n");
		} catch (IOException e) {
			System.err.println("Error writing to the output file");
		}

		if (coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
		}
	}

	@Override
	public String toString() {
		return String.format("Helicopter#%s(%d)", name, id);
	}
}
