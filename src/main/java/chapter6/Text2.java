package chapter6;

import java.util.Set;

/**
 * Created by Administrator on 2016/3/16.
 */
public class Text2 {
    public enum Style {
        STYLE_BOLD,
        STYLE_ITALIC,
        STYLE_UNDERLINE,
        STYLE_STRIKETHROUGH;
    }

    public void applyStyles(Set<Style> styles) {
        for (Style style : styles)
            System.out.println(style);
    }
}
