package Trabalho;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ManipularObjetos {
    public static void salvar(Object objeto, String caminho) {
        try {
            FileOutputStream saveFile = new FileOutputStream(caminho);
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);
            // salva o objeto
            stream.writeObject(objeto);
            stream.close();
            System.out.println("Objeto Salvo!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static Object restaurar(String caminho) {
        Object objeto = null;

        try {
            FileInputStream restFile = new FileInputStream(caminho);
            ObjectInputStream stream = new ObjectInputStream(restFile);
            // recupera o objeto
            objeto = stream.readObject();
            stream.close();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Não foi possível restaurar informações da empresa!");
        }
        System.out.println("Objeto Restaurado!");
        return objeto;
    }
}
