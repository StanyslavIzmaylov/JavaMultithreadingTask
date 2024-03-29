package com.javarush.task.task32.task3209;


import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private UndoManager undoManager = new UndoManager();
    private Controller controller;
    private UndoListener undoListener = new UndoListener(undoManager);

    public void undo(){
        try {
            undoManager.undo();
        }
        catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
    public void redo(){
        try {
            undoManager.redo();
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        switch (actionEvent.getActionCommand()){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
        }
    }

    public void init() {
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);
        getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }
    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane htmlScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", htmlScrollPane);

        JScrollPane plainScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", plainScrollPane);

        tabbedPane.setPreferredSize(new Dimension(300, 300));

        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }


    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void selectedTabChanged() {
        switch (tabbedPane.getSelectedIndex()) {
            case 0:
                controller.setPlainText(plainTextPane.getText());
                break;
            case 1:
                plainTextPane.setText(controller.getPlainText());
                break;
        }
        resetUndo();
    }
    public boolean canUndo(){

        return undoManager.canUndo();
    }
    public boolean isHtmlTabSelected(){
       return tabbedPane.getSelectedIndex() == 0;
    }
    public boolean canRedo(){
        return undoManager.canRedo();
    }
    public void resetUndo(){
        undoManager.discardAllEdits();
    }
    public void selectHtmlTab(){
       tabbedPane.setSelectedIndex(0);
       resetUndo();
    }
    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }
    public void showAbout(){
        JOptionPane.showMessageDialog(this, "Лучший HTML редактор", "О программе", JOptionPane.INFORMATION_MESSAGE);
    }

}