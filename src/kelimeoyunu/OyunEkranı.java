/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelimeoyunu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Yakup
 */
public class OyunEkranı extends javax.swing.JFrame {

    ArrayList<Soru> bütünSorular;
    int eklenenSoruSayısı;
    ArrayList<Soru> sorulacakSorular;
    int sorulanSoruSayısı;
    ArrayList<Integer> açılanHarfler;
    StringBuilder kelime;
    int puan;
    int ekrandakiKalanSüre = 240;
    int ekrandakiTahminEtmeKalanSüresi = 20;

    javax.swing.Timer kalanSüreTimer;

    javax.swing.Timer kalanTahminEtmeSüresiTimer;

    /**
     * Creates new form OyunEkranı
     */
    public OyunEkranı() {
        initComponents();
        bütünSorular = new ArrayList<Soru>();
        bütünSorularıDoldur();
        eklenenSoruSayısı = 0;
        sorulacakSorular = new ArrayList<Soru>();
        sorulacakSorularıDoldur(eklenenSoruSayısı);
        açılanHarfler = new ArrayList<Integer>();

        kelimeTanımıOyunEkranıTextArea.setLineWrap(true);
        kelimeTanımıOyunEkranıTextArea.setWrapStyleWord(true);

    }

    public void bütünSorularıDoldur() {
        try {
            FileInputStream file = new FileInputStream("Sorular.txt");
            ObjectInput inputFile = new ObjectInputStream(file);

            boolean dosyaSonu = false;
            while (!dosyaSonu) {
                try {
                    bütünSorular.add((Soru) inputFile.readObject());
                } catch (EOFException e) {
                    dosyaSonu = true;
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void sorulacakSorularıDoldur(int eklenenSoruSayısı) {
        Random random = new Random();
        int rastgeleSayı;

        while (eklenenSoruSayısı < 2) {
            rastgeleSayı = random.nextInt(bütünSorular.size());
            if (bütünSorular.get(rastgeleSayı).kelime.length() == 4
                    && Collections.frequency(sorulacakSorular, bütünSorular.get(rastgeleSayı)) < 1) {
                sorulacakSorular.add(bütünSorular.get(rastgeleSayı));
                eklenenSoruSayısı++;
            }

        }

        while (eklenenSoruSayısı < 4) {
            rastgeleSayı = random.nextInt(bütünSorular.size());
            if (bütünSorular.get(rastgeleSayı).kelime.length() == 5
                    && Collections.frequency(sorulacakSorular, bütünSorular.get(rastgeleSayı)) < 1) {
                sorulacakSorular.add(bütünSorular.get(rastgeleSayı));
                eklenenSoruSayısı++;
            }

        }

        while (eklenenSoruSayısı < 6) {
            rastgeleSayı = random.nextInt(bütünSorular.size());
            if (bütünSorular.get(rastgeleSayı).kelime.length() == 6
                    && Collections.frequency(sorulacakSorular, bütünSorular.get(rastgeleSayı)) < 1) {
                sorulacakSorular.add(bütünSorular.get(rastgeleSayı));
                eklenenSoruSayısı++;
            }

        }

        while (eklenenSoruSayısı < 8) {
            rastgeleSayı = random.nextInt(bütünSorular.size());
            if (bütünSorular.get(rastgeleSayı).kelime.length() == 7
                    && Collections.frequency(sorulacakSorular, bütünSorular.get(rastgeleSayı)) < 1) {
                sorulacakSorular.add(bütünSorular.get(rastgeleSayı));
                eklenenSoruSayısı++;
            }

        }

        while (eklenenSoruSayısı < 10) {
            rastgeleSayı = random.nextInt(bütünSorular.size());
            if (bütünSorular.get(rastgeleSayı).kelime.length() == 8
                    && Collections.frequency(sorulacakSorular, bütünSorular.get(rastgeleSayı)) < 1) {
                sorulacakSorular.add(bütünSorular.get(rastgeleSayı));
                eklenenSoruSayısı++;
            }

        }

        while (eklenenSoruSayısı < 12) {
            rastgeleSayı = random.nextInt(bütünSorular.size());
            if (bütünSorular.get(rastgeleSayı).kelime.length() == 9
                    && Collections.frequency(sorulacakSorular, bütünSorular.get(rastgeleSayı)) < 1) {
                sorulacakSorular.add(bütünSorular.get(rastgeleSayı));
                eklenenSoruSayısı++;
            }

        }

        while (eklenenSoruSayısı < 14) {
            rastgeleSayı = random.nextInt(bütünSorular.size());
            if (bütünSorular.get(rastgeleSayı).kelime.length() == 10
                    && Collections.frequency(sorulacakSorular, bütünSorular.get(rastgeleSayı)) < 1) {
                sorulacakSorular.add(bütünSorular.get(rastgeleSayı));
                eklenenSoruSayısı++;
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oyunEkranıPanel = new javax.swing.JPanel();
        kelimeTanımıOyunEkranıLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kelimeTanımıOyunEkranıTextArea = new javax.swing.JTextArea();
        kelimeOyunEkranıLabel = new javax.swing.JLabel();
        kelimeOyunEkranıTextField = new javax.swing.JTextField();
        harfSayısıOyunEkranıTextField = new javax.swing.JTextField();
        kelimeTahminEtmeAlanıLabel = new javax.swing.JLabel();
        kelimeTahminEtmeAlanıTextField = new javax.swing.JTextField();
        harfİstiyorumOyunEkranıButton = new javax.swing.JButton();
        tahminEtmekİstiyorumOyunEkranıButton = new javax.swing.JButton();
        tahminEtOyunEkranıButton = new javax.swing.JButton();
        kelimeSırasıLabel = new javax.swing.JLabel();
        kelimeSırasıTextField = new javax.swing.JTextField();
        puanOyunEkranıLabel = new javax.swing.JLabel();
        puanOyunEkranıTextField = new javax.swing.JTextField();
        kalanSüreOyunEkranıLabel = new javax.swing.JLabel();
        kalanSüreOyunEkranıTextField = new javax.swing.JTextField();
        kalanTahminEtmeSüresiOyunEkranıLabel = new javax.swing.JLabel();
        kalanTahminEtmeSüresiOyunEkranıTextField = new javax.swing.JTextField();
        oyuncuAdıOyunEkranıLabel = new javax.swing.JLabel();
        oyuncuAdıOyunEkranıTextField = new javax.swing.JTextField();
        oyunaBaşlaOyunEkranıButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Oyun Ekranı");
        setResizable(false);

        oyunEkranıPanel.setBackground(new java.awt.Color(0, 180, 180));

        kelimeTanımıOyunEkranıLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        kelimeTanımıOyunEkranıLabel.setText("Kelime Tanımı ");

        kelimeTanımıOyunEkranıTextArea.setEditable(false);
        kelimeTanımıOyunEkranıTextArea.setBackground(new java.awt.Color(200, 200, 200));
        kelimeTanımıOyunEkranıTextArea.setColumns(20);
        kelimeTanımıOyunEkranıTextArea.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        kelimeTanımıOyunEkranıTextArea.setRows(5);
        jScrollPane1.setViewportView(kelimeTanımıOyunEkranıTextArea);

        kelimeOyunEkranıLabel.setBackground(new java.awt.Color(200, 200, 200));
        kelimeOyunEkranıLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        kelimeOyunEkranıLabel.setText("Kelime");

        kelimeOyunEkranıTextField.setEditable(false);
        kelimeOyunEkranıTextField.setBackground(new java.awt.Color(200, 200, 200));
        kelimeOyunEkranıTextField.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        harfSayısıOyunEkranıTextField.setEditable(false);
        harfSayısıOyunEkranıTextField.setBackground(new java.awt.Color(200, 200, 200));
        harfSayısıOyunEkranıTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        kelimeTahminEtmeAlanıLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        kelimeTahminEtmeAlanıLabel.setText("Tahmin Etme Alanı");

        kelimeTahminEtmeAlanıTextField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        kelimeTahminEtmeAlanıTextField.setEnabled(false);
        kelimeTahminEtmeAlanıTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelimeTahminEtmeAlanıTextFieldActionPerformed(evt);
            }
        });

        harfİstiyorumOyunEkranıButton.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        harfİstiyorumOyunEkranıButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kelimeoyunu/Project Icons Resized/harfİstiyorum.png"))); // NOI18N
        harfİstiyorumOyunEkranıButton.setText("Harf İstiyorum");
        harfİstiyorumOyunEkranıButton.setEnabled(false);
        harfİstiyorumOyunEkranıButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harfİstiyorumOyunEkranıButtonActionPerformed(evt);
            }
        });

        tahminEtmekİstiyorumOyunEkranıButton.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        tahminEtmekİstiyorumOyunEkranıButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kelimeoyunu/Project Icons Resized/tahminEtme.png"))); // NOI18N
        tahminEtmekİstiyorumOyunEkranıButton.setText("Tahmin Etmek İstiyorum");
        tahminEtmekİstiyorumOyunEkranıButton.setEnabled(false);
        tahminEtmekİstiyorumOyunEkranıButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahminEtmekİstiyorumOyunEkranıButtonActionPerformed(evt);
            }
        });

        tahminEtOyunEkranıButton.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        tahminEtOyunEkranıButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kelimeoyunu/Project Icons Resized/tahminEtme.png"))); // NOI18N
        tahminEtOyunEkranıButton.setText("Tahmin Et");
        tahminEtOyunEkranıButton.setEnabled(false);
        tahminEtOyunEkranıButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahminEtOyunEkranıButtonActionPerformed(evt);
            }
        });

        kelimeSırasıLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        kelimeSırasıLabel.setText("Kelime Sırası");

        kelimeSırasıTextField.setEditable(false);
        kelimeSırasıTextField.setBackground(new java.awt.Color(200, 200, 200));
        kelimeSırasıTextField.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        kelimeSırasıTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelimeSırasıTextFieldActionPerformed(evt);
            }
        });

        puanOyunEkranıLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        puanOyunEkranıLabel.setText("Puan");

        puanOyunEkranıTextField.setEditable(false);
        puanOyunEkranıTextField.setBackground(new java.awt.Color(200, 200, 200));
        puanOyunEkranıTextField.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        puanOyunEkranıTextField.setForeground(new java.awt.Color(0, 0, 204));
        puanOyunEkranıTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puanOyunEkranıTextFieldActionPerformed(evt);
            }
        });

        kalanSüreOyunEkranıLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        kalanSüreOyunEkranıLabel.setText("Kalan Süre(sn)");

        kalanSüreOyunEkranıTextField.setEditable(false);
        kalanSüreOyunEkranıTextField.setBackground(new java.awt.Color(200, 200, 200));
        kalanSüreOyunEkranıTextField.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        kalanSüreOyunEkranıTextField.setForeground(new java.awt.Color(255, 0, 0));

        kalanTahminEtmeSüresiOyunEkranıLabel.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        kalanTahminEtmeSüresiOyunEkranıLabel.setText("Kalan Tahmin Etme Süresi(sn)");

        kalanTahminEtmeSüresiOyunEkranıTextField.setEditable(false);
        kalanTahminEtmeSüresiOyunEkranıTextField.setBackground(new java.awt.Color(200, 200, 200));
        kalanTahminEtmeSüresiOyunEkranıTextField.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        kalanTahminEtmeSüresiOyunEkranıTextField.setForeground(new java.awt.Color(255, 0, 0));
        kalanTahminEtmeSüresiOyunEkranıTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kalanTahminEtmeSüresiOyunEkranıTextFieldActionPerformed(evt);
            }
        });

        oyuncuAdıOyunEkranıLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        oyuncuAdıOyunEkranıLabel.setText("Oyuncu Adı");

        oyuncuAdıOyunEkranıTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        oyuncuAdıOyunEkranıTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oyuncuAdıOyunEkranıTextFieldActionPerformed(evt);
            }
        });

        oyunaBaşlaOyunEkranıButton.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        oyunaBaşlaOyunEkranıButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kelimeoyunu/Project Icons Resized/start-sign.png"))); // NOI18N
        oyunaBaşlaOyunEkranıButton.setText("Oyuna Başla");
        oyunaBaşlaOyunEkranıButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oyunaBaşlaOyunEkranıButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout oyunEkranıPanelLayout = new javax.swing.GroupLayout(oyunEkranıPanel);
        oyunEkranıPanel.setLayout(oyunEkranıPanelLayout);
        oyunEkranıPanelLayout.setHorizontalGroup(
            oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(kelimeSırasıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(puanOyunEkranıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kalanSüreOyunEkranıLabel)
                            .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(kalanSüreOyunEkranıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kalanTahminEtmeSüresiOyunEkranıLabel)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oyunEkranıPanelLayout.createSequentialGroup()
                                .addComponent(kalanTahminEtmeSüresiOyunEkranıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))))
                    .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                        .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(oyunaBaşlaOyunEkranıButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                                        .addComponent(kelimeSırasıLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(puanOyunEkranıLabel)
                                        .addGap(38, 38, 38))
                                    .addComponent(harfİstiyorumOyunEkranıButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tahminEtmekİstiyorumOyunEkranıButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(oyuncuAdıOyunEkranıTextField)))
                            .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(oyuncuAdıOyunEkranıLabel)))
                        .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(kelimeTahminEtmeAlanıLabel)
                                        .addComponent(kelimeTanımıOyunEkranıLabel)
                                        .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                                            .addComponent(kelimeOyunEkranıLabel)
                                            .addGap(18, 18, 18)
                                            .addComponent(harfSayısıOyunEkranıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                                        .addComponent(kelimeOyunEkranıTextField))
                                    .addComponent(kelimeTahminEtmeAlanıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(tahminEtOyunEkranıButton)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        oyunEkranıPanelLayout.setVerticalGroup(
            oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                        .addComponent(tahminEtmekİstiyorumOyunEkranıButton)
                        .addGap(132, 132, 132))
                    .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                        .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                                .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kelimeSırasıLabel)
                                    .addComponent(puanOyunEkranıLabel)
                                    .addComponent(kalanSüreOyunEkranıLabel)
                                    .addComponent(kalanTahminEtmeSüresiOyunEkranıLabel))
                                .addGap(18, 18, 18)
                                .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kelimeSırasıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(puanOyunEkranıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kalanSüreOyunEkranıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kalanTahminEtmeSüresiOyunEkranıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, oyunEkranıPanelLayout.createSequentialGroup()
                                        .addComponent(kelimeTanımıOyunEkranıLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jScrollPane1))
                                    .addGroup(oyunEkranıPanelLayout.createSequentialGroup()
                                        .addComponent(oyuncuAdıOyunEkranıLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(oyuncuAdıOyunEkranıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(oyunaBaşlaOyunEkranıButton)))
                                .addGap(26, 26, 26)
                                .addGroup(oyunEkranıPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kelimeOyunEkranıLabel)
                                    .addComponent(harfSayısıOyunEkranıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(kelimeOyunEkranıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(harfİstiyorumOyunEkranıButton))
                        .addGap(29, 29, 29)
                        .addComponent(kelimeTahminEtmeAlanıLabel)
                        .addGap(18, 18, 18)
                        .addComponent(kelimeTahminEtmeAlanıTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tahminEtOyunEkranıButton)
                        .addGap(27, 27, 27))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oyunEkranıPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(oyunEkranıPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void puanOyunEkranıTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puanOyunEkranıTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puanOyunEkranıTextFieldActionPerformed

    private void kelimeSırasıTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelimeSırasıTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelimeSırasıTextFieldActionPerformed

    private void kalanTahminEtmeSüresiOyunEkranıTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kalanTahminEtmeSüresiOyunEkranıTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kalanTahminEtmeSüresiOyunEkranıTextFieldActionPerformed

    private void kelimeTahminEtmeAlanıTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelimeTahminEtmeAlanıTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelimeTahminEtmeAlanıTextFieldActionPerformed

    private void oyuncuAdıOyunEkranıTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oyuncuAdıOyunEkranıTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oyuncuAdıOyunEkranıTextFieldActionPerformed

    private void oyunaBaşlaOyunEkranıButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oyunaBaşlaOyunEkranıButtonActionPerformed
        // TODO add your handling code here:
        sorulanSoruSayısı = 0;
        kelimeTanımıOyunEkranıTextArea.setText(sorulacakSorular.get(sorulanSoruSayısı).tanım);
        kelime = new StringBuilder(sorulacakSorular.get(sorulanSoruSayısı).kelime);
        for (int i = 0; i < sorulacakSorular.get(sorulanSoruSayısı).kelime.length(); i++) {
            kelime.setCharAt(i, '_');
        }
        kelimeOyunEkranıTextField.setText(kelime.toString());
        kelimeSırasıTextField.setText(String.valueOf(sorulanSoruSayısı + 1) + "/" + String.valueOf(sorulacakSorular.size()));
        puan = 0;
        puanOyunEkranıTextField.setText(String.valueOf(puan));
        harfSayısıOyunEkranıTextField.setText(String.valueOf(sorulacakSorular.get(sorulanSoruSayısı).kelime.length()) + " Harfli");

        harfİstiyorumOyunEkranıButton.setEnabled(true);
        tahminEtmekİstiyorumOyunEkranıButton.setEnabled(true);

        kalanSüreTimer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kalanSüreOyunEkranıTextField.setText(String.valueOf(ekrandakiKalanSüre));

                if (ekrandakiKalanSüre == 0) {
                    LocalDate date = LocalDate.now();
                    DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                    LocalTime time = LocalTime.now();
                    DateTimeFormatter formatterT = DateTimeFormatter.ofPattern("HH:mm:ss");

                    String sdate = date.format(formatterD);
                    String stime = time.format(formatterT);

                    new OyunBitiş(oyuncuAdıOyunEkranıTextField.getText(),
                            puan,
                            ekrandakiKalanSüre,
                            sdate,
                            stime
                    ).setVisible(true);

                    OyunEkranı.super.dispose();
                }
                ekrandakiKalanSüre--;
            }
        });
        kalanSüreTimer.start();

        oyunaBaşlaOyunEkranıButton.setEnabled(false);


    }//GEN-LAST:event_oyunaBaşlaOyunEkranıButtonActionPerformed

    private void harfİstiyorumOyunEkranıButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harfİstiyorumOyunEkranıButtonActionPerformed
        // TODO add your handling code here:
        if (açılanHarfler.size() < sorulacakSorular.get(sorulanSoruSayısı).kelime.length()) {
            Random random = new Random();
            int rastgeleSayı = random.nextInt(sorulacakSorular.get(sorulanSoruSayısı).kelime.length());
            while (açılanHarfler.contains(rastgeleSayı)) {
                rastgeleSayı = random.nextInt(sorulacakSorular.get(sorulanSoruSayısı).kelime.length());
            }
            kelime.setCharAt(rastgeleSayı, sorulacakSorular.get(sorulanSoruSayısı).kelime.charAt(rastgeleSayı));
            kelimeOyunEkranıTextField.setText(kelime.toString());
            açılanHarfler.add(rastgeleSayı);

        }
    }//GEN-LAST:event_harfİstiyorumOyunEkranıButtonActionPerformed

    private void tahminEtmekİstiyorumOyunEkranıButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahminEtmekİstiyorumOyunEkranıButtonActionPerformed
        // TODO add your handling code here:

        try {
            kelimeTahminEtmeAlanıTextField.setEnabled(true);
            tahminEtOyunEkranıButton.setEnabled(true);

            kalanSüreTimer.stop();

            kalanTahminEtmeSüresiTimer = new javax.swing.Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    kalanTahminEtmeSüresiOyunEkranıTextField.setText(String.valueOf(ekrandakiTahminEtmeKalanSüresi));
                    if (ekrandakiTahminEtmeKalanSüresi == 0) {
                        puan -= (sorulacakSorular.get(sorulanSoruSayısı).kelime.length() - açılanHarfler.size()) * 100;
                        puanOyunEkranıTextField.setText(String.valueOf(puan));

                        kalanTahminEtmeSüresiTimer.stop();

                        sorulanSoruSayısı++;
                        if (sorulanSoruSayısı == 14) {
                            LocalDate date = LocalDate.now();
                            DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                            LocalTime time = LocalTime.now();
                            DateTimeFormatter formatterT = DateTimeFormatter.ofPattern("HH:mm:ss");

                            String sdate = date.format(formatterD);
                            String stime = time.format(formatterT);

                            new OyunBitiş(oyuncuAdıOyunEkranıTextField.getText(),
                                    puan,
                                    ekrandakiKalanSüre,
                                    sdate,
                                    stime
                            ).setVisible(true);

                            OyunEkranı.super.dispose();
                        }
                        kalanTahminEtmeSüresiOyunEkranıTextField.setText("");
                        ekrandakiTahminEtmeKalanSüresi = 20;
                        açılanHarfler.clear();
                        kelime = new StringBuilder(sorulacakSorular.get(sorulanSoruSayısı).kelime);
                        kelimeTanımıOyunEkranıTextArea.setText(sorulacakSorular.get(sorulanSoruSayısı).tanım);
                        for (int i = 0; i < sorulacakSorular.get(sorulanSoruSayısı).kelime.length(); i++) {
                            kelime.setCharAt(i, '_');
                        }
                        kelimeOyunEkranıTextField.setText(kelime.toString());
                        kelimeSırasıTextField.setText(String.valueOf(sorulanSoruSayısı + 1) + "/" + String.valueOf(sorulacakSorular.size()));
                        harfSayısıOyunEkranıTextField.setText(String.valueOf(sorulacakSorular.get(sorulanSoruSayısı).kelime.length()) + " Harfli");

                        kelimeTahminEtmeAlanıTextField.setText("");

                        tahminEtmekİstiyorumOyunEkranıButton.setEnabled(true);
                        harfİstiyorumOyunEkranıButton.setEnabled(true);
                        tahminEtOyunEkranıButton.setEnabled(false);
                        kelimeTahminEtmeAlanıTextField.setEnabled(false);

                        kalanSüreTimer.start();
                    }
                    ekrandakiTahminEtmeKalanSüresi--;
                }
            });
            kalanTahminEtmeSüresiTimer.start();

            tahminEtmekİstiyorumOyunEkranıButton.setEnabled(false);
            harfİstiyorumOyunEkranıButton.setEnabled(false);

        } catch (Exception exc) {

        }


    }//GEN-LAST:event_tahminEtmekİstiyorumOyunEkranıButtonActionPerformed

    private void tahminEtOyunEkranıButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahminEtOyunEkranıButtonActionPerformed
        // TODO add your handling code here:

        try {
            if (kelimeTahminEtmeAlanıTextField.getText().trim().toUpperCase().equals(sorulacakSorular.get(sorulanSoruSayısı).kelime)) {
                puan += (sorulacakSorular.get(sorulanSoruSayısı).kelime.length() - açılanHarfler.size()) * 100;
                puanOyunEkranıTextField.setText(String.valueOf(puan));

                kalanTahminEtmeSüresiTimer.stop();

                sorulanSoruSayısı++;
                if (sorulanSoruSayısı == 14) {
                    LocalDate date = LocalDate.now();
                    DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                    LocalTime time = LocalTime.now();
                    DateTimeFormatter formatterT = DateTimeFormatter.ofPattern("HH:mm:ss");

                    String sdate = date.format(formatterD);
                    String stime = time.format(formatterT);

                    new OyunBitiş(oyuncuAdıOyunEkranıTextField.getText(),
                            puan,
                            ekrandakiKalanSüre,
                            sdate,
                            stime
                    ).setVisible(true);

                    OyunEkranı.super.dispose();
                }
                kalanTahminEtmeSüresiOyunEkranıTextField.setText("");
                ekrandakiTahminEtmeKalanSüresi = 20;
                açılanHarfler.clear();
                kelime = new StringBuilder(sorulacakSorular.get(sorulanSoruSayısı).kelime);
                kelimeTanımıOyunEkranıTextArea.setText(sorulacakSorular.get(sorulanSoruSayısı).tanım);
                for (int i = 0; i < sorulacakSorular.get(sorulanSoruSayısı).kelime.length(); i++) {
                    kelime.setCharAt(i, '_');
                }
                kelimeOyunEkranıTextField.setText(kelime.toString());
                kelimeSırasıTextField.setText(String.valueOf(sorulanSoruSayısı + 1) + "/" + String.valueOf(sorulacakSorular.size()));
                harfSayısıOyunEkranıTextField.setText(String.valueOf(sorulacakSorular.get(sorulanSoruSayısı).kelime.length()) + " Harfli");

                kelimeTahminEtmeAlanıTextField.setText("");

                tahminEtmekİstiyorumOyunEkranıButton.setEnabled(true);
                harfİstiyorumOyunEkranıButton.setEnabled(true);
                tahminEtOyunEkranıButton.setEnabled(false);
                kelimeTahminEtmeAlanıTextField.setEnabled(false);

                kalanSüreTimer.start();

            } else {
                kelimeTahminEtmeAlanıTextField.setText("");
            }
        } catch (Exception exc) {

        }


    }//GEN-LAST:event_tahminEtOyunEkranıButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OyunEkranı.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OyunEkranı.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OyunEkranı.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OyunEkranı.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OyunEkranı().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField harfSayısıOyunEkranıTextField;
    private javax.swing.JButton harfİstiyorumOyunEkranıButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kalanSüreOyunEkranıLabel;
    private javax.swing.JTextField kalanSüreOyunEkranıTextField;
    private javax.swing.JLabel kalanTahminEtmeSüresiOyunEkranıLabel;
    private javax.swing.JTextField kalanTahminEtmeSüresiOyunEkranıTextField;
    private javax.swing.JLabel kelimeOyunEkranıLabel;
    private javax.swing.JTextField kelimeOyunEkranıTextField;
    private javax.swing.JLabel kelimeSırasıLabel;
    private javax.swing.JTextField kelimeSırasıTextField;
    private javax.swing.JLabel kelimeTahminEtmeAlanıLabel;
    private javax.swing.JTextField kelimeTahminEtmeAlanıTextField;
    private javax.swing.JLabel kelimeTanımıOyunEkranıLabel;
    private javax.swing.JTextArea kelimeTanımıOyunEkranıTextArea;
    private javax.swing.JPanel oyunEkranıPanel;
    private javax.swing.JButton oyunaBaşlaOyunEkranıButton;
    private javax.swing.JLabel oyuncuAdıOyunEkranıLabel;
    private javax.swing.JTextField oyuncuAdıOyunEkranıTextField;
    private javax.swing.JLabel puanOyunEkranıLabel;
    private javax.swing.JTextField puanOyunEkranıTextField;
    private javax.swing.JButton tahminEtOyunEkranıButton;
    private javax.swing.JButton tahminEtmekİstiyorumOyunEkranıButton;
    // End of variables declaration//GEN-END:variables
}
