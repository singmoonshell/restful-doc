package com.tiger.util;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;


/**
 * Controller工具类
 *
 * @author wangheng
 * @date 2020-08-22
 */
public class ControllerUtil {

    public static final String ANNOTATION_RESCONTROLLER = "org.springframework.web.bind.annotation.RestController";

    public static final String ANNOTATION_POSTMAPPING = "org.springframework.web.bind.annotation.PostMapping";

    public static final String ANNOTATION_GETMAPPING = "org.springframework.web.bind.annotation.GetMapping";

    public static final String ANNOTATION_REQUESTMAPPING = "org.springframework.web.bind.annotation.RequestMapping";

    //public static final String ANNOTATION_REQUESTBODY = "org.springframework.web.bind.annotation.RequestBody";

    /**
     * 判断选中的是否是controller类
     *
     * @param e 事件
     * @return
     */
    public static PsiClass getControllerClass(AnActionEvent e) {
        if (dataIsNotNull(e)) {
            return null;
        }
        PsiElement psiElement = CommonDataKeys.PSI_ELEMENT.getData(e.getDataContext());
        if (psiElement instanceof PsiClass && PsiUtil.getPsiAnnotation((PsiClass) psiElement, ANNOTATION_RESCONTROLLER) != null) {
            return (PsiClass) psiElement;
        }
        return null;
    }

    /**
     * 判断选中的是否是controller类中的接口方法
     *
     * @param e 事件
     * @return
     */
    public static PsiMethod getControllerMethod(AnActionEvent e) {
        if (dataIsNotNull(e)) {
            return null;
        }
        PsiElement psiElement = CommonDataKeys.PSI_ELEMENT.getData(e.getDataContext());
        if (psiElement instanceof PsiMethod) {
            PsiMethod psiMethod = (PsiMethod) psiElement;
            PsiElement parent = psiMethod.getParent();
            if (parent instanceof PsiClass && PsiUtil.getPsiAnnotation((PsiClass) parent, ANNOTATION_RESCONTROLLER) != null
                    && (PsiUtil.getPsiAnnotation(psiMethod, ANNOTATION_POSTMAPPING) != null
                    || PsiUtil.getPsiAnnotation(psiMethod, ANNOTATION_GETMAPPING) != null
                    || PsiUtil.getPsiAnnotation(psiMethod, ANNOTATION_REQUESTMAPPING) != null)) {
                return psiMethod;
            }
        }
        return null;
    }

    /**
     * 判断事件选中的是data是否为null
     *
     * @param e 事件
     * @return
     */
    private static boolean dataIsNotNull(AnActionEvent e) {
        if (e == null) {
            return true;
        }
        DataContext dataContext = e.getDataContext();
        return CommonDataKeys.EDITOR.getData(dataContext) == null;
    }
}
