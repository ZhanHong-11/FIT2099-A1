package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

public class HealingVial extends Item implements Consumable{
  private final static String ATTRIBUTE = "health";

  public HealingVial() {
    super("Healing Vial", 'a', true);
  }

  @Override
  public ActionList allowableActions(Actor owner) {
    ActionList actionList = new ActionList();
    actionList.add(new ConsumeAction(this));
    return actionList;
  }

  @Override
  public int consume(Actor actor) {
    int healthRecovery = Math.round(actor.getAttributeMaximum(BaseActorAttributes.HEALTH) / 10f);
    actor.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, healthRecovery);
    actor.removeItemFromInventory(this);
    return healthRecovery;
  }

  @Override
  public String getAttribute() {
    return HealingVial.ATTRIBUTE;
  }

}
