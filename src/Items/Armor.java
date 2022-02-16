package Items;

import Attributes.PrimaryAttributes;
import Characters.*;

public class Armor extends Item {
    public enum TypesOfArmor {
        CLOTH,
        LEATHER,
        MAIL,
        PLATE
    }
    public TypesOfArmor armorType;
    public PrimaryAttributes attributes;
    public Armor () {}
    public Armor(String name, int level, Slot slot, TypesOfArmor armorType, PrimaryAttributes attributes) {
        super(name);
        setLevel(level);
        setArmorType(armorType);
        setAttributes(attributes);
        setSlot(slot);
    }
    @Override
    public boolean CheckUsageAbility(Hero hero) {
        if (super.getLevel() > hero.level) {
            return false;
        } else if (hero instanceof Mage) {
            return (getArmorType().equals(TypesOfArmor.CLOTH));
        } else if (hero instanceof Warrior) {
            return (getArmorType().equals((TypesOfArmor.MAIL)) || getArmorType().equals(TypesOfArmor.PLATE));
        } else if (hero instanceof Rogue) {
           return (getArmorType().equals(TypesOfArmor.LEATHER) || getArmorType().equals(TypesOfArmor.MAIL));
        } else if (hero instanceof Ranger) {
            return (getArmorType().equals(TypesOfArmor.LEATHER) || getArmorType().equals(TypesOfArmor.MAIL));
        }
        return false;
    }
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
}
