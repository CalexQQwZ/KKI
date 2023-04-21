public class GameLoop {
    public void match(){
        Player player = new Player(30,4,0,false,0);
        Enemy enemy = new Enemy(30,4,0,false);
        GameLogic gameLogic = new GameLogic();
        Table table = new Table(player, enemy);
        table.startBeforeMatch(player, enemy);
        while( player.getHealthPoints() > 0 && enemy.getHealthPoints() > 0 ){
            table.turn(player);
            table.turn(enemy);
        }
    }
}
