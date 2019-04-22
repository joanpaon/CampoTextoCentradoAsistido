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

    // Propiedades App
    public static final String PRP_FAVICON_RESOURCE = "favicon_resource";
    public static final String PRP_FONT_RESOURCE = "font_resource";
    public static final String PRP_FORM_HEIGHT = "form_height";
    public static final String PRP_FORM_WIDTH = "form_width";
    public static final String PRP_FORM_TITLE = "form_title";
    public static final String PRP_IMAGE_RESOURCE = "image_resource";
    public static final String PRP_LOOK_AND_FEEL_PROFILE = "look_and_feel_profile";

    // Valores por Defecto
    public static final String DEF_FAVICON_RESOURCE = "img/favicon.png";
    public static final String DEF_FONT_FALLBACK_NAME = Font.SERIF;
    public static final String DEF_FONT_SYSTEM_NAME = "Kaufmann BT";
    public static final int DEF_FORM_HEIGHT = 300;
    public static final int DEF_FORM_WIDTH = 500;
    public static final String DEF_FORM_TITLE = "Swing Manual App";
    public static final String DEF_LOOK_AND_FEEL_PROFILE = UtilesSwing.LNF_WINDOWS_PROFILE;

    // Colores
    private final ArrayList<LabeledColor> COLORES = new ArrayList<>();

    // Referencias
    private final Properties prp;

    // Fuentes
    private Font fntSample;

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
        procesarTexto(evt);
    }//GEN-LAST:event_txfColorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField txfColor;
    // End of variables declaration//GEN-END:variables
    //
    // Inicialización Anterior    
    private void initBefore() {
        // Establecer LnF
        UtilesSwing.establecerLnFProfile(prp.getProperty(
                PRP_LOOK_AND_FEEL_PROFILE, DEF_LOOK_AND_FEEL_PROFILE));

        // Fuentes
        fntSample = UtilesSwing.generarFuenteRecurso(
                prp.getProperty(PRP_FONT_RESOURCE),
                DEF_FONT_SYSTEM_NAME,
                DEF_FONT_FALLBACK_NAME);

        // Cargar colores
        LabeledColor.cargarColores(prp, COLORES);
    }

    // Inicialización Posterior
    private void initAfter() {
        // Establecer Favicon
        UtilesSwing.establecerFavicon(this, prp.getProperty(
                PRP_FAVICON_RESOURCE, DEF_FAVICON_RESOURCE));

        // Etiqueta
        txfColor.setFont(fntSample.deriveFont(Font.BOLD, 40f));
        txfColor.setColumns(10);

        // Ventana Principal
        setTitle(prp.getProperty(PRP_FORM_TITLE, DEF_FORM_TITLE));
        try {
            int height = Integer.parseInt(prp.getProperty(PRP_FORM_HEIGHT));
            int width = Integer.parseInt(prp.getProperty(PRP_FORM_WIDTH));
            setSize(width, height);
        } catch (NumberFormatException e) {
            setSize(DEF_FORM_WIDTH, DEF_FORM_HEIGHT);
        }
    }

    // Pinta el Panel Principal con el color escrito
    public void procesarTexto(ActionEvent e) {
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
