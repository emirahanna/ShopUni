package TrackingManagement.view;

import java.util.Scanner;

public class TrackingView  {
    public TrackingView() {
    }
    public String showTracking() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter your tracking number");
        String trackingNumber = scnr.nextLine();
        return trackingNumber;
    }
    public void showTrackingStatus(String status) {
        System.out.println("Your tracking status is: " + status);
    }
    public void showTrackingError() {
        System.out.println("Invalid tracking number");
    }
}
