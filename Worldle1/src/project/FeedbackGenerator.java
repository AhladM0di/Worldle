package project;

/**
 * This class provides methods to calculate the distance and direction between two geographical points.
 * The points are represented by their latitude and longitude coordinates.
 */
public class FeedbackGenerator
{

    /**
     * @param lat1 latitude of the first point
     * @param lon1 longitude of the first point
     * @param lat2 latitude of the second point
     * @param lon2 longitude of the second point
     * @return the distance between the two points in km
     */
    public static double getDistance(double lat1, double lon1, double lat2, double lon2)
    {
        final int R = 6371; // Radius of the Earth in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }

    /**
     * @param lat1 latitude of the first point
     * @param lon1 longitude of the first point
     * @param lat2 latitude of the second point
     * @param lon2 longitude of the second point
     * @return the direction from the first point to the second point (N, S, E, W)
     */
    public static String getDirection(double lat1, double lon1, double lat2, double lon2)
    {
        String latDir = (lat2 > lat1) ? "N" : "S";
        String lonDir = (lon2 > lon1) ? "E" : "W";
        return latDir + lonDir;
    }
}
