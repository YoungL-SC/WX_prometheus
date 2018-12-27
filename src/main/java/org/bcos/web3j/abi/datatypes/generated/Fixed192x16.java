package org.bcos.web3j.abi.datatypes.generated;

import java.math.BigInteger;
import org.bcos.web3j.abi.datatypes.Fixed;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modifiy!</strong><br>
 * Please use {@link org.bcos.web3j.codegen.AbiTypesGenerator} to update.</p>
 */
public class Fixed192x16 extends Fixed {
    public static final Fixed192x16 DEFAULT = new Fixed192x16(BigInteger.ZERO);

    public Fixed192x16(BigInteger value) {
        super(192, 16, value);
    }

    public Fixed192x16(int mBitSize, int nBitSize, BigInteger m, BigInteger n) {
        super(192, 16, m, n);
    }
}
