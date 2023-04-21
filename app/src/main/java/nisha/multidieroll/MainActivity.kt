package nisha.multidieroll

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import nisha.multidieroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rollButton1.setOnClickListener {
            binding.diceTextview1.text=rollDice().toString()
            binding.diceTextview1.visibility = View.VISIBLE
            binding.diceTextview2.visibility = View.GONE
        }

        binding.rollButton2.setOnClickListener {
            binding.diceTextview1.text=rollDice().toString()
            binding.diceTextview2.text=rollDice().toString()
            binding.diceTextview1.visibility = View.VISIBLE
            binding.diceTextview2.visibility = View.VISIBLE
        }
    }

    private fun rollDice():Int {
        var dieSize = binding.diceSpinner.selectedItem.toString().toInt()
        val randomnum = (1..dieSize).random()
        return randomnum
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bottom_nav, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.history -> {
                val intent = Intent(this, History::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}