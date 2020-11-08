package ru.mail.polis.service.ivanovandrey;

import one.nio.util.Hash;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Util {
    private Util() {

    }

    /** Convert from ByteBuffer to Byte massive.
     *
     * @param buffer - ByteBuffer to convert
     */
    public static byte[] fromByteBufferToByteArray(@NotNull final ByteBuffer buffer) {
        final ByteBuffer bufferCopy = buffer.duplicate();
        final byte[] array = new byte[bufferCopy.remaining()];
        bufferCopy.get(array);
        return array;
    }

    /**
     * Extract array from a ByteBuffer and shift all bytes by min value.
     *
     * @param buffer - ByteBuffer to extract from
     */
    public static byte[] toArrayShifted(@NotNull final ByteBuffer buffer) {
        var res = fromByteBufferToByteArray(buffer);
        for (int i = 0; i < res.length; i++) {
            res[i] = (byte)(Byte.toUnsignedInt(res[i]) - Byte.MIN_VALUE);
        }
        return res;
    }

    /**
     * Wrap byte array into ByteBuffer.
     *
     * @param arr - byte array
     */
    public static ByteBuffer fromArrayShifted(@NotNull final byte[] arr) {
        final byte[] cpy = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < cpy.length; i++) {
            cpy[i] = (byte) (Byte.toUnsignedInt(cpy[i]) + Byte.MIN_VALUE);
        }
        return ByteBuffer.wrap(cpy);
    }

    /**
     * Returns nodes that stores data for a given key by rendezvous hashing algorithm.
     *
     * @param nodes - list of existing nodes
     * @param key - data id
     * @param replicasNumber - number of nodes to store data
     */
    public static Set<String> getNodes(final Set<String> nodes,
                                       final String key,
                                       final int replicasNumber) {
        final Map<Integer,String> hash = new HashMap<>();
        final Set<String> resultNodes = new HashSet<>();
        for (final String node : nodes) {
            hash.put(Hash.murmur3(node + key), node);
        }
        final Object[] keys = hash.keySet().toArray();
        Arrays.sort(keys);
        for (int i = keys.length - replicasNumber; i < keys.length; i++) {
            resultNodes.add(hash.get(keys[i]));
        }
        return resultNodes;
    }
}

