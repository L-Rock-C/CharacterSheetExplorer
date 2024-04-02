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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CreateCharacterController implements Initializable{
    private Stage stage;
    private Parent root;

    @FXML private TextField nameField;
    @FXML private TextField characterClassField;
    @FXML private TextField xpField;
    @FXML private TextField raceField;
    @FXML private TextField backgroundField;

    @FXML private TextField strenghtField;
    @FXML private TextField dexterityField;
    @FXML private TextField constitutionField;
    @FXML private TextField intelligenceField;
    @FXML private TextField wisdomField;
    @FXML private TextField charismaField; 
    
    @FXML private RadioButton strSaveRadio;
    @FXML private RadioButton conSaveRadio;
    @FXML private RadioButton dexSaveRadio;
    @FXML private RadioButton intSaveRadio;
    @FXML private RadioButton wisSaveRadio;
    @FXML private RadioButton chaSaveRadio;

    @FXML private RadioButton inspirationRadio;
    @FXML private TextField pbField;
    @FXML private TextField armorClassField;
    @FXML private TextField initiativeField;
    @FXML private TextField speedField;
    @FXML private TextField maxHPField;
    @FXML private TextField currentHPField;
    @FXML private TextField tempHPField;
    @FXML private TextField currentHitDiceField;
    @FXML private TextField totalHitDiceField;

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemColumm.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        quantityColumm.setCellValueFactory(new PropertyValueFactory<Item, String>("quantity"));

        equipmentTable.getColumns().clear();
        equipmentTable.getColumns().add(itemColumm);
        equipmentTable.getColumns().add(quantityColumm);
    }

    @SuppressWarnings("unchecked")
    public void addNewEquipment(ActionEvent event) throws IOException
    {
        String itemName = itemNameField.getText();
        int itemQuantity = Integer.parseInt(itemQuantityField.getText());

        equipmentTable.getItems().add(new Item(fileAccess.caracterSheetReader("Sheets/sheets.txt").size() + 1, 
                                                itemName, itemQuantity));
                                             
        System.out.println(equipmentTable.getSelectionModel().getSelectedItem());
        itemNameField.setText("");
        itemQuantityField.setText("");
                             
    }

    public void removeSelectedItem(ActionEvent event)
    {
        Item selectedItem = (Item) equipmentTable.getSelectionModel().getSelectedItem();
        equipmentTable.getItems().remove(selectedItem);
    }

    @SuppressWarnings("unchecked")
    public void saveCharacterSheet(ActionEvent event) throws IOException
    {
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
        ArrayList<CharacterSheet> characterSheets;
        characterSheets = fileAccess.caracterSheetReader("Sheets/sheets.txt");

        Attributes attributes = new Attributes(strenght, dexterity, constitution, intelligence, wisdom, charisma, 
                                               strSave, dexSave, conSave, intSave, wisSave, chaSave);

        Skills skills = new Skills(acrobatics, animalHandling, arcana, atlhetics, deception, history, insight, 
                                   intimitadion, investigation, medicine, nature, perception, perfomance, persuasion, 
                                   religion, sleightOfHands, stealth, survival);

        CharacterSheet newCharacterSheet = new CharacterSheet(name, xp, characterClass, race, background, attributes, pb, 
                                                          inspiration, armorClass, initiative, speed, maxHP, currentHP, 
                                                          tempHP, totalHitDice, currentHitDice, skills, spellAbility, 
                                                          spellDC, attackSpell, cp, sp, ep, gp, pp, notes);

        characterSheets.add(newCharacterSheet);

        String fileCharacterContent = "";
        for(CharacterSheet characterSheet : characterSheets)
        {
            fileCharacterContent += characterSheet.toString();
        }
        fileAccess.WriteFile("Sheets/sheets.txt", fileCharacterContent);
        
        // Save Equipment
        @SuppressWarnings("rawtypes")
        ObservableList equipmentList = equipmentTable.getItems();

        ArrayList<Item> items;
        items = fileAccess.equipmentReader("Sheets/equipments.txt");

        for(Item item : items)
        {
            equipmentList.add(new Item(item.getId(), item.getName(), item.getQuantity()));
        } 

        String fileEquipmentContent = "";
    
        for(int i = 0; i < equipmentList.size(); i++)
        {
            fileEquipmentContent += equipmentList.get(i).toString();
        }
        fileAccess.WriteFile("Sheets/equipments.txt", fileEquipmentContent);        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/ViewCharacter.fxml"));
        root = loader.load();

        CharacterSheetController characterSheetController = loader.getController();
        characterSheetController.fillCharacterSheet(newCharacterSheet);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setTitle("Character Sheet of " + name);
        stage.show();
    }
    
    public void gotoMenu(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/Menu.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setTitle("Character Sheet Explorer");
        stage.show();
    }
}
