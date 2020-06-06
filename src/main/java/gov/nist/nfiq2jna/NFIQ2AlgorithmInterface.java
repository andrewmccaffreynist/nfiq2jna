/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.nist.nfiq2jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import java.util.List;

/**
 *
 * @author mccaffrey
 */
public interface NFIQ2AlgorithmInterface extends Library {

    NFIQ2AlgorithmInterface INSTANCE = (NFIQ2AlgorithmInterface) Native.load(System.getProperty("user.dir") + "/native/out/libtemperaturesampler.so", NFIQ2AlgorithmInterface.class);
    
    int computeQualityScore(FingerprintImageData rawImage,
            boolean bComputeActionableQuality,
            List<ActionableQualityFeedback> actionableQuality,
            boolean bOutputFeatures,
            List<QualityFeatureData> qualityFeatureData,
            boolean bOutputSpeed,
            List<QualityFeatureSpeed> qualityFeatureSpeed);

}
