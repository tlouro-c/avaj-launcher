package tc.tlouro_c.simulator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.IOException;
import tc.tlouro_c.simulator.aircrafts.Flyable;
import tc.tlouro_c.simulator.utils.OutputFile;

public class Tower {
	private List<Flyable> observers =  new CopyOnWriteArrayList<>();

	public Tower() {
	}

	public void register(Flyable p_flyable) {
		this.observers.add(p_flyable);

		try {
			OutputFile.getInstance().write(String.format(
				"Tower says: %s registered to weather tower.\n", p_flyable));
		} catch (IOException e) {
			System.err.println("Error writing to the output file");
		}
	}

	public void unregister(Flyable p_flyable) {
		this.observers.remove(p_flyable);

		try {
			OutputFile.getInstance().write(String.format(
				"Tower says: %s unregistered to weather tower.\n", p_flyable));
		} catch (IOException e) {
			System.err.println("Error writing to the output file");
		}
	}

	protected void conditionChanged() {
		for (Flyable aircraft : this.observers) {
			aircraft.updateConditions();
		}
	}
}
