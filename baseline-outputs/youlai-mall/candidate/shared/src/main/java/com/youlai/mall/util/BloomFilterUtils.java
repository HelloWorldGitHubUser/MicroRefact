package com.youlai.mall.util;
 import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;
import com.google.common.base.Preconditions.checkArgument;
public class BloomFilterUtils {

 private  int numHashFunctions;

 private  int bitSize;

 private  Funnel<T> funnel;

public BloomFilterUtils(Funnel<T> funnel, int expectedInsertions, double fpp) {
    checkArgument(funnel != null, "funnel不能为空");
    checkArgument(expectedInsertions >= 0, "Expected insertions (%s) must be >= 0", expectedInsertions);
    checkArgument(fpp > 0.0, "False positive probability (%s) must be > 0.0", fpp);
    checkArgument(fpp < 1.0, "False positive probability (%s) must be < 1.0", fpp);
    this.funnel = funnel;
    // 计算bit数组长度
    bitSize = optimalNumOfBits(expectedInsertions, fpp);
    // 计算hash方法执行次数
    numHashFunctions = optimalNumOfHashFunctions(expectedInsertions, bitSize);
}
public int[] murmurHash(T value){
    int[] offset = new int[numHashFunctions];
    long hash64 = Hashing.murmur3_128().hashObject(value, funnel).asLong();
    int hash1 = (int) hash64;
    int hash2 = (int) (hash64 >>> 32);
    for (int i = 1; i <= numHashFunctions; i++) {
        int combinedHash = hash1 + i * hash2;
        if (combinedHash < 0) {
            combinedHash = ~combinedHash;
        }
        offset[i - 1] = combinedHash % bitSize;
    }
    return offset;
}


public int optimalNumOfBits(long n,double p){
    if (p == 0) {
        // 设定最小期望长度
        p = Double.MIN_VALUE;
    }
    return (int) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
}


public int optimalNumOfHashFunctions(long n,long m){
    return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
}


}