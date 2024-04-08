package Model;

import java.io.IOException;

public class CharacterSheet {
    FileAccess fileAccess = new FileAccess();

    private int id;
    private String name;
    private String characterClass;
    private int level;
    private int xp;
    private String race;
    private String background;

    private boolean inspiration;
    private int pb;
    
    private int armorClass;
    private int initiative;
    private String speed;

    private int maxHitPoints;
    private int currentHitPoints;
    private int tempHitPoits;
    
    private String maxHitDice;
    private String currentHitDice;
    
    private Attributes attributes; 
    private Skills skills;

    private String abilitySpell;
    private int spellDC;
    private int spellAttack;
    
    private int cp, sp, ep, gp, pp;

    private String notes; 

    public CharacterSheet(int id, String name, int xp, String characterClass, String race, String background,
                          Attributes attributes, int pb, boolean inspiration, int armorClass, int initiative,
                          String speed, int maxHitPoints, int currentHitPoints, int tempHitPoits, String maxHitDice,
                          String currentHitDice, Skills skills, String abilitySpell, int spellDC, int spellAttack, 
                          int cp, int sp, int ep, int gp, int pp, String notes) throws IOException
    {
        this.id = id;
        this.name = name;
        this.xp = xp;
        this.characterClass = characterClass;
        this.race = race;
        this.background = background;
        this.attributes = attributes;
        this.pb = pb;
        this.inspiration = inspiration;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = currentHitPoints;
        this.tempHitPoits = tempHitPoits;
        this.maxHitDice = maxHitDice;
        this.currentHitDice = currentHitDice;
        this.skills = skills;
        this.cp = cp;
        this.sp = sp;
        this.ep = ep;
        this.gp = gp;
        this.pp = pp;
        this.notes = notes;
        this.abilitySpell = abilitySpell;
        this.spellDC = spellDC;
        this.spellAttack = spellAttack;
    }
    public CharacterSheet(String name, int xp, String characterClass, String race, String background,
                          Attributes attributes, int pb, boolean inspiration, int armorClass, int initiative,
                          String speed, int maxHitPoints, int currentHitPoints, int tempHitPoits, String maxHitDice,
                          String currentHitDice, Skills skills, String abilitySpell, int spellDC, int spellAttack, int cp, int sp, int ep, int gp, int pp,
                          String notes) throws IOException
    {
        this.id = fileAccess.caracterSheetReader("Sheets/sheets.txt").size() + 1;
        this.name = name;
        this.xp = xp;
        this.characterClass = characterClass;
        this.race = race;
        this.background = background;
        this.attributes = attributes;
        this.pb = pb;
        this.inspiration = inspiration;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = currentHitPoints;
        this.tempHitPoits = tempHitPoits;
        this.maxHitDice = maxHitDice;
        this.currentHitDice = currentHitDice;
        this.skills = skills;
        this.cp = cp;
        this.sp = sp;
        this.ep = ep;
        this.gp = gp;
        this.pp = pp;
        this.notes = notes;
        this.abilitySpell = abilitySpell;
        this.spellDC = spellDC;
        this.spellAttack = spellAttack;
    }

    public CharacterSheet(){}

    @Override
    public String toString()
    {
        if(notes == "")
        {
            notes = " ";
        } else
        {
            notes = notes.replaceAll("\n", "\\+");
        }
        String characterSheet = id + ";" + name + ";" + characterClass + ";" + xp + ";" + race + ";" + background + ";"
                                + inspiration + ";" + pb + ";" + armorClass + ";" + initiative + ";" + speed + ";" +
                                maxHitPoints + ";" + currentHitPoints + ";" + tempHitPoits + ";" + maxHitDice + ";" +
                                currentHitDice + ";" + attributes.toString() + ";" + skills.toString() + ";" + abilitySpell
                                + ";" + spellDC + ";" + spellAttack + ";" + cp + ";" + sp + ";" + ep + ";" + gp 
                                + ";" + pp + ";" + notes + "\n";

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
    public String getBackground()
    {
        return background;
    }
    public int getXp()
    {
        return xp;
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
    public Attributes getAttributes()
    {
        return attributes;
    }
    public boolean isInspiration() {
        return inspiration;
    }
    public int getPb() {
        return pb;
    }
    public int getArmorClass() {
        return armorClass;
    }
    public int getInitiative() {
        return initiative;
    }
    public String getSpeed() {
        return speed;
    }
    public int getMaxHitPoints() {
        return maxHitPoints;
    }
    public int getCurrentHitPoints() {
        return currentHitPoints;
    }
    public int getTempHitPoits() {
        return tempHitPoits;
    }
    public String getMaxHitDice() {
        return maxHitDice;
    }
    public String getCurrentHitDice() {
        return currentHitDice;
    }
    public Skills getSkills() {
        return skills;
    }
    public void setSkills(Skills skills) {
        this.skills = skills;
    }
    public FileAccess getFileAccess() {
        return fileAccess;
    }
    public String getAbilitySpell() {
        return abilitySpell;
    }
    public int getSpellDC() {
        return spellDC;
    }
    public int getSpellAttack() {
        return spellAttack;
    }
    public int getCp() {
        return cp;
    }
    public int getSp() {
        return sp;
    }
    public int getEp() {
        return ep;
    }
    public int getGp() {
        return gp;
    }
    public int getPp() {
        return pp;
    }
    public String getNotes() {
        return notes;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public void setBackground(String background) {
        this.background = background;
    }
    public void setInspiration(boolean inspiration) {
        this.inspiration = inspiration;
    }
    public void setPb(int pb) {
        this.pb = pb;
    }
    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
    public void setSpeed(String speed) {
        this.speed = speed;
    }
    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }
    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }
    public void setTempHitPoits(int tempHitPoits) {
        this.tempHitPoits = tempHitPoits;
    }
    public void setMaxHitDice(String maxHitDice) {
        this.maxHitDice = maxHitDice;
    }
    public void setCurrentHitDice(String currentHitDice) {
        this.currentHitDice = currentHitDice;
    }
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
    public void setAbilitySpell(String abilitySpell) {
        this.abilitySpell = abilitySpell;
    }
    public void setSpellDC(int spellDC) {
        this.spellDC = spellDC;
    }
    public void setSpellAttack(int spellAttack) {
        this.spellAttack = spellAttack;
    }
    public void setCp(int cp) {
        this.cp = cp;
    }
    public void setSp(int sp) {
        this.sp = sp;
    }
    public void setEp(int ep) {
        this.ep = ep;
    }
    public void setGp(int gp) {
        this.gp = gp;
    }
    public void setPp(int pp) {
        this.pp = pp;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}
