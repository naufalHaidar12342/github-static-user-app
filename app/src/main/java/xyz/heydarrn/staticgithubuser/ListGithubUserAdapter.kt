package xyz.heydarrn.staticgithubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListGithubUserAdapter(private val listGithubUser: ArrayList<GithubUser>) : RecyclerView.Adapter<ListGithubUserAdapter.ListViewHolder>() {


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profilePicture:ImageView=itemView.findViewById(R.id.image_user_profile)
        var fullName:TextView=itemView.findViewById(R.id.textview_user_fullname)
        var followers:TextView=itemView.findViewById(R.id.textView_user_follower)
        var following:TextView=itemView.findViewById(R.id.textView_user_following)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.tampilan_user,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (userFullName,userFollower,userFollowing, userImage)=listGithubUser[position]
        Glide.with(holder.itemView.context)
            .load(userImage)
            .circleCrop()
            .into(holder.profilePicture)
        holder.fullName.text=userFullName
        holder.followers.text="$userFollower followers"
        holder.following.text="$userFollowing following"
    }

    override fun getItemCount(): Int = listGithubUser.size


}