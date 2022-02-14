package Items;

import Characters.Hero;

public abstract class Item {

    public enum Slot {
        HEAD,
        BODY,
        LEGS,
        WEAPON
    }
    public String name;
    public int level = 1;
    public Slot slot;
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
        level = level;
    }
    public Slot getSlot() {
        return slot;
    }
    public void setSlot(Slot slot) {
        slot = slot;
    }
    public Item(String name, int level, Slot slot) {
        this.name = name;
        this.level = level;
        this.slot = slot;
    }
    public abstract boolean CheckUsageAbility(Hero hero);
}
