package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttribute;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.display.FancyMessage;

/**
 * Class representing the Player.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints, int stamina) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addAttribute(BaseActorAttributes.STAMINA, new BaseActorAttribute(stamina));
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        tick();

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(15, "strikes", 80);
    }

    private void tick(){
        int staminaRecovery = Math.round(this.getAttributeMaximum(BaseActorAttributes.STAMINA) / 100f);
        this.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, staminaRecovery);
    }

    @Override
    public String unconscious(Actor actor, GameMap map) {
        map.removeActor(this);
        return "\n" + FancyMessage.YOU_DIED + "\n" + this + " met their demise in the hand of " + actor;
    }

    @Override
    public String unconscious(GameMap map) {
        map.removeActor(this);
        return "\n" + FancyMessage.YOU_DIED + "\n" + this + " ceased to exist.";
    }

    @Override
    public String toString() {
        return name + " (" +
            this.getAttribute(BaseActorAttributes.HEALTH) + "/" +
            this.getAttributeMaximum(BaseActorAttributes.HEALTH) + ", " +
            this.getAttribute(BaseActorAttributes.STAMINA) + "/" +
            this.getAttributeMaximum(BaseActorAttributes.STAMINA) +
            ")";
    }
}
