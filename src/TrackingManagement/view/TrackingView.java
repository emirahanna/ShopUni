package TrackingManagement.view;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class TrackingView extends JFrame {
    public TrackingView() throws HeadlessException {
    }
    public String ShowTracking() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter your tracking number");
        String trackingNumber = scnr.nextLine();
        return trackingNumber;
    }
    public void ShowTrackingStatus(String status) {
        System.out.println("Your tracking status is: " + status);
    }
    public void ShowTrackingError() {
        System.out.println("Invalid tracking number");
    }
}
