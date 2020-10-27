package tasks;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public final class ProgressReporter {
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private int progress = 0;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void accumulateProgress(int progress){
        this.propertyChangeSupport.firePropertyChange("progress", this.progress, this.progress + progress);
        this.progress += progress;
    }

    public int getProgress() {
        return progress;
    }
}