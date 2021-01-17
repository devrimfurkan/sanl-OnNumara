package sanlıOnNumara;

import java.util.*;

public class Main {

    /*
    * 1'den 60'a kadar 1000 tane rastgele sayı oluştur ve küçükten büyüğe doğru ilk on
    * tane sayıyı sırala.
    * */

    static final int URETILECEK_SAYI_MAX_SINIRI=60;
    static final int URETILECEK_SAYI_MIKTARI=1000;
    public static void main(String[] args) {

        Map<Integer,Integer> olusturulanSayilarMap=new HashMap<>();
        List<Integer> olsuturulanSayiListesi=new ArrayList<>();
        Set<Integer> sanlisOnSayi=new TreeSet<>();

        mapiSayilarlaDoldur(olusturulanSayilarMap);
        mapiListeyeYazdir(olusturulanSayilarMap,olsuturulanSayiListesi);
        sanlisOnSayiyiBul(sanlisOnSayi,olsuturulanSayiListesi);

        System.out.println("Listenin Boyutu(size: )"+olsuturulanSayiListesi.size());
        System.out.println("Map Boyutu(size): "+olusturulanSayilarMap.size());
        System.out.println("set size: "+sanlisOnSayi.size());

        System.out.println("Şanslı 10 Sayı");

        for (int gecici: sanlisOnSayi){
            System.out.print(gecici+ "  ");
        }
        /*for (Map.Entry<Integer,Integer> gecici: olusturulanSayilarMap.entrySet()){
            System.out.println(gecici);
        }*/

    }

    private static void sanlisOnSayiyiBul(Set<Integer> sanlisOnSayi, List<Integer> olsuturulanSayiListesi) {

    Collections.shuffle(olsuturulanSayiListesi);

    while (sanlisOnSayi.size()<10){
        int rastgeleSayi=(int)(Math.random()*URETILECEK_SAYI_MIKTARI);
        sanlisOnSayi.add(olsuturulanSayiListesi.get(rastgeleSayi));
    }
    }

    private static void mapiListeyeYazdir(Map<Integer, Integer> olusturulanSayilarMap, List<Integer> olsuturulanSayiListesi) {
        for (Map.Entry<Integer,Integer> gecici: olusturulanSayilarMap.entrySet()){
            int key=gecici.getKey();
            int value=gecici.getValue();

            for (int i=0;i<value;i++){
                olsuturulanSayiListesi.add(key);
            }
        }

    }

    private static void mapiSayilarlaDoldur(Map<Integer, Integer> olusturulanSayilarMap) {
        for (int  i=0;i<URETILECEK_SAYI_MIKTARI;i++){
            int randomSayi=sayiOlustur();
            if (olusturulanSayilarMap.containsKey(randomSayi)){
                int value=olusturulanSayilarMap.get(randomSayi);
                olusturulanSayilarMap.put(randomSayi,++value);
            }else {
                olusturulanSayilarMap.put(randomSayi,1);
            }
        }
    }

    private static int sayiOlustur() {
        return ((int)(Math.random()*URETILECEK_SAYI_MAX_SINIRI)+1);
    }


}
