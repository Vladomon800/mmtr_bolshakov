package all.main;

import all.library.Dictionary;
import all.library.Translator;

import java.awt.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import all.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        Translator translator;
        Menu menu = new Menu();
        int solution;
        do {
            menu.show();

            solution = scan.nextInt();

            switch (solution) {

                case 1:
                    System.out.println("Введите Английское слово:");
                    String english = new Scanner(System.in).nextLine();
                    System.out.println("Введите перевод:");
                    String russia = new Scanner(System.in).nextLine();
                    dictionary.addWord(english, russia);
                    break;
                case 2:
                    System.out.println("Ввкдите английское предложение :");
                    String englishSentence = new Scanner(System.in).nextLine();
                    translator = new Translator(dictionary);
                    translator.TranslateEnglishToRussia(englishSentence);
                    break;
                case 3:
                    System.out.println("Введите русское предложение:");
                    String russiaSentence = new Scanner(System.in).nextLine();
                    translator = new Translator(dictionary);
                    translator.TranslateRussiaToEnglish(russiaSentence);
                    break;
                case 4:
                    System.out
                            .println("Введите путь куда сохранить словарь(ПРИМЕР d:\\java\\dictionary.txt):");
                    String path = new Scanner(System.in).nextLine();
                    dictionary.save(path);
                    break;
                case 5:
                    System.out
                            .println("Введите путь откуда загрузить словарь(ПРИМЕР d:\\java\\dictionary.txt):");
                    path = new Scanner(System.in).nextLine();
                    path.replace("\\", "\\\\");
                    dictionary.load(path);
                    break;
                case 6:
                    if (dictionary.getDictionary().size() == 0)
                        System.out
                                .println("Ваш словарь пуст! Пожалуйста, добавьте слово или загрузите словарь из файла.");
                    else System.out.println(dictionary.getDictionary());
                    break;
                default:
                    if (solution != 0)
                        System.out.println("Неверный выбор!");
                    break;
            }
        } while (solution != 0);
    }
}