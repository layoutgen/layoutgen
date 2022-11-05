package art.scidsgn.layoutgen.cli

fun main(args: Array<String>) {
    val cli = CLI.fromArgs(args)

    cli.run()
}