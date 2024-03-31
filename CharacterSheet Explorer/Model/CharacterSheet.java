package Model;

import java.io.IOException;

public class CharacterSheet {
    FileAccess fileAccess = new FileAccess();

    private int id;
    private String name;
    private String characterClass;
    private int level;
    private String race;
    private String background;
    private String alignment;

    private boolean inspiration;
    private int pb;
    
    private int armorClass;
    private int initiative;
    private int speed;

    private int maxHitPoints;
    private int currentHitPoints;
    private int tempHitPoits;
    
    private String hitDice;
    
    private int strenght, dexterity, constitution, intelligence, wisdom, charisma;
    
    private boolean strSave, dexSave, conSave, intSave, wisSave, chaSave;
    private boolean acrobatics, animalHandling, arcana, athletics, deception, history, insight, intimidation,
                    investigation, medicine, nature, perception, perfomance, persuasion, religion, 
                    sleightOfHands, stealth, survival;
        


    public CharacterSheet(int id, String name, int level, String characterClass, String race, 
                          int strenght, int dexterity, int constitution, int intelligence, 
                          int wisdom, int charisma) throws IOException
    {
        this.id = id;
        this.name = name;
        this.level = level;
        this.characterClass = characterClass;
        this.race = race;
        this.strenght = strenght;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public CharacterSheet(String name, int level, String characterClass, String race, 
                          int strenght, int dexterity, int constitution, int intelligence, 
                          int wisdom, int charisma) throws IOException
    {
        this.id = fileAccess.caracterSheetReader("sheets.txt").size() + 1;
        this.name = name;
        this.level = level;
        this.characterClass = characterClass;
        this.race = race;
        this.strenght = strenght;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public CharacterSheet(){}

    public String toString()
    {
        String characterSheet = id + ";" + name + ";" + characterClass + ";" + level + ";" + race + ";" 
                              + strenght + ";" + dexterity + ";" + constitution + ";" 
                              + intelligence + ";" + wisdom + ";" + charisma + "\n";
        return characterSheet;
    }

    public String getName()
    {
        return name;
    }
    public String getRace()
    {
        return race;
    }
    public String getCharacterClass()
    {
        return characterClass;
    }
    public int getLevel()
    {
        return level;
    }
    public int getId()
    {
        return id;
    }
    public int getStrenght()
    {
        return strenght;
    }
    public int getDexterity()
    {
        return dexterity;
    }
    public int getConstitution()
    {
        return constitution;
    }
    public int getIntelligence()
    {
        return intelligence;
    }
    public int getWisdom()
    {
        return wisdom;
    }
    public int getCharisma()
    {
        return charisma;
    }
}
