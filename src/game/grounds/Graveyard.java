package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.actors.enemies.HollowSoldier;
import game.actors.enemies.WanderingUndead;
import game.gamemaps.AbandonedVillage;
import game.gamemaps.BurialGround;
import java.util.List;
import java.util.Random;

public class Graveyard extends Ground {

  private final Random random = new Random();

  public Graveyard() {
    super('n');
  }

  @Override
  public void tick(Location location) {
    int num = random.nextInt(4);
    if (num == 0) {
      Location spawnLocation = validLocation(location);
      if (spawnLocation != null){
        spawnLocation.addActor(validEnemy(location));
      }
    }
  }

  private Location validLocation(Location location){
    if (!location.containsAnActor()){
      return location;
    }
    else {
      List<Exit> exits = location.getExits();
      for (Exit exit: exits){
        if (!exit.getDestination().containsAnActor()){
          return exit.getDestination();
        }
      }
      return null;
    }
  }

  private Enemy validEnemy(Location location){
    if (location.map() instanceof AbandonedVillage){
      return new WanderingUndead();
    } else if (location.map() instanceof BurialGround) {
      return new HollowSoldier();

    }
    return null;
  }
}
