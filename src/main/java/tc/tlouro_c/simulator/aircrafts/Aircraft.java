package tc.tlouro_c.simulator.aircrafts;

abstract public class Aircraft extends Flyable {
	protected final long	id;
	protected final String	name;
	protected Coordinates	coordinates;
	protected String		message;	

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}
}
