package HomeWork5_1;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class HomeWork5_1 {
    public static void main(String[] args) {
        System.out.println("Enter path to directory for zip files inside:");
        Scanner scanner = new Scanner(System.in);
        String directoryPathFromUser;
        directoryPathFromUser = scanner.nextLine();

        readAllFilesInDirectory(directoryPathFromUser);
    }

    private static void readAllFilesInDirectory(String directoryPathFromUser) {
        Set<String> dataBase = new TreeSet<>();
        File folderPath = new File(directoryPathFromUser);
        Options filesToProcess = new Options();
        for (String[] filesType : filesToProcess.getAllTypesOfFiles()) {
            String zipName = "";
            Set<String> allFilesOfCurrentType = new TreeSet<>();
            for (String currentType : filesType) {
                if (currentType == filesType[0]) {
                    zipName = currentType + ".zip";
                    continue;
                }
                for (String filePathVsName : dataBase) {
                    if (filePathVsName.endsWith(currentType)) {
                        allFilesOfCurrentType.add(filePathVsName);
                    }
                }
                createZipFile(zipName, allFilesOfCurrentType, directoryPathFromUser);
            }
            addFilesToDatabase(folderPath, dataBase);
        }
    }

    private static void addFilesToDatabase(File currentDirectory, Set<String> namesOfFiles) {
        for (File file : currentDirectory.listFiles()) {
            if (file.isFile()) {
                namesOfFiles.add(file.getParent() + "\\" + file.getName());
            } else if (file.isDirectory()) addFilesToDatabase(file, namesOfFiles);
        }
    }

    public static void createZipFile(String zipName, Set<String> filesToAdd, String pathToSave) {
        try (
                FileOutputStream fileToWrite = new FileOutputStream(pathToSave + "\\" + zipName);
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileToWrite)
        ) {
            for (String pathVsNameOfCurrentFile : filesToAdd) {
                String nameEntryinZip = pathVsNameOfCurrentFile.substring(pathToSave.length() + 1);
                try (
                        FileInputStream currentFileToZip = new FileInputStream(pathVsNameOfCurrentFile);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(currentFileToZip)
                ) {
                    ZipEntry currenFileZipEntry = new ZipEntry(nameEntryinZip);
                    zipOutputStream.putNextEntry(currenFileZipEntry);
                    byte[] partOfFile = new byte[1024];
                    int lenght;
                    while ((lenght = bufferedInputStream.read(partOfFile)) >= 0) {
                        zipOutputStream.write(partOfFile, 0, lenght);
                        zipOutputStream.flush();
                    }
                    zipOutputStream.closeEntry();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
