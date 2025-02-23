package syntaxanaliz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SyntaxAnaliz {
    public static void main(String[] args) {
      String dosyaAdi = "src/odev.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;

            while ((satir = br.readLine()) != null) {
                int uzunluk = satir.length();

         
                char islem1 = satir.charAt(0);
                char islem2 = satir.charAt(1);
                char islem3 = satir.charAt(2);
                boolean islemGecerli;

               
                if (islem1 == 'C' && islem2 == 'A' && islem3 == 'R'  && satir.charAt(3) == 'P') {
                    islemGecerli = true;
                } else {
                    islemGecerli = 
                        (islem1 == 'T' && islem2 == 'O' && islem3 == 'P') ||
                        (islem1 == 'C' && islem2 == 'I' && islem3 == 'K') ||
                        (islem1 == 'B' && islem2 == 'O' && islem3 == 'L');
                }
                 if (islemGecerli==false) {
                    System.out.println(satir + " satirinda gecersiz islem adi");
                    continue;
                }

                 
             
               int sayi;
               if (islem1 == 'C' && islem2 == 'A' && islem3 == 'R'  ) {
             
              sayi = 4;
               } else {
              
              sayi = 3;
             }
             if (satir.charAt(sayi) != ' ') {
            System.out.println(satir + " satirinda boşluk eksik.");
            continue;
                }


                
                int sayi1İlk = sayi + 1;
                int sayi1Son = sayi1İlk;
                while (sayi1Son< uzunluk && satir.charAt(sayi1Son) != ',') {
                    sayi1Son++;
                }

              
                boolean sayi1Gecerli = true;
                for (int i = sayi1İlk; i < sayi1Son; i++) {
                    char c = satir.charAt(i);
                    if (c < '0' || c > '9') {
                        sayi1Gecerli = false;
                        break;
                    }
                }

                if (!sayi1Gecerli || sayi1Son == uzunluk || satir.charAt(sayi1Son) != ',') {
                    System.out.println(satir + " satirinda sayi hatali.");
                    continue;
                }

               
                int sayi2İlk = sayi1Son + 1;
                int sayi2Son = sayi2İlk;
                while (sayi2Son < uzunluk && satir.charAt(sayi2Son) != ' ') {
                    sayi2Son++;
                }

               
                boolean sayi2Gecerli = true;
                for (int i = sayi2İlk; i < sayi2Son; i++) {
                    char c = satir.charAt(i);
                    if (c < '0' || c > '9') {
                        sayi2Gecerli = false;
                        break;
                    }
                }

                if (!sayi2Gecerli) {
                    System.out.println(satir + " satirinda sayi hatali.");
                    continue;
                }

                
                System.out.println(satir + " satiri gecerli.");
            }
        } catch (IOException e) {
            System.out.println("Dosya okuma hatasi: " + e.getMessage());
        }
    }
}