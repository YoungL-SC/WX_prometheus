package org.bcos.web3j.abi.datatypes.generated;

import java.math.BigInteger;
import org.bcos.web3j.abi.datatypes.Ufixed;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modifiy!</strong><br>
 * Please use {@link org.bcos.web3j.codegen.AbiTypesGenerator} to update.</p>
 */
public class Ufixed48x80 extends Ufixed {
    public static final Ufixed48x80 DEFAULT = new Ufixed48x80(BigInteger.ZERO);

    public Ufixed48x80(BigInteger value) {
        super(48, 80, value);
    }

    public Ufixed48x80(int mBitSize, int nBitSize, BigInteger m, BigInteger n) {
        super(48, 80, m, n);
    }
}
