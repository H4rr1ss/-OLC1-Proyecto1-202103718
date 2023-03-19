/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import java.awt.BorderLayout;

/**
 *
 * @author harry
 */
public class grafos extends javax.swing.JFrame {

    /**
     * Creates new form grafos
     */
    public grafos() {
        initComponents();
        setTitle("prueba");
        this.setLocationRelativeTo(this);  
        
    }
    
    private static String nombreEntrada = "";
    
    public static void nombreDeBusqueda(String nombre){
        nombreEntrada = nombre;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        lateral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_automatas = new javax.swing.JButton();
        btn_transiciones = new javax.swing.JButton();
        btn_siguientes = new javax.swing.JButton();
        btn_arbol = new javax.swing.JButton();
        btn_regresar = new java.awt.Button();
        auxNombre = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1397, 760));

        bg.setBackground(new java.awt.Color(227, 214, 184));
        bg.setMinimumSize(new java.awt.Dimension(2000, 760));
        bg.setPreferredSize(new java.awt.Dimension(1396, 760));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lateral.setBackground(new java.awt.Color(97, 18, 49));
        lateral.setPreferredSize(new java.awt.Dimension(180, 760));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(227, 214, 184));
        jLabel1.setText("GRAFOS");

        btn_automatas.setBackground(new java.awt.Color(101, 21, 53));
        btn_automatas.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btn_automatas.setForeground(new java.awt.Color(227, 214, 184));
        btn_automatas.setText("AUTOMATAS");
        btn_automatas.setBorder(null);
        btn_automatas.setBorderPainted(false);
        btn_automatas.setFocusPainted(false);
        btn_automatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_automatasActionPerformed(evt);
            }
        });

        btn_transiciones.setBackground(new java.awt.Color(101, 21, 53));
        btn_transiciones.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btn_transiciones.setForeground(new java.awt.Color(227, 214, 184));
        btn_transiciones.setText("TRANSICIONES");
        btn_transiciones.setBorder(null);
        btn_transiciones.setBorderPainted(false);
        btn_transiciones.setFocusPainted(false);
        btn_transiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transicionesActionPerformed(evt);
            }
        });

        btn_siguientes.setBackground(new java.awt.Color(101, 21, 53));
        btn_siguientes.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btn_siguientes.setForeground(new java.awt.Color(227, 214, 184));
        btn_siguientes.setText("SIGUIENTES");
        btn_siguientes.setBorder(null);
        btn_siguientes.setBorderPainted(false);
        btn_siguientes.setFocusPainted(false);
        btn_siguientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_siguientesActionPerformed(evt);
            }
        });

        btn_arbol.setBackground(new java.awt.Color(101, 21, 53));
        btn_arbol.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btn_arbol.setForeground(new java.awt.Color(227, 214, 184));
        btn_arbol.setText("ÁRBOLES");
        btn_arbol.setBorder(null);
        btn_arbol.setBorderPainted(false);
        btn_arbol.setFocusPainted(false);
        btn_arbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_arbolActionPerformed(evt);
            }
        });

        btn_regresar.setBackground(new java.awt.Color(227, 214, 184));
        btn_regresar.setLabel("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        auxNombre.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        auxNombre.setForeground(new java.awt.Color(240, 231, 208));
        auxNombre.setText("...");
        auxNombre.setToolTipText("");

        javax.swing.GroupLayout lateralLayout = new javax.swing.GroupLayout(lateral);
        lateral.setLayout(lateralLayout);
        lateralLayout.setHorizontalGroup(
            lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lateralLayout.createSequentialGroup()
                .addGroup(lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_automatas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_transiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_siguientes, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_arbol, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(lateralLayout.createSequentialGroup()
                .addGroup(lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lateralLayout.createSequentialGroup()
                        .addGroup(lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lateralLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1))
                            .addGroup(lateralLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(lateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(auxNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        lateralLayout.setVerticalGroup(
            lateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lateralLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(auxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(btn_arbol, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btn_siguientes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btn_transiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btn_automatas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        bg.add(lateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 180, 760));

        content.setBackground(new java.awt.Color(240, 231, 208));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        bg.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 1170, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btn_siguientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siguientesActionPerformed
        // TODO add your handling code here:
        this.auxNombre.setText(nombreEntrada);
        Psiguientes p3 = new Psiguientes();
        p3.setSize(780,640);
        p3.setLocation(190,23);
        p3.asignarImagen(nombreEntrada);
        
        content.removeAll();
        content.add(p3, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btn_siguientesActionPerformed

    private void btn_transicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transicionesActionPerformed
        // TODO add your handling code here:
        this.auxNombre.setText(nombreEntrada);
        Ptransiciones p2 = new Ptransiciones();
        p2.setSize(780,640);
        p2.setLocation(190,23);
        p2.asignarImagenn(nombreEntrada);
        
        content.removeAll();
        content.add(p2, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btn_transicionesActionPerformed

    private void btn_arbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_arbolActionPerformed
        // TODO add your handling code here:
        this.auxNombre.setText(nombreEntrada);
        Parbol p1 = new Parbol();
        p1.setSize(809,640);
        p1.setLocation(200,20);
        p1.asignarImagen(nombreEntrada);

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btn_arbolActionPerformed

    private void btn_automatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_automatasActionPerformed
        // TODO add your handling code here:
        this.auxNombre.setText(nombreEntrada);
        Pautomatas p4 = new Pautomatas();
        p4.setSize(780,640);
        p4.setLocation(1,1);
        //p4.asignarImageAutomata(nombreEntrada);
                
        content.removeAll();
        content.add(p4, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btn_automatasActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        // TODO add your handling code here:
        Menu men = new Menu();
        this.setVisible(false);
        men.setVisible(true);
    }//GEN-LAST:event_btn_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(grafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new grafos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel auxNombre;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btn_arbol;
    private javax.swing.JButton btn_automatas;
    private java.awt.Button btn_regresar;
    private javax.swing.JButton btn_siguientes;
    private javax.swing.JButton btn_transiciones;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel lateral;
    // End of variables declaration//GEN-END:variables
}
