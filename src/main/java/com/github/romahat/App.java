package com.github.romahat;

import org.eclipse.jface.widgets.WidgetFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class App {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        // Create the layout.
        RowLayout layout = new RowLayout();
        // Optionally set layout fields.
        layout.wrap = true;
        // Set the layout into the composite.
        shell.setLayout(layout);
        // Create the children of the composite.
        final Button button = new Button(shell, SWT.PUSH);
        button.setText("B1");
        button.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
                if (e.type == SWT.Selection) {
                    System.out.println("Button pressed");
                }
            }
        });
        new Button(shell, SWT.PUSH).setText("Wide Button 2");
        new Button(shell, SWT.PUSH).setText("Button 3");
        WidgetFactory
                .button(SWT.PUSH)
                .text("Press me")
                .onSelect(selectionEvent -> System.out.println("Pressed!"))
                .create(shell);
        shell.pack();
        shell.open();

        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
