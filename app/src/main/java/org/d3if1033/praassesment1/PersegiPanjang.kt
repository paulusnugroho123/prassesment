package org.d3if1033.praassesment1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import org.d3if1033.praassesment1.databinding.FragmentPersegiPanjangBinding

class PersegiPanjang : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPersegiPanjangBinding>(inflater,R.layout.fragment_persegi_panjang,container,false)
        var panjang = binding.panjangPsg.text.toString().toDouble()
        var lebar = binding.lebarPsg.text.toString().toDouble()
        var luas = panjang * lebar
        var keliling = (panjang+lebar)*2
        if (savedInstanceState!=null){
            luas = savedInstanceState.getInt("luas",0).toDouble()
            keliling = savedInstanceState.getInt("keliling",0).toDouble()
        }
        binding.btnPsg.setOnClickListener{
            binding.hasilPsgLuas.setText(luas.toString())
        }
        binding.btnPsg.setOnClickListener {
            binding.hasilPsgKeliling.setText(keliling.toString())
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.putInt("luas",hasil_psg_luas.text.toString().toInt())
        savedInstanceState?.putInt("keliling",hasil_psg_keliling.text.toString().toInt())
    }


}
