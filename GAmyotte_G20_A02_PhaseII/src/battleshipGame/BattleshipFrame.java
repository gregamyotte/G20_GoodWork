package battleshipGame;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class BattleshipFrame extends JFrame implements ActionListener {

	private static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'Z', 'Y', 'Z' };
	private static final int[] NUMBERS = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
			13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 };
	private BattleshipGame game;
	private String player;
	private JButton[][] boardButton;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu optionsMenu;
	private JMenu ActionsMenu;
	private JMenu gameMenu;
	private JMenuItem saveMenuItem;
	private JMenuItem undoMenuItem;
	private JMenuItem exitMenuItem;
	private JMenuItem aboutMenuItem;
	private JMenuItem newGameMenuItem;
	private JMenuItem loadGameMenuItem;
	private JMenuItem helpMenuItem;
	private JPanel boardPanel;
	private char lastAction;
	private int lastGuessCol;
	private int lastGuessRow;
	private boolean isNew;

	/**
	 * Create the frame.
	 */
	public BattleshipFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		gameMenu = new JMenu("Game");
		menuBar.add(gameMenu);

		newGameMenuItem = new JMenuItem("New Game");
		gameMenu.add(newGameMenuItem);

		loadGameMenuItem = new JMenuItem("Load Game");
		gameMenu.add(loadGameMenuItem);
		loadGameMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadGameMenuItem_actionPerformed();
			}
		});
		newGameMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGameMenuItem_actionPerformed();
			}
		});

		optionsMenu = new JMenu("Options");
		menuBar.add(optionsMenu);

		helpMenuItem = new JMenuItem("Help");
		helpMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpMenuItem_actionPerformed();
			}
		});
		optionsMenu.add(helpMenuItem);

		aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutMenuItem_actionPerformed();
			}
		});
		optionsMenu.add(aboutMenuItem);

		ActionsMenu = new JMenu("Actions");
		menuBar.add(ActionsMenu);

		saveMenuItem = new JMenuItem("Save");
		ActionsMenu.add(saveMenuItem);

		undoMenuItem = new JMenuItem("Undo");
		undoMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undoMenuItem_actionPerformed();
			}
		});
		ActionsMenu.add(undoMenuItem);

		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitMenuItem_actionPerformed();
			}
		});
		ActionsMenu.add(exitMenuItem);
		saveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveMenuItem_actionPerformed();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		boardPanel = new JPanel();
		contentPane.add(boardPanel, BorderLayout.CENTER);
	} //BattleshipFrame()

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleshipFrame frame = new BattleshipFrame();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // main()

	public void actionPerformed(ActionEvent e) {
		for (int row = 0; row < boardButton.length; row += 1) {
			for (int col = 0; col < boardButton[row].length; col += 1) {
				if (e.getSource() == boardButton[row][col]) {
					char status = game.play(row, col);
					if (status != 'O')
						changeSquare(row, col, status);
					if (status == 'O') {
						int again = JOptionPane.showConfirmDialog(this,
								"Congatulation " + player
										+ "! You've won this game! Would you like to play again?",
								"Game Over", JOptionPane.YES_NO_OPTION);
						if (again == 0) {
							game = new BattleshipGame(true);
							initializeBoard();
						} // if (again == 0)
						else
							System.exit(0);
					} // if (status == 'O')
					else
						if (game.checkSunk())
							if (isNew == true)
								JOptionPane.showMessageDialog(this,
										"Congratulations, " + player + "! You've sunk a ship!");
					isNew = true;
					lastGuessCol = col;
					lastGuessRow = row;
					lastAction = 'G';
					break;
				} // if (e.getSource() == boardButton[row][col])
			} // for (int col = 0; col < boardButton[row].length; col += 1)
		} // for (int row = 0; row < boardButton.length; row += 1)
	} // actionPerformed(ActionEvent)

	private void clearBoard() {
		boardPanel.removeAll();
		boardButton = null;
	} // clearBoard()

	private void initializeBoard() {
		if (boardButton != null)
			clearBoard();
		boardPanel.setLayout(new GridLayout(game.getRows() + 1, game.getCols()));
		boardButton = new JButton[game.getRows()][game.getCols()];
		char[][] board = game.getBoard();
		if (board.length == boardButton.length
				&& board[0].length == boardButton[0].length) {
			for (int row = game.getRows() - 1; row >= 0; row -= 1) {
				showRows(row);
				for (int col = 0; col < boardButton[row].length; col += 1) {
					if (board[row][col] == 'E')
						boardButton[row][col] = new JButton("Empty");
					else
						if (board[row][col] == 'M') {
							boardButton[row][col] = new JButton("Miss");
							boardButton[row][col].setBackground(Color.WHITE);
							boardButton[row][col].setEnabled(false);
						} // if (board[row][col] == 'M')
						else {
							boardButton[row][col] = new JButton("Hit");
							boardButton[row][col].setEnabled(false);
							boardButton[row][col].setBackground(Color.RED);
							boardButton[row][col].setForeground(Color.BLACK);
						} // else
					boardPanel.add(boardButton[row][col]);
					boardButton[row][col].addActionListener(this);
				} // for (int col = 0; col < boardButton[row].length; col += 1 )
			} // for (int row = 0; row < boardButton.length; row += 1)
			showCols();
			revalidate();
			repaint();
		} // if (board.length == boardButton.length && board[0].length == boardButton[0].length)
	} // initializeBoard()

	private void showRows(int row) {
		boardPanel.add(new JTextArea(String.format("\n\n%20d", NUMBERS[row])));
	} // showRows()

	private void showCols() {
		boardPanel.add(new JTextArea());
		for (int i = 0; i < game.getCols(); i += 1)
			boardPanel.add(new JTextArea(String.format("\n%16s", ALPHABET[i])));
	} // showCols()

	public void changeSquare(int x, int y, char status) {
		if (status == 'H') {
			boardButton[x][y].setEnabled(false);
			boardButton[x][y].setBackground(Color.RED);
			boardButton[x][y].setText("Hit");
		} // if (status == 'H')
		else
			if (status == 'M') {
				boardButton[x][y].setEnabled(false);
				boardButton[x][y].setBackground(Color.WHITE);
				boardButton[x][y].setText("Miss");
			} // if (status == 'M')
			else {
				boardButton[x][y].setEnabled(true);
				boardButton[x][y].setBackground(null);
				boardButton[x][y].setText("Empty");
			} // else
	} // displayButton()

	private void newGameMenuItem_actionPerformed() {
		if (game == null) {
			player = JOptionPane.showInputDialog(this, "Please enter your name",
					"Player name", JOptionPane.PLAIN_MESSAGE);
			if (player != null) {
				game = new BattleshipGame(true);
				initializeBoard();
				isNew = true;
			} // if (player != null)
		} // if (game == null)
		else {
			int confirm = JOptionPane.showConfirmDialog(this,
					"Are you sure you want to start a new game? This will end the current game and all unsaved progress will be lost.",
					"Start New Game?", JOptionPane.YES_NO_OPTION);
			if (confirm == 0) {
				player = JOptionPane.showInputDialog(this, "Please enter your name",
						"Player name", JOptionPane.PLAIN_MESSAGE);
				if (player != null) {
					game = new BattleshipGame(true);
					initializeBoard();
					isNew = true;
				} // if (player != null)
			} // if (confirm == 0)
		} // else		
	} // newGameMenuItem_actionPerformed()

	private void loadGameMenuItem_actionPerformed() {
		if (game == null) {
			game = new BattleshipGame(false);
			player = game.getPlayer();
			initializeBoard();
			isNew = false;
		} // if (game == null)
		else {
			int confirm = JOptionPane.showConfirmDialog(this,
					"Are you sure you want to load the saved game? This will end the current game and all progress will be lost.",
					"Load Game?", JOptionPane.YES_NO_OPTION);
			if (confirm == 0) {
				game = new BattleshipGame(false);
				player = game.getPlayer();
				initializeBoard();
				isNew = false;
			} // if (confirm == 0)
		} // else
	} // loadGameMenuItem_actionPerformed()

	private void saveMenuItem_actionPerformed() {
		game.setPlayer(player);
		if (game.saveGame())
			JOptionPane.showMessageDialog(this, "Game saved successfully.",
					"Game Saved", JOptionPane.PLAIN_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, "Game could not be saved.",
					"Save Failed", JOptionPane.PLAIN_MESSAGE);
	} // saveMenuItem_actionPerformed()

	private void undoMenuItem_actionPerformed() {
		if (lastAction == 0)
			JOptionPane.showMessageDialog(this,
					"You must make a guess before you can undo.", "No Action Taken",
					JOptionPane.PLAIN_MESSAGE);
		else
			if (lastAction == 'G') {
				game.undo();
				changeSquare(lastGuessRow, lastGuessCol, 'E');
				lastAction = 'U';
			} // if (lastAction != 'U')
			else
				JOptionPane.showMessageDialog(this, "Cannot undo twice in a row.",
						"Invalid Move", JOptionPane.PLAIN_MESSAGE);
	} // undoMenuItem_actionPerformed()

	private void exitMenuItem_actionPerformed() {
		int save = JOptionPane.showConfirmDialog(this,
				"Would you like to save before exiting the game?", "Exit Game?",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (save == 0) {
			game.saveGame();
			System.exit(0);
		}
		else
			if (save == 1)
				System.exit(0);
	} // exitMenuItem_actionPerformed()

	private void aboutMenuItem_actionPerformed() {
		JOptionPane.showMessageDialog(this, new BattleshipGame_AboutPanel(),
				"About", JOptionPane.PLAIN_MESSAGE);
	} // aboutMenuItem_actionPerformed()

	private void helpMenuItem_actionPerformed() {
		JPanel helpPanel = new BattleshipGame_HelpPanel();
		helpPanel.setPreferredSize(new Dimension(451, 303));
		JOptionPane.showMessageDialog(this, helpPanel, "Help",
				JOptionPane.PLAIN_MESSAGE);
	} // helpMenuItem_actionPerformed()
} // BattleshipFrame class
