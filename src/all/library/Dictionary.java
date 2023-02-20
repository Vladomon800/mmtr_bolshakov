package all.library;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Dictionary implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<String, String>();
    }



    public void addWord(String english, String russia) {
        dictionary.put(english, russia);
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void save(String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(dictionary);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String path) {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            dictionary = (Map<String, String>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}