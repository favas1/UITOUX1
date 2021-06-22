package com.project.uitoux;

import com.project.uitoux.interfaces.MainActivityInterface;

public class Constants {
    public final static String Database_Name="UITOUXDB";


    private  static MainActivityInterface mainActivityInterface=null;

    public static MainActivityInterface getMainActivityInterface() {
        return mainActivityInterface;
    }

    public static void setMainActivityInterface(MainActivityInterface mainActivityInterface) {
        Constants.mainActivityInterface = mainActivityInterface;
    }
}
