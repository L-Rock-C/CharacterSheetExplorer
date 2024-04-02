package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.CharacterSheet;
import Model.FileAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewCharacterListController implements Initializable{
    private Stage stage;
    private Parent root;
    FileAccess fileAccess = new FileAccess();
    ArrayList<CharacterSheet> characterSheets;

    @SuppressWarnings("rawtypes")
    @FXML private TableView charactersList = new TableView<CharacterSheet>();
    @SuppressWarnings("rawtypes")
    @FXML private TableColumn nameColumm = new TableColumn<CharacterSheet, String>("Name");
    @SuppressWarnings("rawtypes")
    @FXML private TableColumn characterClassColumm = new TableColumn<CharacterSheet, String>("Class");
    @SuppressWarnings("rawtypes")
    @FXML private TableColumn xpColumm = new TableColumn<CharacterSheet, Integer>("Experience");
    @SuppressWarnings("rawtypes")
    @FXML private TableColumn raceColumm = new TableColumn<CharacterSheet, String>("Race");

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameColumm.setCellValueFactory(new PropertyValueFactory<CharacterSheet, String>("name"));
        characterClassColumm.setCellValueFactory(new PropertyValueFactory<CharacterSheet, String>("characterClass"));
        xpColumm.setCellValueFactory(new PropertyValueFactory<CharacterSheet, Integer>("xp"));
        raceColumm.setCellValueFactory(new PropertyValueFactory<CharacterSheet, String>("race"));

        try {
            charactersList.getItems().addAll(fileAccess.caracterSheetReader("Sheets/sheets.txt"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        charactersList.getColumns().clear();
        charactersList.getColumns().add(nameColumm);
        charactersList.getColumns().add(characterClassColumm);
        charactersList.getColumns().add(xpColumm);
        charactersList.getColumns().add(raceColumm);

    }

    public void viewCharacterSheet(ActionEvent event) throws IOException
    {
        CharacterSheet characterSelected = (CharacterSheet) charactersList.getSelectionModel().getSelectedItem();
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/ViewCharacter.fxml"));
        root = loader.load();

        CharacterSheetController characterSheetController = loader.getController();
        characterSheetController.fillCharacterSheet(characterSelected);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setTitle("Character Sheet of " + characterSelected.getName());
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
