package game.skills;

/**
 * A subclass of Skill that represents a focus skill. A focus skill increases the damage and hit
 * rate of the user for a short duration. It requires a certain percentage of stamina to use.
 *
 * @author Soo Zhan Hong
 * @see Skill
 */
public class FocusSkill extends Skill {

  /**
   * Constructs a new focus skill with the default attributes.
   */
  public FocusSkill() {
    super(20, 5, 10, 90);
  }

}
