package Model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileAccess 
{

    public void WriteFile(String path, String input) throws IOException 
    {
        BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(path) );
		bufferedWriter.append(input);
		bufferedWriter.close();
    }

	public ArrayList<Item> equipmentReader(String path, CharacterSheet characterSheet) throws IOException
	{
		ArrayList<Item> equipmentList = new ArrayList<Item>();
		
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
				if(id == characterSheet.getId())
				{
					for(int i = 1; i < sheetData.length; i+=2)
					{
						equipmentList.add(new Item(id, sheetData[i], Integer.parseInt(sheetData[i+1])));
						
						//System.out.print("[" + sheetData[i] + "]");
					}
				}
            }
        }

		return equipmentList;
	}
	public ArrayList<Item> equipmentReader(String path) throws IOException
	{
		ArrayList<Item> equipmentList = new ArrayList<Item>();
		
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
				
				for(int i = 1; i < sheetData.length; i+=2)
				{
					equipmentList.add(new Item(id, sheetData[i], Integer.parseInt(sheetData[i+1])));
					
					//System.out.print("[" + sheetData[i] + "]");
				}
				
            }
        }

		return equipmentList;
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
				int xp = Integer.parseInt(sheetData[3]);
				String race = sheetData[4];
				String background = sheetData[5];
				boolean inspiration = Boolean.parseBoolean(sheetData[6]);
				int pb = Integer.parseInt(sheetData[7]);
				int armorClass = Integer.parseInt(sheetData[8]);
				int initiative = Integer.parseInt(sheetData[9]);
				String speed = sheetData[10];
				int maxHP = Integer.parseInt(sheetData[11]);
				int currentHP = Integer.parseInt(sheetData[12]);
				int tempHP = Integer.parseInt(sheetData[13]);
				String totalHitDice = sheetData[14];
				String currentHitDice = sheetData[15];

				int strenght = Integer.parseInt(sheetData[16]);
				int dexterity = Integer.parseInt(sheetData[17]);
				int constitution = Integer.parseInt(sheetData[18]);
				int intelligence = Integer.parseInt(sheetData[19]);
				int wisdom = Integer.parseInt(sheetData[20]);
				int charisma = Integer.parseInt(sheetData[21]);
				boolean strSave = Boolean.parseBoolean(sheetData[22]);
				boolean dexSave = Boolean.parseBoolean(sheetData[23]);
				boolean conSave = Boolean.parseBoolean(sheetData[24]);
				boolean intSave = Boolean.parseBoolean(sheetData[25]);
				boolean wisSave = Boolean.parseBoolean(sheetData[26]);
				boolean chaSave = Boolean.parseBoolean(sheetData[27]);

				boolean acrobatics = Boolean.parseBoolean(sheetData[28]);
				boolean animalHandling = Boolean.parseBoolean(sheetData[29]);
				boolean arcana = Boolean.parseBoolean(sheetData[30]);
				boolean atlhetics = Boolean.parseBoolean(sheetData[31]);
				boolean deception = Boolean.parseBoolean(sheetData[32]);
				boolean history = Boolean.parseBoolean(sheetData[33]);
				boolean insight = Boolean.parseBoolean(sheetData[34]);
				boolean intimitadion = Boolean.parseBoolean(sheetData[35]);
				boolean investigation = Boolean.parseBoolean(sheetData[36]);
        		boolean medicine = Boolean.parseBoolean(sheetData[37]);
				boolean nature = Boolean.parseBoolean(sheetData[38]);
				boolean perception = Boolean.parseBoolean(sheetData[39]);
				boolean perfomance = Boolean.parseBoolean(sheetData[40]);
				boolean persuasion = Boolean.parseBoolean(sheetData[41]);
				boolean religion = Boolean.parseBoolean(sheetData[42]);
				boolean sleightOfHands = Boolean.parseBoolean(sheetData[43]);
				boolean stealth = Boolean.parseBoolean(sheetData[44]);
				boolean survival = Boolean.parseBoolean(sheetData[45]);

				String spellAbility = sheetData[46];
				int spellDC = Integer.parseInt(sheetData[47]);
				int spellAttack = Integer.parseInt(sheetData[48]);

				int cp = Integer.parseInt(sheetData[49]);
				int sp = Integer.parseInt(sheetData[50]);
				int ep = Integer.parseInt(sheetData[51]);
				int gp = Integer.parseInt(sheetData[52]);
				int pp = Integer.parseInt(sheetData[53]);

				String notes = sheetData[54].replaceAll("\\+", "\n");

				Attributes attributes = new Attributes(strenght, dexterity, constitution, intelligence, wisdom, charisma, 
														   strSave, dexSave, conSave, intSave, wisSave, chaSave);

				Skills skills = new Skills(acrobatics, animalHandling, arcana, atlhetics, deception, history, insight, 
										   intimitadion, investigation, medicine, nature, perception, perfomance, persuasion, 
										   religion, sleightOfHands, stealth, survival);

				CharacterSheet sheet = new CharacterSheet(id, name, xp, characterClass, race, background, attributes, pb, 
														  inspiration, armorClass, initiative, speed, maxHP, currentHP, 
														  tempHP, totalHitDice, currentHitDice, skills, spellAbility, 
														  spellDC, spellAttack, cp, sp, ep, gp, pp, notes);

                characterSheets.add(sheet);
            }
        }
		return characterSheets;
    }

	public void updateCharacter(String path, CharacterSheet characterSheetUpdate, ArrayList<Item> equipmentListUpdate) throws IOException
	{
		ArrayList<CharacterSheet> characterSheets = caracterSheetReader(path);
		String fileCharacterContent = "";
		for(int i = 0; i < characterSheets.size(); i++)
		{
			if(characterSheets.get(i).getId() == characterSheetUpdate.getId())
			{
				fileCharacterContent += characterSheetUpdate.toString();
			}
			else
			{
				fileCharacterContent += characterSheets.get(i).toString();
			}
		}
		fileCharacterContent = fileSorting(fileCharacterContent, "Sheets/sheets.txt");
        WriteFile(path, fileCharacterContent);

		ArrayList<Item> equipmentList = equipmentReader("Sheets/equipments.txt");
		String fileEquipmentContent = "";
		for(int i = 0; i < equipmentList.size(); i++)
		{
			if(equipmentList.get(i).getId() != characterSheetUpdate.getId())
			{
				fileEquipmentContent += equipmentList.get(i).toString();
			}
		}
		for(int i = 0; i < equipmentListUpdate.size(); i++)
		{
			fileEquipmentContent += equipmentListUpdate.get(i).toString();
		}
		fileEquipmentContent = fileSorting(fileEquipmentContent, "Sheets/equipments.txt");
        WriteFile("Sheets/equipments.txt", fileEquipmentContent); 
	}

	public String fileSorting(String fileContent, String path) throws IOException
	{
		String fileSorted = "";
		ArrayList<String> lines = new ArrayList<>();
		
		String[] line = fileContent.split("\n");

		for(int i = 0; i < line.length; i++)
		{
			lines.add(line[i] + "\n");
		}

		for(int i = lines.size(); i > 0; i--)
		{
			for(int j = 0; j < i - 1; j++)
			{
				if(Integer.parseInt(String.valueOf(lines.get(j).charAt(0))) > Integer.parseInt(String.valueOf(lines.get(j + 1).charAt(0))))
				{
					Collections.swap(lines, j, j + 1);
				}
			}
		}
		for(int j = 0; j < lines.size(); j++)
		{
			fileSorted += lines.get(j);
		}

		return fileSorted;
	}

	public void deleteCharacter(CharacterSheet characterSheet) throws IOException
	{
		ArrayList<CharacterSheet> characterSheets = caracterSheetReader("Sheets/sheets.txt");
		String newFileContent = "";

		for(int i = 0; i < characterSheets.size(); i++)
		{
			if(characterSheets.get(i).getId() != characterSheet.getId())
			{
				newFileContent += characterSheets.get(i).toString();
			}
		}
		WriteFile("Sheets/sheets.txt", newFileContent);

		ArrayList<Item> equipmentList = equipmentReader("Sheets/equipments.txt");
		newFileContent = "";
		for(int i = 0; i < equipmentList.size(); i++)
		{
			if(equipmentList.get(i).getId() != characterSheet.getId())
			{
				newFileContent += equipmentList.get(i).toString();
			}
		}
		WriteFile("Sheets/equipments.txt", newFileContent);
	}
}
