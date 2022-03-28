/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.telas;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.parg.viacep.ViaCEP;
import br.com.parg.viacep.ViaCEPException;
import com.Classes.Departamento;
import com.Classes.Empresa;
import com.Classes.Funcao;
import com.Classes.Funcionario;
import static com.Classes.Funcionario.ArrayFuncionario;
import com.Classes.Horario;
import java.awt.Color;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author thayrone
 */
public class telaCadFuncionarios extends javax.swing.JFrame {

    public int id_recebido;

    /**
     * Creates new form telaCadFuncionarios
     */
    public telaCadFuncionarios(int id_funcionario) {
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        initComponents();
        id_recebido = id_funcionario;
        preencheComboEmpresa();
        preencheComboHorario();
        preencheComboDepartamento();
        preencheComboFuncao();

        preenche();

    }

    private void preenche() {

        if (id_recebido != 0) {

            int index = Funcionario.localizaIdex(id_recebido);
            tbNome.setText(Funcionario.ArrayFuncionario.get(index).getNome());
            tbFolha.setText(Integer.toString(Funcionario.ArrayFuncionario.get(index).getFolha()));
            tbPis.setText(Funcionario.ArrayFuncionario.get(index).getPis());

            int empresaID = Funcionario.ArrayFuncionario.get(index).getEmpresa_id();
            int indexEmpresa = empresaID - 1;
            cbEmpresa.setSelectedIndex(indexEmpresa);

            int indexHorario = Horario.localizaIndexHorario(Funcionario.ArrayFuncionario.get(index).getId_horario());
            cbHorario.setSelectedIndex(indexHorario);

            int indexFuncao = Funcao.localizaIndexFuncao(Funcionario.ArrayFuncionario.get(index).getFuncao());
            cbFuncao.setSelectedIndex(indexFuncao);

            int indexDepartamento = Departamento.localizaIndexDepartamento(Funcionario.ArrayFuncionario.get(index).getDepartamento());
            cbDepartamento.setSelectedIndex(indexDepartamento);

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String AdmissaoFormatada = dateFormat.format(Funcionario.ArrayFuncionario.get(index).getAdmissao());
            tbAdmissao.setText(AdmissaoFormatada);

            if (Funcionario.ArrayFuncionario.get(index).getDemissao() != null) {
                String DemissaoFormatada = dateFormat.format(Funcionario.ArrayFuncionario.get(index).getDemissao());
                tbDemissao.setText(DemissaoFormatada);
            }

            tbTelefone.setText(Funcionario.ArrayFuncionario.get(index).getTelefone());
            try {
                CPFFormatter cpfFormat = new CPFFormatter();
                tbCpf.setText(cpfFormat.format(Funcionario.ArrayFuncionario.get(index).getCpf()));

            } catch (IllegalArgumentException e) {
                tbCpf.setText(Funcionario.ArrayFuncionario.get(index).getCpf());
            }

            try {
                String NascimentoFormatado = dateFormat.format(Funcionario.ArrayFuncionario.get(index).getNascimento());
                tbNascimento.setText(NascimentoFormatado);
            } catch (NullPointerException e) {

            }

            tbCnh.setText(Integer.toString(Funcionario.ArrayFuncionario.get(index).getCnh()));
            try {
                int iCat = 0;
                for (int i = 0; i < 27; i++) {
                    if (!cbCategoria.getItemAt(i).isEmpty()) {
                        if (cbCategoria.getItemAt(i).toString().equals(Funcionario.ArrayFuncionario.get(index).getCat_cnh())) {

                            iCat = i;
                        }
                    }
                }
                cbCategoria.setSelectedIndex(iCat);
            } catch (NullPointerException e) {

            }

        } else {
            tbDemissao.setEnabled(false);
        }

    }

    private void preencheComboEmpresa() {

        DefaultComboBoxModel modeloCEmpresa = new DefaultComboBoxModel(Empresa.ArrayNomesEmpresa.toArray());
        cbEmpresa.setModel(modeloCEmpresa);
    }

    private void preencheComboHorario() {

        DefaultComboBoxModel modeloCHorario = new DefaultComboBoxModel(Horario.ArrayNomesHorario.toArray());
        cbHorario.setModel(modeloCHorario);
    }

    private void preencheComboDepartamento() {

        DefaultComboBoxModel modeloCDepartamento = new DefaultComboBoxModel(Departamento.ArrayNomesDepartamento.toArray());
        cbDepartamento.setModel(modeloCDepartamento);
    }

    private void preencheComboFuncao() {

        DefaultComboBoxModel modeloCFuncao = new DefaultComboBoxModel(Funcao.ArrayNomesFuncao.toArray());
        cbFuncao.setModel(modeloCFuncao);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        painelPrincipal = new javax.swing.JPanel();
        painelDadosPrincipais = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        tbNome = new javax.swing.JTextField();
        lblFolha = new javax.swing.JLabel();
        tbFolha = new javax.swing.JTextField();
        lblPis = new javax.swing.JLabel();
        tbPis = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabPrincipal = new javax.swing.JPanel();
        lblHorario = new javax.swing.JLabel();
        lblFuncao = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        cbEmpresa = new javax.swing.JComboBox<>();
        cbHorario = new javax.swing.JComboBox<>();
        lblAdmissao = new javax.swing.JLabel();
        lblDemissao = new javax.swing.JLabel();
        tbAdmissao = new javax.swing.JFormattedTextField();
        tbDemissao = new javax.swing.JFormattedTextField();
        cbFuncao = new javax.swing.JComboBox<>();
        cbDepartamento = new javax.swing.JComboBox<>();
        lblDepartamento1 = new javax.swing.JLabel();
        cbCentroCusto = new javax.swing.JComboBox<>();
        tabAdicionais = new javax.swing.JPanel();
        lblEndereco = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblNascimento = new javax.swing.JLabel();
        lblCnh = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        tbEndereco = new javax.swing.JTextField();
        tbBairro = new javax.swing.JTextField();
        tbCidade = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox<>();
        tbCep = new javax.swing.JFormattedTextField();
        tbTelefone = new javax.swing.JFormattedTextField();
        tbCpf = new javax.swing.JFormattedTextField();
        tbNascimento = new javax.swing.JFormattedTextField();
        tbCnh = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox<>();
        btnBuscaCEP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tbNumero = new javax.swing.JTextField();
        tabBancoDeHoras = new javax.swing.JPanel();
        checkHabilitaBanco = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        lblDataInicio = new javax.swing.JLabel();
        tbDataInicio = new javax.swing.JFormattedTextField();
        lblDataFim = new javax.swing.JLabel();
        tbDataFim = new javax.swing.JFormattedTextField();
        lblCredito = new javax.swing.JLabel();
        cbCredito = new javax.swing.JComboBox<>();
        btnConfiguracaoEspecial = new javax.swing.JButton();
        lblDebito = new javax.swing.JLabel();
        cbDebito = new javax.swing.JComboBox<>();
        checkZerar = new javax.swing.JCheckBox();
        sPeriodoZerar = new javax.swing.JSpinner();
        lblMes = new javax.swing.JLabel();
        checkNaoDescontar = new javax.swing.JCheckBox();
        checkCopiar = new javax.swing.JCheckBox();
        cbCopiar = new javax.swing.JComboBox<>();
        tabAfastamentos = new javax.swing.JPanel();
        btnNovoAfastamento = new javax.swing.JButton();
        btnAlterarAfastamento = new javax.swing.JButton();
        btnExcluirAfastamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAfastamento = new javax.swing.JList<>();
        tabWeb = new javax.swing.JPanel();
        checkHabilitaWeb = new javax.swing.JCheckBox();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        tbEmail = new javax.swing.JTextField();
        lblNivel = new javax.swing.JLabel();
        cbNivelWeb = new javax.swing.JComboBox<>();
        tbSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelTitulo.setBackground(new java.awt.Color(0, 102, 153));

        lblTitulo.setBackground(new java.awt.Color(0, 102, 153));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cartão-de-identificação-64.png"))); // NOI18N
        lblTitulo.setText("Cadastro de funcionários");

        btnSalvar.setBackground(new java.awt.Color(0, 102, 153));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelTituloLayout = new javax.swing.GroupLayout(painelTitulo);
        painelTitulo.setLayout(painelTituloLayout);
        painelTituloLayout.setHorizontalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelTituloLayout.setVerticalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(painelTitulo, java.awt.BorderLayout.NORTH);

        painelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNome.setText("Nome:");
        lblNome.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        tbNome.setMaximumSize(new java.awt.Dimension(300, 22));
        tbNome.setMinimumSize(new java.awt.Dimension(300, 22));
        tbNome.setPreferredSize(new java.awt.Dimension(300, 22));
        tbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNomeActionPerformed(evt);
            }
        });

        lblFolha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFolha.setText("Nº Folha:");

        tbFolha.setMinimumSize(new java.awt.Dimension(300, 22));
        tbFolha.setPreferredSize(new java.awt.Dimension(300, 22));

        lblPis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPis.setText("Nº PIS:");

        tbPis.setMinimumSize(new java.awt.Dimension(300, 22));
        tbPis.setPreferredSize(new java.awt.Dimension(300, 22));
        tbPis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbPisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosPrincipaisLayout = new javax.swing.GroupLayout(painelDadosPrincipais);
        painelDadosPrincipais.setLayout(painelDadosPrincipaisLayout);
        painelDadosPrincipaisLayout.setHorizontalGroup(
            painelDadosPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPrincipaisLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(painelDadosPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblFolha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblPis))
                .addGap(24, 24, 24)
                .addGroup(painelDadosPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelDadosPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tbPis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addComponent(tbFolha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelDadosPrincipaisLayout.setVerticalGroup(
            painelDadosPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPrincipaisLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painelDadosPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDadosPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbFolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFolha))
                .addGap(18, 18, 18)
                .addGroup(painelDadosPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbPis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPis)))
        );

        painelPrincipal.add(painelDadosPrincipais, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 460, 150));

        getContentPane().add(painelPrincipal, java.awt.BorderLayout.CENTER);

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 153));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        lblHorario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHorario.setText("Horário:");
        lblHorario.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblFuncao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFuncao.setText("Função:");

        lblDepartamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDepartamento.setText("Departamento:");

        lblEmpresa.setText("Empresa:");

        cbEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblAdmissao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdmissao.setText("Admissão:");

        lblDemissao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDemissao.setText("Demissão");

        tbAdmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        tbAdmissao.setMaximumSize(new java.awt.Dimension(150, 22));
        tbAdmissao.setMinimumSize(new java.awt.Dimension(150, 22));
        tbAdmissao.setPreferredSize(new java.awt.Dimension(150, 22));

        tbDemissao.setMaximumSize(new java.awt.Dimension(150, 22));
        tbDemissao.setMinimumSize(new java.awt.Dimension(150, 22));
        tbDemissao.setPreferredSize(new java.awt.Dimension(150, 22));

        cbFuncao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFuncao.setMaximumSize(new java.awt.Dimension(250, 22));
        cbFuncao.setMinimumSize(new java.awt.Dimension(250, 22));
        cbFuncao.setPreferredSize(new java.awt.Dimension(250, 22));
        cbFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFuncaoActionPerformed(evt);
            }
        });

        cbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDepartamento.setMaximumSize(new java.awt.Dimension(250, 22));
        cbDepartamento.setMinimumSize(new java.awt.Dimension(250, 22));
        cbDepartamento.setPreferredSize(new java.awt.Dimension(250, 22));

        lblDepartamento1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDepartamento1.setText("Centro de Custo");

        cbCentroCusto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCentroCusto.setMaximumSize(new java.awt.Dimension(250, 22));
        cbCentroCusto.setMinimumSize(new java.awt.Dimension(250, 22));
        cbCentroCusto.setPreferredSize(new java.awt.Dimension(250, 22));

        javax.swing.GroupLayout tabPrincipalLayout = new javax.swing.GroupLayout(tabPrincipal);
        tabPrincipal.setLayout(tabPrincipalLayout);
        tabPrincipalLayout.setHorizontalGroup(
            tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabPrincipalLayout.createSequentialGroup()
                        .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblHorario)
                            .addComponent(lblEmpresa)
                            .addComponent(lblFuncao))
                        .addGap(30, 30, 30)
                        .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbHorario, javax.swing.GroupLayout.Alignment.TRAILING, 0, 414, Short.MAX_VALUE)
                            .addComponent(cbEmpresa, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbFuncao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabPrincipalLayout.createSequentialGroup()
                        .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabPrincipalLayout.createSequentialGroup()
                                .addComponent(lblDepartamento1)
                                .addGap(30, 30, 30)
                                .addComponent(cbCentroCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabPrincipalLayout.createSequentialGroup()
                                .addComponent(lblDepartamento)
                                .addGap(30, 30, 30)
                                .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabPrincipalLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblAdmissao)
                                    .addComponent(lblDemissao))
                                .addGap(30, 30, 30)
                                .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbAdmissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbDemissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(164, 164, 164)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        tabPrincipalLayout.setVerticalGroup(
            tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpresa)
                    .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncao)
                    .addComponent(cbFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartamento)
                    .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartamento1)
                    .addComponent(cbCentroCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdmissao)
                    .addComponent(tbAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDemissao)
                    .addComponent(tbDemissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Principal", tabPrincipal);

        tabAdicionais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblEndereco.setText("Endereço:");

        lblCidade.setText("Cidade:");

        lblBairro.setText("Bairro:");

        lblCep.setText("CEP:");

        lblEstado.setText("Estado:");

        lblTelefone.setText("Telefone:");

        lblCpf.setText("CPF:");

        lblNascimento.setText("Nascimento:");

        lblCnh.setText("CNH:");

        lblCategoria.setText("Categoria:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        try {
            tbCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "A", "B", "C", "D", "E", " " }));

        btnBuscaCEP.setText("Buscar enredeço");
        btnBuscaCEP.setBorder(null);
        btnBuscaCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaCEPActionPerformed(evt);
            }
        });

        jLabel1.setText("Nº");

        javax.swing.GroupLayout tabAdicionaisLayout = new javax.swing.GroupLayout(tabAdicionais);
        tabAdicionais.setLayout(tabAdicionaisLayout);
        tabAdicionaisLayout.setHorizontalGroup(
            tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAdicionaisLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCnh)
                    .addComponent(lblBairro)
                    .addComponent(lblCep)
                    .addComponent(lblTelefone)
                    .addComponent(lblCpf)
                    .addComponent(lblNascimento)
                    .addComponent(lblEndereco))
                .addGap(18, 18, 18)
                .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabAdicionaisLayout.createSequentialGroup()
                        .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabAdicionaisLayout.createSequentialGroup()
                                .addComponent(tbCep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscaCEP))
                            .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tbCpf, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tbNascimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tbTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabAdicionaisLayout.createSequentialGroup()
                                .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tbEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabAdicionaisLayout.createSequentialGroup()
                                        .addComponent(tbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblCidade)
                                        .addGap(18, 18, 18)
                                        .addComponent(tbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(tabAdicionaisLayout.createSequentialGroup()
                                        .addComponent(lblEstado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tabAdicionaisLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(tbNumero)))))
                        .addGap(9, 9, 9))
                    .addGroup(tabAdicionaisLayout.createSequentialGroup()
                        .addComponent(tbCnh, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCategoria)
                        .addGap(18, 18, 18)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(344, 344, 344))))
        );
        tabAdicionaisLayout.setVerticalGroup(
            tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAdicionaisLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(tbEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tbNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro)
                    .addComponent(lblCidade)
                    .addComponent(lblEstado)
                    .addComponent(tbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCep)
                    .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscaCEP)))
                .addGap(18, 18, 18)
                .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(tbTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(tbCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNascimento)
                    .addComponent(tbNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabAdicionaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCnh)
                    .addComponent(tbCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Dados Adicionais", tabAdicionais);

        tabBancoDeHoras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        checkHabilitaBanco.setText("Habilitar banco de horas");
        checkHabilitaBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHabilitaBancoActionPerformed(evt);
            }
        });

        jPanel1.setEnabled(false);

        lblDataInicio.setText("Data inicial:");

        tbDataInicio.setEnabled(false);
        tbDataInicio.setOpaque(true);

        lblDataFim.setText("Data final:");

        tbDataFim.setEnabled(false);

        lblCredito.setText("Totalizadores de credito:");

        cbCredito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas as horas extras.", "Somente a 1º feixa de extra", "Nenhuma hora extra", "Configuração especial" }));
        cbCredito.setEnabled(false);

        btnConfiguracaoEspecial.setText("Configurações especiais");
        btnConfiguracaoEspecial.setEnabled(false);

        lblDebito.setText("Totalizadores de debito:");

        cbDebito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas as horas faltosas", "Nenhuma hora faltosa" }));
        cbDebito.setEnabled(false);

        checkZerar.setText("Zerar saldo acumulado a cada");
        checkZerar.setEnabled(false);

        sPeriodoZerar.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        sPeriodoZerar.setEnabled(false);

        lblMes.setText("meses.");

        checkNaoDescontar.setText("Não descontar horas do banco em caso de FALTA.");
        checkNaoDescontar.setEnabled(false);

        checkCopiar.setText("Copiar configurações de:");
        checkCopiar.setEnabled(false);

        cbCopiar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Padrão", "Funcionario 1", "Funcionario 2", "Funcionario 3" }));
        cbCopiar.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDataInicio)
                        .addGap(18, 18, 18)
                        .addComponent(tbDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDataFim)
                        .addGap(18, 18, 18)
                        .addComponent(tbDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDebito)
                                .addGap(21, 21, 21)
                                .addComponent(cbDebito, 0, 1, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCredito)
                                .addGap(18, 18, 18)
                                .addComponent(cbCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnConfiguracaoEspecial))
                    .addComponent(checkNaoDescontar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkCopiar)
                        .addGap(18, 18, 18)
                        .addComponent(cbCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkZerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sPeriodoZerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMes)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataInicio)
                    .addComponent(tbDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataFim)
                    .addComponent(tbDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCredito)
                    .addComponent(cbCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfiguracaoEspecial))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDebito)
                    .addComponent(cbDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkZerar)
                    .addComponent(sPeriodoZerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMes))
                .addGap(18, 18, 18)
                .addComponent(checkNaoDescontar)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkCopiar)
                    .addComponent(cbCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabBancoDeHorasLayout = new javax.swing.GroupLayout(tabBancoDeHoras);
        tabBancoDeHoras.setLayout(tabBancoDeHorasLayout);
        tabBancoDeHorasLayout.setHorizontalGroup(
            tabBancoDeHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabBancoDeHorasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tabBancoDeHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkHabilitaBanco))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        tabBancoDeHorasLayout.setVerticalGroup(
            tabBancoDeHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabBancoDeHorasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(checkHabilitaBanco)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Banco de horas", tabBancoDeHoras);

        btnNovoAfastamento.setText("Novo");

        btnAlterarAfastamento.setText("Alterar");

        btnExcluirAfastamento.setText("Excluir");
        btnExcluirAfastamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAfastamentoActionPerformed(evt);
            }
        });

        listAfastamento.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listAfastamento);

        javax.swing.GroupLayout tabAfastamentosLayout = new javax.swing.GroupLayout(tabAfastamentos);
        tabAfastamentos.setLayout(tabAfastamentosLayout);
        tabAfastamentosLayout.setHorizontalGroup(
            tabAfastamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAfastamentosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tabAfastamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterarAfastamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoAfastamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirAfastamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        tabAfastamentosLayout.setVerticalGroup(
            tabAfastamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabAfastamentosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tabAfastamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabAfastamentosLayout.createSequentialGroup()
                        .addComponent(btnNovoAfastamento)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterarAfastamento)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirAfastamento)))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Afastamentos e Férias", tabAfastamentos);

        checkHabilitaWeb.setText("Habilitar ponto Web");
        checkHabilitaWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHabilitaWebActionPerformed(evt);
            }
        });

        lblEmail.setText("E-mail:");

        lblSenha.setText("Senha:");

        tbEmail.setEnabled(false);

        lblNivel.setText("Nivel de Permissão:");

        cbNivelWeb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNivelWeb.setEnabled(false);

        tbSenha.setEnabled(false);

        javax.swing.GroupLayout tabWebLayout = new javax.swing.GroupLayout(tabWeb);
        tabWeb.setLayout(tabWebLayout);
        tabWebLayout.setHorizontalGroup(
            tabWebLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabWebLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tabWebLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabWebLayout.createSequentialGroup()
                        .addGroup(tabWebLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmail)
                            .addComponent(lblSenha))
                        .addGap(18, 18, 18)
                        .addGroup(tabWebLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(checkHabilitaWeb)
                    .addGroup(tabWebLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblNivel)
                        .addGap(18, 18, 18)
                        .addComponent(cbNivelWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tabWebLayout.setVerticalGroup(
            tabWebLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabWebLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(checkHabilitaWeb)
                .addGap(18, 18, 18)
                .addGroup(tabWebLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(tbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(tabWebLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(tbSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabWebLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNivelWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNivel))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados Web", tabWeb);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbNomeActionPerformed

    private void tbPisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbPisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbPisActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if (id_recebido != 0) {
            int index = Funcionario.localizaIdex(id_recebido);

            Funcionario.ArrayFuncionario.get(index).setNome(tbNome.getText());

            Funcionario.ArrayFuncionario.get(index).setFolha(Integer.parseInt(tbFolha.getText()));

            Funcionario.ArrayFuncionario.get(index).setPis(tbPis.getText());

            Funcionario.ArrayFuncionario.get(index).setEmpresa_id(cbEmpresa.getSelectedIndex() + 1);

            Funcionario.ArrayFuncionario.get(index).setId_horario(cbHorario.getSelectedIndex());

            Funcionario.ArrayFuncionario.get(index).setFuncao(cbFuncao.getSelectedIndex());

            Funcionario.ArrayFuncionario.get(index).setDepartamento(cbDepartamento.getSelectedIndex() + 1);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                java.util.Date data = dateFormat.parse(tbAdmissao.getText());
                java.sql.Date dataSql = new java.sql.Date(data.getTime());
                Funcionario.ArrayFuncionario.get(index).setAdmissao(dataSql);
            } catch (ParseException ex) {
                Logger.getLogger(telaCadFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                java.util.Date data = dateFormat.parse(tbDemissao.getText());
                java.sql.Date dataSql = new java.sql.Date(data.getTime());
                Funcionario.ArrayFuncionario.get(index).setDemissao(dataSql);
            } catch (ParseException ex) {
                Logger.getLogger(telaCadFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }

            Funcionario.ArrayFuncionario.get(index).setEndereco(tbEndereco.getText() + ", nº " + tbNumero.getText());

            Funcionario.ArrayFuncionario.get(index).setBairro(tbBairro.getText());

            Funcionario.ArrayFuncionario.get(index).setCidade(tbCidade.getText());

            if (cbEstado.getItemAt(cbEstado.getSelectedIndex()).trim().equals("--")) {
                Funcionario.ArrayFuncionario.get(index).setEstado(null);
            } else {

                Funcionario.ArrayFuncionario.get(index).setEstado(cbEstado.getItemAt(cbEstado.getSelectedIndex()));
            }
            Funcionario.ArrayFuncionario.get(index).setCep(tbCep.getText());

            Funcionario.ArrayFuncionario.get(index).setTelefone(tbTelefone.getText());

            Funcionario.ArrayFuncionario.get(index).setCpf(tbCpf.getText());

            try {
                java.util.Date data = dateFormat.parse(tbNascimento.getText());
                java.sql.Date dataSql = new java.sql.Date(data.getTime());
                Funcionario.ArrayFuncionario.get(index).setNascimento(dataSql);
            } catch (ParseException ex) {
                Logger.getLogger(telaCadFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
            }

            Funcionario.ArrayFuncionario.get(index).setCnh(Integer.parseInt(tbCnh.getText()));

            if (cbCategoria.getItemAt(cbCategoria.getSelectedIndex()).trim().equals("--")) {
                Funcionario.ArrayFuncionario.get(index).setCat_cnh(null);
            } else {
                Funcionario.ArrayFuncionario.get(index).setCat_cnh(cbCategoria.getItemAt(cbCategoria.getSelectedIndex()));
            }

            Funcionario.ArrayFuncionario.get(index).setCat_cnh(cbCentroCusto.getItemAt(cbCentroCusto.getSelectedIndex()));

            if (checkHabilitaBanco.isSelected()) {
                Funcionario.ArrayFuncionario.get(index).setBanco(true);
            }

            if (checkHabilitaWeb.isSelected()) {
                Funcionario.ArrayFuncionario.get(index).setWeb(true);
                Funcionario.ArrayFuncionario.get(index).setWeb_email(tbEmail.getText());
                Funcionario.ArrayFuncionario.get(index).setWeb_nivel(cbNivelWeb.getItemAt(cbNivelWeb.getSelectedIndex()));
                String senha = new String(tbSenha.getPassword());
                Funcionario.ArrayFuncionario.get(index).setWeb_senha(senha);
            }

            Funcionario.atualizaFuncionario(Funcionario.ArrayFuncionario.get(index));

        } else {

            Funcionario novoFunc = new Funcionario();

            if (tbNome.getText() == null || tbNome.getText().trim().equals("")) {
                tbNome.setBorder(BorderFactory.createLineBorder(Color.red));
                showMessageDialog(null, "Insira o nome*");
                tbNome.requestFocus();
            } else {

                novoFunc.setNome(tbNome.getText());
            }

            if (tbFolha.getText() == null || tbFolha.getText().trim().equals("")) {
                tbFolha.setBorder(BorderFactory.createLineBorder(Color.red));
                showMessageDialog(null, "Insira o numero da folha*");
                tbFolha.requestFocus();
            } else {
                novoFunc.setFolha(Integer.parseInt(tbFolha.getText()));
            }
            if (tbPis.getText() == null || tbPis.getText().trim().equals("")) {
                tbPis.setBorder(BorderFactory.createLineBorder(Color.red));
                showMessageDialog(null, "Insira o numero do Pis*");
                tbPis.requestFocus();
            } else {
                novoFunc.setPis(tbPis.getText());
            }

            novoFunc.setEmpresa_id(cbEmpresa.getSelectedIndex() + 1);

            novoFunc.setId_horario(cbHorario.getSelectedIndex());

            novoFunc.setFuncao(cbFuncao.getSelectedIndex());

            novoFunc.setDepartamento(cbDepartamento.getSelectedIndex() + 1);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            if (tbAdmissao.getText() == null || tbAdmissao.getText().trim().equals("")) {
                tbAdmissao.setBorder(BorderFactory.createLineBorder(Color.red));
                showMessageDialog(null, "Insira o numero do Pis*");
                tbAdmissao.requestFocus();
            } else {

                try {
                    java.util.Date data = dateFormat.parse(tbAdmissao.getText());
                    java.sql.Date dataSql = new java.sql.Date(data.getTime());

                    novoFunc.setAdmissao(dataSql);
                } catch (ParseException ex) {
                    Logger.getLogger(telaCadFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            novoFunc.setDemissao(null);

            if (tbEndereco.getText().trim().equals("") || tbNumero.getText().trim().equals("")) {
                novoFunc.setEndereco(null);
            } else {
                novoFunc.setEndereco(tbEndereco.getText() + " nº " + tbNumero.getText());
            }
            if (tbBairro.getText().trim().equals("")) {
                novoFunc.setBairro(null);
            } else {
                novoFunc.setBairro(tbBairro.getText());
            }
            if (tbCidade.getText().trim().equals("")) {
                novoFunc.setCidade(null);
            } else {
                novoFunc.setCidade(tbCidade.getText());
            }

            if (cbEstado.getItemAt(cbEstado.getSelectedIndex()).trim().equals("--")) {
                novoFunc.setEstado(null);
            } else {
                novoFunc.setEstado(cbEstado.getItemAt(cbEstado.getSelectedIndex()));
            }
            if (tbCep.getText().trim().equals("-")) {
                novoFunc.setCep(null);
            } else {
                novoFunc.setCep(tbCep.getText());
            }
            if (tbTelefone.getText().trim().equals("")) {
                novoFunc.setTelefone(null);
            } else {
                novoFunc.setTelefone(tbTelefone.getText());
            }
            if (tbCpf.getText().trim().equals("")) {
                novoFunc.setCpf(null);
            } else {
                novoFunc.setCpf(tbCpf.getText());
            }
            if (tbNascimento.getText().trim().equals("")) {
                novoFunc.setNascimento(null);
            } else {
                try {
                    java.util.Date data = dateFormat.parse(tbNascimento.getText());
                    java.sql.Date dataSql = new java.sql.Date(data.getTime());
                    novoFunc.setNascimento(dataSql);
                } catch (ParseException ex) {
                    Logger.getLogger(telaCadFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (tbCnh.getText().trim().equals("")) {
                novoFunc.setCnh(0);
            } else {
                novoFunc.setCnh(Integer.parseInt(tbCnh.getText()));
            }

            if (cbCategoria.getItemAt(cbCategoria.getSelectedIndex()).trim().equals("--")) {
                novoFunc.setCat_cnh(null);
            } else {
                novoFunc.setCat_cnh(cbCategoria.getItemAt(cbCategoria.getSelectedIndex()));
            }
            if (checkHabilitaBanco.isSelected()) {
                novoFunc.setBanco(true);
            } else {
                novoFunc.setBanco(false);
            }

            if (checkHabilitaWeb.isSelected()) {
                novoFunc.setWeb(true);
                novoFunc.setWeb_email(tbEmail.getText());
                novoFunc.setWeb_nivel(cbNivelWeb.getItemAt(cbNivelWeb.getSelectedIndex()));
                String senha = new String(tbSenha.getPassword());
                novoFunc.setWeb_senha(senha);
            } else {
                novoFunc.setWeb(false);
                novoFunc.setWeb_email(null);
                novoFunc.setWeb_nivel(null);
                novoFunc.setWeb_senha(null);
            }

            ArrayFuncionario.add(novoFunc);

            Funcionario.salvaFuncionario(Funcionario.ArrayFuncionario.get(ArrayFuncionario.size() - 1));

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirAfastamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAfastamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirAfastamentoActionPerformed

    private void cbFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFuncaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFuncaoActionPerformed

    private void btnBuscaCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaCEPActionPerformed
        // TODO add your handling code here:
        if (tbCep.getText() == null || tbCep.getText().trim().equals("")) {

            tbCep.setBorder(BorderFactory.createLineBorder(Color.red));
            showMessageDialog(null, "Insira CEP válido");
            tbCep.requestFocus();

        } else {

            ViaCEP viacep = new ViaCEP();
            try {
                viacep.buscar(tbCep.getText());
                tbEndereco.setText(viacep.getLogradouro());
                tbBairro.setText(viacep.getBairro());
                tbCidade.setText(viacep.getLocalidade());
                int iEstado = 0;
                for (int i = 0; i < 27; i++) {
                    if (cbEstado.getItemAt(i).toString().equals(viacep.getUf())) {

                        iEstado = i;
                    }
                }
                cbEstado.setSelectedIndex(iEstado);

            } catch (ViaCEPException ex) {

            }
        }
    }//GEN-LAST:event_btnBuscaCEPActionPerformed

    private void checkHabilitaBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHabilitaBancoActionPerformed
        // TODO add your handling code here:
        if (checkHabilitaBanco.isSelected()) {
            jPanel1.setEnabled(true);

            tbDataInicio.setEnabled(true);
            tbDataInicio.setOpaque(false);
            tbDataFim.setEnabled(true);
            cbCredito.setEnabled(true);
            btnConfiguracaoEspecial.setEnabled(true);
            cbDebito.setEnabled(true);
            checkZerar.setEnabled(true);
            sPeriodoZerar.setEnabled(true);
            checkNaoDescontar.setEnabled(true);
            checkCopiar.setEnabled(true);
            cbCopiar.setEnabled(true);
        } else {

            jPanel1.setEnabled(false);
            tbDataInicio.setEnabled(false);
            tbDataInicio.setOpaque(true);
            tbDataFim.setEnabled(false);
            cbCredito.setEnabled(false);
            btnConfiguracaoEspecial.setEnabled(false);
            cbDebito.setEnabled(false);
            checkZerar.setEnabled(false);
            sPeriodoZerar.setEnabled(false);
            checkNaoDescontar.setEnabled(false);
            checkCopiar.setEnabled(false);
            cbCopiar.setEnabled(false);

        }

    }//GEN-LAST:event_checkHabilitaBancoActionPerformed

    private void checkHabilitaWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHabilitaWebActionPerformed
        // TODO add your handling code here:
        if (checkHabilitaWeb.isSelected()) {

            tbSenha.setEnabled(true);
            tbEmail.setEnabled(true);
            cbNivelWeb.setEnabled(true);

        } else {

            cbNivelWeb.setEnabled(false);
            tbSenha.setEnabled(false);
            tbEmail.setEnabled(false);

        }
    }//GEN-LAST:event_checkHabilitaWebActionPerformed

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
            java.util.logging.Logger.getLogger(telaCadFuncionarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCadFuncionarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCadFuncionarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCadFuncionarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCadFuncionarios(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarAfastamento;
    private javax.swing.JButton btnBuscaCEP;
    private javax.swing.JButton btnConfiguracaoEspecial;
    private javax.swing.JButton btnExcluirAfastamento;
    private javax.swing.JButton btnNovoAfastamento;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbCentroCusto;
    private javax.swing.JComboBox<String> cbCopiar;
    private javax.swing.JComboBox<String> cbCredito;
    private javax.swing.JComboBox<String> cbDebito;
    private javax.swing.JComboBox<String> cbDepartamento;
    private javax.swing.JComboBox<String> cbEmpresa;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbFuncao;
    private javax.swing.JComboBox<String> cbHorario;
    private javax.swing.JComboBox<String> cbNivelWeb;
    private javax.swing.JCheckBox checkCopiar;
    private javax.swing.JCheckBox checkHabilitaBanco;
    private javax.swing.JCheckBox checkHabilitaWeb;
    private javax.swing.JCheckBox checkNaoDescontar;
    private javax.swing.JCheckBox checkZerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAdmissao;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCnh;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblCredito;
    private javax.swing.JLabel lblDataFim;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblDebito;
    private javax.swing.JLabel lblDemissao;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDepartamento1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFolha;
    private javax.swing.JLabel lblFuncao;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPis;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> listAfastamento;
    private javax.swing.JPanel painelDadosPrincipais;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JSpinner sPeriodoZerar;
    private javax.swing.JPanel tabAdicionais;
    private javax.swing.JPanel tabAfastamentos;
    private javax.swing.JPanel tabBancoDeHoras;
    private javax.swing.JPanel tabPrincipal;
    private javax.swing.JPanel tabWeb;
    private javax.swing.JFormattedTextField tbAdmissao;
    private javax.swing.JTextField tbBairro;
    private javax.swing.JFormattedTextField tbCep;
    private javax.swing.JTextField tbCidade;
    private javax.swing.JTextField tbCnh;
    private javax.swing.JFormattedTextField tbCpf;
    private javax.swing.JFormattedTextField tbDataFim;
    private javax.swing.JFormattedTextField tbDataInicio;
    private javax.swing.JFormattedTextField tbDemissao;
    private javax.swing.JTextField tbEmail;
    private javax.swing.JTextField tbEndereco;
    private javax.swing.JTextField tbFolha;
    private javax.swing.JFormattedTextField tbNascimento;
    private javax.swing.JTextField tbNome;
    private javax.swing.JTextField tbNumero;
    private javax.swing.JTextField tbPis;
    private javax.swing.JPasswordField tbSenha;
    private javax.swing.JFormattedTextField tbTelefone;
    // End of variables declaration//GEN-END:variables
}
