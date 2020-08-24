package com.tiger.generator;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiMethod;
import com.tiger.util.ConvertUtil;
import org.jetbrains.annotations.NotNull;

/**
 * restful文档生成器
 *
 * @author wangheng
 * @date 2020-08-22
 */
public class RestDocumentGenerator {

    /**
     * 生成方法的接口文档
     *
     * @param controllerPsiMethod psi方法
     * @return 文件字符串
     */
    public static String generateMethodDoc(@NotNull PsiMethod controllerPsiMethod) {
        return ConvertUtil.psiMethodToDoc(controllerPsiMethod);
    }

    /**
     * 生成类的接口文档
     *
     * @param controllerPsiClass psi类
     * @return 文档字符串
     */
    public static String generateClassDoc(@NotNull PsiClass controllerPsiClass) {
        //todo
        return null;
    }
}
