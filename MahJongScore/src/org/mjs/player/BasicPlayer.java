/**
 * 
 */
package org.mjs.player;

import org.mjs.Player;

/**
 * Basic MahJong player
 * @author Jason Wong
 *
 */
public class BasicPlayer implements Player {
	
	private int score = 0;
	
	private final String name;
	
	public BasicPlayer(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.mjs.Player#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see org.mjs.Player#score()
	 */
	@Override
	public int score() {
		return this.score;
	}

	/* (non-Javadoc)
	 * @see org.mjs.Player#score(int)
	 */
	@Override
	public void score(int value) {
		this.score += value;
	}

	public String toString() {
		return String.format("Player [%s], score=%d", this.name, this.score);
	}
}
