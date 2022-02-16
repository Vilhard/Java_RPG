package Characters;

import Attributes.PrimaryAttributes;
import CustomExceptions.InvalidArmorException;
import CustomExceptions.InvalidWeaponException;
import Items.Armor;
import Items.Item;
import Items.Weapon;

public class Warrior extends Hero{
    public PrimaryAttributes getLeveledUpAttributes() {
        return leveledUpAttributes;
    }

    public void setLeveledUpAttributes(PrimaryAttributes leveledUpAttributes) {
        this.leveledUpAttributes = leveledUpAttributes;
    }

    public PrimaryAttributes leveledUpAttributes;
    public Warrior(String name) {
        super(name);
        setBasePrimaryAttributes(new PrimaryAttributes(5,2,1));
        setLeveledUpAttributes(new PrimaryAttributes(3,2,1));
        setTotalMainPrimaryAttribute(getBasePrimaryAttributes().Strength);
        setDps();
    }
    @Override
    public void LevelUp() {
        setLevel(getLevel() +1);
        setTotalPrimaryAttributes(getBasePrimaryAttributes().addAttributes(getLeveledUpAttributes()));
        setDps();
        printCharacterStats(this);
    }
    @Override
    public boolean EquipItem(Armor armor) throws InvalidArmorException {
        if (armor.CheckUsageAbility(this)) {
            if (getEquipment().get(armor.getSlot()) != null) {
                Armor currentArmor = (Armor) getEquipment().get(armor.getSlot());
                setTotalPrimaryAttributes(getTotalPrimaryAttributes().removeAttributes(currentArmor.getAttributes()));
                getEquipment().put(armor.slot, armor);
            } else {
                getEquipment().put(armor.slot, armor);
            }
            setTotalPrimaryAttributes(getBasePrimaryAttributes().addAttributes(armor.getAttributes()));
            setDps();
            return true;
        } else throw new InvalidArmorException("You cannot use this Armor!");
    }
    @Override
    public boolean EquipItem(Weapon weapon) throws InvalidWeaponException {
        if(weapon.CheckUsageAbility(this)) {
            getEquipment().put(Item.Slot.WEAPON, weapon);
            setDps();
            return true;
        } else {
            throw new InvalidWeaponException("You cannot use this Weapon!");
        }
    }
}
