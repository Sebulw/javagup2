package password.manager.files;

import password.manager.model.PasswordEntry;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static java.util.Collections.emptyList;

public class FilesFacade {

    private FileReader fileReader;
    private PasswordEntryFileWriter passwordEntryFileWriter;

    public FilesFacade() {
        fileReader = new LineFileReader();
        passwordEntryFileWriter = new PasswordEntryFileWriter();
    }

    public List<String> readFile(String path) {
        try {
            return fileReader.read(path);
        } catch (IOException e) {
            return emptyList();
        }
    }

    public List<PasswordEntry> getEntries(String key, String path) {
        try {
            return fileReader.getPasswordEntries(key, path);
        } catch (IOException e) {
            return emptyList();
        }
    }

    public void writeToFile(String key, String fileName, List<PasswordEntry> passwordEntries) {
        try {
            passwordEntryFileWriter.writeToFile(fileName, passwordEntries, key);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
