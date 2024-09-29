package tc.tlouro_c.simulator;

import tc.tlouro_c.simulator.utils.*;
import tc.tlouro_c.simulator.aircrafts.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.util.ArrayList;

public class Simulator {

	private static WeatherTower	weatherTower = new WeatherTower();
	private static int			numSimulations;

	public static void main(String[] args)
	{
		if (args.length != 1) {
			System.err.println(
				"Usage: java tc.tlouro_c.simulator.Simulator [scenario.txt]");
			return;
		}
		try (BufferedReader buffer = new BufferedReader(new FileReader(args[0]))) {
			numSimulations = Integer.parseInt(buffer.readLine());
			loadAircrafts(buffer);
			System.out.println("Start simulation");

			for (int i = 0; i < numSimulations; i++) {
				weatherTower.changeWeather();
			}

			OutputFile.getInstance().close();
		} catch (NumberFormatException e) {
			System.err.println("Invalid number of simulations");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

	static void loadAircrafts(BufferedReader buffer) throws InvalidData, IOException {
		AircraftFactory factory = AircraftFactory.getInstance();
		ArrayList<Flyable> aircrafts = new ArrayList<>();

		String	line;
		while ((line = buffer.readLine()) != null) {
			if (line.isBlank()) {
				continue;
			}
			String[] aircraftData = line.split(" ");
			if (aircraftData.length != 5) {
				throw new InvalidData("Aircraft: TYPE NAME LONGITUDE LATITUDE HEIGHT");
			}
			try {
				int longitude = Integer.parseInt(aircraftData[2]);
				int latitude = Integer.parseInt(aircraftData[3]);
				int height = Integer.parseInt(aircraftData[4]);
				aircrafts.add(factory.newAircraft(aircraftData[0], aircraftData[1],
					new Coordinates(longitude, latitude, height)));
			} catch (NumberFormatException e) {
				throw new InvalidData("Aircraft: TYPE NAME LONGITUDE LATITUDE HEIGHT");
			}
		}
		for (Flyable aircraft : aircrafts) {
			aircraft.registerTower(weatherTower);
		}
	}
}

