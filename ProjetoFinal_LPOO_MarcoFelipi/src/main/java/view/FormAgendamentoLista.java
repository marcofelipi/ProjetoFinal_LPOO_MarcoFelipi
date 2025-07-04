/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.PersistenciaJPA;
import model.Agendamento; // <<< IMPORTANTE: Mudou para Agendamento
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author marco
 */
public class FormAgendamentoLista extends javax.swing.JFrame {
    private final PersistenciaJPA dao;
    private List<Agendamento> listaAgendamentos; // <<< MUDOU: A lista agora é de Agendamentos
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormAgendamentoLista.class.getName());

    /**
     * Creates new form FormAgendamentoLista
     */
    public FormAgendamentoLista() {
        initComponents();
        dao = new PersistenciaJPA();
        atualizarTabela();
    }
    
    public void atualizarTabela() {
        // Busca a lista de AGENDAMENTOS no banco de dados
        listaAgendamentos = dao.getAgendamentos();

        // Define o formato da data e hora para ficar mais bonito na tabela
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Define as colunas da tabela
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Data/Hora", "Procedimento", "Paciente", "Dentista", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Adiciona cada agendamento como uma nova linha na tabela
        if (listaAgendamentos != null) {
            for (Agendamento a : listaAgendamentos) {
                modelo.addRow(new Object[]{
                    a.getId(),
                    a.getDataHora() != null ? a.getDataHora().format(formatter) : "N/D", // Formata a data
                    a.getTipoProcedimento(),
                    a.getPaciente().getNome(),  // <<< A MÁGICA ACONTECE AQUI: Pega o nome do Paciente associado
                    a.getDentista().getNome(),  // <<< E AQUI TAMBÉM: Pega o nome do Dentista associado
                    a.getStatus()
                });
            }
        }
        tblAgendamentos.setModel(modelo); // Usa a variável com o nome que corrigimos
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAgendamentos = new javax.swing.JTable();
        btnGerenciarProntuario = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Lista de Agendamentos");

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

        tblAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblAgendamentos);

        btnGerenciarProntuario.setText("Gerenciar Prontuário");
        btnGerenciarProntuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarProntuarioActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGerenciarProntuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnAtualizar)
                    .addComponent(btnExcluir)
                    .addComponent(btnGerenciarProntuario)
                    .addComponent(btnVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        new FormAgendamentoCriacaoAtualizacao(null, this).setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        int selectedRow = tblAgendamentos.getSelectedRow();
        if (selectedRow >= 0) {
            // Pega o Agendamento da lista com base na linha que o usuário clicou
            Agendamento agendamentoSelecionado = listaAgendamentos.get(selectedRow);
            // Abre a tela de edição, passando o objeto para ser editado
            new FormAgendamentoCriacaoAtualizacao(agendamentoSelecionado, this).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um agendamento para editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int selectedRow = tblAgendamentos.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este agendamento?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    dao.remover(listaAgendamentos.get(selectedRow));
                    JOptionPane.showMessageDialog(this, "Agendamento excluído com sucesso!");
                    atualizarTabela(); // Atualiza a tabela
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir o agendamento: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    logger.log(Level.SEVERE, "Erro ao excluir agendamento", e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um agendamento para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnGerenciarProntuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarProntuarioActionPerformed
        int selectedRow = tblAgendamentos.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um agendamento para gerenciar o prontuário.");
            return;
        }

        // Pega o agendamento da lista (que pode estar desatualizado)
        Agendamento agendamentoSelecionado = listaAgendamentos.get(selectedRow);

        try {
            // É uma boa prática re-buscar o objeto do banco para garantir que temos
            // a versão mais atual, incluindo o prontuário.
            Agendamento agendamentoCompleto = dao.find(Agendamento.class, agendamentoSelecionado.getId());

            // Abre a tela de prontuário, passando o agendamento completo
            new FormProntuario(agendamentoCompleto).setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar dados do agendamento.");
        }
    }//GEN-LAST:event_btnGerenciarProntuarioActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FormAgendamentoLista().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGerenciarProntuario;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblAgendamentos;
    // End of variables declaration//GEN-END:variables
}
