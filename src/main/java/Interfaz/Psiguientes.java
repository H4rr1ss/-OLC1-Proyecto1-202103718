/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interfaz;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author harry
 */
public class Psiguientes extends javax.swing.JPanel {

    /**
     * Creates new form Psiguientes
     */
    public Psiguientes() {
        initComponents();
    }
    
    public void asignarImagen(String nombreImage){
        ImageIcon imagen = new ImageIcon("src/main/java/SIGUIENTES_202103718/"+nombreImage+".jpg");
        int alto = imagen.getIconHeight();
        int altoF = 0;
        
        if(alto < 310){
            altoF = alto+480;
        }else if(alto >=310 && alto<=590){
            altoF = alto+373;
        }else{
            altoF = alto+350;
        }
        System.out.println("TABLA SIGUIENTES ALTURA "+ altoF);
        // 780x640
        Icon miIcono = new ImageIcon(imagen.getImage().getScaledInstance(780, altoF, Image.SCALE_DEFAULT));
        lbl_image.setIcon(miIcono);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        bg = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 231, 208));
        setForeground(new java.awt.Color(240, 231, 208));
        setPreferredSize(new java.awt.Dimension(780, 640));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 1900));

        bg.setBackground(new java.awt.Color(240, 231, 208));
        bg.setForeground(new java.awt.Color(240, 231, 208));
        bg.setPreferredSize(new java.awt.Dimension(783, 1890));

        lbl_image.setBackground(new java.awt.Color(0, 0, 0));
        lbl_image.setForeground(new java.awt.Color(0, 0, 0));
        lbl_image.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 1884, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(bg);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 900));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_image;
    // End of variables declaration//GEN-END:variables
}
