package si.povhe.swoosh

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        nextBtn.setOnClickListener {
            if(selectedLeague != ""){
                val skillIntent = Intent(this, SkillActivity::class.java)
                skillIntent.putExtra(EXTRA_LEAGUE, selectedLeague)
                startActivity(skillIntent)
            } else {
                Toast.makeText(this,"Prosim izberi kategorijo.", Toast.LENGTH_LONG).show()
            }

        }

        mensBtn.setOnClickListener {
            womensBtn.isChecked=false
            coedBtn.isChecked=false

            selectedLeague="mens"

            if(!mensBtn.isChecked){
                selectedLeague=""
            }
        }

        womensBtn.setOnClickListener {
            mensBtn.isChecked=false
            coedBtn.isChecked=false

            selectedLeague="womens"

            if(!womensBtn.isChecked){
                selectedLeague=""
            }
        }

        coedBtn.setOnClickListener {
            mensBtn.isChecked=false
            womensBtn.isChecked=false

            selectedLeague="co-ed"

            if(!coedBtn.isChecked){
                selectedLeague=""
            }
        }
    }
}
