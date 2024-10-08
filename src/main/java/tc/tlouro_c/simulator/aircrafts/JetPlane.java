package tc.tlouro_c.simulator.aircrafts;

import tc.tlouro_c.simulator.utils.OutputFile;
import tc.tlouro_c.simulator.Coordinates;
import java.io.IOException;

public class JetPlane extends Aircraft {
	
	JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String message = "";

		switch (weather) {
			case "SUN":
				message = "Light! Finally!";
				coordinates.increaseHeight(2);
				coordinates.increaseLatitude(10);
				break;
			case "RAIN":
				message = "F16 can handle this rain.";
				coordinates.increaseLatitude(5);
				break;
			case "FOG":
				message = "Going crazy with this fog...";
				coordinates.increaseLatitude(1);
				break;
			case "SNOW":
				message = "Eventually we will land if this snows continues...";
				coordinates.decreaseHeight(7);
				break;
		}

		try {
			OutputFile.getInstance().write(this + ": " + message + " " + this.coordinates + "\n");
		} catch (IOException e) {
			System.err.println("Error writing to the output file");
		}

		if (coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
		}
	}

	@Override
	public String toString() {
		return String.format("JetPlane#%s(%d)", name, id);
	}
}
