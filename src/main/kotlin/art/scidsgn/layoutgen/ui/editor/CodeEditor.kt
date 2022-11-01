package art.scidsgn.layoutgen.ui.editor

import org.fxmisc.richtext.CodeArea
import org.fxmisc.richtext.LineNumberFactory

class CodeEditor(val initialText: String) : CodeArea() {
    init {
        paragraphGraphicFactory = LineNumberFactory.get(this)

        replaceText(initialText)
    }
}