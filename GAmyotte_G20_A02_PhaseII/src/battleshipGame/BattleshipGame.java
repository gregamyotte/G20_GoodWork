package battleshipGame;

/**
 * @author Greg Ammyotte
 *
 */
public class BattleshipGame {
	private static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'Z', 'Y', 'Z' };
	private static final int[] NUMBERS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
			13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 };
	private char[][] board;
	private String[] carrier;
	private String[] battleship;
	private String[] cruiser;
	private String[] submarine;
	private String[] destroyer;
	private boolean carrierSunk = false;
	private boolean battleshipSunk = false;
	private boolean cruiserSunk = false;
	private boolean submarineSunk = false;
	private boolean destroyerSunk = false;
	private int rows;
	private int cols;
	private String player;
	private int lastMoveRow;
	private int lastMoveCol;
	private Settings settings;
	private Save save;

	public BattleshipGame(boolean newGame) {
		if (newGame == true)
			newGame();
		else
			resumeGame();
	} // BattleshipGame(boolean)

	public void setPlayer(String name) {
		player = name;
	} // setPLayer(String)

	public String getPlayer() {
		return player;
	} // getPlayer()

	public int getColNum(String coordinate) {
		int column = 0;
		for (int i = 0; i < ALPHABET.length; i += 1)
			if (ALPHABET[i] == coordinate.charAt(0)) {
				column = i;
				break;
			} // if
		return column;
	} // getColNum(String)

	public int getRowNum(String coordinate) {
		int row = 0;
		int coord = Integer.parseInt(coordinate.substring(1));
		for (int i = NUMBERS.length - 1; i >= 0; i -= 1)
			if (NUMBERS[i] == coord) {
				row = i;
				break;
			} // if
		return row;
	} // getColNum(String)

	private void initializeBoard(int rows, int cols) {
		board = new char[rows][cols];
		for (int row = rows - 1; row >= 0; row -= 1) {
			for (int col = 0; col < cols; col += 1)
				board[row][col] = 'E';
		} // for (int row = 0; row < rows; row += 1)
	} // initializeBoard(int, int)

	private void initializeBoard(char[][] board) {
		this.board = board;
	} // initializeBoard(char[][])

	private void initializeShips(String[][] ships) {
		carrier = sortShip(ships[0]);
		battleship = sortShip(ships[1]);
		cruiser = sortShip(ships[2]);
		submarine = sortShip(ships[3]);
		destroyer = sortShip(ships[4]);
		if (checkShipOrder(carrier) && checkShipOrder(battleship)
				&& checkShipOrder(cruiser) && checkShipOrder(submarine)
				&& checkShipOrder(destroyer))
			validateCoords(ships);
	} // initializeShips(String[][])

	public char[][] getBoard() {
		return board;
	} // getBoard()

	public int getRows() {
		return rows;
	} // getRows;

	public int getCols() {
		return cols;
	} // getCols()

	private void validateCoords(String[][] ships) {
		boolean valid = true;
		int i = 0;
		while (valid == true && i < ships.length) {
			for (int j = 0; j < ships[i].length; j += 1) {
				if (getColNum(ships[i][j]) > ALPHABET.length
						&& getColNum(ships[i][j]) > NUMBERS.length) {
					valid = false;
					System.out.println("The game file has been corrupted.");
				} // if
			} // for
			i += 1;
		} // while
	} // validateCoords(String[][])

	private String[] sortShip(String[] ship) {
		String[] sortedShip = ship;
		boolean sorted = false;
		int loopend = ship.length;
		while (loopend > 1 && sorted == false) {
			sorted = true;
			for (int j = 1; j < loopend; j += 1) {
				if (getColNum(ship[j - 1]) > getColNum(ship[j])) {
					sortedShip = swapCoord(ship, j - 1, j);
					sorted = false;
				} // if
			} // for
			loopend -= 1;
		} // while
		return sortedShip;
	} //sortShip(String[])

	private String[] swapCoord(String[] ship, int coord1, int coord2) {
		String temp = new String(ship[coord1]);
		ship[coord1] = ship[coord2];
		ship[coord2] = temp;
		return ship;
	} // swapCoord(String[], String, String)

	private boolean checkHit(int row, int col) {
		boolean isHit = false;
		String[][] ships = { carrier, battleship, cruiser, submarine, destroyer };
		for (int i = 0; i < ships.length; i += 1)
			for (int j = 0; j < ships[i].length; j += 1)
				if (getColNum(ships[i][j]) == col && getRowNum(ships[i][j]) == row)
					isHit = true;
		return isHit;
	} // checkHit(int, int)

	private boolean checkShips() {
		boolean allSunk = true;
		if (!checkShipStatus(carrier))
			allSunk = false;
		else
			if (!checkShipStatus(battleship))
				allSunk = false;
			else
				if (!checkShipStatus(cruiser))
					allSunk = false;
				else
					if (!checkShipStatus(submarine))
						allSunk = false;
					else
						if (!checkShipStatus(destroyer))
							allSunk = false;
		return allSunk;
	} // checkShips()

	public boolean checkSunk() {
		boolean sunk = false;
		if (checkShipStatus(carrier) && carrierSunk == false) {
			sunk = true;
			carrierSunk = true;
		}
		else
			if (checkShipStatus(battleship) && battleshipSunk == false) {
				sunk = true;
				battleshipSunk = true;
			}
			else
				if (checkShipStatus(cruiser) && cruiserSunk == false) {
					sunk = true;
					cruiserSunk = true;
				}
				else
					if (checkShipStatus(submarine) && submarineSunk == false) {
						sunk = true;
						submarineSunk = true;
					}
					else
						if (checkShipStatus(destroyer) && destroyerSunk == false) {
							sunk = true;
							destroyerSunk = true;
						}
		return sunk;
	} // checkSunk()

	private boolean checkShipStatus(String[] ship) {
		boolean sunk = true;
		int row;
		int col;
		for (int i = 0; i < ship.length; i += 1) {
			row = getRowNum(ship[i]);
			col = getColNum(ship[i]);
			if (board[row][col] != 'H')
				sunk = false;
		} // for (int i = 0; i < ship.length; i += 1)
		return sunk;
	} // checkShipStatus(String[])

	private void resumeGame() {
		save = new Save();
		rows = save.getRows();
		cols = save.getCols();
		initializeBoard(save.getBoard());
		initializeShips(save.getShips());
		player = save.getPlayer();
	} // resumeGame(int, int, String[][], char[][])

	private void newGame() {
		settings = new Settings();
		rows = settings.getRows();
		cols = settings.getCols();
		initializeBoard(rows, cols);
		initializeShips(settings.getShips());
	} // newGame(int, int, String[][])

	private boolean checkShipOrder(String[] ship) {
		boolean valid = false;
		if (checkShipRow(ship))
			valid = true;
		else
			if (checkShipCol(ship))
				valid = true;
			else
				if (checkShipDiagonalUp(ship))
					valid = true;
				else
					if (checkShipDiagonalDown(ship))
						valid = true;
					else {
						System.out.println("The game file has been corrupted.");
						System.exit(-1);
					} // else
		return valid;
	} // checkShipOrder(String[])

	private boolean checkShipRow(String[] ship) {
		boolean valid = true;
		int i = 0;
		while (i < ship.length - 1 && valid == true) {
			if (getRowNum(ship[i]) == getRowNum(ship[i + 1]))
				if (getColNum(ship[i]) != getColNum(ship[i + 1]) - 1)
					valid = false;
			i += 1;
		} // while
		return valid;
	} // checkShipRow(String[])

	private boolean checkShipCol(String[] ship) {
		boolean valid = true;
		int i = 0;
		while (i < ship.length - 1 && valid == true) {
			if (getColNum(ship[i]) == getColNum(ship[i + 1]))
				if (getRowNum(ship[i]) != getRowNum(ship[i + 1]) - 1)
					valid = false;
			i += 1;
		} // while
		return valid;
	} // checkShipCol(String[])

	private boolean checkShipDiagonalDown(String[] ship) {
		boolean valid = true;
		int i = 0;
		while (i < ship.length - 1 && valid == true)
			if (getColNum(ship[i]) != getColNum(ship[i + 1]) - 1
					&& getRowNum(ship[i]) != getRowNum(ship[i + 1]) - 1)
				valid = false;
		return valid;
	} // checkShipDiagonalDown(String[])

	private boolean checkShipDiagonalUp(String[] ship) {
		boolean valid = true;
		int i = 0;
		while (i < ship.length - 1 && valid == true)
			if (getColNum(ship[i]) != getColNum(ship[i + 1]) - 1
					&& getRowNum(ship[i]) != getRowNum(ship[i - 1]) + 1)
				valid = false;
		return valid;
	} // checkShipDiagonalUp(String[])

	public char play(int row, int col) {
		char status = ' ';
		if (checkHit(row, col)) {
			markHit(row, col);
			status = 'H';
		} // if (checkHit(row, col))
		else
			if (!checkHit(row, col)) {
				markMiss(row, col);
				status = 'M';
			} // if (!checkHit(row, col))
		if (checkGameOver())
			status = 'O';
		lastMoveRow = row;
		lastMoveCol = col;
		return status;
	} // play(String)

	private void markHit(int row, int col) {
		board[row][col] = 'H';
	} // markHit(int, int)

	private void markMiss(int row, int col) {
		board[row][col] = 'M';
	} // markMiss(int, int)

	public void undo() {
		board[lastMoveRow][lastMoveCol] = 'E';
	} // undo() 

	public boolean checkGameOver() {
		boolean gameOver = false;
		if (checkShips())
			gameOver = true;
		return gameOver;
	} // checkGameOver()

	public boolean saveGame() {
		boolean saved = false;
		save = new Save();
		if (save.writeFile(rows, cols, carrier, battleship, cruiser, submarine,
				destroyer, player, board))
			saved = true;
		return saved;
	} // saveGame()

} // BattleshipGame class
