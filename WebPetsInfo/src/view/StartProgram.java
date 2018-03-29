package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.PetInfoHelper;
import model.PetInfo;

public class StartProgram 
{
	static Scanner in = new Scanner(System.in);
	static PetInfoHelper pih = new PetInfoHelper();
	
	private static void addAPet()
	{
			// TODO Auto-generated method stub
		System.out.print("Enter a type: ");
		String type = in.nextLine();
		System.out.print("Enter a name: ");
		String name = in.nextLine();
		System.out.print("Enter an owner: ");
		String owner = in.nextLine();
		PetInfo toAdd = new PetInfo(type, name, owner);
		pih.insertItem(toAdd);
	}

	private static void deleteAPet() 
	{
			// TODO Auto-generated method stub
		System.out.print("Enter the type to delete: ");
		String type = in.nextLine();
		System.out.print("Enter the name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the owner to delete: ");
		String owner = in.nextLine();
		PetInfo toRemove = new PetInfo(type, name, owner);
		if(!pih.searchForPetByType(type).isEmpty() && !pih.searchForPetByName(name).isEmpty() && !pih.searchForPetByOwner(owner).isEmpty())
		{
			pih.deleteItem(toRemove);
			System.out.println("Removed: " + toRemove.returnPetDetails());
		}
		else
		{

			System.out.println("---- No results found");
		}
	}

	private static void editAPet() 
	{
		// TODO Auto-generated method stub
			
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Type");
		System.out.println("2 : Search by Name");
		System.out.println("3 : Search by Owner");
		int searchBy = in.nextInt();
		in.nextLine();
			
		List<PetInfo> foundItems = new ArrayList<PetInfo>();
		if (searchBy == 1) {
			System.out.print("Enter the type of pet: ");
			String petType = in.nextLine();
			for(int i=1; i<pih.showAllItems().size(); i++)
			{
				if(petType.equals(pih.showAllItems().get(i).getType()))
				{
					foundItems.add(pih.showAllItems().get(i));
				}

			}	
		} 
		if (searchBy == 2)
		{
			System.out.print("Enter the name of pet: ");
			String petName = in.nextLine();
			for(int j=1; j<pih.showAllItems().size(); j++)
			{
				if(petName.equals(pih.showAllItems().get(j).getName()))
				{
					foundItems.add(pih.showAllItems().get(j));
				}
			}
		}
		else if (searchBy == 3)
		{
			System.out.print("Enter the name of owner: ");
			String petName = in.nextLine();
			for(int j=1; j<pih.showAllItems().size(); j++)
			{
				if(petName.equals(pih.showAllItems().get(j).getOwner()))
				{
					foundItems.add(pih.showAllItems().get(j));
				}
			}
		}
		if (!foundItems.isEmpty()) 
		{
			System.out.println("Found Results.");
			for (PetInfo l : foundItems) 
			{
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			PetInfo toEdit = pih.searchForItemById(idToEdit);
			System.out.println("Retrieved the " + toEdit.getType() + ", " + toEdit.getName() + " from " + toEdit.getOwner());
			System.out.println("1 : Update Type");
			System.out.println("2 : Update Name");
			System.out.println("3 : Update Owner");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) 
			{
				System.out.print("New Type: ");
				String newType = in.nextLine();
				toEdit.setType(newType);
			} 
			if (update == 2) 
			{
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			}
			else if (update == 3)
			{
				System.out.print("New Owner: ");
				String newOwner = in.nextLine();
				toEdit.setOwner(newOwner);
			}
			pih.updateItem(toEdit);
		} 
		else 
		{
			System.out.println("---- No results found");
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		runMenu();
	}

	public static void runMenu() 
	{
		boolean goAgain = true;
		System.out.println("--- Pet Information ---");
		while (goAgain) 
		{
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a pet");
			System.out.println("*  2 -- Edit a pet");
			System.out.println("*  3 -- Delete a pet");
			System.out.println("*  4 -- View list of pets");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) 
			{
				addAPet();
			} 
			else if (selection == 2) 
			{
				editAPet();
			} 
			else if (selection == 3) 
			{
				deleteAPet();
			} 
			else if (selection == 4) 
			{
				viewTheList();
			} 
			else 
			{
				pih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}

	private static void viewTheList() 
	{
		// TODO Auto-generated method stub
		for(int i=0; i<pih.showAllItems().size(); i++)
		{
			System.out.println(pih.showAllItems().get(i));
		}
	}
}