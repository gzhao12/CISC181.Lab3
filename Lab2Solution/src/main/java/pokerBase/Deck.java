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
			deckCards.add(new Card(eSuit.JOKER, eRank.JOKER, 52 + counter));
		}
	}

	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {
		this(NbrOfJokers);

		for (Card c : deckCards) {
			for (Card wild : Wilds) {
				if ((c.geteRank() == wild.geteRank()) && (c.geteSuit() == wild.geteSuit())) {
					c.setbWild(true);
				}
			}
		}
		Collections.shuffle(deckCards);
	}

	public Card Draw() throws DeckException {
		if (deckCards.size() == 0)
			throw new DeckException(this);
		return deckCards.remove(0);
	}

	public ArrayList<Card> getDeckCards() {
		return deckCards;
	}

	public int DeckSize() {
		return deckCards.size();
	}
}
