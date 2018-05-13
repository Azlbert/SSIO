package ssio01_Lotes;

import java.awt.Toolkit;

public class AgregarProceso extends javax.swing.JFrame {
    private boolean estadoNombre = false;
    private boolean estadoValor1 = false;
    private boolean estadoValor2 = false;
    private boolean estadoTME = false;
    private boolean estadoNPrograma = false;
    
    private window win;
    
    /** Creates new form AgregarProceso */
    AgregarProceso() {
        initComponents();
        initIcon();
    }
    
    private void initIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    
    public AgregarProceso(window win) {
        initComponents();
        this.win = win;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLPRG = new javax.swing.JLabel();
        jLOP = new javax.swing.JLabel();
        jLTME = new javax.swing.JLabel();
        jLN = new javax.swing.JLabel();
        jTNOM = new javax.swing.JTextField();
        jTV1 = new javax.swing.JTextField();
        jCOP = new javax.swing.JComboBox<>();
        jTV2 = new javax.swing.JTextField();
        jTTME = new javax.swing.JTextField();
        jTNP = new javax.swing.JTextField();
        jAyC = new javax.swing.JButton();
        jAyT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLPRG.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLPRG.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLPRG.setText("Nombre del programador");

        jLOP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLOP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLOP.setText("Operación");

        jLTME.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLTME.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLTME.setText("Tiempo Maximo Empleado");

        jLN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLN.setText("Numero de programa");

        jTNOM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNOMKeyReleased(evt);
            }
        });

        jTV1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTV1KeyReleased(evt);
            }
        });

        jCOP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+", "-", "*", "/", "%" }));
        jCOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCOPActionPerformed(evt);
            }
        });

        jTV2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTV2KeyReleased(evt);
            }
        });

        jTTME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTMEKeyReleased(evt);
            }
        });

        jTNP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNPKeyReleased(evt);
            }
        });

        jAyC.setText("Agregar y Continuar");
        jAyC.setEnabled(false);
        jAyC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAyCActionPerformed(evt);
            }
        });

        jAyT.setText("Agregar y Terminar");
        jAyT.setEnabled(false);
        jAyT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAyTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLOP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLPRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLTME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLN, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jAyC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTNOM)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTV1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCOP, 0, 72, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTV2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTTME)
                    .addComponent(jTNP)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jAyT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPRG)
                    .addComponent(jTNOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLOP)
                    .addComponent(jTV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTV2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTME)
                    .addComponent(jTTME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLN)
                    .addComponent(jTNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAyC)
                    .addComponent(jAyT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTNOMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNOMKeyReleased
        estadoNombre = !jTNOM.getText().isEmpty();
        permitirAgregar();
    }//GEN-LAST:event_jTNOMKeyReleased

    private void jTV1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTV1KeyReleased
        String test = jTV1.getText();
        estadoValor1 = !test.isEmpty() && test.matches("^([-+])?\\d*(\\.\\d+)?$");
        permitirAgregar();
    }//GEN-LAST:event_jTV1KeyReleased

    private void jTV2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTV2KeyReleased
        validarSegundoValor();
    }//GEN-LAST:event_jTV2KeyReleased

    private void jTTMEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTMEKeyReleased
        String test = jTTME.getText();
        estadoTME = !test.isEmpty() && test.matches("^([+])?\\d*(\\.\\d+)?$") 
                && Integer.parseInt(test) > 0;
        permitirAgregar();
    }//GEN-LAST:event_jTTMEKeyReleased

    private void jTNPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNPKeyReleased
        String test = jTNP.getText();
        estadoNPrograma = !test.isEmpty() && test.matches("^\\d+$")
                && !Proceso.idGuardados.contains(Integer.parseInt(test));
        permitirAgregar();
    }//GEN-LAST:event_jTNPKeyReleased

    private void jAyCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAyCActionPerformed
        agregarProceso();
    }//GEN-LAST:event_jAyCActionPerformed

    private void jAyTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAyTActionPerformed
        agregarProceso();
        this.dispose();
    }//GEN-LAST:event_jAyTActionPerformed

    private void jCOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCOPActionPerformed
        validarSegundoValor();
    }//GEN-LAST:event_jCOPActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        win.permitirAbrirAgregarProceso();
    }//GEN-LAST:event_formWindowClosed
    
    private void agregarProceso(){
        int id = Integer.parseInt(jTNP.getText());
        double v1 = Double.parseDouble(jTV1.getText());
        double v2 = Double.parseDouble(jTV2.getText());
        long tme = Long.parseLong(jTTME.getText());
        Operacion operacion = getOperacion(jCOP.getSelectedIndex());
        win.agregarProceso(id, jTNOM.getText(), v1, operacion, v2, tme);
        jTNOM.setText("");
        jTNP.setText("");
        jTV1.setText("");
        jTV2.setText("");
        jTTME.setText("");
        estadoNombre = estadoNPrograma = estadoValor1 = estadoValor2 = estadoTME = false;
    }
    
    private void validarSegundoValor(){
        Operacion operacion = getOperacion(jCOP.getSelectedIndex());
        String test = jTV2.getText();
        estadoValor2 = !test.isEmpty() && test.matches("^([-+])?\\d*(\\.\\d+)?$");
        if(estadoValor2){
            if((operacion == Operacion.division || operacion == Operacion.residuo)
                    && Integer.parseInt(test) == 0){
                estadoValor2 = false;
            } else {
                estadoValor2 = true;
            }
        }
        permitirAgregar();
    }
    
    private boolean getEstados(){
        return estadoNPrograma && estadoNombre && estadoValor1
                && estadoValor2 && estadoTME;
    }
    
    private void permitirAgregar(){
        boolean permitir = getEstados();
        jAyC.setEnabled(permitir);
        jAyT.setEnabled(permitir);
    }
    
    private Operacion getOperacion(int index){
        switch(index){
            case 0:
                return Operacion.suma;
            case 1:
                return Operacion.resta;
            case 2:
                return Operacion.multiplicacion;
            case 3:
                return Operacion.division;
            case 4:
                return Operacion.residuo;
            default:
                return Operacion.suma;
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAyC;
    private javax.swing.JButton jAyT;
    private javax.swing.JComboBox<String> jCOP;
    private javax.swing.JLabel jLN;
    private javax.swing.JLabel jLOP;
    private javax.swing.JLabel jLPRG;
    private javax.swing.JLabel jLTME;
    private javax.swing.JTextField jTNOM;
    private javax.swing.JTextField jTNP;
    private javax.swing.JTextField jTTME;
    private javax.swing.JTextField jTV1;
    private javax.swing.JTextField jTV2;
    // End of variables declaration//GEN-END:variables

}
