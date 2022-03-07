package xyz.heydarrn.staticgithubuser

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.heydarrn.staticgithubuser.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityBinding:ActivityMainBinding
    val list=ArrayList<GithubUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivityBinding.root)

        mainActivityBinding.recyclerViewGithubUser.setHasFixedSize(true)
        list.addAll(listUsers)
        showRecyclerList()
    }

    val listUsers:ArrayList<GithubUser>
    get() {

        val namaLengkap=resources.getStringArray(R.array.name)
        val follower=resources.getStringArray(R.array.followers)
        val followings=resources.getStringArray(R.array.following)
        val fotoUser=resources.obtainTypedArray(R.array.avatar)

        val namaPengguna=resources.getStringArray(R.array.username)
        val perusahaan=resources.getStringArray(R.array.company)
        val alamat=resources.getStringArray(R.array.location)
        val repo=resources.getStringArray(R.array.repository)

        val listPerUser=ArrayList<GithubUser>()

        for (i in namaLengkap.indices){
            val user=GithubUser(
                name = namaLengkap[i],
                follower = follower[i],
                following = followings[i],
                avatar = fotoUser.getResourceId(i,-1),
                username = namaPengguna[i],
                company = perusahaan[i],
                location = alamat[i],
                repository = repo[i]
            )
            listPerUser.add(user)
        }
        return listPerUser


        //
    }

    /*user-defined function. fungsi ini akan menampilkan recyclerview
    ke dalam mainActivity. Selain itu, juga memanggil user-defined listener
    untuk membuka activity kedua ketika salah satu item di klik*/
    fun showRecyclerList(){
        //jika handphone dalam posisi landscape/tiduran, layout akan menjadi grid
        if (applicationContext.resources.configuration.orientation==Configuration.ORIENTATION_LANDSCAPE){
            mainActivityBinding.recyclerViewGithubUser.layoutManager=GridLayoutManager(this,2)
        }else{
            mainActivityBinding.recyclerViewGithubUser.layoutManager=LinearLayoutManager(this)

        }

        //memanggil adapter bernama ListGithubUserAdapter
        val listGithubUserAdapter=ListGithubUserAdapter(list)
        mainActivityBinding.recyclerViewGithubUser.adapter=listGithubUserAdapter

        val daftarPenggunaGithub=ListGithubUserAdapter(list)
        mainActivityBinding.recyclerViewGithubUser.adapter=daftarPenggunaGithub
        daftarPenggunaGithub.setOnItemDiklik(object : ListGithubUserAdapter.OnClickCallback {
            override fun onItemClicked(dataDikirim: GithubUser) {
                kirimDataPenggunaGithub(dataDikirim)
            }


        })
    }

    /*user defined function, dimana fungsi ini akan mengirimkan data ke
    InfoLengkapUser Activity menggunakan Parcelable*/

    fun kirimDataPenggunaGithub(dataDikirim:GithubUser){
        val kirimKeInfoLengkap=GithubUser(
            dataDikirim.username,
            dataDikirim.name,
            dataDikirim.avatar,
            dataDikirim.follower,
            dataDikirim.following,
            dataDikirim.company,
            dataDikirim.location,
            dataDikirim.repository
        )

        val kirimDenganIntent=Intent(this@MainActivity,InfoLengkapUser::class.java)
        kirimDenganIntent.putExtra(InfoLengkapUser.GITHUB_USER,kirimKeInfoLengkap)
        startActivity(kirimDenganIntent)



    }
}