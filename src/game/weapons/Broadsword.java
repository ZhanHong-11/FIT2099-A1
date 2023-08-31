package game.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.weapons.skill.Skill;

public class Broadsword extends WeaponItem {
  private Skill skill;
  private int skillDuration;
  private final int defaultHitRate;

  public Broadsword() {
    super("Broadsword", '1', 110, "slashes", 80);
    this.defaultHitRate = 80;
  }

  @Override
  public ActionList allowableActions(Actor otherActor, Location location) {
    ActionList actions = new ActionList();
    actions.add(new AttackAction(otherActor, location.toString(), this));
    return actions;
  }
}
