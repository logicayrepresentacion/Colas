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
package colas.listaligada.ejemplos.lavaAuto;

import colas.listaligada.ColasListaLigada;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandroescobar
 */
class Lavador implements Runnable {

    private final ColasListaLigada cola;

    Lavador(ColasListaLigada cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Estoy libre voy a lavar un carro");
                String placa;
                try {
                    placa = (String) cola.desencolar();
                    System.out.println("La placa a lavar es: " + placa);
                    System.out.println("...lavando...");
                } catch (Exception ex) {
                    System.out.println("Al parecer no hay mas carros, voy a esperar 10 seg " + ex.getMessage());
                }
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lavador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
