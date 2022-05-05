package battleshipGame;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

public class BattleshipGame_HelpPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BattleshipGame_HelpPanel() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		JLabel lblColours = new JLabel("Colours:");
		lblColours.setBounds(10, 214, 161, 14);
		lblColours.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblColours);

		JLabel lblWhite = new JLabel("White: Miss");
		lblWhite.setBounds(10, 232, 161, 14);
		lblWhite.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblWhite);

		JLabel lblRed = new JLabel("Red: Hit");
		lblRed.setBounds(10, 250, 161, 14);
		lblRed.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblRed);

		JLabel lblNone = new JLabel("None: Not guessed");
		lblNone.setHorizontalAlignment(SwingConstants.LEFT);
		lblNone.setBounds(10, 266, 161, 14);
		add(lblNone);

		JLabel lblHowToPlay = new JLabel("How to Play:");
		lblHowToPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowToPlay.setBounds(107, 91, 197, 14);
		add(lblHowToPlay);

		JLabel lblInstructions1 = new JLabel("Click on a square to make a guess.");
		lblInstructions1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions1.setBounds(107, 110, 197, 14);
		add(lblInstructions1);

		JLabel lblInstructions2 = new JLabel(
				"Keep guessing until you sink all the ships.");
		lblInstructions2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions2.setBounds(107, 129, 197, 14);
		add(lblInstructions2);

		JLabel lblSaving = new JLabel("Saving:");
		lblSaving.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaving.setBounds(10, 154, 177, 14);
		add(lblSaving);

		JLabel lblSaving2 = new JLabel("To save the game, select ");
		lblSaving2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaving2.setBounds(10, 173, 177, 14);
		add(lblSaving2);

		JLabel lblSaving3 = new JLabel("Save under the Actions menu.");
		lblSaving3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaving3.setBounds(10, 187, 177, 14);
		add(lblSaving3);

		JLabel lblNewGame = new JLabel("Starting a New Game:");
		lblNewGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewGame.setBounds(51, 11, 301, 14);
		add(lblNewGame);

		JLabel lbNewGame2 = new JLabel(
				"To start a new game, select New Game under the Game menu.");
		lbNewGame2.setHorizontalAlignment(SwingConstants.CENTER);
		lbNewGame2.setBounds(51, 25, 301, 14);
		add(lbNewGame2);

		JLabel lblLoadGame = new JLabel("Loading a Save Game:");
		lblLoadGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoadGame.setBounds(51, 53, 300, 14);
		add(lblLoadGame);

		JLabel lblLoadGame2 = new JLabel(
				"To load an old game, select Load Game under the Game menu.");
		lblLoadGame2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoadGame2.setBounds(51, 66, 300, 14);
		add(lblLoadGame2);

		JLabel lblUndo = new JLabel("Undo:");
		lblUndo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUndo.setBounds(292, 154, 143, 14);
		add(lblUndo);

		JLabel lblUndo2 = new JLabel("To undo a move, select Undo ");
		lblUndo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblUndo2.setBounds(292, 166, 143, 14);
		add(lblUndo2);

		JLabel lblUndo3 = new JLabel("under the Actions menu.");
		lblUndo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblUndo3.setBounds(292, 178, 143, 14);
		add(lblUndo3);

		JLabel lblExitGame = new JLabel("Exit Game:");
		lblExitGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblExitGame.setBounds(298, 214, 137, 14);
		add(lblExitGame);

		JLabel lblExit = new JLabel("To exit the game, select Exit");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(298, 230, 137, 14);
		add(lblExit);

		JLabel lblExit2 = new JLabel(" under the ActionsMenu.");
		lblExit2.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit2.setBounds(298, 242, 137, 14);
		add(lblExit2);
	}

}
