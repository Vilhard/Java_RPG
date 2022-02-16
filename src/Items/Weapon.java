package Items;

import Characters.*;

public class Weapon extends Item {
    public enum TypesOfWeapons
    {
        AXE,
        BOW,
        DAGGER,
        HAMMER,
        STAFF,
        SWORD,
        WAND
    }
    public TypesOfWeapons weaponType;
    public int Damage;
    public double AttackSpeed = 1;

    public double getWeaponDps() {
        return WeaponDps;
    }

    public void setWeaponDps(double weaponDps) {
        WeaponDps = weaponDps;
    }

    public double WeaponDps;

    public Weapon() {
        super();
    }

    public Weapon (String name, int level, TypesOfWeapons weaponType) {
        super(name);
        setLevel(level);
        setWeaponType(weaponType);
        setSlot(Slot.WEAPON);
    }
    public Weapon(String name, int level, TypesOfWeapons weaponType, int damage, double attackSpeed) {
        super(name);
        setLevel(level);
        setWeaponType(weaponType);
        setDamage(damage);
        setAttackSpeed(attackSpeed);
        setWeaponDps(damage * AttackSpeed);
        setSlot(Slot.WEAPON);
    }
    /**
     * Checks and returns boolean value that represents the usability of the item with hero class that calls the method
     * @param hero
     * @return
     */
    @Override
    public boolean CheckUsageAbility(Hero hero) {
        System.out.println(super.getLevel() > hero.getLevel());
        if (super.getLevel() > hero.getLevel()) {
            return false;
        } if (hero instanceof Mage) {
            return (getWeaponType().equals(TypesOfWeapons.STAFF) || getWeaponType().equals(TypesOfWeapons.WAND));
        } else if (hero instanceof Warrior) {
            return (getWeaponType().equals(TypesOfWeapons.AXE) || getWeaponType().equals(TypesOfWeapons.HAMMER)
                    || getWeaponType().equals(TypesOfWeapons.SWORD));
        } else if (hero instanceof Rogue) {
            return (getWeaponType().equals(TypesOfWeapons.DAGGER) || getWeaponType().equals(TypesOfWeapons.SWORD));
        } else if (hero instanceof Ranger) {
            return (getWeaponType().equals(TypesOfWeapons.BOW));
        }
        return false;
    }

    public int getDamage() {
        return Damage;
    }
    public double getAttackSpeed() {
        return AttackSpeed;
    }
    public TypesOfWeapons getWeaponType() {
        return weaponType;
    }
    public void setDamage(int damage) {
        Damage = damage;
    }
    public void setAttackSpeed(double attackSpeed) {
        AttackSpeed = attackSpeed;
    }
    public void setWeaponType(TypesOfWeapons weaponType) {
        this.weaponType = weaponType;
    }
}
