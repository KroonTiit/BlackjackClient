package com.blackjackclient.tiit.cards;

public class Card {
	private Suit suit;
	private int value;
	
	public Card() {}
	public Card(Suit suit, int value) {
		this.setSuit(suit);
		this.setValue(value);
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String toString(){
		String nrString= "Error";
		
		if(((this.value >= 11) || (this.value < 2) && this.value != 0) ) {
			switch(this.value) {
			case 1:
				nrString="Äss";
				break;
			case 11:
				nrString="Poiss";
				break;
			case 12:
				nrString="Emand";
				break;
			case 13:
				nrString="Kuningas";
				break;
			}
		} else {
			nrString=Integer.toString(this.value);
		}
		return suit.toString()+" "+nrString;
		
	}
}
