package Items;

import Characters.Hero;

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
    public double Dps() {
        return Damage * AttackSpeed;
    }
    public int getDamage() {
        return Damage;
    }
    public void setDamage(int damage) {
        Damage = damage;
    }
    public double getAttackSpeed() {
        return AttackSpeed;
    }
    public void setAttackSpeed(double attackSpeed) {
        AttackSpeed = attackSpeed;
    }
    public TypesOfWeapons getWeaponType() {
        return weaponType;
    }
    public void setWeaponType(TypesOfWeapons weaponType) {
        this.weaponType = weaponType;
    }
    public Weapon(String name, int level, Slot slot, TypesOfWeapons weaponType, int damage, double attackSpeed) {
        super(name, level, slot);
        this.weaponType = weaponType;
        Damage = damage;
        AttackSpeed = attackSpeed;
    }
    @Override
    public boolean CheckUsageAbility(Hero hero) {
        if (level > hero.level) {
            return false;
        } else if (hero.getClass().getSimpleName().equals("Mage")) {
            if (weaponType == TypesOfWeapons.STAFF || weaponType == TypesOfWeapons.WAND) {
                return true;
            } else return false;
        } else if (hero.getClass().getSimpleName().equals("Warrior")) {
            if (weaponType == TypesOfWeapons.AXE || weaponType == TypesOfWeapons.HAMMER ||  weaponType == TypesOfWeapons.SWORD) {
                return true;
            } else return false;
        } else if (hero.getClass().getSimpleName().equals("Rogue")) {
            if (weaponType == TypesOfWeapons.DAGGER || weaponType == TypesOfWeapons.SWORD) {
                return true;
            } else return false;
        } else if (hero.getClass().getSimpleName().equals("Ranger")) {
            if (weaponType == TypesOfWeapons.BOW) {
                return true;
            } else return false;
        }
        return false;
    }
}
