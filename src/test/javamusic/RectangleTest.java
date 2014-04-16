package javamusic;

import org.junit.*;

import static junit.framework.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: prabha
 * Date: 1/24/14
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class RectangleTest {

    @Test
    public void shouldReturnAreaOfTenforTwoByFiveRectange(){
        Rectangle r = new Rectangle(5,2);
        assertEquals(10, r.get_area());
    }

    @Test
    public void shouldReturnAreaOfTwelveforThreeByFourRectange(){
        Rectangle r = new Rectangle(3,4);
        assertEquals(12, r.get_area());

    }





}
