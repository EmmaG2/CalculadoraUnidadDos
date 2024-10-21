package views;

import com.itd.math.Complex;
import com.itd.math.ComplexOperations;
import utilities.InputValidator;
import utilities.LatexUtils;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Logger;

public class ComplexNumbers extends javax.swing.JPanel {
    public ComplexNumbers() {
        try {
            initComponents();
        } catch (IOException | FontFormatException e) {
            Logger.getLogger(ComplexNumbers.class.getName(), e.getLocalizedMessage());
        }
    }

    private void onSumComplex() {

        boolean a1Valid = InputValidator.numberFormatIsValid(a1, lblError1, "Por favor ingresa un número válido");
        boolean a2Valid = InputValidator.numberFormatIsValid(a2, lblError1, "Por favor ingresa un número válido");
        boolean b1Valid = InputValidator.numberFormatIsValid(b1, lblError1, "Por favor ingresa un número válido");
        boolean b2Valid = InputValidator.numberFormatIsValid(b2, lblError1, "Por favor ingresa un número válido");

        if (!a1Valid || !a2Valid || !b1Valid || !b2Valid) return;

        Complex z1 = new Complex(Float.parseFloat(a1.getText()), Float.parseFloat(b1.getText()));
        Complex z2 = new Complex(Float.parseFloat(a2.getText()), Float.parseFloat(b2.getText()));

        Complex sumRes = ComplexOperations.add(z1, z2);

        LatexUtils.updateLatex(result, "z = " + sumRes, 32f);

        resetInputs();
    }

    private void resetInputs() {
        InputValidator.resetStyles(a1, lblError1);
        InputValidator.resetStyles(a2, lblError1);
        InputValidator.resetStyles(b1, lblError1);
        InputValidator.resetStyles(b2, lblError1);
    }

    private void onSubstractComplex() {
        Complex z1 = new Complex(Float.parseFloat(a1.getText()), Float.parseFloat(b1.getText()));
        Complex z2 = new Complex(Float.parseFloat(a2.getText()), Float.parseFloat(b2.getText()));

        Complex sumRes = ComplexOperations.subtract(z1, z2);

        LatexUtils.updateLatex(result, "z = " + sumRes, 32f);
        result2.setIcon(null);

        resetInputs();
    }

    private void onMultiplyComplex() {
        Complex z1 = new Complex(Float.parseFloat(a1.getText()), Float.parseFloat(b1.getText()));
        Complex z2 = new Complex(Float.parseFloat(a2.getText()), Float.parseFloat(b2.getText()));

        Complex sumRes = ComplexOperations.multiply(z1, z2);

        LatexUtils.updateLatex(result, "z = " + sumRes, 32f);
        result2.setIcon(null);

        resetInputs();
    }

    private void onDivideComplex() {
        Complex z1 = new Complex(Float.parseFloat(a1.getText()), Float.parseFloat(b1.getText()));
        Complex z2 = new Complex(Float.parseFloat(a2.getText()), Float.parseFloat(b2.getText()));

        Complex sumRes = ComplexOperations.divide(z1, z2);

        LatexUtils.updateLatex(result, "z = " + sumRes, 32f);
        result2.setIcon(null);

        resetInputs();

    }

    private void onPolarForm() {
        Complex z1 = new Complex(Float.parseFloat(a1.getText()), Float.parseFloat(b1.getText()));
        Complex z2 = new Complex(Float.parseFloat(a2.getText()), Float.parseFloat(b2.getText()));


        LatexUtils.updateLatex(result, "z_{1} = " + z1.getPolarForm(), 32f);
        LatexUtils.updateLatex(result2, "z_{2} = " + z2.getPolarForm(), 32f);

        resetInputs();
    }

    private void initComponents() throws IOException, FontFormatException {

        complexNumbersTitle = new javax.swing.JLabel();
        result = LatexUtils.createLatexLabel("z = a + bi", 32f);
        result2 = LatexUtils.createLatexLabel("", 32f);
        btnRest = new javax.swing.JButton();
        btnSum = new javax.swing.JButton();
        btnMult = new javax.swing.JButton();
        btnDiv = new javax.swing.JButton();
        btnPolarForm = new javax.swing.JButton();
        b1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        a1 = new javax.swing.JTextField();
        plus1 = LatexUtils.createLatexLabel("+", 22f);
        lblZ2 = LatexUtils.createLatexLabel("z_{2} = ", 32f);
        b2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        a2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblZ1 = LatexUtils.createLatexLabel("z_{1} = ", 32f);
        lblError1 = new javax.swing.JLabel();
        lblError2 = new javax.swing.JLabel();

        setLayout(null);

        complexNumbersTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        complexNumbersTitle.setText("Números Complejos");
        add(complexNumbersTitle);
        complexNumbersTitle.setBounds(527, 21, 218, 29);

        add(result);
        result.setBounds(560, 450, 455, 29);

        result2.setBounds(560, 550, 455, 29);
        add(result2);

        btnRest.setText("Resta");
        add(btnRest);
        btnRest.setBounds(360, 260, 72, 23);

        btnSum.setText("Suma");
        add(btnSum);
        btnSum.setBounds(240, 260, 72, 23);

        btnMult.setText("Multiplicación");
        add(btnMult);
        btnMult.setBounds(500, 260, 130, 23);

        btnDiv.setText("División");
        add(btnDiv);
        btnDiv.setBounds(690, 260, 76, 23);

        btnPolarForm.setText("Forma Polar");
        add(btnPolarForm);
        btnPolarForm.setBounds(880, 260, 99, 23);
        add(b1);
        b1.setBounds(390, 140, 33, 29);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel4.setText("i");
        add(jLabel4);
        jLabel4.setBounds(430, 140, 14, 29);
        add(a1);
        a1.setBounds(310, 140, 33, 29);

        add(plus1);
        plus1.setBounds(360, 140, 18, 29);

        lblZ2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblZ2.setText("Z2 = ");
        add(lblZ2);
        lblZ2.setBounds(780, 140, 56, 29);

        add(b2);
        b2.setBounds(930, 140, 33, 29);

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel7.setText("i");
        add(jLabel7);
        jLabel7.setBounds(970, 140, 14, 29);

        add(a2);
        a2.setBounds(850, 140, 33, 29);

        jLabel8.setText("+");
        add(jLabel8);
        jLabel8.setBounds(900, 140, 18, 29);

        lblZ1.setText("Z1 = ");
        add(lblZ1);
        lblZ1.setBounds(240, 140, 56, 29);

        lblError1.setText("");
        add(lblError1);
        lblError1.setBounds(248, 110, 300, 29);

        lblError2.setText("");
        add(lblError2);
        lblError2.setBounds(248, 90, 300, 29);

        btnSum.addActionListener(e -> {
            onSumComplex();
        });

        btnRest.addActionListener(e -> {
            onSubstractComplex();
        });

        btnMult.addActionListener(e -> {
            onMultiplyComplex();
        });

        btnDiv.addActionListener(e -> {
            onDivideComplex();
        });

        btnPolarForm.addActionListener(e -> {
            onPolarForm();
        });
    }

    private javax.swing.JTextField a1;
    private javax.swing.JTextField a2;
    private javax.swing.JTextField b1;
    private javax.swing.JTextField b2;
    private javax.swing.JButton btnDiv;
    private javax.swing.JButton btnMult;
    private javax.swing.JButton btnPolarForm;
    private javax.swing.JButton btnRest;
    private javax.swing.JButton btnSum;
    private javax.swing.JLabel complexNumbersTitle;
    private javax.swing.JLabel result;
    private javax.swing.JLabel result2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel plus1;
    private javax.swing.JLabel lblZ2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblZ1;
    private javax.swing.JLabel lblError1;
    private javax.swing.JLabel lblError2;
}
