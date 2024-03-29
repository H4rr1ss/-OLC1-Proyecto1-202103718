/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interfaz;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author harry
 */
public class Parbol extends javax.swing.JPanel {

    /**
     * Creates new form Parbol
     */
    public Parbol() {
        initComponents();
    }
    
    
    public void asignarImagen(String nombreImage){
        ImageIcon imagen = new ImageIcon("src/main/java/ARBOLES_202103718/"+nombreImage+".jpg");
        int alto = imagen.getIconHeight();
        int ancho = imagen.getIconWidth();
        
        int alturaF = 0;
        int anchoF = 0;
        //CONDICIONANTES PARA LA ALTURA DE LA IMAGEN
        if(alto < 560){
            alturaF = alto + 350;
        }else{
            alturaF = alto;
        }
        
        if(ancho >= 1000){
            anchoF = 750 + 260;
        }else{
            anchoF = 750;
        }
        
        
        System.out.println(" el ancho original de la imagen: "+ancho);
        System.out.println(" el ancho modificada del grafo: "+anchoF);
        System.out.println("Esta es la altura original de la imagen: "+alto);
        System.out.println("Esta es la altura modificada del grafo: "+alturaF);
        
        Icon miIcono = new ImageIcon(imagen.getImage().getScaledInstance(anchoF, alturaF, Image.SCALE_DEFAULT));
        lbl_imagen.setIcon(miIcono);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        bg = new javax.swing.JPanel();
        lbl_imagen = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 231, 208));
        setForeground(new java.awt.Color(240, 231, 208));
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(780, 640));
        setPreferredSize(new java.awt.Dimension(780, 640));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(32767, 2000));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(16, 700));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1000, 3000));

        bg.setBackground(new java.awt.Color(255, 204, 204));
        bg.setForeground(new java.awt.Color(240, 231, 208));
        bg.setPreferredSize(new java.awt.Dimension(1100, 3000));

        lbl_imagen.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(lbl_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 1900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(lbl_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 2950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(bg);
        bg.getAccessibleContext().setAccessibleName("");
        bg.getAccessibleContext().setAccessibleDescription("");

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 620));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_imagen;
    // End of variables declaration//GEN-END:variables
}
