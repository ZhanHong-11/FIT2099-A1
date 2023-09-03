package game.items;

import edu.monash.fit2099.engine.actors.Actor;

public interface Consumable {
  int consume(Actor actor);

  String getAttribute();
}
