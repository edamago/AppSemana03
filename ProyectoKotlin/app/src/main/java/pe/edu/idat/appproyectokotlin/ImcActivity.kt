package pe.edu.idat.appproyectokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.appproyectokotlin.databinding.ActivityImcBinding

class ImcActivity : AppCompatActivity() ,View.OnClickListener{

    private lateinit var  binding: ActivityImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)

    }

    private fun calcularValorImc(tallacm:Double, pesokg:Double):Double{
        val tallam = tallacm/100;
        val valorimc = pesokg / (tallam * tallam)
        return valorimc
    }

    private fun diagnosticoimc(valorimc:Double):String{
        if (valorimc<16.5){
            return "Bajo de peso"
        }
        else if (valorimc<18.5){
            return "Peso normal"
        }
        else if (valorimc<25.5){
            return "Sobre peso"
        }
        else {
            return "Obesidad"
        }

    }

    override fun onClick(v: View?) {
        val valorimc = calcularValorImc(binding.etPeso.text.toString().toDouble(),binding.etTalla.text.toString().toDouble())
        val diagnostico = diagnosticoimc(valorimc)
        var resultado="Su valor imc es: $valorimc y su diagnostico es: $diagnostico"

        binding.tvdiagnostico.setText(resultado)

    }

}