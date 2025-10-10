public class PsMpoKontr {
    public Integer X7, X18, X10, X21, P24, P25, Y5, OST, Y6, Y7;
    public static final int P1 = 2;
    public int COUNT_OK = 0;

    boolean flag = true;

    public Boolean RAB_OK, Y10, Y11, Y12, Y13, Y14, X8, X19,  DP_SOST;

    public Integer DC1, DC2, DC3, DC4;

    public int [] positions = {45,45,45,45};
    public PsMpoKontr(Integer X7,
                      Integer X18,
                      Boolean X8,
                      Boolean X19,
                      Integer X10,
                      Integer X21,
                      Integer P24,
                      Integer P25,
                      Integer Y5,
                      Integer Y6,
                      Integer Y7,
                      Boolean Y10,
                      Boolean Y11,
                      Boolean Y12,
                      Boolean Y13,
                      Boolean Y14,
                      Boolean RAB_OK) {
        this.OST = 0;
        this.X7 = X7;
        this.X8 = X8;
        this.X19 = X19;
        this.X10 = X10;
        this.X18 = X18;
        this.X21 = X21;
        this.P24 = P24;
        this.P25 = P25;
        this.Y6 = Y6;
        this.Y5 = Y5;
        this.Y7 = Y7;
        this.Y10 = Y10;
        this.Y11 = Y11;
        this.Y12 = Y12;
        this.Y13 = Y13;
        this.Y14 = Y14;
        this.RAB_OK = RAB_OK;
        this.DC1 = this.DC2 = this.DC3 = this.DC4 = 48;
    }

    public void printResult(int count, int X27) {
        System.out.println("Ost = " + this.OST + " Flag = " + flag);
        System.out.println("Rab_OK = " + RAB_OK + " Y10 = " + Y10 + " X27 = " + X27);
        System.out.println("DP_SOST = " +  DP_SOST);
        System.out.println("POS_AXLE = " + Y7 + " POS_UID = " + Y6 + " PS_UID = " + Y5);
        System.out.println("DC4 =" + DC4 + " DC3 =" + DC3 + " DC2 =" + DC2 + " DC1 =" + DC1);
    }

    public void printAfterButtonProcessing(int count) {
        System.out.println("----------------------------------------------------------");
        System.out.println("Tact number " + count);
        System.out.println("after button processing : RAB_OK = " + RAB_OK + " Y10 = " + Y10);
    }

    public static void main(String[] args) {

//        PsMpoKontr psMpoKontr =
//                new PsMpoKontr(4,0, true, false, 15, 0, 1, 0,15, 0, 1, true,false,false, false, false, false);
//        psMpoKontr.setOstForSection();
//        psMpoKontr.setOstForAxle();
//        psMpoKontr.setValuesForPostitions();
//        psMpoKontr.printResult();
    }

    public void doTact(int count, int X27) {
        flag = true;
        processButton(X27);
        printAfterButtonProcessing(count);
        setOstForSection();
        setOstForAxle();
        setValuesForPostitions();
        RAB_OK = Y10;
//        Y10 = false;
        printResult(count, X27);
    }

    public void processButton(int X27) {
        if (X27 != 0) {
            if (COUNT_OK >= P1) {
                Y10 = true;
            } else {
                COUNT_OK++;
                Y10 = false;
            }
        } else {
            COUNT_OK = 0;
            Y10 = false;
        }
    }

    public void setOstForSection() {
        if (P24 != 0 & Y6 == P24) {
//            boolean tmp = ((!(Y11 | Y12 | Y13 | Y14)) & ((!RAB_OK) & Y10));
            boolean tmp = (!RAB_OK) & Y10 & flag;
            if (tmp) {
                Y5 = 0;
                OST = X7;

                Y7 = Y6;
                Y6 = 0;
                flag = false;
            }
        }
        if (P25 != 0 & Y6 == P25) {
//            boolean tmp = ((!(Y11 | Y12 | Y13 | Y14)) & ((!RAB_OK) & Y10));
            boolean tmp = (!RAB_OK) & Y10 & flag;

            if (tmp) {
                Y5 = 0;
                OST = X18;

                Y7 = Y6;
                Y6 = 0;
                flag = false;
            }
        }
    }

    public void setOstForAxle() {
        if (P24 != 0 & Y7 == P24) {
//            boolean tmp = ((!(Y11 | Y12 | Y13 | Y14)) & ((!RAB_OK) & Y10));
            boolean tmp = (!RAB_OK) & Y10 & flag;
            if (tmp) {
                Y5 = X10;
                OST = X10;
                DP_SOST = ((X7 != 0) & X8);

                Y6 = Y7;
                Y7 = 0;
                flag = false;
            }
        }
        if (P25 != 0 & Y7 == P25) {
//            boolean tmp = ((!(Y11 | Y12 | Y13 | Y14)) & ((!RAB_OK) & Y10));
            boolean tmp = (!RAB_OK) & Y10 & flag;
            if (tmp) {
                Y5 = X21;
                OST = X21;
                DP_SOST = ((X18 != 0) & X19);

                Y6 = Y7;
                Y7 = 0;
                flag = false;
            }
        }

    }

    public Integer mapIntValueToCode(Integer input) {
        Integer result = 0;
        switch (input) {
            case 0:
                result = 48;
                break;
            case 1:
                result = 49;
                break;
            case 2:
                result = 50;
                break;
            case 3:
                result = 51;
                break;
            case 4:
                result = 52;
                break;
            case 5:
                result = 53;
                break;
            case 6:
                result = 54;
                break;
            case 7:
                result = 55;
                break;
            case 8:
                result = 56;
                break;
            case 9:
                result = 57;
                break;
            default:
                result = 48;

        }

        return result;
    }

    public void savePositions(Integer input, int [] positions) {
        int tmp = input;
        int tsc = input / 1000;
        tmp = input % 1000;
        int st = tmp / 100;
        tmp = tmp % 100;
        int ds = tmp / 10;
        tmp =  tmp % 10;
        int ed = tmp;
        positions[0] = tsc;
        positions[1] = st;
        positions[2] = ds;
        positions[3] = ed;
//        int i = 3;
//        while (tmp > 0) {
//
//        }
    }

    public void setValuesForPostitions() {
        if (Y6 != 0) {
            setValuesForSection(this.OST);
        }

        if (Y7 != 0) {
            setValuesForAxle(this.OST);
        }
    }

    public void setValuesForSection(int Ost) {

        savePositions(Ost, positions);
//        if (positions[0] >47 && positions[0] < 58) {
//            DC4 = mapIntValueToCode(positions[0]);
//        }

       DC4 = 83;

        if (positions[1] >-1 && positions[1] < 10) {
            DC3 = mapIntValueToCode(positions[1]);
        }
        if (positions[2] >-1 && positions[2] < 10) {
            DC2 = mapIntValueToCode(positions[2]);
        }
        if (positions[3] >-1 && positions[3] < 10) {
            DC1 = mapIntValueToCode(positions[3]);
        }
        System.out.println("finished mapping for section");
    }

    public void setValuesForAxle(int Ost) {

        savePositions(Ost, positions);
        if (positions[0] >-1 && positions[0] < 10) {
            DC4 = mapIntValueToCode(positions[0]);
        }
        if (positions[1] >-1 && positions[1] < 10) {
            DC3 = mapIntValueToCode(positions[1]);
        }
        if (positions[2] >-1 && positions[2] < 10) {
            DC2 = mapIntValueToCode(positions[2]);
        }
        if (positions[3] >-1 && positions[3] < 10) {
            DC1 = mapIntValueToCode(positions[3]);
        }

        System.out.println("finished mapping for Axle");

    }
}
