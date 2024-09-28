package tc.tlouro_c.simulator;

import java.util.List;
import tc.tlouro_c.simulator.aircrafts.Flyable;

public class Tower {
	private List<Flyable> observers;

	public void register(Flyable p_Flyable) {
		observers.add(p_Flyable);

		System.out.println(String.format(
			"Tower says: %s registered to weather tower.", p_Flyable));
	}

	public void unregister(Flyable p_Flyable) {
		observers.remove(p_Flyable);

		System.out.println(String.format(
			"Tower says: %s unregistered to weather tower.", p_Flyable));
	}

	protected void conditionChanged() {
		//TODO
	}
}
