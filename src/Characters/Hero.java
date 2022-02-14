package Characters;

import Attributes.PrimaryAttributes;
import Items.Armor;
import Items.Item;
import Items.Weapon;

import java.util.Map;

public abstract class Hero {
    public String name;
    public int level;
    public PrimaryAttributes basePrimaryAttributes;
    public PrimaryAttributes totalPrimaryAttributes;
    public double Dps;
    public Map<Item.Slot, Item> Equipment;
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

    public Hero(String name) {
        this.name = name;
        EquipmentInitialization();
    }
    private void EquipmentInitialization() {
        Equipment.put(Item.Slot.HEAD, null);
        Equipment.put(Item.Slot.BODY, null);
        Equipment.put(Item.Slot.LEGS, null);
        Equipment.put(Item.Slot.WEAPON, null);
    }
    public abstract void LevelUp();
    public abstract void EquipItem(Armor armor);
    public abstract void EquipItem(Weapon weapon);

    public void PrintCharacterStats() {
        StringBuilder sb = new StringBuilder();
        sb.append("Character name" + name);
        sb.append("Character level" + level);
        sb.append("Strength" + totalPrimaryAttributes.Strength);
        sb.append("Dexterity" + totalPrimaryAttributes.Dexterity);
        sb.append("Intellect" + totalPrimaryAttributes.Intelligence);
        sb.append("DPS" + Dps);
    }
}
