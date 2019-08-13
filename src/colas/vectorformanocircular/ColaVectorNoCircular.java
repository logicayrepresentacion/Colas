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
package colas.vectorformanocircular;

import java.lang.reflect.Array;

/**
 *
 * @author Alejandro Escobar
 * @param <T> es el tipo de datos a almacenar en la Cola
 */
public class ColaVectorNoCircular<T>  {

    int ultimo, primero;
    T[] datos;

    public ColaVectorNoCircular( Class<T> clase, int c) {
        datos = (T[]) Array.newInstance(clase, c + 1);
        ultimo = 0;
        primero = 0;
    }

    public boolean esVacia() {
        return ultimo == primero;
    }

    public boolean estaLlena() {
        return (ultimo == datos.length - 1);
    }

    public void encolar(T dato) throws Exception {
        if ( ultimo == datos.length - 1 ) {
            if (primero == 0) {
                throw new Exception("Esta operación no se puede realizar " + dato);
            } else {
                reorganizar();
            }
        }
        datos[++ultimo] = dato;
    }

    public T desencolar() throws Exception {
        if (primero < ultimo) {
            T t = datos[++primero];
            if(primero == ultimo){
                ultimo = 0;
                primero = 0;
            }
            return t;
        } else {
            throw new Exception("Esta operación no se puede realizar");
        }
    }

    private void reorganizar() {
        
        int resta = primero;
        for (int i = primero + 1 ; i < datos.length; i++) {
            datos[i - resta] = datos[i];
        }
        
        primero = 0;
        ultimo = ultimo - resta;
        
    }

}
