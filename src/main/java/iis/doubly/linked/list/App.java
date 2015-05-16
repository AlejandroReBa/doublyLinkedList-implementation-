package iis.doubly.linked.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
   private App(){

  }

  public static void main(String[] args) {
      Random generadorAletaorios = new Random();
      Integer aleatorio;
      DoublyLinkedList<Integer> listaAleatorios = new DoublyLinkedList<Integer>();

      for(int contador = 0; contador < 10; contador++){

          aleatorio = generadorAletaorios.nextInt(1000);


          listaAleatorios.insertEnd(aleatorio);

      }
      listaAleatorios.elementAtPosition(11);
  }
}
