package views;

import com.itd.math.Aritmetic;
import com.itd.math.SecondGradeEquation;
import constants.CustomFont;
import utilities.CharacterFilter;
import utilities.CustomFonts;
import utilities.InputValidator;
import utilities.LatexUtils;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class SecondGradeEcuations extends JPanel {
    JLabel secondGradeForm = LatexUtils.createLatexLabel("x_{1,2} = \\frac{-b \\pm \\sqrt{b^2 - 4ac}}{2a}", 25);
    JLabel secondGradeEcuationsTitle = new JLabel("Por favor ingrese los valores");
    JLabel x2 = LatexUtils.createLatexLabel("x^{2}", 25);
    JLabel x = LatexUtils.createLatexLabel("x", 25);
    JLabel plusOne = LatexUtils.createLatexLabel("+", 25);
    JLabel plusTwo = LatexUtils.createLatexLabel("+", 25);
    JLabel lblError = new JLabel("");

    JLabel firstResultLabel = LatexUtils.createLatexLabel("x_{1} = ", 25);
    JLabel secondResultLabel = LatexUtils.createLatexLabel("x_{2} = ", 25);

    JTextField inputA = new JTextField();
    JTextField inputB = new JTextField();
    JTextField inputC = new JTextField();

    JButton btnCalculate = new JButton("Calcular");

    SecondGradeEcuations() throws IOException, FontFormatException {
        initComponents();
    }

    public void onSolve() {

        boolean a1Valid = InputValidator.numberFormatIsValid(inputA, lblError, "Ingresa números válidos");
        boolean b2Valid = InputValidator.numberFormatIsValid(inputB, lblError, "Ingresa números válidos");
        boolean c1Valid = InputValidator.numberFormatIsValid(inputC, lblError, "Ingresa números válidos");

        if (!a1Valid || !b2Valid || !c1Valid) return;

        List<Double> sols = SecondGradeEquation.solveQuadraticEquation(
                Float.parseFloat(inputA.getText()),
                Float.parseFloat(inputB.getText()),
                Float.parseFloat(inputC.getText())
        );

        if (sols.isEmpty()) lblError.setText("La ecuación no tiene soluciones reales");
        else {
            lblError.setText("");
            LatexUtils.updateLatex(firstResultLabel, "x_{1} = " + Aritmetic.round(sols.getFirst()), 25);
            LatexUtils.updateLatex(secondResultLabel, "x_{2} = " + Aritmetic.round(sols.getLast()), 25);
        }

    }

    public void initComponents() {
        setLayout(null);
        secondGradeEcuationsTitle.setBounds(473, 120, 345, 30);
        secondGradeForm.setBounds(535, 400, 221, 57);

        plusOne.setBounds(562, 222, 27, 30);
        plusTwo.setBounds(717, 222, 27, 30);

        x2.setBounds(481, 222, 27, 30);
        x.setBounds(651, 222, 27, 27);

        inputA.setBounds(444, 222, 35, 30);
        lblError.setBounds(444, 190, 400, 30);
        inputB.setBounds(614, 222, 35, 30);
        inputC.setBounds(768, 222, 35, 30);

        btnCalculate.setBounds(607, 321, 70, 19);

        btnCalculate.addActionListener(_ -> onSolve());

        firstResultLabel.setBounds(535, 489, 221, 57);
        secondResultLabel.setBounds(535, 539, 221, 57);

        try {
            secondGradeEcuationsTitle.setFont(CustomFonts.getCustomFont(CustomFont.MERRIWEATHER, 24));
            inputA.setFont(CustomFonts.getCustomFont(CustomFont.LATO, 25));
            inputB.setFont(CustomFonts.getCustomFont(CustomFont.LATO, 25));
            inputC.setFont(CustomFonts.getCustomFont(CustomFont.LATO, 25));

            ((AbstractDocument) inputA.getDocument()).setDocumentFilter(new CharacterFilter(2));
            ((AbstractDocument) inputB.getDocument()).setDocumentFilter(new CharacterFilter(2));
            ((AbstractDocument) inputC.getDocument()).setDocumentFilter(new CharacterFilter(2));
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }
        add(secondGradeForm);
        add(secondGradeEcuationsTitle);
        add(x2);
        add(x);
        add(plusOne);
        add(plusTwo);

        add(inputA);
        add(inputB);
        add(inputC);

        add(btnCalculate);

        add(firstResultLabel);
        add(secondResultLabel);
        add(lblError);
    }
}
