package art.scidsgn.layoutgen.ui

import art.scidsgn.layoutgen.ui.editor.CodeEditor
import javafx.scene.control.SplitPane

class DocumentView(val filePath: String, val fileContents: String) : SplitPane() {
    val codeEditor = CodeEditor(fileContents)

    init {
        initCodeEditor()
    }

    private fun initCodeEditor() {
        items.add(codeEditor)
    }
}