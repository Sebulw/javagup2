package password.manager.files;

import password.manager.model.PasswordEntry;

import java.io.IOException;
import java.util.List;

import static java.util.Collections.emptyList;

public class FilesFacade {

    private FileReader fileReader;

    public FilesFacade() {
        fileReader = new LineFileReader();
    }

    public List<String> readFile(String path) {
        try {
            return fileReader.read(path);
        } catch (IOException e) {
            return emptyList();
        }
    }

    public List<PasswordEntry> getEntries(String path) {
        try {
            return fileReader.getPasswordEntries(path);
        } catch (IOException e) {
            return emptyList();
        }
    }
}
