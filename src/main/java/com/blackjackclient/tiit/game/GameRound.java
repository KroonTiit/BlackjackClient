package com.blackjackclient.tiit.game;

public class GameRound {
	
	private Hand dealersHand;
	private Hand playersHand;
	private int action;
	
	public GameRound() {}
	public GameRound(Hand dealersHand, Hand playersHand) {
		this.playersHand=playersHand;
		this.dealersHand=dealersHand;
	}
	public Hand getDealersHand() {
		return dealersHand;
	}
	public void setDealersHand(Hand dealersHand) {
		this.dealersHand = dealersHand;
	}
	public Hand getPlayersHand() {
		return playersHand;
	}
	public void setPlayersHand(Hand playersHand) {
		this.playersHand = playersHand;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
}
