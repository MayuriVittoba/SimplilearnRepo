package simplilearn.project.java;

import java.io.File;
import java.util.Scanner;

public class FileOperationsScreen implements Screen {
	public void showMenuOptions() {
		System.out.println("1. Create a File");
		System.out.println("2. Delete a File");
		System.out.println("3. Search a File");
		System.out.println("4. Previous Menu");
		System.out.println("Please enter either 1, 2, 3 or 4 to select option from above menu");

		menuTask();
	}

	public String getUserInput() {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
//		s.close();
		return input;

	}

	public void menuTask() {

		switch (getUserInput()) {
		case "1":

			createUserFile();
			showMenuOptions();
			break;
		case "2":
			// show another sub menu
			deleteFile();
			showMenuOptions();
			break;
		case "3":
			searchFile();
			showMenuOptions();
			break;
		case "4":
			// previous menu
			WelcomeScreen obj = new WelcomeScreen();
			obj.showMenuOptions();
			break;
		default:
			System.out.println("Invalid option");
			showMenuOptions();
			break;
		}
	}

	public void createUserFile() {
		String fileName = "";
		System.out.println("Enter file name");
		fileName = getUserInput();

		try {
			if (fileName.isBlank()) {
				System.out.println("Please enter valid file name");
			} else if (new File(path_main, fileName).exists()) {
				System.out.println("File name already exists");
			} else {
				File file1 = new File(path_main + fileName);
				file1.createNewFile();
				System.out.println("File is created successfully");
			}
		}

		catch (Exception ex1) {
		}
	}

	public void deleteFile() {
		String fileName = "";
		System.out.println("Enter file name");
		fileName = getUserInput();

		try {
			File file = new File(path_main + fileName);

			if (fileName.equals(file.getName()) && file.exists()) {
				if (file.delete())
					System.out.println("File deleted successfully");
				else
					System.out.println("Failed to delete the file");
			} else {
				System.out.println("No file found");
			}
		} catch (Exception ex) {
		}
	}

	public void searchFile() {
		try {
			File directory = new File(path_main);
			String[] flist = directory.list();

			String fileName = "";
			System.out.println("Enter file name");
			fileName = getUserInput();

			if (flist == null) {
				System.out.println("Empty directory.");
			} else {
				String filename = "";
				// Linear search in the array
				for (int i = 0; i < flist.length; i++) {
					filename = flist[i];
					System.out.println("File found:");
					if (filename.startsWith(fileName)) {
						System.out.println(filename);
					}
				}
			}

		} catch (Exception ex) {

		}

	}

}
