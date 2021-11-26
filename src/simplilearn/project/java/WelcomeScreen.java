package simplilearn.project.java;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class WelcomeScreen implements Screen {
	public static void main(String args[]) {
		WelcomeScreen wsObj = new WelcomeScreen();
		wsObj.setWelcomeScreenDetails("Virtual Key", "Mayuri Vittoba");
		wsObj.createMainFolder();
		wsObj.showMenuOptions();
	}

	public void setWelcomeScreenDetails(String appName, String devName) {
		System.out.println("Application Name: " + appName);
		System.out.println("Developer Name: " + devName);
	}

	public String getUserInput() {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		return input;

	}

	public void showMenuOptions() {
		System.out.println("1. Show Files");
		System.out.println("2. File Menu");
		System.out.println("3. Exit");
		System.out.println("Please enter either 1, 2 or 3 to select option from above menu");

		menuTask();
	}

	public void menuTask() {
		switch (getUserInput()) {
		case "1":
			// get list and show
			listFiles();
			showMenuOptions();
			break;
		case "2":
			// show another sub menu
			FileOperationsScreen obj = new FileOperationsScreen();
			obj.showMenuOptions();
			break;
		case "3":
			closeApp();
			// close application
			break;
		default:
			System.out.println("Invalid option");
			showMenuOptions();
			break;
		}
	}

	public void listFiles() {
		try {
			File folder = new File(path_main);
			File[] listOfFiles = folder.listFiles();

			if (listOfFiles != null && listOfFiles.length > 0) {
				Arrays.sort(listOfFiles);

				System.out.println("Following are the list");
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile()) {
						System.out.println("File " + listOfFiles[i].getName());
					} else if (listOfFiles[i].isDirectory()) {
						System.out.println("Directory " + listOfFiles[i].getName());
					}
				}
			} else {
				System.out.println("No files to show");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void closeApp() {
		System.exit(0);
	}

	public void createMainFolder() {
		try {
			File f1 = new File(path_main);
			// Creating a folder using mkdirs() method
			f1.mkdir();
		} catch (Exception ex) {
		}
	}
}
