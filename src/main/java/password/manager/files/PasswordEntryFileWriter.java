package password.manager.files;

import com.opencsv.CSVWriter;
import password.manager.model.PasswordEntry;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

class PasswordEntryFileWriter {

    void writeToFile(String path, List<PasswordEntry> passwordEntries) throws URISyntaxException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(path)), ';', CSVWriter.DEFAULT_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
        for (PasswordEntry passwordEntry : passwordEntries) {
            csvWriter.writeNext(passwordEntry.toArray());
        }
        csvWriter.close();
    }

}
