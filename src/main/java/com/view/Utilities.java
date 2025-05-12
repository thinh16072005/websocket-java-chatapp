package com.view;

import javax.swing.border.EmptyBorder;
import java.awt.*;

interface Utilities {
    Color TRANSPARENT_COLOR = new Color(0, 0, 0, 0);
    Color PRIMARY_COLOR = Color.decode("#2F2D2D");
    Color SECONDARY_COLOR = Color.decode("#484444");
    Color TEXT_COLOR = Color.WHITE;

    static EmptyBorder addPadding(int top, int left, int bottom, int right) {
        return new EmptyBorder(top, left, bottom, right);
    }
}
