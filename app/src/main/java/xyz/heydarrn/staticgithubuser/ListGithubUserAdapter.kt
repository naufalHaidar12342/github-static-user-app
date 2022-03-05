package xyz.heydarrn.staticgithubuser

import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.resource.SimpleResource

class ListGithubUserAdapter(private val listGithubUser: ArrayList<GithubUser>) : RecyclerView.Adapter<ListGithubUserAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //komponen di dalam layout tampilan_user (default layout yang dipakai)
        var profilePicture:ImageView=itemView.findViewById(R.id.image_user_profile)
        var fullName:TextView=itemView.findViewById(R.id.textview_user_fullname)
        var followers:TextView=itemView.findViewById(R.id.textView_user_follower)
        var following:TextView=itemView.findViewById(R.id.textView_user_following)

        //komponen yang ada di dalam layout tampilan_user_mini (ketika orientasi landscape)
//        var miniProfilePicture:ImageView=itemView.findViewById(R.id.image_mini)
//        var fullNameMini:TextView=itemView.findViewById(R.id.fullname_mini)
//        var followerMini:TextView=itemView.findViewById(R.id.follower_mini)
//        var followingMini:TextView=itemView.findViewById(R.id.following_mini)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var view:View
//        view = if (parent.context.resources.configuration.orientation==Configuration.ORIENTATION_LANDSCAPE){
//            LayoutInflater.from(parent.context).inflate(R.layout.tampilan_user_mini,parent,false)
//        }else{
//            LayoutInflater.from(parent.context).inflate(R.layout.tampilan_user,parent,false)
//        }
        view=LayoutInflater.from(parent.context).inflate(R.layout.tampilan_user,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        /*menggunakan satu variabel saja, baru memanggil anggota dari
        arrayList, dimana arrayList tersebut berisi atribut dari class GithubUser*/
        val githubUser=listGithubUser[position]
        Glide.with(holder.itemView.context)
            .load(githubUser.avatar)
            .circleCrop()
            .into(holder.profilePicture)

        //set text menggunakan text property milik class TextView
        holder.fullName.text=githubUser.name
        holder.followers.text="${githubUser.follower} followers"
        holder.following.text="${githubUser.following} following"

        //untuk layout mini
//        Glide.with(holder.itemView.context)
//            .load(githubUser.avatar)
//            .circleCrop()
//            .into(holder.miniProfilePicture)
//        holder.fullNameMini.text=githubUser.name
//        holder.followerMini.text="${githubUser.follower} followers"
//        holder.followingMini.text="${githubUser.following} following"

    }

    override fun getItemCount(): Int = listGithubUser.size




}