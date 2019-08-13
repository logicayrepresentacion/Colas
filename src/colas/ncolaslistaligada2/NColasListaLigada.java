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
package colas.ncolaslistaligada2;

import colas.listaligada.Nodo;

/**
 *
 * @author alejandroescobar
 * @param <T>
 */
public class NColasListaLigada<T> {

    Configuracion<T>[] configuracion;

    public NColasListaLigada(int ncolas) {
        configuracion = new Configuracion[ncolas];
    }

    public void encolar(int indice, T dato) {
        Nodo u = configuracion[indice].getUltimo();
        Nodo p = configuracion[indice].getPrimero();
        Nodo nuevoP = new Nodo(dato);
        if (u == null) {
            u = nuevoP;
            p = nuevoP;
        } else {
            u.setLiga(nuevoP);
            u = nuevoP;
        }

        configuracion[indice].setUltimo(u);
        configuracion[indice].setPrimero(p);

    }

    public T desencolar(int indice) throws Exception {
        Nodo u = configuracion[indice].getUltimo();
        Nodo p = configuracion[indice].getPrimero();

        Nodo ret = p;
        if (p != null) {
            p = p.getLiga();
            if (p == null) {
                u = p;
            }
        } else {
            throw new Exception("Cola vacia");
        }

        configuracion[indice].setUltimo(u);
        configuracion[indice].setPrimero(p);

        return (T) ret.getDato();
    }
}
