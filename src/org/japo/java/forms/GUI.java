/*
 * Copyright 2019 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.forms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.japo.java.entities.LabeledColor;
import org.japo.java.libraries.UtilesSwing;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class GUI extends JFrame {

    // Colores
    private final ArrayList<LabeledColor> COLORES = new ArrayList<>();

    // Referencias
    private final Properties prp;

    // Fuentes
    private Font fntColor;

    // Constructor
    public GUI(Properties prp) {
        // Conectar Referencia
        this.prp = prp;

        // Inicialización Anterior
        initBefore();

        // Creación Interfaz
        initComponents();

        // Inicializacion Posterior
        initAfter();
    }

    // Construcción - GUI
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfColor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Swing Asistido #05");
        setSize(new java.awt.Dimension(500, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        txfColor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfColorActionPerformed(evt);
            }
        });
        getContentPane().add(txfColor, new java.awt.GridBagConstraints());

        setSize(new java.awt.Dimension(500, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txfColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfColorActionPerformed
        procesarAccion(evt);
    }//GEN-LAST:event_txfColorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField txfColor;
    // End of variables declaration//GEN-END:variables
    //
    // Inicialización Anterior    
    private void initBefore() {
        // Establecer LnF
        UtilesSwing.establecerLnFProfile(prp.getProperty("look_and_feel_profile"));

        // Cargar colores
        LabeledColor.cargarColores(prp, COLORES);

        // Fuentes
        fntColor = UtilesSwing.generarFuenteRecurso(prp.getProperty("font_resource"));

        // Cargar colores
        LabeledColor.cargarColores(prp, COLORES);
    }

    // Inicialización Posterior
    private void initAfter() {
        // Establecer Favicon
        UtilesSwing.establecerFavicon(this, prp.getProperty("img_favicon_resource"));

        // Campo de Texto de Color
        txfColor.setFont(fntColor.deriveFont(Font.BOLD, 40f));
        txfColor.setColumns(10);

        // Ventana Principal - Propiedades
        setTitle(prp.getProperty("form_title"));
        int width = Integer.parseInt(prp.getProperty("form_width"));
        int height = Integer.parseInt(prp.getProperty("form_height"));
        setSize(width, height);
        setLocationRelativeTo(null);
    }

    // Pinta el Panel Principal con el color escrito
    public void procesarAccion(ActionEvent e) {
        // Generador del evento
        JTextField txfActual = (JTextField) e.getSource();

        // Texto tecleado
        String color = txfActual.getText().trim().toUpperCase();

        // Obtener Color
        LabeledColor lc = LabeledColor.buscarColor(COLORES, color);

        // Cambiar Color Panel
        getContentPane().setBackground(lc);
    }
}
