package scripts;

import java.util.ArrayList;
import java.util.List;

public interface SetFile {
    boolean createFile();
    void writeFileAppend();
    void readFile();
    List<List<String>> listRegister();
    void deleteContent(String texto);
}