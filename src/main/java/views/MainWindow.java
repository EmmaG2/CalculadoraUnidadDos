package views;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainWindow extends JFrame {

    MainWindow() throws IOException, FontFormatException {
        super("Forms Solver");
        setSize(new Dimension(1280, 800));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Ecuaciones de segundo grado", new SecondGradeEcuations());
        tabbedPane.addTab("Sistema de ecuaciones 2x2", new EcuationsSystemView());
        tabbedPane.addTab("Números complejos", new ComplexNumbers());
        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new MainWindow().setVisible(true);
            } catch (IOException | FontFormatException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
