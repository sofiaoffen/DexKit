package io.luckypray.dexkit.builder

import io.luckypray.dexkit.DexKitBridge

/**
 * @since 1.1.0
 */
class BatchFindArgs private constructor(
    val queryMap: Map<String, Set<String>>,
    val advancedMatch: Boolean,
) : BaseArgs() {

    companion object {

        /**
         * @since 1.1.0
         */
        @JvmStatic
        inline fun build(block: Builder.() -> Unit): BatchFindArgs {
            return Builder().apply(block).build()
        }
    }

    /**
     * @since 1.1.0
     */
    class Builder : BaseArgs.Builder<BatchFindArgs>() {
        /**
         * query map, key is unique key, value is class/method using strings
         */
        var queryMap = mutableMapOf<String, Set<String>>()

        /**
         * enable advanced match.
         *
         * If true, '^' and '$' can be used to restrict matches, like regex:
         *
         *     "^abc$" match "abc"，not match "abcd", but "^abc" match "abcd"
         */
        var advancedMatch: Boolean = true

        /**
         * [Builder.queryMap]
         */
        fun setQueryMap(queryMap: Map<String, Iterable<String>>) = this.also {
            this.queryMap.clear()
            this.queryMap.putAll(queryMap.mapValues { it.value.toSet() })
        }

        /**
         * add query to [Builder.queryMap]
         *
         * @param [key] class name or unique key
         * @param [usingStrings] class/method using strings
         */
        fun addQuery(key: String, usingStrings: Iterable<String>) = this.also {
            this.queryMap[key] = usingStrings.toSet()
        }

        /**
         * add query to [Builder.queryMap]
         *
         * @param [key] class name or unique key
         * @param [usingStrings] class/method using strings
         */
        fun addQuery(key: String, usingStrings: Array<String>) = this.also {
            this.queryMap[key] = usingStrings.toSet()
        }

        /**
         * [Builder.advancedMatch]
         */
        fun setAdvancedMatch(advancedMatch: Boolean) = this.also {
            this.advancedMatch = advancedMatch
        }

        /**
         * build [BatchFindArgs]
         *
         * @return [BatchFindArgs]
         */
        override fun build(): BatchFindArgs = BatchFindArgs(queryMap, advancedMatch)
    }
}