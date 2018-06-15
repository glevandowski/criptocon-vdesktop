package util;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

 public class HintText implements FocusListener, DocumentListener, PropertyChangeListener {
        private  JTextField textCoin;
        private boolean isEmpty;
        private Color hintColor;
        private Color foregroundColor;
        private String hintText;

        public HintText(final JTextField textfield, String ghostText) {
            super();
            this.textCoin = textfield;
            this.hintText = ghostText;
            this.hintColor = Color.LIGHT_GRAY;
            textfield.addFocusListener(this);
            registerListeners();
            updateState();
            if (!this.textCoin.hasFocus()) {
                focusLost(null);
            }
        }

        public void delete() {
            unregisterListeners();
            textCoin.removeFocusListener((FocusListener) this);
        }

        private void registerListeners() {
            textCoin.getDocument().addDocumentListener((DocumentListener) this);
            textCoin.addPropertyChangeListener("foreground", (PropertyChangeListener) this);
        }

        private void unregisterListeners() {
            textCoin.getDocument().removeDocumentListener(this);
            textCoin.removePropertyChangeListener("foreground", this);
        }

    /**
     *
     * @return colorCoin
     */
    public Color getHintColor() {
            return hintColor;
        }

    /**
     *
     * @param hintColor
     */
    public void setHintColor(Color hintColor) {
            this.hintColor = hintColor;
        }

        private void updateState() {
            isEmpty = textCoin.getText().length() == 0;
            foregroundColor = textCoin.getForeground();
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (isEmpty) {
                unregisterListeners();
                try {
                    textCoin.setText("");
                    textCoin.setForeground(foregroundColor);
                } finally {
                    registerListeners();
                }
            }

        }

        @Override
        public void focusLost(FocusEvent e) {
            if (isEmpty) {
                unregisterListeners();
                try {
                    textCoin.setText(hintText);
                    textCoin.setForeground(hintColor);
                } finally {
                    registerListeners();
                }
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            updateState();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateState();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateState();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateState();
        }

    }
