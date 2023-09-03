package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Ability;

public class Void extends Ground {
  private Display display = new Display();

  public Void(){
    super('+');
  }

  @Override
  public void tick(Location location) {
    if (location.containsAnActor()){
      Actor actor = location.getActor();
      if (!actor.hasCapability(Ability.FLOAT)){
        String deadmsg = actor.unconscious(location.map());
        display.println(deadmsg);
      }
    }
  }

}
