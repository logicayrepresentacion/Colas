/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package colas.vectorformacircular;

import colas.vectorformanocircular.*;
import java.lang.reflect.Array;

/**
 *
 * @author Alejandro Escobar
 * @param <T> es el tipo de datos a almacenar en la Cola
 */
public class ColaVectorCircular<T>  {

    int ultimo, primero;
    T[] datos;

    public ColaVectorCircular( Class<T> clase, int c) {
        datos = (T[]) Array.newInstance(clase, c+1);
        ultimo = 0;
        primero = 0;
    }

    public boolean esVacia() {
        return ultimo == primero;
    }

    public boolean estaLlena() {
        int simulacion = ( ultimo + 1 ) % datos.length;
        return simulacion == primero;
    }

    public void encolar(T dato) throws Exception {
        int simulacion = ( ultimo + 1 ) % datos.length;
        if( simulacion == primero){
            throw new Exception("Cola llena");
        }
        ultimo = simulacion;
        datos[ultimo] = dato;
    }

    public T desencolar() throws Exception {
        if( primero == ultimo){
            throw new Exception("Cola Vacia");
        }
        primero = (primero + 1 ) % datos.length;
        return datos[primero];
    }

}
