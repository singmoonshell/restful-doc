package com.tiger.util;

import com.intellij.psi.PsiMethod;
import com.tiger.definition.MethodDefinition;
import com.tiger.parser.MethodParser;
import org.jetbrains.annotations.NotNull;

/**
 * @author wangheng
 * @date 2020-08-24
 **/
public class ConvertUtil {

    /**
     * controller的方法生成MD文档
     *
     * @param psiMethod psi方法
     * @return 文档字符串
     */
    public static String psiMethodToDoc(@NotNull PsiMethod psiMethod) {
        //从PsiMethod提取有用的信息
        MethodParser methodParser = new MethodParser(psiMethod, 1);
        MethodDefinition methodDefinition = methodParser.parseDefinition();
        //将有用的信息生成文档
        return methodDefinitionToDac(methodDefinition);
    }

    /**
     * 将自定义的MethodDefinition生成MD文档
     *
     * @param methodDefinition 提取出来的方法信息
     * @return MD文档字符串
     */
    private static String methodDefinitionToDac(MethodDefinition methodDefinition) {
        StringBuilder doc = new StringBuilder();
        doc.append("### <a name=\"").append(methodDefinition.getIndex()).append("\">")
                .append(methodDefinition.getIndex() + ".")
                .append(methodDefinition.getDesc().trim())
                .append("</a>")
                .append("\n")
                .append("    ")
                .append(methodDefinition.getRequestType().getDesc())
                .append("    ")
                .append(methodDefinition.getUrl())
                .append("\n")
                .append("| 参数      | 类型 | 必需 | 说明   |\n" +
                        "| --------- | ---- | ---- | ------ |\n" +
                        "| accountId | Long | true | 账号id |");
        //todo
        return doc.toString();
    }
}
