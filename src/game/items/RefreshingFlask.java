package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

public class RefreshingFlask extends Item implements Consumable{
  private final static String ATTRIBUTE = "stamina";

  public RefreshingFlask() {
    super("Refreshing Flask", 'u', true);
  }

  @Override
  public ActionList allowableActions(Actor owner) {
    ActionList actionList = new ActionList();
    actionList.add(new ConsumeAction(this));
    return actionList;
  }

  @Override
  public int consume(Actor actor) {
    int staminaRecovery = Math.round(actor.getAttributeMaximum(BaseActorAttributes.STAMINA) / 5f);
    actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, staminaRecovery);
    actor.removeItemFromInventory(this);
    return staminaRecovery;
  }

  @Override
  public String getAttribute() {
    return RefreshingFlask.ATTRIBUTE;
  }
}
