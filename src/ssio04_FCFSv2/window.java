/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssio04_FCFSv2;

import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class window extends javax.swing.JFrame implements IManipulo{
    private final Timer timer = new Timer();
    private final FCFS fcfs;
    private final Tiempos tablaDeTiempos;
    
    private final DefaultTableModel tablaListos;
    private final DefaultTableModel tablaBloqueados;
    private final DefaultTableModel tablaTerminados;
    
    public window() {
        initComponents();
        initIcon();
        fcfs = new FCFS(this);
        tablaDeTiempos = new Tiempos(this);
        tablaListos = (DefaultTableModel)jtablaListos.getModel();
        tablaBloqueados = (DefaultTableModel)jtablaBloqueados.getModel();
        tablaTerminados = (DefaultTableModel)jtablaTerminados.getModel();
        
        tablaListos.setNumRows(0);
        tablaBloqueados.setNumRows(0);
        tablaTerminados.setNumRows(0);
        
        timer.scheduleAtFixedRate(fcfs,0,10);
    }
    
    private void initIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    
    public LinkedList<Proceso> getProcesos(){
        return fcfs.getProcesos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablaListos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtablaBloqueados = new javax.swing.JTable();
        jLabelColaDeListos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtablaTerminados = new javax.swing.JTable();
        jLabelBloqueados = new javax.swing.JLabel();
        jLabelTerminados = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNuevos = new javax.swing.JLabel();
        numeroDeNuevos = new javax.swing.JLabel();
        jLabelOperacion = new javax.swing.JLabel();
        jLabelTME = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jID = new javax.swing.JLabel();
        jOperacion = new javax.swing.JLabel();
        jTME = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelTT = new javax.swing.JLabel();
        jLabelTR = new javax.swing.JLabel();
        jTT = new javax.swing.JLabel();
        jTR = new javax.swing.JLabel();
        jLabelProcesoEnEjecucion = new javax.swing.JLabel();
        jLabelTiempoGlobal = new javax.swing.JLabel();
        jMinutos = new javax.swing.JLabel();
        jSegundos = new javax.swing.JLabel();
        jMilisegundos = new javax.swing.JLabel();
        jDosPuntosMS = new javax.swing.JLabel();
        jDosPuntosMS1 = new javax.swing.JLabel();
        bIniciar = new javax.swing.JButton();
        jNumeroDeProcesos = new javax.swing.JTextField();
        bAgregarProcesos = new javax.swing.JButton();
        jVerTiempos = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuOperaciones = new javax.swing.JMenu();
        menuItemAgregar = new javax.swing.JMenuItem();
        menuItemInterrumpir = new javax.swing.JMenuItem();
        menuItemError = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuItemPausa = new javax.swing.JMenuItem();
        menuItemContinuar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 490));
        setPreferredSize(new java.awt.Dimension(950, 490));

        contenedor.setMaximumSize(new java.awt.Dimension(851, 398));
        contenedor.setMinimumSize(new java.awt.Dimension(851, 398));

        jtablaListos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "TME", "TR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtablaListos);

        jtablaBloqueados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "TT Bloqueado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtablaBloqueados);

        jLabelColaDeListos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelColaDeListos.setText("Listos");

        jtablaTerminados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Operación", "Resultado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtablaTerminados);

        jLabelBloqueados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelBloqueados.setText("Bloqueados");

        jLabelTerminados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTerminados.setText("Terminados");

        jLabelNuevos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNuevos.setText("Nuevos");

        numeroDeNuevos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numeroDeNuevos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroDeNuevos.setText("00");
        numeroDeNuevos.setToolTipText("");

        jLabelOperacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelOperacion.setText("Operación     -");

        jLabelTME.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTME.setText("TME             -");

        jLabelID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelID.setText("ID                -");

        jID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jOperacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jOperacion.setToolTipText("");

        jTME.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelTT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTT.setText("Tiempo Transcurrido:");
        jLabelTT.setMaximumSize(new java.awt.Dimension(86, 15));

        jLabelTR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTR.setText("Tiempo Restante:");
        jLabelTR.setMaximumSize(new java.awt.Dimension(86, 15));

        jTT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTT.setMaximumSize(new java.awt.Dimension(86, 15));

        jTR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTR.setMaximumSize(new java.awt.Dimension(86, 15));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(jLabelOperacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelNuevos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numeroDeNuevos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelTR, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelTT, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOperacion)
                    .addComponent(jOperacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTME)
                    .addComponent(jTME))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroDeNuevos)
                    .addComponent(jLabelNuevos)))
        );

        jLabelProcesoEnEjecucion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProcesoEnEjecucion.setText("Proceso en Ejecución");

        jLabelTiempoGlobal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTiempoGlobal.setText("Tiempo Global:");

        jMinutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMinutos.setText("00");

        jSegundos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSegundos.setText("00");

        jMilisegundos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMilisegundos.setText("00");

        jDosPuntosMS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jDosPuntosMS.setText(":");

        jDosPuntosMS1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jDosPuntosMS1.setText(":");

        bIniciar.setText("Iniciar");
        bIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarActionPerformed(evt);
            }
        });

        bAgregarProcesos.setText("Agregar procesos");
        bAgregarProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarProcesosActionPerformed(evt);
            }
        });

        jVerTiempos.setText("Ver Tiempos");
        jVerTiempos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVerTiemposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabelColaDeListos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jNumeroDeProcesos)
                    .addComponent(bAgregarProcesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addComponent(jLabelTiempoGlobal)
                        .addGap(27, 27, 27)
                        .addComponent(jMinutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDosPuntosMS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSegundos)
                        .addGap(3, 3, 3)
                        .addComponent(jDosPuntosMS1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMilisegundos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelProcesoEnEjecucion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabelBloqueados, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabelTerminados, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(jVerTiempos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelColaDeListos)
                    .addComponent(jLabelBloqueados)
                    .addComponent(jLabelTerminados)
                    .addComponent(jLabelProcesoEnEjecucion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTiempoGlobal)
                            .addComponent(jMinutos)
                            .addComponent(jMilisegundos)
                            .addComponent(jDosPuntosMS)
                            .addComponent(jDosPuntosMS1)
                            .addComponent(jSegundos)
                            .addComponent(jNumeroDeProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bIniciar)
                            .addComponent(bAgregarProcesos))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                        .addComponent(jVerTiempos)
                        .addContainerGap())))
        );

        menuOperaciones.setText("Acciones");

        menuItemAgregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, 0));
        menuItemAgregar.setText("Agregar");
        menuItemAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuItemAgregar);

        menuItemInterrumpir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, 0));
        menuItemInterrumpir.setText("Interrupción");
        menuItemInterrumpir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInterrumpirActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuItemInterrumpir);

        menuItemError.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, 0));
        menuItemError.setText("Error");
        menuItemError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemErrorActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuItemError);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, 0));
        jMenuItem1.setText("Tabla");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuOperaciones.add(jMenuItem1);

        menuItemPausa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        menuItemPausa.setText("Pausa");
        menuItemPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPausaActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuItemPausa);

        menuItemContinuar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        menuItemContinuar.setText("Continuar");
        menuItemContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemContinuarActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuItemContinuar);

        menu.add(menuOperaciones);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgregarActionPerformed
        fcfs.crearNuevoProcesoAleatorio();
    }//GEN-LAST:event_menuItemAgregarActionPerformed

    private void menuItemInterrumpirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInterrumpirActionPerformed
        fcfs.interrumtpir();
    }//GEN-LAST:event_menuItemInterrumpirActionPerformed

    private void menuItemErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemErrorActionPerformed
        fcfs.causarError();
    }//GEN-LAST:event_menuItemErrorActionPerformed

    private void menuItemPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPausaActionPerformed
        fcfs.pausar();
    }//GEN-LAST:event_menuItemPausaActionPerformed

    private void menuItemContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemContinuarActionPerformed
        if(tablaDeTiempos.isVisible())   return;
        fcfs.continuar();
    }//GEN-LAST:event_menuItemContinuarActionPerformed

    private void bIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarActionPerformed
        fcfs.iniciar();
    }//GEN-LAST:event_bIniciarActionPerformed

    private void bAgregarProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarProcesosActionPerformed
        try {
            int selectedIndex = Integer.parseInt(jNumeroDeProcesos.getText());
            fcfs.crearProcesosAleatorios(selectedIndex);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_bAgregarProcesosActionPerformed

    private void jVerTiemposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVerTiemposActionPerformed
        verTiempos();
    }//GEN-LAST:event_jVerTiemposActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        verTiempos();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void verTiempos(){
        if(tablaDeTiempos.isVisible())  return;
        
        fcfs.pausar();
        tablaDeTiempos.setVisible(true);
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregarProcesos;
    private javax.swing.JButton bIniciar;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jDosPuntosMS;
    private javax.swing.JLabel jDosPuntosMS1;
    private javax.swing.JLabel jID;
    private javax.swing.JLabel jLabelBloqueados;
    private javax.swing.JLabel jLabelColaDeListos;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelNuevos;
    private javax.swing.JLabel jLabelOperacion;
    private javax.swing.JLabel jLabelProcesoEnEjecucion;
    private javax.swing.JLabel jLabelTME;
    private javax.swing.JLabel jLabelTR;
    private javax.swing.JLabel jLabelTT;
    private javax.swing.JLabel jLabelTerminados;
    private javax.swing.JLabel jLabelTiempoGlobal;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel jMilisegundos;
    private javax.swing.JLabel jMinutos;
    private javax.swing.JTextField jNumeroDeProcesos;
    private javax.swing.JLabel jOperacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jSegundos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jTME;
    private javax.swing.JLabel jTR;
    private javax.swing.JLabel jTT;
    private javax.swing.JButton jVerTiempos;
    private javax.swing.JTable jtablaBloqueados;
    private javax.swing.JTable jtablaListos;
    private javax.swing.JTable jtablaTerminados;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menuItemAgregar;
    private javax.swing.JMenuItem menuItemContinuar;
    private javax.swing.JMenuItem menuItemError;
    private javax.swing.JMenuItem menuItemInterrumpir;
    private javax.swing.JMenuItem menuItemPausa;
    private javax.swing.JMenu menuOperaciones;
    private javax.swing.JLabel numeroDeNuevos;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
    
    @Override
    public void actualizarContadorProceosNuevos(int numeroDeProcesos) {
        numeroDeNuevos.setText(""+numeroDeProcesos);
    }

    @Override
    public void agregarProcesoListos(int id, long tme, long tr) {
        tablaListos.addRow(new Object[]{id,tme,tr});
    }

    @Override
    public void eliminarPrimerProcesoDeListos() {
        if(tablaListos.getRowCount() > 0)
            tablaListos.removeRow(0);
    }

    @Override
    public void actualizarReloj(int minutos, int segundos, int milisegundos) {
        jMinutos.setText(String.format("%02d", minutos));
        jSegundos.setText(String.format("%02d", segundos));
        jMilisegundos.setText(String.format("%02d", milisegundos));
    }

    @Override
    public void ejecutarSiguienteProceso(int id, long TME, String operacion) {
        jID.setText("" + id);
        jTME.setText("" + TME);
        jOperacion.setText(operacion);
        if(jtablaListos.getRowCount() > 0)
            jtablaListos.setRowSelectionInterval(0, 0);
        eliminarPrimerProcesoDeListos();
    }

    @Override
    public void borrarProcesoEnEjecucion() {
        jID.setText("");
        jTME.setText("");
        jOperacion.setText("");
        jTT.setText("");
        jTR.setText("");
    }

    @Override
    public void actualizarTiemposDelProcesoEnEjecucion(long tt, long tr) {
        jTT.setText(""+tt);
        jTR.setText(""+tr);
    }

    @Override
    public void agregarProcesoTerminado(int id, String operacion, String resultado) {
        tablaTerminados.insertRow(0,new Object[]{id,operacion,resultado});
    }

    @Override
    public void agregarProcesoBloqueado(int id, long tt) {
        tablaBloqueados.addRow(new Object[]{id,tt});
    }

    @Override
    public void eliminarPrimerProcesoBloqueado() {
        if(tablaBloqueados.getRowCount() > 0)
            tablaBloqueados.removeRow(0);
    }

    @Override
    public void actualizarTiempoRestanteDeBloqueados(int row, long tiempo) {
        if(tablaBloqueados.getRowCount() <= 0)  return;
        if(tablaBloqueados.getRowCount() <= row)  return;
        jtablaBloqueados.setValueAt(tiempo, row, 1);
    }
}
