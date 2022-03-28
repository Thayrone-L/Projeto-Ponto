/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Classes;

import static com.dados.conectaBanco.FecharConexao;
import static com.dados.conectaBanco.getConexaoMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thayrone
 */
public class Funcao {

    private int id;
    private String nome;

    public static ArrayList<Funcao> ArrayFuncao = new ArrayList<>();
    public static List<String> ArrayNomesFuncao = new ArrayList<String>();

    public static int localizaIndexFuncao(int id_funcao) {
        int i = 0;
        int index = 0;
        for (Funcao func : ArrayFuncao) {
            if (func.id == id_funcao) {

                index = i;
            }

            i++;
        }

        return index;
    }

    public static void listarFuncoes() {
        ResultSet rs = null;
        String selectSql = "SELECT * FROM funcoes;";
        try {
            Statement stm = getConexaoMySQL().createStatement();
            rs = stm.executeQuery(selectSql);
            while (rs.next()) {
                Funcao fun = new Funcao();
                fun.setId(rs.getInt("id"));
                fun.setNome(rs.getString("descricao"));
                ArrayNomesFuncao.add(fun.getNome());
                ArrayFuncao.add(fun);
            }
            stm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na consulta", "Atenção!", JOptionPane.OK_OPTION);
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
}
