/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverno4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ksa
 */
public class ServerNo4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(4004);
            System.out.println("Subiu o ServerNo4");
        } catch (IOException ex) {
            System.out.println("Não é possível configurar o servidor neste número da porta. ");
        }

        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;

        try {
            socket = serverSocket.accept();
        } catch (IOException ex) {
            System.out.println("Não é possível aceitar a conexão do cliente. ");
        }

        try {
            in = socket.getInputStream();
        } catch (IOException ex) {
            System.out.println("Não é possível obter o fluxo de entrada do soquete. ");
        }

        try {
            out = new FileOutputStream("C:\\Users\\Ksa\\Documents\\NetBeansProjects\\uploadServerNo1\\src\\arquivos\\novo4.txt");
            System.out.println("Arquivo Copiando SeverNo4");

            byte[] bytes = new byte[16 * 1024];

            int count;
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }

            out.close();
            in.close();
            socket.close();
            serverSocket.close();
            // TODO code application logic here
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado. ");
        }
    }
}
