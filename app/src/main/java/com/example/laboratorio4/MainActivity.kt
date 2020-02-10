package com.example.laboratorio4

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.laboratorio4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var myLocation: MyLocation
        binding.star.bringToFront()
        myLocation = MyLocation(name = "", phrase = "", description ="")
        binding.star.setOnClickListener{
            changeText(it)
        }
        binding.Antigua.setOnClickListener {
            myLocation = MyLocation(name = "Atitlan", phrase = "Era buenos tiempos", description ="Antigua es una pequeña ciudad rodeada por volcanes en el sur de Guatemala. Es famosa por sus edificios coloniales españoles, muchos de ellos restaurados después del terremoto de 1773 que terminó con el régimen de 200 años de Antigua como la capital colonial de Guatemala. Algunos ejemplos destacados de la arquitectura incluyen La Merced, una baja iglesia amarilla y blanca de estilo barroco. Es una parte integral de la famosa Semana Santa en la ciudad, con desfiles y rituales.")
            val intent:Intent = Intent(this, LocationActivity::class.java)
            intent.putExtra("LOCATION", myLocation.name)
            intent.putExtra("PHRASE", myLocation.phrase)
            intent.putExtra("DESCRIPTION", myLocation.description)
            startActivityForResult(intent, 1)

        }

        binding.Atitlan.setOnClickListener {
            val intent:Intent = Intent(this, LocationActivity::class.java)
            myLocation = MyLocation(name = "Izabal", phrase = "Tierra caliente", description ="El lago de Atitlán es un cuerpo de agua ubicado en un enorme cráter volcánico en la zona montañosa del suroeste de Guatemala. Está rodeado de colinas verdes empinadas y es conocido por las aldeas mayas y los volcanes con impresionantes conos agudos. La ajetreada localidad de Panajachel, donde se venden tejidos tradicionales, es una vía de acceso popular al lago. En una antigua plantación de café, se encuentra la Reserva Natural Atitlán, que tiene senderos y un jardín de mariposas.")
            intent.putExtra("LOCATION", myLocation.name)
            intent.putExtra("PHRASE", myLocation.phrase)
            intent.putExtra("DESCRIPTION", myLocation.description)
            startActivityForResult(intent, 1)

        }

        binding.Tikal.setOnClickListener {
            myLocation = MyLocation(name = "Izabal", phrase = "Pulmon de guatemala", description ="Tikal es una antigua ciudadela maya en los bosques tropicales del norte de Guatemala. Se cree que data del siglo I d. C. Tikal floreció entre los años 200 y 850 d. C. y luego fue abandonada. Sus ruinas icónicas de templos y palacios incluyen la gigante pirámide ceremonial Mundo Perdido y el Templo del Gran Jaguar. A 70 metros, el Templo IV es la estructura precolombina más alta de América y tiene vista panorámica.")
            val intent:Intent = Intent(this, LocationActivity::class.java)
            intent.putExtra("LOCATION", myLocation.name)
            intent.putExtra("PHRASE", myLocation.phrase)
            intent.putExtra("DESCRIPTION", myLocation.description)
            startActivityForResult(intent, 1)

        }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data != null){
            if(resultCode == Activity.RESULT_OK){
                val message: String = data.getStringExtra("TOAST_MESSAGE")
                Toast.makeText(this, "El comentario es: $message",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun changeText(view: View){
        binding.apply {
            if (binding.hiddenText.visibility != View.VISIBLE) {
                binding.hiddenText.text = binding.nameEditText.text
                binding.nameEditText.visibility = View.GONE
                binding.nameText.visibility = View.GONE
                binding.hiddenText.visibility = View.VISIBLE
            }
            else
            {
                binding.hiddenText.text = ""
                binding.nameEditText.visibility = View.VISIBLE
                binding.nameText.visibility = View.VISIBLE
                binding.hiddenText.visibility = View.GONE
            }
        }
        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}