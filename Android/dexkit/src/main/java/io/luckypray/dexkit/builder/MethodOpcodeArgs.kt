package io.luckypray.dexkit.builder

import io.luckypray.dexkit.util.getOpCode

/**
 * @since 1.1.0
 */
class MethodOpcodeArgs private constructor(
    val opSeq: IntArray,
    val methodDeclareClass: String,
    val methodName: String,
    val methodReturnType: String,
    val methodParamTypes: Array<String>?,
) : BaseArgs() {

    companion object {

        /**
         * @since 1.1.0
         */
        @JvmStatic
        inline fun build(block: Builder.() -> Unit): MethodOpcodeArgs {
            return Builder().apply(block).build()
        }
    }

    class Builder : BaseArgs.Builder<MethodOpcodeArgs>() {

        /**
         * **opcodes sequence**
         *
         *     e.g. intArrayOf(Opcodes.ALOAD, Opcodes.INVOKE_VIRTUAL)
         */
        var opSeq: IntArray = intArrayOf()

        /**
         * **method declare class**
         *
         * if empty, match any class
         */
        var methodDeclareClass: String = ""

        /**
         * **method name**
         *
         * if empty, match any name
         */
        var methodName: String = ""

        /**
         * **method return type**
         *
         * if empty, match any type
         */
        var methodReturnType: String = ""

        /**
         * **method param types**
         *
         * if null, match any param types
         */
        var methodParamTypes: Array<String>? = null

        /**
         * [Builder.opSeq]
         */
        fun opSeq(opSeq: IntArray) = this.also {
            this.opSeq = opSeq
        }

        /**
         * [Builder.opSeq]
         */
        fun opSeq(opSeq: List<Int>) = this.also {
            this.opSeq = opSeq.toIntArray()
        }

        /**
         * [Builder.opSeq] auto convert opFormat to opcodes
         *
         *     e.g. ["const/16", "array-length"] -> [19, 33]
         */
        fun opFormat(opFormat: Array<String>) = this.also {
            this.opSeq = opFormat.map { getOpCode(it) }.toIntArray()
        }

        /**
         * [Builder.opSeq] auto convert opFormat to opcodes
         *
         *     e.g. ["const/16", "array-length"] -> [19, 33]
         */
        fun opFormat(opFormat: List<String>) = this.also {
            this.opSeq = opFormat.map { getOpCode(it) }.toIntArray()
        }

        /**
         * [Builder.methodDeclareClass]
         */
        fun methodDeclareClass(methodDeclareClass: String) = this.also {
            this.methodDeclareClass = methodDeclareClass
        }

        /**
         * [Builder.methodName]
         */
        fun methodName(methodName: String) = this.also {
            this.methodName = methodName
        }

        /**
         * [Builder.methodReturnType]
         */
        fun methodReturnType(methodReturnType: String) = this.also {
            this.methodReturnType = methodReturnType
        }

        /**
         * [Builder.methodParamTypes]
         */
        fun methodParamTypes(methodParamTypes: Array<String>) = this.also {
            this.methodParamTypes = methodParamTypes
        }

        /**
         * build [MethodOpcodeArgs]
         *
         * @return [MethodOpcodeArgs]
         */
        override fun build(): MethodOpcodeArgs {
            verifyArgs()
            return MethodOpcodeArgs(
                opSeq,
                methodDeclareClass,
                methodName,
                methodReturnType,
                methodParamTypes,
            )
        }

        private fun verifyArgs() {
            if (opSeq.isEmpty()) {
                throw IllegalArgumentException("opSeq cannot be empty")
            }
        }
    }
}