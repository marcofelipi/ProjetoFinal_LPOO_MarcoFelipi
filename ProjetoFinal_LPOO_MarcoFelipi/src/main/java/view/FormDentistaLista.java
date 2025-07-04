/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.PersistenciaJPA;
import model.Dentista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class FormDentistaLista extends javax.swing.JFrame {
    private final PersistenciaJPA dao;
    private List<Dentista> listaDentistas;
    private static final Logger logger = Logger.getLogger(FormDentistaLista.class.getName());    

    /**
     * Creates new form FormDentistaLista
     */
    public FormDentistaLista() {
        initComponents();
        dao = new PersistenciaJPA();
        atualizarTabela(); 
    }
    public void atualizarTabela() {
        // 1. Busca a lista de DENTISTAS no banco de dados
        listaDentistas = dao.getDentistas(); // <<< MUDOU

        // 2. Define as colunas da tabela para os dados do Dentista
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Nome", "CPF", "CRO", "Especialidade"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // 3. Adiciona cada dentista como uma linha na tabela
        if (listaDentistas != null) {
            for (Dentista d : listaDentistas) { // <<< MUDOU
                modelo.addRow(new Object[]{
                    d.getId(), 
                    d.getNome(), 
                    d.getCpf(), 
                    d.getCro(), 
                    d.getEspecialidade()
                }); // <<< MUDOU
            }
        }
        tblDentistas.setModel(modelo); // Assumindo que sua JTable se chama tblDentistas
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
        btnNovo = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDentistas = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Dentistas");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tblDentistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblDentistas);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnNovo)
                .addGap(8, 8, 8)
                .addComponent(btnAtualizar)
                .addGap(4, 4, 4)
                .addComponent(btnExcluir)
                .addGap(238, 238, 238)
                .addComponent(btnVoltar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo)
                    .addComponent(btnAtualizar)
                    .addComponent(btnExcluir)
                    .addComponent(btnVoltar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        new FormDentistaCriacaoAtualizacao(null, this).setVisible(true); // <<< MUDOU
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        int selectedRow = tblDentistas.getSelectedRow();
        if (selectedRow >= 0) {
            // Pega o DENTISTA da lista que corresponde à linha selecionada
            Dentista dentistaSelecionado = listaDentistas.get(selectedRow); // <<< MUDOU
            
            // Abre a tela de edição, passando o objeto DENTISTA selecionado
            new FormDentistaCriacaoAtualizacao(dentistaSelecionado, this).setVisible(true); // <<< MUDOU
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um dentista para editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int selectedRow = tblDentistas.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este dentista?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    // Pega o DENTISTA da lista e manda para o método de remoção do DAO
                    Dentista dentistaSelecionado = listaDentistas.get(selectedRow); // <<< MUDOU
                    dao.remover(dentistaSelecionado); // <<< MUDOU
                    
                    JOptionPane.showMessageDialog(this, "Dentista excluído com sucesso!");
                    atualizarTabela(); // Atualiza a tabela para remover a linha
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir o dentista: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    logger.log(Level.SEVERE, "Erro ao excluir dentista", e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um dentista para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormDentistaLista().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblDentistas;
    // End of variables declaration//GEN-END:variables
}
