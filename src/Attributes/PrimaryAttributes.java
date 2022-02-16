package Attributes;

public class PrimaryAttributes {
    public int Strength;
    public int Dexterity;
    public int Intelligence;

    public int getStrength() {
        return Strength;
    }
    public void setStrength(int strength) {
        Strength = strength;
    }
    public int getDexterity() {
        return Dexterity;
    }
    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }
    public int getIntelligence() {
        return Intelligence;
    }
    public void setIntelligence(int intelligence) {
        Intelligence = intelligence;
    }
    public PrimaryAttributes(int strength, int dexterity, int intelligence) {
        Strength = strength;
        Dexterity = dexterity;
        Intelligence = intelligence;
    }

    /**
     * summing two different sets of attributes that will be used to count total
     * @param levelingUpAttributes
     * @return
     */
    public PrimaryAttributes addAttributes(PrimaryAttributes levelingUpAttributes) {
        return (new PrimaryAttributes(getStrength() + levelingUpAttributes.getStrength(),
                getDexterity() + levelingUpAttributes.getDexterity(), getIntelligence() + levelingUpAttributes.getIntelligence()));
    }

    /**
     * subtracting values of different set of attributes
     * @param removeAttributes
     * @return
     */
    public PrimaryAttributes removeAttributes(PrimaryAttributes removeAttributes) {
        return (new PrimaryAttributes(getStrength() + removeAttributes.getStrength(),
                getDexterity() + removeAttributes.getDexterity(), getIntelligence() + removeAttributes.getIntelligence()));
    }

}