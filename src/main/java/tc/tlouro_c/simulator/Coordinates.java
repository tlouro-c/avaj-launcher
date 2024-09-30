package tc.tlouro_c.simulator;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	}

	public int getLongitude() {
		return longitude;
	}

	public void increaseLongitude(int longitudeIncrease) {
		this.longitude += longitudeIncrease;
	}

	public int getLatitude() {
		return latitude;
	}

	public void increaseLatitude(int latitudeIncrease) {
		this.latitude += latitudeIncrease;
	}

	public int getHeight() {
		return height;
	}

	public void increaseHeight(int heightIncrease) {
		this.height += heightIncrease;
		if (height > 100) {
			this.height = 100;
		}
	}

	public void decreaseHeight(int heightDecrease) {
		this.height -= heightDecrease;
		if (height < 0) {
			this.height = 0;
		}
	}

	@Override
	public String toString() {
		return "(LONGITUDE=" + longitude + ", LATITUDE=" + latitude + ", HEIGHT=" + height + ")";
	}

}
