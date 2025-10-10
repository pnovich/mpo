public class KRU {
    public static void main(String[] args) {

        PsMpoKontr psMpoKontr =
                new PsMpoKontr(4,0, true, false, 15, 0,
                        1, 0,15, 0, 1, true,false,false,
                        false, false, false);
//        psMpoKontr.setOstForSection();
//        psMpoKontr.setOstForAxle();
//        psMpoKontr.setValuesForPostitions();
//        psMpoKontr.printResult();
        int n = 3;
        for (int i = 0; i < n; i++) {
            psMpoKontr.doTact(i);
        }
    }

}
