package iis.doubly.linked.list;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Jose on 10/05/2015.
 */
public class AppTest {

    private static final int NUM_ELEMENTOS = 10;
    private DoublyLinkedList<Integer> lista;

    @Before
    public void testBefore(){

        this.lista = new DoublyLinkedList<Integer>();

    }

    @Test
    public void testAlCrearLaListaDebeEstaVacia(){

        assertNull(this.lista);

    }

    @Test
    public void testSiAgregoElementoAListaVaciaELPrimerElementoDebeSerElIntroducido(){

        Integer elemento = 10;

        this.lista.insertBeginning(elemento);

        Integer primerElementoLista = this.lista.first();

        assertEquals(elemento, primerElementoLista);

    }

    @Test
    public void testSiAgregoElementoAListaVaciaElUltimoElementoDebeSerElIntroducido(){

        Integer elemento = 10;

        this.lista.insertBeginning(elemento);

        Integer ultimoElementoLista = this.lista.last();

        assertEquals(elemento, ultimoElementoLista);

    }

    @Test
    public void testSiAgregoUnElementoYEliminoUnElementoAListaVaciaDebeQuedarListaVacia(){

        Integer elemento = 10;

        this.lista.insertBeginning(elemento);
        this.lista.remove(elemento);

        assertTrue(this.lista.isEmpty());
        assertTrue(0 == this.lista.listSize());

    }

    @Test
    public void testSiADosListasIgualesAgregoUnElementoIgualLasListasResultantesDebenSerIguales(){

        Random generadorAletaorios = new Random();
        Integer aleatorio;
        DoublyLinkedList<Integer> segundaLista = new DoublyLinkedList<Integer>();

        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);

            this.lista.insertEnd(aleatorio);
            segundaLista.insertEnd(aleatorio);

        }

        assertEquals(this.lista, segundaLista);

    }


    @Test
    public void testSiInsertoNuevoNodoAlPrincipioEsteDebeSerElPrimeroDeLaLista(){


        Random generadorAletaorios = new Random();
        Integer aleatorio;

        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);

            this.lista.insertEnd(aleatorio);

        }

        Integer primerElementoLista = 666666;

        this.lista.insertBeginning(primerElementoLista);

        assertEquals(this.lista.first(), primerElementoLista);

    }

    @Test
    public void testSiInsertoNuevoNodoAlFinalEsteDebeSerElUltimoDeLaLista(){

        Random generadorAletaorios = new Random();
        Integer aleatorio;

        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);

            this.lista.insertEnd(aleatorio);

        }

        Integer primerElementoLista = 666666;

        this.lista.insertEnd(primerElementoLista);

        assertEquals(this.lista.last(), primerElementoLista);

    }

    @Test
    public void testSiInsertoUnNumeroDeterminadoDeNodosAListaVaciaSuLongitudDebeSerIgualAlNumeroDeNodosIntroducidos(){


        Random generadorAletaorios = new Random();
        Integer aleatorio;

        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);

            this.lista.insertEnd(aleatorio);

        }

        assertEquals(this.lista.listSize(), NUM_ELEMENTOS);


    }

    @Test
    public void testSiADosListasIgualesLesEliminoNodosDistintosLasListasResultantesSeranDistintas(){

        Random generadorAletaorios = new Random();
        Integer aleatorio;
        DoublyLinkedList<Integer> segundaLista = new DoublyLinkedList<Integer>();

        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);

            this.lista.insertEnd(aleatorio);
            segundaLista.insertEnd(aleatorio);

        }

        this.lista.remove(this.lista.first());
        this.lista.remove(this.lista.last());

        assertNotEquals(this.lista, segundaLista);


    }

    @Test
    public void testSiADosListarIgualesLesAgregoNodosDistintosLasListasResultantesSeranDistintas(){

        Random generadorAletaorios = new Random();
        Integer aleatorio;
        DoublyLinkedList<Integer> segundaLista = new DoublyLinkedList<Integer>();

        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);

            this.lista.insertEnd(aleatorio);
            segundaLista.insertEnd(aleatorio);

        }

        this.lista.insertEnd(new Integer(89));
        segundaLista.insertEnd(new Integer(90));

        assertNotEquals(this.lista, segundaLista);

    }

    @Test
    public void testSiAgregoUnNodoALaListaEstaDebeIncrementarSuLongitudEnUno(){

        Random generadorAletaorios = new Random();
        Integer aleatorio;


        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);

            this.lista.insertEnd(aleatorio);

        }

        this.lista.insertEnd(new Integer(89));


        assertEquals(this.lista.listSize(), (NUM_ELEMENTOS + 1));

    }

    @Test
    public void testSiEliminoUnNodoDeLaListaEstaDebeDecrementarEnUnoSuLongitud(){

        Random generadorAletaorios = new Random();
        Integer aleatorio;


        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);

            this.lista.insertEnd(aleatorio);

        }

        this.lista.remove(this.lista.first());


        assertEquals(this.lista.listSize(), (NUM_ELEMENTOS - 1));

    }




    @Test
    public void testSiEliminoTodosLosNodosDeListaEstaDebeQuedarTotalmenteVacia(){

        Random generadorAletaorios = new Random();
        Integer aleatorio;


        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);

            this.lista.insertEnd(aleatorio);

        }

        this.lista.destroyList();


        assertTrue(this.lista.isEmpty());
        assertTrue(0 == this.lista.listSize());
        assertTrue(this.lista.first() == null);
        assertTrue(this.lista.last() == null);
        this.lista.firstNode;

    }



    @After
    public void testDespues(){

        this.lista = null;

    }
}