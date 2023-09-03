package game.actors.enemies;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Ability;
import game.items.HealingVial;
import game.items.RefreshingFlask;
import java.util.Random;

public class HollowSoldier extends Enemy{
  private Random random = new Random();

  public HollowSoldier() {
    super("Hollow Soldier", '&', 200);
    this.addCapability(Ability.IMMUNE_TO_VOID);
  }

  @Override
  public IntrinsicWeapon getIntrinsicWeapon() {
    return new IntrinsicWeapon(50, "whacked", 50);
  }

  @Override
  public void drop(GameMap map) {
    int num = random.nextInt(10);
    if (num < 2){
      Location location = map.locationOf(this);
      map.at(location.x(), location.y()).addItem(new HealingVial());
    }

    if (num < 3){
      Location location = map.locationOf(this);
      map.at(location.x(), location.y()).addItem(new RefreshingFlask());
    }
  }

}
