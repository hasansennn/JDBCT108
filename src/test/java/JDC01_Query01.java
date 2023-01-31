import java.sql.*;

public class JDC01_Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1- İlgili driver' i yüklemeliyiz. MySQL kull. bildiriyoruz
        //    Driver'i bulamama ihtimaline karsi bizden forName methodu icin
        //    ClassNotFoundException method signature exception olarak firlatmamizi istiyor

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2- Baglantiyi olusturmak icin userName ve passsword girmeliyiz
        //    Burada da bu username ve password un yanlis olma ihtimaline karsi
        //    SQLException firlatmamizi istiyor

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        // 3 - SQL guery leri icin bir Stetement objesi olusturup java da SQL
        //     sorgularimiz icin bir alan acacagiz

        Statement st = con.createStatement();

        // 4 - SQL guery'lerimizi yazip calistirabiliriz

        ResultSet veri= st.executeQuery("select*from personel");

        // 5 - Sonuclari gormek in Iteration ile Set icerisindeki elemanlari
        //     while dongusu  ile donduruyoruz

        while (veri.next()){
            System.out.println(veri.getInt(1)+ " " + veri.getString(2)+ " " + veri.getString(3) +
                    " " + veri.getInt(4) + " " + veri.getString(5));

            /*
            123456789 Ali Seker Istanbul 2500 Honda
            234567890 Ayse Gul Istanbul 1500 Toyota
            345678901 Veli Yilmaz Ankara 3000 Honda
            456789012 Veli Yilmaz Izmir 1000 Ford
            567890123 Veli Yilmaz Ankara 7000 Hyundai
            456789012 Ayse Gul Ankara 1500 Ford
            123456710 Fatma Yasa Bursa 2500 Honda


             */
        }

        // 6 - Olusturulan nesneleri close() ile kapatalim ki bellekten kaldirilsin.

        con.close();
        st.close();
        veri.close();


    }



}
