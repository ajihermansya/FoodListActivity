package com.rumahcerita.listinformation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AlertDialog
import com.rumahcerita.listinformation.classdata.ListAdapter
import com.rumahcerita.listinformation.classdata.ListData
import com.rumahcerita.listinformation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageList = intArrayOf(
            R.drawable.ayamasem,
            R.drawable.ayampedas,
            R.drawable.botoktawon,
            R.drawable.nasicawuk,
            R.drawable.nasikalak,
            R.drawable.pecelpitik,
            R.drawable.pindangkoyong,
            R.drawable.rawon,
            R.drawable.rujaksoto,
            R.drawable.segotempong

        )
        val ingredientList = intArrayOf(
            R.string.ayamasem,
            R.string.ayampedas,
            R.string.botoktawon,
            R.string.nasicawuk,
            R.string.nasikalak,
            R.string.pecelpitik,
            R.string.pindangkoyong,
            R.string.rawon,
            R.string.rujaksoto,
            R.string.segotempong,
        )
        val descList = intArrayOf(
            R.string.ayamasemDesc,
            R.string.ayampedasDesc,
            R.string.botoktawonDesc,
            R.string.nasicawukDesc,
            R.string.nasikalakDesc,
            R.string.pecelpitikDesc,
            R.string.pindangkoyongDesc,
            R.string.rawonDesc,
            R.string.rujaksotoDsc,
            R.string.segotempongDsc
        )
        val nameList = arrayOf("Ayam Asem", "Ayam Pedas", "Botok Tawon", "Nasi Cawuk", "Nasi Kalak", "Pecel Pitik", "Pindang Koyong", "Rawon", "Rujak Soto", "Sego Tempong")
        val timeList = arrayOf("2 hours", "2 hours", "45 mins", "1 hours", "45 mins", "45 mins", "3 hours", "3 hours", "2 hours", "3 hours")
        for (i in imageList.indices) {
            listData = ListData(
                nameList[i],
                timeList[i], ingredientList[i], descList[i], imageList[i]
            )
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true
        binding.listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@MainActivity, DetailedActivity::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("time", timeList[i])
            intent.putExtra("ingredients", ingredientList[i])
            intent.putExtra("desc", descList[i])
            intent.putExtra("image", imageList[i])
            startActivity(intent)
        }

        binding.about.setOnClickListener {
//            val alertDialogBuilder = AlertDialog.Builder(this)
//            alertDialogBuilder.setTitle("Tentang Aplikasi Dapur Aji")
//            alertDialogBuilder.setMessage("Kami percaya bahwa memasak adalah seni yang indah dan setiap orang dapat menjadi koki ulung di dapur mereka sendiri. Dapur Aji hadir untuk membantu Anda mengeksplorasi, menciptakan, dan menikmati hidangan lezat dalam setiap kesempatan.\n" +
//                    "\n" +
//                    "Kami berterima kasih atas dukungan Anda dan harap Anda menikmati pengalaman memasak dengan Dapur Aji. Jangan ragu untuk memberikan umpan balik dan saran Anda karena mereka sangat berarti bagi kami.\n" +
//                    "\n" +
//                    "Selamat memasak dan selamat menikmati sajian istimewa bersama Dapur Aji!")
//
//
//            alertDialogBuilder.setPositiveButton("OK") { dialog, which ->
//                dialog.dismiss()
//            }
//
//
//            val alertDialog = alertDialogBuilder.create()
//            alertDialog.show()

            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)

        }

    }




}