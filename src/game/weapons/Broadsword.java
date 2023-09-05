package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.FocusSkillAction;
import game.skills.FocusSkill;
import game.skills.Skill;

/**
 * A subclass of WeaponItem that represents a broadsword. A broadsword is a powerful weapon that can
 * slash enemies with high damage. It also has a special skill that can increase its damage and hit
 * rate for a short duration.
 *
 * @author Soo Zhan Hong
 * @see WeaponItem
 */
public class Broadsword extends WeaponItem {

  /**
   * The skill associated with the broadsword
   */
  private final Skill skill;
  /**
   * The time left for the skill to be activating
   */
  private int skillCountdown;
  /**
   * The default hit rate of the broadsword
   */
  private final int defaultHitRate;

  /**
   * Constructs a new broadsword with the default attributes and skill.
   */
  public Broadsword() {
    super("Broadsword", '1', 110, "slashes", 80);
    this.defaultHitRate = 80;
    this.skill = new FocusSkill();
  }

  /**
   * Activates the skill of the broadsword and returns the stamina percentage required to use it.
   *
   * @return The percentage of stamina required to use the skill
   */
  public int activateSkill() {
    this.skillCountdown = skill.getSkillDuration();
    updateHitRate(skill.getHitRate());
    increaseDamageMultiplier(skill.getSkillDamageMultiplierPercent() / 100f);
    return skill.getSkillStaminaPercent();
  }

  /**
   * Skill should only last for some turns. Decrement the number of turn left for the activated
   * skill
   *
   * @param currentLocation The location of the actor carrying this weapon.
   * @param actor           The actor carrying this weapon.
   */
  @Override
  public void tick(Location currentLocation, Actor actor) {
    if (this.skillCountdown > 0) {
      this.skillCountdown--;
    }
  }

  /**
   * Accessor for damage done by this weapon. Resets the damage multiplier to 1.0 if the skill
   * duration is finish.
   *
   * @return the damage
   */
  @Override
  public int damage() {
    if (skillCountdown == 0) {
      updateDamageMultiplier(1.0f);
    }
    return super.damage();
  }

  /**
   * Create and return an action to pick this Item up. Resets the hit rate of the broadsword to its
   * default value when picked up.
   *
   * @return A PickUpAction that allows picking up the broadsword
   */
  @Override
  public PickUpAction getPickUpAction(Actor actor) {
    updateHitRate(this.defaultHitRate);
    return super.getPickUpAction(actor);
  }

  /**
   * Returns an ActionList that contains a FocusSkillAction that allows an actor to activate the
   * skill of the broadsword.
   *
   * @param owner the actor that owns the weapon
   * @return an unmodifiable list of Actions
   */
  @Override
  public ActionList allowableActions(Actor owner) {
    ActionList actions = new ActionList();
    actions.add(new FocusSkillAction(owner, this));
    return actions;
  }

  /**
   * Returns an ActionList that contains an AttackAction that allows an actor to attack another
   * actor with the broadsword.
   *
   * @param otherActor the other actor
   * @param location   the location of the other actor
   * @return an unmodifiable list of Actions
   */
  @Override
  public ActionList allowableActions(Actor otherActor, Location location) {
    ActionList actions = new ActionList();
    actions.add(new AttackAction(otherActor, location.toString(), this));
    return actions;
  }
}
