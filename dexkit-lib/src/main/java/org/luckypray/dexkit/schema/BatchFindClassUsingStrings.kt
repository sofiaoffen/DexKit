// automatically generated by the FlatBuffers compiler, do not modify

package org.luckypray.dexkit.schema

import com.google.flatbuffers.BaseVector
import com.google.flatbuffers.BooleanVector
import com.google.flatbuffers.ByteVector
import com.google.flatbuffers.Constants
import com.google.flatbuffers.DoubleVector
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.FloatVector
import com.google.flatbuffers.LongVector
import com.google.flatbuffers.StringVector
import com.google.flatbuffers.Struct
import com.google.flatbuffers.Table
import com.google.flatbuffers.UnionVector
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.math.sign

@Suppress("unused")
class BatchFindClassUsingStrings : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : BatchFindClassUsingStrings {
        __init(_i, _bb)
        return this
    }
    val searchPackage : String?
        get() {
            val o = __offset(4)
            return if (o != 0) {
                __string(o + bb_pos)
            } else {
                null
            }
        }
    val searchPackageAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun searchPackageInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    fun inClasses(j: Int) : ULong {
        val o = __offset(6)
        return if (o != 0) {
            bb.getLong(__vector(o) + j * 8).toULong()
        } else {
            0uL
        }
    }
    val inClassesLength : Int
        get() {
            val o = __offset(6); return if (o != 0) __vector_len(o) else 0
        }
    val inClassesAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 8)
    fun inClassesInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 8)
    fun matchers(j: Int) : BatchUsingStringsMatcher? = matchers(BatchUsingStringsMatcher(), j)
    fun matchers(obj: BatchUsingStringsMatcher, j: Int) : BatchUsingStringsMatcher? {
        val o = __offset(8)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val matchersLength : Int
        get() {
            val o = __offset(8); return if (o != 0) __vector_len(o) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_23_5_26()
        fun getRootAsBatchFindClassUsingStrings(_bb: ByteBuffer): BatchFindClassUsingStrings = getRootAsBatchFindClassUsingStrings(_bb, BatchFindClassUsingStrings())
        fun getRootAsBatchFindClassUsingStrings(_bb: ByteBuffer, obj: BatchFindClassUsingStrings): BatchFindClassUsingStrings {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createBatchFindClassUsingStrings(builder: FlatBufferBuilder, searchPackageOffset: Int, inClassesOffset: Int, matchersOffset: Int) : Int {
            builder.startTable(3)
            addMatchers(builder, matchersOffset)
            addInClasses(builder, inClassesOffset)
            addSearchPackage(builder, searchPackageOffset)
            return endBatchFindClassUsingStrings(builder)
        }
        fun startBatchFindClassUsingStrings(builder: FlatBufferBuilder) = builder.startTable(3)
        fun addSearchPackage(builder: FlatBufferBuilder, searchPackage: Int) = builder.addOffset(0, searchPackage, 0)
        fun addInClasses(builder: FlatBufferBuilder, inClasses: Int) = builder.addOffset(1, inClasses, 0)
        @kotlin.ExperimentalUnsignedTypes
        fun createInClassesVector(builder: FlatBufferBuilder, data: ULongArray) : Int {
            builder.startVector(8, data.size, 8)
            for (i in data.size - 1 downTo 0) {
                builder.addLong(data[i].toLong())
            }
            return builder.endVector()
        }
        fun startInClassesVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(8, numElems, 8)
        fun addMatchers(builder: FlatBufferBuilder, matchers: Int) = builder.addOffset(2, matchers, 0)
        fun createMatchersVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startMatchersVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun endBatchFindClassUsingStrings(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
