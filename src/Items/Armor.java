package Items;

import Attributes.PrimaryAttributes;
import Characters.Hero;

public class Armor extends Item {
    public enum TypesOfArmor {
        CLOTH,
        LEATHER,
        MAIL,
        PLATE
    }
    public TypesOfArmor armorType;
    public PrimaryAttributes attributes;
    public TypesOfArmor getArmorType() {
        return armorType;
    }
    public void setArmorType(TypesOfArmor armorType) {
        this.armorType = armorType;
    }
    public PrimaryAttributes getAttributes() {
        return attributes;
    }
    public void setAttributes(PrimaryAttributes attributes) {
        this.attributes = attributes;
    }
    public Armor(String name, int level, Slot slot, TypesOfArmor armorType, PrimaryAttributes attributes) {
        super(name, level, slot);
        this.armorType = armorType;
        this.attributes = attributes;
    }
    @Override
    public boolean CheckUsageAbility(Hero hero) {
        if (level > hero.level) {
            return false;
        } else if (hero.getClass().getSimpleName().equals("Mage")) {
            if (armorType == TypesOfArmor.CLOTH) {
                return true;
            } else return false;
        } else if (hero.getClass().getSimpleName().equals("Warrior")) {
            if (armorType == TypesOfArmor.MAIL || armorType == TypesOfArmor.PLATE) {
                return true;
            } else return false;
        } else if (hero.getClass().getSimpleName().equals("Rogue")) {
            if (armorType == TypesOfArmor.LEATHER || armorType == TypesOfArmor.MAIL) {
                return true;
            } else return false;
        } else if (hero.getClass().getSimpleName().equals("Ranger")) {
            if (armorType == TypesOfArmor.LEATHER || armorType == TypesOfArmor.MAIL) {
                return true;
            } else return false;
        }
        return false;
    }
}
