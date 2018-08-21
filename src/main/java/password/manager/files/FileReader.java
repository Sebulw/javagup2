package password.manager.files;

import java.io.IOException;
import java.util.List;

interface FileReader {

    List<String> read(String path) throws IOException;
}
