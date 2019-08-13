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
package colas;

/**
 *
 * @author alejandroescobar
 */
public class NColas {

    int[] datos;
    int[] base;
    int[] primeros;
    int[] ultimos;

    public NColas(int... capacidades) {

        int m = 0;
        for (int i : capacidades) {
            m = m + i;
        }
        datos = new int[m + 1];
        base = new int[capacidades.length];
        primeros = new int[capacidades.length];
        ultimos = new int[capacidades.length];

        for (int i = 0; i < capacidades.length; i++) {
            if (i == 0) {
                base[i] = 1;
                primeros[i] = 0;
                ultimos[i] = 0;
            } else {
                base[i] = base[i - 1] + capacidades[i - 1];
                primeros[i] = primeros[i - 1] + +capacidades[i - 1];
                ultimos[i] = ultimos[i - 1] + +capacidades[i - 1];
            }
        }
    }

    public void mostrarConfiguracion() {
        System.out.println("datos");
        for (int i = 0; i < datos.length; i++) {
            System.out.print(" - " + datos[i]);
        }
        System.out.println("");

        System.out.println("base");
        for (int i = 0; i < base.length; i++) {
            System.out.print(" - " + base[i]);
        }
        System.out.println("");

        System.out.println("primeros");
        for (int i = 0; i < primeros.length; i++) {
            System.out.print(" - " + primeros[i]);
        }
        System.out.println("");
        
        System.out.println("ultimos");
        for (int i = 0; i < ultimos.length; i++) {
            System.out.print(" - " + ultimos[i]);
        }
        System.out.println("");

    }

    public static void main(String[] args) {
        NColas nc = new NColas(3, 5, 4);
        nc.mostrarConfiguracion();
    }

}




















