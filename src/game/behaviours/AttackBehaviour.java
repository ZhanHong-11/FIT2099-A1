package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.Status;
import game.actions.AttackAction;
import java.util.ArrayList;
import java.util.Random;

public class AttackBehaviour implements Behaviour {
  private final Random random = new Random();

  @Override
  public Action getAction(Actor actor, GameMap map) {
    ArrayList<Action> actions = new ArrayList<>();

      for (Exit exit: map.locationOf(actor).getExits()){
        Location destination = exit.getDestination();
        if (destination.containsAnActor()){
          Actor target = destination.getActor();
          if (target.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(target, destination.toString()));
          }
        }
      }

    if (!actions.isEmpty()) {
      return actions.get(random.nextInt(actions.size()));
    }
    else {
      return null;
    }
  }

}
