package xyz.heydarrn.staticgithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    fun showRecyclerList(){
        mainActivityBinding.recyclerViewGithubUser.layoutManager=LinearLayoutManager(this)
        val listGithubUserAdapter=ListGithubUserAdapter(list)
        mainActivityBinding.recyclerViewGithubUser.adapter=listGithubUserAdapter
    }
}