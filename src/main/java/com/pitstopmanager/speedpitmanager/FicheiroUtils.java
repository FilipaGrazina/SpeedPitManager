package com.pitstopmanager.speedpitmanager;

import java.io.*;
/**
 *
 * @author anafilipa
 */
public class FicheiroUtils {

    public static void guardarDados(String nomeFicheiro, Object objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFicheiro))) {
            oos.writeObject(objeto);
            System.out.println("Dados guardados com sucesso em: " + nomeFicheiro);
        } catch (IOException e) {
            System.out.println("Erro ao guardar dados: " + e.getMessage());
        }
    }

    public static Object carregarDados(String nomeFicheiro) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFicheiro))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
            return null;
        }
    }
}
