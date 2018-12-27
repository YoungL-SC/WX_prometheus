package org.bcos.web3j.abi.datatypes.generated;

import java.math.BigInteger;
import org.bcos.web3j.abi.datatypes.Ufixed;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modifiy!</strong><br>
 * Please use {@link org.bcos.web3j.codegen.AbiTypesGenerator} to update.</p>
 */
public class Ufixed32x64 extends Ufixed {
    public static final Ufixed32x64 DEFAULT = new Ufixed32x64(BigInteger.ZERO);

    public Ufixed32x64(BigInteger value) {
        super(32, 64, value);
    }

    public Ufixed32x64(int mBitSize, int nBitSize, BigInteger m, BigInteger n) {
        super(32, 64, m, n);
    }
}
