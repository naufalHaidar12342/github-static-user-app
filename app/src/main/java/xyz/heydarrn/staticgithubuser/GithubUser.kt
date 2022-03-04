package xyz.heydarrn.staticgithubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    var username :String,
    var name:String,
    var avatar:Int,
    var follower:String,
    var following:String,
    var company:String,
    var location:String,
    var repository:String,
):Parcelable
