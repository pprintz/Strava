import java.util.ArrayList;
import java.util.List;

/**
 * Created by Casper on 01/02/2017.
 */
public class Main {

    public static void main(String[] args){
        StoO string = new StoO("a + n * 1");
        string.printAllObjects();

        Language b = new Language("j", 2);
        b.initList();
        b.printList();
    }



}

class Language {
    List<Language> languages;

    public String name;
    public int rate;

    public Language(String name, int rate){
        this.name = name;
        this.rate = rate;
    }

    void initList(){
        languages = new ArrayList<Language>();

        languages.add(new Language("C++", 3));
        languages.add(new Language("C#", 2));
        languages.add(new Language("Java", 3));
        languages.add(new Language("Python", 3));
        languages.add(new Language("HTML, CSS, PHP", 2));
        languages.add(new Language("C", 3));
    }

    void printList(){
        for (Language lang: languages
                ) {
            System.out.println(lang.name + " | " + lang.rate);
        }
    }
}