import java.util.ArrayList;

public class Table {
    private ArrayList<Card> enemyDeck = new ArrayList<Card>();
    private ArrayList<Card> enemyHand = new ArrayList<Card>();
    private ArrayList<Card> enemyTable = new ArrayList<Card>();
    private ArrayList<Card> playerDeck = new ArrayList<Card>();
    private ArrayList<Card> playerHand = new ArrayList<Card>();
    private ArrayList<Card> playerTable = new ArrayList<Card>();

    public ArrayList<Card> getEnemyDeck() {
        return enemyDeck;
    }

    public ArrayList<Card> getEnemyHand() {
        return enemyHand;
    }

    public ArrayList<Card> getEnemyTable() {
        return enemyTable;
    }

    public ArrayList<Card> getPlayerDeck() {
        return playerDeck;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getPlayerTable() {
        return playerTable;
    }
}
