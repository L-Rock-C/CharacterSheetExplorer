package Model;

public class Attributes 
{
    private int strenght, dexterity, constitution, intelligence, wisdom, charisma;
    private boolean strSave, dexSave, conSave, intSave, wisSave, chaSave;

    public Attributes(int strenght, int dexterity, int constitution, int intelligence, int wisdom, int charisma,
            boolean strSave, boolean dexSave, boolean conSave, boolean intSave, boolean wisSave, boolean chaSave) {
        this.strenght = strenght;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.strSave = strSave;
        this.dexSave = dexSave;
        this.conSave = conSave;
        this.intSave = intSave;
        this.wisSave = wisSave;
        this.chaSave = chaSave;
    }

    @Override
    public String toString()
    {
        String attToString = String.valueOf(strenght) + ";" + String.valueOf(dexterity) +  ";" + String.valueOf(constitution)
                           + ";" + String.valueOf(intelligence) +  ";" + String.valueOf(wisdom) +  ";" + String.valueOf(charisma)
                           + ";" + String.valueOf(strSave) + ";" + String.valueOf(dexSave) + ";" +  String.valueOf(conSave)
                           + ";" +  String.valueOf(intSave) + ";" +  String.valueOf(wisSave) + ";" +  String.valueOf(chaSave);
        return attToString;
    }

    // Getters and Setters
    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public boolean isStrSave() {
        return strSave;
    }

    public void setStrSave(boolean strSave) {
        this.strSave = strSave;
    }

    public boolean isDexSave() {
        return dexSave;
    }

    public void setDexSave(boolean dexSave) {
        this.dexSave = dexSave;
    }

    public boolean isConSave() {
        return conSave;
    }

    public void setConSave(boolean conSave) {
        this.conSave = conSave;
    }

    public boolean isIntSave() {
        return intSave;
    }

    public void setIntSave(boolean intSave) {
        this.intSave = intSave;
    }

    public boolean isWisSave() {
        return wisSave;
    }

    public void setWisSave(boolean wisSave) {
        this.wisSave = wisSave;
    }

    public boolean isChaSave() {
        return chaSave;
    }

    public void setChaSave(boolean chaSave) {
        this.chaSave = chaSave;
    }
}
