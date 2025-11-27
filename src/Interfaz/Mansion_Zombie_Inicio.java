package Interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mansion_zombie.Habitacion;
import mansion_zombie.Juego;
import mansion_zombie.Superviviente;

public class Mansion_Zombie_Inicio extends javax.swing.JFrame {

    Juego juego;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Mansion_Zombie_Inicio.class.getName());

    public Mansion_Zombie_Inicio() {
        // Cargar imagen de fondo del menú principal
        Image fondo = Fondo.cargarImagen("/Interfaz/img/fondo_inicio.png");
        setContentPane(new Fondo.FondoPanel(fondo));

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
        ButtonCargarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCargarPartidaActionPerformed(evt);
            }
        });

        ButtonVerHistorial.setText("Ver Historico");
        ButtonVerHistorial.setName("Ver historico"); // NOI18N
        ButtonVerHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonVerHistorialActionPerformed(evt);
            }
        });

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
                .addGap(33, 33, 33)
                .addComponent(ButtonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(ButtonVerHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComboBoxSeleccionarDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonCargarPartida)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(ComboBoxSeleccionarDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonJugar)
                    .addComponent(ButtonVerHistorial)
                    .addComponent(ButtonCargarPartida))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonJugarActionPerformed

        if (juego == null) {
            juego = new Juego();

            // Inicia el juego con la dificultad elegida
            juego.iniciarJuego((String) this.ComboBoxSeleccionarDificultad.getSelectedItem());
        }

        // Abre la ventana pacciones del juego pasandole el Jframe
        Accion accion = new Accion(this, true, juego);
        accion.setVisible(true);
    }//GEN-LAST:event_ButtonJugarActionPerformed

    private void ComboBoxSeleccionarDificultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxSeleccionarDificultadActionPerformed

    }//GEN-LAST:event_ComboBoxSeleccionarDificultadActionPerformed

    private void ButtonCargarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCargarPartidaActionPerformed
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PartidaGuardada"))) {
            juego = (Juego) ois.readObject();
            JOptionPane.showMessageDialog(this, "PARTIDA CARGADA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "NO EXISTEN DATOS GUARDADOS");
        }
    }//GEN-LAST:event_ButtonCargarPartidaActionPerformed

    private void ButtonVerHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonVerHistorialActionPerformed
        Historico historico = new Historico(this, true, juego);
        historico.setVisible(true);
        
    }//GEN-LAST:event_ButtonVerHistorialActionPerformed

    public class Fondo {

        // Carga una imagen desde el proyecto
        public static Image cargarImagen(String rutaInterna) {
            try {
                return new ImageIcon(Fondo.class.getResource(rutaInterna)).getImage();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        // Panel personalizado que dibuja la imagen de fondo
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
