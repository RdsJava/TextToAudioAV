package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SimpleWindow extends JFrame {
    public SimpleWindow() {
        super();
        setTitle("Avtor");

        PathToAudio pathToAudio = new PathToAudio();
        TextToAudioOporiHladovit textToAudioOporiHladovit = new TextToAudioOporiHladovit();
        TextToAudioCiklo textToAudioCiklo = new TextToAudioCiklo();
        TextToAudioNomernoi textToAudioNomernoi = new TextToAudioNomernoi();
        TextToAudioRitmo textToAudioRitmo = new TextToAudioRitmo();
        TextToAudioOporiRadasteid textToAudioOporiRadasteid = new  TextToAudioOporiRadasteid();
        TextToAudioR100 textToAudioR100 = new TextToAudioR100();
        TextToAudioRadasteid textToAudioRadasteid = new TextToAudioRadasteid();
        TextToAudioRozuzOpori textToAudioRozuzOpori = new TextToAudioRozuzOpori();

        JTextArea textArea = new JTextArea(30, 30);

        JButton click = new JButton("Создать");// Создание кнопки

        JCheckBox o_hladovit = new JCheckBox("Опоры Хладавит", false);
        JCheckBox ciklo = new JCheckBox("Циклохладвит", false);
        JCheckBox nomernoi = new JCheckBox("Номерной", false);
        JCheckBox ritmo = new JCheckBox("Ритмохладавит", false);
        JCheckBox o_radasteid = new JCheckBox("Опоры Радастеид", false);
        JCheckBox radasteid100 = new JCheckBox("Радастеид - 100", false);
        JCheckBox radasteid = new JCheckBox("Радастеид", false);
        JCheckBox rozuzOpori = new JCheckBox("Розуз-опоры", false);



        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // FlowLayout - Менеджер последовательного размещения

//Созданное поле добавляется в окно аплета методом add.
        panel.add(textArea);
        panel.add(click);

        panel.add(o_hladovit);
        panel.add(ciklo);
        panel.add(nomernoi);
        panel.add(ritmo);
        panel.add(o_radasteid);
        panel.add(radasteid100);
        panel.add(radasteid);
        panel.add(rozuzOpori);

        setContentPane(panel); /* Метод setContentPane(JPanel panel) позволяет заменить панель содержимого окна.*/
        pack(); //устанавливает такой минимальный размер контейнера, который достаточен для отображения всех компонентов.

// метод для сохранения в файл введенного текста в поле
        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String d = textArea.getText();

                //Запись в файл текста:
                try {
                    FileWriter writer = new FileWriter(pathToAudio.getPathToAudio() + "doc.txt");
                    writer.write(d);
                    writer.flush();//Данные, которые вы записываете в Writer, иногда временно хранятся в буфере, метод flush() используется для сброса (flush) всех данных из буфера в целевой объект.
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                BufferedReader brTest;
                try {
                    brTest = new BufferedReader(new FileReader(pathToAudio.getPathToAudio() + "doc.txt"));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                String text = null;
                try {
                    text = brTest.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    if (o_hladovit.isSelected()) {
                        textToAudioOporiHladovit.textToAudioOporiHladovit(text);
                    }
                    if (ciklo.isSelected()) {
                        textToAudioCiklo.textToAudioCiklo(text);
                    }
                    if (nomernoi.isSelected()) {
                        textToAudioNomernoi.textToAudioNomernoi(text);
                    }
                    if (ritmo.isSelected()) {
                        textToAudioRitmo.textToAudioRitmo(text);
                    }
                    if (o_radasteid.isSelected()) {
                        textToAudioOporiRadasteid.textToAudioOporiRadasteid(text);
                    }
                    if (radasteid100.isSelected()) {
                        textToAudioR100.textToAudioR100(text);
                    }
                    if (radasteid.isSelected()) {
                        textToAudioRadasteid.textToAudioRadasteid(text);
                    }
                    if (rozuzOpori.isSelected()) {
                        textToAudioRozuzOpori.textToAudioRozuzOpori(text);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}