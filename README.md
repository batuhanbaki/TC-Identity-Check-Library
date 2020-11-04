# TC Identity Check Library

```
This library uses https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx?op=TCKimlikNoDogrula source. NVI is goverment departmant, if you use custom checker follow to link.
```

# How To Use

### Add Permission to AndroidManifest

```
<uses-permission android:name="android.permission.INTERNET"/>
```

### Add Implementations

```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

```
implementation 'com.github.batuhanbaki:TC-Identity-Check-Library:0.1.0'
```

### Use basic in activity/classes

```
TCIdentityRequest.isTrue(10000000000L,"name","surname",2000)
```

### About isTrue Class
```
First field length 11, long type and equals identity number
As you can see it second field equals name and string type
As you can see it third field equals surname and string type
Fourth field equals birth year and int type
```