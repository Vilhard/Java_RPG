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
    public int level;
    public Slot slot;

    public Item() { }
    public Item(String name) {
        setName(name);
    }
    public abstract boolean CheckUsageAbility(Hero hero);
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
}
