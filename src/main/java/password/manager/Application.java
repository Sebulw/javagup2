package password.manager;

import org.apache.log4j.Logger;
import password.manager.files.FilesFacade;
import password.manager.model.PasswordEntry;
import password.manager.model.PasswordFacade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Application {

    final static Logger LOG = Logger.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
//        LOG.trace("Trace level");
//        LOG.debug("Debug level");
//        LOG.info("Info level");
//        LOG.warn("Warn level");
//        LOG.error("Error level");
        FilesFacade filesFacade = new FilesFacade();
        PasswordFacade passwordFacade = new PasswordFacade();
        List<PasswordEntry> entries = new ArrayList<>();
        entries = filesFacade.getEntries("abcdabcdabcdabcd", "test.csv");
        entries.forEach(System.out::println);
//        entries.add(passwordFacade.generatePassword("gmail.com", "17:46", GeneratorType.UUID, 10));

//        System.out.println(entries);

//        filesFacade.writeToFile("abcdabcdabcdabcd", "test.csv", entries);

//        Runner runner = new Runner();
//        runner.run();

    }
}
