package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Ability;
import game.items.HealingVial;
import game.items.Key;
import java.util.Random;

public class WanderingUndead extends Enemy{
    private Random random = new Random();

    public WanderingUndead() {
        super("Wandering Undead", 't', 100);
        this.addCapability(Ability.FLOAT);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(30, "smacked", 50);
    }

    @Override
    public void drop(GameMap map) {
        int num = random.nextInt(10);
        if (num < 1){
            Location location = map.locationOf(this);
            map.at(location.x(), location.y()).addItem(new Key());
        }

        if (num < 2){
            Location location = map.locationOf(this);
            map.at(location.x(), location.y()).addItem(new HealingVial());
        }
    }

    @Override
    public String unconscious(Actor actor, GameMap map) {
        drop(map);
        return super.unconscious(actor, map);
    }
}
