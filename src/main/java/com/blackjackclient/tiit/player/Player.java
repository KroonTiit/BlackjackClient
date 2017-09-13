package com.blackjackclient.tiit.player;


public class Player {
	private	long id;
	private int cash;
	private String name;
	private int bet;
	
	public Player() {}
	
	public Player(long id,String name, int cash) {
		this.id=id;
		this.name=name;
		this.cash=cash;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public long getId() {
		return id;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}
}

