package game;

import game.actors.Player;
import game.actors.enemies.WanderingUndead;
import game.display.FancyMessage;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.LockedGate;
import game.grounds.Puddle;
import game.grounds.Void;
import game.grounds.Wall;
import game.weapons.Broadsword;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Void(), new LockedGate());

        List<String> map = Arrays.asList(
                "...........................................................",
                "...#######.................................................",
                "...#__=....................................................",
                "...#..___#.................................................",
                "...###.###................#######..........................",
                "..........................#_____#..........................",
                "........~~................#_____#..........................",
                ".........~~~..............###_###..........................",
                "...~~~~~~~~...............++...............................",
                "....~~~~~.................................###..##..........",
                "~~~~~~~...................................#___..#..........",
                "~~~~~~....................................#..___#..........",
                "~~~~~~~~~.................................#######..........");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        gameMap.at(23, 10).addActor(new WanderingUndead());
        gameMap.at(28, 6).addItem(new Broadsword());

        Player player = new Player("The Abstracted One", '@', 150, 200);
        world.addPlayer(player, gameMap.at(29, 5));

        world.run();
    }
}
