package com.github.romahat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class AppLabel {

    static String newLine = System.getProperty("line.separator");
    private static Label positiongLabel;
    private static Shell shell;
    public static void main(String[] args) {
        Display display = new Display();
        shell = new Shell(display);

        positiongLabel = new Label(shell, SWT.BORDER);

        int x= 60;
        int y=20;
        int width =400;
        int height=200;

        positiongLabel.setBounds(x, y, width, height);
        positiongLabel.setBackground(new Color(255, 255,127));
        int toolbarSize = 80;

        shell.setBounds(0, 0, width+2*x , height + 2*y +toolbarSize);
        shell.setBackground(new Color(0,0,255));
        shell.open();



        shell.addMouseMoveListener(AppLabel::showSize);
        positiongLabel.addMouseMoveListener(AppLabel::showSize);

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    public static void showSize(MouseEvent e) {
        int x = e.x;
        int y = e.y;
        String s = "Bounds for Label: " + positiongLabel.getBounds() + newLine;
        s+= "Bounds for Shell: " + shell.getBounds()  + newLine;
        s+= "Mouse pointer: " + x + " " + y;
        positiongLabel.setText(s);

    }
}
