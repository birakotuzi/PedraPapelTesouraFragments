package br.edu.ifsp.scl.sdm.pedrapapeltesourafragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import br.edu.ifsp.scl.sdm.pedrapapeltesourafragments.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        //view.findViewById<Button>(R.id.fecharAppBt).setOnClickListener {
         //   activity?.finish()
        //}
        view.findViewById<TextView>(R.id.qtdeParticipantesTv).setText("Quantidade de participantes")
        view.findViewById<Button>(R.id.doisParticipantesBt).setOnClickListener {

            val bundle = Bundle()
            bundle.putInt("participantes", 2)
            val fragment = SettingsFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.principalFcv, fragment)?.commit()

        }
        view.findViewById<Button>(R.id.tresParticipantesBt).setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("participantes", 3)
            val fragment = SettingsFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.principalFcv, fragment)?.commit()

        }

        return view
    }
}