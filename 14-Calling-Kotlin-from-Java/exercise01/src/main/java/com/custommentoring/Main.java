package com.custommentoring;
import com.custommentoring.Message; // import Kotlin data class

public class Main {
  public static void main( String[] argv ) {
    String message = new Message().getText() + " World!";
    System.out.println( message ); // prints: Hello, Kotlin World!
  }
}
