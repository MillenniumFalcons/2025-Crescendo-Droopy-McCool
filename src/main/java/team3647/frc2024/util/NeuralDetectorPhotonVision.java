package team3647.frc2024.util;

import edu.wpi.first.networktables.NetworkTableInstance;
import org.photonvision.PhotonCamera;

public class NeuralDetectorPhotonVision extends PhotonCamera implements NeuralDetector {
    public NeuralDetectorPhotonVision(String camera) {
        super(NetworkTableInstance.getDefault(), camera);
    }

    public double getTX() {
        var result = VisionController.getLatestResult(this);
        if (result.hasTargets()) {
            return result.getBestTarget().getYaw();
        } else {
            return 0;
        }
    }

    public double getTY() {
        var result = VisionController.getLatestResult(this);
        if (result.hasTargets()) {
            return result.getBestTarget().getPitch();
        } else {
            return 0;
        }
    }

    public boolean hasTarget() {
        var result = VisionController.getLatestResult(this);
        return result.hasTargets();
    }
}
