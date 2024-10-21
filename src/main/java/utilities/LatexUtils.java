package utilities;

import constants.CustomFont;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LatexUtils {
    public static JLabel createLatexLabel(String latex, float size) throws IOException, FontFormatException {
        TeXFormula formula = new TeXFormula(latex);
        TeXIcon icon = formula.createTeXIcon(TeXFormula.SERIF, size);  // Ajusta el tamaño de la fuente

        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }

    public static void updateLatex(JLabel label, String latex, float size) {
        TeXFormula formula = new TeXFormula(latex);
        TeXIcon icon = formula.createTeXIcon(TeXFormula.SERIF, size);

        label.setIcon(icon);
    }
}
