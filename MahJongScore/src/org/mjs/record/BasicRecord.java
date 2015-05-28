/**
 * 
 */
package org.mjs.record;

import org.mjs.Player;
import org.mjs.Record;

/**
 * Basic Mah-Jong Record
 * @author Jason Wong
 *
 */
public class BasicRecord implements Record {

	private final int fan;
	
	private final Player winner;
	
	private final Player discardPlayer;
	
	public BasicRecord(final int fan, final Player winner, final Player discardPlayer) {
		this.fan = fan;
		this.winner = winner;
		this.discardPlayer = discardPlayer;
	}
	
	/* (non-Javadoc)
	 * @see org.mjs.Record#getFan()
	 */
	@Override
	public int getFan() {
		return this.fan;
	}

	/* (non-Javadoc)
	 * @see org.mjs.Record#winner()
	 */
	@Override
	public Player winner() {
		return this.winner;
	}

	/* (non-Javadoc)
	 * @see org.mjs.Record#discard()
	 */
	@Override
	public Player discard() {
		return this.discardPlayer;
	}

	public String toString() {
		return String.format("Winner %s wins with fan %d, with %s discard", this.winner.getName(), this.fan, this.discardPlayer.getName());
	}

	@Override
	public boolean isValid(final int minFan, final int maxFan) {
		boolean result = true;
		if (this.winner.equals(Player.NO_PLAYER)) {
			result = false;
		}
		if (this.fan < minFan || this.fan > maxFan) {
			result = false;
		}
		return result;
	}
}
