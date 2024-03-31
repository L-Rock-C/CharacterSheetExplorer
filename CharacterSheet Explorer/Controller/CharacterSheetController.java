package Controller;

import java.io.IOException;

import Model.CharacterSheet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CharacterSheetController {
    private Stage stage;
    private Parent root;

    @FXML private TextField nameField;
    @FXML private TextField characterClassField;
    @FXML private TextField xpField;
    @FXML private TextField raceField;
    @FXML private TextField strenghtField;
    @FXML private TextField strenghtModField;
    @FXML private TextField dexterityField;
    @FXML private TextField dexterityModField;
    @FXML private TextField constitutionField;
    @FXML private TextField constitutionModField;
    @FXML private TextField intelligenceField;
    @FXML private TextField intelligenceModField;
    @FXML private TextField wisdomField;
    @FXML private TextField wisdomModField;
    @FXML private TextField charismaField;
    @FXML private TextField charismaModField;

    public void fillCharacterSheet(CharacterSheet characterSheet)
    {
        nameField.setText(characterSheet.getName());
        characterClassField.setText(characterSheet.getCharacterClass());
        xpField.setText(String.valueOf(characterSheet.getLevel()));
        raceField.setText(characterSheet.getRace());
        strenghtField.setText(String.valueOf(characterSheet.getStrenght()));
        strenghtModField.setText(String.valueOf((characterSheet.getStrenght()-10/2)));
        dexterityField.setText(String.valueOf(characterSheet.getDexterity()));
        dexterityModField.setText(String.valueOf((characterSheet.getDexterity()-10/2)));
        constitutionField.setText(String.valueOf(characterSheet.getConstitution()));        
        constitutionModField.setText(String.valueOf((characterSheet.getConstitution()-10/2)));
        intelligenceField.setText(String.valueOf(characterSheet.getIntelligence()));
        intelligenceModField.setText(String.valueOf((characterSheet.getIntelligence()-10/2)));
        wisdomField.setText(String.valueOf(characterSheet.getWisdom()));
        wisdomModField.setText(String.valueOf((characterSheet.getWisdom()-10/2)));
        charismaField.setText(String.valueOf(characterSheet.getCharisma()));
        charismaModField.setText(String.valueOf((characterSheet.getCharisma()-10/2)));

    }

    public void gotoViewCharacterSheets(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/ViewCharacterList.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.show();
    }
}
