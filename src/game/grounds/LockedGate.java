package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.UnlockAction;

public class LockedGate extends Ground implements Unlockable{
  private boolean isLocked = true;

  public LockedGate() {
    super('=');
  }

  @Override
  public boolean canActorEnter(Actor actor) {
    return !this.isLocked;
  }

  @Override
  public ActionList allowableActions(Actor actor, Location location, String direction) {
    ActionList actions = new ActionList();
    if (isLocked){
      actions.add(new UnlockAction(this));
    }
    return actions;
  }

  @Override
  public void unlocked() {
    this.isLocked = !this.isLocked;
  }

  @Override
  public String toString() {
    return "locked gate";
  }
}
