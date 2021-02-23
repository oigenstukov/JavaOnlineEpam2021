import Planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;
import org.junit.Assert;
import org.junit.Test;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );



    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        Assert.assertEquals(MilitaryType.TRANSPORT,
                airport.getMilitaryPlaneByType(MilitaryType.TRANSPORT).get(0).getType());
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980,
                16100, 70500, 242);
        Assert.assertEquals(airport.getPassengerPlaneWithMaxPassengersCapacity(), planeWithMaxPassengerCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        List<PassengerPlane> sortedPlanes = Arrays.asList(
                new PassengerPlane("",0, 0, 10, 0),
                new PassengerPlane("", 0, 0, 20, 0),
                new PassengerPlane("", 0, 0, 30, 0)
        );

        List<PassengerPlane> unsortedPlanes = Arrays.asList(
                new PassengerPlane("",0, 0, 10, 0),
                new PassengerPlane("", 0, 0, 30, 0),
                new PassengerPlane("", 0, 0, 20, 0)
        );

        Airport sortedAirport = new Airport(sortedPlanes);
        Airport unsortedAirport = new Airport(unsortedPlanes);
        unsortedAirport.sortByMaxLoadCapacity();

        Assert.assertEquals(sortedAirport, unsortedAirport);
    }

    @Test
    public void testGetBomberMilitaryPlanes() {
        Airport airport = new Airport(planes);
        Assert.assertEquals(MilitaryType.BOMBER,
                airport.getMilitaryPlaneByType(MilitaryType.BOMBER).get(0).getType());
    }

    @Test
    public void testExperimentalPlanesClassificationLevel(){
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();

        Assert.assertFalse(experimentalPlanes.stream()
                .anyMatch(plane -> plane.getClassificationLevel().equals(ClassificationLevel.UNCLASSIFIED)));
    }
}
