package com.github.ohtomi.ktlint.ruleset

import com.github.shyiko.ktlint.core.LintError
import com.github.shyiko.ktlint.test.lint
import org.assertj.core.api.Assertions
import kotlin.test.Test

class ValueArgumentListLineBreakRuleTest {

    @Test
    fun testHasOneProblem() {
        val rule = ValueArgumentListLineBreakRule()
        val code = """
            fun fn(a: String, b: String): String = a + b
            val a = "a"
            val b = "b"
            fun example() {
                fn(a, b)
            }
        """.trimIndent()

        Assertions.assertThat(rule.lint(code)).isEqualTo(listOf(
            LintError(5, 7, "value-argument-list-line-break", "should line break")
        ))
    }
}
