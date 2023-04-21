import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Table {
    Player player;
    Enemy enemy;
    private ArrayList<Card> enemyDeck = new ArrayList<Card>();
    private ArrayList<Card> enemyHand = new ArrayList<Card>();
    private ArrayList<Card> enemyTable = new ArrayList<Card>();
    private ArrayList<Card> playerDeck = new ArrayList<Card>();
    private ArrayList<Card> playerHand = new ArrayList<Card>();
    private ArrayList<Card> playerTable = new ArrayList<Card>();

    public Table(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }
    public void createDeck(){
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            String cardName = "goodName" + Integer.toString(i);
            Card card1 = new Card("playerCard" + Integer.toString(i), random.nextInt(5)+1, random.nextInt(5)+1,random.nextInt(5)+1,0,0,0);
            Card card2 = new Card("enemyCard" + Integer.toString(i), random.nextInt(5)+1, random.nextInt(5)+1,random.nextInt(5)+1,0,0,0);
            if(playerDeck.size() < 3){
                this.playerDeck.add(card1);
                this.enemyDeck.add(card2);
            }
        }
    }
    public void startBeforeMatch(Player player, Enemy enemy){
        player.setStart();
        enemy.setStart();
        createDeck();
    }
    public boolean isCardDrawable(PlayerPerson currentPlayer, int cardId){
        if (currentPlayer.getId() == 0) {
            return(currentPlayer.getConversant() >= enemyHand.get(cardId).getManaCost());
        }
        else{
            return(currentPlayer.getConversant() >= playerHand.get(cardId).getManaCost());
        }

    }
    public boolean isCardAttack(PlayerPerson currentPlayer, int cardId) {
        if (currentPlayer.getId() == 0){
            return (enemyTable.get(cardId).isAttack());
        }
        else{
            return (playerTable.get(cardId).isAttack());
        }

    }
    public boolean isCardsAttackable(PlayerPerson currentPlayer, int cardId) {
        boolean target = false;
        if (currentPlayer.getId() == 0) {
            for (Card cardI : playerTable) {
                if (cardI.getTarget()) {
                    target = true;
                }
                if(cardId != 100){
                    if (cardI == playerTable.get(cardId)) {
                        return (true);
                    }
                }
            }
            if (!target) {
                return (true);
            }
            else {
                return (false);
            }
        }
        else {
            for (Card cardI : enemyTable) {
                if (cardI.getTarget()) {
                    target = true;
                }
                if(cardId != 100){
                    if (cardI == enemyTable.get(cardId)) {
                        return (true);
                    }
                }
            }
            if (!target) {
                return (true);
            } else {
                return (false);
            }
        }
    }
    public void takeCardFromDeck(PlayerPerson currentPlayer){
        if (currentPlayer.getId() == 0){
            if (enemyDeck.isEmpty()){
                enemyHand.add(enemyDeck.remove(enemyDeck.size()-1));
            }
            else{
                enemyHand.add(enemyDeck.remove(enemyDeck.size()-1));
                currentPlayer.setLassitude(currentPlayer.getLassitude()+1);
            }
        }
        else{
            if (enemyDeck.isEmpty()){
                playerHand.add(playerDeck.remove(playerDeck.size()-1));
            }
            else{
                playerHand.add(playerDeck.remove(playerDeck.size()-1));
                currentPlayer.setLassitude(currentPlayer.getLassitude()+1);
            }
        }
    }
    public void playCardFromHand(PlayerPerson currentPlayer, int cardId){
        if (currentPlayer.getId() == 0){
            enemyHand.get(cardId).setFromHand(true);
            enemyTable.add(enemyHand.remove(cardId));
        }
        else{
            playerHand.get(cardId).setFromHand(true);
            playerTable.add(playerHand.remove(cardId));
        }
    }
    public int pickPlayableCard(PlayerPerson currentPlayer){
        int i;
        Scanner console = new Scanner(System.in);
        System.out.println("Input attacking num between 0 and ");
        if (currentPlayer.getId() == 1){
            System.out.println(this.enemyHand.size()-1);
        }
        else{
            System.out.println(this.playerHand.size()-1);
        }
        System.out.println(" or 100 to attack person");
        i = console.nextInt();
        while(!isCardDrawable(currentPlayer, i)){
            System.out.println("Wrong num input again");
            i = console.nextInt();
        }
        return (i);
    }
    public int pickAttackingCard(PlayerPerson currentPlayer){
        int i;
        Scanner console = new Scanner(System.in);
        System.out.println("Input attacking num between 0 and ");
        if (currentPlayer.getId() == 1){
            System.out.println(this.enemyTable.size()-1);
        }
        else{
            System.out.println(this.playerTable.size()-1);
        }
        i = console.nextInt();
        while(!isCardAttack(currentPlayer,i)){
            System.out.println("Wrong num input again");
            i = console.nextInt();
        }
        return (i);
        }
    public int pickAttackedCard(PlayerPerson currentPlayer){
        int i;
        Scanner console = new Scanner(System.in);
        System.out.println("Input attacked num between 0 and ");
        if (currentPlayer.getId() == 1){
            System.out.println(this.playerTable.size()-1);
        }
        else{
            System.out.println(this.enemyTable.size()-1);
        }
        System.out.println(" or 100 to attack person");
        i = console.nextInt();
        while (!isCardsAttackable(currentPlayer,i)){
            System.out.println("Wrong num input again");
            i = console.nextInt();
        }
        return (i);
    }
    public void checkDiedAll(){
        for (Card cardI:enemyTable) {
            if(cardI.isAlive()){
                enemyTable.remove(cardI);
            }
        }
        for (Card cardI:playerTable) {
            if(cardI.isAlive()){
                enemyTable.remove(cardI);
            }
        }
    }
    public void attack(PlayerPerson currentPlayer, int attackingId, int attackedId){

        if (currentPlayer.getId() == 0){
            if(attackedId == 100){
                player.setHealthPoints( player.getHealthPoints() - enemyTable.get(attackingId).getDamage() );
            }
            else{
                playerTable.get(attackedId).setHealthPoints(playerTable.get(attackedId).getHealthPoints() - enemyTable.get(attackingId).getDamage());
            }
            enemyTable.get(attackingId).setOnCooldown(true);
            }
        else {
            if(attackedId == 100){
                enemy.setHealthPoints( enemy.getHealthPoints() - playerTable.get(attackingId).getDamage() );
            }
            else{
                enemyTable.get(attackedId).setHealthPoints(enemyTable.get(attackedId).getHealthPoints() - playerTable.get(attackingId).getDamage());
            }
            playerTable.get(attackingId).setOnCooldown(true);
            }
    }
    public void turn(PlayerPerson currentPlayer){
        boolean endOfTurn = false;
        int action;
        takeCardFromDeck(currentPlayer);
        while(!endOfTurn){
            Scanner console = new Scanner(System.in);
            System.out.println("Input num between 0 and 2 (0 to end turn. 1 to play card from hand. 2 to attack card)");
            action = console.nextInt();
            if(action == 0){
                endOfTurn = true;
            }
            if(action == 1){
                playCardFromHand(currentPlayer, pickPlayableCard(currentPlayer));
            }
            if(action == 2){
                attack(currentPlayer,pickAttackingCard(currentPlayer),pickAttackedCard(currentPlayer));
                checkDiedAll();
            }
        }
        checkDiedAll();
        if(currentPlayer.getId() == 1){
            for (Card cardI:enemyTable) {
                cardI.setOnCooldown(false);
                cardI.incTurnCounter();
            }
        }
        else {
            for (Card cardI : playerTable) {
                cardI.setOnCooldown(false);
                cardI.incTurnCounter();
            }
        }
        currentPlayer.setConversant(currentPlayer.getConversant() + 3);
    }
}
