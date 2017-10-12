package com.example.mapdemo;

/**
 * Created by skarwa on 10/11/17.
 */

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.maps.android.ui.IconGenerator;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.animation.BounceInterpolator;

/**
 * Make sure you have included the Android Maps Utility library
 * See: https://developers.google.com/maps/documentation/android-api/utility/
 * <p>
 * Gradle config:
 * <p>
 * dependencies {
 * 'com.google.maps.android:android-maps-utils:0.5+'
 * }
 * <p>
 * Example usage:
 * <p>
 * BitmapDescriptor icon = MapUtils.createBubble(MapDemoActivity.this, IconGenerator.STYLE_GREEN, title);
 * Marker marker = MapUtils.addMarker(map, point, title, snippet, icon);
 */

public class MapUtils {

    public static BitmapDescriptor createBubble(Context context, int style, String title) {
        IconGenerator iconGenerator = new IconGenerator(context);
        iconGenerator.setStyle(style);
        Bitmap bitmap = iconGenerator.makeIcon(title);
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
        return bitmapDescriptor;
    }

    public static Marker addMarker(GoogleMap map, LatLng point, String title,
                                   String snippet,
                                   BitmapDescriptor icon) {
        // Creates and adds marker to the map
        MarkerOptions options = new MarkerOptions()
                .position(point)
                .title(title)
                .snippet(snippet)
                .icon(icon);
        Marker marker = map.addMarker(options);
        marker.setDraggable(true);
        return map.addMarker(options);
    }
}