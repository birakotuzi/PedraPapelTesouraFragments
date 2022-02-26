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
import java.lang.StringBuilder
import java.util.*

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

        view?.findViewById<Button>(R.id.pedraBt)?.setOnClickListener {
            if (participantes != null) {
                jogarPedraPapelTesoura(participantes, 0)
            }
        }
        view?.findViewById<Button>(R.id.tesouraBt)?.setOnClickListener {
            if (participantes != null) {
                jogarPedraPapelTesoura(participantes, 1)
            }
        }
        view?.findViewById<Button>(R.id.papelBt)?.setOnClickListener {
            if (participantes != null) {
                jogarPedraPapelTesoura(participantes, 2)
            }
        }


        //fragmentSettingsBinding.fecharFragmentoBt.setOnClickListener {
        //    activity?.supportFragmentManager?.popBackStack()
        //}
        return fragmentSettingsBinding.root
    }

    private fun jogarPedraPapelTesoura(participantes: Int, jogada: Int) {
        var jogadaStr = if (jogada == 0) {
            "Pedra"
        } else if (jogada == 1) {
            "Tesoura"
        } else {
            "Papel"
        }
        val random = Random(System.currentTimeMillis())
        val jogadaComputador = random.nextInt(3)
        var jogadaComputadorStr = ""
        //setando imagem da jogada do comptador
        var imagemjogadaComputadorId = -1
        when (jogadaComputador) {
            0 -> {
                jogadaComputadorStr = "Pedra"
            }
            1 -> {
                jogadaComputadorStr = "Tesoura"
            }
            2 -> {
                jogadaComputadorStr = "Papel"
            }
            else -> {
            }
        }
        val resultadoSb = StringBuilder()
        resultadoSb.append("Sua jogada: ")
        resultadoSb.append(jogadaStr)
        resultadoSb.append("\nComputador: ")
        resultadoSb.append(jogadaComputadorStr)
        if (participantes==2) {
            if (jogada == jogadaComputador) {
                resultadoSb.append("\n EMPATE!")
            } else if (jogada == 0 && jogadaComputador == 1 ||
                jogada == 1 && jogadaComputador == 2 ||
                jogada == 2 && jogadaComputador == 0
            ) {
                resultadoSb.append("\n VITÓRIA!")
            } else {
                resultadoSb.append("\n DERROTA!")
            }
            view?.findViewById<Button>(R.id.resultadoTv)?.setText(resultadoSb.toString())
        } else {
            val jogadaComputador1 = random.nextInt(3)

            //setando imagem da jogada do computador
            var jogadaComputadorStr1 = ""
            var imagemjogadaComputadorId1 = -1
            when (jogadaComputador1) {
                0 -> {
                    jogadaComputadorStr1 = "Pedra"
                }
                1 -> {
                    jogadaComputadorStr1 = "Tesoura"
                }
                2 -> {
                    jogadaComputadorStr1 = "Papel"
                }
                else -> {
                }
            }
            resultadoSb.append("\nComputador1: ")
            resultadoSb.append(jogadaComputadorStr1)
            if (jogada == jogadaComputador && jogadaComputador == jogadaComputador1) {
                resultadoSb.append("\n EMPATE!")
            } else if (jogada == 0 && jogadaComputador == 1 && jogadaComputador1 == 1 ||
                jogada == 1 && jogadaComputador == 2 && jogadaComputador1 == 2 ||
                jogada == 2 && jogadaComputador == 0 && jogadaComputador1 == 0
            ) {
                resultadoSb.append("\n VITÓRIA!")
            } else if (jogada == 0 && jogadaComputador == 0 && jogadaComputador1 == 1 ||
                jogada == 1 && jogadaComputador == 1 && jogadaComputador1 == 2 ||
                jogada == 2 && jogadaComputador == 2 && jogadaComputador1 == 0
            ) {
                resultadoSb.append("\n EMPATE!")
            } else if (jogada == 0 && jogadaComputador == 1 && jogadaComputador1 == 2 ||
                jogada == 0 && jogadaComputador == 2 && jogadaComputador1 == 1 ||
                jogada == 0 && jogadaComputador == 2 && jogadaComputador1 == 2 ||
                jogada == 1 && jogadaComputador == 0 && jogadaComputador1 == 2 ||
                jogada == 1 && jogadaComputador == 2 && jogadaComputador1 == 0 ||
                jogada == 1 && jogadaComputador == 0 && jogadaComputador1 == 0 ||
                jogada == 2 && jogadaComputador == 1 && jogadaComputador1 == 0 ||
                jogada == 2 && jogadaComputador == 1 && jogadaComputador1 == 1 ||
                jogada == 2 && jogadaComputador == 0 && jogadaComputador1 == 1
            ) {
                resultadoSb.append("\n EMPATE!")
            } else {
                resultadoSb.append("\n DERROTA!")
            }
            view?.findViewById<Button>(R.id.resultadoTv)?.setText(resultadoSb.toString())
        }
    }
}