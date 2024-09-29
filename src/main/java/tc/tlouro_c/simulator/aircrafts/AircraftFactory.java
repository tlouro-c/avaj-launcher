package tc.tlouro_c.simulator.aircrafts;

import tc.tlouro_c.simulator.utils.InvalidData;
import tc.tlouro_c.simulator.Coordinates;

public class AircraftFactory {

	private static AircraftFactory	instance;
	private static int				aircraftsProduced;

	private AircraftFactory() {};

	public static AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name,
		Coordinates p_coordinates) throws InvalidData {

		if (p_type == null || p_name == null) {
			throw new InvalidData("Insufficient data to build the aircraft");
		}

		int height = p_coordinates.getHeight();
		int latitude = p_coordinates.getLatitude();
		int longitude = p_coordinates.getLongitude();

		if (height < 0 || height > 100) {
			throw new InvalidData("The height of the aircraft must be in the 0-100 range");
		} else if (latitude < 0 || longitude < 0) {
			throw new InvalidData("The longitude and latitude of the aircraft must be positive numbers");
		}

		if (p_type.equalsIgnoreCase("JETPLANE")) {
			aircraftsProduced++;
			return new JetPlane(aircraftsProduced, p_name, p_coordinates);
		} else if (p_type.equalsIgnoreCase("HELICOPTER")) {
			aircraftsProduced++;
			return new Helicopter(aircraftsProduced, p_name, p_coordinates);
		} else if (p_type.equalsIgnoreCase("BALOON")) {
			aircraftsProduced++;
			return new Baloon(aircraftsProduced, p_name, p_coordinates);
		}
		throw new InvalidData("This factory doesn't produce that type of aircraft");
	}

}
