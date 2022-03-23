package ui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DragMouseAdapter extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        JComponent component = (JComponent) e.getSource();
        TransferHandler handler = component.getTransferHandler();
        handler.exportAsDrag(component, e, TransferHandler.COPY);
    }

}
