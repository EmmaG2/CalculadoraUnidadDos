package utilities;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class InputValidator {
    public static final Color errorColor = new Color (255, 0, 0);
    public static final Border errorBorder = BorderFactory.createLineBorder(errorColor);
    public static Border originalBorder = new JTextField().getBorder();
    public static Color originalColor = new JTextField().getForeground();

    public static boolean fieldIsEmpty(JTextField field, JLabel lblErr, String message) {

        if (field.getText().isEmpty()) {
            setErrorStyles(field, lblErr);
            lblErr.setText(message);
        }

        return field.getText().isEmpty();
    }

    public static boolean numberFormatIsValid(JTextField field, JLabel lblErr, String message) {
        try {
            Float.parseFloat(field.getText());
        } catch (NumberFormatException e) {
            setErrorStyles(field, lblErr);
            lblErr.setText(message);
            return false;
        }

        return true;
    }

    private static void setErrorStyles(JTextField field, JLabel lblErr) {
        field.setBorder(errorBorder);
        field.setForeground(errorColor);
        lblErr.setForeground(errorColor);
    }

    public static void resetStyles(JTextField field, JLabel lblErr) {
        field.setBorder(originalBorder);
        field.setForeground(originalColor);
        lblErr.setForeground(originalColor);
        lblErr.setText("");
    }

    public static void resetStyles(JTextField field) {
        field.setBorder(originalBorder);
        field.setForeground(originalColor);
    }
}
