/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import DataTypes.DataArea;
import DataTypes.DataEmpresa;
import DataTypes.DataOferta;
import Logica.logicaArea;
import Logica.logicaEmpresa;
import Logica.logicaOferta;
import java.util.List;

/**
 *
 * @author Estefanía
 */
public class registroOferta extends javax.swing.JFrame {

    /**
     * Creates new form registroOferta
     */
    public registroOferta() {
        initComponents();
        CargarAreas();
        CargarEmpresas();
        iniciarBotones();
    }

    //Cargo la lista de Ofertas
    private void CargarAreas() {
        try {
            ComboArea.removeAllItems();
            List<DataArea> lista = logicaArea.getInstance().ListarArea();
            if (lista.isEmpty()) {
                throw new Exception("No hay áreas ingresadas en el sistema.");
            } else {
                for (DataArea o : lista) {
                    ComboArea.addItem(o);
                }
            }
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }

    //Cargo la lista de Empresas en el combo
    private void CargarEmpresas() {
        try {
            ComboEmpresa.removeAllItems();
            List<DataEmpresa> lista = logicaEmpresa.getInstance().ListEmpresa();
            if (lista.isEmpty()) {
                throw new Exception("No hay Empresas ingresadas en el sistema.");
            } else {
                for (DataEmpresa e : lista) {
                    ComboEmpresa.addItem(e);
                }
            }
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }

    private void iniciarBotones() {
        BtnRegistrar.setVisible(true);
        BtnDesactivar.setVisible(false);
        BtnModificar.setVisible(false);
        txtIdOferta.setEditable(true);
    }

    private void iniciarBotonesEdit() {
        BtnRegistrar.setVisible(false);
        BtnDesactivar.setVisible(true);
        BtnModificar.setVisible(true);
        txtIdOferta.setEditable(false);
        lblError.setText("");
    }

    private void validarId() {
        try {
            int a = Integer.parseInt(txtIdOferta.getText());
        } catch (Exception e) {
            lblError.setVisible(true);
            lblError.setText("El id debe ser numerico");
        }
    }

    private void validarFormulario() throws Exception {
        if (txtTitulo.getText().isEmpty()) {
            throw new Exception("Debe ingresar un titulo");
        }
        if (txtCargo.getText().isEmpty()) {
            throw new Exception("Debe ingresar una descripcion del cargo");
        }
        if (txtReq.getText().isEmpty()) {
            throw new Exception("Debe ingresar un requerimiento");
        }
        try {
            int a = Integer.parseInt(txtPuestos.getText());
        } catch (Exception e) {
            throw new Exception("La cantidad de puestos debe ser numerica");
        }

        if (ComboArea.getSelectedItem() == null) {
            throw new Exception("debe seleccionar una area");
        }
        if (ComboEmpresa.getSelectedItem() == null) {
            throw new Exception("debe seleccionar una empresa");
        }
    }

    private void limpiarCampos() {
        txtTitulo.setText("");
        txtCargo.setText("");
        txtReq.setText("");
        txtPuestos.setText("");
        //pendiente de ver que dejo seleccionado en el combo area y combo empresa        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdOferta = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCargo = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReq = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtPuestos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ComboEmpresa = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        ComboArea = new javax.swing.JComboBox();
        BtnRegistrar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnDesactivar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Ofertas");

        jLabel2.setText("Id Oferta:");

        txtIdOferta.setName("txtIdOferta"); // NOI18N
        txtIdOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdOfertaActionPerformed(evt);
            }
        });

        BtnBuscar.setText("Buscar");
        BtnBuscar.setToolTipText("");
        BtnBuscar.setName("BuscarOferta"); // NOI18N
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Titulo:");
        jLabel3.setName("Titulo"); // NOI18N

        txtTitulo.setName("txtTitulo"); // NOI18N

        jLabel4.setText("Descripcion de Cargo:");
        jLabel4.setName("Titulo"); // NOI18N

        txtCargo.setColumns(20);
        txtCargo.setRows(5);
        txtCargo.setName("descCargo"); // NOI18N
        jScrollPane1.setViewportView(txtCargo);

        jLabel5.setText("Requerimientos:");
        jLabel5.setName("Requerimientos"); // NOI18N

        txtReq.setColumns(20);
        txtReq.setRows(5);
        txtReq.setName("txtRequerimientos"); // NOI18N
        jScrollPane2.setViewportView(txtReq);

        jLabel6.setText("Puestos:");

        txtPuestos.setName("txtPuestos"); // NOI18N

        jLabel7.setText("Empresa:");

        ComboEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboEmpresa.setName("cbAreas"); // NOI18N

        jLabel8.setText("Area:");

        ComboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboArea.setName("cbEmpresas"); // NOI18N

        BtnRegistrar.setText("Registrar Oferta");
        BtnRegistrar.setName("btnRegistrar"); // NOI18N
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar Oferta");
        BtnModificar.setName("btnModificar"); // NOI18N

        BtnDesactivar.setText("Desactivar Oferta");
        BtnDesactivar.setName("btnDesactivar"); // NOI18N

        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setName("lblError"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ComboEmpresa, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPuestos, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ComboArea, javax.swing.GroupLayout.Alignment.LEADING, 0, 124, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIdOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnBuscar))
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(BtnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnDesactivar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnRegistrar)
                    .addComponent(BtnModificar)
                    .addComponent(BtnDesactivar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        try {
            lblError.setText("");
            validarId();
            int a = Integer.parseInt(txtIdOferta.getText());
            DataOferta of = logicaOferta.getInstance().buscarOferta(a);
            txtTitulo.setText(of.getTitulo());
            txtCargo.setText(of.getCargo());
            txtReq.setText(of.getRequerimientos());
            txtPuestos.setText(String.valueOf(of.getPuestos()));
            ComboArea.setSelectedItem(of.getArea());
            ComboEmpresa.setSelectedItem(of.getEmpresa());
            iniciarBotonesEdit();

        } catch (Exception e) {
            lblError.setText(e.getMessage());
            iniciarBotones();
            limpiarCampos();
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void txtIdOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdOfertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdOfertaActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        try {
            DataOferta ofera = new DataOferta();
            validarFormulario();
            ofera.setPuestos(Integer.parseInt(txtPuestos.getText()));
            ofera.setRequerimientos(txtReq.getText());
            ofera.setTitulo(txtTitulo.getText());
            ofera.setCargo(txtCargo.getText());
            ofera.setArea((DataArea)ComboArea.getSelectedItem());
            ofera.setEmpresa((DataEmpresa)ComboEmpresa.getSelectedItem());
            logicaOferta.getInstance().altaOferta(ofera);
            lblError.setText("Oferta Creada con exito");
        } catch (Exception e) {
            lblError.setText(e.getMessage());
        }


    }//GEN-LAST:event_BtnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(registroOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new registroOferta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnDesactivar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JComboBox ComboArea;
    private javax.swing.JComboBox ComboEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextArea txtCargo;
    private javax.swing.JTextField txtIdOferta;
    private javax.swing.JTextField txtPuestos;
    private javax.swing.JTextArea txtReq;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
