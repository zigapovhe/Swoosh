package si.povhe.swoosh

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*
import si.povhe.swoosh.Model.Player

class LeagueActivity : BaseActivity() {

    var player = Player("","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        nextBtn.setOnClickListener {
            if(player.league != ""){
                val skillIntent = Intent(this, SkillActivity::class.java)
                skillIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(skillIntent)
            } else {
                Toast.makeText(this,"Prosim izberi kategorijo.", Toast.LENGTH_LONG).show()
            }

        }

        mensBtn.setOnClickListener {
            womensBtn.isChecked=false
            coedBtn.isChecked=false

            player.league="mens"

            if(!mensBtn.isChecked){
                player.league=""
            }
        }

        womensBtn.setOnClickListener {
            mensBtn.isChecked=false
            coedBtn.isChecked=false

            player.league="womens"

            if(!womensBtn.isChecked){
                player.league=""
            }
        }

        coedBtn.setOnClickListener {
            mensBtn.isChecked=false
            womensBtn.isChecked=false

            player.league="co-ed"

            if(!coedBtn.isChecked){
                player.league=""
            }
        }
    }
}
