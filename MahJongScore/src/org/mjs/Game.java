/**
 * 
 */
package org.mjs;

import java.util.List;

/**
 * Mah-Jong record object.
 * 
 * @author Jason Wong
 */
public interface Game {
	
	/**
	 * Return the player who win in this round.
	 * @return
	 */
	Player win();

	/**
	 * Return the player with the least score.
	 * @return
	 */
	Player lose();
	
	/**
	 * Add a record to the current game.
	 * @param record
	 */
	void addRecord(Record record);
	
	/**
	 * Return all players of this game.
	 * @return The players of this game. Maximum number of players returned is 4 and minimum is 2.
	 */
	List<Player> getPlayers();
	
	/**
	 * Return all the records in the game.
	 * @return
	 */
	List<Record> getRecords();
}
