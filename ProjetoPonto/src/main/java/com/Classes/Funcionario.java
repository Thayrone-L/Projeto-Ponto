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

    private Date admissao;
    private Date afast_data_fim;
    private Date afast_data_ini;
    private String afast_motivo;
    private String bairro;
    private boolean banco;
    private int banco_id;
    private String cat_cnh;
    private String cep;
    private String cidade;
    private String cnh;
    private String cpf;
    private Date demissao;
    private String departamento;
    private boolean digital;
    private String email;
    private int empresa_id;
    private String endereco;
    private String estado;
    private int folha;
    private String funcao;
    private int id;
    private int id_horario;
    private Date nascimento;
    private String nome;
    private String pis;
    private String telefone;
    private boolean web;
    private String web_email;
    private String web_nivel;
    private String web_senha;

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

                func.setAdmissao(rs.getDate("admissao"));
                func.setAfast_data_fim(rs.getDate("afast_data_fim"));
                func.setAfast_data_ini(rs.getDate("afast_data_ini"));
                func.setAfast_motivo(rs.getNString("afast_motivo"));
                func.setBairro(rs.getNString("bairro"));
                func.setBanco(rs.getBoolean("banco"));
                func.setCat_cnh(cat_cnh);
                func.setCep(cep);
                func.setCidade(cidade);
                func.setCnh(cnh);
                func.setCpf(cpf);
                func.setDemissao(demissao);
                func.setDepartamento(departamento);
                func.setDigital(digital);
                func.setEmail(email);
                func.setEmpresa_id(rs.getInt("empresa_id"));
                func.setEndereco(endereco);
                func.setEstado(estado);
                func.setFolha(Integer.parseInt(rs.getString("n_folha")));
                func.setFuncao(funcao);
                func.setId(rs.getInt("id"));
                func.setId_horario(id_horario);
                func.setNascimento(nascimento);
                func.setNome(rs.getString("nome"));
                func.setPis(rs.getString("n_pis"));
                func.setTelefone(telefone);
                func.setWeb(web);
                func.setWeb_email(web_email);
                func.setWeb_nivel(web_nivel);
                func.setWeb_senha(web_senha);
                ArrayFuncionario.add(func);
            }

            stm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na cconsulta", "Atenção!", JOptionPane.OK_OPTION);
            e.printStackTrace();
        }
        FecharConexao();

    }

    public Date getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    public Date getAfast_data_fim() {
        return afast_data_fim;
    }

    public void setAfast_data_fim(Date afast_data_fim) {
        this.afast_data_fim = afast_data_fim;
    }

    public Date getAfast_data_ini() {
        return afast_data_ini;
    }

    public void setAfast_data_ini(Date afast_data_ini) {
        this.afast_data_ini = afast_data_ini;
    }

    public String getAfast_motivo() {
        return afast_motivo;
    }

    public void setAfast_motivo(String afast_motivo) {
        this.afast_motivo = afast_motivo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public boolean isBanco() {
        return banco;
    }

    public void setBanco(boolean banco) {
        this.banco = banco;
    }

    public int getBanco_id() {
        return banco_id;
    }

    public void setBanco_id(int banco_id) {
        this.banco_id = banco_id;
    }
    
    

    public String getCat_cnh() {
        return cat_cnh;
    }

    public void setCat_cnh(String cat_cnh) {
        this.cat_cnh = cat_cnh;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDemissao() {
        return demissao;
    }

    public void setDemissao(Date demissao) {
        this.demissao = demissao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getFolha() {
        return folha;
    }

    public void setFolha(int folha) {
        this.folha = folha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
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

    public String getWeb_senha() {
        return web_senha;
    }

    public void setWeb_senha(String web_senha) {
        this.web_senha = web_senha;
    }

}
