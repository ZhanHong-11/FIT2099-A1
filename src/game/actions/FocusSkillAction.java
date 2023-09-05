package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Broadsword;

/**
 * A subclass of Action that represents a focus skill action. A focus skill action is an action that
 * allows an actor to activate the skill of a broadsword. The skill increases the damage and hit
 * rate of the broadsword for a short duration, but costs some stamina.
 *
 * @see Action
 * @see Broadsword
 */
public class FocusSkillAction extends Action {

  /**
   * The actor who performs the focus skill action
   */
  private Actor player;
  /**
   * The broadsword that has the focus skill
   */
  private Broadsword broadsword;

  /**
   * Constructs a new focus skill action with the given actor and weapon.
   *
   * @param player     The actor who performs the focus skill action
   * @param broadsword The broadsword that has the focus skill
   */
  public FocusSkillAction(Actor player, Broadsword broadsword) {
    this.player = player;
    this.broadsword = broadsword;
  }

  /**
   * Executes the focus skill action and returns a string that describes what happened.
   *
   * @param actor The actor who performs the action
   * @param map   The game map that contains the actor
   * @return the action description to be displayed on the menu
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    int staminaCostPercent = broadsword.activateSkill();
    int staminaCost = Math.round(
        player.getAttributeMaximum(BaseActorAttributes.STAMINA) * staminaCostPercent / 100f);
    if (player.getAttribute(BaseActorAttributes.STAMINA) < staminaCost) {
      return actor + " has insufficient stamina.";
    }
    player.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE,
        staminaCost);
    return actor + " takes a deep breath and focuses all their might!!";
  }

  /**
   * Returns a string that describes the focus skill action in a menu.
   *
   * @param actor The actor performing the action.
   * @return the action description to be displayed on the menu
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " activates skill of the broadsword.";
  }
}
