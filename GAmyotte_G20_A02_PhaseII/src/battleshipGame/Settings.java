package battleshipGame;

import java.io.*;
import java.util.*;

/**
 * @author Greg Amyotte
 *
 */
public class Settings {
	private String[] carrier;
	private String[] battleship;
	private String[] cruiser;
	private String[] submarine;
	private String[] destroyer;
	private String fileName;
	private int rows;
	private int cols;

	public Settings() {
		fileName = new String("gameSettings.txt");
		carrier = new String[5];
		battleship = new String[4];
		cruiser = new String[3];
		submarine = new String[3];
		destroyer = new String[2];
		readFile();
	} // Settings()

	public int getRows() {
		return rows;
	} // getRows()

	public int getCols() {
		return cols;
	} // getCols

	public String[][] getShips() {
		String[][] ships = new String[5][];
		ships[0] = carrier;
		ships[1] = battleship;
		ships[2] = cruiser;
		ships[3] = submarine;
		ships[4] = destroyer;
		return ships;
	} // getShips()
	
	public void readFile() {
		File settingsFile;
		Scanner input = null;
		try {
			settingsFile = new File(fileName);
			input = new Scanner(settingsFile);
		} // try
		catch (IOException e) {
			System.out.println("Error: " + fileName + " could not be foumd");
		} // catch

		while (input.hasNext()) {
			rows = input.nextInt();
			cols = input.nextInt();
			for (int i = 0; i < 5; i += 1)
				carrier[i] = input.next();
			for (int j = 0; j < 4; j += 1)
				battleship[j] = input.next();
			for (int l = 0; l < 3; l += 1)
				cruiser[l] = input.next();
			for (int m = 0; m < 3; m += 1)
				submarine[m] = input.next();
			for (int n = 0; n < 2; n += 1)
				destroyer[n] = input.next();
		} // while
	} // readFile()
} // Settings class
