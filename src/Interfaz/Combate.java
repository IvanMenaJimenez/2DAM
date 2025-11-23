package Interfaz;

import java.awt.Image;
import javax.swing.JOptionPane;
import mansion_zombie.*;

public class Combate extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Combate.class.getName());
    private Juego juego;
    private int ronda = 1;
    private boolean zombieMuerto = false;

    public Combate(java.awt.Frame parent, boolean modal, Juego juego) {
        //guardamos los atributos que se le pasan al JDialog 
        super(parent, modal);
        this.juego = juego;

        // Cargar imagen de fondo del menú principal
        Image fondo = Mansion_Zombie_Inicio.Fondo.cargarImagen("/Interfaz/img/fondo_Combate.png");
        setContentPane(new Mansion_Zombie_Inicio.Fondo.FondoPanel(fondo));

        //iniciamos los componentes y actualizamos los labels
        initComponents();
        mostrarAtributos();
    }

    public void mostrarAtributos() {
        //cambiamos los labels relacionado con el superviviente
        labelVidaSuperviviente.setText(Integer.toString(juego.getSuperviviente().getVida()));
        labelAtaqueSuperviviente.setText(Integer.toString(juego.getSuperviviente().getAtaque() + juego.getSuperviviente().getNum_armas()));

        //cambiamos los labels relacionado con el Zombie, si el zombie esta muerto los atributos seran 0
        if (!juego.getHabitacion().getZombies().isEmpty()) {
            labelVidaZombie.setText(Integer.toString(((Zombie) juego.getHabitacion().getZombies().getFirst()).getVida()));
            labelAtaqueZombie.setText(Integer.toString(((Zombie) juego.getHabitacion().getZombies().getFirst()).getAtaque()));
        } else {
            labelVidaZombie.setText("0");
            labelAtaqueZombie.setText("0");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaCombate = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelVidaZombie = new javax.swing.JLabel();
        labelAtaqueZombie = new javax.swing.JLabel();
        labelVidaSuperviviente = new javax.swing.JLabel();
        labelAtaqueSuperviviente = new javax.swing.JLabel();
        buttonAtacar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TextAreaCombate.setEditable(false);
        TextAreaCombate.setColumns(20);
        TextAreaCombate.setRows(5);
        jScrollPane1.setViewportView(TextAreaCombate);

        jLabel1.setText("Zombie");

        jLabel2.setText("Usuario");

        jLabel3.setText("Puntos de vida");

        jLabel4.setText("Puntos de Ataque");

        jLabel5.setText("Puntos de Vida");

        jLabel6.setText("Puntos de Ataque");

        labelVidaZombie.setText("jLabel8");

        labelAtaqueZombie.setText("jLabel9");

        labelVidaSuperviviente.setText("jLabel10");

        labelAtaqueSuperviviente.setText("jLabel11");

        buttonAtacar.setText("Atacar");
        buttonAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtacarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAtaqueZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelVidaZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelVidaSuperviviente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAtaqueSuperviviente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(buttonAtacar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(labelVidaZombie)
                    .addComponent(labelVidaSuperviviente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(labelAtaqueZombie)
                    .addComponent(labelAtaqueSuperviviente))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAtacar))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtacarActionPerformed
        //si la vida del jugador es menor o igual que cero salta el JOptionPane y cuando se cierra acaba la ejecucion del programa
        if (juego.getSuperviviente().getVida() <= 0) {
            JOptionPane.showMessageDialog(this, "HAS PERDIDO :(");
            System.exit(0);
        }

        //si has matado un zombie aunque queden en la sala se cierra la pantalla y para de jecutarse el metodo
        if (zombieMuerto) {
            this.setVisible(false);
            return;
        }

        //se imprime el resultado de la pelea que es lo devuelto por combate y se modifican los labels 
        TextAreaCombate.append("RONDA " + ronda + "\n" + juego.Combate());
        mostrarAtributos();

        //si el zombie tiene el valor vida menor o igual a 0 
        if (((Zombie) juego.getHabitacion().getZombies().getFirst()).getVida() <= 0) {
            //se inprime este mensaje , se borra el zombie y se modifica el atributo zombieMuerto
            TextAreaCombate.append("HAS MATADO AL ZOMBIE \n");
            juego.getHabitacion().getZombies().remove(0);

            zombieMuerto = true;
        }

        ronda++;
    }//GEN-LAST:event_buttonAtacarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TextAreaCombate;
    private javax.swing.JButton buttonAtacar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAtaqueSuperviviente;
    private javax.swing.JLabel labelAtaqueZombie;
    private javax.swing.JLabel labelVidaSuperviviente;
    private javax.swing.JLabel labelVidaZombie;
    // End of variables declaration//GEN-END:variables
}
