package com.github.ohtomi.ktlint.ruleset

import com.github.shyiko.ktlint.core.Rule
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.psiUtil.children

class ValueArgumentListLineBreakRule : Rule("value-argument-list-line-break") {

    private val errorMessage = "should line break"

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == KtNodeTypes.VALUE_ARGUMENT_LIST) {
            val isError = node.children().any { child ->
                child.elementType == KtTokens.COMMA &&
                    child.treeNext.elementType == KtTokens.WHITE_SPACE &&
                    !child.treeNext.text.contains("\n")
            }
            if (isError) {
                emit(node.startOffset,
                    errorMessage,
                    false)
            }
        }
    }
}
