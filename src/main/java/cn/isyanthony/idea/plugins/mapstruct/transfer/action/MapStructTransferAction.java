package cn.isyanthony.idea.plugins.mapstruct.transfer.action;

import cn.isyanthony.idea.plugins.mapstruct.transfer.handler.impl.MapStructTransferHandler;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.psi.PsiFile;

public class MapStructTransferAction extends AnAction {

    MapStructTransferHandler handler = new MapStructTransferHandler();
    @Override
    public void actionPerformed(AnActionEvent e) {

        // TODO: insert action logic here
        System.out.println("Hello World~ Idea Plugins");
        //// 获取当前正在操作的工程
        //Project project = e.getData(PlatformDataKeys.PROJECT);
        //
        //// 获取正在操作的文件
        //PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);

        // 当前操作文件的全限定类名
        //String classPath = psiFile.getVirtualFile().getPath();

        PsiFile file = e.getData(LangDataKeys.PSI_FILE);
        handler.getGenerateContext(e.getProject(), e.getDataContext(), file);
    }
}
