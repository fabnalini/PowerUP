package mechanics;

import java.util.ArrayList;
import global.Variables;

public class Hand {
    private static final int HAND_SIZE = 7;

    public static int getHandSize() {
        return HAND_SIZE;
    }

    ArrayList<Card> playerHand = new ArrayList<>(HAND_SIZE);

    public Hand(Deck Deck) {
        while (currentHand() < getHandSize()) {
            playerHand.add(Deck.removeCard());
        }
    }

    public void fillHand(Deck Deck) {
        while (currentHand() < getHandSize()) {
            playerHand.add(Deck.removeCard());
        }
    }

    public void useCard(int userChoice, Variables Global) {
        if (Global.getUsedCards() < 3) {
            playerHand.remove(chosenCard(userChoice));
            Global.setUsedCards(Global.getUsedCards() + 1);
        }
    }

    public Card chosenCard(int userChoice) {
        return playerHand.get(userChoice);
    }

    public int currentHand() {
        return playerHand.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < playerHand.size(); i++) {
            sb.append("(" + (i) + ") ");
            sb.append(playerHand.get(i).getName());

            if (i < playerHand.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
