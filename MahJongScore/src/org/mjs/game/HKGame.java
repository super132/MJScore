/**
 * 
 */
package org.mjs.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.mjs.Game;
import org.mjs.Player;
import org.mjs.Record;

/**
 * The Hong Kong MahJong Game object
 * @author Jason Wong
 *
 */
public class HKGame implements Game {

	private final List<Player> gamePlayers = new ArrayList<Player>();
	
	/**
	 * The "Fan" table stores fan to self-pick scores. I.e., the score a player should player to the winner.
	 */
	private final Map<Integer, Integer> fansTable;
	
	private final Queue<Record> records = new LinkedList<Record>();
	
	private final List<Record> processedRecords = new ArrayList<Record>();
	
	public HKGame (List<Player> players, Map<Integer, Integer> fans) {
		this.gamePlayers.addAll(players);
		this.fansTable = new TreeMap<Integer, Integer>(fans);
	}
	
	/* (non-Javadoc)
	 * @see org.mjs.Game#win()
	 */
	@Override
	public Player win() {
		this.calculateScores();
		int max = Integer.MIN_VALUE;
		Player winner = Player.NO_PLAYER;
		for (Player player : this.gamePlayers) {
			if (player.score() > max) {
				max = player.score();
				winner = player;
			}
		}
		return winner;
	}

	/* (non-Javadoc)
	 * @see org.mjs.Game#lose()
	 */
	@Override
	public Player lose() {
		this.calculateScores();
		int min = Integer.MAX_VALUE;
		Player loser = Player.NO_PLAYER;
		for (Player player : this.gamePlayers) {
			if (player.score() < min) {
				min = player.score();
				loser = player;
			}
		}
		return loser;
	}

	/* (non-Javadoc)
	 * @see org.mjs.Game#addRecord(org.mjs.Record)
	 */
	@Override
	public void addRecord(Record record) {
		this.records.add(record);
	}

	/* (non-Javadoc)
	 * @see org.mjs.Game#getPlayers()
	 */
	@Override
	public List<Player> getPlayers() {
		return Collections.unmodifiableList(this.gamePlayers);
	}
	
	private void calculateScores() {
		while (!this.records.isEmpty()) {
			Record record = records.poll();
			int fan = record.getFan();
			if (this.fansTable.containsKey(fan) && record.isValid(Collections.min(this.fansTable.keySet()), Collections.max(this.fansTable.keySet()))) {
				int winScore = this.fansTable.get(fan);
				Player discardPlayer = record.discard();
				if (discardPlayer.equals(Player.NO_PLAYER)) {
					for (Player player : this.gamePlayers) {
						player.score(-winScore);
					}
					record.winner().score(winScore * this.gamePlayers.size());
				} else {
					discardPlayer.score(-winScore * 2);
					record.winner().score(winScore * 2); 
				}
				this.processedRecords.add(record);
			}
		}
	}

	@Override
	public List<Record> getRecords() {
		List<Record> result = new ArrayList<Record>();
		result.addAll(this.processedRecords);
		result.addAll(this.records);
		return result;
	}

}
