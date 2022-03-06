package com.begumyolcu.spacexlaunchapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.begumyolcu.spacexlaunchapp.LaunchesPastListQuery
import com.begumyolcu.spacexlaunchapp.R
import com.begumyolcu.spacexlaunchapp.databinding.HomeGridItemBinding
import com.bumptech.glide.Glide

class LaunchAdapter(private val launches: List<LaunchesPastListQuery.LaunchesPast>, var fragment: HomeListFragment)
    :  RecyclerView.Adapter<LaunchAdapter.CardHolder>(){

    class CardHolder(homeGridItemBinding: HomeGridItemBinding) :
        RecyclerView.ViewHolder(homeGridItemBinding.root) {
        var binding: HomeGridItemBinding

        init {
            this.binding = homeGridItemBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HomeGridItemBinding.inflate(layoutInflater, parent, false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val launch = launches[position]

        holder.binding.apply {
            textViewHomeCardMission.text = launch.mission_name
            textViewHomeCardLaunchDate.text = launch.launch_date_local.toString()

            if (launch.ships?.size != null && launch.ships?.size >= 1) {
                val imgUrl = launch.ships?.get(0)?.image

                when(imgUrl) {
                    null -> imageViewHomeCardShipPhoto.setImageResource(R.drawable.ic_error)
                    else ->  Glide.with(fragment).load(imgUrl).into(imageViewHomeCardShipPhoto)
                }
            }
            else {
                imageViewHomeCardShipPhoto.setImageResource(R.drawable.ic_error)
            }

        }
    }

    override fun getItemCount() = launches.size

}

