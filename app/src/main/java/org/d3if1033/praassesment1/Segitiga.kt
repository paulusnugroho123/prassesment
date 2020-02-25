package org.d3if1033.praassesment1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_segitiga.*
import org.d3if1033.praassesment1.databinding.FragmentSegitigaBinding

class Segitiga : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     val binding = DataBindingUtil.inflate<FragmentSegitigaBinding>(inflater,R.layout.fragment_segitiga,container,false)

        val alas = binding.alasSgt.text.toString().toInt()
        val tinggi = binding.tinggiSgt.text.toString().toInt()
        var luas = (alas*tinggi)/2
        var keliling = alas*3

        if (savedInstanceState!=null){
            luas = savedInstanceState.getInt("luas",0)
            keliling= savedInstanceState.getInt("keliling",0)
        }
        binding.luasSgt.setOnClickListener {
            binding.hasilSgtLuas.setText(luas.toString().toInt())
        }
        binding.kelilingSgt.setOnClickListener {
         binding.hasilKelilingSgt.setText(keliling.toString().toInt())
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.putInt("luas",hasil_sgt_luas.text.toString().toInt())
        savedInstanceState?.putInt("keliling",hasil_keliling_sgt.text.toString().toInt())
    }


}
