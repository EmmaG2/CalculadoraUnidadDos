package utilities;

import constants.CustomFont;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CustomFonts {
    public static Font getCustomFont(CustomFont path, float size) throws IOException, FontFormatException {
        File fontFile = new File(path.getFontName());
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(size); // Tamaño 24

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);

        return customFont;
    }
}
