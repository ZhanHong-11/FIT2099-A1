package game.skills;

public abstract class Skill {
  private final int skillStaminaPercent;
  private final int skillDuration;
  private final int skillDamageMultiplierPercent;
  private final int hitRate;


  public Skill(int skillStaminaPercent, int skillDuration, int skillDamageMultiplierPercent, int hitRate){
    this.skillStaminaPercent = skillStaminaPercent;
    this.skillDuration = skillDuration;
    this.skillDamageMultiplierPercent = skillDamageMultiplierPercent;
    this.hitRate = hitRate;
  }

  public int getSkillStaminaPercent() {
    return this.skillStaminaPercent;
  }

  public int getSkillDuration() {
    return this.skillDuration;
  }

  public int getSkillDamageMultiplierPercent() {
    return this.skillDamageMultiplierPercent;
  }

  public int getHitRate() {
    return this.hitRate;
  }
}
