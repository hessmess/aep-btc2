package javamusic;

/**
 * Created by jhess on 23.04.14.
 */
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    private Map<String , String> studentGrades;

    public HashMapExample(Map<String, String> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public String getValue(String key){

        if(studentGrades.containsKey(key)) return studentGrades.get(key);

        System.out.println("Key not found.");
        throw new RuntimeException();

    }
}