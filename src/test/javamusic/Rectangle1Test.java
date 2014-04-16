package javamusic;


import org.junit.Test;
import static junit.framework.Assert.assertEquals;


public class Rectangle1Test{

    @Test
    public void shouldBeAbleToCreateSquare(){
        assertEquals(25.0, (new Rectangle1(5, 5)).Area());
    }

    @Test
    public void testNothing() {
    }

    // @Test
    // public void testWillAlwaysFail() {
    //     fail("An error message");
    // }

}
