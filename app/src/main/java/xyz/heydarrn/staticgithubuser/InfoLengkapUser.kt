package xyz.heydarrn.staticgithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import xyz.heydarrn.staticgithubuser.databinding.ActivityInfoLengkapUserBinding

class InfoLengkapUser : AppCompatActivity() {
    lateinit var bindingInfoLengkap:ActivityInfoLengkapUserBinding
    companion object{
        const val GITHUB_USER="profil lengkap user github"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_lengkap_user)

        //
        bindingInfoLengkap= ActivityInfoLengkapUserBinding.inflate(layoutInflater)
        setContentView(bindingInfoLengkap.root)

        //
        val dataDiterima=intent.getParcelableExtra<GithubUser>(GITHUB_USER) as GithubUser
        setTampilan(dataDiterima)


    }

    fun setTampilan(kiriman:GithubUser){
        Glide.with(this)
            .load(kiriman.avatar)
            .circleCrop()
            .into(bindingInfoLengkap.infoUserImage)
        bindingInfoLengkap.infoFullname.text=kiriman.name
        bindingInfoLengkap.infoUsername.text="@${kiriman.username}"

        bindingInfoLengkap.infoFollower.text="${kiriman.follower} followers"
        bindingInfoLengkap.infoFollowing.text="${kiriman.following} following"
        bindingInfoLengkap.infoRepository.text="${kiriman.repository} repository"

        bindingInfoLengkap.infoCompany.text=kiriman.company
        bindingInfoLengkap.infoLocation.text=kiriman.location
    }


}