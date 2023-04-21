import java.util.ArrayList;

public class Player extends PlayerPerson{

    int id = 1;
    private int comprehension;//Понимание;

    public Player(int healthPoints, int conversant, int lassitude, boolean yourTurn, int comprehension) {
        super(healthPoints, conversant, lassitude, yourTurn);
        this.comprehension = comprehension;
    }

    public void setStart(){
        this.healthPoints = 20;
        this.conversant = 4;
        this.comprehension = 0;
        this.lassitude = 0;
        this.yourTurn =false;
    }
    public boolean getYourTurn() {
        return yourTurn;
    }
}
