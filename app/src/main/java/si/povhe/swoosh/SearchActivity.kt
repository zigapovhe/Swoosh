package si.povhe.swoosh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_search.*
import si.povhe.swoosh.Model.Player

class SearchActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchTxt.text="Looking for a ${player.league} ${player.skill} league near you..."
    }
}
