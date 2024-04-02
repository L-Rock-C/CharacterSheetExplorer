import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXML/Menu.fxml"));
        
        primaryStage.setTitle("Character Sheet Explorer"); 
        
        primaryStage.setScene(new Scene(root, 1100, 650));
        primaryStage.show();
    }
}

    /*
     *
     * - Proposta - CRUD de Ficha de Personagem de RPG com:
     * -    Nome, classe, raça, antecedente
     * -    Atributos e perícias
     * -    Lista de ataques, magias e habilidades
     * -    Inventário
     * -    Anotações
     * 
     * - Done:
     * -    Persistência em arquivo
     * -    Create e Update de CharacterSheet e Equipment 
     * 
     * - ToDo:
     * -    Resto do CRUD
     * -    Ordenar arquivos por Id na gravação (implementar algum sorting)
     * -    Busca --Binária-- por Id (atualmente linear)
     * -    Implementar algo sobre pilha/fila
     * -    Ajeitar as Anotações (quebra de linha)
     * -    Estilizar
     * 
     */