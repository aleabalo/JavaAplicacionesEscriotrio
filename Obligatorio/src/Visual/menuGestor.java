/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import javax.swing.JFrame;

/**
 *
 * @author ale
 */
public class menuGestor extends javax.swing.JFrame {

    /**
     * Creates new form menuGestor
     */
    public menuGestor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        btnAltaArea = new javax.swing.JMenu();
        btnRegistrarArea = new javax.swing.JMenuItem();
        btnAltaEmpresa = new javax.swing.JMenu();
        btnRegistroEmpresa = new javax.swing.JMenuItem();
        btnAltaOferta = new javax.swing.JMenu();
        btnRegistroOferta = new javax.swing.JMenuItem();
        btnComisiones = new javax.swing.JMenu();
        btnListadoComisones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAltaArea.setText("Area");

        btnRegistrarArea.setText("Registrar Area");
        btnRegistrarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAreaActionPerformed(evt);
            }
        });
        btnAltaArea.add(btnRegistrarArea);

        jMenuBar1.add(btnAltaArea);

        btnAltaEmpresa.setText("Empresa");

        btnRegistroEmpresa.setText("Registro Empresa");
        btnRegistroEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroEmpresaActionPerformed(evt);
            }
        });
        btnAltaEmpresa.add(btnRegistroEmpresa);

        jMenuBar1.add(btnAltaEmpresa);

        btnAltaOferta.setText("Oferta");

        btnRegistroOferta.setText("Registro Oferta");
        btnRegistroOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroOfertaActionPerformed(evt);
            }
        });
        btnAltaOferta.add(btnRegistroOferta);

        jMenuBar1.add(btnAltaOferta);

        btnComisiones.setText("Comisiones");

        btnListadoComisones.setText("Listado Comisiones");
        btnListadoComisones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoComisonesActionPerformed(evt);
            }
        });
        btnComisiones.add(btnListadoComisones);

        jMenuBar1.add(btnComisiones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAreaActionPerformed
        registroArea area = new registroArea();
        area.setVisible(true);
    }//GEN-LAST:event_btnRegistrarAreaActionPerformed

    private void btnRegistroEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroEmpresaActionPerformed
        registroEmpresa emp = new registroEmpresa();
        emp.setVisible(true);
    }//GEN-LAST:event_btnRegistroEmpresaActionPerformed

    private void btnRegistroOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroOfertaActionPerformed
        registroOferta oferta = new registroOferta();
        oferta.setVisible(true);
    }//GEN-LAST:event_btnRegistroOfertaActionPerformed

    private void btnListadoComisonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoComisonesActionPerformed
        listadoComisiones list = new listadoComisiones();
        list.setVisible(true);
        list.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnListadoComisonesActionPerformed

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
            java.util.logging.Logger.getLogger(menuGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGestor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnAltaArea;
    private javax.swing.JMenu btnAltaEmpresa;
    private javax.swing.JMenu btnAltaOferta;
    private javax.swing.JMenu btnComisiones;
    private javax.swing.JMenuItem btnListadoComisones;
    private javax.swing.JMenuItem btnRegistrarArea;
    private javax.swing.JMenuItem btnRegistroEmpresa;
    private javax.swing.JMenuItem btnRegistroOferta;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
