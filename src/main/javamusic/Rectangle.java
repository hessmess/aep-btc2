package javamusic;
/* * understands a four-sided figure with sides at right angles
*/
/**
 * Created with IntelliJ IDEA.
 * User: prabha
 * Date: 1/24/14
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */


//import javax.swing.JFrame;

public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(int pub_width, int pub_height){
        width = pub_width;
        height = pub_height;
    }

    public int get_perimeter(){
        return 2*(width+height);

    }
    public int get_area(){
        return width*height;

    }

//    public static void main(String[] args){
//        System.out.println("Start ...");
//
//        Rectangle r= new Rectangle(4,5);
//        System.out.println(r.get_perimeter());
//
//        System.out.println("End...");
//
//
//    }

    public static Rectangle createSquare(int side){
        //Static factory method
        return new Rectangle(side,side);
    }

    public static Rectangle createRhombus(int side){
        return new Rectangle(side,side);

    }


}
