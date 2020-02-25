package org.d3if1033.praassesment1


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if1033.praassesment1.databinding.FragmentHalamanUtamaBinding

class HalamanUtama : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding = DataBindingUtil.inflate<FragmentHalamanUtamaBinding>(inflater,R.layout.fragment_halaman_utama,container,false)
       binding.btnPersegi.setOnClickListener {
           it.findNavController().navigate(R.id.action_halamanUtama7_to_persegiPanjang)
       }
        binding.btnSegitiga.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_halamanUtama7_to_segitiga)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
