package Items.Characters;

import Attributes.PrimaryAttributes;
import Characters.Mage;
import Characters.Ranger;
import Characters.Rogue;
import Characters.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    public void CharacterIsLevelOneWhenCreated_ShouldReturnTrue() {
        //Arrange
        Warrior testWarrior = new Warrior("Grog");
        int expected = 1;
        //Act
        int actual = testWarrior.getLevel();
        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void CharacterGainsLevel_ShouldLevelUpToLevel2() {
        // Arrange
        int expected = 2;
        // Act
        Warrior testWarrior = new Warrior("Grog");
        testWarrior.LevelUp();
        int actual = testWarrior.getLevel();
        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void StartsWith_WarriorStartsWithCorrectPrimaryAttributes_ShouldReturnTrue()
    {
        // Arrange
        int expectedStrength = 5;
        int expectedDexterity = 2;
        int expectedIntelligence = 1;

        // Act
        Warrior testWarrior = new Warrior("Orum");
        PrimaryAttributes actual = testWarrior.getBasePrimaryAttributes();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);

    }
    @Test
    public void StartsWith_MageStartsWithCorrectPrimaryAttributes_ShouldReturnTrue()
    {
        // Arrange
        int expectedStrength = 1;
        int expectedDexterity = 1;
        int expectedIntelligence = 8;

        // Act
        Mage testMage = new Mage("Ladna");
        PrimaryAttributes actual = testMage.getBasePrimaryAttributes();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);

    }
    @Test
    public void StartsWith_RogueStartsWithCorrectPrimaryAttributes_ShouldReturnTrue()
    {
        // Arrange
        int expectedStrength = 2;
        int expectedDexterity = 6;
        int expectedIntelligence = 1;

        // Act
        Rogue testRogue = new Rogue("Vex");
        PrimaryAttributes actual = testRogue.getBasePrimaryAttributes();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }
    @Test
    public void StartsWith_RangerStartsWithCorrectPrimaryAttributes_ShouldReturnTrue()
    {
        // Arrange
        int expectedStrength = 1;
        int expectedDexterity = 7;
        int expectedIntelligence = 1;

        // Act
        Ranger testRanger = new Ranger("Vax");
        PrimaryAttributes actual = testRanger.getBasePrimaryAttributes();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }
    @Test
    public void LevelUp_WarriorPrimaryAttributesIncreaseWhenLeveledUp()
    {
        // Arrange
        int expectedStrength = 8;
        int expectedDexterity = 4;
        int expectedIntelligence = 2;

        // Act
        Warrior testWarrior = new Warrior("Grog");
        testWarrior.LevelUp();
        testWarrior.getTotalPrimaryAttributes();
        PrimaryAttributes actual = testWarrior.getTotalPrimaryAttributes();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }
    @Test
    public void LevelUp_MagePrimaryAttributesIncreaseWhenLeveledUp()
    {
        // Arrange
        int expectedStrength = 2;
        int expectedDexterity = 2;
        int expectedIntelligence = 13;

        // Act
        Mage testMage = new Mage("Ladna");
        testMage.LevelUp();
        testMage.getTotalPrimaryAttributes();
        PrimaryAttributes actual = testMage.getTotalPrimaryAttributes();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }
    @Test
    public void LevelUp_RoguePrimaryAttributesIncreaseWhenLeveledUp()
    {
        // Arrange
        int expectedStrength = 3;
        int expectedDexterity = 10;
        int expectedIntelligence = 2;

        // Act
        Rogue testRogue = new Rogue("Vex");
        testRogue.LevelUp();
        testRogue.getTotalPrimaryAttributes();
        PrimaryAttributes actual = testRogue.getTotalPrimaryAttributes();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }
    @Test
    public void LevelUp_RangerPrimaryAttributesIncreaseWhenLeveledUp()
    {
        // Arrange
        int expectedStrength = 2;
        int expectedDexterity = 12;
        int expectedIntelligence = 2;

        // Act
        Ranger testRanger = new Ranger("Vax");
        testRanger.LevelUp();
        testRanger.getTotalPrimaryAttributes();
        PrimaryAttributes actual = testRanger.getTotalPrimaryAttributes();
        int actualStrength = actual.getStrength();
        int actualDexterity = actual.getDexterity();
        int actualIntelligence = actual.getIntelligence();

        // Assert
        assertEquals(expectedStrength, actualStrength);
        assertEquals(expectedDexterity, actualDexterity);
        assertEquals(expectedIntelligence, actualIntelligence);
    }


}