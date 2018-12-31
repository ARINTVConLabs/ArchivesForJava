package com.arintv.conlabs.WGSExchanger;

// WGS84 좌표계의 거리를 각종 거리단위로 변경
// 출처: Mapnet/Divex™, "Distance between two points / coordinates", http://www.mapanet.eu/EN/Resources/Script-Distance.htm
// 이 자료는 C#으로 구성된 코드를 Java로 재구성한 코드입니다.

public class WGStoKM {

    public static double Distance(double lat1, double lng1, double lat2, double lng2, String unit) {
        double deg2radMultiplier = Math.PI / 180;
        lat1 = lat1 * deg2radMultiplier;
        lng1 = lng1 * deg2radMultiplier;
        lat2 = lat2 * deg2radMultiplier;
        lng2 = lng2 * deg2radMultiplier;

        double radius = 6378.137;
        double dlng = lng2 - lng1;
        double distance = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(dlng)) * radius;

        if(unit.equals("Kilometer")) {
            return distance;
        } else if (unit.equals("Meter")) {
            return distance * 1000;
        } else if(unit.equals("Miles")) {
            return (distance * 0.621371192);
        } else if (unit.equals("Nautical Miles")) {
            return (distance * 0.539956803);
        } else {
            return 0.0;
        }
    }
}
