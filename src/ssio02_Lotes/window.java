/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssio02_Lotes;

import java.awt.Toolkit;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alberto
 */
public class window extends javax.swing.JFrame {
    private ProcesamientoXLotes procesamiento = new ProcesamientoXLotes();
    
    private Timer timer = new Timer();
    private Contador contador = new Contador();
    private int procesosTerminados = 0;
    private boolean pausar = false;
    
    public window() {
        initComponents();
        initIcon();
        timer.scheduleAtFixedRate(contador,0,10);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPLoteEnEjecucion = new javax.swing.JPanel();
        jLLEE = new javax.swing.JLabel();
        jSPLEE = new javax.swing.JScrollPane();
        jTLEE = new javax.swing.JTable();
        jPProcesoEnEjecucion = new javax.swing.JPanel();
        jLPEE = new javax.swing.JLabel();
        jLO = new javax.swing.JLabel();
        jLOTXT = new javax.swing.JLabel();
        jLTME = new javax.swing.JLabel();
        jLTMETXT = new javax.swing.JLabel();
        jLNP = new javax.swing.JLabel();
        jLNPTXT = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLTT = new javax.swing.JLabel();
        jLTTTXT = new javax.swing.JLabel();
        jLTR = new javax.swing.JLabel();
        jLTRTXT = new javax.swing.JLabel();
        jPLoteTerminado = new javax.swing.JPanel();
        jLLT = new javax.swing.JLabel();
        jSPLT = new javax.swing.JScrollPane();
        jTLT = new javax.swing.JTable();
        jLTPendientes = new javax.swing.JLabel();
        jLPendientes = new javax.swing.JLabel();
        jLTTiempoGlobal = new javax.swing.JLabel();
        jLTiempoGlobal = new javax.swing.JLabel();
        jBIniciar = new javax.swing.JButton();
        jBAgregarAleatoriamente = new javax.swing.JButton();
        jTNAgregar = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMIInterrupcion = new javax.swing.JMenuItem();
        jMIError = new javax.swing.JMenuItem();
        jMIPausa = new javax.swing.JMenuItem();
        jMIContinuar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SSIO Lotes 02");
        setName("SSIO"); // NOI18N
        setResizable(false);

        jLLEE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLLEE.setText("Lote en Ejecución");

        jTLEE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "TME", "TR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jSPLEE.setViewportView(jTLEE);
        if (jTLEE.getColumnModel().getColumnCount() > 0) {
            jTLEE.getColumnModel().getColumn(0).setMinWidth(40);
            jTLEE.getColumnModel().getColumn(1).setMinWidth(40);
            jTLEE.getColumnModel().getColumn(2).setMinWidth(40);
        }

        javax.swing.GroupLayout jPLoteEnEjecucionLayout = new javax.swing.GroupLayout(jPLoteEnEjecucion);
        jPLoteEnEjecucion.setLayout(jPLoteEnEjecucionLayout);
        jPLoteEnEjecucionLayout.setHorizontalGroup(
            jPLoteEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLLEE, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
            .addComponent(jSPLEE, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPLoteEnEjecucionLayout.setVerticalGroup(
            jPLoteEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLoteEnEjecucionLayout.createSequentialGroup()
                .addComponent(jLLEE)
                .addGap(18, 18, 18)
                .addComponent(jSPLEE, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jLPEE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLPEE.setText("Lote en Ejecución");

        jLO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLO.setText("Operación");

        jLOTXT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLTME.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLTME.setText("TME");

        jLTMETXT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLNP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLNP.setText("# Programa");

        jLNPTXT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLTT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLTT.setText("Tiempo transcurrido");

        jLTTTXT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLTR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLTR.setText("Tiempo restante");

        jLTRTXT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPProcesoEnEjecucionLayout = new javax.swing.GroupLayout(jPProcesoEnEjecucion);
        jPProcesoEnEjecucion.setLayout(jPProcesoEnEjecucionLayout);
        jPProcesoEnEjecucionLayout.setHorizontalGroup(
            jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLPEE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPProcesoEnEjecucionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPProcesoEnEjecucionLayout.createSequentialGroup()
                        .addGroup(jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLNP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLTME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLOTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLTMETXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLNPTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPProcesoEnEjecucionLayout.createSequentialGroup()
                        .addGroup(jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLTR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLTTTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLTRTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPProcesoEnEjecucionLayout.setVerticalGroup(
            jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProcesoEnEjecucionLayout.createSequentialGroup()
                .addComponent(jLPEE)
                .addGroup(jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPProcesoEnEjecucionLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLOTXT))
                    .addGroup(jPProcesoEnEjecucionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLO)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTME)
                    .addComponent(jLTMETXT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLNPTXT)
                    .addComponent(jLNP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTT)
                    .addComponent(jLTTTXT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPProcesoEnEjecucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTR)
                    .addComponent(jLTRTXT))
                .addGap(0, 240, Short.MAX_VALUE))
        );

        jLLT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLLT.setText("Lotes Terminados");
        jLLT.setToolTipText("");

        jTLT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Operación", "Resultado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jSPLT.setViewportView(jTLT);
        if (jTLT.getColumnModel().getColumnCount() > 0) {
            jTLT.getColumnModel().getColumn(0).setMinWidth(50);
            jTLT.getColumnModel().getColumn(0).setMaxWidth(90);
            jTLT.getColumnModel().getColumn(1).setMinWidth(100);
            jTLT.getColumnModel().getColumn(1).setMaxWidth(250);
            jTLT.getColumnModel().getColumn(2).setMinWidth(100);
            jTLT.getColumnModel().getColumn(2).setMaxWidth(250);
        }

        javax.swing.GroupLayout jPLoteTerminadoLayout = new javax.swing.GroupLayout(jPLoteTerminado);
        jPLoteTerminado.setLayout(jPLoteTerminadoLayout);
        jPLoteTerminadoLayout.setHorizontalGroup(
            jPLoteTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLLT, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
            .addComponent(jSPLT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPLoteTerminadoLayout.setVerticalGroup(
            jPLoteTerminadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLoteTerminadoLayout.createSequentialGroup()
                .addComponent(jLLT)
                .addGap(18, 18, 18)
                .addComponent(jSPLT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jLTPendientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLTPendientes.setText("Lotes Pendientes: ");

        jLPendientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLPendientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLPendientes.setText("0");
        jLPendientes.setToolTipText("");

        jLTTiempoGlobal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLTTiempoGlobal.setText("Tiempo Global:");
        jLTTiempoGlobal.setToolTipText("");

        jLTiempoGlobal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLTiempoGlobal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTiempoGlobal.setText("000:00:000");
        jLTiempoGlobal.setToolTipText("");

        jBIniciar.setText("Iniciar");
        jBIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBIniciar.setEnabled(false);
        jBIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIniciarActionPerformed(evt);
            }
        });

        jBAgregarAleatoriamente.setText("Agregar Aleatoriamente");
        jBAgregarAleatoriamente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBAgregarAleatoriamente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarAleatoriamenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jLTPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPLoteEnEjecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jLTTiempoGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLTiempoGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPProcesoEnEjecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jBIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPLoteTerminado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBAgregarAleatoriamente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTNAgregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPLoteEnEjecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPProcesoEnEjecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPLoteTerminado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPendientes)
                    .addComponent(jLTPendientes)
                    .addComponent(jLTTiempoGlobal)
                    .addComponent(jLTiempoGlobal)
                    .addComponent(jTNAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBIniciar)
                    .addComponent(jBAgregarAleatoriamente))
                .addContainerGap())
        );

        jMenu1.setText("Acciones");

        jMIInterrupcion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, 0));
        jMIInterrupcion.setText("Interrupción");
        jMIInterrupcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIInterrupcionActionPerformed(evt);
            }
        });
        jMenu1.add(jMIInterrupcion);

        jMIError.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, 0));
        jMIError.setText("Error");
        jMIError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIErrorActionPerformed(evt);
            }
        });
        jMenu1.add(jMIError);

        jMIPausa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        jMIPausa.setText("Pausa");
        jMIPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPausaActionPerformed(evt);
            }
        });
        jMenu1.add(jMIPausa);

        jMIContinuar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        jMIContinuar.setText("Continuar");
        jMIContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIContinuarActionPerformed(evt);
            }
        });
        jMenu1.add(jMIContinuar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIniciarActionPerformed
        ejecutarProcesos();
    }//GEN-LAST:event_jBIniciarActionPerformed

    private void jBAgregarAleatoriamenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarAleatoriamenteActionPerformed
        try {
            int selectedIndex = Integer.parseInt(jTNAgregar.getText());
            while(selectedIndex > 0){
                agregarProcesoAleatorio();
                selectedIndex--;
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jBAgregarAleatoriamenteActionPerformed

    private void jMIInterrupcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIInterrupcionActionPerformed
        if(contador.estado != Estado.Interrupcion){
            contador.estado = Estado.Interrupcion;
        }
    }//GEN-LAST:event_jMIInterrupcionActionPerformed

    private void jMIErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIErrorActionPerformed
        if(contador.estado == Estado.Ejecucion){
            contador.estado = Estado.Error;
        }
    }//GEN-LAST:event_jMIErrorActionPerformed

    private void jMIPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPausaActionPerformed
        if(contador.estado != Estado.Pausa){
            contador.estado = Estado.Pausa;
            jBIniciar.setText("Iniciar");
        }
    }//GEN-LAST:event_jMIPausaActionPerformed

    private void jMIContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIContinuarActionPerformed
        if(contador.estado != Estado.Ejecucion){
            contador.estado = Estado.Ejecucion;
            jBIniciar.setText("Pausa");
        }
    }//GEN-LAST:event_jMIContinuarActionPerformed

    private void initIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    
    public void agregarProceso(int id, String nm, double v1, Operacion op, double v2, long tme){
        procesamiento.agregarProceso(id, nm, v1, op, v2, tme);
        jBIniciar.setEnabled(true);
        imprimirSiguienteLote();
    }
    
    public void permitirAbrirAgregarProceso(){
        //jBAgregarProceso.setEnabled(true);
    }
    
    private void agregarProcesoAleatorio(){
        Operacion operacionGenerada;
        switch(new Random().nextInt(5)){
            case 0:
                operacionGenerada = Operacion.suma;
                break;
            case 1:
                operacionGenerada = Operacion.resta;
                break;
            case 2:
                operacionGenerada = Operacion.multiplicacion;
                break;
            case 3:
                operacionGenerada = Operacion.division;
                break;
            default:
                operacionGenerada = Operacion.residuo;
                break;
        }
        double secondValue = operacionGenerada == Operacion.division 
                || operacionGenerada == Operacion.residuo ? (Math.random() * 100)+1.0f : Math.random() * 100;
        agregarProceso((int) Math.floor(Math.random() * 10000),"N / A",
                Math.floor(Math.random() * 100),operacionGenerada, Math.floor(secondValue),
                (int) Math.floor(Math.random() * 1000));
    }
    
    private void ejecutarProcesos(){
        if(contador.estado == Estado.Ejecucion){
            contador.estado = Estado.Pausa;
            jBIniciar.setText("Iniciar");
            return;
        } else if(contador.estado != Estado.Pausa){
            return;
        }
        jBIniciar.setText("Pausa");
        contador.ejecutarSiguienteProceso();
        //jBAgregarProceso.setEnabled(false);
        jBAgregarAleatoriamente.setEnabled(false);
        //jCNPA.setEnabled(false);
    }
    
    private void imprimirSiguienteLote(){
        Lote nuevoLote = procesamiento.getPrimerLote();
        ((DefaultTableModel)jTLEE.getModel()).setRowCount(0);
        if(nuevoLote != null && !nuevoLote.vacio()){
            for(Proceso proceso : nuevoLote.getProcesos()){
            ((DefaultTableModel)jTLEE.getModel()).addRow(
                    new String [] { "" + proceso.getId(), 
                        ""+proceso.getTiempoMaximoEstimado(), "" + proceso.getTiempoRestante()});
            }
        }
        
        jLPendientes.setText(""+procesamiento.lotesPendientes());
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new window().setVisible(true);
            }
        });
    }

//<editor-fold defaultstate="collapsed" desc="Variables Windows">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarAleatoriamente;
    private javax.swing.JButton jBIniciar;
    private javax.swing.JLabel jLLEE;
    private javax.swing.JLabel jLLT;
    private javax.swing.JLabel jLNP;
    private javax.swing.JLabel jLNPTXT;
    private javax.swing.JLabel jLO;
    private javax.swing.JLabel jLOTXT;
    private javax.swing.JLabel jLPEE;
    private javax.swing.JLabel jLPendientes;
    private javax.swing.JLabel jLTME;
    private javax.swing.JLabel jLTMETXT;
    private javax.swing.JLabel jLTPendientes;
    private javax.swing.JLabel jLTR;
    private javax.swing.JLabel jLTRTXT;
    private javax.swing.JLabel jLTT;
    private javax.swing.JLabel jLTTTXT;
    private javax.swing.JLabel jLTTiempoGlobal;
    private javax.swing.JLabel jLTiempoGlobal;
    private javax.swing.JMenuItem jMIContinuar;
    private javax.swing.JMenuItem jMIError;
    private javax.swing.JMenuItem jMIInterrupcion;
    private javax.swing.JMenuItem jMIPausa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPLoteEnEjecucion;
    private javax.swing.JPanel jPLoteTerminado;
    private javax.swing.JPanel jPProcesoEnEjecucion;
    private javax.swing.JScrollPane jSPLEE;
    private javax.swing.JScrollPane jSPLT;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTLEE;
    private javax.swing.JTable jTLT;
    private javax.swing.JTextField jTNAgregar;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
    private class Contador extends TimerTask{
        private byte miliSegundos = 0;
        private byte segundos = 0;
        private byte minutos = 0;
        private long tiempoTotal = 0;
        
        private long _Tinicio = 0;
        private long _tme = 0;
        private Proceso proceso;
        
        public Estado estado = Estado.Pausa;
        
        @Override
        public void run() {
            if(estado == Estado.Pausa){
                return;
            }
            if(proceso == null){
                procesosTerminados = 0;
                estado = Estado.Pausa;
                jBIniciar.setText("Iniciar");
                jBAgregarAleatoriamente.setEnabled(true);
                return;
            }
            jTLEE.setRowSelectionInterval(0, 0);
            if(estado == Estado.Interrupcion){
                proceso.setTiempoRestante((_tme - (tiempoTotal - _Tinicio)));
                procesamiento.InterrumpirProceso();
                ejecutarSiguienteProceso();
            } else if(terminarProceso() || estado == Estado.Error){
                procesamiento.terminarProceso();
                if(estado == Estado.Error){
                    proceso.reportarError();
                    estado = Estado.Ejecucion;
                }
                procesosTerminados++;
                ((DefaultTableModel)jTLT.getModel()).insertRow(0,
                    new String [] { ""+proceso.getId(), 
                        ""+proceso.getOperacion(),""+proceso.getResultado()});
                if(procesosTerminados % 6 == 0){
                    ((DefaultTableModel)jTLT.getModel()).insertRow(0,new String [] { "", "",""});
                }
                ejecutarSiguienteProceso();
            }
            
            miliSegundos++;
            tiempoTotal++;
            ajustar();
            imprimir();
        }
        
        private void ajustar(){
            if(miliSegundos == 100){
                miliSegundos= 0;
                segundos++;
                if(segundos == 60){
                    segundos = 0;
                    minutos++;
                    if(minutos > 999){
                        minutos = 0;
                    }
                }
            }
        }
        
        private void imprimir(){
            String t = "" + minutos + ":" + segundos + ":" + miliSegundos;
            jLTiempoGlobal.setText(t);
        }
        
        private boolean terminarProceso(){
            //System.out.println("TT: " + tiempoTotal + " Inicio " + _Tinicio +  " tme " + _tme);
            long tiempoTranscurrido = tiempoTotal - _Tinicio;
            jLTTTXT.setText(""+tiempoTranscurrido);
            jLTRTXT.setText(""+(_tme - tiempoTranscurrido));
            return tiempoTranscurrido > _tme;
        }
        
        private void setProceso(Proceso proceso){
            System.out.println("Proceso Ejecutado");
            this.proceso = proceso;
            if(proceso == null){
                limpiarTexto();
                jBIniciar.setEnabled(false);
                ((DefaultTableModel)jTLT.getModel()).insertRow(0,new String [] { "", "",""});
                return;
            }
            _tme = proceso.getTiempoRestante();
            jLOTXT.setText(proceso.getOperacion());
            jLTMETXT.setText(""+_tme);
            jLNPTXT.setText(""+proceso.getId());
            _Tinicio = tiempoTotal;
        }
        
        private void limpiarTexto(){
            jLOTXT.setText("");
            jLTMETXT.setText("");
            jLNPTXT.setText("");
            jLTTTXT.setText("");
            jLTRTXT.setText("");
        }
        
        public void ejecutarSiguienteProceso(){
            estado = Estado.Ejecucion;
            setProceso(procesamiento.ejecutarSiguienteProceso());
            imprimirSiguienteLote();
        }
    }
    
    private enum Estado{
        Ejecucion,
        Pausa,
        Interrupcion,
        Error
    }
}