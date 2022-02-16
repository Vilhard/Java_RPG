package Characters;

public class CharacterStatPrinter {
    public void PrintCharacterStats(Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append("Character name " + hero.name + "\n");
        sb.append("Character level " + hero.level + "\n");
        sb.append("Strength " + hero.totalPrimaryAttributes.Strength + "\n");
        sb.append("Dexterity " + hero.totalPrimaryAttributes.Dexterity + "\n");
        sb.append("Intellect " + hero.totalPrimaryAttributes.Intelligence + "\n");
        sb.append("DPS " + hero.Dps + "\n");
        System.out.println(sb);
    }
}
