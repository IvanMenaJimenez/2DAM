/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Interfaz;

import java.awt.Image;
import mansion_zombie.Habitacion;
import mansion_zombie.Juego;
import mansion_zombie.Superviviente;

/**
 *
 * @author ivan.menjim
 */
public class Accion extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Accion.class.getName());
    java.awt.Frame parent;
    Juego juego;

   
    public Accion(java.awt.Frame parent, boolean modal, Juego juego) {
        

        super(parent, modal);
        this.juego = juego;
        this.parent = parent;
        
        
        Image fondo = Mansion_Zombie_Inicio.FondoUtil.cargarImagen("/Interfaz/img/fondo_Accion.png", "D:\\ruta_absoluta\\fondo_inicio.png");
        setContentPane(new Mansion_Zombie_Inicio.FondoUtil.FondoPanel(fondo));
        initComponents();

        mostrarAccionesDisponibles();
        mostrarAtributosJugador();

    }

    public void actulizarParametros() {
        mostrarAccionesDisponibles();
        mostrarAtributosJugador();
    }

    public void mostrarAccionesDisponibles() {
        ButtonAvanza.setEnabled(true);
        ButtonBuscar.setEnabled(true);
        ButtonCurarse.setEnabled(true);
        ButtonLuchar.setEnabled(true);

        if (juego.getHabitacion().getZombies().isEmpty()) {
            ButtonLuchar.setEnabled(false);

            if (juego.getSuperviviente().isBotiquin() == false) {
                ButtonCurarse.setEnabled(false);
            }

            if (juego.getHabitacion().getNumIntentosRest() == 0) {
                ButtonBuscar.setEnabled(false);
            }

        } else {
            ButtonAvanza.setEnabled(false);
            ButtonBuscar.setEnabled(false);
            ButtonCurarse.setEnabled(false);

        }
    }

    public void mostrarAtributosJugador() {
        labelVida.setText(Integer.toString(juego.getSuperviviente().getVida()));

        labelProtecciones.setText(Integer.toString(juego.getSuperviviente().getNum_protecion()));

        labelArmas.setText(Integer.toString(juego.getSuperviviente().getNum_armas()));

        labelBotiquin.setText(Boolean.toString(juego.getSuperviviente().isBotiquin()));

        labelBusqueda.setText(Integer.toString(juego.getHabitacion().getNumIntentosRest()));

        jLabel7.setText("Habitacion {Max " + juego.getHabitacionMax() + "}");

        labelHabitacion.setText(Integer.toString(juego.getHabitacionActual()));

        labelZombies.setText(Integer.toString(juego.getHabitacion().getZombies().size()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ButtonLuchar = new javax.swing.JButton();
        ButtonCurarse = new javax.swing.JButton();
        ButtonBuscar = new javax.swing.JButton();
        ButtonAvanza = new javax.swing.JButton();
        ButtonGuardar = new javax.swing.JButton();
        labelVida = new javax.swing.JLabel();
        labelProtecciones = new javax.swing.JLabel();
        labelArmas = new javax.swing.JLabel();
        labelBotiquin = new javax.swing.JLabel();
        labelBusqueda = new javax.swing.JLabel();
        labelHabitacion = new javax.swing.JLabel();
        labelZombies = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Puntos de vida:");

        jLabel2.setText("Cantidad protecciones:");

        jLabel3.setText("Cantidas de armas:");

        jLabel4.setText("¿Botiquin?");

        jLabel5.setText("Intentos de busqueda:");

        jLabel6.setText("Zombies:");

        jLabel7.setText("Habitacion");

        ButtonLuchar.setText("Luchar");
        ButtonLuchar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLucharActionPerformed(evt);
            }
        });

        ButtonCurarse.setText("Curarse");
        ButtonCurarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCurarseActionPerformed(evt);
            }
        });

        ButtonBuscar.setText("Buscar");
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

        ButtonAvanza.setText("Avanza");
        ButtonAvanza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAvanzaActionPerformed(evt);
            }
        });

        ButtonGuardar.setText("Guardar");

        labelVida.setText("jLabel8");

        labelProtecciones.setText("jLabel9");

        labelArmas.setText("jLabel10");

        labelBotiquin.setText("jLabel11");

        labelBusqueda.setText("jLabel12");

        labelHabitacion.setText("jLabel13");

        labelZombies.setText("jLabel14");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelVida, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelProtecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBotiquin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(ButtonGuardar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonLuchar)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonCurarse)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelZombies, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonBuscar)
                            .addComponent(ButtonAvanza))
                        .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(labelVida)
                        .addComponent(labelHabitacion))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(ButtonLuchar)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonCurarse)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(labelZombies))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(labelProtecciones)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(labelArmas))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(labelBotiquin))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(labelBusqueda))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(ButtonGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ButtonAvanza)))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLucharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLucharActionPerformed
        Combate combate = new Combate(parent, true, juego);
        combate.setVisible(true);
        actulizarParametros();
    }//GEN-LAST:event_ButtonLucharActionPerformed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        javax.swing.JOptionPane.showMessageDialog(this, juego.getHabitacion().Buscar(juego.getSuperviviente()));
        actulizarParametros();
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void ButtonCurarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCurarseActionPerformed
        javax.swing.JOptionPane.showMessageDialog(this, "TE HAS CURADO " + Integer.toString(juego.getSuperviviente().UsarBotiquin()));
        actulizarParametros();
    }//GEN-LAST:event_ButtonCurarseActionPerformed

    private void ButtonAvanzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAvanzaActionPerformed
        if (juego.getHabitacionActual() > juego.getHabitacionMax()) {
            javax.swing.JOptionPane.showMessageDialog(this, "HAS SOBREVIVIDO");
            System.exit(0);
        } else {
            juego.avanzar();
            javax.swing.JOptionPane.showMessageDialog(this, "HAS AVANZADO A LA SALA " + juego.getHabitacionActual());
            actulizarParametros();
        }
    }//GEN-LAST:event_ButtonAvanzaActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                Accion dialog = new Accion(new javax.swing.JFrame(), true , juego);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAvanza;
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JButton ButtonCurarse;
    private javax.swing.JButton ButtonGuardar;
    private javax.swing.JButton ButtonLuchar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelArmas;
    private javax.swing.JLabel labelBotiquin;
    private javax.swing.JLabel labelBusqueda;
    private javax.swing.JLabel labelHabitacion;
    private javax.swing.JLabel labelProtecciones;
    private javax.swing.JLabel labelVida;
    private javax.swing.JLabel labelZombies;
    // End of variables declaration//GEN-END:variables
}
