package arquivo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Client {

    public static void main(String[] args) {
        JButton envia = new JButton("Enviar arquivo");
        JButton baixa = new JButton("Baixar aquivo");
        JButton lista = new JButton("Listar arquivos no servidor");
        JPanel jPanel = new JPanel();
        jPanel.add(envia);
        jPanel.add(baixa);
        jPanel.add(lista);

        lista.addActionListener(new ActionListener() {
            @Override
            //TODO
            //Listar os arquivos no servidor
            public void actionPerformed(ActionEvent e) {

            }
        });

        baixa.addActionListener(new ActionListener() {
            @Override

            //TODO
            //Escolher um arquivo para baixar e abrir uma JFile chooser para escolher o lugar para salvar

            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = new JFrame();

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Salvar como");

                fileChooser.showSaveDialog(parentFrame);

            }
        });

        envia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int retorno = fileChooser.showOpenDialog(null);

                if (retorno == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    //TODO
                    //ENVIAR ARQUIVO PARA O SERVIDOR
                }
            }
        });

        JFrame window = new JFrame("File Sender");
        window.add(jPanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
