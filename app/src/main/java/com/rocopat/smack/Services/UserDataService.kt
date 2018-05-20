package com.rocopat.smack.Services

import android.graphics.Color
import com.rocopat.smack.Controller.App
import java.util.*

object UserDataService {

    var id = ""
    var avatarColor = ""
    var email = ""
    var avatarName = ""
    var name = ""

    fun logout(){
        id = ""
        avatarColor = ""
        email = ""
        avatarName = ""
        name = ""
        App.prefs.authToken = ""
        App.prefs.userEmail = ""
        App.prefs.isLoggedIn = false
        MessageService.clearMessages()
        MessageService.clearChannels()
    }

    fun returnAvatarColor(componets: String) : Int {
        val strippedColor = componets
                .replace("[","")
                .replace("]", "")
                .replace(",", "")

        var r = 0
        var g = 0
        var b = 0

        var scanner = Scanner(strippedColor)
        if (scanner.hasNext()){
            r = (scanner.nextDouble() * 255).toInt()
            g = (scanner.nextDouble() * 255).toInt()
            b = (scanner.nextDouble() * 255).toInt()
        }
        return Color.rgb(r,g,b)
    }
}