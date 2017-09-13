package com.blackjackclient.tiit.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blackjackclient.tiit.cards.Card;
import com.blackjackclient.tiit.player.Player;

public class Hand {
	private Player player;
	private Card[] hand= new Card[10];
	private int numCards;
	private int handSum;
	
	public Hand() {}
	
	public int getNumCards() {
		return numCards;
	}
	public void setNumCards(int numCards) {
		this.numCards = numCards;
	}
	public Hand(Player player) {
		this.player=player;
	}
	
	public void printHand(boolean showFirstCard) {
		System.out.printf("%s kaardid:\n", this.player.getName());
		for(int c = 0; c < this.numCards; c++) {
			if(c == 0 && !showFirstCard){
				System.out.println(" [peidetud]");
			} else {
				System.out.printf(" %s\n", this.hand[c].toString());
			}
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	public Card[] getHand() {
		return hand;
	}
	public void setHand(Card[] hand) {
		this.hand = hand;
	}

	public int getHandSum() {
		return handSum;
	}

	public void setHandSum(int handSum) {
		this.handSum = handSum;
	}
}
