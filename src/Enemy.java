import java.util.ArrayList;

public class Enemy extends PlayerPerson{
    int id = 0;
    public Enemy(int healthPoints, int conversant, int lassitude, boolean yourTurn) {
        super(healthPoints, conversant, lassitude, yourTurn);
    }

    public void setStart() {
        this.healthPoints = 20;
        this.conversant = 4;
        this.lassitude = 0;
    }
}
