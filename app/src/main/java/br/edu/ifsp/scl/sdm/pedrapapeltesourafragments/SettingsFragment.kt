package br.edu.ifsp.scl.sdm.pedrapapeltesourafragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.edu.ifsp.scl.sdm.pedrapapeltesourafragments.databinding.FragmentSettingsBinding

class SettingsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)

        val participantes = arguments?.getInt("participantes")

        with (fragmentSettingsBinding) {
            fragmentoConfiguracoesTv.setText("Participantes: " + participantes.toString())
        }
        fragmentSettingsBinding.fecharFragmentoBt.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
        return fragmentSettingsBinding.root
    }

}