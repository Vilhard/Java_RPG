package Characters;

public class CharacterStatPrinter {
    public void PrintCharacterStats(Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append("Character name" + hero.name);
        sb.append("Character level" + hero.level);
        sb.append("Strength" + hero.totalPrimaryAttributes.Strength);
        sb.append("Dexterity" + hero.totalPrimaryAttributes.Dexterity);
        sb.append("Intellect" + hero.totalPrimaryAttributes.Intelligence);
        sb.append("DPS" + hero.Dps);
    }
}
