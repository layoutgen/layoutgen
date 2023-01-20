# LayoutGen

## Build instructions

Run Gradle to build the executables:

```
./gradlew assemble
```

In the `/build/distributions` directory, archives containing the built project will be created. Unpack the desired archive, and run `layoutgen` or `layoutgen.bat` from the `/bin` directory of the unpacked archive.

Run the program using the following syntax:

```
./layoutgen -i <input_rulecode> -o <output_image> -w <width> -h <height>
```

Example Rulecode files can be found in the `/demos` directory.

## Progress status

| Module        | Status  |
|---------------|---------|
| ANTLR parser  | ✅ Done  |
| Ruletree AST  | ✅ Done  |
| Interpreter   | ✅ Done  |
| Layout Engine | ✅ Done  |
| Renderer      | ✅ Done  |

