package com.tiger.parser;

import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiMethod;
import com.tiger.canstant.RequestType;
import com.tiger.definition.FieldDefinition;
import com.tiger.definition.MethodDefinition;
import com.tiger.util.JavaDocUtil;
import com.tiger.util.PsiUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author wangheng
 * @date 2020-08-24
 **/
public class MethodParser implements Parser<MethodDefinition> {

    private PsiMethod psiMethod;

    private Integer index;

    public MethodParser(@NotNull PsiMethod psiMethod, Integer index) {
        this.psiMethod = psiMethod;
        this.index = index;
    }

    @Override
    public MethodDefinition parseDefinition() {
        MethodDefinition methodDefinition = new MethodDefinition();
        methodDefinition.setIndex(index);
        methodDefinition.setMethodName(psiMethod.getName());
        methodDefinition.setDesc(JavaDocUtil.getText(psiMethod.getDocComment()));
        methodDefinition.setRequestType(getRequestType(psiMethod));
        methodDefinition.setUrl(getUrl(psiMethod));
        methodDefinition.setRequest(getRequestParamsDefinitions());
        methodDefinition.setResponse(getResponseDefinitions());
        return methodDefinition;
    }

    /**
     * 获得参数请求参数
     *
     * @return
     */
    private List<FieldDefinition> getRequestParamsDefinitions() {

        return null;
    }

    private List<FieldDefinition> getResponseDefinitions() {
        return null;
    }


    /**
     * 获取方法的请求类型
     *
     * @param psiMethod
     * @return
     */
    public static RequestType getRequestType(@NotNull PsiMethod psiMethod) {
        for (RequestType requestType : RequestType.values()) {
            if (PsiUtil.getPsiAnnotation(psiMethod, requestType.getAnnotation()) != null) {
                return requestType;
            }
        }
        throw new RuntimeException("Unsupported annotation");
    }

    /**
     * 获取方法接口的url
     *
     * @param psiMethod
     * @return
     */
    public static String getUrl(@NotNull PsiMethod psiMethod) {
        PsiAnnotation annotation = PsiUtil.getPsiAnnotation(psiMethod, getRequestType(psiMethod).getAnnotation());
        String methodUrlPart = getPartOfUrl(annotation);


        PsiAnnotation clzReqMapAn = PsiUtil.getPsiAnnotation(psiMethod.getContainingClass(), RequestType.ALL.getAnnotation());
        String classUrlPart = getPartOfUrl(clzReqMapAn);

        return (classUrlPart + methodUrlPart).replace("//", "/");
    }

    /**
     * 获得方法级别的Uri
     *
     * @param annotation
     * @return
     */
    public static String getPartOfUrl(PsiAnnotation annotation) {
        String path = PsiUtil.getPsiAnnotationValueByAttr(annotation, "path");
        String val = PsiUtil.getPsiAnnotationValueByAttr(annotation, "value");
        String resultPath = path.length() <= 0 ? val : path;
        return resultPath.length() > 0 ? resultPath : "";
    }
}
