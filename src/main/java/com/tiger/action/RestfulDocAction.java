package com.tiger.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiMethod;
import com.tiger.generator.RestDocumentGenerator;
import com.tiger.util.ControllerUtil;
import com.tiger.window.TextDialog;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

/**
 * RestfulDocAction
 *
 * @author wangheng
 * @date 2020-08-22
 */
public class RestfulDocAction extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent e) {
        super.update(e);
        //如果选择的不是Controller接口方法或者Controller接口类，不显示生成文档的选项
        e.getPresentation().setVisible(ControllerUtil.getControllerClass(e) != null || ControllerUtil.getControllerMethod(e) != null);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        //显示文档
        openDialog(generateDocumentContent(e));
    }

    /**
     * 生成restful 文档
     */
    private String generateDocumentContent(@NotNull AnActionEvent e) {
        //生成方法接口文档
        PsiMethod psiMethod = ControllerUtil.getControllerMethod(e);
        if (psiMethod != null) {
            return RestDocumentGenerator.generateMethodDoc(psiMethod);
        }
        //生成类接口文档
        PsiClass psiClass = ControllerUtil.getControllerClass(e);
        if (psiClass != null) {
            return RestDocumentGenerator.generateClassDoc(psiClass);
        }
        throw new RuntimeException("Unsupported type");
    }

    /**
     * 弹出文本展示框
     */
    private void openDialog(String documentContent) {
        //获取屏幕的大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) (screenSize.width * 0.3);
        int h = (int) (screenSize.height * 0.3);

        TextDialog dialog = new TextDialog(documentContent);
        dialog.pack();
        dialog.setSize(w, h);
        dialog.setLocation((int) (screenSize.width * 0.5) - (int) (w * 0.5), (int) (screenSize.height * 0.5) - (int) (h * 0.5));
        dialog.setVisible(true);
    }
}
