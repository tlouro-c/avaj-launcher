package tc.tlouro_c.simulator.aircrafts;

class AircraftFactory {

	private static AircraftFactory	instance;
	private static int				aircraftsProduced;

	private AircraftFactory() {};

	public static AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		//TODO
		return new JetPlane(aircraftsProduced, "F16", new Coordinates(1,1,1));
	}

}
