package Graphics;

import javax.swing.*;
import java.awt.*;

public abstract class ScrollPane {
    public static JScrollPane getScrollPane(JTable table){
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }

    public static void setScrollPane(JFrame frame, JScrollPane scrollPane){
        frame.getContentPane().add(scrollPane, BorderLayout.PAGE_START);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }
}
