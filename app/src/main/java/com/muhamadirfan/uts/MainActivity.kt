package com.adesukirno.recycleview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.adesukirno.recycleview.adapter.AdapterTeamBola
import com.adesukirno.recycleview.databinding.ActivityMainBinding
import com.adesukirno.recycleview.databinding.ListItemPemainBinding
import com.adesukirno.recycleview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ListPemain = ArrayList<Pemain>()
        ListPemain.add(Pemain("Thibaut Courtois",R.drawable.courtois,"Penjaga Gawang","2.00 m","Bree (Belgia)","11 Mei 1992"))
        ListPemain.add(Pemain("Karim Benzema",R.drawable.benzema,"Penyerang","1,85 m","Lyon (Perancis)","19 Desember 1987"))
        ListPemain.add(Pemain("Marcelo Vieira da Silva",R.drawable.marcello,"Belakang","1,74 m","Rio de Janeiro (Brasil)","12 Mei 1988"))
        ListPemain.add(Pemain("Sergio Ramos García",R.drawable.ramos,"Belakang","1,84 m","Camas (Sevilla)","30 Maret 1986"))


        binding.list.adapter = AdapterTeamBola(this,ListPemain,object :AdapterTeamBola.OnClickListener{
            override fun DetailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatlahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text ="${item?.nama}"
                    posisi.text ="${item?.posisi}"
                    tinggi.text ="${item?.tinggi}"
                    tempatlahir.text ="${item?.tempatlahir}"
                    tgllahir.text ="${item?.tgllahir}"
                   btn.setOnClickListener {
                       this.dismiss()
                   }

                }.show()
            }

        })
    }
}



