/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.nist.nfiq2jna;

import com.sun.jna.Structure;

/**
 *
 * @author mccaffrey
 */
public abstract class FingerprintImageData extends Structure implements Structure.ByValue {

    long m_ImageWidth;   ///< Width of the fingerprint image (in pixels)
    long m_ImageHeight;  ///< Height of the fingerprint image (in pixels)
    short m_FingerCode;   ///< ISO finger code of the fingerprint in the image
    int m_ImageDPI;     ///< Dots per inch of the fingerprint image (default: 500 dpi)

    /**
     * This type represents the resolution of an image (in dpi)
     */
    public enum ImageResolution {
        e_ImageResolution_500dpi(500), ///< 500 dpi
        e_ImageResolution_1000dpi(1000);        ///< 1000 dpi

        private final int dpi;

        ImageResolution(int dpi) {
            this.dpi = dpi;

        }

    }

    abstract FingerprintImageData(
            long imageWidth,
            long imageHeight,
            int fingerCode,
            long imageDPI);

    /**
     * @brief Constructor of data with available pointer to data
     */
    abstract FingerprintImageData(
            int pData,
            long dataSize,
            long imageWidth,
            long imageHeight,
            int fingerCode,
            long imageDPI
    );

    /**
     * @brief Copy constructor
     */
    abstract FingerprintImageData(FingerprintImageData otherData);

    abstract FingerprintImageData toBMP(boolean topDown);

    abstract void fromBMP(FingerprintImageData bmpData);

    abstract FingerprintImageData toWSQ(float compressionRate);

    abstract void fromWSQ(FingerprintImageData  wsqData);

    abstract FingerprintImageData removeWhiteFrameAroundFingerprint();

    
}
