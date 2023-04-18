import java.util.ArrayList;

public class Card {
    private String name;
    private int healthPoints;
    private int damage;
    private int manaCost;
    private int turnCounter = 0;
    private boolean fromHand = false;
    private boolean alive = true;
    private boolean target = false;
    private int modificatorId;
    private int sigilId;
    private int effectId;
    public boolean getFromHand() {
        return fromHand;
    }
    public void setFromHand(boolean fromHand) {
        this.fromHand = fromHand;
    }
    public boolean getAlive() {
        if (this.healthPoints <= 0){
            this.alive = false;
        }
        return alive;
    }
    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDamage() {
        return damage;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public boolean getTarget() {
        return target;
    }
    public void setTarget(boolean target) {
        this.target = target;
    }

    public int getModificatorId() {
        return modificatorId;
    }

    public Card(String name, int healthPoints, int damage, int manaCost, int modificatorId, int sigilId, int effectId) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.manaCost = manaCost;
        this.modificatorId = modificatorId;
        this.sigilId = sigilId;
        this.effectId = effectId;
    }
}
