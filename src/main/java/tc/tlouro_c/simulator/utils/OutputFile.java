package tc.tlouro_c.simulator.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFile extends BufferedWriter {
	private static OutputFile instance;

	private OutputFile() throws IOException {
		super(new FileWriter("simulation.txt"));
	};

	public static OutputFile getInstance() throws IOException {
		if (instance == null) {
			instance = new OutputFile();
		}
		return instance;
	}
}
