package game.gamemaps;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;
import java.util.Arrays;
import java.util.List;

public class BurialGround extends GameMap {
  private static final List<String> MAP = Arrays.asList(
      "...........+++++++........~~~~~~++....~~",
      "....n......++++++.........~~~~~~+.....~~",
      "............++++.....n.....~~~~~......++",
      "............+.+.............~~~.......++",
      "..........++~~~.......................++",
      ".........+++~~~....#######...........+++",
      ".........++++~.....#_____#.........+++++",
      "..........+++......#_____#........++++++",
      "..........+++......###_###.......~~+++++",
      "..........~~.....................~~...++",
      "..........~~~..................++.......",
      "...........~~....~~~~~.........++.......",
      "......~~....++..~~~~~~~~~~~......~...n..",
      "....+~~~~..++++++++~~~~~~~~~....~~~.....",
      "..n.+~~~~..++++++++~~~..~~~~~..~~~~~....");

  public BurialGround(GroundFactory groundFactory) {
    super(groundFactory, BurialGround.MAP);
  }
}
