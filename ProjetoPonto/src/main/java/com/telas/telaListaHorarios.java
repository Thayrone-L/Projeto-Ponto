/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.telas;

import com.Classes.Horario;
import static com.Classes.Horario.ArrayHorario;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thayrone
 */
public class telaListaHorarios extends javax.swing.JFrame {

    public int click = 0;

    /**
     * Creates new form telaListaHorarios
     */
    public telaListaHorarios() {
        setSize(750, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
        limpaTabela();
        preencheTabela();

    }

    public void preencheTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabelaHorarios.getModel();

        modelo.setNumRows(0);
        Horario func = new Horario();
        if (func.ArrayHorario.size() == 0) {
            func.listarHorarios();
        }
        for (int i = 0; i < func.ArrayHorario.size(); i++) {
            modelo.addRow(new Object[]{func.ArrayHorario.get(i).getNome()});
        }

    }

    public void limpaTabela() {

        DefaultTableModel model = (DefaultTableModel) tabelaHorarios.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
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

        painelTituloPagina = new javax.swing.JPanel();
        lblTituloPagina = new javax.swing.JLabel();
        pPrincipal = new javax.swing.JPanel();
        pBotoes = new javax.swing.JPanel();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDemitidos = new javax.swing.JButton();
        pTabela = new javax.swing.JScrollPane();
        tabelaHorarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        painelTituloPagina.setBackground(new java.awt.Color(0, 102, 153));

        lblTituloPagina.setBackground(new java.awt.Color(0, 102, 153));
        lblTituloPagina.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTituloPagina.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPagina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-hora-extra-64.png"))); // NOI18N
        lblTituloPagina.setText("Lista de Hor??rios");

        javax.swing.GroupLayout painelTituloPaginaLayout = new javax.swing.GroupLayout(painelTituloPagina);
        painelTituloPagina.setLayout(painelTituloPaginaLayout);
        painelTituloPaginaLayout.setHorizontalGroup(
            painelTituloPaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloPaginaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
        );
        painelTituloPaginaLayout.setVerticalGroup(
            painelTituloPaginaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloPaginaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(painelTituloPagina, java.awt.BorderLayout.NORTH);

        btnIncluir.setText("Incluir");
        btnIncluir.setPreferredSize(new java.awt.Dimension(100, 22));
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDemitidos.setText("Excluir");
        btnDemitidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemitidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pBotoesLayout = new javax.swing.GroupLayout(pBotoes);
        pBotoes.setLayout(pBotoesLayout);
        pBotoesLayout.setHorizontalGroup(
            pBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBotoesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDemitidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        pBotoesLayout.setVerticalGroup(
            pBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBotoesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnAlterar)
                .addGap(18, 18, 18)
                .addComponent(btnDemitidos)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        pTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pTabelaMouseClicked(evt);
            }
        });

        tabelaHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaHorariosMouseClicked(evt);
            }
        });
        pTabela.setViewportView(tabelaHorarios);
        if (tabelaHorarios.getColumnModel().getColumnCount() > 0) {
            tabelaHorarios.getColumnModel().getColumn(0).setResizable(false);
            tabelaHorarios.getColumnModel().getColumn(0).setPreferredWidth(320);
        }

        javax.swing.GroupLayout pPrincipalLayout = new javax.swing.GroupLayout(pPrincipal);
        pPrincipal.setLayout(pPrincipalLayout);
        pPrincipalLayout.setHorizontalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addComponent(pBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );
        pPrincipalLayout.setVerticalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(pPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDemitidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemitidosActionPerformed
        // TODO add your handling code here:
        telaListaDemitidos listaDemitidos = new telaListaDemitidos();
        listaDemitidos.setVisible(true);
    }//GEN-LAST:event_btnDemitidosActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        // TODO add your handling code here:
        telaCadHorarios telacad = new telaCadHorarios();
        telacad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void pTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pTabelaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_pTabelaMouseClicked

    private void tabelaHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaHorariosMouseClicked
        // TODO add your handling code here:
        if (click < 1) {

            click++;

        } else {

        }
    }//GEN-LAST:event_tabelaHorariosMouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        limpaTabela();
        preencheTabela();
    }//GEN-LAST:event_formFocusGained

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
            java.util.logging.Logger.getLogger(telaListaHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaListaHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaListaHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaListaHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaListaHorarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDemitidos;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JLabel lblTituloPagina;
    private javax.swing.JPanel pBotoes;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JScrollPane pTabela;
    private javax.swing.JPanel painelTituloPagina;
    private javax.swing.JTable tabelaHorarios;
    // End of variables declaration//GEN-END:variables

    public JTable getTabelaHorarios() {
        return tabelaHorarios;
    }

    public void setTabelaHorarios(JTable tabelaHorarios) {
        this.tabelaHorarios = tabelaHorarios;
    }

}
