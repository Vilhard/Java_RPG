package Characters;

import Attributes.PrimaryAttributes;
import Items.Armor;
import Items.Item;
import Items.Weapon;

public class Warrior extends Hero{
    public PrimaryAttributes leveledUpAttributes;
    public PrimaryAttributes totalPrimaryAttributes;
    public Warrior(String name) {
        super(name);
        basePrimaryAttributes = new PrimaryAttributes(5,2,1);
        leveledUpAttributes = new PrimaryAttributes(3,2,1);
    }
    @Override
    public void LevelUp() {
        level += 1;
    basePrimaryAttributes = new PrimaryAttributes(basePrimaryAttributes.Strength + leveledUpAttributes.Strength,
            basePrimaryAttributes.Dexterity + leveledUpAttributes.Dexterity, basePrimaryAttributes.Intelligence + leveledUpAttributes.Intelligence);
    }
    @Override
    public void EquipItem(Armor armor) {
        if(armor.CheckUsageAbility(this)) {
            Equipment.put(armor.slot, armor);
            totalPrimaryAttributes = new PrimaryAttributes(basePrimaryAttributes.Strength + armor.attributes.Strength,
                    basePrimaryAttributes.Dexterity + armor.attributes.Dexterity, basePrimaryAttributes.Intelligence + armor.attributes.Intelligence);
        } else {
            throw new IllegalArgumentException("You cannot use this armor!");
        }
    }
    @Override
    public void EquipItem(Weapon weapon) {
        if(weapon.CheckUsageAbility(this)) {
            Equipment.put(Item.Slot.WEAPON, weapon);
            Dps = weapon.Damage * (double)(1 + (totalPrimaryAttributes.Strength / 100));
        } else {
            throw new IllegalArgumentException("You cannot use this armor!");
        }
    }
}
