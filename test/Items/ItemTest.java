package Items;

import Attributes.PrimaryAttributes;
import Characters.Warrior;
import CustomExceptions.InvalidArmorException;
import CustomExceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    public void EquipItem_level1WarriorEquipsLevel2Axe_ShouldThrowInvalidWeaponException() {
        // Arrange
        Warrior testWarrior = new Warrior("Orum");
        Weapon testWeapon = new Weapon();
        testWeapon.setName("Common Axe");
        testWeapon.setLevel(4);
        String expected = "You cannot use this Weapon!";

        // Act & Assert
        Exception exception = assertThrows(InvalidWeaponException.class, () -> {
            testWarrior.EquipItem(testWeapon);
        });
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }
    @Test
    public void EquipItem_level1WarriorEquipsLevel2Armor_ShouldThrowInvalidArmorException(){
        // Arrange
        Warrior testWarrior = new Warrior("Orum");
        Armor testArmor = new Armor();
        testArmor.setName("Common Chain mail Head");
        testArmor.setLevel(2);
        testArmor.setSlot(Item.Slot.HEAD);
        testArmor.setArmorType(Armor.TypesOfArmor.PLATE);
        testArmor.setAttributes(new PrimaryAttributes(2,1,0));
        // Act & Assert
        Exception exception = assertThrows(InvalidArmorException.class, () -> {
            testWarrior.EquipItem(testArmor);
        });
        assertTrue(exception.getMessage().contains("You cannot use this Armor!"));
    }
    @Test
    public void EquipItem_WarriorTriesToEquipWrongWeaponType_ShouldThrowInvalidWeaponException(){
        // Arrange
        Warrior testWarrior = new Warrior("Grog");
        Weapon testBow = new Weapon("Common Bow", 1, Weapon.TypesOfWeapons.BOW, 12, 0.8);
        // Act & Assert
        Exception exception = assertThrows(InvalidWeaponException.class, () -> {
            testWarrior.EquipItem(testBow);
        });
        assertTrue(exception.getMessage().contains("You cannot use this Weapon!"));
    }
    @Test
    public void EquipItem_WarriorTriesToEquipWrongArmorType_ShouldThrowInvalidArmorException() {
        // Arrange
        Warrior testWarrior = new Warrior("Grog");
        Armor testArmor = new Armor("Common Cloth Head Armor", 1, Item.Slot.HEAD, Armor.TypesOfArmor.CLOTH,
                new PrimaryAttributes(0,0,5));

        // Act & Assert
        Exception exception = assertThrows(InvalidArmorException.class, () -> {
            testWarrior.EquipItem(testArmor);
        });
        assertTrue(exception.getMessage().contains("You cannot use this Armor!"));
    }
    @Test
    public void EquipItem_WarriorEquipsValidWeapon_ShouldReturnTrue() throws InvalidWeaponException {
        // Arrange
        boolean expected = true;
        Warrior testWarrior = new Warrior("Grog");
        Weapon testWeapon = new Weapon("Common Axe", 1, Weapon.TypesOfWeapons.AXE, 7, 1.1);

        //Act & Assert
        boolean actual = testWarrior.EquipItem(testWeapon);
        assertEquals(expected, actual);
    }
    @Test
    public void EquipItem_WarriorEquipsValidArmor_ShouldReturnTrue() throws InvalidArmorException {
        // Arrange
        boolean expected = true;
        Warrior testWarrior = new Warrior("Grog");
        Armor testArmor = new Armor("Common Plate Body Armor", 1, Item.Slot.BODY, Armor.TypesOfArmor.PLATE,
                new PrimaryAttributes(1,0,0));

        //Act & Assert
        boolean actual = testWarrior.EquipItem(testArmor);
        assertEquals(expected, actual);
    }
    @Test
    public void getDps_CalculateDpsForLevel1WarriorWithoutEquipments_ShouldReturnTrue(){
        // Arrange
        double expected = 1.05;
        Warrior testWarrior = new Warrior("Grog");

        // Act
        double actual = testWarrior.getDps();

        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void getDPS_CalculateDpsForLevel1WarriorWithValidWeapon_ShouldReturnTrue() throws InvalidWeaponException {
        // Arrange
        double expected = 8.085;
        Warrior testWarrior = new Warrior("Grog");
        Weapon testWeapon = new Weapon("Common Axe", 1, Weapon.TypesOfWeapons.AXE, 7, 1.1);
        // Act
        testWarrior.EquipItem(testWeapon);
        double actual = testWarrior.getDps();

        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void getDPS_CalculateDpsForLevel1WarriorWithValidWeaponAndValidArmor_ShouldReturnTrue() throws InvalidWeaponException, InvalidArmorException {
        // Arrange
        double expected = 8.085;
        Warrior testWarrior = new Warrior("Grog");
        Weapon testWeapon = new Weapon("Common Axe", 1, Weapon.TypesOfWeapons.AXE, 7, 1.1);
        Armor testArmor = new Armor("Common Plate Body Armor", 1, Item.Slot.BODY, Armor.TypesOfArmor.PLATE,
                new PrimaryAttributes(1,0,0));
        // Act
        testWarrior.EquipItem(testWeapon);
        testWarrior.EquipItem(testArmor);
        double actual = testWarrior.getDps();

        //Assert
        assertEquals(expected, actual);
    }
}