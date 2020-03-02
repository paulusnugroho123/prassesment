package com.proyektingkat.praasessement

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.proyektingkat.praasessement.databinding.FragmentBMIBinding


/**
 * A simple [Fragment] subclass.
 */
class BMIFragment : Fragment() {
    private lateinit var binding:FragmentBMIBinding
    private var bmihasil = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_b_m_i, container, false)

        binding.btnHitung.setOnClickListener { hitung() }
        binding.btnShare.setOnClickListener { share() }
        return binding.root
    }
    private fun hitung(){
        if(binding.tvTinggiBadan.text.isEmpty()){
            Toast.makeText(activity,"Tinggi Badan Kosong",Toast.LENGTH_SHORT).show()
        }else{
            if (binding.rgGender.checkedRadioButtonId == -1){
                Toast.makeText(activity,"Harus Pilih Gender",Toast.LENGTH_SHORT).show()
            }else{
                if (binding.rbLaki.isChecked){
                    bmihasil = binding.tvTinggiBadan.text.toString().toDouble() - 100

                }else{
                    bmihasil = (binding.tvTinggiBadan.text.toString().toDouble()-100) *0.9
                }
                binding.tvHasil.text = "$bmihasil"
            }
        }
    }
    private fun share(){
        val email = Intent(Intent.ACTION_SENDTO)
        email.data= Uri.parse("mailto:")
        email.putExtra(Intent.EXTRA_SUBJECT,"Hasil Body Mas Index")
        email.putExtra(Intent.EXTRA_TEXT,"Hasil BMI : $bmihasil")
        startActivity(email)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("hasil",bmihasil)
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        if (savedInstanceState != null){
            bmihasil = savedInstanceState.getDouble("hasil")
            binding.tvHasil.text = "$bmihasil"
        }
        super.onViewStateRestored(savedInstanceState)
    }
}
