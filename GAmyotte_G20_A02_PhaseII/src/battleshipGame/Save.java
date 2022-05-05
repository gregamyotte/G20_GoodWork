package battleshipGame;

import java.io.*;
import java.util.Scanner;

/**
 * @author Greg Amyotte
 *
 */
public class Save {
	private char[][] board;
	private String[] carrier;
	private String[] battleship;
	private String[] cruiser;
	private String[] submarine;
	private String[] destroyer;
	private String fileName;
	private int rows;
	private int cols;
	private String player;

	public Save() {
		fileName = new String("currentGame.txt");
		carrier = new String[5];
		battleship = new String[4];
		cruiser = new String[3];
		submarine = new String[3];
		destroyer = new String[2];
		readFile();
	} // Save()

	public int getRows() {
		return rows;
	} // getRows()

	public int getCols() {
		return cols;
	} // getCols

	private void setBoard() {
		this.board = new char[rows][cols];
	} // setBoard(char[][])

	public char[][] getBoard() {
		return board;
	} // getBoard()

	public String[][] getShips() {
		String[][] ships = new String[5][];
		ships[0] = carrier;
		ships[1] = battleship;
		ships[2] = cruiser;
		ships[3] = submarine;
		ships[4] = destroyer;
		return ships;
	} // getShips()

	public String getPlayer() {
		return player;
	} // getPlayer()

	public void readFile() {
		File settingsFile;
		Scanner input = null;
		try {
			settingsFile = new File(fileName);
			input = new Scanner(settingsFile);
		}
		catch (IOException e) {
			System.out.println("Error: " + fileName + " could not be foumd");
		}

		while (input.hasNext()) {
			rows = Integer.parseInt(input.next());
			cols = Integer.parseInt(input.next());
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
			player = input.next();
			setBoard();
			for (int o = 0; o < board.length; o += 1)
				for (int p = 0; p < board[o].length; p += 1)
					board[o][p] = input.next().charAt(0);
		}

	} // readFile()

	public boolean writeFile(int rows, int cols, String[] carrier,
			String[] battleship, String[] cruiser, String[] submarine,
			String[] destroyer, String player, char[][] board) {
		boolean saved = false;
		File settingsFile = null;
		FileWriter write = null;
		try {
			settingsFile = new File(fileName);
			write = new FileWriter(settingsFile);
		}
		catch (IOException e) {
			System.out.println("Error: " + fileName + " could not be foumd");
		}
		settingsFile.delete();

		try {
			write.write(rows + "\n");
			write.write(cols + "\n");
			write.write(carrier[0] + " " + carrier[1] + " " + carrier[2] + " "
					+ carrier[3] + " " + carrier[4] + "\n");
			write.write(battleship[0] + " " + battleship[1] + " " + battleship[2]
					+ " " + battleship[3] + "\n");
			write.write(cruiser[0] + " " + cruiser[1] + " " + cruiser[2] + "\n");
			write.write(submarine[0] + " " + submarine[1] + " " +  submarine[2] + "\n");
			write.write(destroyer[0] + " " + destroyer[1] + "\n");
			write.write(player + "\n");
			for (int row = 0; row < board.length; row += 1) {
				for (int col = 0; col < board[row].length; col += 1)
					write.write(board[row][col] + " ");
				write.write("\n");
			}
			saved = true;
			write.close();
		} // try
		catch (IOException e) {
			System.out.println("Game could not be saved");
		}
		return saved;
	} // writeFile(int, int, String[], String[], String[], String[], String[], String, char[][])
} // Save class
