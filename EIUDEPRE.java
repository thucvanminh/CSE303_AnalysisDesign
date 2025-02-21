//import java.util.Scanner;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//
//public class EIUDEPRE {
//    static Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        Infor info = takeInfor();
//        double rate = calculateRate(info);
//        System.out.println(rate);
//    }
//
//    private static BigDecimal calculateRate(Infor info) {
//        BigDecimal max = new BigDecimal("0.5");
//        BigDecimal min = new BigDecimal("0.0");
//        // double middle = (min + max) / 2.0;
//        BigDecimal middle = (max.add(min)).divide(new BigDecimal("2"), 8, RoundingMode.HALF_UP);
//        // double rate = 1;
//        BigDecimal money = new BigDecimal(info.initMoney);
//        while (Math.abs(money.subtract(new BigDecimal(info.target)) > 0.00000001) {
//            money = calculateValue(info, middle);
//            if (money > info.target) {
//                middle = (min + max) / 2.0;
//                min = middle;
//            } else if (money < info.target) {
//                middle = (min + max) / 2.0;
//                max = middle;
//            }
//        }
//
//        return middle;
//    }
//
//    static class Infor {
//        int years;
//        double initMoney;
//        double target;
//
//        public Infor(int years, double initMoney, double target) {
//
//            this.years = years;
//            this.initMoney = initMoney;
//            this.target = target;
//        }
//
//    }
//
//    static Infor takeInfor() {
//        int years = sc.nextInt();
//        double initMoney = sc.nextDouble();
//        double target = sc.nextDouble();
//        return new Infor(years, initMoney, target);
//    }
//
//    static BigDecimal calculateValue(Infor input, BigDecimal rate) {
//        BigDecimal result = new BigDecimal(input.initMoney);
//        for (int i = 0; i < input.years; i++) {
//            result = result.multiply(1 - rate);
//        }
//        return result;
//    }
//}
