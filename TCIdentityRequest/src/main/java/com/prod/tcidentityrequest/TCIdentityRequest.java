package com.prod.tcidentityrequest;

import android.os.StrictMode;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

public class TCIdentityRequest {
    private static final String SOAP_ACTION = "http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula";
    private static final String METHOD_NAME = "TCKimlikNoDogrula";
    private static final String NAME_SPACE = "http://tckimlik.nvi.gov.tr/WS";
    private static final String URL = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx?WSDL";

    public static boolean isTrue(Long tc,String ad,String soyad,int dyili)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        SoapObject request = new SoapObject(NAME_SPACE,METHOD_NAME);
        request.addProperty("TCKimlikNo",tc);
        request.addProperty("Ad",ad);
        request.addProperty("Soyad",soyad);
        request.addProperty("DogumYili",dyili);
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.dotNet=true;
        soapEnvelope.setOutputSoapObject(request);
        AndroidHttpTransport aht = new AndroidHttpTransport(URL);
        try{
            aht.call(SOAP_ACTION,soapEnvelope);
            SoapPrimitive resultString = (SoapPrimitive)soapEnvelope.getResponse();
            return Boolean.parseBoolean(resultString.toString());
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
