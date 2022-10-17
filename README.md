# LayoutGen

## Progress status

| Module        | Status            |
|---------------|-------------------|
| ANTLR parser  | 🔵 In progress    |
| Ruletree AST  | ❌ Not started yet |
| Interpreter   | ❌ Not started yet |
| Layout Engine | 🔵 In progress    |
| Renderer      | 🅿️ Prototype     |

### Module progress - ANTLR parser

Lexer and parser automatically generated by [ANTLR](https://www.antlr.org) from
the [Rulecode grammar](https://github.com/layoutgen/layoutgen/blob/main/src/main/antlr/art/scidsgn/layoutgen/rulecode/Rulecode.g4)
.

### Module progress - Ruletree AST

The interpreter won't be running off of the raw ANTLR parsing tree, instead using a further processed AST produced by
this module.

### Module progress - Interpreter

TODO

### Module progress - Layout Engine

#### Basic components

| Component   | Status |
|-------------|:------:|
| Box         |   ✅    |
| OffsetBox   |   ✅    |
| MarginBox   |   ❌    |
| AbsoluteBox |   ❌    |

#### 1D layouts

| Component     | Status  |
|---------------|:-------:|
| HTiling       |    ✅    |
| VTiling       |    ✅    |
| HStack        |    ✅    |
| VStack        |    ✅    |
| OverlapHStack |    ✅    |
| OverlapVStack |    ✅    |

#### 2D layouts

| Component     | Status  |
|---------------|:-------:|
| Grid          |    ✅    |
| Flexbox       |    🔵    |

#### Responsive layouts

| Component      | Status  |
|----------------|:-------:|
| AspectRatioBox |    ❌    |
| ResponsiveBox  |    ❌    |

### Module progress - Renderer

TODO