package constants;

public enum CustomFont {
    MERRIWEATHER("/Users/emmanuelgranados/Desktop/Programacion/java/CalculadoraUnidadDos/src/main/resources/fonts/Merriweather_Sans/static/MerriweatherSans-Regular.ttf"),
    LATO("/Users/emmanuelgranados/Desktop/Programacion/java/CalculadoraUnidadDos/src/main/resources/fonts/Lato/Lato-Regular.ttf"),
    ROBOTO("/Users/emmanuelgranados/Desktop/Programacion/java/CalculadoraUnidadDos/src/main/resources/fonts/Roboto/Roboto-Regular.ttf");

    private final String fontName;

    CustomFont(String fontName) {
        this.fontName = fontName;
    }

    public String getFontName() {
        return fontName;
    }
}
