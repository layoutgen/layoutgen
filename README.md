# LayoutGen

## Progress status

| Module        | Status            |
|---------------|-------------------|
| Tokenizer[1]  | 🅿️ Prototype     |
| Parser[1]     | 🅿️ Prototype     |
| Interpreter   | ❌ Not started yet |
| Layout Engine | 🔵 In progress    |
| Renderer      | 🅿️ Prototype     |

[1] Whether a custom tokenizer and parser will be used (instead of an out-of-the-box solution like ANTLR) is
still to be decided.

### Module progress - Tokenizer

TODO

### Module progress - Parser

TODO

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
| Grid          |    🔵    |
| Flexbox       |    ❌    |

#### Responsive layouts

| Component      | Status  |
|----------------|:-------:|
| AspectRatioBox |    ❌    |
| ResponsiveBox  |    ❌    |

### Module progress - Renderer

TODO
