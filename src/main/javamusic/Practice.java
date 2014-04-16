package javamusic;

/**
 * Created with IntelliJ IDEA.
 * User: prabha
 * Date: 2/5/14
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Scanner;

public class Practice {

    public static void main(String[] args){
    int answer;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("What is 6 multiplied by 7?");
    answer = keyboard.nextInt();
//    answer=43;
    if( answer == 42 ){
        System.out.println("Good Job. You are a genius");

    }
    else{
        System.out.println("Are you kidding?");

    }
  }
}

// public static void main(String[] args){
//
//     Practice p= new Practice();
// }


