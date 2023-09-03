package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

public class ConsumeAction extends Action {
  private final Consumable consumableItem;

  public ConsumeAction(Consumable consumableItem){
    this.consumableItem = consumableItem;
  }

  @Override
  public String execute(Actor actor, GameMap map) {
    int recoveryPoints = this.consumableItem.consume(actor);
    return actor + " restores the " + consumableItem.getAttribute() + " by " + recoveryPoints + " points.";
  }

  @Override
  public String menuDescription(Actor actor) {
    return actor + " consumes " + consumableItem;
  }
}
