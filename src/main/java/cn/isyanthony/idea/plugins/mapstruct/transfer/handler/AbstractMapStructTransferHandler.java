package cn.isyanthony.idea.plugins.mapstruct.transfer.handler;

import cn.isyanthony.idea.plugins.mapstruct.transfer.model.GenerateContext;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;

/**
 *
 * @author: Syanthony
 * @Date: 2023/5/1
 * @Version: 1.0.0
 */
public abstract class AbstractMapStructTransferHandler {

    public void doGenerateTransfer(Project project,
                                   DataContext dataContext,
                                   PsiFile psiFile) {
        GenerateContext context = getGenerateContext(project, dataContext, psiFile);

    }

    public abstract GenerateContext getGenerateContext(Project project,
                                                       DataContext dataContext,
                                                       PsiFile psiFile);


}
