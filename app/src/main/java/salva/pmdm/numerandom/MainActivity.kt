package salva.pmdm.numerandom

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valLblNumero = findViewById<TextView>(R.id.lblNumero)
        val valBtnGenera = findViewById<Button>(R.id.btnGenera)
        val valSeekBar = findViewById<SeekBar>(R.id.seekBar)
        val valNumTope = findViewById<TextView>(R.id.lblNumTope)
        val toast = Toast.makeText(this@MainActivity,
            getString(R.string.sorteando), Toast.LENGTH_LONG
        )
        toast.setGravity(Gravity.CENTER or Gravity.CENTER_HORIZONTAL, 0, 40)
        valNumTope.text = getString(R.string.numero_tope) + " 0"

        valSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
                valNumTope.text = getString(R.string.numero_tope) + " " + valSeekBar.progress
            }
        })

        valBtnGenera.setOnClickListener {
            valLblNumero.text = ""
            toast.show()

            val hilo = Thread {
                Thread.sleep(4000)
                val random = (1..valSeekBar.progress).random()
                valLblNumero.text = random.toString()
            }
            hilo.start()
        }
    }
}
