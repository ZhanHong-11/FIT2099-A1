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

public class Broadsword extends WeaponItem {
  private final Skill skill;
  private int skillCountdown;
  private final int defaultHitRate;

  public Broadsword() {
    super("Broadsword", '1', 110, "slashes", 80);
    this.defaultHitRate = 80;
    this.skill = new FocusSkill();
  }

  public int activateSkill() {
    this.skillCountdown = skill.getSkillDuration();
    updateHitRate(skill.getHitRate());
    increaseDamageMultiplier(skill.getSkillDamageMultiplierPercent() / 100f);
    return skill.getSkillStaminaPercent();
  }

  @Override
  public void tick(Location currentLocation, Actor actor) {
    if (this.skillCountdown > 0){
      this.skillCountdown--;
    }
  }

  @Override
  public int damage() {
    if (skillCountdown == 0){
      updateDamageMultiplier(1.0f);
    }
    return super.damage();
  }

  @Override
  public PickUpAction getPickUpAction(Actor actor) {
    updateHitRate(this.defaultHitRate);
    return super.getPickUpAction(actor);
  }

  @Override
  public ActionList allowableActions(Actor owner) {
    ActionList actions = new ActionList();
    actions.add(new FocusSkillAction(owner, this));
    return actions;
  }

  @Override
  public ActionList allowableActions(Actor otherActor, Location location) {
    ActionList actions = new ActionList();
    actions.add(new AttackAction(otherActor, location.toString(), this));
    return actions;
  }
}
