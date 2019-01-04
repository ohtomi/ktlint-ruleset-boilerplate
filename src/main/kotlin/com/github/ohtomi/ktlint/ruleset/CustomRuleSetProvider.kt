package com.github.ohtomi.ktlint.ruleset

import com.github.shyiko.ktlint.core.RuleSet
import com.github.shyiko.ktlint.core.RuleSetProvider

class CustomRuleSetProvider : RuleSetProvider {

    override fun get(): RuleSet = RuleSet("custom",
            ValueArgumentListLineBreakRule())
}
