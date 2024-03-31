package Model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileAccess 
{

    public void WriteFile(String path, String input) throws IOException 
    {
        BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(path) );
		bufferedWriter.append(input);
		bufferedWriter.close();
    }

    public ArrayList<CharacterSheet> caracterSheetReader(String path) throws IOException
    {
		ArrayList<CharacterSheet> characterSheets = new ArrayList<CharacterSheet>();

        @SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader( new FileReader(path) );

		StringBuffer sbResult = new StringBuffer();
		String line = "";

        while (line != null)
        {
            sbResult.append(line + "\n");
            line = bufferedReader.readLine();

            if(line != null)
            {
                String[] sheetData = line.split(";");
				int id = Integer.parseInt(sheetData[0]);
				String name = sheetData[1];
				String characterClass = sheetData[2];
				int level = Integer.parseInt(sheetData[3]);
				String race = sheetData[4];
				int strenght = Integer.parseInt(sheetData[5]);
				int dexterity = Integer.parseInt(sheetData[6]);
				int constitution = Integer.parseInt(sheetData[7]);
				int intelligence = Integer.parseInt(sheetData[8]);
				int wisdom = Integer.parseInt(sheetData[9]);
				int charisma = Integer.parseInt(sheetData[10]);

				CharacterSheet sheet = new CharacterSheet(id, name, level, characterClass, race, 
														  strenght, dexterity, constitution, 
														  intelligence, wisdom, charisma);

                characterSheets.add(sheet);
/* 
				for(int i = 0; i < sheetData.length; i++)
				{
					System.out.print("[" + sheetData[i] + "]");
				}
				System.out.println();  */
            }
        }

		return characterSheets;
    }
}
