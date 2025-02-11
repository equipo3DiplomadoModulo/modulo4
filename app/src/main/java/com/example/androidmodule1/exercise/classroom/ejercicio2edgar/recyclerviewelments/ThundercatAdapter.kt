package com.example.androidmodule1.exercise.classroom.ejercicio2edgar.recyclerviewelments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmodule1.R

class ThundercatAdapter(val list: List<ThundercatEntity>) : RecyclerView.Adapter<ThundercatAdapter.ThunederViewHolder>() {


        class ThunederViewHolder(view: View): RecyclerView.ViewHolder(view){
            val tvName = view.findViewById<TextView>(R.id.tvName)
            val tvPower =view.findViewById<TextView>(R.id.tvPower)

            fun render(thundercatEntity: ThundercatEntity){
                tvName.text = thundercatEntity.name
                tvPower.text = thundercatEntity.power
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThunederViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_thundercat_adapter, parent, false)
            return ThunederViewHolder(view)
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: ThunederViewHolder, position: Int) {
            holder.render(list[position])

        }

}