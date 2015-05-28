/**
 * 
 */
package org.mjs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.mjs.game.HKGame;
import org.mjs.player.BasicPlayer;
import org.mjs.record.BasicRecord;

/**
 * @author hcsrxo6
 *
 */
public class MJCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, Integer> fansTable = new HashMap<Integer, Integer>();
		fansTable.put(3, 4);
		fansTable.put(4, 8);
		fansTable.put(5, 16);
		fansTable.put(6, 32);
		fansTable.put(7, 48);
		fansTable.put(8, 64);
		
		Player player1 = new BasicPlayer("Player 1");
		Player player2 = new BasicPlayer("Player 2");
		Player player3 = new BasicPlayer("Player 3");
		Player player4 = new BasicPlayer("Player 4");
		
		Game newGame = new HKGame(
			Arrays.asList(
				player1,
				player2,
				player3,
				player4
				),
			fansTable
		);
		
		newGame.addRecord(new BasicRecord(3, player1, player4));
		newGame.addRecord(new BasicRecord(8, player2, Player.NO_PLAYER));
		newGame.addRecord(new BasicRecord(4, player2, player3));
		newGame.addRecord(new BasicRecord(10, player3, Player.NO_PLAYER));
		
		System.out.println(newGame.win().toString());
		System.out.println(newGame.lose().toString());
		System.out.println(newGame.win().toString());
		
		for (Record record : newGame.getRecords()) {
			System.out.println(record.toString());
		}
	}

}
