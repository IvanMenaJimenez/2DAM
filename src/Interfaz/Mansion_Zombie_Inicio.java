/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import mansion_zombie.Habitacion;
import mansion_zombie.Juego;
import mansion_zombie.Main;
import mansion_zombie.Superviviente;

public class Mansion_Zombie_Inicio extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Mansion_Zombie_Inicio.class.getName());
    Juego juego = new Juego();
   

    public Mansion_Zombie_Inicio() {
        Image fondo = FondoUtil.cargarImagen("/Interfaz/img/fondo_inicio.png","D:\\ruta_absoluta\\fondo_inicio.png");
        setContentPane(new FondoUtil.FondoPanel(fondo));
        
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonJugar = new javax.swing.JButton();
        ButtonCargarPartida = new javax.swing.JButton();
        ButtonVerHistorial = new javax.swing.JButton();
        ComboBoxSeleccionarDificultad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 300));

        ButtonJugar.setText("Jugar");
        ButtonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonJugarActionPerformed(evt);
            }
        });

        ButtonCargarPartida.setText("Cargar Partida");

        ButtonVerHistorial.setText("Ver Historico");
        ButtonVerHistorial.setName("Ver historico"); // NOI18N

        ComboBoxSeleccionarDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facil", "Normal", "Dificil" }));
        ComboBoxSeleccionarDificultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSeleccionarDificultadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ButtonJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonCargarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonVerHistorial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75)
                .addComponent(ComboBoxSeleccionarDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonJugar)
                    .addComponent(ComboBoxSeleccionarDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(ButtonCargarPartida)
                .addGap(46, 46, 46)
                .addComponent(ButtonVerHistorial)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonJugarActionPerformed

        juego.iniciarJuego((String) this.ComboBoxSeleccionarDificultad.getSelectedItem());
        Accion accion = new Accion(this, true, juego);
        accion.setVisible(true);
    }//GEN-LAST:event_ButtonJugarActionPerformed

    private void ComboBoxSeleccionarDificultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxSeleccionarDificultadActionPerformed

    }//GEN-LAST:event_ComboBoxSeleccionarDificultadActionPerformed

    public class FondoUtil {

        public static Image cargarImagen(String rutaInterna, String rutaAbsoluta) {
            try {
                return new ImageIcon(
                        FondoUtil.class.getResource(rutaInterna)
                ).getImage();
            } catch (Exception e) {
                return new ImageIcon(rutaAbsoluta).getImage();
            }
        }

        public static class FondoPanel extends JPanel {

            private Image imagen;

            public FondoPanel(Image imagen) {
                this.imagen = imagen;
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Mansion_Zombie_Inicio().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCargarPartida;
    private javax.swing.JButton ButtonJugar;
    private javax.swing.JButton ButtonVerHistorial;
    private javax.swing.JComboBox<String> ComboBoxSeleccionarDificultad;
    // End of variables declaration//GEN-END:variables

}
