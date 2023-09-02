package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
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
        if (findAttackAction(destination) != null){
          actions.add(findAttackAction(destination));
        }
        //Detects one block away
        for (Exit exit1: destination.getExits()){
          Location destination1 = exit1.getDestination();
          if (findAttackAction(destination1) != null){
            actions.add(findAttackAction(destination1));
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

  private AttackAction findAttackAction(Location destination) {
      if (destination.containsAnActor()) {
        Actor target = destination.getActor();
        if (target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
          return new AttackAction(target, destination.toString());
        }
      }

    return null;
  }
}
