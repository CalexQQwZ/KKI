import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic {
    private int turnCount;

    private ArrayList<Card> playerCanBeAttacked = new ArrayList<Card>();
    private ArrayList<Card> enemyCanBeAttacked = new ArrayList<Card>();
    private ArrayList<Card> available = new ArrayList<Card>();
    private int modificatorsId;
    private Card newCardOnTable;
    private int nextPlusHealthPoint;
    private Table table;


    private void turn(ArrayList<Card> CanBeAttacked, ArrayList<Card> table, ArrayList<Card> hand, ArrayList<Card> deck){
        boolean endTurn = false;
        int action = 3;
        while (endTurn != true){
            Scanner console = new Scanner(System.in);
            System.out.println("Input num between 0 and 2 (0 to end turn 1 to play card from hand 2 to attack card)");
            action = console.nextInt();
            if (action == 0){
                endTurn = false;
                checkDied();
                checkCanBeAttackedByEnemy();
                checkCanBeAttackedByPlayer();
            }
            if (action == 1){
                takeCardFromTO(hand,table);
                checkDied();
                checkCanBeAttackedByEnemy();
                checkCanBeAttackedByPlayer();
            }
            if (action == 2){
                checkAvailable(table);
                attack(this.available,CanBeAttacked);
                checkDied();
                checkCanBeAttackedByEnemy();
                checkCanBeAttackedByPlayer();
            }
        }

    }
    private void checkAvailable(ArrayList<Card> yourTable){
        for (Card cardI:yourTable) {
            if (cardI.getTurnCounter() > 0){
                this.available.add(cardI);
            }
        }
    }
    private void attack(ArrayList<Card> yourTableAvailable, ArrayList<Card> canBeAttacked){
        damage( pickYourCard(yourTableAvailable) , pickAttackedCard(canBeAttacked) );

    }
    private Card pickYourCard(ArrayList<Card> yourTableAvailable){
        int i;
        Scanner console = new Scanner(System.in);
        System.out.println("Input num between 0 and ");
        System.out.println(yourTableAvailable.size()-1);
        i = console.nextInt();
        return (yourTableAvailable.get(i));
    }
    private Card pickAttackedCard(ArrayList<Card> CanBeAttacked){
        int i;
        Scanner console = new Scanner(System.in);
        System.out.println("Input num between 0 and ");
        System.out.println(CanBeAttacked.size()-1);
        i = console.nextInt();
        return (CanBeAttacked.get(i));
    }
    private void damage(Card picked, Card attacked){
        attacked.setHealthPoints(attacked.getHealthPoints() - picked.getDamage());
        attacked.getAlive();
        }
    private void checkCanBeAttackedByPlayer(){
        this.enemyCanBeAttacked.clear();
        for (Card cardI:this.table.getPlayerTable()) {
            if (cardI.getTarget() == true){
                this.enemyCanBeAttacked.add(cardI);
            }
        }
        if (this.enemyCanBeAttacked.isEmpty() == true){
            this.enemyCanBeAttacked.addAll(this.table.getPlayerTable());
        }
    }
    private void checkCanBeAttackedByEnemy(){
        this.playerCanBeAttacked.clear();
        for (Card cardI:this.table.getEnemyTable()) {
            if (cardI.getTarget() == true){
                this.playerCanBeAttacked.add(cardI);
            }
        }
        if (this.playerCanBeAttacked.isEmpty() == true){
            this.playerCanBeAttacked.addAll(this.table.getEnemyTable());
        }
    }
    private void checkDied(){
        for (Card cardI:this.table.getPlayerTable()) {
            cardI.getAlive();
        }
        for (Card cardI:this.table.getEnemyTable()) {
            cardI.getAlive();
        }
    }
    private void takeCardFromTO(ArrayList<Card> from, ArrayList<Card> to){
        to.add(newCardOnTable = from.remove(from.size()-1));
        if ( (from == this.table.getPlayerHand() && to == this.table.getPlayerDeck()) || (from == this.table.getEnemyHand() && to == this.table.getEnemyDeck()) ){
            newCardOnTable.setFromHand(true);////Проверка моей отбитости ничего не помню надо проверять себя
            if (newCardOnTable.getFromHand() != to.get(to.size()-1).getFromHand()){
                System.exit(1488);
            }
        }
    }

   /* private void CardModificatorsCheck(ArrayList<Card> deck,ArrayList<Card> hand,ArrayList<Card> table, Card card ){
        switch(card.getModificatorId()){
            case (1):
                if (card.getFromHand() == true){
                    card.goeffect;
                };
                break;
            case (2):
                if (card.getAlive() == false){
                    card.goeffect;
                };
                break;
            case (3):
                card.setTarget(true);
                break;
            case (4):
                if (playerDeck.size() < 10){
                    card.goeffect;
                };
                break;
            case (5):
                for (Card cardI :table) {
                    if (cardI.getModificatorId() == 5 && cardI.getTurnCounter() == 0){
                        card.goeffect;
                    };
                };
                break;
            case (6):
                nextPlusHealthPoint = card.getManaCost();
                break;
            case (7):

                break;


        }
    }*/
}
