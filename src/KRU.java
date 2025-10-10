public class KRU {
    public static void main(String[] args) {

        PsMpoKontr psMpoKontr =
                new PsMpoKontr(4,0, true, false, 15, 0,
                        1, 0,15, 0, 1, false,false,false,
                        false, false, false);
//        psMpoKontr.setOstForSection();
//        psMpoKontr.setOstForAxle();
//        psMpoKontr.setValuesForPostitions();
//        psMpoKontr.printResult();
        int n = 3;
        psMpoKontr.doTact(1,0);
        psMpoKontr.doTact(2,1);
        psMpoKontr.doTact(3,1);
        psMpoKontr.doTact(4,1); //
        psMpoKontr.doTact(5,0);
        psMpoKontr.doTact(6,1);
        psMpoKontr.doTact(7,1);
        psMpoKontr.doTact(8,1);//
        psMpoKontr.doTact(9,0);
        psMpoKontr.doTact(10,1);
        psMpoKontr.doTact(11,1);
        psMpoKontr.doTact(12,1);//
        psMpoKontr.doTact(13,0);
        psMpoKontr.doTact(14,0);
        psMpoKontr.doTact(15,0);




    }

}
