package xyz.heydarrn.staticgithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class InfoLengkapUser : AppCompatActivity() {

    companion object{ const val GITHUB_USER="profil lengkap user github" }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_lengkap_user)
    }


}