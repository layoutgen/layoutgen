package art.scidsgn.layoutgen.interpreter

import art.scidsgn.layoutgen.ruletree.ast.IsRule

data class RuleInvocationReference(val rule: IsRule, val ruleArguments: Map<String, Any>)
