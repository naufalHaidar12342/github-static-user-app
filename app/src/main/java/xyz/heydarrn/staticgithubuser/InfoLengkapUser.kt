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

        //memanggil viewBinding milik ActivityInfoLengkapuser
        bindingInfoLengkap= ActivityInfoLengkapUserBinding.inflate(layoutInflater)
        setContentView(bindingInfoLengkap.root)

        //menerima kiriman data dari MainActivity
        val dataDiterima=intent.getParcelableExtra<GithubUser>(GITHUB_USER) as GithubUser
        setTampilan(dataDiterima)
    }
    /*function untuk setText dan image yang digunakan pada activity ini*/
    fun setTampilan(kiriman:GithubUser){
        Glide.with(this)
            .load(kiriman.avatar)
            .circleCrop()
            .into(bindingInfoLengkap.infoUserImage)
        bindingInfoLengkap.apply {
            infoFullname.text=kiriman.name
            infoUsername.text=resources.getString(R.string.username_text,kiriman.username)

            infoFollower.text=resources.getString(R.string.follower_text,kiriman.follower)
            infoFollowing.text=resources.getString(R.string.following_text,kiriman.following)
            infoRepository.text=resources.getString(R.string.repository_text,kiriman.repository)

            infoCompany.text=kiriman.company
            infoLocation.text=kiriman.location
        }
    }


}