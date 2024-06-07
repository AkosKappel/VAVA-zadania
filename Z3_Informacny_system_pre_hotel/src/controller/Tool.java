package controller;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author kappe
 */
public class Tool {

    private static final Calendar c1 = Calendar.getInstance();
    private static final Calendar c2 = Calendar.getInstance();

    private Tool() {
    }

    public static String dateToString(Date date) {
        c1.setTime(date);

        int day = c1.get(Calendar.DAY_OF_MONTH);
        int month = c1.get(Calendar.MONTH) + 1;
        int year = c1.get(Calendar.YEAR);

        return String.valueOf(day) + ". " + String.valueOf(month) + ". " + String.valueOf(year);
    }

    public static int getDaysDifferenceCount(Date date1, Date date2) {

        int dayCount1 = (int) Math.round(date1.getTime() / (double) (24 * 60 * 60 * 1000));
        int dayCount2 = (int) Math.round(date2.getTime() / (double) (24 * 60 * 60 * 1000));

        int daysBetween = dayCount1 - dayCount2;
        return daysBetween;
    }

    public static boolean isBefore(Date date1, Date date2) {
        c1.setTime(date1);
        c2.setTime(date2);

        int day1 = c1.get(Calendar.DAY_OF_MONTH), month1 = c1.get(Calendar.MONTH), year1 = c1.get(Calendar.YEAR);
        int day2 = c2.get(Calendar.DAY_OF_MONTH), month2 = c2.get(Calendar.MONTH), year2 = c2.get(Calendar.YEAR);

        if (year1 > year2) {
            return false;
        } else if (year1 == year2 && month1 > month2) {
            return false;
        } else if (year1 == year2 && month1 == month2 && day1 >= day2) {
            return false;
        }
        return true;
    }

    public static boolean isAfter(Date date1, Date date2) {
        c1.setTime(date1);
        c2.setTime(date2);

        int day1 = c1.get(Calendar.DAY_OF_MONTH), month1 = c1.get(Calendar.MONTH), year1 = c1.get(Calendar.YEAR);
        int day2 = c2.get(Calendar.DAY_OF_MONTH), month2 = c2.get(Calendar.MONTH), year2 = c2.get(Calendar.YEAR);

        if (year1 < year2) {
            return false;
        } else if (year1 == year2 && month1 < month2) {
            return false;
        } else if (year1 == year2 && month1 == month2 && day1 <= day2) {
            return false;
        }
        return true;
    }

    public static double getPrice(JTextField textField) {
        try {
            Double price = Double.parseDouble(textField.getText().trim().replace(",", "."));
            if (price < 0) {
                throw new NumberFormatException();
            }
            return price;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Prosím zadajte cenu ako kladnú číselnú hodnotu.", "Nesprávny formát ceny!", JOptionPane.ERROR_MESSAGE);
            textField.setText("");
            return -1;
        }
    }

}
