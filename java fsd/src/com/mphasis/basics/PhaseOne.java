package com.mphasis.basics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mphasis.common.ApplicationConstants;

public class PhaseOne {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int operation = 0;

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String path = ApplicationConstants.FILE_PATH;

		while (true) {
			System.out.println(
					"Enter 1 for create file and add,2 for delete file,3 for display file,4 for search file,5 for exit from the app:");
			operation = scanner.nextInt();
			switch (operation) {
			case 1:

				ArrayList<String> al = new ArrayList<>();
				while (true) {
					System.out.println("enter the file name to create");
					String filename = scanner.next();
					String finalname = path + filename;

					// create a file
					File f = new File(finalname);
					boolean b = f.createNewFile();
					if (b != true) {
						System.out.println("the file not created");
					} else {
						al.add(filename);
						System.out.println("file created");
						break;
					}

					System.out.println("the collection of files is " + al);
				}

				break;
			case 2:
				System.out.println("enter the file name to be deleted");
				String filname = scanner.next();
				String finalfile = path + filname;
				File file = new File(finalfile);

				if (file.exists()) {
					file.delete();
					System.out.println(filname + " file was deleted");
				} else {
					System.out.println("No file found with " + filname + " to delete");
				}

				break;

			case 3:

				File f = new File(path);
				File filename[] = f.listFiles();
				System.out.println("List of Files:");
				if (filename.length != 0) {
					for (File ff : filename) {
						System.out.println(ff.getName());
					}
				} else {
					System.out.println("No files found in this folder");
				}
				break;

			case 4:
				File folderPath = new File(path);
				int flag = 0;
				System.out.println("enter the file name to search");
				String fileNameToSearch = scanner.next();
				File filename1[] = folderPath.listFiles();

				if (filename1.length != 0) {
					for (File ff : filename1) {
						if (ff.getName().equalsIgnoreCase(fileNameToSearch)) {
							flag = 1;
							break;

						} else {
							flag = 0;
						}
					}

					if (flag == 1) {
						System.out.println("found the file:- " + fileNameToSearch);
					} else {
						System.out.println("No Such File with:- " + fileNameToSearch + " found in given directory");
						break;
					}

				} else {
					System.out.println("No Files Found in given Folder");
				}

				break;

			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Check your Choice:");
				break;

			}

		}

	}

}
