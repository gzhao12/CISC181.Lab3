package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerExceptions.DeckException;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Deck {

	private ArrayList<Card> deckCards = new ArrayList<Card>();

	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				if ((eSuit != pokerEnums.eSuit.JOKER) && (eRank != pokerEnums.eRank.JOKER)) {
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
				}
			}

		}
		Collections.shuffle(deckCards);
	}

	public Deck(int NbrOfJokers) {
		this();
		for (int counter = 1; counter <= NbrOfJokers; counter++) {
			deckCards.add(new Card (eSuit.JOKER, eRank.JOKER, 52 + counter));
		}
	}

	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {
		for (Card c : deckCards) {
			for (Card Wild : Wilds) {
				if ((c.geteRank() == Wild.geteRank()) && (c.geteSuit() == Wild.geteSuit())) {
					c.setbWild(true);
				}
			}
		}
	}

	public Card Draw() throws Exception{
		if (deckCards.size() == 0) 
			throw new DeckException(this);
		return deckCards.remove(0);
	}

	public ArrayList<Card> getDeckCards() {
		return deckCards;
	}
}
