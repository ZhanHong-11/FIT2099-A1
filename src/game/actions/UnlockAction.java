package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.Unlockable;
import game.items.Key;
import java.util.List;

public class UnlockAction extends Action {
  private final Unlockable sealedObject;

  public UnlockAction(Unlockable sealedObject){
    this.sealedObject = sealedObject;
  }

  @Override
  public String execute(Actor actor, GameMap map) {
    List<Item> items = actor.getItemInventory();
    for (Item item: items){
      if (item instanceof Key){
        sealedObject.unlocked();
        return "The " + sealedObject + " is unlocked.";
      }
    }
    return "The " + sealedObject + " is locked.";
  }

  @Override
  public String menuDescription(Actor actor) {
    return actor + " opens the " + this.sealedObject.toString();
  }
}
