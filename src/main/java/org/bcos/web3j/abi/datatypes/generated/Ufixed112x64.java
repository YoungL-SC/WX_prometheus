package org.bcos.web3j.abi.datatypes.generated;

import java.math.BigInteger;
import org.bcos.web3j.abi.datatypes.Ufixed;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modifiy!</strong><br>
 * Please use {@link org.bcos.web3j.codegen.AbiTypesGenerator} to update.</p>
 */
public class Ufixed112x64 extends Ufixed {
    public static final Ufixed112x64 DEFAULT = new Ufixed112x64(BigInteger.ZERO);

    public Ufixed112x64(BigInteger value) {
        super(112, 64, value);
    }

    public Ufixed112x64(int mBitSize, int nBitSize, BigInteger m, BigInteger n) {
        super(112, 64, m, n);
    }
}
