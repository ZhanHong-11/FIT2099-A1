package game.skills;

/**
 * An abstract class that represents a skill that can be used by a game character. A skill has four
 * attributes: stamina cost, duration, damage multiplier percentage, and hit rate. Subclasses of
 * this class should implement the specific logic of how the skill is executed and what effects it
 * has.
 *
 * @author Soo Zhan Hong
 */
public abstract class Skill {

  /**
   * The percentage of stamina required to use the skill
   */
  private final int skillStaminaPercent;
  /**
   * The duration of the skill in turns
   */
  private final int skillDuration;
  /**
   * The percentage of damage multiplier increase when using the skill
   */
  private final int skillDamageMultiplierPercent;
  /**
   * The probability of hitting the target when using the skill
   */
  private final int hitRate;

  /**
   * Constructs a new skill with the given attributes.
   *
   * @param skillStaminaPercent          The percentage of stamina required to use the skill
   * @param skillDuration                The duration of the skill in turns
   * @param skillDamageMultiplierPercent The percentage of damage multiplier increase when using the
   *                                     skill
   * @param hitRate                      The probability of hitting the target when using the skill
   */
  public Skill(int skillStaminaPercent, int skillDuration, int skillDamageMultiplierPercent,
      int hitRate) {
    this.skillStaminaPercent = skillStaminaPercent;
    this.skillDuration = skillDuration;
    this.skillDamageMultiplierPercent = skillDamageMultiplierPercent;
    this.hitRate = hitRate;
  }

  /**
   * Returns the percentage of stamina cost.
   *
   * @return The percentage of stamina cost
   */
  public int getSkillStaminaPercent() {
    return this.skillStaminaPercent;
  }

  /**
   * Returns the duration of the skill in turns.
   *
   * @return The duration of the skill in turns
   */
  public int getSkillDuration() {
    return this.skillDuration;
  }

  /**
   * Returns the percentage of damage multiplier increase when using the skill.
   *
   * @return The percentage of damage multiplier increase when using the skill
   */
  public int getSkillDamageMultiplierPercent() {
    return this.skillDamageMultiplierPercent;
  }

  /**
   * Returns the probability of hitting the target when using the skill.
   *
   * @return The probability of hitting the target when using the skill
   */
  public int getHitRate() {
    return this.hitRate;
  }
}
