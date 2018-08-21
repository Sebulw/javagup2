package password.manager.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class BufferedFileReader extends AbstractFileReader {

    @Override
    public List<String> read(String path) throws IOException {
        File file = getFile(path);

        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                result.add(line);
            }
        }
        return result;
    }
}
