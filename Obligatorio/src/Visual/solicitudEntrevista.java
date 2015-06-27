/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import DataTypes.DataArea;
import DataTypes.DataAspirante;
import DataTypes.DataOferta;
import Logica.logicaAspirante;
import Logica.logicaOferta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estefanía
 */
public class solicitudEntrevista extends javax.swing.JFrame {

    /**
     * Creates new form solicitudEntrevista
     */
    public solicitudEntrevista() {
        initComponents();
        CargarAspirantes();
        iniciarBotones();
    }

    //Cargo la lista de Aspirantes
    private void CargarAspirantes() {
        try {
            ComboAspirante.removeAllItems();
            List<DataAspirante> lista = logicaAspirante.getInstance().ListarAspirantes();
            if (lista.isEmpty()) {
                throw new Exception("No hay Aspirantes ingresadas en el sistema.");
            } else {
                for (DataAspirante a : lista) {
                    ComboAspirante.addItem(a);
                }
            }
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }

    //Cargo la lista de Ofertas para el Aspirante
    private void CargarOfertas(DataAspirante a) throws Exception {
        try {
            ComboOfertas.removeAllItems();
            //Areas de interes del aspirante
            List<DataArea> areas = a.getAreasDeInteres();
            //Lista completa de Ofertas del sistema
            List<DataOferta> ofertas = logicaOferta.getInstance().listaOferta();
            if (ofertas.isEmpty()) {
                throw new Exception("No hay Ofertas ingresadas en el sistema.");
            } else {
                //Lista de Ofertas para Areas de interes del aspirante
                List<DataOferta> ofertasAspirante = new ArrayList<DataOferta>();
                for (DataOferta of : ofertas) {
                    for (DataArea ar : areas) {
                        if (of.getArea().getId() == ar.getId()) {
                            boolean agregar = true;
                            List<DataAspirante> aspirantesDeLaOferta = logicaOferta.getInstance().listarSolicitudesOferta(of.getId());
                            for (DataAspirante as : aspirantesDeLaOferta) {
                                if (as.getCedula().equals(a.getCedula())) {
                                    agregar = false;
                                }
                            }
                            if (agregar) {
                                ofertasAspirante.add(of);
                            }

                        }
                    }
                }
                if (ofertasAspirante.isEmpty()) {
                    throw new Exception("No hay Ofertas para las Areas de Interes del Aspirante.");
                } else {
                    for (DataOferta dof : ofertasAspirante) {
                        ComboOfertas.addItem(dof);
                    }
                }
            }
        } catch (Exception ex) {
            lblError.setText(ex.getMessage());
        }
    }

    private void validarFormulario() throws Exception {
        if (ComboAspirante.getSelectedItem() == null) {
            throw new Exception("Debe Seleccionar un Aspirante");
        }
        if (ComboOfertas.getSelectedItem() == null) {
            throw new Exception("Debe Seleccionar una Oferta");
        }
    }

    private void iniciarBotones() {
        //El boton esta en falso hasta que se seleccione candidato y oferta
        BtnSolicitud.setVisible(false);
        //Se limpian los datos al inicio que se cargaran con la oferta seleccionada
        TituloOferta.setText("");
        DescOferta.setText("");
        ReqOferta.setText("");
        EmpOferta.setText("");
        AreaOferta.setText("");
        PuestosOferta.setText("");
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
        ComboOfertas = new javax.swing.JComboBox();
        lblOfertas = new javax.swing.JLabel();
        lblAspirante = new javax.swing.JLabel();
        ComboAspirante = new javax.swing.JComboBox();
        PuestosOferta = new javax.swing.JLabel();
        lblTit = new javax.swing.JLabel();
        lblCarg = new javax.swing.JLabel();
        CargoOferta = new javax.swing.JLabel();
        lblReq = new javax.swing.JLabel();
        DescOferta = new javax.swing.JLabel();
        ReqOferta = new javax.swing.JLabel();
        lblPuestos = new javax.swing.JLabel();
        lblEmp = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        TituloOferta = new javax.swing.JLabel();
        EmpOferta = new javax.swing.JLabel();
        AreaOferta = new javax.swing.JLabel();
        BtnSolicitud = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Solicitar Entrevista - Candidato");

        ComboOfertas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboOfertasItemStateChanged(evt);
            }
        });

        lblOfertas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOfertas.setText("Ofertas:");

        lblAspirante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAspirante.setText("Aspirante:");

        ComboAspirante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboAspiranteItemStateChanged(evt);
            }
        });

        PuestosOferta.setBackground(new java.awt.Color(255, 255, 153));
        PuestosOferta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTit.setText("Titulo:");

        lblCarg.setText("Descripcion Cargo:");

        lblReq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReq.setText("Requerimientos:");

        DescOferta.setBackground(new java.awt.Color(255, 255, 153));
        DescOferta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ReqOferta.setBackground(new java.awt.Color(255, 255, 153));
        ReqOferta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblPuestos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPuestos.setText("Puestos:");

        lblEmp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmp.setText("Empresa:");

        lblArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArea.setText("Area:");

        TituloOferta.setBackground(new java.awt.Color(255, 255, 153));
        TituloOferta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        EmpOferta.setBackground(new java.awt.Color(255, 255, 153));
        EmpOferta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        AreaOferta.setBackground(new java.awt.Color(255, 255, 153));
        AreaOferta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BtnSolicitud.setText("Solicitar Entrevista");
        BtnSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSolicitudActionPerformed(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblOfertas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboAspirante, 0, 432, Short.MAX_VALUE)
                    .addComponent(ComboOfertas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(EmpOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AreaOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(PuestosOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCarg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblReq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(DescOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ReqOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TituloOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(CargoOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComboAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboOfertas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOfertas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CargoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TituloOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DescOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCarg, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ReqOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReq, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmpOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AreaOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPuestos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PuestosOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSolicitudActionPerformed
        //Registrar solicitud de entrevista del candidato para la oferta
        try {
            lblError.setText("");
            validarFormulario();
            DataAspirante das = (DataAspirante) (ComboAspirante.getSelectedItem());
            DataOferta dof = (DataOferta) (ComboOfertas.getSelectedItem());
            if (das == null) {
                throw new Exception("Debe Seleccionar un Aspirante");
            } else if (dof == null) {
                throw new Exception("Debe Seleccionar una Oferta");
            } else {
                //Verifico si el candidato ya tiene una solicitud activa
                for (DataAspirante as : dof.getAspirante()) {
                    if (as.equals(das)) {
                        throw new Exception("El Aspirante ya se encuentra registrado a esta Oferta");
                    }
                }
                //Realizo la solicitud de entrevista que sera aceptada o no por la empresa
                logicaOferta.getInstance().solicitarEntrevista(das, dof);
                lblError.setText("Solicitud de entrevista creada");
                lblError.setVisible(true);
                ComboOfertas.removeItem(dof);
            }
        } catch (Exception e) {
            lblError.setText(e.getMessage());
            iniciarBotones();
        }
    }//GEN-LAST:event_BtnSolicitudActionPerformed

    private void ComboAspiranteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboAspiranteItemStateChanged
        //Cuando seleccione un Aspirante
        try {
            lblError.setText("");
            DataAspirante das = (DataAspirante) (ComboAspirante.getSelectedItem());
            if (das == null) {
                lblError.setText("Debe Seleccionar un Aspirante");
            } else {
                CargarOfertas(das);
            }
        } catch (Exception e) {
            lblError.setText(e.getMessage());
            iniciarBotones();
        }
    }//GEN-LAST:event_ComboAspiranteItemStateChanged

    private void ComboOfertasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboOfertasItemStateChanged
        //Cuando selecciona una Oferta despliego sus datos y habilito el registro a Entrevista
        try {
            lblError.setText("");
            validarFormulario();
            DataAspirante das = (DataAspirante) (ComboAspirante.getSelectedItem());
            DataOferta dof = (DataOferta) (ComboOfertas.getSelectedItem());
            if (das == null) {
                throw new Exception("Debe Seleccionar un Aspirante");
            } else if (dof == null) {
                throw new Exception("Debe Seleccionar una Oferta");
            } else {
                TituloOferta.setText(dof.getTitulo());
                DescOferta.setText(dof.getCargo());
                ReqOferta.setText(dof.getRequerimientos());
                EmpOferta.setText(dof.getEmpresa().getNombre());
                AreaOferta.setText(dof.getArea().getDescripcion());
                PuestosOferta.setText(Integer.toString(dof.getPuestos()));
                //Verifico si el candidato ya tiene una solicitud activa
                for (DataAspirante as : dof.getAspirante()) {
                    if (as.equals(das)) {
                        throw new Exception("El Aspirante ya se encuentra registrado a esta Oferta");
                    }
                }
                BtnSolicitud.setVisible(true);
            }
        } catch (Exception e) {
            lblError.setText(e.getMessage());
            iniciarBotones();
        }
    }//GEN-LAST:event_ComboOfertasItemStateChanged

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
            java.util.logging.Logger.getLogger(solicitudEntrevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(solicitudEntrevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(solicitudEntrevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(solicitudEntrevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new solicitudEntrevista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AreaOferta;
    private javax.swing.JButton BtnSolicitud;
    private javax.swing.JLabel CargoOferta;
    private javax.swing.JComboBox ComboAspirante;
    private javax.swing.JComboBox ComboOfertas;
    private javax.swing.JLabel DescOferta;
    private javax.swing.JLabel EmpOferta;
    private javax.swing.JLabel PuestosOferta;
    private javax.swing.JLabel ReqOferta;
    private javax.swing.JLabel TituloOferta;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblAspirante;
    private javax.swing.JLabel lblCarg;
    private javax.swing.JLabel lblEmp;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblOfertas;
    private javax.swing.JLabel lblPuestos;
    private javax.swing.JLabel lblReq;
    private javax.swing.JLabel lblTit;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
