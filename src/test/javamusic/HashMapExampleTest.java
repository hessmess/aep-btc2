package javamusic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jhess on 23.04.14.
 */
public class HashMapExampleTest {

    private Map<String, String> studentGrades = new HashMap<String, String>();

    public HashMapExampleTest(){
        //Add Key/Value pairs
        studentGrades.put("Alvin", "A+");
        studentGrades.put("Alan", "A");
        studentGrades.put("Becca", "A-");
        studentGrades.put("Sheila", "B+");
    }


    @Test
    public void shouldReturnBPlus(){

        HashMapExample hashMapExample = new HashMapExample(studentGrades);
        assertEquals("B+", hashMapExample.getValue("Sheila"));

    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowException(){

        HashMapExample hashMapExample = new HashMapExample(studentGrades);
        assertEquals("B+", hashMapExample.getValue("Sheil"));

    }

}
