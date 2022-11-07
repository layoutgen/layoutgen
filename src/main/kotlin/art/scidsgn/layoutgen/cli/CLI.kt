package art.scidsgn.layoutgen.cli

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.sizing.Dimensions
import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.interpreter.Interpreter
import art.scidsgn.layoutgen.layout.LayoutEngine
import art.scidsgn.layoutgen.ruletree.RuletreeEnvironment
import art.scidsgn.layoutgen.ruletree.depsgraph.Depsgraph
import art.scidsgn.layoutgen.ruletree.parsers.antlr.AntlrRuletreeGenerator
import art.scidsgn.layoutgen.visual.VisualTreeRenderer
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import java.nio.file.FileSystems
import java.nio.file.Path
import java.nio.file.StandardWatchEventKinds
import javax.imageio.ImageIO
import kotlin.io.path.Path
import kotlin.io.path.extension
import kotlin.random.Random

data class CLI(
    val inputPath: String,
    val outputPath: String,
    var width: Int,
    var height: Int,
    var seed: Int,
    var depth: Int,
    var watch: Boolean
) {
    companion object {
        fun fromArgs(args: Array<String>): CLI {
            var inputPath: String? = null
            var outputPath: String? = null
            var width = 1024
            var height = 1024
            var seed = Random.nextInt()
            var depth = 16
            var watch = false

            var i = 0

            while (i < args.size) {
                when (args[i]) {
                    "-i", "--input" -> {
                        inputPath = File(args[i + 1]).absolutePath
                        i += 1
                    }

                    "-o", "--output" -> {
                        outputPath = args[i + 1]
                        i += 1
                    }

                    "-w", "--width" -> {
                        width = args[i + 1].toInt()
                        if (width <= 0) {
                            throw GeneralError(Errors.CLI_WIDTH_CANNOT_BE_LESS_THAN_ONE)
                        }

                        i += 1
                    }

                    "-h", "--height" -> {
                        height = args[i + 1].toInt()
                        if (height <= 0) {
                            throw GeneralError(Errors.CLI_HEIGHT_CANNOT_BE_LESS_THAN_ONE)
                        }

                        i += 1
                    }

                    "-s", "--seed" -> {
                        seed = args[i + 1].toInt()
                        i += 1
                    }

                    "-d", "--depth" -> {
                        depth = args[i + 1].toInt()
                        i += 1
                    }

                    "--watch" -> {
                        watch = true
                    }

                    else -> throw GeneralError(Errors.CLI_UNKNOWN_ARGUMENT, arrayOf(args[i]))
                }
                i += 1
            }

            return CLI(
                inputPath ?: throw GeneralError(Errors.CLI_INPUT_PATH_NOT_PRESENT),
                outputPath ?: "$inputPath.png",
                width, height, seed, depth, watch
            )
        }
    }

    private fun executeRulecode(): Component {
        val environment = RuletreeEnvironment(AntlrRuletreeGenerator)
        val ruleTree = environment.loadFile(inputPath)


        val rootRule = ruleTree.getRootRule()
        Depsgraph(environment).markCycles(rootRule)

        val interpreter = Interpreter(
            Random(seed), depth
        )

        val output = interpreter.execute(rootRule)
        if (output.size != 1) {
            throw GeneralError(Errors.CLI_ROOT_MUST_BE_A_SINGLE_COMPONENT)
        } else if (output.none { it is Component }) {
            throw GeneralError(Errors.CLI_ROOT_MUST_BE_A_COMPONENT)
        }

        return output[0] as Component
    }

    private fun renderComponent(root: Component): BufferedImage {
        LayoutEngine.resetLayout(root)
        LayoutEngine.layOut(root, Dimensions(width.toDouble(), height.toDouble()))

        return VisualTreeRenderer(root).render()
    }

    private fun saveImage(image: BufferedImage) {
        val allowedExtensions = ImageIO.getWriterFileSuffixes().toList()
        val extension = Path(outputPath).extension

        if (extension !in allowedExtensions) {
            throw GeneralError(Errors.CLI_IMAGE_UNKNOWN_EXTENSION, arrayOf(extension))
        }

        try {
            ImageIO.write(image, extension, File(outputPath))
        } catch (e: IOException) {
            throw GeneralError(Errors.CLI_IMAGE_COULD_NOT_SAVE)
        }
    }

    private fun execute() {
        try {
            saveImage(renderComponent(executeRulecode()))
        } catch (e: Throwable) {
            System.err.println(e)
        }
    }

    private fun watch() {
        // TODO: continue
        val dirPath = Path.of(inputPath).parent
        val watcher = FileSystems.getDefault().newWatchService()

        try {
            Path.of(dirPath.toUri()).register(watcher, StandardWatchEventKinds.ENTRY_MODIFY)
        } catch (e: IOException) {
            println(e)
        }

        var clock = System.currentTimeMillis()

        while (true) {
            val key = watcher.take()

            for (event in key.pollEvents()) {
                if (event.kind() != StandardWatchEventKinds.ENTRY_MODIFY) {
                    continue
                }

                if (System.currentTimeMillis() - clock >= 1000) {
                    println("File change detected - re-rendering...")
                    execute()

                    clock = System.currentTimeMillis()
                }
            }

            if (!key.reset()) {
                break
            }
        }
    }

    fun run() {
        if (watch) {
            println("Running in watch mode - file changes will trigger a re-render.")
            execute()
            watch()
        } else {
            execute()
        }
    }
}
