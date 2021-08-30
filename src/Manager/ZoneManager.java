package Manager;

import Constants.ZONE;

public abstract class ZoneManager {
    private static final String NORTE= ZONE.NORTE;
    private static final String OESTE = ZONE.OESTE;
    private static final String SUR = ZONE.SUR;
    private static final String CAPITAL_FEDERAL = ZONE.CAPITAL_FEDERAL;
    private static final String NOT_FOUND = ZONE.NOT_FOUND;

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
