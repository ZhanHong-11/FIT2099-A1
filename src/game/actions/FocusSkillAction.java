package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Broadsword;

public class FocusSkillAction extends Action {
  private Actor player;
  private Broadsword broadsword;

  public FocusSkillAction(Actor player, Broadsword broadsword){
    this.player = player;
    this.broadsword = broadsword;
  }

  @Override
  public String execute(Actor actor, GameMap map) {
    int staminaCostPercent = broadsword.activateSkill();
    int staminaCost = Math.round(player.getAttributeMaximum(BaseActorAttributes.STAMINA) * staminaCostPercent / 100f);
    if (player.getAttribute(BaseActorAttributes.STAMINA) < staminaCost){
      return actor + " has insufficient stamina.";
    }
    player.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, staminaCost);
    return actor + " takes a deep breath and focuses all their might!!";
  }

  @Override
  public String menuDescription(Actor actor) {
    return actor + " activates the Broadsword skill.";
  }
}
