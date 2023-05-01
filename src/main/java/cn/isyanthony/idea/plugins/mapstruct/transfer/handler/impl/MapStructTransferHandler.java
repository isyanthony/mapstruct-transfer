package cn.isyanthony.idea.plugins.mapstruct.transfer.handler.impl;

import cn.isyanthony.idea.plugins.mapstruct.transfer.handler.AbstractMapStructTransferHandler;
import cn.isyanthony.idea.plugins.mapstruct.transfer.model.GenerateContext;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapStructTransferHandler extends AbstractMapStructTransferHandler {
    @Override
    public GenerateContext getGenerateContext(Project project,
                                              DataContext dataContext,
                                              PsiFile psiFile) {

        //System.out.printf("[GenerateContext] params -> project: {}, dataContext: {}, psiFile: {}", project,
        //         dataContext, psiFile);;
        // 基础信息
        Editor editor = CommonDataKeys.EDITOR.getData(dataContext);
        PsiElement psiElement = CommonDataKeys.PSI_ELEMENT.getData(dataContext);
        assert editor != null;
        Document document = editor.getDocument();

        //if (psiFile instanceof PsiJavaFileImpl javaFile) {
        //    javaFile.getImportList();
        //}

        // 封装生成对象上下文
        GenerateContext generateContext = new GenerateContext();
        generateContext.setProject(project);
        generateContext.setPsiFile(psiFile);
        generateContext.setDataContext(dataContext);
        generateContext.setEditor(editor);
        generateContext.setPsiElement(psiElement);
        generateContext.setOffset(editor.getCaretModel().getOffset());
        generateContext.setDocument(document);
        generateContext.setLineNumber(document.getLineNumber(generateContext.getOffset()));
        generateContext.setStartOffset(
                document.getLineStartOffset(generateContext.getLineNumber()));
        generateContext.setEditorText(document.getCharsSequence());

        //System.out.println("[ContextGenerate] context :" + generateContext);
        log.info("[GenerateContext] res -> context: {}", generateContext);
        return generateContext;
    }
}
