package views;

import com.itd.math.Aritmetic;
import com.itd.math.SystemEquations;
import constants.CustomFont;
import utilities.CustomFonts;
import utilities.InputValidator;
import utilities.LatexUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EcuationsSystemView extends javax.swing.JPanel {
    public EcuationsSystemView() {
        try {
            initComponents();
        } catch (IOException | FontFormatException e) {
            Logger.getLogger(EcuationsSystemView.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void onSolve() {
        boolean x1Valid = InputValidator.numberFormatIsValid(xInputOne, lblError, "Por favor ingresa números válidos");
        boolean x2Valid = InputValidator.numberFormatIsValid(xInputTwo, lblError, "Por favor ingresa números válidos");
        boolean y1Valid = InputValidator.numberFormatIsValid(yInputOne, lblError, "Por favor ingresa números válidos");
        boolean y2Valid = InputValidator.numberFormatIsValid(yInputTwo, lblError, "Por favor ingresa números válidos");
        boolean z1Valid = InputValidator.numberFormatIsValid(zInputOne, lblError, "Por favor ingresa números válidos");
        boolean z2Valid = InputValidator.numberFormatIsValid(zInputTwo, lblError, "Por favor ingresa números válidos");

        if (!x1Valid || !x2Valid || !y1Valid || !y2Valid || !z1Valid || !z2Valid) return;

        try {
            List<Double> sols = SystemEquations.solve2x2(
                    Double.parseDouble(xInputOne.getText()),
                    Double.parseDouble(yInputOne.getText()),
                    Double.parseDouble(zInputOne.getText()),
                    Double.parseDouble(xInputTwo.getText()),
                    Double.parseDouble(yInputTwo.getText()),
                    Double.parseDouble(zInputTwo.getText()));

            LatexUtils.updateLatex(xResultLbl1, "x = " + Aritmetic.round(sols.getFirst()), 32f);
            LatexUtils.updateLatex(yResultLbl, "y = " + Aritmetic.round(sols.getLast()), 32f);

            InputValidator.resetStyles(xInputOne, lblError);
            InputValidator.resetStyles(yInputOne);
            InputValidator.resetStyles(zInputOne);
            InputValidator.resetStyles(xInputTwo);
            InputValidator.resetStyles(yInputTwo);
            InputValidator.resetStyles(zInputTwo);
        } catch (ArithmeticException e) {
            lblError.setText(e.getMessage());
        }
    }

    private void initComponents() throws IOException, FontFormatException {
        systemEcuationsTitle = new JLabel();
        bracket = new JLabel();
        plus2 = LatexUtils.createLatexLabel("+", 32f);
        yVar2 = LatexUtils.createLatexLabel("y", 32f);
        yVar1 = LatexUtils.createLatexLabel("y", 32f);
        equal2 = LatexUtils.createLatexLabel("=", 32f);
        plus1 = LatexUtils.createLatexLabel("+", 32f);
        equal1 = LatexUtils.createLatexLabel("=", 32f);
        xVar2 = LatexUtils.createLatexLabel("x", 32f);
        yResultLbl = LatexUtils.createLatexLabel("y = ", 32f);
        xVar3 = LatexUtils.createLatexLabel("x", 32f);
        xResultLbl1 = LatexUtils.createLatexLabel("x = ", 32f);
        xInputOne = new JTextField();
        xInputTwo = new JTextField();
        yInputOne = new JTextField();
        yInputTwo = new JTextField();
        zInputOne = new JTextField();
        zInputTwo = new JTextField();
        btnSolve = new JButton();
        lblError = new JLabel();

        setLayout(null);

        systemEcuationsTitle.setText("Sistemas de ecuaciones");
        systemEcuationsTitle.setFont(CustomFonts.getCustomFont(CustomFont.MERRIWEATHER, 24f));
        systemEcuationsTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(systemEcuationsTitle);
        systemEcuationsTitle.setBounds(495, 42, 347, 83);

        bracket.setFont(new java.awt.Font("Hiragino Sans GB", 0, 200)); // NOI18N
        bracket.setText("{");
        add(bracket);
        bracket.setBounds(337, 132, 89, 300);
        add(xInputTwo);
        xInputTwo.setBounds(440, 270, 49, 51);

        add(xInputOne);
        xInputOne.setBounds(440, 180, 52, 51);

        lblError.setBounds(443, 145, 500, 51);
        add(lblError);

        yResultLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(yResultLbl);
        yResultLbl.setBounds(490, 550, 200, 44);

        xVar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(xVar2);
        xVar2.setBounds(510, 280, 31, 44);
        add(yInputTwo);
        yInputTwo.setBounds(620, 270, 49, 51);

        add(yInputOne);
        yInputOne.setBounds(620, 180, 52, 51);

        plus2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(plus2);
        plus2.setBounds(570, 270, 31, 44);

        yVar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(yVar2);
        yVar2.setBounds(690, 280, 31, 44);

        yVar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(yVar1);
        yVar1.setBounds(690, 180, 31, 44);

        equal2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(equal2);
        equal2.setBounds(740, 270, 31, 44);

        plus1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(plus1);
        plus1.setBounds(570, 180, 31, 44);

        equal1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(equal1);
        equal1.setBounds(740, 180, 31, 44);
        add(zInputTwo);
        zInputTwo.setBounds(790, 270, 49, 51);

        add(zInputOne);
        zInputOne.setBounds(790, 180, 52, 51);

        btnSolve.setText("Resolver");
        btnSolve.addActionListener(e -> onSolve());
        add(btnSolve);
        btnSolve.setBounds(600, 390, 100, 21);

        xVar3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        xVar3.setBounds(510, 180, 31, 44);
        add(xVar3);

        xResultLbl1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(xResultLbl1);
        xResultLbl1.setBounds(490, 490, 200, 44);

        xInputOne.setFont(CustomFonts.getCustomFont(CustomFont.LATO, 25));
        xInputTwo.setFont(CustomFonts.getCustomFont(CustomFont.LATO, 25));
        yInputOne.setFont(CustomFonts.getCustomFont(CustomFont.LATO, 25));
        yInputTwo.setFont(CustomFonts.getCustomFont(CustomFont.LATO, 25));
        zInputOne.setFont(CustomFonts.getCustomFont(CustomFont.LATO, 25));
        zInputTwo.setFont(CustomFonts.getCustomFont(CustomFont.LATO, 25));
    }

    private JLabel bracket;
    private JButton btnSolve;
    private JLabel equal1;
    private JLabel equal2;
    private JLabel plus1;
    private JLabel plus2;
    private JLabel systemEcuationsTitle;
    private JTextField xInputOne;
    private JTextField xInputTwo;
    private JLabel xResultLbl1;
    private JLabel xVar2;
    private JLabel xVar3;
    private JTextField yInputOne;
    private JTextField yInputTwo;
    private JLabel yResultLbl;
    private JLabel yVar1;
    private JLabel yVar2;
    private JTextField zInputOne;
    private JTextField zInputTwo;
    private JLabel lblError;
}
