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
     *  CheckList:
     * -    Vetor ou Matriz - feito
     * -    Recursividade (se ouver cenário de uso)
     * -    Generic 
     * -    Arquivos - feito
     * -    Pilha (se ouver cenário de uso)
     * -    Fila
     * -    Lista Encadeada
     * -    Alg Busca - feito
     * -    Alg Ordenação - feito
     * 
     * 
     * - Proposta - CRUD de Ficha de Personagem de RPG (D&D5e) com:
     * -    Nome, classe, raça, antecedente e etc
     * -    Atributos e perícias
     * -    Lista de ataques, magias e habilidades
     * -    Inventário
     * -    Anotações
     * 
     * - Done:
     * -    Persistência em arquivo
     * -    Create e Update de CharacterSheet e Equipment 
     * -    Ordenar arquivos por Id na gravação (implementar algum sorting)
     * -    Ajeitar as Anotações (quebra de linha)
     * 
     * - ToDo:
     * -    Resto do CRUD
     * -    Busca --Binária-- por Id (atualmente linear)
     * -    Implementar algo sobre pilha/fila
     * -    Estilizar
     * -    Trocar o sorting de bubble pra quick 
     * 
     */