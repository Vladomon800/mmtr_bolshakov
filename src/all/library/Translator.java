package all.library;

import all.library.Dictionary;

import java.util.Map;
import java.util.Set;

public class Translator {
    Set<Map.Entry<String, String>> vocabularySet;

    public Translator(Dictionary dictionary) {
        vocabularySet = dictionary.getDictionary().entrySet();
    }

    public void TranslateEnglishToRussia(String phrase) {
        String[] str = phrase.split(" ");
        for (int i = 0; i < str.length; i++) {
            int j = 0;
            if (i == 0) {
                System.out.println();
            }
            for (Map.Entry<String, String> entry : vocabularySet) {
                if (entry.getKey().equalsIgnoreCase(str[i])) {
                    System.out.print(entry.getValue() + " ");
                    break;
                }

                else if (j == vocabularySet.size() - 1) {
                    System.out.print(str[i] + " ");
                }
                j++;
            }
        }
    }

    public void TranslateRussiaToEnglish(String phrase) {
        String[] str = phrase.split(" ");
        for (int i = 0; i < str.length; i++) {
            int j = 0;
            if (i == 0) {
                System.out.println();
            }
            for (Map.Entry<String, String> entry : vocabularySet) {
                if (entry.getValue().equalsIgnoreCase(str[i])) {
                    System.out.print(entry.getKey() + " ");
                    break;
                }

                else if (j == vocabularySet.size() - 1) {
                    System.out.print(str[i] + " ");
                }
                j++;
            }
        }
    }
}