/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Classes;

import static com.dados.conectaBanco.FecharConexao;
import static com.dados.conectaBanco.getConexaoMySQL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author thayrone
 */
public class Funcionario {

    private Date admissao;
    private String bairro;
    private boolean banco;
    private int banco_id;
    private String cat_cnh;
    private String cep;
    private String cidade;
    private int cnh;
    private String cpf;
    private Date demissao;
    private int departamento;
    private boolean digital;
    private int empresa_id;
    private String endereco;
    private String estado;
    private int folha;
    private int funcao;
    private int id;
    private int id_horario;
    private Date nascimento;
    private int n_residencial;
    private String nome;
    private int pis;
    private String telefone;
    private boolean web;
    private String web_email;
    private String web_nivel;
    private String web_senha;

    public static int localizaIdex(int id_funcionario) {
        int index = 0;
        int i = 0;
        Iterator<Funcionario> iterator = ArrayFuncionario.iterator();
        while (iterator.hasNext()) {
            try {
                if (ArrayFuncionario.get(i).getId() == id_funcionario) {

                    index = i;
                }

                i++;
            } catch (IndexOutOfBoundsException e) {

                return index;
            }
        }
        return index;
    }

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
            System.out.println("3");
            e.printStackTrace();
        }
        FecharConexao();

        return count;

    }

    public static ArrayList<Funcionario> ArrayFuncionario = new ArrayList<>();

    public static void atualizaFuncionario(Funcionario func) {

        int digital;
        if (func.isDigital()) {
            digital = 1;
        } else {
            digital = 0;
        }
        int banco;
        if (func.isBanco()) {
            banco = 1;
        } else {
            banco = 0;
        }
        int web;
        if (func.isWeb()) {
            web = 1;
        } else {
            web = 0;
        }
        int webNivel;
        if (func.getWeb_nivel() == null) {
            webNivel = 0;
        } else {
            webNivel = Integer.parseInt(func.getWeb_nivel());
        }

        String updateSql = "UPDATE `funcionarios` SET "
                + " `n_folha` = '" + func.getFolha()
                + "', `nome` = '" + func.getNome()
                + "', `empresa_id` = '" + func.getEmpresa_id()
                + "', `id_horario` = '" + func.getId_horario()
                + "', `funcao_id` = '" + func.getFuncao()
                + "', `departamento_id` = '" + func.getDepartamento()
                + "', `admissao` = '" + func.getAdmissao()
                + "', `digital` = '" + digital
                + "', `endereco` = '" + func.getEndereco()
                + "', `bairro` = '" + func.getBairro()
                + "', `cidade` = '" + func.getCidade()
                + "', `uf` = '" + func.getEstado()
                + "', `cep` = '" + func.getCep()
                + "', `telefone` = '" + func.getTelefone()
                + "', `cpf` = '" + func.getCpf()
                + "', `web_senha` = '" + func.getWeb_senha()
                + "', `banco` = '" + banco
                + "', `n_pis` = '" + func.getPis()
                + "', `banco_id` = '" + func.getBanco_id()
                + "', `cnh` = '" + func.getCnh()
                + "', `cat_cnh` = '" + func.getCat_cnh()
                + "', `web` = '" + web
                + "', `web_email` = '" + func.getWeb_email()
                + "', `web_nivel` = '" + webNivel
                + "' WHERE `funcionarios`.`id` =" + func.getId() + ";";

        try {

            PreparedStatement stm = getConexaoMySQL().prepareStatement(updateSql);

            System.out.println(updateSql);

            stm.executeUpdate(updateSql);

            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Salvo!", JOptionPane.OK_OPTION);
        } catch (SQLException e) {
            System.out.println("4");
            e.printStackTrace();
        }
        FecharConexao();

    }

    public static void salvaFuncionario(Funcionario func) {

        ResultSet rs = null;
        String selectCountSql = "SELECT COUNT('id') FROM funcionarios ;";
        int count = 0;
        try {

            Statement stm = getConexaoMySQL().createStatement();

            rs = stm.executeQuery(selectCountSql);
            rs.next();
            count = rs.getInt(1);
            stm.close();

        } catch (SQLException e) {
            System.out.println("5");
            e.printStackTrace();
        }
        FecharConexao();

        int total = count;

        int id = total + 1;
        System.out.println(id);
        int digital;
        if (func.isDigital()) {
            digital = 1;
        } else {
            digital = 0;
        }
        int banco;
        if (func.isBanco()) {
            banco = 1;
        } else {
            banco = 0;
        }
        int web;
        if (func.isWeb()) {
            web = 1;
        } else {
            web = 0;
        }
        int webNivel;
        if (func.getWeb_nivel() == null) {
            webNivel = 0;
        } else {
            webNivel = Integer.parseInt(func.getWeb_nivel());
        }
        String demissao;
        if (func.getDemissao() == null) {

            demissao = null;
        } else {
            demissao = "'" + func.getDemissao() + "'";
        }
        String nascimento;
        if (func.getNascimento() == null) {

            nascimento = null;
        } else {
            nascimento = "'" + func.getNascimento() + "'";
        }

        System.out.println(func.getFuncao());
        String InsertSql = "INSERT INTO `funcionarios` VALUES ("
                + id
                + ", " + func.getFolha()
                + ", '" + func.getNome() + "'"
                + ", " + func.getEmpresa_id()
                + ", " + func.getId_horario()
                + ", " + func.getFuncao()
                + ", " + func.getDepartamento()
                + ", '" + func.getAdmissao() + "'"
                + ", " + demissao
                + ", " + digital
                + ", " + func.getEndereco()
                + ", " + func.getBairro()
                + ", " + func.getCidade()
                + ", " + func.getEstado()
                + ", " + func.getCep()
                + ", " + func.getTelefone()
                + ", " + func.getCpf()
                + ", " + func.getNascimento()
                + ", " + func.getWeb_senha()
                + ", " + banco
                + ", " + func.getPis()
                + ", " + func.getBanco_id()
                + ", " + func.getCnh()
                + ", " + func.getCat_cnh()
                + ", " + web
                + ", " + func.getWeb_email()
                + ", " + webNivel
                + ");";

        try {

            PreparedStatement stm = getConexaoMySQL().prepareStatement(InsertSql);

            System.out.println(InsertSql);

            stm.executeUpdate(InsertSql);

            JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Salvo!", JOptionPane.OK_OPTION);
        } catch (SQLException e) {
            System.out.println("6");
            e.printStackTrace();
        }
        FecharConexao();

    }

    public void listarFuncionarios() {

        ResultSet rs = null;
        String selectSql = "SELECT * FROM funcionarios ;";

        try {

            Statement stm = getConexaoMySQL().createStatement();

            rs = stm.executeQuery(selectSql);
            while (rs.next()) {
                Funcionario func = new Funcionario();
                func.setAdmissao(rs.getDate("admissao"));
                func.setBairro(rs.getString("bairro"));
                func.setBanco(rs.getBoolean("banco"));
                func.setBanco_id(rs.getInt("banco_id"));
                func.setCat_cnh(rs.getString("cat_cnh"));
                func.setCep(rs.getString("cep"));
                func.setCidade(rs.getString("cidade"));
                func.setCnh(rs.getInt("cnh"));
                func.setCpf(rs.getString("cpf"));
                func.setDemissao(rs.getDate("demissao"));
                func.setDepartamento(rs.getInt("departamento_id"));
                func.setDigital(rs.getBoolean("digital"));
                func.setEmpresa_id(rs.getInt("empresa_id"));
                func.setEndereco(rs.getString("endereco"));
                func.setEstado(rs.getString("uf"));
                func.setFolha(Integer.parseInt(rs.getString("n_folha")));
                func.setFuncao(rs.getInt("funcao_id"));
                func.setId(rs.getInt("id"));
                func.setId_horario(rs.getInt("id_horario"));
                func.setNascimento(rs.getDate("nascimento"));
                func.setNome(rs.getString("nome"));
                func.setPis(rs.getInt("n_pis"));
                func.setTelefone(rs.getNString("telefone"));
                func.setWeb(rs.getBoolean("web"));
                func.setWeb_email(rs.getString("web_email"));
                func.setWeb_nivel(rs.getString("web_nivel"));
                func.setWeb_senha(rs.getString("web_senha"));

                ArrayFuncionario.add(func);
            }

            stm.close();

        } catch (SQLException e) {
            System.out.println("7");
            e.printStackTrace();
        }
        FecharConexao();

    }

    public boolean consultaPis(int pis) {
        for (int i = 0; i <= ArrayFuncionario.size(); i++) {
            if (ArrayFuncionario.get(i).getPis() == pis) {
                return true;
            }
        }
        return false;
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
                func.setBairro(rs.getString("bairro"));
                func.setBanco(rs.getBoolean("banco"));
                func.setBanco_id(rs.getInt("banco_id"));
                func.setCat_cnh(rs.getString("cat_cnh"));
                func.setCep(rs.getString("cep"));
                func.setCidade(rs.getString("cidade"));
                func.setCnh(rs.getInt("cnh"));
                func.setCpf(rs.getString("cpf"));
                func.setDemissao(rs.getDate("demissao"));
                func.setDepartamento(rs.getInt("departamento"));
                func.setDigital(rs.getBoolean("digital"));
                func.setEmpresa_id(rs.getInt("empresa_id"));
                func.setEndereco(rs.getString("endereco"));
                func.setEstado(rs.getString("uf"));
                func.setFolha(Integer.parseInt(rs.getString("n_folha")));
                func.setFuncao(rs.getInt("funcao"));
                func.setId(rs.getInt("id"));
                func.setId_horario(rs.getInt("id_horario"));
                func.setNascimento(rs.getDate("nascimento"));
                func.setNome(rs.getString("nome"));
                func.setPis(rs.getInt("n_pis"));
                func.setTelefone(rs.getNString("telefone"));
                func.setWeb(rs.getBoolean("web"));
                func.setWeb_email(rs.getString("web_email"));
                func.setWeb_nivel(rs.getString("web_nivel"));
                func.setWeb_senha(rs.getString("web_senha"));
                ArrayFuncionario.add(func);
            }

            stm.close();

        } catch (SQLException e) {
            System.out.println("8");
            e.printStackTrace();
        }
        FecharConexao();

    }

    public void imprimirFuncionario() {

        System.out.println(""
                + " / " + this.getAdmissao()
                + " / " + this.getBairro()
                + " / " + this.isBanco()
                + " / " + this.getBanco_id()
                + " / " + this.getCat_cnh()
                + " / " + this.getCep()
                + " / " + this.getCidade()
                + " / " + this.getCnh()
                + " / " + this.getCpf()
                + " / " + this.getDemissao()
                + " / " + this.getDepartamento()
                + " / " + this.isDigital()
                + " / " + this.getEmpresa_id()
                + " / " + this.getEndereco()
                + " / " + this.getEstado()
                + " / " + this.getFolha()
                + " / " + this.getFuncao()
                + " / " + this.getId()
                + " / " + this.getId_horario()
                + " / " + this.getNascimento()
                + " / " + this.getNome()
                + " / " + this.getPis()
                + " / " + this.getTelefone()
                + " / " + this.isWeb()
                + " / " + this.getWeb_email()
                + " / " + this.getWeb_nivel()
                + " / " + this.getWeb_senha()
        );

    }

    public Date getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
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

    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
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

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
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

    public int getFuncao() {
        return funcao;
    }

    public void setFuncao(int funcao) {
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

    public int getN_residencial() {
        return n_residencial;
    }

    public void setN_residencial(int n_residencial) {
        this.n_residencial = n_residencial;
    }

    public int getPis() {
        return pis;
    }

    public void setPis(int pis) {
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
