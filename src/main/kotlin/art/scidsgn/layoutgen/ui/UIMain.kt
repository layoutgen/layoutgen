package art.scidsgn.layoutgen.ui

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import java.io.File
import java.nio.file.Path

class UIMain : Application() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(UIMain::class.java)
        }
    }

    override fun start(primaryStage: Stage) {
        val ruleCodePath = Path.of(
            {}.javaClass.classLoader.getResource(
                "rulecode/flexbox.rulecode"
            )!!.toURI()
        ).toString()

        val scene = Scene(makeDocumentView(ruleCodePath), 1024.0, 768.0)
        scene.stylesheets.add(javaClass.classLoader.getResource("stylesheets/styles.css").toExternalForm())

        primaryStage.scene = scene
        primaryStage.title = "LayoutGen"
        primaryStage.show()
    }

    private fun makeDocumentView(filePath: String): DocumentView {
        return DocumentView(filePath, File(filePath).readText())
    }
}