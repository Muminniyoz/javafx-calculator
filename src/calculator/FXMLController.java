package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FXMLController implements Initializable {

    @FXML
    private Label izoh;
    @FXML
    private Label hotiraHolat;
    @FXML
    private Label holat;
    @FXML
    private Button btnBesht;
    @FXML
    private Button btnBoluv;
    @FXML
    private Button btnToqqiz;
    @FXML
    private Button btnSakkiz;
    @FXML
    private Button btnYetti;
    @FXML
    private Button btnIldiz;
    @FXML
    private Button btnPlusMenus;
    @FXML
    private Button btnC;
    @FXML
    private Button btnUchirgich;
    @FXML
    private Button btnCe;
    @FXML
    private Button btnMmenus;
    @FXML
    private Button btnMplus;
    @FXML
    private Button btnMs;
    @FXML
    private Button btnMr;
    @FXML
    private Button btnAyiruv;
    @FXML
    private Button btnFoiz;
    @FXML
    private Button btnUch;
    @FXML
    private Button btnIkki;
    @FXML
    private Button btnBir;
    @FXML
    private Button btnTeskari;
    @FXML
    private Button btnKupaytiruv;
    @FXML
    private Button btnOlti;
    @FXML
    private Button btnTurt;
    @FXML
    private Button btnNuqta;
    @FXML
    private Button btnQoshuv;
    @FXML
    private Button btnNol;
    @FXML
    private Button btnTenglik;
    @FXML
    private Button btnMc;
    @FXML
    private RadioButton rbGradius;
    @FXML
    private RadioButton rbRadian;
    @FXML
    private Button btnMc1;
    @FXML
    private Button btnQavsYopish;
    @FXML
    private Button btnQavsOchish;
    @FXML
    private Button btnMod;
    @FXML
    private RadioButton rbGrad;
    @FXML
    private Button btnln;
    @FXML
    private Button btnlnv;
    @FXML
    private Button btnxkub;
    @FXML
    private Button btntan;
    @FXML
    private Button btntanh;
    @FXML
    private Button btnPi;
    @FXML
    private Button btnxildizy;
    @FXML
    private Button btnxdary;
    @FXML
    private Button btncos;
    @FXML
    private Button btncosh;
    @FXML
    private Button btndms;
    @FXML
    private Button btnnfack;
    @FXML
    private Button btnxkv;
    @FXML
    private Button btnsin;
    @FXML
    private Button btnsinh;
    @FXML
    private Button btnInt;
    @FXML
    private Button btnlog;
    @FXML
    private Button btnExp;
    @FXML
    private Button btnFE;
    @FXML
    private Button btnxkupildiz;
    @FXML
    private Button btn10darx;
    @FXML
    private Label labelAmal;


    
    public static boolean butun = true;
    public static boolean yozishRuxsat = true;
    public static boolean amalBor = false;
    public static boolean nuqtaBor = false;
    public static int amal = 0;
    private double burchakKoefsent = Math.PI / 180;

    private long joriyButun = 0;
    private long hotiraButun = 0;
    private double joriyHaqiqiy = 0;
    private double holatHaqiqiy = 0;
    private double daraja = 1;
    private double haqiqiy = 0;

    private static AudioClip audio, audio2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Komponentalarni initializatsiya qilish

        btnUchirgich.setText("\u2190");
       

        audio = new AudioClip(getClass().getResource("s.wav").toString());
        audio2 = new AudioClip(getClass().getResource("xato.wav").toString());

    }

    @FXML
    private void raqamHodisa(ActionEvent event) {
        audio.play();
        if(amalBor){
            joriyButun = 0;
            joriyHaqiqiy=0;
            amalBor = false;
        }
        if (yozishRuxsat) {
            int n = Integer.parseInt(((Button) event.getSource()).getText());
            if (butun && nuqtaBor == false) {
                joriyButun = 10 * joriyButun + n;
                holatUrnat(joriyButun);
                if ((joriyButun + "").length() == 18) {
                    yozishRuxsat = false;
                }

            }

        } else {
            if(nuqtaBor){
                audio2.play();
                joriyHaqiqiy = joriyButun;
                int n = Integer.parseInt(((Button) event.getSource()).getText());
                daraja = daraja/10.;
                joriyHaqiqiy = joriyHaqiqiy+(daraja)*n;
                holatUrnat(joriyHaqiqiy);
            }
            
        }
        haqiqiy = (double)joriyButun;

    }

    @FXML
    private void amalHodisa(ActionEvent event) {
        audio.play();
        amalBor = true;
        hotiraButun = joriyButun;
        holatHaqiqiy = joriyHaqiqiy;
        izoh.setText(hotiraButun + "");

        String amalStr = ((Button) event.getSource()).getText();
        switch(amalStr){
            case "+":
                amal =1;
                break;
            case "-":
                amal = 2;
                break;
            case "*":
                amal = 3;
                break;
            case "/":
                amal = 4;
                break;
        }
        //izoh.setText(amalStr);
        labelAmal.setText(amalStr);

    }

    @FXML
    private void ildizHodisa(ActionEvent event) {
        audio.play();
        haqiqiy = Math.sqrt(haqiqiy);
        holatUrnat(haqiqiy);
    }

    @FXML
    private void ctozlashHodisa(ActionEvent event) {
        audio.play();
        joriyButun = 0;
        holatUrnat(joriyButun);
    }
    
    @FXML
    private void CETozalashHodisasi(ActionEvent event){
        audio.play();
        izoh.setText(null);
        labelAmal.setText(null);
        joriyButun = 0;
        holatUrnat(joriyButun);
        
    }

    @FXML
    private void uchirishHodisa(ActionEvent event) {
        audio.play();
        if(butun){
            joriyButun /= 10;
            holatUrnat(joriyButun);
        }

    }

    @FXML
    private void mhotiraHodisa(ActionEvent event) {
        audio.play();
        
    }

    @FXML
    private void foizHodisa(ActionEvent event) {
        audio.play();
        if(butun){
           //labelAmal.setText(null);
           //izoh.setText(null); 
           joriyButun *= hotiraButun;
           izoh.setText(hotiraButun +" "+ labelAmal.getText()+" "+(double)joriyButun/100);
           holatUrnat((double)joriyButun/100);        
        }
        
    }

    @FXML
    private void teskariHodisa(ActionEvent event) {
        audio.play();
        labelAmal.setText(null);
        izoh.setText(null);
        haqiqiy = 1./haqiqiy;
        holatUrnat(haqiqiy);
   
    }

    @FXML
    private void nuqtaHodisa(ActionEvent event) {
        holatUrnat(".");
        nuqtaBor = true;
    }

    @FXML
    private void tenglikHodisa(ActionEvent event) {
        audio.play();
        
        
            //if(butun){
                switch(amal){
                    case 1: 
                        joriyButun += hotiraButun;
                        holatUrnat(joriyButun);
                        labelAmal.setText(null);
                        izoh.setText(null);
                        break;
                    case 2: 
                        joriyButun -= hotiraButun;
                        holatUrnat(joriyButun);
                        labelAmal.setText(null);
                        izoh.setText(null);
                        break;
                    case 3: 
                        joriyButun *= hotiraButun;
                        holatUrnat(joriyButun);
                        labelAmal.setText(null);
                        izoh.setText(null);
                        break;
                    case 4: 
                        double bulinma = (double)hotiraButun/joriyButun;
                        holatUrnat(bulinma);
                        labelAmal.setText(null);
                        izoh.setText(null);
                        break;                   
                }            
        //}     
    }

    @FXML
    private void tugmaChiqish(MouseEvent event) {
        ((Button) event.getSource()).setEffect(null);

    }

    @FXML
    private void tugmaKirish(MouseEvent event) {

        //InnerShadow insh = new InnerShadow(30, Color.GOLD);

        //((Button) event.getSource()).setEffect(insh);

    }

    private void holatUrnat(String jSonSatr) {
        holat.setText(joriyButun+jSonSatr);
    }

    @FXML
    private void ishoraHodisa(ActionEvent event) {
        if (butun) {
            joriyButun *= -1;
            holatUrnat(joriyButun);
        }

    }

    public static void xatolik() {
        audio2.play();
    }

    public void holatUrnat(long son) {
        String sonStr = son + "";
        if (sonStr.length() > 12) {
            holat.setFont(Font.font(18));
        } else {
            holat.setFont(Font.font(24));

        }
        holat.setText(sonStr);

    }

    public void holatUrnat(double son) {
        String sonStr = son + "";
        if (sonStr.length() > 12) {
            holat.setFont(Font.font(18));
        } else {
            holat.setFont(Font.font(24));

        }
        holat.setText(sonStr);
    }

}
