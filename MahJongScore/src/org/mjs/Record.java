/**
 * 
 */
package org.mjs;

/**
 * Mah-Jong record
 * @author Jason Wong
 *
 */
public interface Record {

	/**
	 * Return the number of "Fan" of this MahJong record.
	 * @return
	 */
	int getFan();
	
	/**
	 * Return the winner of this record.
	 * @return
	 */
	Player winner();
	
	/**
	 * Return the player who perform discard this round.
	 * @return
	 */
	Player discard();
	
	/**
	 * Report this record is valid according to the minimum "Fan" and max "Fan" provided.
	 * @param minFan The minimum "Fan" of a game.
	 * @param maxFan The maximum "Fan" of a game.
	 * @return true if the record is within the min and max fan and valid setting. False otherwise.
	 */
	boolean isValid(int minFan, int maxFan);
}
