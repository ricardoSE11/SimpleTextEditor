
package abctexteditor;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class ChangesDocumentListener implements DocumentListener {

    private boolean detectedChanges;

    public ChangesDocumentListener() {
        this.detectedChanges = false;
    }

    public boolean detectedChanges() {
        return detectedChanges;
    }

    public void setDetectedChanges(boolean detectedChange) {
        this.detectedChanges = detectedChange;
    }
    
    
    
    @Override
    public void insertUpdate(DocumentEvent de) {
        //System.out.println("Editor log: Document listener detected new characters");
        this.detectedChanges = true;
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        //System.out.println("Editor log: Document listener detected remove of characters");
        this.detectedChanges = true;
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        System.out.println("Reporting a change in styles");
    }
    
}
