package com.vv.auth.struts.util;

public class BookUtility {

    /**
     * 根据发布状态标志返回中文的发布状态字符串
     *
     * @param stateFlag
     * @return
     */
    public static String getBookIssueState(String stateFlag) {
        String state = "";
        if ("C".equals(stateFlag)) {
            state = Utility.getMessage("book.promulgationstate.C");
        } else if ("G".equals(stateFlag)) {
            state = Utility.getMessage("book.promulgationstate.G");
        } else if ("K".equals(stateFlag)) {
            state = Utility.getMessage("book.promulgationstate.K");
        } else if ("M".equals(stateFlag)) {
            state = Utility.getMessage("book.promulgationstate.M");
        } else if ("N".equals(stateFlag)) {
            state = Utility.getMessage("book.promulgationstate.N");
        } else if ("S".equals(stateFlag)) {
            state = Utility.getMessage("book.promulgationstate.S");
        } else if ("T".equals(stateFlag)) {
            state = Utility.getMessage("book.promulgationstate.T");
        } else if ("V".equals(stateFlag)) {
            state = Utility.getMessage("book.promulgationstate.V");
        }
        return state;
    }

    /**
     * 根据图书状态标志返回中文图书状态标志
     *
     * @param stateFlag
     * @return
     */
    public static String getBookState(String stateFlag) {
        String state = "";
        if ("N".equals(stateFlag)) {
            state = Utility.getMessage("book.status.n");
        } else if ("E".equals(stateFlag)) {
            state = Utility.getMessage("book.status.o");
        } else if ("C".equals(stateFlag)) {
            state = Utility.getMessage("book.status.s");
        }
        return state;
    }

    /**
     * 根据图书状态判断是否能够进行审核操作
     *
     * @param stateFlag
     * @return
     */
    public static boolean isNeedAudit(String stateFlag) {
        boolean flag = false;
        if ("N".equals(stateFlag) || "S".equals(stateFlag)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 根据书费标志返回中文书费类型字符串
     *
     * @param feeFlag
     * @return
     */
    public static String getZhFeeType(String feeFlag) {
        String feeType = Utility.getMessage("book.feetype.free");
        if ("0".equals(feeFlag)) {
            feeType = Utility.getMessage("book.feetype.free");
        } else if ("1".equals(feeFlag)) {
            feeType = Utility.getMessage("book.feetype.book");
        } else if ("2".equals(feeFlag)) {
            feeType = Utility.getMessage("book.feetyoe.chapter");
        }
        return feeType;
    }

    public static String getBookFeeInfo(String feeFlag, String numfee) {
        StringBuffer sb = new StringBuffer();
        if ("1".equals(feeFlag)) {
            try {
                numfee = (Float.valueOf(numfee).floatValue() / 10) + "";
            } catch (Exception e) {
                e.printStackTrace();
                numfee = "NaN";
            }
            sb.append(Utility.getMessage("book.feetype.book") + ":  " + numfee + Utility.getMessage("label.datuu.bi") + "/" + Utility.getMessage("label.quanshu"));
        } else if ("2".equals(feeFlag)) {
            try {
                numfee = (Float.valueOf(numfee).floatValue() / 10) + "";
            } catch (Exception e) {
                e.printStackTrace();
                numfee = "NaN";
            }
            sb.append(Utility.getMessage("book.feetyoe.chapter") + ":  " + numfee + Utility.getMessage("label.datuu.bi") + "/" + Utility.getMessage("label.zhangjie"));
        } else {
            sb.append(Utility.getMessage("book.fee.free"));
        }
        return sb.toString();
    }
}
