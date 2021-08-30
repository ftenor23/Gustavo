package Manager;

public abstract class ZoneManager {
    private static final String NORTE= "Norte";
    private static final String OESTE = "Oeste";
    private static final String SUR = "Sur";
    private static final String CAPITAL_FEDERAL = "Capital Federal";
    private static final String NOT_FOUND = "No encontrado";

    public static String getZone(int zone){
        String response;
        switch (zone){
            case 1:
                response = NORTE;
                break;
            case 2:
                response=OESTE;
                break;
            case 3:
                response=SUR;
                break;
            case 4:
                response=CAPITAL_FEDERAL;
                break;
            default:
                response = NOT_FOUND;
                break;
        }
        return response;
    }
}
