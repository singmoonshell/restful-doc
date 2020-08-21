package com.tiger.window;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

/**
 * 文本对话框
 *
 * @author wangheng
 * @date 2020-08-22
 */
public class TextDialog extends JDialog {
    private JPanel contentPane;
    private JButton copyButton;
    private JButton cancelButton;
    private JTextArea textArea;

    public TextDialog(String documentContent) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(copyButton);
        textArea.setText(documentContent);

        //注册取消按钮事件
        cancelButton.addActionListener(e -> cancel());
        //注册复制按钮事件
        copyButton.addActionListener(e -> copy());


        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //注册WindowEvent
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cancel();
            }
        });
        contentPane.registerKeyboardAction(e -> cancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * 复制文档，然后关闭窗口
     */
    private void copy() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(this.textArea.getText());
        clipboard.setContents(selection, null);
        dispose();
    }

    /**
     * 关闭窗口
     */
    private void cancel() {
        dispose();
    }
}
