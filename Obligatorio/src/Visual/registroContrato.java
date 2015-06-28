/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import DataTypes.DataContrato;
import DataTypes.DataEmpresa;
import DataTypes.DataEntrevista;
import Logica.logicaContrato;
import Logica.logicaEmpresa;
import Logica.logicaEntrevista;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Estefanía
 */
public class registroContrato extends javax.swing.JFrame {

    /**
     * Creates new form registroContrato
     */
    public registroContrato() {
        initComponents();
        CargarEmpresas();
        FormularioDefecto();
    }

    //Cargo la lista de Empresas en el combo
    private void CargarEmpresas() {
        try {
            lblError.setText("");
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

    private void FormularioDefecto() {
        //Dejo todo como no visible hasta que se vayan seleccionando los datos
        listEntrevistas.setVisible(false);
        lblAs.setVisible(false);
        lblOf.setVisible(false);
        lblTip.setVisible(false);
        lblSdo.setVisible(false);
        lblIni.setVisible(false);
        txtAspirante.setVisible(false);
        txtOferta.setVisible(false);
        txtSueldo.setVisible(false);
        ComboTipo.setVisible(false);
        calInicio.setVisible(false);
        btnAlta.setVisible(false);
        btnBaja.setVisible(false);
        btnLimpiar.setVisible(false);
    }

    private void SelectEmpresa(DataEmpresa em) throws Exception {
        try {
            lblError.setText("");
            //Cuando selecciono la empresa habilito la lista de Ofertas y la cargo
            List<DataEntrevista> entrevistas = logicaEntrevista.getInstance().listaEntrevistasEmpresa(em);
            if (entrevistas.isEmpty()) {
                throw new Exception("No hay Entrevistas realizadas para la Empresa seleccionada.");
            } else {
                DefaultListModel modelEntrevista = new DefaultListModel();
                for (DataEntrevista e : entrevistas) {
                    modelEntrevista.addElement(e);
                }
                listEntrevistas.setVisible(true);
                listEntrevistas.setModel(modelEntrevista);
            }
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }

    private void SelectEntrevista(DataEntrevista en) throws Exception {
        try {
            //Cuando selecciona una entrevista habilito el resto de los botones y controles        
            lblAs.setVisible(true);
            lblOf.setVisible(true);
            lblTip.setVisible(true);
            lblSdo.setVisible(true);
            lblIni.setVisible(true);
            txtAspirante.setText(en.getAspirante().toString());
            txtAspirante.setVisible(true);
            txtOferta.setText(en.getOferta().toString());
            txtOferta.setVisible(true);
            txtSueldo.setVisible(true);
            //Cargo el combo de tipos de contratos
            ComboTipo.addItem("Efectivo");
            ComboTipo.addItem("Termino");
            ComboTipo.setVisible(true);
            //Seteo como fecha por defecto la fecha de hoy
            Date actual = new Date();
            calInicio.setDate(actual);
            calInicio.setVisible(true);
            btnAlta.setVisible(true);
            btnBaja.setVisible(true);
            btnLimpiar.setVisible(true);
        } catch (Exception e) {
            lblError.setText(e.getMessage());
        }
    }

    private void ValidarForm() throws Exception {
        if (listEntrevistas.getSelectedValue() == null) {
            throw new Exception("Debe seleccionar una entrevista");
        }
        if (ComboTipo.getSelectedItem() == null) {
            throw new Exception("Debe seleccionar un tipo de Entrevista");
        }
        if (txtSueldo.getText().isEmpty()) {
            throw new Exception("Debe ingresar un Sueldo");
        }
        if (calInicio.getDate() == null) {
            throw new Exception("Debe Seleccionar una fecha de inicio");
        }
        Date actual = new Date();
        if (calInicio.getDate().before(actual)) {
            throw new Exception("La fecha de Inicio no puede ser anterior a hoy");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEntrevistas = new javax.swing.JList();
        ComboEmpresa = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnAlta = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        lblAs = new javax.swing.JLabel();
        lblOf = new javax.swing.JLabel();
        lblTip = new javax.swing.JLabel();
        lblSdo = new javax.swing.JLabel();
        lblIni = new javax.swing.JLabel();
        txtAspirante = new javax.swing.JTextField();
        txtOferta = new javax.swing.JTextField();
        ComboTipo = new javax.swing.JComboBox();
        txtSueldo = new javax.swing.JTextField();
        calInicio = new com.toedter.calendar.JDateChooser();
        btnBaja = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registro de Contrato");

        listEntrevistas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listEntrevistas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listEntrevistasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listEntrevistas);

        ComboEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboEmpresaItemStateChanged(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Empresa:");

        btnAlta.setText("Alta Contrato");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar Pantalla");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lblAs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAs.setText("Aspirante:");

        lblOf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOf.setText("Oferta:");

        lblTip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTip.setText("Tipo:");

        lblSdo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSdo.setText("Sueldo:");

        lblIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIni.setText("Inicio:");

        txtAspirante.setEnabled(false);

        txtOferta.setEnabled(false);

        btnBaja.setText("Remover de Lista");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblOf, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtOferta))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblAs, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(lblIni, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(calInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(lblSdo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSueldo))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(lblTip, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTip, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSdo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIni, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAlta)
                            .addComponent(btnBaja))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboEmpresaItemStateChanged
        // Cuando selecciona una empresa cargo la lista de Entrevistas
        try {
            lblError.setText("");
            DataEmpresa emp = (DataEmpresa) ComboEmpresa.getSelectedItem();
            if (emp == null) {
                throw new Exception("Debe Seleccionar una Empresa");
            }
            //Si tengo empresa seleccionada entonces llamo al metodo para cargar la lista de ofertas
            this.SelectEmpresa(emp);
        } catch (Exception e) {
            lblError.setText(e.getMessage());
        }
    }//GEN-LAST:event_ComboEmpresaItemStateChanged

    private void listEntrevistasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listEntrevistasValueChanged
        // Cuando selecciona una entrevista cargo el resto del formulario
        try {
            lblError.setText("");
            DataEntrevista ent = (DataEntrevista) listEntrevistas.getSelectedValue();
            if (ent == null) {
                throw new Exception("Debe Seleccionar una Entrevista");
            }
            //Si tengo entrevista seleccionada entonces cargo el resto del formuario
            this.SelectEntrevista(ent);
        } catch (Exception e) {            
            lblError.setText(e.getMessage());
        }
    }//GEN-LAST:event_listEntrevistasValueChanged

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        try {
            lblError.setText("");            
            this.FormularioDefecto();
        } catch (Exception e) {            
            lblError.setText(e.getMessage());
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        try {
            lblError.setText("");
            DataEntrevista en = (DataEntrevista)listEntrevistas.getSelectedValue();
            logicaEntrevista.getInstance().removerEntrevista(en);            
            lblError.setText("La Entrevista se ha quitado de la lista con Exito");
            this.FormularioDefecto();
        } catch (Exception e) {            
            lblError.setText(e.getMessage());
        }
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        try {
            lblError.setText("");
            //Lo primero que hago es validar que todo este cargado
            this.ValidarForm();
            //Verifico que el sueldo seleccionado sea un numero mayor a cero
            double sueldo = Double.parseDouble(txtSueldo.getText());
            if(sueldo<=0){
                throw new Exception("El sueldo debe ser mayor a cero");
            }
            //construyo la fecha inicio, el tipo y la fecha fin para crear el contrato
            Date inicio = calInicio.getDate();
            Date fin = new Date();
            String tipo = ComboTipo.getSelectedItem().toString();
            if(tipo=="Termino"){
                //Si es a termino seteo la fecha fin agregando tres meses a la de inicio
                Calendar ini = Calendar.getInstance();
                ini.setTime(inicio);
                Calendar f = Calendar.getInstance();
                f.setTime(inicio);
                f.add(Calendar.MONTH, 3);
                fin = f.getTime();
            }
            if(tipo=="Efectivo"){
                //Si es efectivo la fecha de fin es null                
                fin = null;
            }
            DataContrato dc = new DataContrato();
            dc.setEntrev((DataEntrevista)listEntrevistas.getSelectedValue());
            dc.setFechaCaducidad(fin);
            dc.setFechaInicio(inicio);
            dc.setSueldo(sueldo);
            dc.setTipoContrato(tipo);
            logicaContrato.getInstance().altaContrato(dc);
            this.FormularioDefecto();
            lblError.setText("Contrato dado de alta con Exito");                    
        } catch (Exception e) {            
            lblError.setText(e.getMessage());
        }
    }//GEN-LAST:event_btnAltaActionPerformed

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
            java.util.logging.Logger.getLogger(registroContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroContrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroContrato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboEmpresa;
    private javax.swing.JComboBox ComboTipo;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnLimpiar;
    private com.toedter.calendar.JDateChooser calInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAs;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblIni;
    private javax.swing.JLabel lblOf;
    private javax.swing.JLabel lblSdo;
    private javax.swing.JLabel lblTip;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList listEntrevistas;
    private javax.swing.JTextField txtAspirante;
    private javax.swing.JTextField txtOferta;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
