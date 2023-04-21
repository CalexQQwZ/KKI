public class PlayerPerson {
    protected int id;
    protected int healthPoints;
    protected int conversant;//Осознание;
    protected int lassitude;//Усталость;
    protected boolean yourTurn;

    public PlayerPerson(int healthPoints, int conversant, int lassitude, boolean yourTurn) {
        this.healthPoints = healthPoints;
        this.conversant = conversant;
        this.lassitude = lassitude;
        this.yourTurn = yourTurn;
    }

    public int getId() {
        return id;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public int getConversant() {
        return conversant;
    }
    public void setConversant(int conversant) {
        this.conversant = conversant;
    }
    public int getLassitude() {
        return lassitude;
    }
    public void setLassitude(int lassitude) {
        this.lassitude = lassitude;
    }
    public boolean isYourTurn() {
        return yourTurn;
    }
    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }
}
