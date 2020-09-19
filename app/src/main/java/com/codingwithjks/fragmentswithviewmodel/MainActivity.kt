package com.codingwithjks.fragmentswithviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingwithjks.fragmentswithviewmodel.Adapter.UserAdapter
import com.codingwithjks.fragmentswithviewmodel.Model.User
import com.codingwithjks.fragmentswithviewmodel.Repository.UserRepository
import com.codingwithjks.fragmentswithviewmodel.Repository.UserViewModelFactory
import com.codingwithjks.fragmentswithviewmodel.ViewModel.UserViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userRepository=UserRepository()
        val userViewModelFactory=UserViewModelFactory(userRepository)
        userViewModel=ViewModelProvider(this,userViewModelFactory)[UserViewModel::class.java]
        userViewModel.getData()
        userViewModel.userMutableLiveData.observe(this, Observer {
            userAdapter.setUserData(it as ArrayList<User>)
        })
        intiRecyclerView()

    }


    private fun intiRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        userAdapter= UserAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=userAdapter
        }
    }
}