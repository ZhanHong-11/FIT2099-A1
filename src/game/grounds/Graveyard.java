package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.WanderingUndead;
import java.util.Random;

public class Graveyard extends Ground {
  private final Random random = new Random();

  public Graveyard() {
    super('n');
  }

  @Override
  public void tick(Location location) {
    int num = random.nextInt(4);
    if (num == 0){
      location.addActor(new WanderingUndead());
    }
  }
}
