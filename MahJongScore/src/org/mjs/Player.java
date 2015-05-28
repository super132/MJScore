/**
 * 
 */
package org.mjs;

/**
 * The player object represent a mah-jong player.
 * @author Jason Wong
 *
 */
public interface Player {

	/**
	 * The name of the player
	 * @return
	 */
	String getName();
	
	/**
	 * The total score of a player.
	 * @return
	 */
	int score();
	
	/**
	 * Adding values to player's score, either +ve or -ve value
	 * @param value The score to add to the player score.
	 */
	void score(int value);
	
	Player NO_PLAYER = new Player() {

		@Override
		public String getName() {
			return "NO_PLAYER";
		}

		@Override
		public int score() {
			throw new UnsupportedOperationException("Cannot obtain score of NO_PLAYER");
		}

		@Override
		public void score(int value) {
			throw new UnsupportedOperationException("Cannot change score to NO_PLAYER");
		}
		
	};
}
