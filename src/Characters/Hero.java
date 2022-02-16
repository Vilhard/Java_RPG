package Characters;

import Attributes.PrimaryAttributes;
import CustomExceptions.InvalidArmorException;
import CustomExceptions.InvalidWeaponException;
import Items.Armor;
import Items.Item;
import Items.Weapon;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero {
    public String name;
    public int level = 1;
    public PrimaryAttributes basePrimaryAttributes;
    public PrimaryAttributes totalPrimaryAttributes;
    public double Dps = 1;
    public double totalMainPrimaryAttribute;
    public Map<Item.Slot, Item> Equipment;
    public Hero(String name) {
        setName(name);
        setBasePrimaryAttributes(basePrimaryAttributes);
        setTotalPrimaryAttributes(totalPrimaryAttributes);
        EquipmentInitialization();
    }
    private void EquipmentInitialization() {
        HashMap<Item.Slot, Item> equipment= new HashMap<>();
        setEquipment(equipment);
    }
    public abstract void LevelUp();
    public abstract boolean EquipItem(Armor armor) throws InvalidArmorException;
    public abstract boolean EquipItem(Weapon weapon) throws InvalidWeaponException;
    public PrimaryAttributes getBasePrimaryAttributes() {
        return basePrimaryAttributes;
    }
    public void setBasePrimaryAttributes(PrimaryAttributes basePrimaryAttributes) {
        this.basePrimaryAttributes = basePrimaryAttributes;
    }
    public PrimaryAttributes getTotalPrimaryAttributes() {
        return totalPrimaryAttributes;
    }
    public void setTotalPrimaryAttributes(PrimaryAttributes totalPrimaryAttributes) {
        this.totalPrimaryAttributes = totalPrimaryAttributes;
    }
    public Map<Item.Slot, Item> getEquipment() {
        return Equipment;
    }
    public void setEquipment(Map<Item.Slot, Item> equipment) {
        Equipment = equipment;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public double getTotalMainPrimaryAttribute() {
        return totalMainPrimaryAttribute;
    }
    public void setTotalMainPrimaryAttribute(double totalMainPrimaryAttribute) {
        this.totalMainPrimaryAttribute = totalMainPrimaryAttribute;
    }
    public double getDps() {
        return Dps;
    }
    public void setDps() {
        if(getEquipment().get(Item.Slot.WEAPON) == null) {
            this.Dps = 1 * (1 + getTotalMainPrimaryAttribute()/100);
        } else {
            Weapon currentWeapon = (Weapon) getEquipment().get(Item.Slot.WEAPON);
            this.Dps = currentWeapon.getWeaponDps() * (1 + getTotalMainPrimaryAttribute()/100);
        }
    }
    public void printCharacterStats(Hero hero) {
        CharacterStatPrinter printer = new CharacterStatPrinter();
        printer.PrintCharacterStats(hero);
    }

}
