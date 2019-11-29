
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bthn0
 */
public class Batuhan extends javax.swing.JFrame{

    Transactions t = new Transactions();
    Timer timer = new Timer(1000, null);
    private int time = 0;
    static int mod;
    boolean kullanici1Oynadi;
    boolean kullanici2Oynadi;
    Oyuncu oyuncu1 = null;
    Oyuncu oyuncu2 = null;
    int hasar1, hasar2;

    /**
     * Creates new form Batuhan
     */
    public Batuhan() {

        initComponents();
        Object[] options = {
            "CPU-CPU",
            "İnsan-CPU"};
        mod = JOptionPane.showOptionDialog(new JFrame(),
                "Oyunun Modunu Seçiniz",
                "Mod Seçimi",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.OK_CANCEL_OPTION,
                null,
                options,
                options[1]);
        if (mod == -1) {//kullanıcı seçim yapmadan kapatırsa
            System.exit(0);
        }

        t.kartlariOlustur();//pokemon kartları tanımlanıyor.
        t.kartIkonOlustur();//kart resimleri tanımlanıyor.
        if (mod == 0) {
            oyuncu1 = new BilgisayarOyuncusu("Bilgisayar-1", 1, 0);
            oyuncu2 = new BilgisayarOyuncusu("Bilgisayar-2", 2, 0);
            kullanici1Ismi.setText(oyuncu1.getOyuncuAdi());
            kullanici1TextIsim.setText(oyuncu1.getOyuncuAdi());
            kullanici1SkorIsmi.setText(oyuncu1.getOyuncuAdi());
            kullanici2Ismi.setText(oyuncu2.getOyuncuAdi());
            kullanici2TextIsim.setText(oyuncu2.getOyuncuAdi());
            kullanici2SkorIsmi.setText(oyuncu2.getOyuncuAdi());
        } else if (mod == 1) {
            String isim;
            String tmp = null;
            isim = JOptionPane.showInputDialog("Oyuncunun İsmini Girin");
            oyuncu1 = new InsanOyuncusu(isim, 1, 0);
            oyuncu2 = new BilgisayarOyuncusu("Bilgisayar", 2, 0);
            if (isim == null) {//kullanıcı isim inputu vermeden kapatırsa default değer atıyor.
                kullanici1Ismi.setText("Kullanıcı-1");
                kullanici1TextIsim.setText("Kullanici-1");
                kullanici1SkorIsmi.setText("Kullanici-1");
            } else {
                kullanici1Ismi.setText(oyuncu1.getOyuncuAdi());
                kullanici1TextIsim.setText(oyuncu1.getOyuncuAdi());
                kullanici1SkorIsmi.setText(oyuncu1.getOyuncuAdi());
            }
            kullanici2Ismi.setText(oyuncu2.getOyuncuAdi());
            kullanici2TextIsim.setText(oyuncu2.getOyuncuAdi());
            kullanici2SkorIsmi.setText(oyuncu2.getOyuncuAdi());
        }
        t.basKartAta(t.kullanilanKartlar, t.pokemon, oyuncu1);
        t.basKartAta(t.kullanilanKartlar, t.pokemon, oyuncu2);
        //---------------------------------------------------------------------------
        kullanici1Kart0.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[0][1])));
        kullanici1Kart1.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[1][1])));
        kullanici1Kart2.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[2][1])));
        //ikonları set ettiğim yer.
        kullanici2Kart0.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[0][1])));
        kullanici2Kart1.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[1][1])));
        kullanici2Kart2.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[2][1])));
        kullanici1OrtaKart.setIcon(t.kartIkon.get(10));
        kullanici2OrtaKart.setIcon(t.kartIkon.get(10));
        kalanKartIkon.setIcon(t.kartIkon.get(10));
        kalanKartSayisi.setText(String.valueOf(10 - t.kullanilanKartlar.size()));
        //System.out.println(oyuncu1.kartListesi[0] + "\n" + oyuncu1.kartListesi[1] + "\n" + oyuncu1.kartListesi[2] + "\n");
        //System.out.println(oyuncu2.kartListesi[0] + "\n" + oyuncu2.kartListesi[1] + "\n" + oyuncu2.kartListesi[2] + "\n");
        //---------------------------------------------------------------------------//
/*
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                time += 20;
                surecKontrol.setValue(time);
                if (surecKontrol.getValue() == 100) {
                    System.out.println("batuhan");
                    if (kullanici1Oynadi == true && kullanici2Oynadi == true) {
                        if (t.kullanilanKartlar.size() < 9) {
                            for (int i = 0; i < 3; i++) {
                                if (oyuncu1.kartListesi[i][0].equalsIgnoreCase(" ")) {
                                    t.yeniKart(t.kullanilanKartlar, t.pokemon, oyuncu1);
                                }
                                if (oyuncu2.kartListesi[i][0].equalsIgnoreCase(" ")) {
                                    t.yeniKart(t.kullanilanKartlar, t.pokemon, oyuncu2);
                                }
                            }
                        }
                        kullanici1OrtaKart.setIcon(t.kartIkon.get(10));
                        kullanici2OrtaKart.setIcon(t.kartIkon.get(10));
                        kullanici1Kart0.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[0][1])));
                        kullanici1Kart1.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[1][1])));
                        kullanici1Kart2.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[2][1])));
                        //ikonları set ettiğim yer.
                        kullanici2Kart0.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[0][1])));
                        kullanici2Kart1.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[1][1])));
                        kullanici2Kart2.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[2][1])));
                        if (hasar1 > hasar2) {
                            skor1 += 5;
                            kullanici1Skor.setText(String.valueOf(skor1));
                        } else if (hasar1 < hasar2) {
                            skor2 += 5;
                            kullanici1Skor.setText(String.valueOf(skor2));
                        }

                        kalanKartSayisi.setText(String.valueOf(10 - t.kullanilanKartlar.size()));
                        kullanici1Oynadi = false;
                        kullanici2Oynadi = false;
                    } else {

                    }
                }
            }
        });
        timer.start();*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        surecKontrol = new javax.swing.JProgressBar();
        raundNext = new javax.swing.JButton();
        kullanici1Ismi = new javax.swing.JLabel();
        kullanici2Ismi = new javax.swing.JLabel();
        kullanici1OrtaKart = new javax.swing.JLabel();
        kullanici2OrtaKart = new javax.swing.JLabel();
        kullanici1Kart0 = new javax.swing.JLabel();
        kullanici1Kart1 = new javax.swing.JLabel();
        kullanici1Kart2 = new javax.swing.JLabel();
        kullanici2Kart0 = new javax.swing.JLabel();
        kullanici2Kart1 = new javax.swing.JLabel();
        kullanici2Kart2 = new javax.swing.JLabel();
        kullanici1TextIsim = new javax.swing.JLabel();
        kullanici2TextIsim = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        kullanici1SkorIsmi = new javax.swing.JLabel();
        kullanici2SkorIsmi = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        kullanici2Skor = new javax.swing.JLabel();
        kullanici1Skor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        kalanKartIkon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        kalanKartSayisi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pokemon Kart Oyunu");
        setBounds(new java.awt.Rectangle(125, 0, 1920, 1080));

        jLabel1.setText("SIRADAKİ RAUNT İÇİN KALAN SÜRE");

        surecKontrol.setIndeterminate(true);
        surecKontrol.setStringPainted(true);

        raundNext.setText("ŞİMDİ GEÇ");
        raundNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raundNextActionPerformed(evt);
            }
        });

        kullanici1Ismi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kullanici1Ismi.setText("Kullanici-1");

        kullanici2Ismi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kullanici2Ismi.setText("Kullanici-2");

        kullanici1OrtaKart.setMaximumSize(new java.awt.Dimension(150, 200));
        kullanici1OrtaKart.setMinimumSize(new java.awt.Dimension(100, 100));

        kullanici1Kart0.setText("K1Kart0");
        kullanici1Kart0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kullanici1Kart0MouseClicked(evt);
            }
        });

        kullanici1Kart1.setText("K1Kart1");
        kullanici1Kart1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kullanici1Kart1MouseClicked(evt);
            }
        });

        kullanici1Kart2.setText("K1Kart2");
        kullanici1Kart2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kullanici1Kart2MouseClicked(evt);
            }
        });

        kullanici2Kart0.setText("K2Kart0");

        kullanici2Kart1.setText("K2Kart1");

        kullanici2Kart2.setText("K2Kart2");

        kullanici1TextIsim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kullanici1TextIsim.setText("Kullanici1");

        kullanici2TextIsim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kullanici2TextIsim.setText("Kullanıcı2");

        kullanici1SkorIsmi.setText("Kullanici-1:");

        kullanici2SkorIsmi.setText("Kullanici-2:");

        kullanici2Skor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kullanici2Skor.setText("0");

        kullanici1Skor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kullanici1Skor.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kullanici1SkorIsmi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kullanici2SkorIsmi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kullanici2Skor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kullanici1Skor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kullanici2Skor, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(kullanici2SkorIsmi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kullanici1Skor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kullanici1SkorIsmi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        kalanKartIkon.setText("jLabel2");

        jLabel3.setText("KALAN KART:");

        kalanKartSayisi.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(kalanKartIkon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kalanKartSayisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(kullanici2TextIsim, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(kullanici2Kart0, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(kullanici2Kart1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(kullanici2Kart2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(316, 316, 316))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(kullanici1Kart0, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)
                                    .addComponent(kullanici1Kart1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(kullanici1Kart2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(kullanici1TextIsim, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(surecKontrol, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(raundNext)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kullanici1OrtaKart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kullanici1Ismi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kullanici2Ismi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kullanici2OrtaKart, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(413, 413, 413))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(raundNext, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(surecKontrol, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kullanici2TextIsim, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kullanici2Kart0, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kullanici2Kart1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kullanici2Kart2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kullanici1Ismi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kullanici2Ismi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kullanici1OrtaKart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kullanici2OrtaKart, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kullanici1Kart0, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kullanici1Kart1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kullanici1Kart2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kullanici1TextIsim, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(kalanKartIkon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(kalanKartSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void raundNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raundNextActionPerformed
        int secilen1, secilen2;
        if (String.valueOf(oyuncu1.getClass()).equals("class BilgisayarOyuncusu")) {
            secilen1 = oyuncu1.kartSec(oyuncu1.kartListesi);
            switch (secilen1) {
                case 0: {
                    kullanici1Kart0.setIcon(t.kartIkon.get(10));
                    kullanici1OrtaKart.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[0][1])));
                    kullanici1Oynadi = true;
                    oyuncu1.kartListesi[0][0] = " ";
                    hasar1 = t.pokemon.get(Integer.parseInt(oyuncu1.kartListesi[0][1])).hasarPuaniGoster();
                    break;
                    //set repat false
                    
                }

                case 1: {
                    kullanici1Kart1.setIcon(t.kartIkon.get(10));
                    kullanici1OrtaKart.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[1][1])));
                    kullanici1Oynadi = true;
                    oyuncu1.kartListesi[1][0] = " ";
                    hasar1 = t.pokemon.get(Integer.parseInt(oyuncu1.kartListesi[1][1])).hasarPuaniGoster();
                    break;
                }

                case 2: {
                    kullanici1Kart2.setIcon(t.kartIkon.get(10));
                    kullanici1OrtaKart.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[2][1])));
                    kullanici1Oynadi = true;
                    oyuncu1.kartListesi[2][0] = " ";
                    hasar1 = t.pokemon.get(Integer.parseInt(oyuncu1.kartListesi[2][1])).hasarPuaniGoster();
                    break;
                }
            }

        }
        if (String.valueOf(oyuncu2.getClass()).equals("class BilgisayarOyuncusu")) {
            secilen2 = oyuncu2.kartSec(oyuncu2.kartListesi);
            switch (secilen2) {
                case 0: {
                    kullanici2Kart0.setIcon(t.kartIkon.get(10));
                    kullanici2OrtaKart.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[0][1])));
                    kullanici2Oynadi = true;
                    oyuncu2.kartListesi[0][0] = " ";
                    hasar2 = t.pokemon.get(Integer.parseInt(oyuncu2.kartListesi[0][1])).hasarPuaniGoster();
                    break;
                }

                case 1: {
                    kullanici2Kart1.setIcon(t.kartIkon.get(10));
                    kullanici2OrtaKart.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[1][1])));
                    kullanici2Oynadi = true;
                    oyuncu2.kartListesi[1][0] = " ";
                    hasar2 = t.pokemon.get(Integer.parseInt(oyuncu2.kartListesi[1][1])).hasarPuaniGoster();
                    break;
                }

                case 2: {
                    kullanici2Kart2.setIcon(t.kartIkon.get(10));
                    kullanici2OrtaKart.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[2][1])));
                    kullanici2Oynadi = true;
                    oyuncu2.kartListesi[2][0] = " ";
                    hasar2 = t.pokemon.get(Integer.parseInt(oyuncu2.kartListesi[2][1])).hasarPuaniGoster();
                    break;
                }
            }
        }
        if (kullanici1Oynadi == true && kullanici2Oynadi == true) {
            if (t.kullanilanKartlar.size() < 10) {
                for (int i = 0; i < 3; i++) {
                    if (oyuncu1.kartListesi[i][0].equalsIgnoreCase(" ")) {
                        t.yeniKart(t.kullanilanKartlar, t.pokemon, oyuncu1);
                    }
                    if (oyuncu2.kartListesi[i][0].equalsIgnoreCase(" ")) {
                        t.yeniKart(t.kullanilanKartlar, t.pokemon, oyuncu2);
                    }
                }
            }
            
            kullanici1OrtaKart.setIcon(t.kartIkon.get(10));
            kullanici2OrtaKart.setIcon(t.kartIkon.get(10));
            if (!(oyuncu1.kartListesi[0][0].equals(" "))) {
                kullanici1Kart0.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[0][1])));
            }
            if (!(oyuncu1.kartListesi[1][0].equals(" "))) {
                kullanici1Kart1.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[1][1])));
            }
            if (!(oyuncu1.kartListesi[2][0].equals(" "))) {
                kullanici1Kart2.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[2][1])));
            }
            //ikonları set ettiğim yer.

            if (!(oyuncu2.kartListesi[0][0].equals(" "))) {
                kullanici2Kart0.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[0][1])));
            }
            if (!(oyuncu2.kartListesi[1][0].equals(" "))) {
                kullanici2Kart1.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[1][1])));
            }
            if (!(oyuncu2.kartListesi[2][0].equals(" "))) {
                kullanici2Kart2.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu2.kartListesi[2][1])));
            }
            if (hasar1 > hasar2) {
                oyuncu1.setSkor(5);
            } else if (hasar1 < hasar2) {
                oyuncu2.setSkor(5);
            }

            kullanici2Skor.setText(String.valueOf(oyuncu2.getSkor()));
            kullanici1Skor.setText(String.valueOf(oyuncu1.getSkor()));
            System.out.println("kullanici 1 skor:" + (String.valueOf(oyuncu1.getSkor())));
            System.out.println("kullanici 2 skor:" + (String.valueOf(oyuncu2.getSkor())));
            kalanKartSayisi.setText(String.valueOf(10 - t.kullanilanKartlar.size()));
            kullanici1Oynadi = false;
            kullanici2Oynadi = false;
        } else {

        }
    }//GEN-LAST:event_raundNextActionPerformed

 private void kullanici1Kart0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kullanici1Kart0MouseClicked
     if (String.valueOf(oyuncu1.getClass()).equals("class InsanOyuncusu") && kullanici1Oynadi == false && !(oyuncu1.kartListesi[0][0].equals(" "))) {
         kullanici1Kart0.setIcon(t.kartIkon.get(10));
         kullanici1OrtaKart.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[0][1])));
         kullanici1Oynadi = true;
         oyuncu1.kartListesi[0][0] = " ";
         hasar1 = t.pokemon.get(Integer.parseInt(oyuncu1.kartListesi[0][1])).hasarPuaniGoster();
     }
    }//GEN-LAST:event_kullanici1Kart0MouseClicked

	private void kullanici1Kart1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kullanici1Kart1MouseClicked
            if (String.valueOf(oyuncu1.getClass()).equals("class InsanOyuncusu") && kullanici1Oynadi == false && !(oyuncu1.kartListesi[1][0].equals(" "))) {
                kullanici1Kart1.setIcon(t.kartIkon.get(10));
                kullanici1OrtaKart.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[1][1])));
                kullanici1Oynadi = true;
                oyuncu1.kartListesi[1][0] = " ";
                hasar1 = t.pokemon.get(Integer.parseInt(oyuncu1.kartListesi[1][1])).hasarPuaniGoster();
            }
    }//GEN-LAST:event_kullanici1Kart1MouseClicked


    private void kullanici1Kart2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kullanici1Kart2MouseClicked

        if (String.valueOf(oyuncu1.getClass()).equals("class InsanOyuncusu") && kullanici1Oynadi == false && !(oyuncu1.kartListesi[2][0].equals(" "))) {
            kullanici1Kart2.setIcon(t.kartIkon.get(10));
            kullanici1OrtaKart.setIcon(t.kartIkon.get(Integer.parseInt(oyuncu1.kartListesi[2][1])));
            kullanici1Oynadi = true;
            oyuncu1.kartListesi[2][0] = " ";
            hasar1 = t.pokemon.get(Integer.parseInt(oyuncu1.kartListesi[2][1])).hasarPuaniGoster();
        }

    }//GEN-LAST:event_kullanici1Kart2MouseClicked

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
            java.util.logging.Logger.getLogger(Batuhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Batuhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Batuhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Batuhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Batuhan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel kalanKartIkon;
    private javax.swing.JLabel kalanKartSayisi;
    private javax.swing.JLabel kullanici1Ismi;
    private javax.swing.JLabel kullanici1Kart0;
    private javax.swing.JLabel kullanici1Kart1;
    private javax.swing.JLabel kullanici1Kart2;
    private javax.swing.JLabel kullanici1OrtaKart;
    private javax.swing.JLabel kullanici1Skor;
    private javax.swing.JLabel kullanici1SkorIsmi;
    private javax.swing.JLabel kullanici1TextIsim;
    private javax.swing.JLabel kullanici2Ismi;
    private javax.swing.JLabel kullanici2Kart0;
    private javax.swing.JLabel kullanici2Kart1;
    private javax.swing.JLabel kullanici2Kart2;
    private javax.swing.JLabel kullanici2OrtaKart;
    private javax.swing.JLabel kullanici2Skor;
    private javax.swing.JLabel kullanici2SkorIsmi;
    private javax.swing.JLabel kullanici2TextIsim;
    private javax.swing.JButton raundNext;
    private javax.swing.JProgressBar surecKontrol;
    // End of variables declaration//GEN-END:variables
}
