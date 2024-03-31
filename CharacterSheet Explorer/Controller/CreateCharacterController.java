package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Model.CharacterSheet;
import Model.FileAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateCharacterController {
    private Stage stage;
    private Parent root;

    @FXML private TextField nameField;
    @FXML private TextField characterClassField;
    @FXML private TextField raceField;
    @FXML private TextField levelField;
    @FXML private TextField strenghtField;
    @FXML private TextField dexterityField;
    @FXML private TextField constitutionField;
    @FXML private TextField intelligenceField;
    @FXML private TextField wisdomField;
    @FXML private TextField charismaField; 

    public void saveCharacterSheet(ActionEvent event) throws IOException
    {
        String name = nameField.getText();
        String characterClass = characterClassField.getText();
        int level = Integer.parseInt(levelField.getText());
        String race = raceField.getText();
        int strenght = Integer.parseInt(strenghtField.getText());
        int dexterity = Integer.parseInt(dexterityField.getText());
        int constitution = Integer.parseInt(constitutionField.getText());
        int intelligence = Integer.parseInt(intelligenceField.getText());
        int wisdom = Integer.parseInt(wisdomField.getText());
        int charisma = Integer.parseInt(charismaField.getText());

        FileAccess fileAccess = new FileAccess();
        ArrayList<CharacterSheet> characterSheets;
        
        String path = "sheets.txt";
        characterSheets = fileAccess.caracterSheetReader(path);

        characterSheets.add(new CharacterSheet(name, level, characterClass, race, 
                                                strenght, dexterity, constitution, 
                                                intelligence, wisdom, charisma));

        String fileContent = "";
        for(CharacterSheet characterSheet : characterSheets)
        {
            fileContent += characterSheet.toString();
        }
        path = "sheets.txt";
        fileAccess.WriteFile(path, fileContent);
        
        System.out.println("Character Sheets saved succefully!");


        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/Menu.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setTitle("Character Sheet Explorer");
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
