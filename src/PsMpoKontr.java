public class PsMpoKontr {
    public Integer X7, X18, X10, X21, P24, P25, Y5, OST, Y6, Y7;

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

    public void printResult() {
        System.out.println("Ost = " + this.OST);
        System.out.println("DP_SOST = " +  DP_SOST);
        System.out.println("DC4 =" + DC4 + " DC3 =" + DC3 + " DC2 =" + DC2 + " DC1 =" + DC1);
    }

    public static void main(String[] args) {

        PsMpoKontr psMpoKontr =
                new PsMpoKontr(4,0, true, false, 15, 0, 1, 0,15, 0, 1, true,false,false, false, false, false);
        psMpoKontr.setOstForSection();
        psMpoKontr.setOstForAxle();
        psMpoKontr.setValuesForPostitions();
        psMpoKontr.printResult();
    }

    public void setOstForSection() {
        if (P24 != 0 & Y6 == P24) {
            Y5 = 0;
            OST = X10;
            boolean tmp = ((!(Y11 | Y12 | Y13 | Y14)) & ((!RAB_OK) & Y10));
            if (tmp) {
                Y7 = Y6;
                Y6 = 0;
            }
        }
        if (P25 != 0 & Y6 == P25) {
            Y5 = 0;
            OST = X10;
            boolean tmp = ((!(Y11 | Y12 | Y13 | Y14)) & ((!RAB_OK) & Y10));
            if (tmp) {
                Y7 = Y6;
                Y6 = 0;
            }
        }
    }

    public void setOstForAxle() {
        if (P24 != 0 & Y7 == P24) {
            Y5 = X10;
            OST = X7;
            DP_SOST = ((X7 != 0) & X8);
            boolean tmp = ((!(Y11 | Y12 | Y13 | Y14)) & ((!RAB_OK) & Y10));
            if (tmp) {
                Y6 = Y7;
                Y7 = 0;
            }
        }
        if (P25 != 0 & Y7 == P25) {
            Y5 = X21;
            OST = X18;
            DP_SOST = ((X18 != 0) & X19);
            boolean tmp = ((!(Y11 | Y12 | Y13 | Y14)) & ((!RAB_OK) & Y10));
            if (tmp) {
                Y6 = Y7;
                Y7 = 0;
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
        int tmp = 0;
        int tsc = input % 10000;
        int st = input % 1000;
        int ds = input % 100;
        int ed = input % 10;
        positions[0] = tsc;
        positions[1] = st;
        positions[2] = ds;
        positions[3] = ed;
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

        if (positions[1] >47 && positions[1] < 58) {
            DC3 = mapIntValueToCode(positions[1]);
        }
        if (positions[2] >47 && positions[2] < 58) {
            DC2 = mapIntValueToCode(positions[2]);
        }
        if (positions[3] >47 && positions[3] < 58) {
            DC1 = mapIntValueToCode(positions[3]);
        }
        System.out.println("finished mapping for section");
    }

    public void setValuesForAxle(int Ost) {

        savePositions(Ost, positions);
        if (positions[0] >47 && positions[0] < 58) {
            DC4 = mapIntValueToCode(positions[0]);
        }
        if (positions[1] >47 && positions[1] < 58) {
            DC3 = mapIntValueToCode(positions[1]);
        }
        if (positions[2] >47 && positions[2] < 58) {
            DC2 = mapIntValueToCode(positions[2]);
        }
        if (positions[3] >47 && positions[3] < 58) {
            DC1 = mapIntValueToCode(positions[3]);
        }

        System.out.println("finished mapping for Axle");

    }
}
