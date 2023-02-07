// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.localization;

import java.util.HashMap;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

/** Add your docs here. */
@SuppressWarnings("unused")
public class HashTag {
    HashMap <Integer, TestAprilTag> aprilHash;

    public HashTag(){
        aprilHash = new HashMap<Integer, TestAprilTag>();

        TestAprilTag tag1 = new TestAprilTag(3, new Pose2d(new Translation2d(15.513558, 1.071626), new Rotation2d(0)));
        TestAprilTag tag2 = new TestAprilTag(2, new Pose2d(new Translation2d(15.513558, 2.748026), new Rotation2d(0)));
        TestAprilTag tag3 = new TestAprilTag(1, new Pose2d(new Translation2d(15.513558, 4.424426), new Rotation2d(0)));

        aprilHash.put(tag1.ID, tag1);
        //aprilHash.put(tag2.ID, tag2);
    }

    public TestAprilTag getCurrentTag(int i){
        if (aprilHash.containsKey(i)) {
            return aprilHash.get(i);
        }
        return null;
    }

    public Pose2d getTagIDPose(int i){
        TestAprilTag aprilTag = aprilHash.get(i);
        return aprilTag.getPose();
    }
    
    public Pose2d poseCalc(double x, double z, double rads){
        Translation2d translation = new Translation2d(x, z);
        Rotation2d rotation = new Rotation2d(rads);
        Pose2d pose = new Pose2d(translation, rotation);
        return pose;
      }
}