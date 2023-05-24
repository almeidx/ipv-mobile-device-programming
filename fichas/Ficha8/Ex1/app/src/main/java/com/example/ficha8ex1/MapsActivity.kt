package com.example.ficha8ex1

import android.location.Geocoder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ficha8ex1.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.Locale

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val lat = intent.getDoubleExtra("latitude", 40.6575)
        val lng = intent.getDoubleExtra("longitude", -7.91428)

        val geocoder = Geocoder(this, Locale.getDefault())
        val addresses = geocoder.getFromLocation(lat, lng, 1)
        val obj = addresses!![0]
        val addr = obj.getAddressLine(0)

        // Add a marker in Sydney and move the camera
        val viseu = LatLng(lat, lng)
        mMap.addMarker(MarkerOptions().position(viseu).title(addr))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(viseu))
    }
}
