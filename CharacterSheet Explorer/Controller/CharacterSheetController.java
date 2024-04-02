package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Attributes;
import Model.CharacterSheet;
import Model.FileAccess;
import Model.Item;
import Model.Skills;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CharacterSheetController implements Initializable{
    private Stage stage;
    private Parent root;

    @FXML private Label idField;

    @FXML private TextField nameField;
    @FXML private TextField characterClassField;
    @FXML private TextField xpField;
    @FXML private TextField raceField;
    @FXML private TextField backgroundField;
    
    @FXML private RadioButton inspirationRadio;
    @FXML private TextField pbField;

    @FXML private RadioButton strSaveRadio;
    @FXML private RadioButton conSaveRadio;
    @FXML private RadioButton dexSaveRadio;
    @FXML private RadioButton intSaveRadio;
    @FXML private RadioButton wisSaveRadio;
    @FXML private RadioButton chaSaveRadio;

    @FXML private TextField strenghtField;
    @FXML private Label strenghtModField;
    @FXML private TextField dexterityField;
    @FXML private Label dexterityModField;
    @FXML private TextField constitutionField;
    @FXML private Label constitutionModField;
    @FXML private TextField intelligenceField;
    @FXML private Label intelligenceModField;
    @FXML private TextField wisdomField;
    @FXML private Label wisdomModField;
    @FXML private TextField charismaField;
    @FXML private Label charismaModField;

    @FXML private TextField armorClassField;
    @FXML private TextField speedField;
    @FXML private TextField initiativeField;
    @FXML private TextField maxHPField;
    @FXML private TextField currentHPField;
    @FXML private TextField tempHPField;
    @FXML private TextField totalHitDiceField;
    @FXML private TextField currentHitDiceField;

    @FXML private RadioButton acrobaticsRadio;
    @FXML private RadioButton animalHandlingRadio;
    @FXML private RadioButton arcanaRadio;
    @FXML private RadioButton athleticsRadio;
    @FXML private RadioButton deceptionRadio;
    @FXML private RadioButton historyRadio;
    @FXML private RadioButton insightRadio;
    @FXML private RadioButton intimidationRadio;
    @FXML private RadioButton investigationRadio;
    @FXML private RadioButton medicineRadio;
    @FXML private RadioButton natureRadio;
    @FXML private RadioButton perceptionRadio;
    @FXML private RadioButton perfomanceRadio;
    @FXML private RadioButton persuasionRadio;
    @FXML private RadioButton religionRadio;
    @FXML private RadioButton sleightOfHandsRadio;
    @FXML private RadioButton stealthRadio;
    @FXML private RadioButton survivalRadio;
    
    @FXML private TextField abilitySpellField;
    @FXML private TextField spellDCField;
    @FXML private TextField attackSpellField;

    @FXML private TextField cpField;
    @FXML private TextField spField;
    @FXML private TextField epField;
    @FXML private TextField gpField;
    @FXML private TextField ppField;
    
    @SuppressWarnings("rawtypes")
    @FXML private TableView equipmentTable = new TableView<Item>();
    @SuppressWarnings("rawtypes")
    @FXML private TableColumn itemColumm = new TableColumn<Item, String>("Item");
    @SuppressWarnings("rawtypes")
    @FXML private TableColumn quantityColumm = new TableColumn<Item, Integer>("Quantity");

    @FXML private TextField itemNameField;
    @FXML private TextField itemQuantityField;
    
    @FXML private Button addItem;
    
    @FXML private TextArea notesField;

    FileAccess fileAccess = new FileAccess();
    
    @SuppressWarnings("unchecked")
    public void fillCharacterSheet(CharacterSheet characterSheet)
    {
        idField.setText(String.valueOf(characterSheet.getId()));

        nameField.setText(characterSheet.getName());
        characterClassField.setText(characterSheet.getCharacterClass());
        xpField.setText(String.valueOf(characterSheet.getXp()));
        raceField.setText(characterSheet.getRace());
        backgroundField.setText(characterSheet.getBackground());

        inspirationRadio.setSelected(characterSheet.isInspiration());
        pbField.setText(String.valueOf(characterSheet.getPb()));

        // Attributes
        strenghtField.setText(String.valueOf(characterSheet.getAttributes().getStrenght()));
        strenghtModField.setText(String.valueOf(((characterSheet.getAttributes().getStrenght()-10)/2)));
        dexterityField.setText(String.valueOf(characterSheet.getAttributes().getDexterity()));
        dexterityModField.setText(String.valueOf(((characterSheet.getAttributes().getDexterity()-10)/2)));
        constitutionField.setText(String.valueOf(characterSheet.getAttributes().getConstitution()));        
        constitutionModField.setText(String.valueOf(((characterSheet.getAttributes().getConstitution()-10)/2)));
        intelligenceField.setText(String.valueOf(characterSheet.getAttributes().getIntelligence()));
        intelligenceModField.setText(String.valueOf(((characterSheet.getAttributes().getIntelligence()-10)/2)));
        wisdomField.setText(String.valueOf(characterSheet.getAttributes().getWisdom()));
        wisdomModField.setText(String.valueOf(((characterSheet.getAttributes().getWisdom()-10)/2)));
        charismaField.setText(String.valueOf(characterSheet.getAttributes().getCharisma()));
        charismaModField.setText(String.valueOf(((characterSheet.getAttributes().getCharisma()-10)/2)));

        // Saving Throws
        strSaveRadio.setSelected(characterSheet.getAttributes().isStrSave());
        dexSaveRadio.setSelected(characterSheet.getAttributes().isDexSave());
        conSaveRadio.setSelected(characterSheet.getAttributes().isConSave());
        intSaveRadio.setSelected(characterSheet.getAttributes().isIntSave());
        wisSaveRadio.setSelected(characterSheet.getAttributes().isWisSave());
        chaSaveRadio.setSelected(characterSheet.getAttributes().isChaSave());

        // Status
        armorClassField.setText(String.valueOf(characterSheet.getArmorClass()));
        speedField.setText(characterSheet.getSpeed());
        initiativeField.setText(String.valueOf(characterSheet.getInitiative()));
        maxHPField.setText(String.valueOf(characterSheet.getMaxHitPoints()));
        currentHPField.setText(String.valueOf(characterSheet.getCurrentHitPoints()));
        tempHPField.setText(String.valueOf(characterSheet.getTempHitPoits()));
        totalHitDiceField.setText(String.valueOf(characterSheet.getMaxHitDice()));
        currentHitDiceField.setText(String.valueOf(characterSheet.getCurrentHitDice()));

        // Skills
        acrobaticsRadio.setSelected(characterSheet.getSkills().isAcrobatics());
        animalHandlingRadio.setSelected(characterSheet.getSkills().isAnimalHandling());
        arcanaRadio.setSelected(characterSheet.getSkills().isArcana());
        athleticsRadio.setSelected(characterSheet.getSkills().isAtlhetics());
        deceptionRadio.setSelected(characterSheet.getSkills().isDeception());
        historyRadio.setSelected(characterSheet.getSkills().isHistory());
        insightRadio.setSelected(characterSheet.getSkills().isInsight());
        intimidationRadio.setSelected(characterSheet.getSkills().isIntimitadion());
        investigationRadio.setSelected(characterSheet.getSkills().isInvestigation());
        medicineRadio.setSelected(characterSheet.getSkills().isMedicine());
        natureRadio.setSelected(characterSheet.getSkills().isNature());
        perceptionRadio.setSelected(characterSheet.getSkills().isPerception());
        perfomanceRadio.setSelected(characterSheet.getSkills().isPerfomance());
        persuasionRadio.setSelected(characterSheet.getSkills().isPersuasion());
        religionRadio.setSelected(characterSheet.getSkills().isReligion());
        sleightOfHandsRadio.setSelected(characterSheet.getSkills().isSleightOfHands());
        stealthRadio.setSelected(characterSheet.getSkills().isStealth());
        survivalRadio.setSelected(characterSheet.getSkills().isSurvival());
        
        // Spell
        if(!characterSheet.getAbilitySpell().isEmpty())
        {
            abilitySpellField.setText(characterSheet.getAbilitySpell());
            spellDCField.setText(String.valueOf(characterSheet.getSpellDC()));
            attackSpellField.setText(String.valueOf(characterSheet.getSpellAttack()));
        }

        // Money
        cpField.setText(String.valueOf(characterSheet.getCp()));
        spField.setText(String.valueOf(characterSheet.getSp()));
        epField.setText(String.valueOf(characterSheet.getEp()));
        gpField.setText(String.valueOf(characterSheet.getGp()));
        ppField.setText(String.valueOf(characterSheet.getPp()));

        // Items
        itemColumm.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        quantityColumm.setCellValueFactory(new PropertyValueFactory<Item, String>("quantity"));

        try {
            equipmentTable.getItems().addAll(fileAccess.equipmentReader("Sheets/equipments.txt", characterSheet));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        equipmentTable.getColumns().clear();
        equipmentTable.getColumns().add(itemColumm);
        equipmentTable.getColumns().add(quantityColumm);

        // Notes
        notesField.setText(characterSheet.getNotes());
    }

    @SuppressWarnings("unchecked")
    public void updateCharacterSheet(ActionEvent event) throws IOException
    {
        int id = Integer.parseInt(idField.getText());

        String name = nameField.getText();
        String characterClass = characterClassField.getText();
        int xp = Integer.parseInt(xpField.getText());
        String race = raceField.getText();
        String background = backgroundField.getText();

        int strenght = Integer.parseInt(strenghtField.getText());
        int dexterity = Integer.parseInt(dexterityField.getText());
        int constitution = Integer.parseInt(constitutionField.getText());
        int intelligence = Integer.parseInt(intelligenceField.getText());
        int wisdom = Integer.parseInt(wisdomField.getText());
        int charisma = Integer.parseInt(charismaField.getText());

        // Saving Throws
        boolean strSave = strSaveRadio.isSelected();
        boolean dexSave = dexSaveRadio.isSelected();
        boolean conSave = conSaveRadio.isSelected();
        boolean intSave = intSaveRadio.isSelected();
        boolean wisSave = wisSaveRadio.isSelected();
        boolean chaSave = chaSaveRadio.isSelected();
        
        boolean inspiration = inspirationRadio.isSelected();
        int pb = Integer.parseInt(pbField.getText());
        int armorClass = Integer.parseInt(armorClassField.getText());
        int initiative = Integer.parseInt(initiativeField.getText());
        String speed = speedField.getText();
        int maxHP = Integer.parseInt(maxHPField.getText());
        int currentHP = Integer.parseInt(currentHPField.getText());
        int tempHP = Integer.parseInt(tempHPField.getText());
        String currentHitDice = currentHitDiceField.getText();
        String totalHitDice = totalHitDiceField.getText();

        boolean acrobatics = acrobaticsRadio.isSelected();
        boolean animalHandling = animalHandlingRadio.isSelected();
        boolean arcana = arcanaRadio.isSelected();
        boolean atlhetics = athleticsRadio.isSelected();
        boolean deception = deceptionRadio.isSelected();
        boolean history = historyRadio.isSelected();
        boolean insight = insightRadio.isSelected();
        boolean intimitadion = intimidationRadio.isSelected();
        boolean investigation = investigationRadio.isSelected();
        boolean medicine = medicineRadio.isSelected();
        boolean nature = natureRadio.isSelected();
        boolean perception = perceptionRadio.isSelected();
        boolean perfomance = perfomanceRadio.isSelected();
        boolean persuasion = persuasionRadio.isSelected();
        boolean religion = religionRadio.isSelected();
        boolean sleightOfHands = sleightOfHandsRadio.isSelected();
        boolean stealth = stealthRadio.isSelected();
        boolean survival = survivalRadio.isSelected();

        String spellAbility = abilitySpellField.getText();
        int spellDC = Integer.parseInt(spellDCField.getText());
        int attackSpell = Integer.parseInt(attackSpellField.getText());
        
        int cp = Integer.parseInt(cpField.getText());
        int sp = Integer.parseInt(spField.getText());
        int ep = Integer.parseInt(epField.getText());
        int gp = Integer.parseInt(gpField.getText());
        int pp = Integer.parseInt(ppField.getText());

        String notes = notesField.getText();

        // Save Character

        Attributes attributes = new Attributes(strenght, dexterity, constitution, intelligence, wisdom, charisma, 
                                               strSave, dexSave, conSave, intSave, wisSave, chaSave);

        Skills skills = new Skills(acrobatics, animalHandling, arcana, atlhetics, deception, history, insight, 
                                   intimitadion, investigation, medicine, nature, perception, perfomance, persuasion, 
                                   religion, sleightOfHands, stealth, survival);

        CharacterSheet newCharacterSheet = new CharacterSheet(id, name, xp, characterClass, race, background, attributes, pb, 
                                                          inspiration, armorClass, initiative, speed, maxHP, currentHP, 
                                                          tempHP, totalHitDice, currentHitDice, skills, spellAbility, 
                                                          spellDC, attackSpell, cp, sp, ep, gp, pp, notes);

        // Update Character
        ObservableList<Item> equipmentListUpdate = equipmentTable.getItems();
        for(Item item : equipmentListUpdate)
        {
            System.out.println(item.toString());
        }

        fileAccess.updateCharacter("Sheets/sheets.txt", newCharacterSheet, equipmentListUpdate);

    }

    public void gotoViewCharacterSheets(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/ViewCharacterList.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @SuppressWarnings("unchecked")
    public void addNewEquipment(ActionEvent event) throws IOException
    {

        String itemName = itemNameField.getText();
        int itemQuantity = Integer.parseInt(itemQuantityField.getText());
        int id = Integer.parseInt(idField.getText());

        equipmentTable.getItems().add(new Item(id, itemName, itemQuantity));
                                             
        itemNameField.setText("");
        itemQuantityField.setText("");
                             
    }
    
    public void removeSelectedItem(ActionEvent event)
    {
        Item selectedItem = (Item) equipmentTable.getSelectionModel().getSelectedItem();
        equipmentTable.getItems().remove(selectedItem);
    }
}
