package com.codingwithjks.fragmentswithviewmodel.Repository

import com.codingwithjks.fragmentswithviewmodel.Model.User

class UserRepository {
    fun getUserData():List<User>
    {
        val userList=ArrayList<User>()
        userList.add(User("jayant"))
        userList.add(User("aman"))
        userList.add(User("priya"))
        userList.add(User("nitin"))
        userList.add(User("naman"))
        userList.add(User("tina"))
        userList.add(User("ketan"))
        userList.add(User("ashu"))
        userList.add(User("nayan"))
        return userList
    }
}