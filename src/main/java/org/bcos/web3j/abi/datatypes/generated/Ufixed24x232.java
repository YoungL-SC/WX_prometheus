package org.bcos.web3j.abi.datatypes.generated;

import java.math.BigInteger;
import org.bcos.web3j.abi.datatypes.Ufixed;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modifiy!</strong><br>
 * Please use {@link org.bcos.web3j.codegen.AbiTypesGenerator} to update.</p>
 */
public class Ufixed24x232 extends Ufixed {
    public static final Ufixed24x232 DEFAULT = new Ufixed24x232(BigInteger.ZERO);

    public Ufixed24x232(BigInteger value) {
        super(24, 232, value);
    }

    public Ufixed24x232(int mBitSize, int nBitSize, BigInteger m, BigInteger n) {
        super(24, 232, m, n);
    }
}
