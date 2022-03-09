/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Classes;

import static com.dados.conectaBanco.FecharConexao;
import static com.dados.conectaBanco.getConexaoMySQL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thayrone
 */
public class Funcionario {

    private int id;
    private String nome;
    private String pis;
    private int folha;
    private int empresa_id;
    private int id_horario;
    private Date admissao;
    private Date demissao;
    private String funcao;
    private String departamento;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String telefone;
    private String email;
    private String cpf;
    private String cnh;
    private String cat_cnh;
    private Date nascimento;
    private boolean banco;
    private Date afastamentos;
    private boolean web;
    private String web_senha;
    private String web_email;
    private String web_nivel;

    public int contarIdFuncionario() {

        ResultSet rs = null;
        String selectCountSql = "SELECT COUNT('id') FROM funcionarios WHERE demissao IS NULL ;";
        int count = 0;
        try {

            Statement stm = getConexaoMySQL().createStatement();

            rs = stm.executeQuery(selectCountSql);
            rs.next();
            count = rs.getInt(1);
            stm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na cconsulta", "Atenção!", JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        FecharConexao();

        return count;

    }

    public ArrayList<Funcionario> ArrayFuncionario = new ArrayList<>();

    public void listarFuncionarios() {

        ResultSet rs = null;
        String selectSql = "SELECT * FROM funcionarios WHERE demissao IS NULL ;";

        try {

            Statement stm = getConexaoMySQL().createStatement();

            rs = stm.executeQuery(selectSql);
            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setFolha(Integer.parseInt(rs.getString("n_folha")));
                func.setPis(rs.getString("n_pis"));

                ArrayFuncionario.add(func);
            }

            stm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na cconsulta", "Atenção!", JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        FecharConexao();

    }

    public void listarFuncionariosDemitidos() {

        ResultSet rs = null;
        String selectSql = "SELECT * FROM funcionarios WHERE demissao IS NOT NULL ;";

        try {

            Statement stm = getConexaoMySQL().createStatement();

            rs = stm.executeQuery(selectSql);
            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setId(rs.getInt("id"));
                func.setNome(rs.getString("nome"));
                func.setFolha(Integer.parseInt(rs.getString("n_folha")));
                func.setPis(rs.getString("n_pis"));
                func.setEmpresa_id(rs.getInt("empresa_id"));
                func.setAdmissao(admissao);
                func.setAfastamentos(afastamentos);
                func.setBairro(bairro);
                func.setBanco(banco);
                func.setCat_cnh(cat_cnh);
                func.setCep(cep);
                func.setCidade(cidade);
                func.setCnh(cnh);
                func.setCpf(cpf);
                func.setDemissao(demissao);
                func.setDepartamento(departamento);
                func.setEmail(email);
                func.setEndereco(endereco);
                func.setEstado(estado);
                func.setFuncao(funcao);
                func.setId_horario(id_horario);
                func.setNascimento(nascimento);
                ArrayFuncionario.add(func);
            }

            stm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na cconsulta", "Atenção!", JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        FecharConexao();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public int getFolha() {
        return folha;
    }

    public void setFolha(int folha) {
        this.folha = folha;
    }

    public int getId_empresa() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public Date getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    public Date getDemissao() {
        return demissao;
    }

    public void setDemissao(Date demissao) {
        this.demissao = demissao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCat_cnh() {
        return cat_cnh;
    }

    public void setCat_cnh(String cat_cnh) {
        this.cat_cnh = cat_cnh;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public boolean usaBanco() {
        return banco;
    }

    public void setBanco(boolean banco) {
        this.banco = banco;
    }

    public Date getAfastamentos() {
        return afastamentos;
    }

    public void setAfastamentos(Date afastamentos) {
        this.afastamentos = afastamentos;
    }

    public boolean usaWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
    }

    public String getWeb_senha() {
        return web_senha;
    }

    public void setWeb_senha(String web_senha) {
        this.web_senha = web_senha;
    }

    public String getWeb_email() {
        return web_email;
    }

    public void setWeb_email(String web_email) {
        this.web_email = web_email;
    }

    public String getWeb_nivel() {
        return web_nivel;
    }

    public void setWeb_nivel(String web_nivel) {
        this.web_nivel = web_nivel;
    }

}
