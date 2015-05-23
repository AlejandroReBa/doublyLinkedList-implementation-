package iis.doubly.linked.list;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Jose Antonio González Doñas on 10/05/2015.
 */
public class AppTest {

    private static final int NUM_ELEMENTOS = 10;
    private DoublyLinkedList<Integer> lista;

    @Before
    public void testBefore(){

        this.lista = new DoublyLinkedList<Integer>();

    }

    @Test
    public void testAlCrearLaListaDebeTenerLongitudCero(){

        assertTrue(this.lista.listSize()  == 0);


    }

    @Test (expected = DoublyLinkedListException.class)
    public void testAlCrearLaListaDebeDebeLanzarExcepciónAlTratarDeObtenerPrimerElemento(){

        this.lista.first();


    }

    @Test (expected = DoublyLinkedListException.class)
    public void testAlCrearLaListaDebeDebeLanzarExcepciónAlTratarDeObtenerUltimoElemento(){

        this.lista.last();

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
        List<Integer> listaAleatorios = new ArrayList<Integer>();


        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);
            listaAleatorios.add(aleatorio);

            this.lista.insertEnd(aleatorio);

        }

        //elimino todos los elementos antes introducidos
        for (Integer entero : listaAleatorios){

            this.lista.remove(entero);

        }


        assertTrue(this.lista.isEmpty());
        assertTrue(0 == this.lista.listSize());

    }



    /*
    * Es el único modo que se me ocurre de probar el método removeAll();
    */
    @Test
    public void siEliminoTodasLasOcurrenciasDeUnElementoSuLongitudDebeQuedarIgualOMenor(){

        Random generadorAletaorios = new Random();
        Integer aleatorio;
        int longitudTrasInserciones;
        int valorPrueba = 888;

        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);

            //cada iteración par, inserto un valor repetido
            if(contador % 2 == 0){

                this.lista.insertEnd(valorPrueba);

            }


            this.lista.insertEnd(aleatorio);

        }

        //para completar coverage
        this.lista.insertEnd(valorPrueba);

        longitudTrasInserciones = this.lista.listSize();

        this.lista.removeAll(valorPrueba);

        assertTrue(this.lista.listSize() <= longitudTrasInserciones);

    }


    @Test (expected = DoublyLinkedListException.class)
    public void siIntentoAccederAlPrimerElementoDeUnaListaVaciaDebeElevarseExcepcion(){

        this.lista.first();

    }

/*
    @Test
    public void siAccedoAlNodoDeUnaPosicionConcretaObtengoElValorEsperado(){

        Random generadorAletaorios = new Random();
        Integer aleatorio;
        Integer valorConocido = 99;

        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);


            this.lista.insertEnd(aleatorio);

        }

        //inserto en posicion NUM_ELEMENTOS + 1 un valor conocido:
        this.lista.insertEnd(new Integer(valorConocido));

        //inserto más valores
        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);


            this.lista.insertEnd(aleatorio);

        }

        assertEquals(valorConocido,this.lista.elementAtPosition(NUM_ELEMENTOS + 1));
    }*/

    @Test
    public void siInsertoUnNodoAlFinalDeLaListaInmediatamenteDespuesDeUnoConocidoQueOcupaLaPrimeraPosicionLoPodreEncontrarEnLaPosicionesperda(){

        Integer primerNodo = 99, nodoPosterior = 100, intercalado = 159;

        this.lista.insertBeginning(primerNodo);
        //para completar coverage
        this.lista.insertAfter(primerNodo,nodoPosterior);
        this.lista.insertAfter(primerNodo,intercalado);

        assertEquals(this.lista.last(), nodoPosterior);

    }

    @Test
    public void siInsertoUnNodoEnPosicionMediaDeLaListaInmediatamenteDespuesDeUnoConocidoQueOcupaLaPrimeraPosicionLoPodreEncontrarEnLaPosicionesperda(){

        Integer primero = 99, segundo = 999, dataAEncontrar = 100, ultimo = 101, intercalado = 666;

        this.lista.insertBeginning(primero);
        this.lista.insertAfter(primero,segundo);
        this.lista.insertAfter(segundo, dataAEncontrar);

        this.lista.insertAfter(dataAEncontrar,ultimo);

        //para completar coverage
        this.lista.insertAfter(dataAEncontrar,intercalado);


        assertEquals(this.lista.elementAtPosition(3), dataAEncontrar);

    }

    @Test
    public void siInsertoUnNodoEnPosicionMediaDeLaListaInmediatamenteAntesDeUnoConocidoQueOcupaLaPrimeraPosicionLoPodreEncontrarEnLaPosicionesperda(){

        Integer primero = 99, segundo = 999, dataAEncontrar = 100, ultimo = 101, intercalado = 666;

        this.lista.insertBeginning(primero);
        this.lista.insertBefore(primero, segundo);
        this.lista.insertBefore(segundo, dataAEncontrar);

        this.lista.insertBefore(dataAEncontrar, ultimo);

        //para completar coverage
        this.lista.insertBefore(dataAEncontrar, intercalado);


        assertEquals(this.lista.elementAtPosition(3), dataAEncontrar);

    }

    @Test
    public void siIntentoAccederAlUltimoElementoDeUnaListaVaciaDebeElevarseExcepcion(){

        try{

            this.lista.last();
            fail("Se esperaba que una excepción fuera elevada en este punto");

        }catch(DoublyLinkedListException excepcion){

        }

    }

    @Rule
    public ExpectedException e = ExpectedException.none();
    @Test
    public void siIntentoAccederAlElementoEnPosicionMayorQueLongitudListaDebeElevarseExcepcion(){

        Random generadorAletaorios = new Random();
        Integer aleatorio;

        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);


            this.lista.insertEnd(aleatorio);

        }



        e.expect(DoublyLinkedListException.class);
        e.expectMessage("Error: no existe un nodo en la posici�n " + (NUM_ELEMENTOS + 1));

        this.lista.elementAtPosition(NUM_ELEMENTOS + 1);
    }

    @Test
    public void alDestruirListaEstaQuedaConLongitudCero(){

        Random generadorAletaorios = new Random();
        Integer aleatorio;

        for(int contador = 0; contador < NUM_ELEMENTOS; contador++){

            aleatorio = generadorAletaorios.nextInt(1000);


            this.lista.insertEnd(aleatorio);

        }

        this.lista.destroyList();

        assertEquals(0,this.lista.listSize());


    }

    @Test
    public void alEjecutarToStringDeListaObtenemosLoEsperado(){

        Integer primero = 99, segundo = 999, tercero = 100, cuarto = 101, quinto = 666;

        this.lista.insertEnd(primero);
        this.lista.insertEnd(segundo);
        this.lista.insertEnd(tercero);
        this.lista.insertEnd(cuarto);
        this.lista.insertEnd(quinto);

        String cadenaEsperada = "99--999--100--101--666--";

        assertEquals(cadenaEsperada,this.lista.toString());



    }

    @After
    public void testDespues(){

        this.lista = null;

    }
}