/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Classes;

import static com.Classes.Funcionario.ArrayFuncionario;
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
public class Departamento {

    private int id;
    private String nome;

    public static ArrayList<Departamento> ArrayDepartamento = new ArrayList<>();
    public static List<String> ArrayNomesDepartamento = new ArrayList<String>();

    public static int localizaIdex(int id_departamento) {
        int index = 0;
        for (int i = 0; i < ArrayDepartamento.size(); i++) {
            if (ArrayDepartamento.get(i).getId() == id_departamento) {
                System.out.println(ArrayDepartamento.get(i).getId());
                index = i;
                return index;
            }

            System.out.println("Passou pelo for" + i + "vez");
        }
        return 0;

    }

    public static void listarDepartamentos() {

        ResultSet rs = null;
        String selectSql = "SELECT * FROM departamentos;";

        try {

            Statement stm = getConexaoMySQL().createStatement();

            rs = stm.executeQuery(selectSql);
            while (rs.next()) {
                Departamento dep = new Departamento();
                dep.setId(rs.getInt("id"));
                dep.setNome(rs.getString("descricao"));

                ArrayNomesDepartamento.add(dep.getNome());
                ArrayDepartamento.add(dep);
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
}
