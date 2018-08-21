package password.manager.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class LineFileReader extends AbstractFileReader {
    @Override
    public List<String> read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
}
