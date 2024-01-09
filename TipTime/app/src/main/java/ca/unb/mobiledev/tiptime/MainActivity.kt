package ca.unb.mobiledev.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.unb.mobiledev.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //when you click calculate call the calculate tip function
        binding.calculateButton.setOnClickListener{calculateTip()}
    }

    fun calculateTip () {
        //getting the total cost, value we get is an editable so we have to convert it to string first
        //then from string we convert it to a double to perform calculations on it
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()

        //getting the tip percentage
        //getting the selected option/radio button from the radio group
        val selectedId = binding.tipOptions.checkedRadioButtonId
        //conditional statement to get the tip %
        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost

        //check if round up switch is toggled
        val roundUp = binding.roundUpSwitch.isChecked

        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        NumberFormat.getCurrencyInstance()
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}