package com.akemitti.jdbc.main;

import com.akemitti.jdbc.dao.GerenciadorNomes;
import com.akemitti.jdbc.dao.GerenciadorNomesMem;
import com.akemitti.jdbc.view.Ihm;

public class Main {
    public static void main(String[] args) {
        try {
            GerenciadorNomes gerenciador = new GerenciadorNomesMem();
            Ihm ihm = new Ihm(gerenciador);
            ihm.dialogar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
