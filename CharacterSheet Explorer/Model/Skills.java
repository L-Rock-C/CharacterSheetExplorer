package Model;

public class Skills 
{
    boolean acrobatics, animalHandling, arcana, atlhetics, deception, history, insight, intimitadion, investigation,
            medicine, nature, perception, perfomance, persuasion, religion, sleightOfHands, stealth, survival;

    public Skills(boolean acrobatics, boolean animalHandling, boolean arcana, boolean atlhetics, boolean deception,
            boolean history, boolean insight, boolean intimitadion, boolean investigation, boolean medicine,
            boolean nature, boolean perception, boolean perfomance, boolean persuasion, boolean religion,
            boolean sleightOfHands, boolean stealth, boolean survival) {
        this.acrobatics = acrobatics;
        this.animalHandling = animalHandling;
        this.arcana = arcana;
        this.atlhetics = atlhetics;
        this.deception = deception;
        this.history = history;
        this.insight = insight;
        this.intimitadion = intimitadion;
        this.investigation = investigation;
        this.medicine = medicine;
        this.nature = nature;
        this.perception = perception;
        this.perfomance = perfomance;
        this.persuasion = persuasion;
        this.religion = religion;
        this.sleightOfHands = sleightOfHands;
        this.stealth = stealth;
        this.survival = survival;
    }

    @Override
    public String toString()
    {
        String skillsToString = String.valueOf(acrobatics) + ";" + String.valueOf(animalHandling) + ";" +
                                String.valueOf(arcana) + ";" + String.valueOf(atlhetics) + ";" +
                                String.valueOf(deception) + ";" + String.valueOf(history) + ";" +
                                String.valueOf(insight) + ";" + String.valueOf(intimitadion) + ";" +
                                String.valueOf(investigation) + ";"  + String.valueOf(medicine) + ";" +
                                String.valueOf(nature) + ";" + String.valueOf(perception) + ";" +
                                String.valueOf(perfomance) + ";" + String.valueOf(persuasion) + ";" +
                                String.valueOf(religion) + ";" + String.valueOf(sleightOfHands) + ";" +
                                String.valueOf(stealth) + ";" + String.valueOf(survival);

        return skillsToString;
    }

    public boolean isAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(boolean acrobatics) {
        this.acrobatics = acrobatics;
    }

    public boolean isAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(boolean animalHandling) {
        this.animalHandling = animalHandling;
    }

    public boolean isArcana() {
        return arcana;
    }

    public void setArcana(boolean arcana) {
        this.arcana = arcana;
    }

    public boolean isAtlhetics() {
        return atlhetics;
    }

    public void setAtlhetics(boolean atlhetics) {
        this.atlhetics = atlhetics;
    }

    public boolean isDeception() {
        return deception;
    }

    public void setDeception(boolean deception) {
        this.deception = deception;
    }

    public boolean isHistory() {
        return history;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public boolean isInsight() {
        return insight;
    }

    public void setInsight(boolean insight) {
        this.insight = insight;
    }

    public boolean isIntimitadion() {
        return intimitadion;
    }

    public void setIntimitadion(boolean intimitadion) {
        this.intimitadion = intimitadion;
    }

    public boolean isInvestigation() {
        return investigation;
    }

    public void setInvestigation(boolean investigation) {
        this.investigation = investigation;
    }

    public boolean isMedicine() {
        return medicine;
    }

    public void setMedicine(boolean medicine) {
        this.medicine = medicine;
    }

    public boolean isNature() {
        return nature;
    }

    public void setNature(boolean nature) {
        this.nature = nature;
    }

    public boolean isPerception() {
        return perception;
    }

    public void setPerception(boolean perception) {
        this.perception = perception;
    }

    public boolean isPerfomance() {
        return perfomance;
    }

    public void setPerfomance(boolean perfomance) {
        this.perfomance = perfomance;
    }

    public boolean isPersuasion() {
        return persuasion;
    }

    public void setPersuasion(boolean persuasion) {
        this.persuasion = persuasion;
    }

    public boolean isReligion() {
        return religion;
    }

    public void setReligion(boolean religion) {
        this.religion = religion;
    }

    public boolean isSleightOfHands() {
        return sleightOfHands;
    }

    public void setSleightOfHands(boolean sleightOfHands) {
        this.sleightOfHands = sleightOfHands;
    }

    public boolean isStealth() {
        return stealth;
    }

    public void setStealth(boolean stealth) {
        this.stealth = stealth;
    }

    public boolean isSurvival() {
        return survival;
    }

    public void setSurvival(boolean survival) {
        this.survival = survival;
    }

    
}
