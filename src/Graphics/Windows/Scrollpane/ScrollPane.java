package Graphics.Windows.Scrollpane;

import javax.swing.*;
import java.awt.*;

public abstract class ScrollPane {
    public static JScrollPane getScrollPane(JTable table){
        return new JScrollPane(table);
    }

    public static void setScrollPane(JFrame frame, JScrollPane scrollPane){
        frame.getContentPane().add(scrollPane, BorderLayout.PAGE_START);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }
}
